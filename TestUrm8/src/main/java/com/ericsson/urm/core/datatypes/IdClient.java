package com.ericsson.urm.core.datatypes;


public enum IdClient {
	UNKNOWN(0), CORE(1), GRE(2), GCF(3), GAP(4), GDQ(5), GSE(6), CLU(7), THR(8), GESTIONESW(9);
	
	int id;
	
	private IdClient(int id) {
		this.id = id;
	}

	public static IdClient parse(String type) {
		if(type!=null) {
			for(IdClient curr : IdClient.values()) {
				if(curr.toString().equalsIgnoreCase(type.trim())) {
					return curr;
				}
			}
			try {
				IdClient curr = getById(Integer.parseInt(type)); 
				if(!curr.equals(IdClient.UNKNOWN)) {
					return curr;
				}
			} catch (NumberFormatException e) {}
		}
		throw new IllegalArgumentException("Unknown type:"+type);
	}
	

	public static IdClient getByName(String name) {
		if(name!=null) {
			for(IdClient curr : IdClient.values()) {
				if(curr.toString().equalsIgnoreCase(name.trim())) {
					return curr;
				}
			}
			try {
				return getById(Integer.parseInt(name)); 
				
			} catch (NumberFormatException e) {}
		}
		return UNKNOWN;
	}
	
	public static IdClient getById(int id) {
		for(IdClient curr : IdClient.values()) {
			if(curr.id == id) {
				return curr;
			}
		}
		
		return UNKNOWN;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return toString();
	}
	
}
