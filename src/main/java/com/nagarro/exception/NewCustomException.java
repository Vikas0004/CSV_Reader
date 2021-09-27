package com.nagarro.exception;

public class NewCustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4076611916863296393L;
	private String message = null;

	public NewCustomException(){
		super();
	}
	public NewCustomException(String message) {
		super();
		this.message = message;
	}
	
	public String printMessage() {
		return message;
	}
}

