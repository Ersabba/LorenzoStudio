package com.ericsson.urm.core.enumeration;


public enum HourlyTimeSlot {
	FASCIA_ORA_0_1(10),
	FASCIA_ORA_2_3(11),
	FASCIA_ORA_4_5(12),
	FASCIA_ORA_6_7(13),
	FASCIA_ORA_8_9(14),
	FASCIA_ORA_10_11(15),
	FASCIA_ORA_12_13(16),
	FASCIA_ORA_14_15(17),
	FASCIA_ORA_16_17(18),
	FASCIA_ORA_18_19(19),
	FASCIA_ORA_20_21(20),
	FASCIA_ORA_22_24(21),
	FASCIA_ORA_25(9);

	private int	dbValue;

	private HourlyTimeSlot(int dbValue) {
		this.dbValue = dbValue;
	}

	public int dbValue() {
		return dbValue;
	}

	public static HourlyTimeSlot fromValue(int fasciaOraria) {
		for (HourlyTimeSlot ts : HourlyTimeSlot.values()) {
			if (ts.dbValue == fasciaOraria) {
				return ts;
			}
		}
		throw new IllegalArgumentException("Invalid period: " + fasciaOraria);
	}
}
