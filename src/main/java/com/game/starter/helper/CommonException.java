package com.game.starter.helper;

public class CommonException extends GamesException {

	private static final long serialVersionUID = 1L;

	public CommonException(String message) {
		this.message = message;
		this.errorReason = "Un handled exception";
	} 

}
