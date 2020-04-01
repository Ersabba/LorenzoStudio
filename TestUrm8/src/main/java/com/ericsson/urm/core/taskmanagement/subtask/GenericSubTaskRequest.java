package com.ericsson.urm.core.taskmanagement.subtask;

import java.io.Serializable;

public class GenericSubTaskRequest implements ISubTaskRequest {
	
	private static final long serialVersionUID = -1L;
	private String id;
	private Serializable subtaskInput = null;
	private long delay = 0;
	private int numRetry = 0;
	
	
	public GenericSubTaskRequest() {
		super();
	}
	
	public GenericSubTaskRequest(String id) {
		super();
		this.id = id;
	}

	public GenericSubTaskRequest(String id, Serializable data) {
		this(id);
		this.subtaskInput = data;	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Serializable getSubtaskInput() {
		return subtaskInput;
	}

	public void setSubtaskInput(Serializable subtaskInput) {
		this.subtaskInput = subtaskInput;
	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	public int getNumRetry() {
		return numRetry;
	}

	public void setNumRetry(int numRetry) {
		this.numRetry = numRetry;
	}

	public boolean validate() {
		return id!=null;
	}
}
