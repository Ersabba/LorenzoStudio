package com.ericsson.urm.device.driver;


public class CommunicationException extends Exception {
	
	
	private static final long serialVersionUID = -1L;

	public static enum ErrorCode {
		UNCLASSIFIED_ERROR,
		COMMUNICATION_TIMEOUT,
		READ_TIMEOUT,
		COMMUNICATION_ERROR,
		ERROR_FROM_DEVICE,
		LOST_CONNECTION,
		UNKNOWN_HOST,
		INVALID_COMMAND_RESPONSE,
		SESSION_ERROR,
		COMMAND_RESPONSE_ERROR,
		NACK_RESPONSE,
		NO_RESPONSE_EXPECTED;
	}
	
	private ErrorCode errorCode = ErrorCode.UNCLASSIFIED_ERROR;
	private int nackCode = 0;
	private boolean fatalError = false;

	public CommunicationException() {
		this.errorCode = ErrorCode.UNCLASSIFIED_ERROR;
		
	}

	public CommunicationException(String arg0) {
		super(arg0);
		this.errorCode = ErrorCode.UNCLASSIFIED_ERROR;
	}

	public CommunicationException(Throwable arg0) {
		super(arg0);
		this.errorCode = ErrorCode.UNCLASSIFIED_ERROR;
	}

	public CommunicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		this.errorCode = ErrorCode.UNCLASSIFIED_ERROR;
	}
	
	public CommunicationException(ErrorCode errorCode) {
		this.errorCode = errorCode;
		
	}

	public CommunicationException(String arg0, ErrorCode errorCode) {
		super(arg0);
		this.errorCode = errorCode;
	}

	public CommunicationException(Throwable arg0,ErrorCode errorCode) {
		super(arg0);
		this.errorCode = errorCode;
	}

	public CommunicationException(String arg0, Throwable arg1, ErrorCode errorCode) {
		super(arg0, arg1);
		this.errorCode = errorCode;
	}
	
	public CommunicationException(Throwable arg1, int nackCode) {
		super(arg1);
		this.errorCode = ErrorCode.NACK_RESPONSE;
		this.nackCode = nackCode;
	}
	
	public CommunicationException(String arg0, Throwable arg1, int nakCode) {
		super(arg0, arg1);
		this.nackCode = nakCode;
		this.errorCode = ErrorCode.NACK_RESPONSE;
	}
	
	public CommunicationException(String arg0, int nakCode, boolean fatalError) {
		super(arg0);
		this.nackCode = nakCode;
		this.errorCode = ErrorCode.NACK_RESPONSE;
		this.fatalError = fatalError;
	}
	
	public CommunicationException(String arg0, Throwable arg1, int nakCode, boolean fatalError) {
		super(arg0, arg1);
		this.nackCode = nakCode;
		this.errorCode = ErrorCode.NACK_RESPONSE;
		this.fatalError = fatalError;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public int getNackCode() {
		return nackCode;
	}

	public boolean isFatalError() {
		return fatalError;
	}

	public void setFatalError(boolean fatalError) {
		this.fatalError = fatalError;
	}
}
