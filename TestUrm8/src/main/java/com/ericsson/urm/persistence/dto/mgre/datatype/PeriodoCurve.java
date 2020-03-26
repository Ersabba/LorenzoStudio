package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;

public class PeriodoCurve implements Serializable {
	private static final long serialVersionUID = -1;
	public final static PeriodoCurve Q = new PeriodoCurve("Q", 15, 12);
	public final static PeriodoCurve M = new PeriodoCurve("M", 30, 6);
	public final static PeriodoCurve H = new PeriodoCurve("H", 60, 3);

	private String periodoCurve;
	/**
	 * Number of minutes of the division on the standard sampling period of three hours: 15 means Quarter of hour, 15 minutes, 
	 * 30 minutes corresponds to Half hour, 60 to a complete Hour.
	 */
	private int value;
	/**
	 * Number of periods. For example the instance with periodoCurve=Q means that the division of the sampling period of three hours 
	 * is divided into 15 minutes intervals, so we have 12 intervals.   
	 * 
	 */
	private int periods;

	private PeriodoCurve(String periodoCurve, int value, int periods) {
		this.periodoCurve = periodoCurve;
		this.value = value;
		this.periods = periods;
	}

	public static PeriodoCurve parse(String periodoCurve) {
		if (periodoCurve == null || periodoCurve.length() == 0)
			return null;
		
		if (Q.periodoCurve.equalsIgnoreCase(periodoCurve))
			return Q;
		if (M.periodoCurve.equalsIgnoreCase(periodoCurve))
			return M;
		if (H.periodoCurve.equalsIgnoreCase(periodoCurve))
			return H;

		throw new IllegalArgumentException("Unsupported periodoCurve: " + periodoCurve);
	}

	public static PeriodoCurve parse(int value) {
		if (Q.value == value)
			return Q;
		if (M.value == value)
			return M;
		if (H.value == value)
			return H;

		throw new IllegalArgumentException("Unsupported periodoCurve value: " + value);
	}

	public int getValue() {
		return value;
	}

	public int getPeriods() {
		return periods;
	}

	public String toString() {
		return periodoCurve;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((periodoCurve == null) ? 0 : periodoCurve.hashCode());
		result = prime * result + value;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PeriodoCurve))
			return false;
		final PeriodoCurve other = (PeriodoCurve) obj;
		if (periodoCurve == null) {
			if (other.periodoCurve != null)
				return false;
		} else if (!periodoCurve.equals(other.periodoCurve))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
}
