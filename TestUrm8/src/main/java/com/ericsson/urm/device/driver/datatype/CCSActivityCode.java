package com.ericsson.urm.device.driver.datatype;


public enum CCSActivityCode {
	MONTHLY_ACTIVE_ABSORBED(1,0xC9),
	MONTHLY_SUPPLYED_REACTIVE_Q2Q3(2,0xCA),
	MONTHLY_REACTIVE_Q1Q4(3,0xCB),
	MONTHLY_POWER_ACTIVE_ABSORBED(4,0xCC);
	
	private int type;
	private byte code;
	
	private CCSActivityCode(int type, int code) {
		this.type = type;
		this.code = (byte)code;
	}

	public int getType() {
		return type;
	}

	public byte getCode() {
		return code;
	}
	
	public static CCSActivityCode asType(String type) {
		for(CCSActivityCode curr : CCSActivityCode.values()) {
			if(curr.toString().equalsIgnoreCase(type)) {
				return curr;
			}
		}
		throw new IllegalArgumentException("Unknown activity code type:"+type);
	}
	
	public static CCSActivityCode asType(int type) {
		for(CCSActivityCode curr : CCSActivityCode.values()) {
			if(curr.type == type) {
				return curr;
			}
		}
		throw new IllegalArgumentException("Unknown activity code type:"+type+" valid 1 to 3");
	}
}
