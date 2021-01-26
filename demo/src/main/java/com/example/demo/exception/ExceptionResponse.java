package com.example.demo.exception;

import java.util.Date;

public class ExceptionResponse {
	public ExceptionResponse(String message, Date timestamp, String details) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.details = details;
	}
	private String message;
	private Date timestamp;
	private String details;
	
	public String getMessage() {
		return message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getDetails() {
		return details;
	}
	

}
