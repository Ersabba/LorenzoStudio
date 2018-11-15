package com.ericsson.mgse.persistence.dto.datatypes;

import java.io.Serializable;

public class LockTypeName implements Serializable {
	private static final long serialVersionUID = -1;
	
	public static final LockTypeName LOCAL_DIRECTORY = new LockTypeName("LOCAL_DIRECTORY");
	public static final LockTypeName REMOTE_DIRECTORY = new LockTypeName("REMOTE_DIRECTORY");

	String type;

	private LockTypeName(String type) {
		this.type = type.trim().toUpperCase();	
	}

	public static LockTypeName parse(String type) {
		if(LOCAL_DIRECTORY.type.equalsIgnoreCase(type.trim())) return LOCAL_DIRECTORY;
		
		throw new IllegalArgumentException("Unsupported LockTypeVal: " + type);
	}

	public String toString () {
		return type;	
	}
}
