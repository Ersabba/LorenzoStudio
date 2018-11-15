package com.ericsson.mgse.persistence.dto;

import java.io.Serializable;

import com.ericsson.mgse.persistence.dto.datatypes.PollerTypeDir;

public class FlowConfig  implements Serializable {
	private static final long serialVersionUID = -1;
	
	private String flowCode;
	private String description;
	private String subsystem;
	private PollerTypeDir pollerType;
	private String pollerName;
	
	public FlowConfig() {
	
	}

	public String getFlowCode() {
		return flowCode;
	}

	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubsystem() {
		return subsystem;
	}

	public void setSubsystem(String subsystem) {
		this.subsystem = subsystem;
	}

	public PollerTypeDir getPollerType() {
		return pollerType;
	}

	public void setPollerType(PollerTypeDir pollerType) {
		this.pollerType = pollerType;
	}

	public String getPollerName() {
		return pollerName;
	}

	public void setPollerName(String pollerName) {
		this.pollerName = pollerName;
	}

	@Override
	public String toString() {
		return "FlowConfig [flowCode=" + flowCode + ", description=" + description + ", subsystem=" + subsystem
				+ ", pollerType=" + pollerType + ", pollerName=" + pollerName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((flowCode == null) ? 0 : flowCode.hashCode());
		result = prime * result + ((pollerName == null) ? 0 : pollerName.hashCode());
		result = prime * result + ((pollerType == null) ? 0 : pollerType.hashCode());
		result = prime * result + ((subsystem == null) ? 0 : subsystem.hashCode());
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
		FlowConfig other = (FlowConfig) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (flowCode == null) {
			if (other.flowCode != null)
				return false;
		} else if (!flowCode.equals(other.flowCode))
			return false;
		if (pollerName == null) {
			if (other.pollerName != null)
				return false;
		} else if (!pollerName.equals(other.pollerName))
			return false;
		if (pollerType != other.pollerType)
			return false;
		if (subsystem == null) {
			if (other.subsystem != null)
				return false;
		} else if (!subsystem.equals(other.subsystem))
			return false;
		return true;
	}
	
	
}
