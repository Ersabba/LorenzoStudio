package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;



public class EnergyComponentId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final EnergyComponentId EEA = new EnergyComponentId ("EEA","ECC",0);
	public static final EnergyComponentId EUA = new EnergyComponentId ("EUA","EE",1);
	public static final EnergyComponentId EEI = new EnergyComponentId ("EEI","RAI",2);
	public static final EnergyComponentId EUI = new EnergyComponentId ("EUI","REI",3);
	public static final EnergyComponentId EEC = new EnergyComponentId ("EEC","RAC",4);
	public static final EnergyComponentId EUC = new EnergyComponentId ("EUC","REC",5);
	
	private final String literal;
	private final String ext;
	private final int value;
	
	private EnergyComponentId (String literal,String ext, int value) {
		this.literal = literal;
		this.ext = ext;
		this.value = value;
	}
	
	public static EnergyComponentId parseInt (int value)	{			
		if (EEA.value == value) return EEA;
		if (EUA.value == value) return EUA;
		if (EEI.value == value) return EEI;
		if (EUI.value == value) return EUI;
		if (EEC.value == value) return EEC;
		if (EUC.value == value) return EUC;

		throw new IllegalArgumentException ("EnergyComponentType.parse: unsupported value " + value);
	}
	
	public static EnergyComponentId parseAsExt (String ext)	{			
		if (EEA.ext.equalsIgnoreCase(ext)) return EEA;
		if (EUA.ext.equalsIgnoreCase(ext)) return EUA;
		if (EEI.ext.equalsIgnoreCase(ext)) return EEI;
		if (EUI.ext.equalsIgnoreCase(ext)) return EUI;
		if (EEC.ext.equalsIgnoreCase(ext)) return EEC;
		if (EUC.ext.equalsIgnoreCase(ext)) return EUC;

		throw new IllegalArgumentException ("EnergyComponentType.parse: unsupported extention name value " + ext);
	}
	
	public static EnergyComponentId parse (String literal)	{			
		if (EEA.literal.equalsIgnoreCase(literal)) return EEA;
		if (EUA.literal.equalsIgnoreCase(literal)) return EUA;
		if (EEI.literal.equalsIgnoreCase(literal)) return EEI;
		if (EUI.literal.equalsIgnoreCase(literal)) return EUI;
		if (EEC.literal.equalsIgnoreCase(literal)) return EEC;
		if (EUC.literal.equalsIgnoreCase(literal)) return EUC;

		throw new IllegalArgumentException ("EnergyComponentType.parse: unsupported literal value " + literal);
	}
	
	public static EnergyComponentId parse (EnergyComponentType ect, EnergyFlowDirectionType efdt)	{			
		if (ect.equals(EnergyComponentType.ACTIVE) && efdt.equals(EnergyFlowDirectionType.ABSORBED)) return EEA;
		if (ect.equals(EnergyComponentType.ACTIVE) && efdt.equals(EnergyFlowDirectionType.SUPPLIED)) return EUA;
		if (ect.equals(EnergyComponentType.INDUCTIVE) && efdt.equals(EnergyFlowDirectionType.ABSORBED)) return EEI;
		if (ect.equals(EnergyComponentType.INDUCTIVE) && efdt.equals(EnergyFlowDirectionType.SUPPLIED)) return EUI;
		if (ect.equals(EnergyComponentType.CAPACITIVE) && efdt.equals(EnergyFlowDirectionType.ABSORBED)) return EEC;
		if (ect.equals(EnergyComponentType.CAPACITIVE) && efdt.equals(EnergyFlowDirectionType.SUPPLIED)) return EUC;

		throw new IllegalArgumentException ("EnergyComponentType.parse: unsupported EnergyComponentType[" 
				                            + ect.toString()+
				                            "] and EnergyFlowDirectionType["+efdt.toString()+"]");
	}
	
	public EnergyComponentType getEnergyComponentType() {
		if (EEA.literal.equals (literal)) return EnergyComponentType.ACTIVE;
		if (EUA.literal.equals (literal)) return EnergyComponentType.ACTIVE;
		if (EEI.literal.equals (literal)) return EnergyComponentType.INDUCTIVE;
		if (EUI.literal.equals (literal)) return EnergyComponentType.INDUCTIVE;
		if (EEC.literal.equals (literal)) return EnergyComponentType.CAPACITIVE;
		if (EUC.literal.equals (literal)) return EnergyComponentType.CAPACITIVE;
		
		return null;
	}
	
	public EnergyFlowDirectionType getEnergyFlowDirectionType() {
		if (EEA.literal.equals (literal)) return EnergyFlowDirectionType.ABSORBED;
		if (EUA.literal.equals (literal)) return EnergyFlowDirectionType.SUPPLIED;
		if (EEI.literal.equals (literal)) return EnergyFlowDirectionType.ABSORBED;
		if (EUI.literal.equals (literal)) return EnergyFlowDirectionType.SUPPLIED;
		if (EEC.literal.equals (literal)) return EnergyFlowDirectionType.ABSORBED;
		if (EUC.literal.equals (literal)) return EnergyFlowDirectionType.SUPPLIED;
		
		return null;
	}
	
	public String getEnergyId() {
		return literal;	
	}
	
	public String getExtentionName () {
		return ext;	
	}
	
	public int intValue() {
		return value;
	}

	public String toString () {
		return literal;	
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ext == null) ? 0 : ext.hashCode());
		result = prime * result + ((literal == null) ? 0 : literal.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnergyComponentId other = (EnergyComponentId) obj;
		if (ext == null) {
			if (other.ext != null)
				return false;
		} else if (!ext.equals(other.ext))
			return false;
		if (literal == null) {
			if (other.literal != null)
				return false;
		} else if (!literal.equals(other.literal))
			return false;
		return true;
	}
	
}
