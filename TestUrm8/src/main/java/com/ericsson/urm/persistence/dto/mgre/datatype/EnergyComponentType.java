/**
 * 
 */
package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;


public class EnergyComponentType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final EnergyComponentType ACTIVE = new EnergyComponentType ("ACTIVE");
	public static final EnergyComponentType INDUCTIVE = new EnergyComponentType ("INDUCTIVE");
	public static final EnergyComponentType CAPACITIVE = new EnergyComponentType ("CAPACITIVE");

	
	private final String literal;
	private EnergyComponentType (String literal) {
		this.literal = literal;
	}
	public static EnergyComponentType parse (String literal)	{	
		if (literal == null || literal.length() == 0)
			return null;
		if (ACTIVE.literal.equalsIgnoreCase(literal)) return ACTIVE;
		if (INDUCTIVE.literal.equalsIgnoreCase(literal)) return INDUCTIVE;
		if (CAPACITIVE.literal.equalsIgnoreCase(literal)) return CAPACITIVE;

		throw new IllegalArgumentException ("EnergyComponentType.parse: unsupported literal value " + literal);
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
		if (!(obj instanceof EnergyComponentType))
			return false;
		final EnergyComponentType other = (EnergyComponentType) obj;
		if (literal == null) {
			if (other.literal != null)
				return false;
		} else if (!literal.equals(other.literal))
			return false;
		return true;
	}
}
