package com.game.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.starter.model.Score;


@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer>{

}
