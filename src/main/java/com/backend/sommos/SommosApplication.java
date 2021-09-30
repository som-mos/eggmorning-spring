package com.backend.sommos;

import com.backend.sommos.entities.User;
import com.backend.sommos.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SommosApplication {

	private static final Logger log = LoggerFactory.getLogger(SommosApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SommosApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UsersRepository repository){
		return (args) -> {
			repository.save(new User("test2", "test2"));

			log.info("User found with findAll():");
			log.info("--------------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");
		};
	}
}
