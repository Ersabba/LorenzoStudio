package com.ericsson.mgre.interruzioni;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ericsson.urm.persistence.dto.mgre.datatype.StatoClusterCabina;

public class IbtRecordsValidationResult implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	private StatoClusterCabina stato = null;
	private List<Check> checkFailList = new ArrayList<Check>();
	
	public IbtRecordsValidationResult() {
		super();
	}
	
	public IbtRecordsValidationResult(StatoClusterCabina stato, List<Check> checkFailList) {
		this.stato = stato;
		this.checkFailList = checkFailList; 
	}
	
	public StatoClusterCabina getStato() {
		return stato;
	}
	
	public void setStato(StatoClusterCabina stato) {
		this.stato = stato;
	}
	
	public List<Check> getCheckFailList() {
		return checkFailList;
	}
	
	public void setCheckFailList(List<Check> checkFailList) {
		this.checkFailList = checkFailList;
	}
	
	public boolean isEmpty() {
		return (stato == null && (checkFailList == null || checkFailList.size() == 0));
	}

	@Override
	public String toString() {
		return "IbtRecordsValidationResult [stato=" + stato
				+ ", checkFailList=" + checkFailList + "]";
	}
}

