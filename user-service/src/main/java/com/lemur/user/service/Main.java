package com.lemur.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.EndpointMBeanExportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableEurekaClient
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication(exclude = EndpointMBeanExportAutoConfiguration.class)
public class Main {

    public static void main(final String[] args) {
        System.setProperty("spring.config.name", "user-service");
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private UserRepository repo;

    @Bean
    CommandLineRunner setUp() {
        return (args) -> {
            repo.save(new User("etiescu","Tiernan", "Scully", "phoneNumber", "emailAddress"));
            repo.save(new User("pj","Patrick", "Scully", "phoneNumber", "emailAddress"));
            repo.save(new User("bríd","Bridie", "Scully", "phoneNumber", "emailAddress"));
            System.out.println(repo.findAll());
        };
    }

}
