package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestJpaStreamsApplication {

	@Autowired
	UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(TestJpaStreamsApplication.class, args);
	}
}
