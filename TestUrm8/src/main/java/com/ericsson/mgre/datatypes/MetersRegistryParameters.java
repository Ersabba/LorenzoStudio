package com.ericsson.mgre.datatypes;

import java.io.Serializable;

public class MetersRegistryParameters implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int daysBack;
	private int timeWindowRange;
	
	
	public int getDaysBack() {
		return daysBack;
	}
	public void setDaysBack(int daysBack) {
		this.daysBack = daysBack;
	}
	public int getTimeWindowRange() {
		return timeWindowRange;
	}
	public void setTimeWindowRange(int timeWindowRange) {
		this.timeWindowRange = timeWindowRange;
	}
	
	

}
