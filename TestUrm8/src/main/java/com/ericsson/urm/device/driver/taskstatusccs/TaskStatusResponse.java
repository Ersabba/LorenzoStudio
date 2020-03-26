package com.ericsson.urm.device.driver.taskstatusccs;

import java.io.Serializable;

public class TaskStatusResponse implements Serializable {
	
	private static final long serialVersionUID = -1L;

	public enum CCSTaskStatus {
		
		RUNNING_TASK(0),
		STOP_RUNNING_TASK(1),
		TRYING_START_TASK_ALREADY_RUNNING(2),
		ATTEMPT_STOP_TASK_NOT_STARTED(3);
		
		private int value = -1;

		private CCSTaskStatus(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
				
		public static CCSTaskStatus valueOf(int value) {
			for(CCSTaskStatus taskStatus : CCSTaskStatus.values()) {
				if(taskStatus.value == value) {
					return taskStatus;
				}
			}
			throw new IllegalArgumentException("Unknown Task status with value:"+value);
		}
	}

	
	private CCSTaskStatus taskStatus = null;
	private String taskName = null;
	
	public CCSTaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(CCSTaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
		
}