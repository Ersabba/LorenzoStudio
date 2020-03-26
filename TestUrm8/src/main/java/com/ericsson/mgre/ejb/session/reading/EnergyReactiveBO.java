package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyFlowDirectionType;

public class EnergyReactiveBO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String meterId;
	private Date   referenceDate;
	
	private Long valueInductiveGen;
	private Long valueCapacitiveGen;
	
	private Long valueInductiveT1;
	private Long valueInductiveT2;
	private Long valueInductiveT3;
	private Long valueInductiveT4;
	
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

	public Long getValueInductiveGen() {
		return valueInductiveGen;
	}

	public void setValueInductiveGen(Long valueInductiveGen) {
		this.valueInductiveGen = valueInductiveGen;
	}

	public Long getValueCapacitiveGen() {
		return valueCapacitiveGen;
	}

	public void setValueCapacitiveGen(Long valueCapacitiveGen) {
		this.valueCapacitiveGen = valueCapacitiveGen;
	}

	public Long getValueInductiveT1() {
		return valueInductiveT1;
	}

	public void setValueInductiveT1(Long valueInductiveT1) {
		this.valueInductiveT1 = valueInductiveT1;
	}

	public Long getValueInductiveT2() {
		return valueInductiveT2;
	}

	public void setValueInductiveT2(Long valueInductiveT2) {
		this.valueInductiveT2 = valueInductiveT2;
	}

	public Long getValueInductiveT3() {
		return valueInductiveT3;
	}

	public void setValueInductiveT3(Long valueInductiveT3) {
		this.valueInductiveT3 = valueInductiveT3;
	}

	public Long getValueInductiveT4() {
		return valueInductiveT4;
	}

	public void setValueInductiveT4(Long valueInductiveT4) {
		this.valueInductiveT4 = valueInductiveT4;
	}

	public EnergyFlowDirectionType getFlowDirectionType() {
		return flowDirectionType;
	}

	public void setFlowDirectionType(EnergyFlowDirectionType flowDirectionType) {
		this.flowDirectionType = flowDirectionType;
	}

	
}
