package com.ericsson.urm.exceptions;

public class CreationException extends Exception {
	
	
	private static final long serialVersionUID = -1L;

	public CreationException() {
		this(null,null);
		// TODO Auto-generated constructor stub
	}

	public CreationException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreationException(String message) {
		this(message,null);
	}

	public CreationException(Throwable cause) {
		this(null,cause);
	}

}
