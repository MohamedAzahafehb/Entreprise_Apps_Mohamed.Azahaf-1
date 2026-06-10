package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//de Application weet waar hij de Repositories moet vinden en de entities om de db succesvol te kunnen creeren
//hij gaat automatisch opzoek naar packages "repository" en "model". indien deze packages op een andere locatie zijn of anders noemen
//moet u het bijvoorbeeld als volgt specifiëren
//@EnableJpaRepositories("com.example.demo.repository")
//@EntityScan("com.example.demo.model")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
