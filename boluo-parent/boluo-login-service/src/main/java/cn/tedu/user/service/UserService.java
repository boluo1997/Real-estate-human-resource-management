package cn.tedu.user.service;

import cn.tedu.user.mapper.UserMapper;
import com.jt.common.pojo.Salesman;
import com.jt.common.pojo.User;
import com.jt.common.utils.MD5Util;
import com.jt.common.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper um;

    public boolean salesmanNameExists(String salesmanName) {
        int exist=um.selectUserCountBysalesmanName(salesmanName);
        return exist==1;
    }

    public void addUser(Salesman salesman) {
        //userId password加密，user_type 0/1
        salesman.setSalesmanId(UUID.randomUUID().toString());
        String md5Pass= MD5Util.md5(salesman.getSalesmanPassword());
        salesman.setSalesmanPassword(md5Pass);
        salesman.setSalesmanCreateTime(new Date());
        um.insertUser(salesman);

    }
@Autowired
    private JedisCluster jedis;
    public String doLogin(Salesman salesman) {
          /*
            1.判断是否合法 密码加密,使用user对象拼接sql
            select * from t_user where user_name=#{userName} and
            user_password=#{userPassword}
            2.通过返回值判断合法,有值说明合法,null登录失败
            3.登录合法
                3.1 创建userJson ObjectMapper转化json
                3.2 生成key值,使用jedis对象存储6379
            4.ticket返回
         */
        //通过加密的密码执行sql判断合法
        try{
            salesman.setSalesmanPassword(MD5Util.md5(salesman.getSalesmanPassword()));
            //持久化方法查询存在
            Salesman exist=um.selectUserBysalesNameAndPassword(salesman);

            System.out.println("存不存在" + exist);
            if(exist==null){
                //登录失败
                return "";
            }else{
                //判断是否已经存在一个登陆的ticket
                String userLoginKey = "user_login_" + salesman.getSalesmanName();
                //登录成功 封装key value 存储redis
                String ticket="EM_TICKET_"+System.currentTimeMillis()+salesman.getSalesmanName();
                if (jedis.exists(userLoginKey)) {
                    //有人登陆，实现顶替逻辑
                    //d登陆过的ticket获取，删除
                    jedis.del(jedis.get(userLoginKey));
                }
                //存储两个key-value
                jedis.setex(userLoginKey,60*60*2,ticket);
                String userJson= MapperUtil.MP.writeValueAsString(exist);
                //超时2小时
                jedis.setex(ticket,60*60*2,userJson);

                System.out.println("service执行完毕");
                return ticket;

            }
        }catch(Exception e){
            System.out.println("异常");
            e.printStackTrace();
            return "";
        }
    }

    public String queryUserJson(String ticket) {
        String userName = ticket.substring(24);
        try {
            //毫秒数long 判断ticket剩余数间
            Long leftTime = jedis.pttl(ticket);
            if (leftTime < 1000 * 60 * 20) {
                //说明剩余时间达到即将超时
                //将时间延时30分钟
                jedis.pexpire("user_login_" + userName, leftTime + 1000 * 60 * 30);
                jedis.pexpire(ticket, leftTime + 1000 * 60 * 30);
            }
            return jedis.get(ticket);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
    }



