package cn.tedu.user.controller;

import cn.tedu.user.service.UserService;
import com.jt.common.pojo.Salesman;
import com.jt.common.pojo.User;
import com.jt.common.utils.CookieUtils;
import com.jt.common.vo.SysResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// nigix中 / 对应 www.boluo.com   登录注册
//         /users 对应 http://127.0.0.1:8103/zuul-user/user/check;

//请求地址 http://www.boluo.com/users/checkUser?userId=1614
//后台接收 /user/check/checkUser?userId=1614

@RestController
@RequestMapping("login")
public class UserController {

    //注入service层属性
    @Autowired
    private UserService us;

    //查看自己信息 √
    //...  return us.queryUser(userId);
    @RequestMapping("check/checkUserName")
    public SysResult checkUserName(String salesmanName){
        if(us.salesmanNameExists(salesmanName)){
            //存在
            return SysResult.build(201,"存在了",null);
        }else{
            return SysResult.ok();
        }
    }
    //用户注册表单提交  √
    @RequestMapping("save")
    public SysResult addUser(Salesman salesman){
        //判断新增成功失败
        try{
            us.addUser(salesman);
            return  SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return  SysResult.build(201,"新增失败",null);
        }
    }

    //select * from user where userId={userId}
    @RequestMapping("login")
   public SysResult doLogin(Salesman salesman,HttpServletRequest req, HttpServletResponse res){

        //从业务层获取redis的key值 ticket
        String ticket=us.doLogin(salesman);
        //判断非空 !=null !"".equals()

        if(StringUtils.isNotEmpty(ticket)){
            //非空,登录成功 -22222
            //ticket加入到cookie中返回给浏览器
            CookieUtils.setCookie(req,res,"EM_TICKET",ticket);
            return SysResult.ok();
        }
        //登录失败
        return SysResult.build(201,"传入错误，弟弟",null);
    }
    @RequestMapping("query/{ticket}")
    public SysResult queryUserJson(@PathVariable String ticket){
        String userJson=us.queryUserJson(ticket);
        if(userJson==null){
            //已经超时
            return SysResult.build(202,"都超时了",null);
        }
        return SysResult.build(200,"成功获取",userJson);
    }

}





































