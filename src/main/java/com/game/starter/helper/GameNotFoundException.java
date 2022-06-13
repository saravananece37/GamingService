package com.game.starter.helper;

import org.springframework.http.HttpStatus;

public class GameNotFoundException extends GamesException {

	private static final long serialVersionUID = 1L;

	public GameNotFoundException(String message) {
		this.message = message;
		this.errorReason = HttpStatus.NOT_FOUND;
	}
}
