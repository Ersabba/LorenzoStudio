package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;


public class EnergyFlowDirectionType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static EnergyFlowDirectionType ABSORBED = new EnergyFlowDirectionType ("ABSORBED");
	public static EnergyFlowDirectionType SUPPLIED = new EnergyFlowDirectionType ("SUPPLIED");

	private final String literal;
	
	private EnergyFlowDirectionType (String literal) {
		this.literal = literal;
	}	
	public static EnergyFlowDirectionType parse (String literal)	{			
		if (literal == null || literal.length() == 0)
			return null;
		if (ABSORBED.literal.equalsIgnoreCase(literal)) return ABSORBED;
		if (SUPPLIED.literal.equalsIgnoreCase(literal)) return SUPPLIED;

		throw new IllegalArgumentException ("EnergyFlowDirectionType.parse: unsupported literal value " + literal);
	}
	public String toString () {
		return literal;	
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((literal == null) ? 0 : literal.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EnergyFlowDirectionType))
			return false;
		final EnergyFlowDirectionType other = (EnergyFlowDirectionType) obj;
		if (literal == null) {
			if (other.literal != null)
				return false;
		} else if (!literal.equals(other.literal))
			return false;
		return true;
	}

}
