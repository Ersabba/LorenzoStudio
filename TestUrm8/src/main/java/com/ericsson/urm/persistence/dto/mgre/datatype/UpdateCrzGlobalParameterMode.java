package com.ericsson.urm.persistence.dto.mgre.datatype;

public enum UpdateCrzGlobalParameterMode {
	ALL_CRZ("TUTTI"),
	LIST_CRZ("LISTA");
	
	private String dbValue;
	
	private UpdateCrzGlobalParameterMode(String dbValue) {
		this.dbValue = dbValue;
	}
	
	public String getDbValue() {
		return dbValue;
	}
	
	public static UpdateCrzGlobalParameterMode fromString(String mode) {
		return parser(mode, true);
	}
	
	public static UpdateCrzGlobalParameterMode parser(String mode) {
		return parser(mode, false);
	}
	
	private static UpdateCrzGlobalParameterMode parser(String mode, boolean forced) {
		for(UpdateCrzGlobalParameterMode curr : UpdateCrzGlobalParameterMode.values()) {
			if(curr.toString().equalsIgnoreCase(mode) || curr.dbValue.equalsIgnoreCase(mode)) {
				return curr;
			}
		}
		if(!forced) {
			throw new IllegalArgumentException("Unknown CrzConfigParamName with mode: "+mode);
		}
		return null;
	}

}