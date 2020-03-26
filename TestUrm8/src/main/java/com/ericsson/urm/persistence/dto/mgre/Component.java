package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class Component implements Serializable {
	private static final long serialVersionUID = -1;
	
	public static String ID_ATT_ASS=EnergyComponentId.EEA.getEnergyId();
	public static String ID_ATT_ER=EnergyComponentId.EUA.getEnergyId();
	public static String ID_REATT_CAP_ASS=EnergyComponentId.EEC.getEnergyId();
	public static String ID_REATT_CAP_ER=EnergyComponentId.EUC.getEnergyId();
	public static String ID_REATT_IND_ASS=EnergyComponentId.EEI.getEnergyId();
	public static String ID_REATT_IND_ER=EnergyComponentId.EUI.getEnergyId();
	
	private String  componentId;
	private String  extension;
	private boolean enabled;
	
	
	public Component() {
		
	}
	
	public Component(String componentId) {
		ArgumentsCheckerUtil.checkString(componentId, "componentId");
		EnergyComponentId.parse(componentId);
		this.componentId=componentId;
	}

	public EnergyComponentId getComponentId() {
		return componentId != null ? EnergyComponentId.parse(componentId) : null;
	}

	public void setComponentId(EnergyComponentId energyComponentId) {
		ArgumentsCheckerUtil.checkNull(energyComponentId, "energyComponentId");
		this.componentId = energyComponentId.toString();
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((componentId == null) ? 0 : componentId.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result
				+ ((extension == null) ? 0 : extension.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Component other = (Component) obj;
		if (componentId == null) {
			if (other.componentId != null)
				return false;
		} else if (!componentId.equals(other.componentId))
			return false;
		if (enabled != other.enabled)
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		return true;
	}
	
	
    
}
