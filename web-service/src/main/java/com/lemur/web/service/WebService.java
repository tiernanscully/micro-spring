package com.lemur.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lemur.user.domain.User;
import com.lemur.web.feign.client.UserServiceClient;


@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = {UserServiceClient.class})
@RestController
@SpringBootApplication
public class WebService implements WebRestService{

	@Autowired
	private UserServiceClient userServiceClient;

	public static void main(final String[] args) {
		System.setProperty("spring.config.name", "web-service");
		SpringApplication.run(WebService.class, args);
	}

	@Override
	public String getId(@PathVariable("id") final String id){
		return id;
	}

	@Override
	public User getUser(@PathVariable("id") final String id) {
		return userServiceClient.getUser(id);
	}

	@Override
	public String index() {
		return "Hello World!";
	}

}
