package com.ericsson.urm.device.driver.standbyccs;

import java.io.Serializable;

public class StandbyResponse implements Serializable {
	
	private static final long serialVersionUID = -1L;

	public static enum ResultCode {
		SUCCESS,
		FAILED;	
	}
	
	private Integer errorCode = null;
	
	private ResultCode resultCode = ResultCode.FAILED;

	public StandbyResponse() {
		resultCode = ResultCode.FAILED;
	}
	
	public StandbyResponse(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
}
