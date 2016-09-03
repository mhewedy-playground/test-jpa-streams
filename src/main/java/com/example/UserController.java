package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/db")
	public ResponseEntity<?> getUsersDb() {
		return ResponseEntity.ok(workOnStream(userService.getUsersStreamFromDb()));
	}

	@RequestMapping("/db-notrans")
	public ResponseEntity<?> getUsersDbNoTransactionl() {
		return ResponseEntity.ok(workOnStream(userService.getUsersStreamFromDbWithNoTransactionalAnnot()));
	}

	@RequestMapping("/service")
	public ResponseEntity<?> getUsersService() {
		return ResponseEntity.ok(workOnStream(userService.getUsersStreamFromService()));
	}

	private User[] workOnStream(Stream<User> users) {
		return users.filter(u -> u.getFName().contains("3")).toArray(User[]::new);
	}
}