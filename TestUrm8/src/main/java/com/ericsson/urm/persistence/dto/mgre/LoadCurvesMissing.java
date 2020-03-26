package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.device.driver.loadcurves.LoadCurveComponentType;
import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class LoadCurvesMissing implements Serializable {
	private static final long serialVersionUID = -1;
	
	private String	codConcentratore;
	private String	matricolaLenntCliente;
	private String  componentId;
	private Date 	dataCurva;
	private Integer period;	           
	
	public LoadCurvesMissing() {}

	public LoadCurvesMissing(
			String codConcentratore, 
			String matricolaLenntCliente, 
			EnergyComponentId energyComponentId,
			Date dataCurva, 
			int period) {
		super();
		this.codConcentratore = codConcentratore;
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.componentId = energyComponentId.toString();
		this.dataCurva = dataCurva;
		this.period = period;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	
	public Date getDataCurva() {
		return dataCurva;
	}
	public void setDataCurva(Date dataCurva) {
		this.dataCurva = dataCurva;
	}
	
	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getComponentId() {
		return componentId;
	}
	public void setComponentId(String componentId) {
		ArgumentsCheckerUtil.checkNull(componentId, "componentId");
		this.componentId = componentId;
	}
	
	public EnergyComponentId getEnergyComponentId() {
		return componentId != null ? EnergyComponentId.parse(componentId) : null;
	}
	
	public void setEnergyComponentId(EnergyComponentId energyComponentId) {
		ArgumentsCheckerUtil.checkNull(energyComponentId, "energyComponentId");
		this.componentId = energyComponentId.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result
				+ ((componentId == null) ? 0 : componentId.hashCode());
		result = prime * result
				+ ((dataCurva == null) ? 0 : dataCurva.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoadCurvesMissing other = (LoadCurvesMissing) obj;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (componentId == null) {
			if (other.componentId != null)
				return false;
		} else if (!componentId.equals(other.componentId))
			return false;
		if (dataCurva == null) {
			if (other.dataCurva != null)
				return false;
		} else if (!dataCurva.equals(other.dataCurva))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		return true;
	}

	
}
