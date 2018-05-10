package com.example.springbootdubbodemoclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.flowable.spring.boot.SecurityAutoConfiguration.class})
public class SpringbootDubboDemoClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboDemoClientApplication.class, args);
    }
}
