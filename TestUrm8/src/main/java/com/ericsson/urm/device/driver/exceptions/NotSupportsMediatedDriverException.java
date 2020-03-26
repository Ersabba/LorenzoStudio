package com.ericsson.urm.device.driver.exceptions;

public class NotSupportsMediatedDriverException extends Exception {
	
	private static final long serialVersionUID = -1L;

	public NotSupportsMediatedDriverException() {
		super();
	}
	
	public NotSupportsMediatedDriverException(String message) {
		super(message);
	}
	
	public NotSupportsMediatedDriverException(Throwable cause) {
		super(cause);
	}
	
	public NotSupportsMediatedDriverException(String message, Throwable cause) {
		super(message, cause);
	}
}
