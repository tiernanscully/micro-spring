package com.lemur.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Main {

    public static void main(final String[] args) {
        System.setProperty("spring.config.name", "user-service");
        SpringApplication.run(Main.class, args);
    }

}
