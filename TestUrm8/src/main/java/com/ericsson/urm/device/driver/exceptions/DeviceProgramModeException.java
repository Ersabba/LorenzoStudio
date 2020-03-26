package com.ericsson.urm.device.driver.exceptions;

public class DeviceProgramModeException extends Exception {

	private static final long serialVersionUID = -1L;

	private String mode = null;
	private long taskId = 0;
	
	public DeviceProgramModeException() {
		// TODO Auto-generated constructor stub
	}

	public DeviceProgramModeException(String message, String mode, long taskId) {
		super(message);
		this.mode = mode;
		this.taskId = taskId;
	}

	public DeviceProgramModeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DeviceProgramModeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	
	

}
