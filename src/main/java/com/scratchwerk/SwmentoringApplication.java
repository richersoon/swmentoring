package com.scratchwerk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.scratchwerk.service","com.scratchwerk.controller"})
@EnableMongoRepositories(basePackages = "com.scratchwerk.repo")
public class SwmentoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwmentoringApplication.class, args);
	}
}
