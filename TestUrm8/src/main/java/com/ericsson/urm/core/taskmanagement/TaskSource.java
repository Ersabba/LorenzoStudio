package com.ericsson.urm.core.taskmanagement;

public enum TaskSource {
	
	PERIODIC, GUI, FILE, WEBSERVICE;
	
	public static TaskSource parser(String status) {
		for(TaskSource ts: TaskSource.values()) {
			if(ts.toString().equalsIgnoreCase(status)) {
				return ts;
			}
		}
		throw new IllegalArgumentException("Unknown source:"+status);
	}
}
