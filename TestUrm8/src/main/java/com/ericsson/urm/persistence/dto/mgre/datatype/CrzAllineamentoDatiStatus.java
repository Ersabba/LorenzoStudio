package com.ericsson.urm.persistence.dto.mgre.datatype;

public enum CrzAllineamentoDatiStatus {
	EXECUTED,
	FAILED,
	WAITING;
	
	public static CrzAllineamentoDatiStatus fromString(String status) {
		if(status!=null) {
			for(CrzAllineamentoDatiStatus curr : CrzAllineamentoDatiStatus.values()) {
				if(curr.toString().equalsIgnoreCase(status)) {
					return curr;
				}
			}
		}
		return null;
	}
}
