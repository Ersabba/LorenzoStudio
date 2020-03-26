package com.ericsson.mgre.datatypes;

/**
 * 
 * @author sys0
 * Questa enumeration serve per descrivere lo stato 
 * di un file già acquisito e presente nel repository locale.
 * 
 */

public enum LocalRepoFileStatus {
	
	PROCESSED("PROCESSED"),
	TO_BE_PROCESSED("TO_BE_PROCESSED");
	
	private String innerDesc;

	private LocalRepoFileStatus(String innerDesc) {
		this.innerDesc = innerDesc;
	}

	public String getIndex() {
		return innerDesc;
	}
}
