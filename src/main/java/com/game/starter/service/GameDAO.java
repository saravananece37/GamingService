package com.game.starter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.starter.helper.GameAlreadyExistException;
import com.game.starter.helper.UserAlreadyExistException;
import com.game.starter.model.Game;
import com.game.starter.model.User;
import com.game.starter.repository.GameRepository;

//
@Service
public class GameDAO {

	
	@Autowired
	GameRepository repo;
	
	
	public Game addNewGame(Game game) throws GameAlreadyExistException
	{
		
		Optional<Game> optional=repo.findByGameName(game.getGameName());
		System.out.println(optional.isPresent()+" user exist");
		if(optional.isPresent())
			throw new GameAlreadyExistException("UserAlreadyExist");
		return repo.save(game);
	}

	public Game updateGame(Game game)
	{
		repo.save(game);
		return game;
	}

	public Game deleteGame(Game game)
	{
		repo.delete(game);
		return game;
	}
}
