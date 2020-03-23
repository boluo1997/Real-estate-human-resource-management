package cn.tedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.tedu.user.mapper")
public class StarterLogin {
    public static void main(String[] args) {
        SpringApplication.run(StarterLogin.class,args);
    }
    @Bean
    public Jedis initJedis(){
        return new Jedis("10.42.21.160",6379);
    }
}
