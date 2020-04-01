package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;


public class StatisticheLettureLennt implements Serializable {

	private static final long	serialVersionUID	= -1L;

	private long	taskId;
	private String  taskCode;
	private Date	executionTimestamp;
	private int     totNumLennt;
	private int     complSuccNumLennt;
	private int     partSuccNumLennt;
	private int     failNumLennt;
	
	public StatisticheLettureLennt() {
		
	}

	public StatisticheLettureLennt(long taskId, String taskCode,
			Date executionTimestamp, int totNumLennt, int complSuccNumLennt,
			int partSuccNumLennt, int failNumLennt) {
		super();
		this.taskId = taskId;
		this.taskCode = taskCode;
		this.executionTimestamp = executionTimestamp;
		this.totNumLennt = totNumLennt;
		this.complSuccNumLennt = complSuccNumLennt;
		this.partSuccNumLennt = partSuccNumLennt;
		this.failNumLennt = failNumLennt;
	}



	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public Date getExecutionTimestamp() {
		return executionTimestamp;
	}

	public void setExecutionTimestamp(Date executionTimestamp) {
		this.executionTimestamp = executionTimestamp;
	}

	public int getTotNumLennt() {
		return totNumLennt;
	}

	public void setTotNumLennt(int totNumLennt) {
		this.totNumLennt = totNumLennt;
	}

	public int getComplSuccNumLennt() {
		return complSuccNumLennt;
	}

	public void setComplSuccNumLennt(int complSuccNumLennt) {
		this.complSuccNumLennt = complSuccNumLennt;
	}

	public int getPartSuccNumLennt() {
		return partSuccNumLennt;
	}

	public void setPartSuccNumLennt(int partSuccNumLennt) {
		this.partSuccNumLennt = partSuccNumLennt;
	}

	public int getFailNumLennt() {
		return failNumLennt;
	}

	public void setFailNumLennt(int failNumLennt) {
		this.failNumLennt = failNumLennt;
	}
	
	
	
}
