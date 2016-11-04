package com.lemur.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.EndpointMBeanExportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableEurekaClient
@EnableFeignClients
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication(exclude = EndpointMBeanExportAutoConfiguration.class)
public class Main {

    public static void main(final String[] args) {
        System.setProperty("spring.config.name", "web-service");
        SpringApplication.run(Main.class, args);
    }
}
