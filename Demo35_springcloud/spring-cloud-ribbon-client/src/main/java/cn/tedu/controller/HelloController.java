package cn.tedu.controller;

import cn.tedu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{

    @Autowired
    private HelloService hs;

    @RequestMapping("/hello")
    public String sayHi(String name){
        System.out.println(111111111);
        return "RIBBON:"+hs.sayHi(name);
    }

    /*有个叫 DispatchServlet的，  所有的访问都进入这个类
    * 以前配置web.xml文件访问路径都配置一个 /*
    这个类里有一个对象，这个对象存了所有的路径和controller的对应关系
    根据路径找到controller、

    然后 再根据详细的路径找到对应的方法
    */

}