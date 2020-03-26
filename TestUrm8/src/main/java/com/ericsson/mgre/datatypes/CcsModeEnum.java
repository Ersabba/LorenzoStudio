package com.ericsson.mgre.datatypes;

public enum CcsModeEnum {

	STANDBY("STANDBY"),
	BER("BER");
	
	
	private String value;
	
	private CcsModeEnum(String mode){
		this.value = mode;
	}
	
	
	public static CcsModeEnum parse(String mode)	{	
		for (CcsModeEnum curr : CcsModeEnum.values()) {
			if(curr.value.equalsIgnoreCase(mode)) { return curr; }
			}
		
		throw new IllegalArgumentException ("CcsModeEnum: unsupported mode " + mode);
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}

	
}
