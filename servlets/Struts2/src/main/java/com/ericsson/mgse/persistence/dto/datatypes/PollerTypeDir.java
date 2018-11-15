package com.ericsson.mgse.persistence.dto.datatypes;

public enum PollerTypeDir {

	LOCAL("LOCAL"),
	REMOTE("REMOTE");
	
	private String tipo;
	
	private PollerTypeDir(String tipo) {
		this.tipo = tipo;
	}
	
	public static PollerTypeDir parse(String tipo) {
		if (tipo == null)
			return null;
		for (PollerTypeDir t : PollerTypeDir.values())
			if (t.tipo.equalsIgnoreCase(tipo))
				return t;
		
		throw new IllegalArgumentException("Invalid Poller Directory Type:" + tipo);
	}
}
