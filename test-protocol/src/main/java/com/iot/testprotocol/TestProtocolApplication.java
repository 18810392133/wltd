package com.iot.testprotocol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.iot")
public class TestProtocolApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestProtocolApplication.class, args);
    }

}
