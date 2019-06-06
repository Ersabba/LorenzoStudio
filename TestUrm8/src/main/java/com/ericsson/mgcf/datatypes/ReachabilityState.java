package com.ericsson.mgcf.datatypes;

public enum ReachabilityState {

	NORMALE("NORMALE"),
	ALLERTA("ALLERTA"),
	BLOCCO("BLOCCO");
	
	String stato;
	
	private ReachabilityState(){}
	
	private ReachabilityState(String stato){
		this.stato=stato;
	}
	
	public String getStato() {
		return stato;
	}		
	
	public static ReachabilityState parse(String stato) {
		for(ReachabilityState st : ReachabilityState.values()) {
			if( st.toString().equalsIgnoreCase(stato) ) {
				return st;
			}
		}
		throw new IllegalArgumentException("Unknown ReachabilityState named: "+stato);
	}

}
