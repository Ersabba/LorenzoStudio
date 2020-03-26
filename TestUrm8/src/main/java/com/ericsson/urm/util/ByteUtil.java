/**
 * 
 */
package com.ericsson.urm.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * @Date : 22 set 2017
 * 
 * @Time : 11:14:44
 * 
 * @Project : URMCommon
 * 
 * @Class : com.ericsson.urm.util.ByteUtil
 * 
 */
public abstract class ByteUtil {

	public enum BitCommandOrder {
		BIG_ENDIAN, LITTLE_ENDIAN;
	}

	/**
	 * 
	 * @param original
	 * @param toAppend
	 * @return
	 */
	public static byte[] appendBytes(byte[] original, byte[] toAppend) {
		
		byte[] result = new byte[original.length + toAppend.length];
		System.arraycopy(original, 0, result, 0, original.length);
		System.arraycopy(toAppend, 0, result, original.length, toAppend.length);
		return result;
		
//		for (byte b : toAppend) {
//			original = appendByte(original, b);
//		}
//		return original;
	}

	/**
	 * 
	 * @param original
	 * @param toAppend
	 * @return
	 */
	public static byte[] appendByte(byte[] original, byte toAppend) {
		original = Arrays.copyOf(original, original.length + 1);
		original[original.length - 1] = toAppend;
		return original;
	}

	/**
	 * 
	 * @param original
	 * @param toAppend
	 * @return
	 */
	public static byte[] appendInt(byte[] original, int toAppend) {
		return appendByte(original, convertInt(toAppend));
	}

	public static byte[] appendBitString(byte[] original, String bitStringToAppend) {
		return appendBytes(original, convertBitString(bitStringToAppend, BitCommandOrder.LITTLE_ENDIAN));
	}

	private static final byte convertInt(int toConvert) {
		//byte converted = new BigInteger(Integer.toHexString(toConvert), 16).byteValue();
		byte converted = (byte)(toConvert&0xff);
		return converted;
	}

	public static final byte[] convertBitString(String bitStringToConvert, BitCommandOrder bitCommandOrder) {
		switch (bitCommandOrder) {
		case LITTLE_ENDIAN:
			bitStringToConvert = new StringBuilder(bitStringToConvert).reverse().toString();
			break;
		}

		int module = bitStringToConvert.length() % 8;
		int divider = bitStringToConvert.length() / 8;
		List<String> biteList = new ArrayList<String>();
		int indx = 0;
		for (int a = 0; a < divider; a++) {
			biteList.add(bitStringToConvert.substring(indx, indx += 8));
		}
		if (module > 0) {
			biteList.add(bitStringToConvert.substring(indx, indx += module));
		}
		byte[] result = new byte[0];
		for (String string : biteList) {
			String hexString = new BigInteger(string, 2).toString(16);
			StringBuffer buffer = new StringBuffer(hexString);
			if (buffer.length() < 2) {
				buffer.insert(0, "0");
			}
			result = appendInt(result, Integer.parseInt(buffer.toString(), 16));
		}

		return result;
	}

	public final static String convertArrayToBitString(byte[] toConvert, BitCommandOrder bitCommandOrder) {
		StringBuffer buffer = new StringBuffer();
		for (byte b : toConvert) {
			buffer.append(convertToBitString(b));
		}
		switch (bitCommandOrder) {
		case LITTLE_ENDIAN:
			buffer = buffer.reverse();
			break;
		}
		return buffer.toString();
	}

	public static byte[] reverseByteArray(byte[] array) {
		byte[] result = new byte[array.length];
		int indx = 0;
		for (int a = array.length - 1; a > -1; a--) {
			result[indx++] = array[a];
		}
		return result;
	}
	
	public final static String convertToBitString(byte toConvert) {
		BigInteger bigInt = new BigInteger(new byte[] { toConvert });
		return bigInt.toString(2);
	}

	public static final int getInt(byte toConvert) {
		int converted = new BigInteger(Integer.toHexString(toConvert), 16).intValue();
		return converted;
	}

	public static final byte getByte(int toConvert) {
		return convertInt(toConvert);
	}

	public static final byte[] hexStringToByteArray(String hexString) {
		byte[] result = new byte[0];
		if (hexString == null || hexString.length() % 2 != 0) {
			throw new RuntimeException("The length of string must be even");
		}
		StringBuilder builder = new StringBuilder(hexString);

		while (builder.length() >= 2) {
			result = Arrays.copyOf(result, result.length + 1);
			result[result.length - 1] = getByte(Integer.parseInt(builder.substring(0, 2), 16));
			builder.delete(0, 2);
		}

		return result;
	}

	public static final String byteToHexString(byte data) {
		return String.format("%02X", data);
	}

	public static final String byteArrayToHexString(byte[] data) {
		if (data == null) {
			throw new RuntimeException("The input parameter can't be a null value");
		}
		StringBuilder builder = new StringBuilder();
		for (byte b : data) {
			builder.append(byteToHexString(b));
		}

		return builder.toString();
	}

	public static final byte[] copyRange(byte[] data, int startIndex, int endIndex) {
		return Arrays.copyOfRange(data, startIndex, endIndex);
	}
	
	public static Byte[] convertPrimitiveArray(byte[] toConvert) {
		Byte[] result = new Byte[0];
		for (byte current : toConvert) {
			result = Arrays.copyOf(result, result.length + 1);
			result[result.length - 1] = Byte.valueOf(current);
		}
		return result;
	}

	public static void main(String[] args) {
		try {
			byte[] hexStringToByteArray = hexStringToByteArray("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");

			System.out.println(byteArrayToHexString(hexStringToByteArray));
			byte appo = convertInt(-1);
			System.out.println(appo);
		} catch (Throwable e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}
