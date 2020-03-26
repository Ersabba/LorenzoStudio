package com.ericsson.communication.datatype;


public enum SourceRequestType {
	OPERATOR("OP"), EXTERNAL_SYSTEM("EXT"), WORKFLOW_MANAGER("WFM");
	
	private String persistText;

	private SourceRequestType(String persistText) {
		this.persistText = persistText;
	}

	public static SourceRequestType parse(String typeName)	{	
		for (SourceRequestType curr : SourceRequestType.values()) {
			if(curr.toString().equalsIgnoreCase(typeName)) { return curr; }
		}
		
		throw new IllegalArgumentException ("Componente: unsupported type name " + typeName);
	}
	
	public String getPersistText() {
		return persistText;
	}
}
