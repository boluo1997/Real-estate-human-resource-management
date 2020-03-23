package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class StarterRibbon {
    public static void main(String[] args) {
        SpringApplication.run(StarterRibbon.class,args);
    }
    //生成一个RestTemplate的spring管理对象
    //创建过程需要整合ribbon拦截逻辑
    //http://service-hi/sayHi?name=wang
    @Bean
    @LoadBalanced//负载均衡的ribbon拦截器注解
    //RestTemplate 实现方法发送请求的拦截逻辑
    public RestTemplate initTemplate(){
        return new RestTemplate();




















        /*
        *
        * 先看SSM
        * 得把注解  @Controller  @Service 这些弄清楚
        * 加不加注解都是什么区别
        *
        * 然后再看cloud  就是各种 eureka ribbon zuul这些
        * 代码不重要，这块没代码
        * 但是一定要把关系捋清楚，  率不清楚没法写，因为你不知道哪里出问题了，是代码出问题了还是配置出问题了
        *
        * 最后再配上nginx就更乱了
        *
        * */
    }
}
