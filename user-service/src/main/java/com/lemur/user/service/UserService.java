package com.lemur.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lemur.user.domain.User;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class UserService implements UserRestService{

	public static void main(final String[] args) {
		System.setProperty("spring.config.name", "user-service");
		SpringApplication.run(UserService.class, args);
	}

	@Override
	public User getUser(@PathVariable("userId") final String userId) {
		return new User();
	}

	@Override
	public String index() {
		return "Hello User!";
	}
}
