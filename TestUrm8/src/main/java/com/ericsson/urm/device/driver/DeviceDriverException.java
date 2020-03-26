package com.ericsson.urm.device.driver;

public class DeviceDriverException extends Exception {

	private static final long serialVersionUID = -1L;

	private int causeType = GENERIC_ERROR_TYPE;

	public static int GENERIC_ERROR_TYPE = 0;
	public static int ERROR_FROM_DEVICE_TYPE = 1;
	public static int COMMUNICATION_ERROR_TYPE = 2;
	public static int DEVICE_SETTINGS = 3;
	public static int DATA_PROCESSING_FAILED = 4;
	public static int RETRY_TERMINATED = 5;
	

	public DeviceDriverException() {		
	}

	public DeviceDriverException(int causeType, String arg0) {
		super(arg0);
		this.causeType=causeType;
	}

	public DeviceDriverException(int causeType, Throwable arg0) {
		super(arg0);
		this.causeType=causeType;
		
	}

	public DeviceDriverException(int causeType, String arg0, Throwable arg1) {
		super(arg0, arg1);
		this.causeType=causeType;
	}

	public int getCauseType() {
		return causeType;
	}

	public void setCauseType(int causeType) {
		this.causeType = causeType;
	}

}
