package com.geetha.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductRestExceptionHandler {

	//add exception handler for ProductNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException exc) {
		
		//create the ProductErrorResponse
		ProductErrorResponse error = new ProductErrorResponse(
				                          HttpStatus.NOT_FOUND.value(),
				                          exc.getMessage(),
				                          System.currentTimeMillis());
		
		//return the ResponseEntity
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//add another Exception handler for any other exceptions (catch all)	
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleException(Exception exc) {
		
		//create the ProductErrorResponse
		ProductErrorResponse error = new ProductErrorResponse(
				                          HttpStatus.BAD_REQUEST.value(),
				                          exc.getMessage(),
				                          System.currentTimeMillis());
		
		//return the ResponseEntity
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
