package com.ericsson.mgre.datatypes.quality;

import java.io.Serializable;
import java.util.Date;

public class QualityRequestBO implements Serializable {

	private static final long serialVersionUID = 1L;

	String  IdRequest;
	String	concentratorId;
	Date	requestDate;
	
	
	
	public QualityRequestBO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public QualityRequestBO(String idRequest, String concentratorId,
			Date requestDate) {
		IdRequest = idRequest;
		this.concentratorId = concentratorId;
		this.requestDate = requestDate;
	}

	public String getIdRequest() {
		return IdRequest;
	}
	public void setIdRequest(String idRequest) {
		IdRequest = idRequest;
	}
	public String getConcentratorId() {
		return concentratorId;
	}
	public void setConcentratorId(String concentratorId) {
		this.concentratorId = concentratorId;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	
	
}
