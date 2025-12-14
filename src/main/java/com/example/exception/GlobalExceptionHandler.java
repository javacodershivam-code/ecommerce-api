package com.example.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleValidationError(MethodArgumentNotValidException ex){
		Map<String,String> error=new HashMap<>();
		ex.getBindingResult().getFieldErrors()
						     .forEach(a-> error.put(a.getField(),a.getDefaultMessage()));
		
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntime(RuntimeException ex){
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
				
	}

}
