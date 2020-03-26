package com.ericsson.urm.device.driver.datatype;

import java.util.HashSet;
import java.util.Set;


public enum ComponentId {
	ACTIVE_ABSORBED("EEA",0),
	ACTIVE_SUPPLIED("EUA",1), 
	INDUCTIVE_ABSORBED("EEI",2),
	INDUCTIVE_SUPPLIED("EUI",3),
	CAPACITIVE_ABSORBED("EEC",4), 
	CAPACITIVE_SUPPLIED("EUC",5);
	
	private String acronym;
	private int index;
	private EnergyType type;
	private String direction;
	
	private ComponentId(String acronym, int index) {
		this.acronym = acronym;
		this.index = index;
		this.setType(index);
		this.setDirection(index);
	}
	
	

	public String getAcronym() {
		return acronym;
	}

	public int getIndex() {
		return index;
	}
	public EnergyType getType(){
		return type;
	}

	public String getDirection() {
		return direction;
	}
	
	public static ComponentId valueOf(int index)	{
		for (ComponentId curr : ComponentId.values()) {
			if(curr.index == index) { return curr; }
		}	
		throw new IllegalArgumentException ("Componente: unsupported index " + index);
	}
	
	public static boolean isComponent(String typeName)	{	
		for (ComponentId curr : ComponentId.values()) {
			if(curr.toString().equalsIgnoreCase(typeName)) { return true; }
			if(curr.acronym.equalsIgnoreCase(typeName)) { return true; }
		}
		
		return false;
	}
	
	public static ComponentId parse(String typeName)	{	
		for (ComponentId curr : ComponentId.values()) {
			if(curr.toString().equalsIgnoreCase(typeName)) { return curr; }
			if(curr.acronym.equalsIgnoreCase(typeName)) { return curr; }
		}
		
		throw new IllegalArgumentException ("Componente: unsupported type name " + typeName);
	}

	public static Set<ComponentId> getAll() {
	   Set<ComponentId> comps = new HashSet<ComponentId>();
		for (ComponentId c : values())
			comps.add(c);
		return comps;
		//return (Set<ComponentId>) Arrays.asList(values());
	}


	private void setType(int index) {
		switch(index){
			case 0: 
			case 1: this.type = EnergyType.ACTIVE;
			break;
			case 2:
			case 3: this.type = EnergyType.INDUCTIVE;
			break;
			case 4:
			case 5: this.type = EnergyType.CAPACITIVE;
			break;
			default: throw new IllegalArgumentException ("setType(Component): unsupported index " + index );
		}				
	}
	
	
	private void setDirection(int index) {
			switch(index){
			case 0:
			case 2:
			case 4:
				this.direction = EnergyDirection.ABSORBED.toString();
				break;
			case 1:
			case 3:
			case 5:
				this.direction = EnergyDirection.SUPPLIED.toString();
				break;
			default:
				throw new IllegalArgumentException("setDirection(Component): unsupported index " + index);
			}		
		}		
		
}
