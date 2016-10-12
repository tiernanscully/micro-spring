package com.lemur.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaService {

	public static void main(final String[] args) {
		System.setProperty("spring.config.name", "eureka-service");
		SpringApplication.run(EurekaService.class, args);
	}
}
