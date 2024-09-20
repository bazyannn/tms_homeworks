package com.example.rest_43_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Rest431Application {

    public static void main(String[] args) {
        SpringApplication.run(Rest431Application.class, args);
    }

}
