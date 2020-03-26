package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentType;
import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyFlowDirectionType;
import com.ericsson.urm.persistence.dto.mgre.datatype.IntegrationPeriodType;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class MisuPotMensiliId implements Serializable {
	
	private static final long serialVersionUID = -1;
	
	private String matricolaLenntCliente;
	private String type;
	private String integrationPeriod;
	private String powerType;

	public MisuPotMensiliId() {
		super();
	}

	public MisuPotMensiliId(String matricolaLenntCliente, String type, String integrationPeriod, String powerType) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.type = type;
		this.integrationPeriod = integrationPeriod;
		this.powerType = powerType;
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public EnergyFlowDirectionType getType() {
		return type != null ? EnergyFlowDirectionType.parse(type) : null;
	}

	public void setType(EnergyFlowDirectionType energyFlowDirectionType) {
		ArgumentsCheckerUtil.checkNull(energyFlowDirectionType, "energyFlowDirectionType");
		this.type = energyFlowDirectionType.toString();
	}

	public IntegrationPeriodType getIntegrationPeriod() {
		return integrationPeriod != null ? IntegrationPeriodType.parse(integrationPeriod) : null;
	}

	public void setIntegrationPeriod(IntegrationPeriodType integrationPeriodType) {
		ArgumentsCheckerUtil.checkNull(integrationPeriodType, "integrationPeriodType");
		this.integrationPeriod = integrationPeriodType.toString();
	}

	public EnergyComponentType getPowerType() {
		return powerType != null ? EnergyComponentType.parse(powerType) : null;
	}

	public void setPowerType(EnergyComponentType energyComponentType) {
		ArgumentsCheckerUtil.checkNull(energyComponentType, "energyComponentType");
		this.powerType = energyComponentType.toString();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (!(obj instanceof MisuPotMensiliId))
			return false;
		final MisuPotMensiliId other = (MisuPotMensiliId) obj;
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
		return "MisuPotMensiliId [integrationPeriod=" + integrationPeriod
				+ ", matricolaLenntCliente=" + matricolaLenntCliente
				+ ", powerType=" + powerType + ", type=" + type + "]";
	}

		
}
