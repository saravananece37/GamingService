package com.game.starter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	Logger logger=LoggerFactory.getLogger(ScoreController.class);
	
	@Autowired
	ScoreDAO dao;

	@GetMapping(value = "/score/{gameName}/{topResult}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getTopScorer(@PathVariable(name = "gameName") String gameName,
			@PathVariable(name = "topResult") int topResult) throws GameNotFoundException {
		logger.info("Get top list called");
		List<String> result = dao.getTopList(gameName, topResult);
		logger.info("Result data size : "+result.size());
		return new ResponseEntity<List<String>>(result, HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "/score", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Score> addNewScorer(@RequestBody Score score)
			throws UserNotFoundException, GameNotFoundException {
		logger.info(" Add New Score request called");
		return new ResponseEntity<Score>(dao.addNewScore(score), HttpStatus.OK);
	}

	@PutMapping(value = "/score", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Score> updateScorer(@RequestBody Score score)
			throws UserNotFoundException, GameNotFoundException, NoExisitingScoreFoundException {
		logger.info("Update Score request called");
		return new ResponseEntity<Score>(dao.updateScore(score), HttpStatus.OK);
	}

}
