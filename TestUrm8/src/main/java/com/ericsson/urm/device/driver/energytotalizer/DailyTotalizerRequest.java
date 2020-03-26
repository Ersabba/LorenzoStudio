package com.ericsson.urm.device.driver.energytotalizer;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DailyTotalizerRequest implements Serializable {

	private static final long serialVersionUID = -1L;
	private Date day = null;
	private TotalizerRequestType requestType = null;

	public DailyTotalizerRequest(Date day, TotalizerRequestType requestType) {
		super();
		if (day == null || requestType == null)
			throw new IllegalArgumentException("Day and type must be not null");
		this.day = day;
		this.requestType = requestType;
	}

	public int getDayOfMonth() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(day);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	public Date getDay() {
		return day;
	}

	public boolean isPastMonth() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.add(Calendar.MONTH, -1);
		int pastMonth = cal.get(Calendar.MONTH);
		cal.setTime(day);
		return cal.get(Calendar.MONTH) == pastMonth;

	}

	public TotalizerRequestType getRequestType() {
		return requestType;
	}

}
