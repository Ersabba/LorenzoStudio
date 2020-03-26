/**
 * 
 */
package com.ericsson.urm.device.driver.registersblockprogramming;

import java.util.Arrays;

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
 * @Time : 11:48:48
 * 
 * @Project : DEVICE_DRIVER_INTERFACE
 * 
 * @Class :
 *        com.ericsson.urm.device.driver.registersblockprogramming.AbstractEnablingRegisterBlock
 * 
 */
abstract class AbstractEnablingRegisterBlock implements RegistersBlock {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5933807574925194159L;

	private boolean[] enabledBit = new boolean[0];

	private BitCommandOrder bitCommandOrder;

	public enum BitCommandOrder {
		BIG_ENDIAN, LITTLE_ENDIAN;
	}

	void setSizeArray(int bitNumber) {
		this.enabledBit = new boolean[bitNumber];
	}

	void setBitOrder(BitCommandOrder bitCommandOrder) {
		this.bitCommandOrder = bitCommandOrder;
	}

	BitCommandOrder getBitOrder() {
		return bitCommandOrder;
	}

	void enableId(int bitId) {
		if (enabledBit.length < bitId) {
			enabledBit = Arrays.copyOf(enabledBit, bitId + 1);
		}
		this.enabledBit[bitId] = true;
	}

	String getBitString(BitCommandOrder bitCommandOrder) {
		String result = "";
		switch (bitCommandOrder) {
		case LITTLE_ENDIAN:
			for (int a = enabledBit.length - 1; a > -1; a--) {
				result += enabledBit[a] ? "1" : "0";
			}
			break;
		case BIG_ENDIAN:
			for (boolean b : enabledBit) {
				result += b ? "1" : "0";
			}
			break;
		}
		return result;
	}

	public final String getEnableWord() {
		return getBitString(getBitOrder());
	}
}
