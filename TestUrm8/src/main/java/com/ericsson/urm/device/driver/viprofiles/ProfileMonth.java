package com.ericsson.urm.device.driver.viprofiles;

public enum ProfileMonth {
	CURRENT(0),
	PREVIOUS(1);

	private final int bt048ExtendedValue;

	private ProfileMonth(int value) {
		this.bt048ExtendedValue = value;
	}

	public int getBt048ExtendedValue() {
		return bt048ExtendedValue;
	}
}
