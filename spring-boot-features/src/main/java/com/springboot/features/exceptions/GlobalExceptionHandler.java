package com.springboot.features.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> productNotFoundException(ProductNotFoundException e) {
		return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
	}
}
