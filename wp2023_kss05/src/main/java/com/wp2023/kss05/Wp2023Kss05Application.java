package com.wp2023.kss05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Wp2023Kss05Application {

	public static void main(String[] args) {
		SpringApplication.run(Wp2023Kss05Application.class, args);
	}

}
