package com.scratchwerk;

import com.scratchwerk.repo.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwmentoringApplication {

	@Autowired
	private MentorRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SwmentoringApplication.class, args);
	}
}
