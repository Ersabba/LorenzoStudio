package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class StatusAcqFileId implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private String idFileRequest = null;
	private long taskId = 0;
	
	
	public StatusAcqFileId() {
		super();
	}
	
	public StatusAcqFileId(String idFileRequest, long taskId) {
		super();
		this.idFileRequest = idFileRequest;
		this.taskId = taskId;
	}
	
	public String getIdFileRequest() {
		return idFileRequest;
	}

	public void setIdFileRequest(String idFileRequest) {
		this.idFileRequest = idFileRequest;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		StatusAcqFileId that = (StatusAcqFileId) o;

		if (getTaskId() != that.getTaskId()) return false;
		return getIdFileRequest().equals(that.getIdFileRequest());
	}

	@Override
	public int hashCode() {
		int result = getIdFileRequest().hashCode();
		result = 31 * result + (int) (getTaskId() ^ (getTaskId() >>> 32));
		return result;
	}
}
