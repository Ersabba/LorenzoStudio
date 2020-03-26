package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.device.driver.loadcurves.LoadCurveComponentType;
import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class CrzLoadCurveMancanti implements Serializable {
	private static final long serialVersionUID = -1;
	

	private String  componente;
	private Date 	dataCurva;
	private Integer periodo;	           
	
	public CrzLoadCurveMancanti() {}

	public CrzLoadCurveMancanti(String componente, Date dataCurva,
			Integer periodo) {
		super();
		this.componente = componente;
		this.dataCurva = dataCurva;
		this.periodo = periodo;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}

	public Date getDataCurva() {
		return dataCurva;
	}

	public void setDataCurva(Date dataCurva) {
		this.dataCurva = dataCurva;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((componente == null) ? 0 : componente.hashCode());
		result = prime * result
				+ ((dataCurva == null) ? 0 : dataCurva.hashCode());
		result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
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
		CrzLoadCurveMancanti other = (CrzLoadCurveMancanti) obj;
		if (componente == null) {
			if (other.componente != null)
				return false;
		} else if (!componente.equals(other.componente))
			return false;
		if (dataCurva == null) {
			if (other.dataCurva != null)
				return false;
		} else if (!dataCurva.equals(other.dataCurva))
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CrzLoadCurveMancanti [componente=" + componente
				+ ", dataCurva=" + dataCurva + ", periodo=" + periodo + "]";
	}

	

	
}
