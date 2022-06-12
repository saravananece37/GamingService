package com.game.starter.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.starter.model.User;
import com.game.starter.repository.UserRepository;


@Service
public class UserDAO {
	
	@Autowired
	UserRepository repo;
	
	public User addNewUser(User user)
	{
		return repo.save(user);
	}

	public User deleteUser(User user)
	{
		repo.delete(user);
		return user;
	}
}
