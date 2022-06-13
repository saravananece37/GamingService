package com.game.starter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.game.starter.model.Game;
import com.game.starter.model.Score;
import com.game.starter.model.User;

@Repository
public interface ScoreRepository extends PagingAndSortingRepository<Score, Integer> {

	Optional<Score> findByUserAndGame(User user, Game game);
	List<Score> findByGameOrderByScore(Game game,PageRequest ofSize);

}
