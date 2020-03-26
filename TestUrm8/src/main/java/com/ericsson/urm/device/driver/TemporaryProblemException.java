package com.ericsson.urm.device.driver;

public class TemporaryProblemException extends RuntimeException {

	public TemporaryProblemException() {
	}

	public TemporaryProblemException(String message) {
		super(message);
	
	}

	public TemporaryProblemException(Throwable cause) {
		super(cause);

	}

	public TemporaryProblemException(String message, Throwable cause) {
		super(message, cause);
	}

}
