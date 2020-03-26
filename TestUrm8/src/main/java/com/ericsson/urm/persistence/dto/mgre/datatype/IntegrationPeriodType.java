package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;

/**	
 * Typed enumeration class whose purpose is to abstract	
 * the PowerType (ACTIVE, INDUCTIVE or CAPACITIVE).	 
 */	
public class IntegrationPeriodType implements Serializable	{
	private static final long serialVersionUID = 1L;
	
	public static final IntegrationPeriodType IPM = new IntegrationPeriodType ("IPM");
	public static final IntegrationPeriodType ONE_MINUTE = new IntegrationPeriodType ("1MIN");
	

	private final String literal;
	private IntegrationPeriodType (String literal) {
		this.literal = literal;
	}
	public static IntegrationPeriodType parse (String literal)	{	
		if (literal == null || literal.length() == 0)
			return null;
		if (IPM.literal.equalsIgnoreCase(literal)) return IPM;
		if (ONE_MINUTE.literal.equalsIgnoreCase(literal)) return ONE_MINUTE;
		
		throw new IllegalArgumentException ("IntegrationPeriod.parse: unsupported literal value " + literal);
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
		if (!(obj instanceof IntegrationPeriodType))
			return false;
		final IntegrationPeriodType other = (IntegrationPeriodType) obj;
		if (literal == null) {
			if (other.literal != null)
				return false;
		} else if (!literal.equals(other.literal))
			return false;
		return true;
	}
	
	
	
}
