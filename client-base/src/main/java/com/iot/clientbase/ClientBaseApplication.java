package com.iot.clientbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.iot")
@ComponentScan(basePackages = "com.iot")
public class ClientBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientBaseApplication.class, args);
    }

}

