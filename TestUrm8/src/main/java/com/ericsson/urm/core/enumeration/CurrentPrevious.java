package com.ericsson.urm.core.enumeration;


public enum CurrentPrevious {
	CURRENT(0),
	PREVIOUS(1);

	private int	dbValue;

	private CurrentPrevious(int dbValue) {
		this.dbValue = dbValue;
	}

	public int dbValue() {
		return dbValue;
	}

	public static CurrentPrevious fromValue(int dbValue) {
		for (CurrentPrevious cp : CurrentPrevious.values())
			if (cp.dbValue == dbValue)
				return cp;
		throw new IllegalArgumentException("Unrecognized value: " + dbValue);
	}
}
