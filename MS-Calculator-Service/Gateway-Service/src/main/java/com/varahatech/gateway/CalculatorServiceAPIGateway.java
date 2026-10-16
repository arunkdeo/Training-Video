package com.varahatech.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CalculatorServiceAPIGateway {
    static void main(String[] args) {
        SpringApplication.run(CalculatorServiceAPIGateway.class, args);
    
    }
}
