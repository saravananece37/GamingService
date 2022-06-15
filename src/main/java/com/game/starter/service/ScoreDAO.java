package com.game.starter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.game.starter.helper.GameNotFoundException;
import com.game.starter.helper.NoExisitingScoreFoundException;
import com.game.starter.helper.UserNotFoundException;
import com.game.starter.model.Game;
import com.game.starter.model.Score;
import com.game.starter.model.User;
import com.game.starter.repository.GameRepository;
import com.game.starter.repository.ScoreRepository;
import com.game.starter.repository.UserRepository;

@Service
public class ScoreDAO {

	@Autowired
	ScoreRepository scoreRepo;

	@Autowired
	GameRepository gameRepo;

	@Autowired
	UserRepository userRepo;

	public Score addNewScore(Score score) throws UserNotFoundException, GameNotFoundException {

		User user = score.getUser();
		Game game = score.getGame();
		Optional<User> userOptional = userRepo.findByUserName(user.getUserName());
		Optional<Game> gameOptional = gameRepo.findByGameName(game.getGameName());

		if (!userOptional.isPresent())
			throw new UserNotFoundException("UserNotFound");
		if (!gameOptional.isPresent())
			throw new GameNotFoundException("GameNotFound");
		score.setUser(userOptional.get());
		score.setGame(gameOptional.get());
		return scoreRepo.save(score);
	}

	public Score updateScore(Score score)
			throws UserNotFoundException, GameNotFoundException, NoExisitingScoreFoundException {

		User user = score.getUser();
		Game game = score.getGame();
		Optional<User> userOptional = userRepo.findByUserName(user.getUserName());
		Optional<Game> gameOptional = gameRepo.findByGameName(game.getGameName());

		if (!userOptional.isPresent())
			throw new UserNotFoundException("UserNotFound");
		if (!gameOptional.isPresent())
			throw new GameNotFoundException("GameNotFound");

		Optional<Score> scoreOptional = scoreRepo.findByUserAndGame(userOptional.get(), gameOptional.get());

		if (!scoreOptional.isPresent())
			throw new NoExisitingScoreFoundException("NoScoreFound");
		
		int updatedScore=score.getScore()+scoreOptional.get().getScore();
		score=scoreOptional.get();
		score.setScore(updatedScore);
		return scoreRepo.save(score);
	}

	@SuppressWarnings("unchecked")
	public List<String> getTopList(String gameName, int topResult) throws GameNotFoundException {
		Optional<Game> gameOptional = gameRepo.findByGameName(gameName);
		if (!gameOptional.isPresent())
			throw new GameNotFoundException("GameNotFound");
		List<Score> scores = (List<Score>) scoreRepo.findByGameOrderByScoreDesc(gameOptional.get(),
				PageRequest.ofSize(topResult));
		List<String> result = new ArrayList<String>();
		scores.forEach(
				score -> result.add("UserName : " + score.getUser().getUserName() + ", Score : " + score.getScore()));
		return result;
	}

}
