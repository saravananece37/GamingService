package com.game.starter.helper;

import org.springframework.http.HttpStatus;

public class GlobalError {
	  private String message;
	  private HttpStatus errorReason;

	  public GlobalError() {
	  }

	  public GlobalError(String message, HttpStatus errorReason) {
	    this.message = message;
	    this.errorReason = errorReason;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }

	  public void setErrorReason(HttpStatus errorReason) {
	    this.errorReason = errorReason;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public HttpStatus getErrorReason() {
	    return errorReason;
	  }

	}