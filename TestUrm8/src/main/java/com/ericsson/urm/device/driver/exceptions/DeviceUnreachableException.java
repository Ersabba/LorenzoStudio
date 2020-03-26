package com.ericsson.urm.device.driver.exceptions;

import com.ericsson.urm.device.driver.CommunicationException;

public class DeviceUnreachableException extends CommunicationException {

	private static final long serialVersionUID = -1L;

	
	public DeviceUnreachableException() {
		super();
	}

	public DeviceUnreachableException(String arg0) {
		super(arg0);
	}

	public DeviceUnreachableException(Throwable arg0) {
		super(arg0);
	}

	public DeviceUnreachableException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	

	public DeviceUnreachableException(ErrorCode errorCode) {
		super(errorCode);	
	}

	public DeviceUnreachableException(String arg0,ErrorCode errorCode) {
		super(arg0,errorCode);
	}

	public DeviceUnreachableException(Throwable arg0, ErrorCode errorCode) {
		super(arg0, errorCode);
	}

	public DeviceUnreachableException(String arg0, Throwable arg1, ErrorCode errorCode) {
		super(arg0, arg1,errorCode);
	}
}
