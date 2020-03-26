package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;
import java.util.Date;

public class ReadingSelectBO implements Serializable {
	
	private static final long serialVersionUID = -1L;
	public static final short TYPE_ACTIVE = 0;
	public static final short TYPE_REACTIVE = 1;
	public static final short TYPE_SUPPLIED = 2;
	
	private String meterId=null;
	private Date startDate=null;
	private Date endDate=null;
	
	
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
