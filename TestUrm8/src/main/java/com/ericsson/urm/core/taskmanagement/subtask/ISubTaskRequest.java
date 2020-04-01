package com.ericsson.urm.core.taskmanagement.subtask;

import java.io.Serializable;

public interface ISubTaskRequest extends Serializable {
	public String getId();
	public long getDelay();
	public int getNumRetry();
	public Serializable getSubtaskInput();
	public boolean validate();
}
