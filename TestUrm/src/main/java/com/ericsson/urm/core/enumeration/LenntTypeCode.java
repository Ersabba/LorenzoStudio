package com.ericsson.urm.core.enumeration;


public enum LenntTypeCode {
	P1("P1"),
	P2("P2"),
	P2_IP("P2-IP"),
	P2_SG("P2-SG"),
	UNTYPED("UNTYPED");

	private String	dbCode;

	private LenntTypeCode(String dbCode) {
		this.dbCode = dbCode;
	}

	public String getDbCode() {
		return this.dbCode;
	}
	
	public static LenntTypeCode parse(String dbCode) {
		if (dbCode == null)
			return null;
		for (LenntTypeCode tu : LenntTypeCode.values())
			if (tu.dbCode.equalsIgnoreCase(dbCode))
				return tu;
		
		throw new IllegalArgumentException("Invalid dbCode:" + dbCode);
	}
}
