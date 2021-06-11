package com.main.java.week4.db;
/**
 * This is DBException class
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 *
 */
public class DBException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public DBException(String string) {
		message = string;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}			
	