package com.ronaldrogas.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ronaldrogas.backend")
public class RonaldrogasBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(RonaldrogasBackendApplication.class, args);
    }
} 