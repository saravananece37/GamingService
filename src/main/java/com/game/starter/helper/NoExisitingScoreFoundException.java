package com.game.starter.helper;

import org.springframework.http.HttpStatus;

public class NoExisitingScoreFoundException extends GamesException {

	private static final long serialVersionUID = 1L;

	public NoExisitingScoreFoundException(String message) {
		this.message = message;
		this.errorReason = HttpStatus.CONFLICT;
	}
}
