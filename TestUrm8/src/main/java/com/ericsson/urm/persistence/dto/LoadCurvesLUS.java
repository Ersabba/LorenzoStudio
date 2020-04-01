package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;


public class LoadCurvesLUS implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private LoadCurvesLUSId		id;
	private Date				acquisitionDate;
	private Short				integrationPeriod;
	private Long				componentValue;
	private Date				exportTimestamp;

	public LoadCurvesLUSId getId() {
		return id;
	}

	public void setId(LoadCurvesLUSId id) {
		this.id = id;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public Short getIntegrationPeriod() {
		return integrationPeriod;
	}

	public void setIntegrationPeriod(Short integrationPeriod) {
		this.integrationPeriod = integrationPeriod;
	}

	public Long getComponentValue() {
		return componentValue;
	}

	public void setComponentValue(Long componentValue) {
		this.componentValue = componentValue;
	}

	public Date getExportTimestamp() {
		return exportTimestamp;
	}

	public void setExportTimestamp(Date exportTimestamp) {
		this.exportTimestamp = exportTimestamp;
	}
}
