package com.ericsson.urm.device.driver.datetime;

import java.io.Serializable;
import java.util.Calendar;

import com.ericsson.urm.device.driver.datatype.DayOfWeek;
import com.ericsson.urm.device.driver.datatype.TariffId;


public class DateTimeDevice implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private byte[] statusWord = null;
	private Calendar calendar = null;
	private int scorrimentoInCorso   = -1;
	private int scorrimentoEffetuato = -1;
	private DaysType daysType = null;
	private TariffId tariffId = null;
	private Legale legale = null;
	
	public static enum DaysType {
		
		WORKING(0),
		HOLYDAYS(1);
		
		private int value;

		private DaysType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
		
		public static DaysType valueOf(int value) {
			for(DaysType dt : DaysType.values()) {
				if(dt.value == value) {
					return dt;
				}
			}
			throw new IllegalArgumentException("Unknown DaysType with value:"+value);
		}
	}
	
	public static enum Legale {
		
		SOLARE(0),
		LEGALE(1),
		POST_LEGALE(2),
		DOPPIO_POST_LEGALE(3);
		
		private int value;

		private Legale(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
		
		public static Legale valueOf(int value) {
			for(Legale dt : Legale.values()) {
				if(dt.value == value) {
					return dt;
				}
			}
			throw new IllegalArgumentException("Unknown Legale with value:"+value);
		}
	}
	

	public byte[] getStatusWord() {
		return statusWord;
	}


	public Calendar getCalendar() {
		return calendar;
	}
	
	public int getHourOfDay() {
		checkCalendar();
		
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public int getMinute() {
		checkCalendar();
		
		return calendar.get(Calendar.MINUTE);
	}

	public int getDayOfMonth() {
		checkCalendar();
		
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getMonth() {
		checkCalendar();
		
		return calendar.get(Calendar.MONTH) + 1;
	}
	
	public int getYear() {
		checkCalendar();
		
		return calendar.get(Calendar.YEAR);
	}
	
	public DayOfWeek getDayOfWeek() {
		checkCalendar();
		return DayOfWeek.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
	}
	

	public int getScorrimentoInCorso() {
		return scorrimentoInCorso;
	}


	public int getScorrimentoEffetuato() {
		return scorrimentoEffetuato;
	}


	public DaysType getDaysType() {
		return daysType;
	}

	public TariffId getTariffId() {
		return tariffId;
	}

	public Legale getLegale() {
		return legale;
	}


	public void setStatusWord(byte[] statusWord) {
		this.statusWord = statusWord;
	}


	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}


	public void setScorrimentoInCorso(int scorrimentoInCorso) {
		this.scorrimentoInCorso = scorrimentoInCorso;
	}


	public void setScorrimentoEffetuato(int scorrimentoEffetuato) {
		this.scorrimentoEffetuato = scorrimentoEffetuato;
	}


	public void setDaysType(DaysType daysType) {
		this.daysType = daysType;
	}


	public void setTariffId(TariffId tariffId) {
		this.tariffId = tariffId;
	}


	public void setLegale(Legale legale) {
		this.legale = legale;
	}


	private void checkCalendar() {
		if(calendar==null) {
			throw new IllegalStateException("Parameter calendar not initialized");
		}
	}
}
