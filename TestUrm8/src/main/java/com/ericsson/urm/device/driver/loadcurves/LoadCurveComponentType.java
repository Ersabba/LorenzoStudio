package com.ericsson.urm.device.driver.loadcurves;

import java.io.Serializable;

public class LoadCurveComponentType implements Serializable {
	
	private static final long serialVersionUID = -1L;
	private int type=-1;
	private String literal = null;
	private String extension = null;
	
	public static final LoadCurveComponentType COMP_TYPE_ACTIVE_ABSORBED = new LoadCurveComponentType("EEA","ECC",0);
	public static final LoadCurveComponentType COMP_TYPE_ACTIVE_SUPPLIED = new LoadCurveComponentType("EUA","EE",1);
	public static final LoadCurveComponentType COMP_TYPE_REACTIVE_INDUCTIVE_ABSORBED = new LoadCurveComponentType("EEI","RAI",2);
	public static final LoadCurveComponentType COMP_TYPE_REACTIVE_INDUCTIVE_SUPPLIED = new LoadCurveComponentType("EUI","REI",3);
	public static final LoadCurveComponentType COMP_TYPE_REACTIVE_CAPACITIVE_ABSORBED = new LoadCurveComponentType("EEC","RAC",4);
	public static final LoadCurveComponentType COMP_TYPE_REACTIVE_CAPACITIVE_SUPPLIED = new LoadCurveComponentType("EUC","REC",5);
	
	private LoadCurveComponentType(String literal,String extension,int type) {
		super();
		this.literal   = literal;
		this.type      = type;
		this.extension = extension;
	}

	public static LoadCurveComponentType parseInt (int value)	{			
		if (COMP_TYPE_ACTIVE_ABSORBED.type == value) return COMP_TYPE_ACTIVE_ABSORBED;
		if (COMP_TYPE_ACTIVE_SUPPLIED.type == value) return COMP_TYPE_ACTIVE_SUPPLIED;
		if (COMP_TYPE_REACTIVE_INDUCTIVE_ABSORBED.type == value) return COMP_TYPE_REACTIVE_INDUCTIVE_ABSORBED;
		if (COMP_TYPE_REACTIVE_INDUCTIVE_SUPPLIED.type == value) return COMP_TYPE_REACTIVE_INDUCTIVE_SUPPLIED;
		if (COMP_TYPE_REACTIVE_CAPACITIVE_ABSORBED.type == value) return COMP_TYPE_REACTIVE_CAPACITIVE_ABSORBED;
		if (COMP_TYPE_REACTIVE_CAPACITIVE_SUPPLIED.type == value) return COMP_TYPE_REACTIVE_CAPACITIVE_SUPPLIED;

		throw new IllegalArgumentException ("LoadCurveComponentType.parse: unsupported value " + value);
	}
	
	public static LoadCurveComponentType parseByExtension (String extension)	{			
		if (COMP_TYPE_ACTIVE_ABSORBED.extension.equalsIgnoreCase(extension)) return COMP_TYPE_ACTIVE_ABSORBED;
		if (COMP_TYPE_ACTIVE_SUPPLIED.extension.equalsIgnoreCase(extension)) return COMP_TYPE_ACTIVE_SUPPLIED;
		if (COMP_TYPE_REACTIVE_INDUCTIVE_ABSORBED.extension.equalsIgnoreCase(extension)) return COMP_TYPE_REACTIVE_INDUCTIVE_ABSORBED;
		if (COMP_TYPE_REACTIVE_INDUCTIVE_SUPPLIED.extension.equalsIgnoreCase(extension)) return COMP_TYPE_REACTIVE_INDUCTIVE_SUPPLIED;
		if (COMP_TYPE_REACTIVE_CAPACITIVE_ABSORBED.extension.equalsIgnoreCase(extension)) return COMP_TYPE_REACTIVE_CAPACITIVE_ABSORBED;
		if (COMP_TYPE_REACTIVE_CAPACITIVE_SUPPLIED.extension.equalsIgnoreCase(extension)) return COMP_TYPE_REACTIVE_CAPACITIVE_SUPPLIED;

		throw new IllegalArgumentException ("LoadCurveComponentType.parse: unsupported literal value " + extension);
	}
	
	public static LoadCurveComponentType parse (String literal)	{			
		if (COMP_TYPE_ACTIVE_ABSORBED.literal.equalsIgnoreCase(literal)) return COMP_TYPE_ACTIVE_ABSORBED;
		if (COMP_TYPE_ACTIVE_SUPPLIED.literal.equalsIgnoreCase(literal)) return COMP_TYPE_ACTIVE_SUPPLIED;
		if (COMP_TYPE_REACTIVE_INDUCTIVE_ABSORBED.literal.equalsIgnoreCase(literal)) return COMP_TYPE_REACTIVE_INDUCTIVE_ABSORBED;
		if (COMP_TYPE_REACTIVE_INDUCTIVE_SUPPLIED.literal.equalsIgnoreCase(literal)) return COMP_TYPE_REACTIVE_INDUCTIVE_SUPPLIED;
		if (COMP_TYPE_REACTIVE_CAPACITIVE_ABSORBED.literal.equalsIgnoreCase(literal)) return COMP_TYPE_REACTIVE_CAPACITIVE_ABSORBED;
		if (COMP_TYPE_REACTIVE_CAPACITIVE_SUPPLIED.literal.equalsIgnoreCase(literal)) return COMP_TYPE_REACTIVE_CAPACITIVE_SUPPLIED;

		throw new IllegalArgumentException ("LoadCurveComponentType.parse: unsupported literal value " + literal);
	}
	
	public String getExtension() {
		return extension;
	}

	public String getEnergyId() {
		return literal;	
	}
	
	public int intValue() {
		return type;
	}

	public String toString () {
		return literal;	
	}
	
	public int getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((literal == null) ? 0 : literal.hashCode());
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoadCurveComponentType other = (LoadCurveComponentType) obj;
		if (literal == null) {
			if (other.literal != null)
				return false;
		} else if (!literal.equals(other.literal))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
