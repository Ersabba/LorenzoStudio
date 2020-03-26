package com.ericsson.urm.exceptions;


public class URMCommunicationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public static enum ErrorCode {
		UNCLASSIFIED_ERROR,
		COMMUNICATION_TIMEOUT,
		COMMUNICATION_ERROR,
		UNKNOWN_HOST;
	}
	
	private ErrorCode errorCode = ErrorCode.UNCLASSIFIED_ERROR;

	public URMCommunicationException() {
		this.errorCode = ErrorCode.UNCLASSIFIED_ERROR;
		
	}

	public URMCommunicationException(String arg0) {
		super(arg0);
		this.errorCode = ErrorCode.UNCLASSIFIED_ERROR;
	}

	public URMCommunicationException(Throwable arg0) {
		super(arg0);
		this.errorCode = ErrorCode.UNCLASSIFIED_ERROR;
	}

	public URMCommunicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		this.errorCode = ErrorCode.UNCLASSIFIED_ERROR;
	}
	

	public URMCommunicationException(ErrorCode errorCode) {
		this.errorCode = errorCode;
		
	}

	public URMCommunicationException(String arg0,ErrorCode errorCode) {
		super(arg0);
		this.errorCode = errorCode;
	}

	public URMCommunicationException(Throwable arg0,ErrorCode errorCode) {
		super(arg0);
		this.errorCode = errorCode;
	}

	public URMCommunicationException(String arg0, Throwable arg1, ErrorCode errorCode) {
		super(arg0, arg1);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

}
