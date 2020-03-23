package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//声明这个应用是一个EurekaServer
@EnableEurekaServer
public class StarterEServer01 {
    public static void main(String[] args) {
        SpringApplication.run(StarterEServer01.class,args);
    }
}
