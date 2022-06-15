package com.game.starter.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.starter.helper.UserAlreadyExistException;
import com.game.starter.helper.UserNotFoundException;
import com.game.starter.model.User;
import com.game.starter.repository.UserRepository;


@Service
public class UserDAO {
	
	@Autowired
	UserRepository repo;
	
	public User addNewUser(User user) throws UserAlreadyExistException
	{
		
		Optional<User> optional=repo.findByUserName(user.getUserName());
		if(optional.isPresent())
			throw new UserAlreadyExistException("UserAlreadyExist");
		return repo.save(user);
	}

	public void deleteUser(User user) throws UserNotFoundException
	{
		Optional<User> optional=repo.findByUserID(user.getUserID());
		if(!optional.isPresent())
			throw new UserNotFoundException("UserNotFound");
		repo.delete(user);
	}
}
