package com.game.starter.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GameServiceExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<GlobalError> noUserFoundException(UserNotFoundException exception)
	{
		GlobalError error=new GlobalError();
		error.setErrorReason(exception.getErrorReason());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<GlobalError>(error, HttpStatus.NOT_FOUND);		
	}
	
	
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<GlobalError> userAlreadyExist(UserAlreadyExistException exception)
	{
		GlobalError error=new GlobalError();
		error.setErrorReason(exception.getErrorReason());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<GlobalError>(error, HttpStatus.CONFLICT);		
	}
		
	@ExceptionHandler(GameNotFoundException.class)
	public ResponseEntity<GlobalError> gameNotMatchingException(GameNotFoundException exception)
	{
		GlobalError error=new GlobalError();
		error.setErrorReason(exception.getErrorReason());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<GlobalError>(error, HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler(NoExisitingScoreFoundException.class)
	public ResponseEntity<GlobalError> NoExisitingScoreFound(NoExisitingScoreFoundException exception)
	{
		GlobalError error=new GlobalError();
		error.setErrorReason(exception.getErrorReason());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<GlobalError>(error, HttpStatus.NOT_FOUND);		
	}

}
