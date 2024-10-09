package com.adminservice.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdminServiceControllerAdvice {

//	@ExceptionHandler(value= {ResourceNotFoundException.class})
//	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex){
//		ErrorMessage message = new ErrorMessage("Fail", LocalDate.now(),ex.getMessage(),description);
		
//		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
//	}
}
