package com.ericsson.urm.device.driver.viprofiles;


public enum ProfilePeriod {
	HOURS_0_1 (10),
	HOURS_2_3 (11),
	HOURS_4_5 (12),
	HOURS_6_7 (13),
	HOURS_8_9 (14),
	HOURS_10_11 (15),
	HOURS_12_13 (16),
	HOURS_14_15 (17),
	HOURS_16_17 (18),
	HOURS_18_19 (19),
	HOURS_20_21 (20),
	HOURS_22_24 (21),
	HOURS_25 (9);
	
	private final int bt048ExtendedValue; 
	
	private ProfilePeriod(int value) {
		this.bt048ExtendedValue = value;
	}
	
	public int getBt048ExtendedValue() {
		return bt048ExtendedValue;
	}
	
	public int getPeriod() {
		return bt048ExtendedValue;
	}
	
	public static ProfilePeriod fromValue(int value) {
		for (ProfilePeriod p : ProfilePeriod.values()) {
			if ( p.getBt048ExtendedValue() == value) {
				return p;
			}	
		}
		throw new IllegalArgumentException("Value not expected for period, received:"+value);
	}
	
	public static ProfilePeriod parse(String s) {
		if(s!=null) {
			s = s.trim();
			
			for (ProfilePeriod p : ProfilePeriod.values()) {
				if ( p.toString().equalsIgnoreCase(s) ) {
					return p;
				}	
			}
			
			try {
				return fromValue(Integer.parseInt(s) );
			} catch (NumberFormatException e) { 
				// ignored
			} 
		}
		throw new IllegalArgumentException("Value not expected for period, received:"+s);
	}
}
