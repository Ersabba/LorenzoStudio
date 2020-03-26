package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;


public class CurvaCaricoCrzBufferId implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Date				dataCurva;
	private String				matricolaLenntCliente;
	private int					numPeriodo;
	private String				componentId;
	
	public CurvaCaricoCrzBufferId() {
		
	}

	public CurvaCaricoCrzBufferId(Date dataCurva, String matricolaLenntCliente, int numPeriodo, String componentId) {
		this.dataCurva = dataCurva;
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.numPeriodo = numPeriodo;
		this.componentId = componentId;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CurvaCaricoCrzBufferId that = (CurvaCaricoCrzBufferId) o;

		if (getNumPeriodo() != that.getNumPeriodo()) return false;
		if (!getDataCurva().equals(that.getDataCurva())) return false;
		if (!getMatricolaLenntCliente().equals(that.getMatricolaLenntCliente())) return false;
		return getComponentId().equals(that.getComponentId());
	}

	@Override
	public int hashCode() {
		int result = getDataCurva().hashCode();
		result = 31 * result + getMatricolaLenntCliente().hashCode();
		result = 31 * result + getNumPeriodo();
		result = 31 * result + getComponentId().hashCode();
		return result;
	}
}
