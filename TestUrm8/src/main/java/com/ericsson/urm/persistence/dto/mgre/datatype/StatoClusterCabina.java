package com.ericsson.urm.persistence.dto.mgre.datatype;


public enum StatoClusterCabina {
	VALIDO("VALIDO"),
	NON_VALIDO("NON_VALIDO"),
	DA_APPROVARE("DA_APPROVARE"),
	VALIDO_SCADUTO("VALIDO_SCADUTO"),
	DA_ESPORTARE("DA_ESPORTARE"),
	DA_SCARTARE("DA_SCARTARE"),
	ESPORTATO("ESPORTATO");
	
	private String state;

	private StatoClusterCabina(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
	
	public static StatoClusterCabina parse(String state)	{
		for (StatoClusterCabina curr : StatoClusterCabina.values()) {
			if(curr.state.equalsIgnoreCase(state)) { return curr; }
		}
	
		throw new IllegalArgumentException ("StatoClusterCabina: unsupported state: " + state);
	}
}
