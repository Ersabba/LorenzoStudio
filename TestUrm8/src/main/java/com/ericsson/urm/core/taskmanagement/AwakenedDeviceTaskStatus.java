package com.ericsson.urm.core.taskmanagement;

import java.util.EnumSet;
import java.util.Set;

public enum AwakenedDeviceTaskStatus {
	
	WAITING, // The task is waiting for the first execution 
	IN_PROGRESS, 
	RESTARTING_AFTER_FAILURE, // It should have the same behavior as "waiting" with the difference that the task, executed at least once, has failed and can be repeated from the beginning
	COMPLETED(true), CANCELLED(true), EXPIRED(true), FAILED(true);
	
	private boolean endStatus;
	
	private AwakenedDeviceTaskStatus() {
		this.endStatus = false;
	}
	private AwakenedDeviceTaskStatus(boolean endStatus) {
		this.endStatus = endStatus;
	}
	
	public boolean isEndStatus() {
		return endStatus;
	}
	
	public static AwakenedDeviceTaskStatus fromString(String status) {
		if(status!=null) {
			for(AwakenedDeviceTaskStatus ts: AwakenedDeviceTaskStatus.values()) {
				if(ts.toString().equalsIgnoreCase(status)) {
					return ts;
				}
			}
		}
		return null;	
	}
	
	public static AwakenedDeviceTaskStatus parser(String status) {
		AwakenedDeviceTaskStatus instance = fromString(status);
		if(instance==null) {
			throw new IllegalArgumentException("Unknown status:"+status);
		}
		return instance; 
	}
	
	public static Set<AwakenedDeviceTaskStatus> getTerminalStates() {
		Set<AwakenedDeviceTaskStatus> terminalStates = EnumSet.noneOf(AwakenedDeviceTaskStatus.class);
		for(AwakenedDeviceTaskStatus ts: AwakenedDeviceTaskStatus.values()) {
			if( ts.isEndStatus() ) {
				terminalStates.add(ts);
			}
		}
		return terminalStates;
	}
	
	public static Set<AwakenedDeviceTaskStatus> getNotTerminalStates() {
		Set<AwakenedDeviceTaskStatus> terminalStates = EnumSet.noneOf(AwakenedDeviceTaskStatus.class);
		for(AwakenedDeviceTaskStatus ts: AwakenedDeviceTaskStatus.values()) {
			if( !ts.isEndStatus() ) {
				terminalStates.add(ts);
			}
		}
		return terminalStates;
	}
	
}
