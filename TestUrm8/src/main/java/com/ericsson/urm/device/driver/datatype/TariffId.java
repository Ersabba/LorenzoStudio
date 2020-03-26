package com.ericsson.urm.device.driver.datatype;

import java.util.HashSet;
import java.util.Set;

public enum TariffId {
	T1(1), 
	T2(2),
	T3(3),
	T4(4);
	
	private int index;
	
	private TariffId(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
	
	public static TariffId valueOf(int index)	{
		for (TariffId curr : TariffId.values()) {
			if(curr.index == index) { return curr; }
		}
	
		throw new IllegalArgumentException ("Unsupported TariffId index " + index);
	}
	
	public static TariffId parse(String typeName)	{	
		for (TariffId curr : TariffId.values()) {
			if(curr.toString().equalsIgnoreCase(typeName)) { return curr; }
		}
		try {
			return valueOf(Integer.parseInt(typeName));		
		} catch (NumberFormatException e) {
			
		}
		
		throw new IllegalArgumentException ("Unsupported TariffId type name " + typeName);
	}
	
	public static Set<TariffId> getAll() {
		Set<TariffId> elements = new HashSet<TariffId>();
		for (TariffId e : values())
			elements.add(e);
		return elements;
	}
}
