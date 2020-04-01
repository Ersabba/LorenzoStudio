package com.ericsson.urm.core.datatypes;

public enum LockType {
	DEVICE_DRIVER,
	CCSCONN,
	SCHEDULER,
	TASK_MANAGER,
	CCSMODE;
	
	public static LockType parse(String type) {
		for (LockType lt : LockType.values()) {
			if(lt.toString().equalsIgnoreCase(type)) { return lt; }
		}
		throw new IllegalArgumentException ("LockType: unsupported type:" + type);
	}
}
