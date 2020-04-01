package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;


public class LoadCurvesLUSId implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				matricolaLenntCliente;
	private Short				period;
	private Date				curveDate;
	private String				componentId;
	
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	
	public Short getPeriod() {
		return period;
	}
	
	public void setPeriod(Short period) {
		this.period = period;
	}
	
	public Date getCurveDate() {
		return curveDate;
	}
	
	public void setCurveDate(Date curveDate) {
		this.curveDate = curveDate;
	}
	
	public String getComponentId() {
		return componentId;
	}
	
	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LoadCurvesLUSId that = (LoadCurvesLUSId) o;

		if (!getMatricolaLenntCliente().equals(that.getMatricolaLenntCliente())) return false;
		if (!getPeriod().equals(that.getPeriod())) return false;
		if (!getCurveDate().equals(that.getCurveDate())) return false;
		return getComponentId().equals(that.getComponentId());
	}

	@Override
	public int hashCode() {
		int result = getMatricolaLenntCliente().hashCode();
		result = 31 * result + getPeriod().hashCode();
		result = 31 * result + getCurveDate().hashCode();
		result = 31 * result + getComponentId().hashCode();
		return result;
	}
}
