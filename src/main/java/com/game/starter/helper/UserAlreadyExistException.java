package com.game.starter.helper;

public class UserAlreadyExistException extends GamesException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException(String message) {
		this.message = message;
		this.errorReason = "User Already Exist";
	}
}
