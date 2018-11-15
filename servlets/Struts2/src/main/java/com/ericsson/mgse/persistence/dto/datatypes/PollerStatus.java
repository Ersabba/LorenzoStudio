package com.ericsson.mgse.persistence.dto.datatypes;

public enum PollerStatus {

	ENABLED("ENABLED"),
	DISABLED("DISABLED");
	
	private String status;
	
	private PollerStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public static PollerStatus parse(String status) {
		if (status == null)
			return null;
		for (PollerStatus t : PollerStatus.values())
			if (t.status.equalsIgnoreCase(status))
				return t;
		
		throw new IllegalArgumentException("Invalid Poller Status:" + status);
	}

	boolean isEnabled(){
		return status=="ENABLED"?true:false;
	}
}
