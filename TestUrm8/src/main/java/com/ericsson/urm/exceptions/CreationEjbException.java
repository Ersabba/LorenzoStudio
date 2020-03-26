package com.ericsson.urm.exceptions;

public class CreationEjbException extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826220676997324769L;

	public CreationEjbException() {
		this(null,null);
		// TODO Auto-generated constructor stub
	}

	public CreationEjbException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreationEjbException(String message) {
		this(message,null);
	}

	public CreationEjbException(Throwable cause) {
		this(null,cause);
	}

}
