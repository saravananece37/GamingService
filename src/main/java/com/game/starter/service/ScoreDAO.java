package com.game.starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.starter.model.Score;
import com.game.starter.repository.ScoreRepository;

@Service
public class ScoreDAO {

	@Autowired
	ScoreRepository repo;

	public Score addNewScore(Score score)
	{
		return repo.save(score);
	}

}
