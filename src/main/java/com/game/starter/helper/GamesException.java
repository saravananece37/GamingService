package com.game.starter.helper;

public abstract class GamesException extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	protected String message;

	protected String errorReason;
	
	public String getMessage() {
		return message;
	}

	public String getErrorReason() {
		return errorReason;
	}


}
