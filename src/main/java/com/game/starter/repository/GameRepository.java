package com.game.starter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.starter.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

	Optional<Game> findByGameName(String gameName);

}
