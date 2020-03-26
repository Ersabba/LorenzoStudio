package com.ericsson.urm.device.driver.programmingcfg;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Classe che rappresenta i parametri relativi alle curve di carico:
 * abilitazione e relativo periodo di integrazione. Il body è strutturato nel
 * seguente modo: XMMMMMMM - il bit più significativo di abilitazione,indicato
 * con X, con valori 0 curve disabilitate, 1 abilitate - 7 bit, indicati con MMM
 * MMM M, per periodo di integrazione, valori permessi 15 30 60. I 7 bit
 * conterranno la codifica binaria del numero 15, 30 o 60
 * 
 * @author Davide
 * 
 */
public class ParameterIP implements Serializable {

	private static final long serialVersionUID = -1L;
	private byte body = 0;
	
	public ParameterIP(boolean enabled, Ipm ipm) {
		if (ipm == null )
			throw new IllegalArgumentException("Undefined argument ipm");
		
		this.body = (byte)((enabled ? 0x80 : 0x00) | ipm.getIpmValue());
	}

	public ParameterIP(byte body) {
		// valid test
		Ipm.fromValue(body & 0x7f);
		this.body = body;
	}
	public ParameterIP(int body) {
		this((byte)(body&0xff));
	}

	public ParameterIP() {
	}

	public boolean isAbilitato() {
		return ((body >> 7) & 0x1) == 1;
	}

	public void setAbilitato(boolean value) {
		byte app = value ? (byte) 0x80 : (byte) 0;

		body = (byte) ((body & 0x7F) | app);
	}

	public Ipm getIpm() {
		// escludo il bit più significativo dell'abilitazione e valuto i
		// restanti 7
		try {
			return Ipm.fromValue((body & 0x7F));
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

	public void setIpm(Ipm ipm) {
		body = (byte) ((body & 0x80) | ipm.ipmValue);
	}

	/**
	 * Classe che rappresenta il periodo di integrazione 15,30,60.
	 * 
	 * @author Davide
	 * 
	 */
	public static enum Ipm {
		IPM_15(15),
		IPM_30(30),
		IPM_60(60);
		
		/**
		 * valore dei 7 bit del periodo di integrazione.
		 */
		private byte ipmValue = 0;

		private Ipm(byte ipmValue) {
			this.ipmValue = ipmValue;
		}
		private Ipm(int ipmValue) {
			this.ipmValue = (byte)(ipmValue & 0xff);
		}
		
		public byte getIpmValue() {
			return ipmValue;
		}
		
		public static Ipm fromValue(byte value) {
			for(Ipm curr : Ipm.values()) {
				if(curr.ipmValue == value) {
					return curr;
				}
			}
			throw new IllegalArgumentException("Invalid value:"+value+" allowed: 15,30,60");
		}
		
		public static Ipm fromValue(int value) {
			return fromValue((byte)(value & 0xff));
		}
	}

	@Override
	public String toString() {
		BigInteger bi = new BigInteger(new byte[] { 0, body });
		StringBuffer buf = new StringBuffer(bi.toString(2));
		while (buf.length() < 8)
			buf.insert(0, "0");
		return "BtIP [body=" + buf + "]";
	}

	public byte getBody() {
		return body;
	}

	public static void main(String[] args) {
		/*
		 * //10001111 byte app=(byte)0x8F; BtIP bt= new BtIP(app);
		 * 
		 * System.out.println("abilitate "+bt.isAbilitato());
		 * System.out.println("perodo "+bt.getIpm().ipmValue);
		 */

		ParameterIP bt = new ParameterIP();
		bt.setAbilitato(false);
		bt.setIpm(Ipm.IPM_60);
		System.out.println(bt.toString());

	}

}
