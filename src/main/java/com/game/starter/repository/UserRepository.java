package com.game.starter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.starter.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

	Optional<User> findByUserName(String userName);

	Optional<User> findByUserID(int userID);

}
