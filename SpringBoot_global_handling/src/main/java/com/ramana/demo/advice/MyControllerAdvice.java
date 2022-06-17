package com.ramana.demo.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ramana.demo.custom.exception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice {
	@ExceptionHandler
	public ResponseEntity<String> handleEmtyInput(EmptyInputException emptyInputException){
		
		return new ResponseEntity<String>("Input field is empty, please look into it",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException ){
		return new ResponseEntity<String>("No value present in DB, please change your request",HttpStatus.BAD_REQUEST);
	}
}
