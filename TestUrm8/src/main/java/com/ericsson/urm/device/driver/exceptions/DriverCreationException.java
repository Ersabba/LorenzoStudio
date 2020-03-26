package com.ericsson.urm.device.driver.exceptions;

public class DriverCreationException extends Exception {
	
	private static final long serialVersionUID = -1L;

	public DriverCreationException() {
		super();
	}
	
	public DriverCreationException(String message) {
		super(message);
	}
	
	public DriverCreationException(Throwable cause) {
		super(cause);
	}
	
	public DriverCreationException(String message, Throwable cause) {
		super(message, cause);
	}
}
