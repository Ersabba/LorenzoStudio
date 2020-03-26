/**
 * 
 */
package com.ericsson.urm.device.driver.registersblockprogramming;

import com.ericsson.urm.util.ByteUtil;

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
 * @Time : 11:27:46
 * 
 * @Project : DEVICE_DRIVER_INTERFACE
 * 
 * @Class : com.ericsson.urm.device.driver.registersblockprogramming.ResetCommand
 * 
 */
public class ResetCommand extends AbstractEnablingRegisterBlock {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2001417095339514055L;

	
//	public enum ResetObjectType{
//		UNUSED_1,
//		UNUSED_2,
//		UNUSED_3,
//		UNUSED_4,
//		UNUSED_5,
//		TEST_BUTTON,
//		TEST_LED,
//		USB_CONNECTION_CENTER,
//		USB_LENNT_DATA_ACQUISITION,
//		PRIMITIVE_METER_ID,
//		USB_FAULT_CONNECTION_NUMBER,
//		PUSH_BUTTON_NUMBER,
//		RADIO_FAULT_CONNECTION_NUMBER,
//		NO_PRIMITIVE_CONNECTION_NUMBER,
//		ZVEI_FAULT_CONNECTION_NUMBER,
//		STATUS_WORD;
//	}
	
	public enum ResetObjectType{
		STATUS_WORD,
		ZVEI_FAULT_CONNECTION_NUMBER,
		NO_PRIMITIVE_CONNECTION_NUMBER,
		RADIO_FAULT_CONNECTION_NUMBER,
		PUSH_BUTTON_NUMBER,
		USB_FAULT_CONNECTION_NUMBER,
		PRIMITIVE_METER_ID,
		USB_LENNT_DATA_ACQUISITION,
		USB_CONNECTION_CENTER,
		TEST_LED,
		TEST_BUTTON,
		UNUSED_1,
		UNUSED_2,
		UNUSED_3,
		UNUSED_4,
		UNUSED_5;
	}
	
	public ResetCommand() {
		setSizeArray(ResetObjectType.values().length);
		setBitOrder(BitCommandOrder.LITTLE_ENDIAN);
	}

	public void enableReset(ResetObjectType resetObjectType) {
		switch (resetObjectType) {
		case UNUSED_1:
		case UNUSED_2:
		case UNUSED_3:
		case UNUSED_4:
		case UNUSED_5:
			break;
		default:
			enableId(resetObjectType.ordinal());
			break;
		}
	}
	
	public static void main(String[] args) {
		ResetCommand resetCommand= new ResetCommand();
		resetCommand.enableReset(ResetObjectType.TEST_LED);
		resetCommand.enableReset(ResetObjectType.STATUS_WORD);
		byte[] byter=new byte[0];
		String bitString = resetCommand.getBitString(BitCommandOrder.LITTLE_ENDIAN);
		byter=ByteUtil.appendBitString(byter, bitString);
		System.out.println(bitString);
		
	}
}

