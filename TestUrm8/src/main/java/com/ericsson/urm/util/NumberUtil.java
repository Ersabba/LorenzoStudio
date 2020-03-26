package com.ericsson.urm.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

public abstract class NumberUtil {
	
	private static final Map<Class<?>, Class<?>> PRIMITIVES_TO_WRAPPERS = new HashMap<Class<?>, Class<?>>() {
		private static final long serialVersionUID = 1L;
		{ 
			put(byte.class, Byte.class);
			put(double.class, Double.class);
			put(float.class, Float.class);
			put(int.class, Integer.class);
			put(long.class, Long.class);
			put(short.class, Short.class);
		};
	};
	
	@SuppressWarnings("unchecked")
	public static <T extends Number> T toNumber(String value, Class<T> clsRet) {
		if(clsRet==null) {
			throw new IllegalArgumentException("Argument clsRet not defined");
		}
		
		T result = null;
		
		if(value != null) {
			clsRet = clsRet.isPrimitive() ? (Class<T>)PRIMITIVES_TO_WRAPPERS.get(clsRet) : clsRet;
			
			if(clsRet.isAssignableFrom(Double.class)) {
				result = clsRet.cast(Double.valueOf(value));
			}
			else
			if(clsRet.isAssignableFrom(Float.class)) {
					result = clsRet.cast(Float.valueOf(value));
			}
			else {
				int j = value.lastIndexOf('.');
				if(j>=0) {
					value = value.substring(0,j);
				}

				if(clsRet.isAssignableFrom(Long.class)) {
					result = clsRet.cast(Long.valueOf(value));
				} 
				else
				if(clsRet.isAssignableFrom(Integer.class)) {
					result = clsRet.cast(Integer.valueOf(value));
				}
				else
				if(clsRet.isAssignableFrom(Short.class)) {
					result = clsRet.cast(Short.valueOf(value));
				}
				else
				if(clsRet.isAssignableFrom(Byte.class)) {
					result = clsRet.cast(Byte.valueOf(value));
				}
			}
		}
		return result;
	}

	public static byte[] toBytes(short input) {
		return toBytes(input,ByteOrder.LITTLE_ENDIAN);
	}
	public static byte[] toBytes(int input) {
		return toBytes(input,ByteOrder.LITTLE_ENDIAN);
	}
	public static byte[] toBytes(long input) {
		return toBytes(input,ByteOrder.LITTLE_ENDIAN);
	}

	public static byte[] toBytes(short input, ByteOrder byteOrder) {
		ByteBuffer bbuf = allocateByteBuffer(Short.SIZE/8, byteOrder);
		bbuf.putShort(input);
		bbuf.rewind();
		return bbuf.array();
	}
	
	public static byte[] toBytes(int input, ByteOrder byteOrder) {
		ByteBuffer bbuf = allocateByteBuffer(Integer.SIZE/8, byteOrder);
		bbuf.putInt(input);
		bbuf.rewind();
		return bbuf.array();
	}
	
	public static byte[] toBytes(long input, ByteOrder byteOrder) {
		ByteBuffer bbuf = allocateByteBuffer(Long.SIZE/8, byteOrder);
		bbuf.putLong(input);
		bbuf.rewind();
		return bbuf.array();
	}
	
	public static short asShort(byte[] input, int offset, ByteOrder byteOrder) {
		return allocateByteBuffer(Short.SIZE/8, input, offset, byteOrder).getShort();
	}
	
	public static int asInt(byte[] input, int offset, ByteOrder byteOrder) {
		return allocateByteBuffer(Integer.SIZE/8, input, offset, byteOrder).getInt();
	}
	
	public static long asLong(byte[] input, int offset, ByteOrder byteOrder) {
		return allocateByteBuffer(Long.SIZE/8, input, offset, byteOrder).getLong();
	}
	
	public static short asShort(byte[] input, ByteOrder byteOrder) {
		return asShort(input, 0, byteOrder);
	}
	public static int asInt(byte[] input, ByteOrder byteOrder) {
		return asInt(input, 0, byteOrder);
	}
	public static long asLong(byte[] input, ByteOrder byteOrder) {
		return asLong(input, 0, byteOrder);
	}
	
	public static short asShort(byte[] input) {
		return asShort(input, 0, null);
	}
	public static int asInt(byte[] input) {
		return asInt(input, 0, null);
	}
	public static long asLong(byte[] input) {
		return asLong(input, 0, null);
	}
	
	public static ByteBuffer asNewByteBuffer(int length, byte[] input, int offset, ByteOrder byteOrder) {
		return allocateByteBuffer(length, input, offset, byteOrder);
	}
	
	private static ByteBuffer allocateByteBuffer(int length, ByteOrder byteOrder) {
		if(byteOrder == null) {
			byteOrder = ByteOrder.LITTLE_ENDIAN;
		}
		ByteBuffer bbuf = ByteBuffer.allocate(length);
		bbuf.order(byteOrder);
		return bbuf;
	}
	
