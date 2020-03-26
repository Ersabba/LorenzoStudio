package com.ericsson.urm.device.driver.energytotalizer;


public enum TotalizerRequestType {
	ALL(0),
	ACTIVE_ABSORBED_TYPE(1),
	REACTIVE_ABSORBED_TYPE(2),
	SUPPLIED_TYPE(3);
	
    
	private int id;

	private TotalizerRequestType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public static TotalizerRequestType parse(String name) {
		if(name!=null) {
			for(TotalizerRequestType t : TotalizerRequestType.values()) {
				if(t.toString().equalsIgnoreCase(name)) {
					return t;
				}
			}
			throw new IllegalArgumentException("Unknown type name:"+name);
		}
		throw new IllegalArgumentException("Undefined type name");
	}
	
	
    public static TotalizerRequestType getById(int id) {
    	for(TotalizerRequestType curr : TotalizerRequestType.values()) {
    		if(curr.id == id) {
    			return curr;
    		}
    	}
    	throw new IllegalArgumentException("Unknown id:"+id+" valid id [0-3]");
    }

}
