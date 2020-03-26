package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;
import java.util.Date;


public class LoadCurvesState implements Serializable {
	
	private static final long serialVersionUID = -1L;
	
	private Date referenceDate;
	private int integrationPeriod;
	private String state;
	private String energyComponentId;
	private String ccsId;
	

	public LoadCurvesState() {

	}
		
	public String getCcsId() {
		return ccsId;
	}

	public void setCcsId(String ccsId) {
		this.ccsId = ccsId;
	}

	public Date getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	public EnergyComponentId  getEnergyComponentId() {
		return energyComponentId!=null ? EnergyComponentId.parse(energyComponentId) : null;
	}

	public void setEnergyComponentId(EnergyComponentId energyComponentId) {
		this.energyComponentId = energyComponentId!=null ? energyComponentId.getEnergyId() : null;
	}

	public int getIntegrationPeriod() {
		return integrationPeriod;
	}

	public void setIntegrationPeriod(int integrationPeriod) {
		this.integrationPeriod = integrationPeriod;
	}

	public StateAcqLoadCurve getState() {
		return state!=null ? StateAcqLoadCurve.parse(state) : null;
	}

	public void setState(StateAcqLoadCurve state) {
		this.state = state!=null ? state.getState() : null;
	}
}
