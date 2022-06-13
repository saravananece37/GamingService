package com.game.starter.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.starter.model.Game;
import com.game.starter.model.Score;
import com.game.starter.model.User;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

//	@Query("select s score from score s where s.user=?1 and s.game=?2")
	Optional<Score> findByUserAndGame(User user, Game game);

	Page<Score> findByGameOrderByScore(Game game,PageRequest ofSize);

}
