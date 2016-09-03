package com.example;

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
}
