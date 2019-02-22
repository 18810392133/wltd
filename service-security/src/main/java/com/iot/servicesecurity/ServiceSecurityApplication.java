package com.iot.servicesecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.iot")
@MapperScan("com.iot.mapper")
public class ServiceSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSecurityApplication.class, args);
    }

}

