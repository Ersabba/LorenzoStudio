package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class BonificaCCSTaskInput implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String clusteringTaskId = null;
	private Date dataIniziale = null;
	private boolean ignoraDataIniziale = false;
	private List<String> ccsList = null;
	
	
	public String getClusteringTaskId() {
		return clusteringTaskId;
	}
	public void setClusteringTaskId(String clusteringTaskId) {
		this.clusteringTaskId = clusteringTaskId;
	}
	public Date getDataIniziale() {
		return dataIniziale;
	}
	public void setDataIniziale(Date dataIniziale) {
		this.dataIniziale = dataIniziale;
	}
	public boolean isIgnoraDataIniziale() {
		return ignoraDataIniziale;
	}
	public void setIgnoraDataIniziale(boolean ignora) {
		this.ignoraDataIniziale = ignora;
	}
	public List<String> getCcsList() {
		return ccsList;
	}
	public void setCcsList(List<String> ccsList) {
		this.ccsList = ccsList;
	}


}
