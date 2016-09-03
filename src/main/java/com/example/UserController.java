package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping("/db")
	public ResponseEntity<?> getUsersDb() {
		return ResponseEntity.ok(manipulateStream(userService.getUsersStreamFromDb()));
	}

	@RequestMapping("/db-notrans")
	public ResponseEntity<?> getUsersDbNoTransactionl() {
		return ResponseEntity.ok(manipulateStream(userService.getUsersStreamFromDbWithNoTransactionalAnnot()));
	}

	@RequestMapping("/service")
	public ResponseEntity<?> getUsersService() {
		return ResponseEntity.ok(manipulateStream(userService.getUsersStreamFromService()));
	}

	@RequestMapping("/add")
	public ResponseEntity<?> addUsers() {
		userService.addUsers();
		return ResponseEntity.ok().build();
	}

	private User[] manipulateStream(Stream<User> users) {
		return users.filter(u -> true).toArray(User[]::new);
	}
}