/**
 * 
 */
package com.ericsson.urm.device.driver.registersblockprogramming;

/**
 * 
 * @Organization : Ericsson
 * 
 * @Organization_Unit: ACEA
 * 
 * @Author : Giampiero
 *
 * @Copyright : 2017
 * 
 * @Date : 25 set 2017
 * 
 * @Time : 11:13:36
 * 
 * @Project : DEVICE_DRIVER_INTERFACE
 * 
 * @Class :
 *        com.ericsson.urm.device.driver.registersblockprogramming.AbilitazioneDati
 * 
 */
public class AbilitazioneDati extends AbstractEnablingRegisterBlock {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2130891789120972102L;

//	public enum Measurement {
//		CURVE_INDUCTIVE_SUPPLIED,
//		CURVE_CAPACITIVE_SUPPLIED,
//		CURVE_ACTIVE_SUPPLIED,
//		CURVE_CAPACITIVE_ABSORBED,
//		CURVE_INDUCTIVE_ABSORBED,
//		CURVE_ACTIVE_ABSORBED,
//		TOTALIZER_INDUCTIVE_SUPPLIED,
//		TOTALIZER_CAPACITIVE_SUPPLIED,
//		TOTALIZER_ACTIVE_SUPPLIED,
//		TOTALIZER_CAPACITIVE_ABSORBED,
//		TOTALIZER_INDUCTIVE_ABSORBED,
//		TOTALIZER_ACTIVE_ABSORBED;
//	}
	
	public enum Measurement {
		TOTALIZER_ACTIVE_ABSORBED,
		TOTALIZER_INDUCTIVE_ABSORBED,
		TOTALIZER_CAPACITIVE_ABSORBED,
		TOTALIZER_ACTIVE_SUPPLIED,
		TOTALIZER_CAPACITIVE_SUPPLIED,
		TOTALIZER_INDUCTIVE_SUPPLIED,
		
		CURVE_ACTIVE_ABSORBED,
		CURVE_INDUCTIVE_ABSORBED,
		CURVE_CAPACITIVE_ABSORBED,
		CURVE_ACTIVE_SUPPLIED,
		CURVE_CAPACITIVE_SUPPLIED,
		CURVE_INDUCTIVE_SUPPLIED;
	}
	
	public AbilitazioneDati() {
		setSizeArray(Measurement.values().length);
		enableId(Measurement.TOTALIZER_ACTIVE_ABSORBED.ordinal());
		setBitOrder(BitCommandOrder.LITTLE_ENDIAN);
	}

	public void enableMeasurement(Measurement component) {
		switch (component) {
		case TOTALIZER_ACTIVE_ABSORBED:
			break;
		default:
			enableId(component.ordinal());
			break;

		}
	}
	
	public static void main(String[] args) {
		 AbilitazioneDati abil=new AbilitazioneDati();
		 abil.enableMeasurement(Measurement.CURVE_ACTIVE_SUPPLIED);
		 abil.enableMeasurement(Measurement.TOTALIZER_CAPACITIVE_ABSORBED);
		 abil.enableMeasurement(Measurement.TOTALIZER_INDUCTIVE_ABSORBED);
		 String measurement=abil.getBitString(BitCommandOrder.LITTLE_ENDIAN);
		 System.out.println(measurement);
	}
}
