package com.game.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.game.starter.model.Game;
import com.game.starter.repository.GameRepository;

@RestController
public class GameController {


	
	@Autowired
	GameRepository repo;
	
	@GetMapping(value="/game",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Game> getGamesDetails()
	{
		return null;
	}

	@PostMapping(value="/game/newGame",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Game addNewGame(@RequestBody Game game)
	{
		return repo.save(game);
	}

	@PutMapping(value="/game/updateGame",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Game updateGameDetails(@RequestParam Game game)
	{
		return game;
	}

	@DeleteMapping(value="/game/deleteGame",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Game deleteGameDetails(@RequestParam Game game)
	{
		return game;
	}

}
