package com.lemur.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class Main {

    public static void main(final String[] args) {
        System.setProperty("spring.config.name", "web-service");
        SpringApplication.run(Main.class, args);
    }
}
