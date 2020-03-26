package com.ericsson.urm.device.driver.exceptions;

import com.ericsson.urm.device.driver.CommunicationException;

public class DeviceCommunicationException extends CommunicationException {

	private static final long serialVersionUID = -1L;

	public DeviceCommunicationException() {
		super(ErrorCode.UNCLASSIFIED_ERROR);
	}

	public DeviceCommunicationException(CommunicationException e) {
		super(e.getMessage(),e,e.getErrorCode());
	}
	
	public DeviceCommunicationException(String message) {
		super(message,ErrorCode.UNCLASSIFIED_ERROR);
	}

	public DeviceCommunicationException(Throwable cause) {
		super(cause,ErrorCode.UNCLASSIFIED_ERROR);
	}

	public DeviceCommunicationException(String message, Throwable cause) {
		super(message, cause, ErrorCode.UNCLASSIFIED_ERROR);
	}
	

	public DeviceCommunicationException(ErrorCode errorCode) {
		super(errorCode);
	}

	public DeviceCommunicationException(String message,ErrorCode errorCode) {
		super(message,errorCode);
	}

	public DeviceCommunicationException(Throwable cause,ErrorCode errorCode) {
		super(cause,errorCode);
	}

	public DeviceCommunicationException(String message, Throwable cause, ErrorCode errorCode) {
		super(message, cause, errorCode);
	}
}
