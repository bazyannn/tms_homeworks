package com.example.springboot38.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${app.key}")
    private String key;

    @PostConstruct
    public void test() {
        System.out.println(key);
    }
}