	private static ByteBuffer allocateByteBuffer(int retLength, byte[] input, int offset, ByteOrder byteOrder) {
		if(input==null) {
			throw new IllegalArgumentException("Undefined input parameter");
		}
		if(input.length - retLength - offset < 0) {
			throw new IllegalArgumentException("Required an input of at least "+retLength+" bytes");
		}
		if(byteOrder == null) {
			byteOrder = ByteOrder.LITTLE_ENDIAN;
		}
		ByteBuffer bbuf = ByteBuffer.wrap(input, offset, input.length - offset);
		bbuf.order(byteOrder);
		return bbuf;
	}
	

	public static byte[] getBytes(int input) {
		byte[] ret = new byte[4];
		ret[0] = (byte) (input & 0xff);
		ret[1] = (byte) ((input >> 8) & 0xff);
		ret[2] = (byte) ((input >> 16) & 0xff);
		ret[3] = (byte) ((input >> 24) & 0xff);
		return ret;

	}

	public static byte[] getBytes(long input) {
		int i=1;
		byte[] ret = new byte[8];
		ret[0] = (byte) (input & 0xff);
		ret[1] = (byte) ((input >> 8*(i++)) & 0xff);
		ret[2] = (byte) ((input >> 8*(i++)) & 0xff);
		ret[3] = (byte) ((input >> 8*(i++)) & 0xff);		
		ret[4] = (byte) ((input >> 8*(i++)) & 0xff);
		ret[5] = (byte) ((input >> 8*(i++)) & 0xff);
		ret[6] = (byte) ((input >> 8*(i++)) & 0xff);
		ret[7] = (byte) ((input >> 8*(i++)) & 0xff);
		
		return ret;
	}


	/**
	 * Metodo che converte un array di 4 byte nel corrispondente intero
	 * 
	 * @param bytes
	 * @return
	 */
	public static int getShortFromBytes(byte[] bytes) {
		if (bytes == null || bytes.length != 2)
			throw new IllegalArgumentException("Byte array must be not null and contains 4 bytes");

		int ret = 0;
		for (int i = 0; i < 2; i++) {
			ret = (ret | ((int) bytes[i] & 0xff) << (i * 8));
		}
		return ret;
	}



	/**
	 * Metodo che converte un array di 4 byte nel corrispondente intero
	 * 
	 * @param bytes
	 * @return
	 */
	public static int getIntFromBytes(byte[] bytes) {
		if (bytes == null || bytes.length != 4)
			throw new IllegalArgumentException("Byte array must be not null and contains 4 bytes");

		int ret = 0;
		for (int i = 0; i < 4; i++) {
			ret = (ret | ((int) bytes[i] & 0xff) << (i * 8));
		}
		return ret;
	}

	/**
	 * Metodo che converte un array di 8 byte nel corrispondente long
	 * 
	 * @param bytes
	 * @return
	 */
	public static long getLongFromBytes(byte[] bytes) {
		if (bytes == null || bytes.length != 8)
			throw new IllegalArgumentException("Byte array must be not null and contain 8 bytes");

		long ret = 0;
		for (int i = 0; i < 8; i++) {
			ret = (ret | ((int) bytes[i] & 0xff) << (i * 8));
		}
		return ret;
	}

	/**
	 * MEtodo che inverte l'ordine dei byte dell'array passato come input.
	 * 
	 * @param in
	 * @return reverse order byte o null se in==null
	 */
	public static byte[] reverseOrder(byte[] in) {
		byte[] ret = null;
		if (in != null) {
			int len = in.length;
			ret = new byte[len];

			for (int i = 0; i < len; i++) {
				ret[len - i - 1] = in[i];
			}
		}
		return ret;

	}

	/**
	 * Metodo che converte un array di bytes con bit di segno in un intero
	 * 
	 * @param in
	 * @return
	 */
	public static int getIntFromSignedBytes(byte[] in) {
		int ret = -1;
		int len = in.length;
		if (in == null || in.length > 4)
			throw new IllegalArgumentException("Invalid parameter: must be not null and contain al most 4 bytes");

		// il bit + significativo è il bit di segno
		int sign = ((in[len - 1] >> 7) & 0x01) == 1 ? -1 : 1;

		if (len < 4) {
			byte[] app = new byte[4];
			// normalizzo a 4 bytes
			System.arraycopy(in, 0, app, 0, len);
			// annullo il bit + significativo che ho incluso nel segno
			app[len - 1] &= 0x7f;
			in = app;
		}

		// annullo il bit + significativo e moltiplico per il segno
		ret = sign * NumberUtil.getIntFromBytes(in);

		return ret;

	}
	
	public static double arroundNumber( double number, int nDecimalCiphers ){
	    return Math.round( number * Math.pow( 10, nDecimalCiphers ) )/Math.pow( 10, nDecimalCiphers );
	}
	
	public static double multiplier(double value, int multipler) {
		return value * (Math.pow(10, multipler));
	}

}
