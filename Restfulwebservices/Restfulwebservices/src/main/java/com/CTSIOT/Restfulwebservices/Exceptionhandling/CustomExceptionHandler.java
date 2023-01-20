package com.CTSIOT.Restfulwebservices.Exceptionhandling;

import java.time.LocalDateTime;

import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Object>
	handleUserNotFoundException (UserNotFoundException userNotFoundException){
		
		HttpStatus badRequest = HttpStatus.NOT_FOUND;
		ExceptionResponse exresponse = new ExceptionResponse(
				userNotFoundException.getMessage(),
				HttpStatus.NOT_FOUND,
				LocalDateTime.now());
		return new ResponseEntity<> (exresponse,badRequest);
	}
		
}
