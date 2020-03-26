package com.ericsson.urm.device.driver.energytotalizer;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MonthlyTotalizerRequest implements IMonthlyTotalizerMeasure, Serializable {

	private static final long serialVersionUID = -1L;
	private Date date = null;
	private TotalizerRequestType requestType = null;

	public MonthlyTotalizerRequest(Date date, TotalizerRequestType requestType) {
		super();
		if (date == null || requestType == null)
			throw new IllegalArgumentException("Day and type must be not null");
		this.date = date;
		this.requestType = requestType;
	}

	public int getMonth() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	public Date getDate() {
		return date;
	}

	public boolean isPastMonth() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.add(Calendar.MONTH, -1);
		int pastMonth = cal.get(Calendar.MONTH);
		cal.setTime(date);
		return cal.get(Calendar.MONTH) == pastMonth;

	}

	public TotalizerRequestType getRequestType() {
		return requestType;
	}

}