package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.LinkedHashSet;

import com.ericsson.urm.device.driver.datatype.ComponentId;

public class PunctualMonthlyMeasuresExtraParams implements Serializable {
	
	public static enum PunctualMonthlyMeasureExtraKeys {
		
		LENNT_NUMBER_TO_ASK("LENNT_NUMBER_TO_ASK"),
		REQUESTED_ENERGY_COMPONENTS("REQUESTED_ENERGY_COMPONENTS"), 
		REQUESTED_IPM("REQUESTED_IPM");
		
		private String value;
		
		private PunctualMonthlyMeasureExtraKeys(String value){
			this.value = value;
		}

		public String getValue() {
			return value;
		}
		
		public static PunctualMonthlyMeasureExtraKeys parse (String value){
			for(PunctualMonthlyMeasureExtraKeys curr : PunctualMonthlyMeasureExtraKeys.values()){
				if(curr.toString().equalsIgnoreCase(value)){
					return curr;					
				}
			}
			
			throw new IllegalArgumentException ("PunctualMonthlyMeasureExtraKeys: unsupported value " + value);
		}
		
	}

	private static final long serialVersionUID = 1L;
	
	private LinkedHashSet<ComponentId> requestedEnergyComponents = new LinkedHashSet<ComponentId>();
	private boolean ipmRequested;
	private Integer maxLenntNumber;
	
	public PunctualMonthlyMeasuresExtraParams() {
	}

	
	public PunctualMonthlyMeasuresExtraParams(
			LinkedHashSet<ComponentId> requestedEnergyComponents,
			boolean ipmRequested, Integer maxLenntNumber) {
		super();
		this.requestedEnergyComponents = requestedEnergyComponents;
		this.ipmRequested = ipmRequested;
		this.maxLenntNumber = maxLenntNumber;
	}

	public LinkedHashSet<ComponentId> getRequestedEnergyComponents() {
		return requestedEnergyComponents;
	}


	public void setRequestedEnergyComponents(
			LinkedHashSet<ComponentId> requestedEnergyComponents) {
		this.requestedEnergyComponents = requestedEnergyComponents;
	}


	public boolean isIpmRequested() {
		return ipmRequested;
	}

	public void setIpmRequested(boolean ipmRequested) {
		this.ipmRequested = ipmRequested;
	}

	public Integer getMaxLenntNumber() {
		return maxLenntNumber;
	}

	public void setMaxLenntNumber(Integer maxLenntNumber) {
		this.maxLenntNumber = maxLenntNumber;
	}
	
			
}
