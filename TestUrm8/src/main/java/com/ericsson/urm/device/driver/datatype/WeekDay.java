package com.ericsson.urm.device.driver.datatype;

import java.util.HashSet;
import java.util.Set;

public enum WeekDay {
	Monday(0),
	Tuesday(1),
	Wednesday(2),
	Thuersday(3),
	Friday(4),
	Saturday(5),
	Sunday(6),
	Holiday(7);
	
	private int index;

	private WeekDay(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
	
	public static WeekDay valueOf(int index) {
		for(WeekDay curr : WeekDay.values()) {
			if(curr.index == index) {
				return curr;
			}
		}
		throw new IllegalArgumentException("Unknown index:"+index+"; valid values:0-7");
	}
	
	public static Set<WeekDay> getAll() {
		Set<WeekDay> elements = new HashSet<WeekDay>();
		for (WeekDay c : values())
			elements.add(c);
	
		return elements;
	}
}
