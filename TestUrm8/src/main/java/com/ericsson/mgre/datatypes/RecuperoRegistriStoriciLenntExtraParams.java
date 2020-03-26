package com.ericsson.mgre.datatypes;

import java.io.Serializable;

public class RecuperoRegistriStoriciLenntExtraParams implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int daysBetweenLastTwoReadings;
	private int maxMeterToContact;
	private int monthsBackwards;
	
	public static enum Keys {
		DAYS_BETWEEN_LAST_TWO_READINGS("recupero.registri.storici.giorni.mancata.comunicazione.lennt"),
		MAX_METER_TO_CONTACT("recupero.registri.storici.lennt.da.contattare.numero.max"),
		MONTHS_BACKWARDS("recupero.registri.storici.lennt.numero.mesi.a.ritroso");
		
		/**
		 * @param dbKey
		 */
		private Keys(String dbKey) {
			this.dbKey = dbKey;
		}

		private String dbKey;

		public String getDbKey() {
			return dbKey;
		}
		
		public static Keys parse(String param) {
			if(param!=null) {
				for(Keys curr : Keys.values()) {
					if(curr.getDbKey().equalsIgnoreCase(param) || curr.toString().equalsIgnoreCase(param)) {
						return curr;
					}
				}
				throw new IllegalArgumentException("Unknown key: "+param);
			}
			return null;
		}
	}
	
	/**
	 * 
	 */
	public RecuperoRegistriStoriciLenntExtraParams() {
		super();
	}

	/**
	 * @param daysBetweenLastTwoReadings
	 * @param maxMeterToContact
	 * @param monthsBackwards
	 */
	public RecuperoRegistriStoriciLenntExtraParams(int daysBetweenLastTwoReadings, int maxMeterToContact,
			int monthsBackwards) {
		super();
		this.daysBetweenLastTwoReadings = daysBetweenLastTwoReadings;
		this.maxMeterToContact = maxMeterToContact;
		this.monthsBackwards = monthsBackwards;
	}

	public int getDaysBetweenLastTwoReadings() {
		return daysBetweenLastTwoReadings;
	}

	public void setDaysBetweenLastTwoReadings(int daysBetweenLastTwoReadings) {
		this.daysBetweenLastTwoReadings = daysBetweenLastTwoReadings;
	}

	public int getMaxMeterToContact() {
		return maxMeterToContact;
	}

	public void setMaxMeterToContact(int maxMeterToContact) {
		this.maxMeterToContact = maxMeterToContact;
	}

	public int getMonthsBackwards() {
		return monthsBackwards;
	}

	public void setMonthsBackwards(int monthsBackwards) {
		this.monthsBackwards = monthsBackwards;
	}

	@Override
	public String toString() {
		return "RecuperoRegistriStoriciLenntExtraParams [daysBetweenLastTwoReadings=" + daysBetweenLastTwoReadings
				+ ", maxMeterToContact=" + maxMeterToContact + ", monthsBackwards=" + monthsBackwards + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + daysBetweenLastTwoReadings;
		result = prime * result + maxMeterToContact;
		result = prime * result + monthsBackwards;
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
		RecuperoRegistriStoriciLenntExtraParams other = (RecuperoRegistriStoriciLenntExtraParams) obj;
		if (daysBetweenLastTwoReadings != other.daysBetweenLastTwoReadings)
			return false;
		if (maxMeterToContact != other.maxMeterToContact)
			return false;
		if (monthsBackwards != other.monthsBackwards)
			return false;
		return true;
	}
	
	
}
