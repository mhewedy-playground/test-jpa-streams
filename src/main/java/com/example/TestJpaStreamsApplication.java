package com.example;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestJpaStreamsApplication implements CommandLineRunner {

	@Autowired
	UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(TestJpaStreamsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		IntStream.range(1, 100).forEach(i -> userRepo.save(User.of(null, "Ali" + i, "Wael" + i)));
	}
}
