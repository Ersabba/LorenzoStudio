package com.ericsson.urm.device.driver.viprofiles;


public enum ProfilePhase {
	R(0),
	S(1),
	T(2);

	private final int	bt048ExtendedValue;

	private ProfilePhase(int value) {
		this.bt048ExtendedValue = value;
	}

	public int getBt048ExtendedValue() {
		return bt048ExtendedValue;
	}
	
	public static ProfilePhase fromValue(int value) {
		for (ProfilePhase p : ProfilePhase.values()) {
			if ( p.getBt048ExtendedValue() == value) {
				return p;
			}	
		}
		throw new IllegalArgumentException("Value not expected for phase, received:"+value);
	}
	
	public static ProfilePhase parse(String s) {
		if(s!=null) {
			s = s.trim();
			
			for (ProfilePhase p : ProfilePhase.values()) {
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
		throw new IllegalArgumentException("Value not expected for phase, received:"+s);
	}
}
