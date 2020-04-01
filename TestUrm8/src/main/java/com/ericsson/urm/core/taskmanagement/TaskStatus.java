package com.ericsson.urm.core.taskmanagement;


public enum TaskStatus {
	
	NEW, RUNNING, FAILED(true), FINISHED(true), ABORTED(true), STUCK(true);
	
	private boolean endStatus;
	
	private TaskStatus() {
		this.endStatus = false;
	}
	private TaskStatus(boolean endStatus) {
		this.endStatus = endStatus;
	}
	
	public boolean isEndStatus() {
		return endStatus;
	}
	
	public static TaskStatus parser(String status) {
		for(TaskStatus ts: TaskStatus.values()) {
			if(ts.toString().equalsIgnoreCase(status)) {
				return ts;
			}
		}
		throw new IllegalArgumentException("Unknown status:"+status);
	}
	
}
