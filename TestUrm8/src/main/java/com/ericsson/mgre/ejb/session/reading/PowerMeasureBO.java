package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentType;
import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyFlowDirectionType;
import com.ericsson.urm.persistence.dto.mgre.datatype.IntegrationPeriodType;

public class PowerMeasureBO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String meterId;
	private Date   referenceDate;
	
	private Long valueT1;
	private Long valueT2;
	private Long valueT3;
	private Long valueT4;
	
	private Date referenceDateT1 = null;
	private Date referenceDateT2 = null;
	private Date referenceDateT3 = null;
	private Date referenceDateT4 = null;

	private IntegrationPeriodType integrationPeriodType;
	
	private EnergyComponentType energyComponentType;
	
	private EnergyFlowDirectionType flowDirectionType;

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public Date getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	public Long getValueT1() {
		return valueT1;
	}

	public void setValueT1(Long valueT1) {
		this.valueT1 = valueT1;
	}

	public Long getValueT2() {
		return valueT2;
	}

	public void setValueT2(Long valueT2) {
		this.valueT2 = valueT2;
	}

	public Long getValueT3() {
		return valueT3;
	}

	public void setValueT3(Long valueT3) {
		this.valueT3 = valueT3;
	}

	public Long getValueT4() {
		return valueT4;
	}

	public void setValueT4(Long valueT4) {
		this.valueT4 = valueT4;
	}

	public Date getReferenceDateT1() {
		return referenceDateT1;
	}

	public void setReferenceDateT1(Date referenceDateT1) {
		this.referenceDateT1 = referenceDateT1;
	}

	public Date getReferenceDateT2() {
		return referenceDateT2;
	}

	public void setReferenceDateT2(Date referenceDateT2) {
		this.referenceDateT2 = referenceDateT2;
	}

	public Date getReferenceDateT3() {
		return referenceDateT3;
	}

	public void setReferenceDateT3(Date referenceDateT3) {
		this.referenceDateT3 = referenceDateT3;
	}

	public Date getReferenceDateT4() {
		return referenceDateT4;
	}

	public void setReferenceDateT4(Date referenceDateT4) {
		this.referenceDateT4 = referenceDateT4;
	}

	public IntegrationPeriodType getIntegrationPeriodType() {
		return integrationPeriodType;
	}

	public void setIntegrationPeriodType(IntegrationPeriodType integrationPeriodType) {
		this.integrationPeriodType = integrationPeriodType;
	}

	public EnergyComponentType getEnergyComponentType() {
		return energyComponentType;
	}

	public void setEnergyComponentType(EnergyComponentType energyComponentType) {
		this.energyComponentType = energyComponentType;
	}

	public EnergyFlowDirectionType getFlowDirectionType() {
		return flowDirectionType;
	}

	public void setFlowDirectionType(EnergyFlowDirectionType flowDirectionType) {
		this.flowDirectionType = flowDirectionType;
	}

	
	
	
	
}
