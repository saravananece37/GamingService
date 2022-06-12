package com.game.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.starter.helper.UnhandledException;
import com.game.starter.helper.UserAlreadyExistException;
import com.game.starter.helper.UserNotFoundException;
import com.game.starter.model.User;
import com.game.starter.service.UserDAO;

@RestController
public class UserController {

	@Autowired
	UserDAO dao;

	@PostMapping(value = "/user/newUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addNewUser(@RequestBody User user) throws UserAlreadyExistException, UnhandledException {
		try {
			return new ResponseEntity<User>(dao.addNewUser(user), HttpStatus.OK);
		} catch (UserAlreadyExistException e) {
			throw new UserAlreadyExistException(e.getMessage());
		} catch (Exception e) {
			throw new UnhandledException(e.getMessage());
		}
	}

//	@PutMapping(value = "/user/updateUser/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public User updateUser(@RequestBody User user, @PathVariable(name = "userId") int userId) {
//		System.out.println(user.getUserID());
//		return user;
//	}

	@DeleteMapping(value = "/user/deleteUser/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteUser(@RequestBody User user) throws UserNotFoundException, UnhandledException {
		try {
			dao.deleteUser(user);
			return new ResponseEntity<String>("Account Deleted", HttpStatus.ACCEPTED);
		} catch (UserNotFoundException exc) {
			throw new UserNotFoundException(exc.getMessage());
		} catch (Exception e) {
			throw new UnhandledException(e.getMessage());
		}
	}

}
