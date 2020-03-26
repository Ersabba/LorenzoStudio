package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class StatusAcqFileDqfId implements Serializable {

	private String concentratorId=null;
	private String fileName=null;
	
	
	
	public StatusAcqFileDqfId() {
		super();
	}
	
	public StatusAcqFileDqfId(String concentratorId, String fileName) {
		super();
		this.concentratorId = concentratorId;
		this.fileName = fileName;
	}
	public String getConcentratorId() {
		return concentratorId;
	}
	public void setConcentratorId(String concentratorId) {
		this.concentratorId = concentratorId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		StatusAcqFileDqfId that = (StatusAcqFileDqfId) o;

		if (!getConcentratorId().equals(that.getConcentratorId())) return false;
		return getFileName().equals(that.getFileName());
	}

	@Override
	public int hashCode() {
		int result = getConcentratorId().hashCode();
		result = 31 * result + getFileName().hashCode();
		return result;
	}
}
