package com.game.starter.helper;

import org.springframework.http.HttpStatus;

public class GameAlreadyExistException extends GamesException {
	private static final long serialVersionUID = 1L;

	public GameAlreadyExistException(String message) {
		this.message = message;
		this.errorReason = HttpStatus.CONFLICT;
	}
}
