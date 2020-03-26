package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class StatusAcqFileDqf implements Serializable {

	private StatusAcqFileDqfId id=null;
	private Date acquisitionDate=null;
	private Date fileDate=null;
	private boolean success=false;
	
	
	
	
	public StatusAcqFileDqf() {
		super();
	}
	public StatusAcqFileDqf(StatusAcqFileDqfId id) {
		super();
		this.id = id;
	}
	public StatusAcqFileDqfId getId() {
		return id;
	}
	public void setId(StatusAcqFileDqfId id) {
		this.id = id;
	}
	public Date getAcquisitionDate() {
		return acquisitionDate;
	}
	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}
	public Date getFileDate() {
		return fileDate;
	}
	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	
}
