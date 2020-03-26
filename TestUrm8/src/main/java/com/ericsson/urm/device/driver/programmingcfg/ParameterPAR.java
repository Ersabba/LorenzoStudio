package com.ericsson.urm.device.driver.programmingcfg;

import java.io.Serializable;
import java.math.BigInteger;

import com.ericsson.urm.device.driver.programmingcfg.ParameterIP.Ipm;

public class ParameterPAR implements Serializable {

	private static final long serialVersionUID = -1L;
	private byte body = 0;

	public ParameterPAR() {
		super();
	}

	public ParameterPAR(byte body) {
		super();
		this.body = body;
	}

	public void setAlleggerimentoProgrammato(boolean par) {
		byte app = par ? (byte) 0x80 : (byte) 0;
		body = (byte) ((body & 0x7F) | app);
	}

	public boolean getAlleggerimentoProgrammato() {
		return ((body >> 7) & 0x01) == 1;
	}

	public void setAlleggerimentoEmergenza(boolean par) {
		byte app = par ? (byte) 0x40 : (byte) 0;
		body = (byte) ((body & 0xBF) | app);
	}

	public boolean getAlleggerimentoEmergenza() {
		return ((body >> 6) & 0x01) == 1;
	}

	public void setAbilitazioneRiarmoAL(boolean par) {
		byte app = par ? (byte) 0x20 : (byte) 0;
		body = (byte) ((body & 0xDF) | app);
	}

	public boolean getAbilitazioneRiarmoAL() {
		return ((body >> 5) & 0x01) == 1;
	}

	public void setAbilitazioneRiarmoCG(boolean par) {
		byte app = par ? (byte) 0x10 : (byte) 0;
		body = (byte) ((body & 0xEF) | app);
	}

	public boolean getAbilitazioneRiarmoCG() {
		return ((body >> 4) & 0x01) == 1;
	}

	public void setAbilitazionePerSuperoPotenza(boolean par) {
		byte app = par ? (byte) 0x08 : (byte) 0;
		body = (byte) ((body & 0xF7) | app);
	}

	public boolean getAbilitazionePerSuperoPotenza() {
		return ((body >> 3) & 0x01) == 1;
	}
	
	public static enum Ipm {
		IPM_NULL(0x00),
		IPM5(0x01),
		IPM10(0x02),
		IPM15(0x03),
		IPM30(0x04),
		IPM60(0x05);
		
		private byte ipmValue = 0;

		private Ipm(byte ipmValue) {
			this.ipmValue = (byte)(ipmValue & 0x07);
		}
		
		private Ipm(int ipmValue) {
			this((byte)(ipmValue & 0x07));
		}
		
		public static Ipm fromValue(byte ipmValue) {
			for(Ipm curr : Ipm.values()) {
				if(curr.ipmValue == ipmValue) {
					return curr;
				}
			}
			throw new IllegalArgumentException("Invalid value:"+ipmValue+" allowed: 1-5");
		}
		public static Ipm fromValue(int ipmValue) { 
			return fromValue((byte)(ipmValue & 0x07));
		}

		public int getIpmValue() {
			return ipmValue;
		}
		
		@Override
		public String toString() {
			String app = null;
			switch (ipmValue) {
				case 0: {
					app = "null value";
					break;
				}
				case 0x01: {
					app = "5 min";
					break;
				}
				case 0x02: {
					app = "10 min";
					break;
				}
				case 0x03: {
					app = "15 min";
					break;
				}
				case 0x04: {
					app = "30 min";
					break;
				}
				case 0x05: {
					app = "60 min";
					break;
				}
			}
			return "Ipm value: " + app;
		}
		
	}


	public void setIPM(Ipm ipm) {
		body = (byte) ((body & 0xF8) | (ipm.getIpmValue() & 0xff));
	}

	public Ipm getIPM() {
		try {
			return Ipm.fromValue((body & 0x07));
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

	public byte getBody() {
		return body;
	}

	@Override
	public String toString() {
		BigInteger bi = new BigInteger(new byte[] { 0, body });
		StringBuffer buf = new StringBuffer(bi.toString(2));
		while (buf.length() < 8)
			buf.insert(0, "0");
		return "BtPAR [body=" + buf + "]";
	}

	public static void main(String[] args) {
		/*
		 * byte app = 0; //11111001 app=(byte)0xf9; //11001011 app=(byte)0xCB;
		 * BtPAR par = new BtPAR(app); System.out.println("body = " +
		 * par.toString());
		 * 
		 * System.out.println(par.getAlleggerimentoProgrammato());
		 * System.out.println(par.getAlleggerimentoEmergenza());
		 * System.out.println(par.getAbilitazioneRiarmoAL());
		 * System.out.println(par.getAbilitazioneRiarmoCG());
		 * System.out.println(par.getAbilitazionePerSuperoPotenza());
		 * 
		 * 
		 * System.out.println(par.getIPM().toString());
		 * System.out.println(par.getIPM().equals(Ipm.IPM15));
		 */
		ParameterPAR par = new ParameterPAR();
		par.setAlleggerimentoProgrammato(true);
		par.setAbilitazionePerSuperoPotenza(true);
		par.setAbilitazioneRiarmoAL(true);
		par.setIPM(Ipm.IPM60);
		System.out.println(par.toString());

	}

}
