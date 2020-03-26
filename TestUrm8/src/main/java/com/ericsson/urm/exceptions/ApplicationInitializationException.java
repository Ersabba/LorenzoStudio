package com.ericsson.urm.exceptions;

public class ApplicationInitializationException extends RuntimeException {

	private static final long serialVersionUID = -1L;
	private boolean enableSuppression;
	private boolean writableStackTrace;

	public ApplicationInitializationException() {
		this(null,null);
	}

	public ApplicationInitializationException(String message) {
		this(message,null);
	}

	public ApplicationInitializationException(Throwable cause) {
		this(null,cause);
	}

	public ApplicationInitializationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationInitializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		this(message, cause);
		this.setEnableSuppression(enableSuppression); 
		this.writableStackTrace=writableStackTrace;
	}

	public boolean isEnableSuppression() {
		return enableSuppression;
	}

	public void setEnableSuppression(boolean enableSuppression) {
		this.enableSuppression = enableSuppression;
	}

}
