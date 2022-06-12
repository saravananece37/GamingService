package com.game.starter.helper;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GamesException {

	private static final long serialVersionUID = 1L;
	public UserNotFoundException(String message) {
		this.message = message;
		this.errorReason = HttpStatus.NOT_FOUND;
	}


}
