package com.game.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.starter.model.User;
import com.game.starter.service.UserDAO;

@RestController
public class UserController {
	
	@Autowired
	UserDAO dao;

	@PostMapping(value = "/user/newUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addNewUser(@RequestBody User user) {
		System.out.println(user.getUserName());
		return dao.addNewUser(user);
	}

	@PutMapping(value = "/user/updateUser/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User user, @PathVariable(name = "userId") int userId) {
		System.out.println(user.getUserID());
		return user;
	}

	@DeleteMapping(value = "/user/deleteUser/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteUser(@PathVariable(name = "userId") int userId) {
		System.out.println();
		return "delested";
	}

}
