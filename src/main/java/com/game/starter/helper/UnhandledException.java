package com.game.starter.helper;

public class UnhandledException extends GamesException {

	private static final long serialVersionUID = 1L;

	public UnhandledException(String message) {
		this.message = message;
		this.errorReason = "Un handled exception";
	} 

}
