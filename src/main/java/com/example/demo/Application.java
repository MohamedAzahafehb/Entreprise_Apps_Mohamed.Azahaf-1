package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//COMMENT: db werd niet gemigrate, na het toevoegen van de volgende twee lijnen werkt goed
@EnableJpaRepositories("repository")
@EntityScan("model")
//tst
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
