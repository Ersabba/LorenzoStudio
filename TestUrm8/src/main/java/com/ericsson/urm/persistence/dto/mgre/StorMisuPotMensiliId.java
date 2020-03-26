package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentType;
import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyFlowDirectionType;
import com.ericsson.urm.persistence.dto.mgre.datatype.IntegrationPeriodType;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class StorMisuPotMensiliId implements Serializable, Cloneable {

	private static final long serialVersionUID = -1;
	
	private String matricolaLenntCliente;
	private String type;
	private String integrationPeriod;
	private String powerType;
	private Date dataRil = null;

	public Object clone() {
		try {
			StorMisuPotMensiliId ret = (StorMisuPotMensiliId) super.clone();
			if (dataRil != null)
				ret.dataRil = (Date) dataRil.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public StorMisuPotMensiliId() {
		super();
	}

	public StorMisuPotMensiliId(String matricolaLenntCliente, String type, String integrationPeriod, String powerType, Date dataRil) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.type = type;
		this.integrationPeriod = integrationPeriod;
		this.powerType = powerType;
		this.dataRil = dataRil;
	}

	public Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public EnergyFlowDirectionType getType() {
		return EnergyFlowDirectionType.parse(type);
	}
	
	public String getTypeString() {
		return type;
	}

	public void setType(EnergyFlowDirectionType energyFlowDirectionType) {
//		ArgumentsCheckerUtil.checkNull(energyFlowDirectionType, "energyFlowDirectionType");
		this.type = energyFlowDirectionType == null ? null : energyFlowDirectionType.toString();
	}
	
	public void setTypeString(String type) {
		this.type = type;
	}

	public IntegrationPeriodType getIntegrationPeriod() {
		return IntegrationPeriodType.parse(integrationPeriod);
	}
	
	public String getIntegrationPeriodString() {
		return integrationPeriod;
	}

	public void setIntegrationPeriod(IntegrationPeriodType integrationPeriodType) {
//		ArgumentsCheckerUtil.checkNull(integrationPeriodType, "integrationPeriodType");
		this.integrationPeriod = integrationPeriodType == null ? null : integrationPeriodType.toString();
	}
	
	public void setIntegrationPeriodString(String intPeriod) {
		this.integrationPeriod = intPeriod;
	}

	public EnergyComponentType getPowerType() {
		return EnergyComponentType.parse(powerType);
	}
	
	public String getPowerTypeString() {
		return powerType;
	}

	public void setPowerType(EnergyComponentType energyComponentType) {
//		ArgumentsCheckerUtil.checkNull(energyComponentType, "energyComponentType");
		this.powerType = energyComponentType == null ? null : energyComponentType.toString();
	}
	
	public void setPowerTypeString(String powerType) {
		this.powerType = powerType;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRil == null) ? 0 : dataRil.hashCode());
		result = prime
				* result
				+ ((integrationPeriod == null) ? 0 : integrationPeriod
						.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result
				+ ((powerType == null) ? 0 : powerType.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StorMisuPotMensiliId))
			return false;
		final StorMisuPotMensiliId other = (StorMisuPotMensiliId) obj;
		if (dataRil == null) {
			if (other.dataRil != null)
				return false;
		} else if (!dataRil.equals(other.dataRil))
			return false;
		if (integrationPeriod == null) {
			if (other.integrationPeriod != null)
				return false;
		} else if (!integrationPeriod.equals(other.integrationPeriod))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (powerType == null) {
			if (other.powerType != null)
				return false;
		} else if (!powerType.equals(other.powerType))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	public String toString() {
		return "StorMisuPotMensiliId [dataRil=" + dataRil
				+ ", integrationPeriod=" + integrationPeriod
				+ ", matricolaLenntCliente=" + matricolaLenntCliente
				+ ", powerType=" + powerType + ", type=" + type + "]";
	}

	
}
