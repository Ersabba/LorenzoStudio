package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyFlowDirectionType;

public class EnergyActiveBO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String meterId;
	Date   referenceDate;
	
	private Long valueActiveGen;
	private Long valueActiveT1;
	private Long valueActiveT2;
	private Long valueActiveT3;
	private Long valueActiveT4;
	
	private EnergyFlowDirectionType flowDirectionType;
	
	
	public EnergyFlowDirectionType getFlowDirectionType() {
		return flowDirectionType;
	}
	public void setFlowDirectionType(EnergyFlowDirectionType flowDirectionType) {
		this.flowDirectionType = flowDirectionType;
	}
	
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
	public Long getValueActiveGen() {
		return valueActiveGen;
	}
	public void setValueActiveGen(Long valueActiveGen) {
		this.valueActiveGen = valueActiveGen;
	}
	public Long getValueActiveT1() {
		return valueActiveT1;
	}
	public void setValueActiveT1(Long valueActiveT1) {
		this.valueActiveT1 = valueActiveT1;
	}
	public Long getValueActiveT2() {
		return valueActiveT2;
	}
	public void setValueActiveT2(Long valueActiveT2) {
		this.valueActiveT2 = valueActiveT2;
	}
	public Long getValueActiveT3() {
		return valueActiveT3;
	}
	public void setValueActiveT3(Long valueActiveT3) {
		this.valueActiveT3 = valueActiveT3;
	}
	public Long getValueActiveT4() {
		return valueActiveT4;
	}
	public void setValueActiveT4(Long valueActiveT4) {
		this.valueActiveT4 = valueActiveT4;
	}
	
	
	
	
}
