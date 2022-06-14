package com.game.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.starter.helper.GameAlreadyExistException;
import com.game.starter.model.Game;
import com.game.starter.service.GameDAO;

@RestController
public class GameController {

	@Autowired
	GameDAO dao;

	@GetMapping(value = "/game", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Game>> getGamesDetails() {
		return new ResponseEntity<List<Game>>(dao.getGames(), HttpStatus.OK);
	}

	@PostMapping(value = "/game/newGame", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Game> addNewGame(@RequestBody Game game) throws GameAlreadyExistException {
		return new ResponseEntity<Game>(dao.addNewGame(game), HttpStatus.OK);
	}

}
