package com.iot.clientbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
@EnableFeignClients(basePackages = "com.iot")
@ComponentScan(basePackages = "com.iot")
public class ClientBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientBaseApplication.class, args);
    }

}

