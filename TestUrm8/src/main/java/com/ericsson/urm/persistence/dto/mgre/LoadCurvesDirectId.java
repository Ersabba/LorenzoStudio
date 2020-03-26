package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class LoadCurvesDirectId implements Serializable {
	private static final long serialVersionUID = -1;
	
	private Date 	dataCurva;
	private String	matricolaLenntCliente;
	private int 	numPeriodo;	           
	private String  componentId;
	
	public LoadCurvesDirectId() {}

	
	public LoadCurvesDirectId(Date dataCurva, String matricolaLenntCliente,
			int numPeriodo, EnergyComponentId energyComponentId) {
		super();
		this.dataCurva = dataCurva;
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.numPeriodo = numPeriodo;
		this.componentId = energyComponentId.toString();
	}

	public Date getDataCurva() {
		return dataCurva;
	}
	public void setDataCurva(Date dataCurva) {
		this.dataCurva = dataCurva;
	}
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public int getNumPeriodo() {
		return numPeriodo;
	}
	public void setNumPeriodo(int numPeriodo) {
		this.numPeriodo = numPeriodo;
	}
	
	public EnergyComponentId getComponentId() {
		return componentId != null ? EnergyComponentId.parse(componentId) : null;
	}

	public void setComponentId(EnergyComponentId energyComponentId) {
		ArgumentsCheckerUtil.checkNull(energyComponentId, "energyComponentId");
		this.componentId = energyComponentId.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((componentId == null) ? 0 : componentId.hashCode());
		result = prime * result
				+ ((dataCurva == null) ? 0 : dataCurva.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result + numPeriodo;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LoadCurvesDirectId))
			return false;
		LoadCurvesDirectId other = (LoadCurvesDirectId) obj;
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
		if (numPeriodo != other.numPeriodo)
			return false;
		return true;
	}

	
}
