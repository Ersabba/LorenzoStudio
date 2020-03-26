package com.ericsson.urm.persistence.dto.mgre.datatype;

public enum RegisterCode {
	
	TG("TG",0),
	T1("T1",1),
	T2("T2",2),
	T3("T3",3),
	T4("T4",4);
	
	private String literal;
	private int index;
	
	private RegisterCode (String literal, int index) {
		this.literal = literal;
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}

	public static RegisterCode parse(int index)	{
		for(RegisterCode curr : RegisterCode.values()) {
			if(curr.index == index) {
				return curr;
			}
		}
		throw new IllegalArgumentException ("RegisterCode.parse: unsupported index value " + index);
	}

	public static RegisterCode parse(String literal)	{
		if(literal!=null && literal.length()>0) {
			for(RegisterCode curr : RegisterCode.values()) {
				if(curr.literal.equalsIgnoreCase(literal)) {
					return curr;
				}
			}
		}
		throw new IllegalArgumentException ("RegisterCode.parse: unsupported literal value " + literal);
	}
	
	public int getCodeAsIndex() {
		return index;
	}
	
	public String toString () {
		return literal;	
	}
}
