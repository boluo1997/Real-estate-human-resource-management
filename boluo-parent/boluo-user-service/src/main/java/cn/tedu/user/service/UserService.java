package cn.tedu.user.service;

import cn.tedu.user.mapper.UserMapper;
import com.jt.common.pojo.MyOrder;
import com.jt.common.pojo.Salesman;
import com.jt.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper um;

    //查看个人信息
    public Salesman querySalesman(Integer salesmanId) {

        Salesman sm = um.selectSalesmanById(salesmanId);
        return sm;
        //TODO 缓存
    }

    //修改信息
    public SysResult alterInfo(Salesman salesman) {
        return um.alterInfo(salesman);
    }

    //新增订单
    public void addOrder(MyOrder myOrder) {     //此处是Order 不是Product
        //没有订单ID UUID实现
        System.out.println("service1");
        String orderId = UUID.randomUUID().toString();
        myOrder.setMyorderCreateTime(new Date());

        System.out.println(myOrder.getMyorderId());
        System.out.println(myOrder.getMyorderCreateTime());

        System.out.println("service2");
        um.insertOrder(myOrder);

        System.out.println("service3");

    }

    //申请病假
    public void updateStatus(Integer salesmanId) {
        um.updateUserById(salesmanId);
    }


    //申请离职
    public void updateQuitStatus(Integer salesmanId) {
        um.updateUserQuitById(salesmanId);
    }


}




























