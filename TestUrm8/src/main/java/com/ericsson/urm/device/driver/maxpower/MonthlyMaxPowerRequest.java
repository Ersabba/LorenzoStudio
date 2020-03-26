package com.ericsson.urm.device.driver.maxpower;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ericsson.urm.device.driver.datatype.ComponentId;
import com.ericsson.urm.device.driver.energytotalizer.IMonthlyTotalizerMeasure;


public class MonthlyMaxPowerRequest implements IMonthlyTotalizerMeasure, Serializable {

	private static final long serialVersionUID = -1L;
	
	private Date month = null;
	private ComponentId powerType;

	public MonthlyMaxPowerRequest(Date month, ComponentId powerType) {
		super();
		if (month == null)
			throw new IllegalArgumentException("Parameter month must be not null");
		
		if (powerType == null)
			throw new IllegalArgumentException("Parameter powerType must be not null");

		setMonth(month);
		this.powerType = powerType;
	}

	private void setMonth(Date month){
		GregorianCalendar cal= new GregorianCalendar();
		cal.setTime(month);
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.add(Calendar.MONTH,1);
		cal.add(Calendar.DAY_OF_MONTH,-1);
		this.month=cal.getTime();
	}
	public Date getMonth() {
		return month;
	}

	public ComponentId getPowerType() {
		return powerType;
	}
}
