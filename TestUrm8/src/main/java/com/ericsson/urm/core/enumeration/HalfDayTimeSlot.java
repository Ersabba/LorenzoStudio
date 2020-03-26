package com.ericsson.urm.core.enumeration;


public enum HalfDayTimeSlot {
	FASCIA_1(1),
	FASCIA_2(2);

	private int	dbValue;

	private HalfDayTimeSlot(int dbValue) {
		this.dbValue = dbValue;
	}

	public int dbValue() {
		return this.dbValue;
	}

	public static HalfDayTimeSlot fromValue(int dbValue) {
		for (HalfDayTimeSlot f : HalfDayTimeSlot.values())
			if (f.dbValue == dbValue)
				return f;
		throw new IllegalArgumentException("Unrecognized value: " + dbValue);
	}
}
