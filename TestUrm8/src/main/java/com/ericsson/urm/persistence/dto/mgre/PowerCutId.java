package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class PowerCutId implements Serializable {
	
	private String meterId=null;
	private Date eventDate=null;
	private int eventIndex=-1;
	
	
	public PowerCutId() {
		super();
	}
	
	
	public PowerCutId(String meterId, Date eventDate, int eventIndex) {
		super();
		this.meterId = meterId;
		this.eventDate = eventDate;
		this.eventIndex = eventIndex;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public int getEventIndex() {
		return eventIndex;
	}
	public void setEventIndex(int eventIndex) {
		this.eventIndex = eventIndex;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PowerCutId that = (PowerCutId) o;

		if (getEventIndex() != that.getEventIndex()) return false;
		if (!getMeterId().equals(that.getMeterId())) return false;
		return getEventDate().equals(that.getEventDate());
	}

	@Override
	public int hashCode() {
		int result = getMeterId().hashCode();
		result = 31 * result + getEventDate().hashCode();
		result = 31 * result + getEventIndex();
		return result;
	}
}
