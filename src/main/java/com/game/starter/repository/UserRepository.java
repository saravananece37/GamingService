package com.game.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.starter.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
