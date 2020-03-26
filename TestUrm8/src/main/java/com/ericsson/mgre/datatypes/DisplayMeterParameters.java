package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DisplayMeterParameters implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idClientRequest = null;
	private Hashtable meterDataTable;
	
	public DisplayMeterParameters() {
		meterDataTable = new Hashtable();
	}

	public DisplayMeterParameters(String idClientRequest, Hashtable meterDataTable) {
		super();
		this.idClientRequest = idClientRequest;
		this.meterDataTable = meterDataTable;
	}

	public String getIdClientRequest() {
		return idClientRequest;
	}

	public void setIdClientRequest(String idClientRequest) {
		this.idClientRequest = idClientRequest;
	}

	public Hashtable getMeterDataTable() {
		return meterDataTable;
	}

	public void setMeterDataTable(Hashtable meterDataTable) {
		this.meterDataTable = meterDataTable;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idClientRequest == null) ? 0 : idClientRequest.hashCode());
		result = prime * result
				+ ((meterDataTable == null) ? 0 : meterDataTable.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisplayMeterParameters other = (DisplayMeterParameters) obj;
		if (idClientRequest == null) {
			if (other.idClientRequest != null)
				return false;
		} else if (!idClientRequest.equals(other.idClientRequest))
			return false;
		if (meterDataTable == null) {
			if (other.meterDataTable != null)
				return false;
		} else if (!meterDataTable.equals(other.meterDataTable))
			return false;
		return true;
	}	
}
