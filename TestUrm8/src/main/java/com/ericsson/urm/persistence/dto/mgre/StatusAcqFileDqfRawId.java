package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.sql.Date;

public class StatusAcqFileDqfRawId implements Serializable {

	private String idFileDqfRequest = null;
	private long taskId = 0;
	

	
	public StatusAcqFileDqfRawId() {
		super();
	}
	
	public StatusAcqFileDqfRawId(String idFileDqfRequest, long taskId) {
		super();
		this.idFileDqfRequest = idFileDqfRequest;
		this.taskId = taskId;
	}
	
	public String getIdFileDqfRequest() {
		return idFileDqfRequest;
	}

	public void setIdFileDqfRequest(String idFileDqfRequest) {
		this.idFileDqfRequest = idFileDqfRequest;
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

		StatusAcqFileDqfRawId that = (StatusAcqFileDqfRawId) o;

		if (getTaskId() != that.getTaskId()) return false;
		return getIdFileDqfRequest().equals(that.getIdFileDqfRequest());
	}

	@Override
	public int hashCode() {
		int result = getIdFileDqfRequest().hashCode();
		result = 31 * result + (int) (getTaskId() ^ (getTaskId() >>> 32));
		return result;
	}
}
