package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class StatusAcqFile implements Serializable {

	private StatusAcqFileId id=null;
	private String concentratorId=null;
	private Date dateRequest=null;
	private String fileName=null;
	private int result;
	
	
	public StatusAcqFile() {
		super();
	}
	public StatusAcqFile(StatusAcqFileId id) {
		super();
		this.id = id;
	}
	public StatusAcqFileId getId() {
		return id;
	}
	public void setId(StatusAcqFileId id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
