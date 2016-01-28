package com.company.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception  {

	int status;
	String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CustomException(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	} 
	
	
	
	
}
