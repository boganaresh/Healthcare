package com.slokam.healthcare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.slokam.healthcare.pojo.ErrorInfo;

@RestControllerAdvice
public class HealthCareExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> handleException(Exception e){
		
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorId(12345);
		errorInfo.setException(e);
		errorInfo.setMessage("Application went wrong");
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HealthCareException.class)
	public ResponseEntity<ErrorInfo> healthCareException(HealthCareException e){
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorId(e.getErrorCode());
		errorInfo.setMessage(e.getMessage());
		errorInfo.setException(e);
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
