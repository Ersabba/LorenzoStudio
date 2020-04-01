package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;


public class AcqDaysVoltageCurrent implements Serializable {

	private static final long	serialVersionUID	= -1L;

	private long	countMeter;
	private Date	acqDate;
	
	public AcqDaysVoltageCurrent() {
		
	}
	
	public AcqDaysVoltageCurrent(long countMeter, Date acqDate) {
		super();
		this.countMeter = countMeter;
		this.acqDate = acqDate;
	}

	public long getCountMeter() {
		return countMeter;
	}

	public void setCountMeter(long countMeter) {
		this.countMeter = countMeter;
	}

	public Date getAcqDate() {
		return acqDate;
	}

	public void setAcqDate(Date acqDate) {
		this.acqDate = acqDate;
	}	
}
