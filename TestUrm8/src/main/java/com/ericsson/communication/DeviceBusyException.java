package com.ericsson.communication;

public class DeviceBusyException extends Exception {
	public DeviceBusyException() {
	}
	
	public DeviceBusyException(String msg) {
		super(msg);
	}
	
	public DeviceBusyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
