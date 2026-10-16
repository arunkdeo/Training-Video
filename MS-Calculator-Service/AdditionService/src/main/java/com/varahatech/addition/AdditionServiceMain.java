package com.varahatech.addition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdditionServiceMain {

    static void main(String[] args) {
        SpringApplication.run(AdditionServiceMain.class, args);
    }
}
