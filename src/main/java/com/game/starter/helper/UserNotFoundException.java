package com.game.starter.helper;

public class UserNotFoundException extends GamesException {

	private static final long serialVersionUID = 1L;
	public UserNotFoundException(String message) {
		this.message = message;
		this.errorReason = "User Not found";
	}


}
