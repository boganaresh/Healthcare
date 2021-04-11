package com.slokam.healthcare.exception;

public class HealthCareException extends Exception {

	private Integer errorCode;

	public Integer getErrorCode() {
		return errorCode;
	}

	public HealthCareException() {

	}

	public HealthCareException(String message) {
		super(message);
	}

	public HealthCareException(String message, Integer errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public HealthCareException(String message, Throwable t) {
		super(message);
	}

	public HealthCareException(String message, Throwable t, Integer errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

}
