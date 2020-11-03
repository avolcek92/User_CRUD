package com.example.user.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.user.app")
@EnableJpaRepositories(basePackages = "com.example.user.app.repositories")
@EnableTransactionManagement
@EntityScan(basePackages = "com.example.user.app.entities")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
