package com.ronaldrogas.backend.users.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ronaldrogas.backend.users.infrastructure.persistence.mappers")
public class MapperConfig {
} 