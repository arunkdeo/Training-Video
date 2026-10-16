package com.varahatech.subtraction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubtractionServiceMain {

    static void main(String[] args) {
        SpringApplication.run(SubtractionServiceMain.class, args);
    }
}
