package com.ericsson.urm.device.driver.energytotalizer;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DailyActiveAbsorbedTotRequest implements Serializable {

	private Date day = null;

	public DailyActiveAbsorbedTotRequest(Date day) {
		super();
		if (day == null)
			throw new IllegalArgumentException("Day must be not null");
		this.day = day;
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

}
