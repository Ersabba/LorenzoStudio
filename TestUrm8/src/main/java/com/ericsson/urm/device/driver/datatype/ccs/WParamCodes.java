package com.ericsson.urm.device.driver.datatype.ccs;

public enum WParamCodes {
	ERR_NOT_VALID_CMD(0xffff),
	ERR_LENNT_COMM_ERROR(0xfffe),
	ERR_LENNT_UNKNOWN(0xfffd),
	STANDBY_NON_ATTIVO(0xffe6), 
	STANDBY_GIA_ATTIVO(0xffe5),
	STANDBY_IN_ESEC(0xffe4),
	STANDBY_SETTATO(0xffe3),
	WRONG_TOKEN_SESSION(0xfff1);
	
	private int paramCode;
	
	private WParamCodes(int paramCode) {
		this.paramCode = paramCode;
	}
	
	public int getParamCode() {
		return paramCode;
	}
	
	public static WParamCodes valueOf(int paramCode) {
		for(WParamCodes curr : WParamCodes.values()) {
			if(curr.paramCode == paramCode) {
				return curr;
			}
		}
		return null;
	}
}
