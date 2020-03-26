package com.ericsson.mgre.datatypes;

import java.util.HashSet;
import java.util.Set;

public enum Componente {
	ATT_ASS("EEA","ECC",0),
	ATT_ER("EUA","EE",1), 
	REATT_IND_ASS("EEI","RAI",2),
	REATT_IND_ER("EUI","REI",3),
	REATT_CAP_ASS("EEC","RAC",4), 
	REATT_CAP_ER("EUC","REC",5);
	
	private String acronym;
	private String fileExtension;
	private int index;
	
	private Componente(String acronym, String extension, int index) {
		this.acronym = acronym;
		this.fileExtension = extension;
		this.index = index;
	}

	public String getAcronym() {
		return acronym;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public int getIndex() {
		return index;
	}
	
	public static Componente valueOf(int index)	{
		for (Componente curr : Componente.values()) {
			if(curr.index == index) { return curr; }
		}
	
		throw new IllegalArgumentException ("Componente: unsupported index " + index);
	}
	
	public static Componente parse(String typeName)	{	
		for (Componente curr : Componente.values()) {
			if(curr.toString().equalsIgnoreCase(typeName)) { return curr; }
			if(curr.acronym.equalsIgnoreCase(typeName)) { return curr; }
			if(curr.fileExtension.equalsIgnoreCase(typeName)) { return curr; }
		}
		
		throw new IllegalArgumentException ("Componente: unsupported type name " + typeName);
	}

	public static Set<Componente> getAll() {
		Set<Componente> comps = new HashSet<Componente>();
		for (Componente c : values())
			comps.add(c);
		return comps;
	}
}
