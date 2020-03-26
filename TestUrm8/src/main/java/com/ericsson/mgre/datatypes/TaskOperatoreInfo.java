package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Date;

public class TaskOperatoreInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long taskId;
	private String state = null;
	private String expectedStartTime = null;
	private Date startTime = null;
	
	public TaskOperatoreInfo() {
		super();
	}

	public TaskOperatoreInfo(long taskId, String state,
			String expectedStartTime, Date startTime) {
		super();
		this.taskId = taskId;
		this.state = state;
		this.expectedStartTime = expectedStartTime;
		this.startTime = startTime;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getExpectedStartTime() {
		return expectedStartTime;
	}

	public void setExpectedStartTime(String expectedStartTime) {
		this.expectedStartTime = expectedStartTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	
}
