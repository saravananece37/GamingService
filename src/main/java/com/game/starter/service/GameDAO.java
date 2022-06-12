package com.game.starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.starter.model.Game;
import com.game.starter.repository.GameRepository;

//
@Service
public class GameDAO {

	
	@Autowired
	GameRepository repo;
	
	
	public Game addNewGame(Game game)
	{
		repo.save(game);
		return game;
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
