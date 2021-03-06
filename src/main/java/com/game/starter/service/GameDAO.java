package com.game.starter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.starter.helper.GameAlreadyExistException;
import com.game.starter.model.Game;
import com.game.starter.repository.GameRepository;

@Service
public class GameDAO {

	@Autowired
	GameRepository repo;

	public Game addNewGame(Game game) throws GameAlreadyExistException {

		Optional<Game> optional = repo.findByGameName(game.getGameName());
		if (optional.isPresent())
			throw new GameAlreadyExistException("GameAlreadyExist");
		return repo.save(game);
	}

	public Game deleteGame(Game game) {
		repo.delete(game);
		return game;
	}

	public List<Game> getGames() {
		return repo.findAll();
	}
}
