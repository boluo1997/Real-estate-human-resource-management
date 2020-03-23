package cn.tedu.user.controller;

import cn.tedu.user.service.UserService;
import com.jt.common.pojo.MyOrder;
import com.jt.common.pojo.Salesman;
import com.jt.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// nigix中 / 对应 www.boluo.com
//         /user 对应 http://127.0.0.1:8103/zuul-user/user/check;

//请求地址 http://www.boluo.com/user/checkUser?userId=1614
//后台接收 /user/check/checkUser?userId=1614

@RestController
@RequestMapping("user")
public class UserController {

    //注入service层属性
    @Autowired
    private UserService us;


    //查看自己信息
    //...  return us.queryUser(userId);
    @RequestMapping("check/checkUser")
    public Salesman queryUser(Integer salesmanId){
        System.out.println("11111");
        //System.out.println(us.querySalesman(salesmanId));
        return us.querySalesman(salesmanId);
    }

    //select * from user where userId={userId}


    @RequestMapping(value = "/test")
    public SysResult sadashkjdashk(String name){
        System.out.println(name + "111" );
        return new SysResult().build(1, "成功",
                new Salesman("zhangsan", "123"));
    }


    //修改信息
    //www.boluo.com/user/alterInfo?salesmanId=666
    @RequestMapping("alterInfo")
    public SysResult updateInfo(Salesman salesman){
        System.out.println("alterInfo");
        return us.alterInfo(salesman);
    }


    //提交签单申请{userId}        //新增信息
    //点击提交签单申请，跳转一个页面，页面中有一个表单，输入受理人的信息，点击提交按钮...

    //请求地址 http://www.boluo.com/user/addOrder
    //后台接收 /user/addOrder

    @RequestMapping("addOrder")
    public SysResult addOrder(MyOrder myorder){     //此处是订单Order 后期记得改
        //判断增加成功或者失败
        System.out.println("进来了");
        try{
            System.out.println("-----" + myorder);
            us.addOrder(myorder);
            return SysResult.ok();      //status=200 msg="ok" data=null
        }catch(Exception e){
            e.printStackTrace();
            return SysResult.build(201,"新增失败",null);
        }

    }


    //病假申请
    //请求地址 http://www.boluo.com/users/updateUser?userId=666
    //后台接收 user/update/updateUser?userId=666

    @RequestMapping("applyHoliday")
    public SysResult updateStatus(Integer salesmanId){
        try{
            us.updateStatus(salesmanId);
            return SysResult.ok();
        }catch(Exception e){
            e.printStackTrace();
            return SysResult.build(201,"请假失败",null);
        }
    }


    //离职申请
    //请求地址 http://www.boluo.com/users/update/updateUserQuit?userId=666
    //后台接收 user/update/updateUserQuit?userId=666

    @RequestMapping("applyQuit")
    public SysResult updateQuitStatus(Integer salesmanId){
        try{
            us.updateQuitStatus(salesmanId);
            return SysResult.ok();
        }catch(Exception e){
            e.printStackTrace();
            return SysResult.build(201,"离职申请失败！",null);
        }

    }


}





































