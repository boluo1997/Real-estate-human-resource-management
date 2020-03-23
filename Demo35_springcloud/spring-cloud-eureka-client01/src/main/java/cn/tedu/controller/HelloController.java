package cn.tedu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("sayHi")
    public String sayHi(){
        return "hello world springcloud i am from 9001";
    }
}
