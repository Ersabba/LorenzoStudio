package com.ericsson.urm.exceptions;


public class CommunicationException extends Throwable {

	private static final long serialVersionUID = 1L;
	
	public static enum ErrorCode {
		UNCLASSIFIED_ERROR,
		COMMUNICATION_TIMEOUT,
		COMMUNICATION_ERROR,
		UNKNOWN_HOST;
	}
	
	private ErrorCode errorCode = ErrorCode.UNCLASSIFIED_ERROR;

	public CommunicationException() {
		this(null,null,ErrorCode.UNCLASSIFIED_ERROR);
	}

	public CommunicationException(String arg0) {
		this(arg0,null,ErrorCode.UNCLASSIFIED_ERROR);
	}

	public CommunicationException(Throwable arg0) {
		this(null,arg0,ErrorCode.UNCLASSIFIED_ERROR);
	}

	public CommunicationException(String arg0, Throwable arg1) {
		this(arg0, arg1,ErrorCode.UNCLASSIFIED_ERROR);
	}
	

	public CommunicationException(ErrorCode errorCode) {
		this(null,null,errorCode);
		
	}

	public CommunicationException(String arg0,ErrorCode errorCode) {
		this(arg0,null,errorCode);
	}

	public CommunicationException(Throwable arg0,ErrorCode errorCode) {
		this(null,arg0,errorCode);
	}

	public CommunicationException(String arg0, Throwable arg1, ErrorCode errorCode) {
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
