package com.ericsson.mgre.biz.taskMgmt.clusteringfilenew.dto;

import java.io.Serializable;
import java.util.Date;

public class GreClusteringTaskConfigDto implements Serializable {

	private static final long serialVersionUID = -1L;

	private String idClientRequest = null;
	private Date data = null;
	private String frequenza = null; 
	private int finestraTemporale = -1;
	private Date dataInizio = null; 
	
	public GreClusteringTaskConfigDto() {
		super();
	}

	public String getIdClientRequest() {
		return idClientRequest;
	}

	public void setIdClientRequest(String idClientRequest) {
		this.idClientRequest = idClientRequest;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getFrequenza() {
		return frequenza;
	}

	public void setFrequenza(String frequenza) {
		this.frequenza = frequenza;
	}

	public int getFinestraTemporale() {
		return finestraTemporale;
	}

	public void setFinestraTemporale(int finestraTemporale) {
		this.finestraTemporale = finestraTemporale;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	
	
}
