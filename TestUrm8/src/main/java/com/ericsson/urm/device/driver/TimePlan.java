package com.ericsson.urm.device.driver;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class TimePlan implements Serializable {
	private String contractName = null;
	private String planName = null;

	public static class Day implements Serializable {

		private int onHour;
		private int onMinute;
		private int offHour;
		private int offMinute;

		private boolean lightingControlled = false;
		private int controllerOnHour;
		private int controllerOnMinute;
		private int controllerOffHour;
		private int controllerOffMinute;

		public Day() {

		}

		public void setTimes(int onHour, int onMinute, int offHour, int offMinute) {
			this.onHour = onHour;
			this.onMinute = onMinute;
			this.offHour = offHour;
			this.offMinute = offMinute;
		}

		public void setControlledTimes(int controllerOnHour, int controllerOnMinute, int controllerOffHour, int controllerOffMinute) {
			lightingControlled = true;
			this.controllerOnHour = controllerOnHour;
			this.controllerOnMinute = controllerOnMinute;
			this.controllerOffHour = controllerOffHour;
			this.controllerOffMinute = controllerOffMinute;
		}

		public int getOnHour() {
			return onHour;
		}

		public int getOnMinute() {
			return onMinute;
		}

		public int getOffHour() {
			return offHour;
		}

		public int getOffMinute() {
			return offMinute;
		}

		public boolean isLightingControlled() {
			return lightingControlled;
		}

		public int getControllerOnHour() {
			return controllerOnHour;
		}

		public int getControllerOnMinute() {
			return controllerOnMinute;
		}

		public int getControllerOffHour() {
			return controllerOffHour;
		}

		public int getControllerOffMinute() {
			return controllerOffMinute;
		}

	}

	public static class Week implements Serializable {

		private Date startDate = null;

		private Day[] days = new Day[7];

		public Day getMonday() {
			return days[0];
		}

		public void setMonday(Day monday) {
			days[0] = monday;
		}

		public Day getTuesday() {
			return days[1];
		}

		public void setTuesday(Day tuesday) {
			days[1] = tuesday;
		}

		public Day getWednesday() {
			return days[2];
		}

		public void setWednesday(Day wednesday) {
			days[2] = wednesday;
		}

		public Day getThuersday() {
			return days[3];
		}

		public void setThuersday(Day thuersday) {
			days[3] = thuersday;
		}

		public Day getFriday() {
			return days[4];
		}

		public void setFriday(Day friday) {
			days[4] = friday;
		}

		public Day getSaturday() {
			return days[5];
		}

		public void setSaturday(Day saturday) {
			days[5] = saturday;
		}

		public Day getSunday() {
			return days[6];
		}

		public void setSunday(Day sunday) {
			days[6] = sunday;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setDays(Day[] days) {
			if (days == null || days.length != 7)
				throw new IllegalArgumentException("Invalid parameter must be not null and 7 elements long");
			this.days = days;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

	}

	private Week[] weeks = new Week[6];

	public Week[] getOrderedWeeks() {

		Comparator<Week> comp = new Comparator<Week>() {

			@Override
			public int compare(Week o1, Week o2) {
				return o1.getStartDate().compareTo(o2.getStartDate());
			}
		};
		Arrays.sort(weeks, comp);
		return weeks;
	}

	public void setWeek(int index, Week week) {
		if (index < 0 || index > 5)
			throw new IllegalArgumentException("Index must be greater than 0 and lesser than 5");
		if (week == null)
			throw new IllegalArgumentException("Invalid value for parameter week");
		weeks[index] = week;

	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		if (contractName == null || contractName.length() > 5)
			throw new IllegalArgumentException("Contranctname must be not null and 6 character long");

		this.contractName = contractName;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		if (planName == null || planName.length() > 5)
			throw new IllegalArgumentException("PlanName must be not null and 6 character long");
		this.planName = planName;
	}

}
