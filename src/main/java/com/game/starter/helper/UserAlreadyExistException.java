package com.game.starter.helper;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends GamesException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException(String message) {
		this.message = message;
		this.errorReason = HttpStatus.CONFLICT;
	}
}
