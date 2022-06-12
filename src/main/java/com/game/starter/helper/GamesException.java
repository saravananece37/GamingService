package com.game.starter.helper;

import org.springframework.http.HttpStatus;

public abstract class GamesException extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	protected String message;

	protected HttpStatus errorReason;
	
	public String getMessage() {
		return message;
	}

	public HttpStatus getErrorReason() {
		return (HttpStatus) errorReason;
	}


}
