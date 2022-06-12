package com.game.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.starter.model.Game;


@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

}
