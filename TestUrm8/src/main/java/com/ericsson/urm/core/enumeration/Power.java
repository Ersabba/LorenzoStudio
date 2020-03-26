package com.ericsson.urm.core.enumeration;


public enum Power {
	PEA,
	PUA,
	PEI,
	PUI,
	PEC,
	PUC;
	
	
	public static Power parse(String tipoPotenza) {
		if(tipoPotenza!=null) {
			tipoPotenza = tipoPotenza.trim();
			for (Power tp : Power.values()) {
				if (tp.toString().equalsIgnoreCase(tipoPotenza)) {
					return tp;
				}
			}
			throw new RuntimeException("Invalid power type:" + tipoPotenza);
		}
		return null;
	}
}
