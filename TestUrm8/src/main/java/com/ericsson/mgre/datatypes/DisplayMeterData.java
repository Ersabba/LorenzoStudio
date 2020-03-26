package com.ericsson.mgre.datatypes;

import java.io.Serializable;

public class DisplayMeterData implements Serializable {
	
	private static final long serialVersionUID = -1L;
	private String idMeter;
	private String idLocation;
	private String subscriberType;

	public DisplayMeterData() {
		
	}

	public DisplayMeterData(String idMeter, String idLocation,
			String subscriberType) {
		
		this.idMeter = idMeter;
		this.idLocation = idLocation;
		this.subscriberType = subscriberType;
	}

	public String getIdMeter() {
		return idMeter;
	}

	public void setIdMeter(String idMeter) {
		this.idMeter = idMeter;
	}

	public String getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(String idLocation) {
		this.idLocation = idLocation;
	}

	public String getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idLocation == null) ? 0 : idLocation.hashCode());
		result = prime * result + ((idMeter == null) ? 0 : idMeter.hashCode());
		result = prime * result
				+ ((subscriberType == null) ? 0 : subscriberType.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisplayMeterData other = (DisplayMeterData) obj;
		if (idLocation == null) {
			if (other.idLocation != null)
				return false;
		} else if (!idLocation.equals(other.idLocation))
			return false;
		if (idMeter == null) {
			if (other.idMeter != null)
				return false;
		} else if (!idMeter.equals(other.idMeter))
			return false;
		if (subscriberType == null) {
			if (other.subscriberType != null)
				return false;
		} else if (!subscriberType.equals(other.subscriberType))
			return false;
		return true;
	}
	
	
}
