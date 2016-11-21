package com.lemur.event.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.EndpointMBeanExportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.lemur.user.service.User;

@EnableEurekaClient
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication(exclude = EndpointMBeanExportAutoConfiguration.class)
public class Main {

	@Autowired
	private EventRepository repo;

	public static void main(final String[] args) {
		System.setProperty("spring.config.name", "event-service");
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner setUp() {
		return (args) -> {
			final List<User> organizers = new ArrayList<>();
			final List<User> attendees = new ArrayList<>();
			final User tiernan = new User("etiescu", "Tie", "Scu", "098786879", "tiernan@gmail.com");
			final User kieran = new User("scumbag", "Kie", "Don", "98574342", "kieran@gmail.com");
			organizers.add(tiernan);
			attendees.add(kieran);
			repo.save(new Event("Bowling", "Bowling party", "social", "2007-12-03T10:15:30", "2007-12-03T10:18:30", 5));
			repo.save(new Event("Cinema", "Deadpool premier", "social", "2007-12-03T10:15:30", "2007-12-03T10:18:30",
					12));
			System.out.println(repo.findAll());
		};
	}

}
