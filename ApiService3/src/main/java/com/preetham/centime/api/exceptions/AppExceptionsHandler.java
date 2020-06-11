package com.preetham.centime.api.exceptions;

import java.util.Date; 

import javax.validation.ValidationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception ex,WebRequest request){
		
		String message = ex.getLocalizedMessage();
		ErrorMessage errorMessage = new ErrorMessage(message, new Date());
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(errorMessage,headers,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleNullPointerException(Exception ex,WebRequest request){
		
		String message = ex.getLocalizedMessage();
		ErrorMessage errorMessage = new ErrorMessage(message, new Date());
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(errorMessage,headers,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> handleValidationException(ValidationException ex,WebRequest request){
		
		String message = "Please Enter a valid Name with alphabets only, Validation failed!!";
		ErrorMessage errorMessage = new ErrorMessage(message, new Date());
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(errorMessage,headers,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
