package com.ericsson.urm.device.driver.loadcurves;

import java.io.Serializable;

public class LoadCurveReadingRequest implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private int day = -1;
	private LoadCurveComponentType componentType = null;
	private boolean currentMonthRequest = true;
	private boolean summerToSolarTime = false;
	public int period = -1;
	public boolean allPeriodRequested = false;

	/**
	 * 
	 * @return the day of the month requested
	 */
	public int getDay() {
		return day;
	}

	/**
	 * 
	 * @param day
	 *            valid values 1 - 31
	 */
	public void setDay(int day) {
		if (day < 1 || day > 31)
			throw new IllegalArgumentException("Invalid day: must be between 1 and 31");
		this.day = day;
	}

	public LoadCurveComponentType getComponentType() {
		return this.componentType;
	}

	public void setComponentType(LoadCurveComponentType componentType) {
		if (componentType == null)
			throw new IllegalArgumentException("Null value not admitted");
		this.componentType = componentType;
	}

	/**
	 * 
	 * @return true if the request is about the current month, false if the
	 *         request is about the past month.
	 */
	public boolean isCurrentMonthRequest() {
		return currentMonthRequest;
	}

	/**
	 * @param currentMonthRequest
	 *            true if the request is about the current month, false if the
	 *            request is about the past month.
	 */
	public void setCurrentMonthRequest(boolean currentMonthRequest) {
		this.currentMonthRequest = currentMonthRequest;
	}

	/**
	 * 
	 * @return true if the day requested is the day of the year when the summer
	 *         time changes to solar time: there are more curves to get from the
	 *         lennt.
	 */
	public boolean isSummerToSolarTime() {
		return summerToSolarTime;
	}

	/**
	 * 
	 * @param WinterTimeChange
	 *            true if the day requested is the day of the year when the
	 *            summer time changes to solar time: there are more curves to
	 *            get from the lennt
	 */
	public void setSummerToSolarTime(boolean summerToSolarTime) {
		this.summerToSolarTime = summerToSolarTime;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
		this.allPeriodRequested=false;
	}

	public boolean isAllPeriodRequested() {
		return allPeriodRequested;
	}

	public void setAllPeriodRequested(boolean allPeriodRequested) {
		this.allPeriodRequested = allPeriodRequested;
		this.period=-1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (allPeriodRequested ? 1231 : 1237);
		result = prime * result
				+ ((componentType == null) ? 0 : componentType.hashCode());
		result = prime * result + (currentMonthRequest ? 1231 : 1237);
		result = prime * result + day;
		result = prime * result + period;
		result = prime * result + (summerToSolarTime ? 1231 : 1237);
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
		LoadCurveReadingRequest other = (LoadCurveReadingRequest) obj;
		if (allPeriodRequested != other.allPeriodRequested)
			return false;
		if (componentType == null) {
			if (other.componentType != null)
				return false;
		} else if (!componentType.equals(other.componentType))
			return false;
		if (currentMonthRequest != other.currentMonthRequest)
			return false;
		if (day != other.day)
			return false;
		if (period != other.period)
			return false;
		if (summerToSolarTime != other.summerToSolarTime)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoadCurveReadingRequest [day=" + day + ", componentType=" + componentType + ", currentMonthRequest="
				+ currentMonthRequest + ", summerToSolarTime=" + summerToSolarTime + ", period=" + period
				+ ", allPeriodRequested=" + allPeriodRequested + "]";
	}
	
	
	
}
