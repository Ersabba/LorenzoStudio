package com.ericsson.urm.core.enumeration;

public enum VoltageCurrent {
	V, // TENSIONE
	I; // CORRENTE

	public static VoltageCurrent parse(String tipoProfilo) {
		if (tipoProfilo != null) {
			for (VoltageCurrent tp : VoltageCurrent.values()) {
				if (tp.toString().equalsIgnoreCase(tipoProfilo)) {
					return tp;
				}
			}
		}
		throw new IllegalArgumentException("Invalid profile: " + tipoProfilo);
	}
}
