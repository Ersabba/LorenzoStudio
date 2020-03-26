package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
/**
 * The persistent class for the GRE_CRZ_EVENT database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_EVENTS")
public class CrzEvents implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EVENT_CODE", unique=true, nullable=false)
	private String eventCode;

	@Column(name="DESCRIPTION")
	private String description;

	
	
	public CrzEvents(){
		super();
	}



	public String getEventCode() {
		return eventCode;
	}



	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "CrzEvents [eventCode=" + eventCode + ", description="
				+ description + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((eventCode == null) ? 0 : eventCode.hashCode());
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
		CrzEvents other = (CrzEvents) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (eventCode == null) {
			if (other.eventCode != null)
				return false;
		} else if (!eventCode.equals(other.eventCode))
			return false;
		return true;
	}

	
	
}