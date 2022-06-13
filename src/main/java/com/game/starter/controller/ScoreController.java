package com.game.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.starter.helper.GameNotFoundException;
import com.game.starter.helper.NoExisitingScoreFoundException;
import com.game.starter.helper.UserNotFoundException;
import com.game.starter.model.Score;
import com.game.starter.service.ScoreDAO;

@RestController
public class ScoreController {

	@Autowired
	ScoreDAO dao;

	@GetMapping(value = "/score/toplist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getTopScorer() {
		return null;
	}

	@PostMapping(value = "/score/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Score addNewScorer(@RequestBody Score score) throws UserNotFoundException, GameNotFoundException {
		return dao.addNewScore(score);
	}

	
	@PutMapping(value = "/score/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Score updateScorer(@RequestBody Score score) throws UserNotFoundException, GameNotFoundException, NoExisitingScoreFoundException {
		return dao.updateScore(score);
	}

}
