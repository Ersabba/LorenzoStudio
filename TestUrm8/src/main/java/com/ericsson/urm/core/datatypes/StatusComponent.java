package com.ericsson.urm.core.datatypes;


import java.io.Serializable;

import com.ericsson.urm.device.driver.datatype.ComponentId;

public class StatusComponent implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private ComponentId  componentId = null;
	private int status = 15;
	
	
	public StatusComponent() {
		super();
	}

	public StatusComponent(ComponentId componentId, int status) {
		super();
		this.componentId = componentId;
		this.status = status;
	}
	
	public boolean isMissingRegValue() {
		return (status & 0x08)!=0;
	}
	
	public boolean isMissingIPMValue() {
		return (status & 0x04)!=0;
	}

	public boolean isMissingDecimalGeneralValue() {
		return (status & 0x02)!=0;
	}

	public boolean isMissingDecimalTariffValue() {
		return (status & 0x01)!=0;
	}

	public ComponentId getComponentId() {
		return componentId;
	}

	public void setComponentId(ComponentId componentId) {
		this.componentId = componentId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentId == null) ? 0 : componentId.hashCode());
		result = prime * result + status;
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
		StatusComponent other = (StatusComponent) obj;
		if (componentId != other.componentId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
}
