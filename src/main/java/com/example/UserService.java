package com.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Transactional
	public Stream<User> getUsersStreamFromDb() {
		return userRepo.findAllStream();
	}

	public Stream<User> getUsersStreamFromDbWithNoTransactionalAnnot() {
		return userRepo.findAllStream();
	}

	@Transactional
	public Stream<User> getUsersStreamFromService() {
		return userRepo.findAll().stream();
	}

//	@Transactional
	public void addUsers() {
		IntStream.range(1, 100).forEach(i -> userRepo.save(User.of(null, "Ali" + i, i % 30 != 0 ? "wael" + i : null)));
	}
}
