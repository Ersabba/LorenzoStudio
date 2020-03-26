package com.ericsson.urm.device.driver.datatype;

import java.io.Serializable;

public class DeviceCommandResult implements Serializable {
	

	private static final long serialVersionUID = -1L;

	public static enum ErrorCode {
		UNCLASSIFIED_ERROR,
		DEVICE_BUSY,
		COMMUNICATION_TIMEOUT,
		COMMUNICATION_ERROR,
		ERROR_FROM_DEVICE,
		LOST_CONNECTION,
		UNKNOWN_HOST;
	}

	public static enum ResultCode {
		SUCCESS,
		FAILED;
	}
	
	private ResultCode resultCode = null;
	private ErrorCode errorCode = null;
	private String message = null;
	private Integer errorDeviceCode = null;
	
	
	public DeviceCommandResult() {
		errorCode = ErrorCode.UNCLASSIFIED_ERROR;
	}
	
	public DeviceCommandResult(ResultCode resultCode, ErrorCode errorCode, Integer errorDeviceCode, String message) {
		super();
		this.resultCode = resultCode;
		this.errorCode = errorCode;
		this.errorDeviceCode = errorDeviceCode;
		this.message = message;
	}
	
	public DeviceCommandResult(ResultCode resultCode, ErrorCode errorCode,String message) {
		
		this(resultCode,errorCode, null, message);
	}

	
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}
	
	public Integer getErrorDeviceCode() {
		return errorDeviceCode;
	}

	public void setErrorDeviceCode(Integer errorDeviceCode) {
		this.errorDeviceCode = errorDeviceCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DeviceCommandResult [resultCode=" + resultCode + ", errorCode="
				+ errorCode + ", message=" + message + ", errorDeviceCode="
				+ errorDeviceCode + "]";
	}
	
	
	
}
