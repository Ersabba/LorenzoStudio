package com.ericsson.urm.device.driver.viprofiles;


public enum ProfileType {
	V (6), // TENSIONE
	I (7) ;// CORRENTE
	
	private final int bt048ExtendedValue;
	
	private ProfileType(int value) {
		this.bt048ExtendedValue = value;
	}

	public int getBt048ExtendedValue() {
		return bt048ExtendedValue;
	}
	
	
	public static ProfileType fromValue(int value) {
		for (ProfileType p : ProfileType.values()) {
			if ( p.getBt048ExtendedValue() == value) {
				return p;
			}	
		}
		throw new IllegalArgumentException("Value not expected for profile type, received:"+value);
	}
	
	public static ProfileType parse(String s) {
		if(s!=null) {
			s = s.trim();
			
			for (ProfileType p : ProfileType.values()) {
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
		throw new IllegalArgumentException("Value not expected for profile type, received:"+s);
	}
	
}
