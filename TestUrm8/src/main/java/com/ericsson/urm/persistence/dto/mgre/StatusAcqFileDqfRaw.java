package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class StatusAcqFileDqfRaw implements Serializable {

	private StatusAcqFileDqfRawId id=null;
	private String concentratorId=null;
	private Date dateRequest=null;
	private String dqfFileName=null;
	private int result;
	
	
	
	
	public StatusAcqFileDqfRaw() {
		super();
	}
	public StatusAcqFileDqfRaw(StatusAcqFileDqfRawId id) {
		super();
		this.id = id;
	}
	public StatusAcqFileDqfRawId getId() {
		return id;
	}
	public void setId(StatusAcqFileDqfRawId id) {
		this.id = id;
	}
	public String getDqfFileName() {
		return dqfFileName;
	}
	public void setDqfFileName(String dqfFileName) {
		this.dqfFileName = dqfFileName;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getConcentratorId() {
		return concentratorId;
	}
	public void setConcentratorId(String concentratorId) {
		this.concentratorId = concentratorId;
	}
	public Date getDateRequest() {
		return dateRequest;
	}
	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}
	
}
