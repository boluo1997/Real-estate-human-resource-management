package cn.tedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 注入使用restTemplate完成访问service-hi的过程
 */
@Service
public class HelloService{

    @Autowired
    private RestTemplate rtl;

    public String sayHi(String name){
        return rtl.getForObject(
                "http://service-hi/sayHi?name="+name,
                String.class);
    }

}

