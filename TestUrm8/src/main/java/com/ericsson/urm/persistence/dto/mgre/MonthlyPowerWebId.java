package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentId;
import com.ericsson.urm.persistence.dto.mgre.datatype.IntegrationPeriodType;
import com.ericsson.urm.persistence.dto.mgre.datatype.RegisterCode;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class MonthlyPowerWebId implements Serializable, Cloneable {
	private static final long serialVersionUID = -1;
	
	private String matricolaLenntCliente = null;
	private String integrationPeriod = null;
	private String componentId = null;
	private String registro = null;
	
	
	public MonthlyPowerWebId() {}
	
	public MonthlyPowerWebId(String matricolaLenntCliente,
			IntegrationPeriodType integrationPeriodType, 
			EnergyComponentId energyComponentId, 
			RegisterCode registerCode) {
		
		ArgumentsCheckerUtil.checkString(matricolaLenntCliente, "matricolaLenntCliente");
		ArgumentsCheckerUtil.checkNull(integrationPeriodType, "integrationPeriodType");
		ArgumentsCheckerUtil.checkNull(energyComponentId, "energyComponentId");
		ArgumentsCheckerUtil.checkNull(registerCode, "registerCode");
		
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.integrationPeriod = integrationPeriodType.toString();
		this.componentId = energyComponentId.toString();
		this.registro = registerCode.toString();
	}
	
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public IntegrationPeriodType getIntegrationPeriod() {
		return integrationPeriod != null ? IntegrationPeriodType.parse(integrationPeriod) : null;
	}
	public void setIntegrationPeriod(IntegrationPeriodType integrationPeriodType) {
		ArgumentsCheckerUtil.checkNull(integrationPeriodType, "integrationPeriodType");
		
		this.integrationPeriod = integrationPeriodType.toString();
	}
	
	public EnergyComponentId getComponentId() {
		return componentId != null ? EnergyComponentId.parse(componentId) : null;
	}
	public void setComponentId(EnergyComponentId energyComponentId) {
		ArgumentsCheckerUtil.checkNull(energyComponentId, "energyComponentId");
		this.componentId = energyComponentId.toString();
	}
	
	public RegisterCode getRegistro() {
		return registro != null ? RegisterCode.parse(registro) : null;
	}
	public void setRegistro(RegisterCode registerCode) {
		ArgumentsCheckerUtil.checkNull(registerCode, "registerCode");
		this.registro = registerCode.toString();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((componentId == null) ? 0 : componentId.hashCode());
		result = prime
				* result
				+ ((integrationPeriod == null) ? 0 : integrationPeriod
						.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result
				+ ((registro == null) ? 0 : registro.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MonthlyPowerWebId other = (MonthlyPowerWebId) obj;
		if (componentId == null) {
			if (other.componentId != null)
				return false;
		} else if (!componentId.equals(other.componentId))
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
		if (registro == null) {
			if (other.registro != null)
				return false;
		} else if (!registro.equals(other.registro))
			return false;
		return true;
	}
	
	public Object clone() {
		MonthlyPowerWebId ret = new MonthlyPowerWebId();
		ret.matricolaLenntCliente = matricolaLenntCliente;
		ret.integrationPeriod = integrationPeriod;
		ret.componentId = componentId;
		ret.registro = registro;
		return ret;
	}
}
