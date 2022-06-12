package com.game.starter.helper;

import org.springframework.http.HttpStatus;

public class UnhandledException extends GamesException {

	private static final long serialVersionUID = 1L;

	public UnhandledException(String message) {
		this.message = message;
		this.errorReason = HttpStatus.NO_CONTENT;
	} 

}
