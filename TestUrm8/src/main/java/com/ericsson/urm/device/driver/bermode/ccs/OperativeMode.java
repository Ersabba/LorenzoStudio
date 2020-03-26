package com.ericsson.urm.device.driver.bermode.ccs;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class OperativeMode implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private byte[]  rawData;

	//ByteBuffer
	
	
	private int opMode = OperationMode.BER.getValue();
	private int restoreTimeout = 14400; //0 oppure da 60 a 32000. Nel btcommand è di 4 bytes
	private int typeBERMode = BERMode.RICEVITORE.getValue();
	private int pclFrequency = Frequenza.KHZ82.getValue(); 
	private int phaseSynchr = Fase.R.getValue();
	private int toneGeneration = Tono.DISATTIVO.getValue();
	private int zeroCrossing = ZeroCrossing.YES.getValue();
	
	
	public OperativeMode() {
		super();
	}

	public OperativeMode(byte[] toParse) {
		super();
		parse(toParse);
	}
	public void parse(byte[] toParse) {
		rawData = toParse;

		opMode = toParse[1] & 0xff;
		byte[] app = new byte[4];
		System.arraycopy(toParse, 2, app, 0, app.length);
		restoreTimeout = getIntFromNBytes(app, app.length);
		typeBERMode = toParse[6] & 0xff;
		pclFrequency = toParse[7] & 0xff;
		phaseSynchr = toParse[8] & 0xff;
		toneGeneration = toParse[9] & 0xff;
		zeroCrossing = toParse[10] & 0xff;
	}
	
	/*public void parse(byte[] toParse) {
		rawData = toParse;
	//Byte 49:57 informazioni riguardanti la diagnostica delle risorse hardware	
		if (toParse == null || toParse.length < 9)
			throw new IllegalArgumentException("Invalid message: it's null or has invalid length");		
		
		byte[] app = new byte[1];
		System.arraycopy(toParse, 0, app, 0, 1);
		int i = 1;
		this.parolaStatoMoc = toParse[i++] & 0xff;			
		this.modem = (toParse[i++] & 0xff) == 1;
		
	}*/
	
	public static enum OperationMode {
		STANDARD(0), MONITOR(1), BER(2);
		
		private int value = -1;

		private OperationMode(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static OperationMode parseValue(int newValue) {
			for(OperationMode ret : OperationMode.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	
	public static enum BERMode {
		TRASMETTITORE(1), RICEVITORE(2);
		
		private int value = -1;

		private BERMode(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static BERMode parseValue(int newValue) {
			for(BERMode ret : BERMode.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	
	public static enum Frequenza {
		KHZ82(1), KHZ66(2);
		
		private int value = -1;

		private Frequenza(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static Frequenza parseValue(int newValue) {
			for(Frequenza ret : Frequenza.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	public static enum Fase {
		R(1), S(2), T(3);
		
		private int value = -1;

		private Fase(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static Fase parseValue(int newValue) {
			for(Fase ret : Fase.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	public static enum Tono {
		DISATTIVO(0), SPACE(1), MARK(2);
		
		private int value = -1;

		private Tono(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static Tono parseValue(int newValue) {
			for(Tono ret : Tono.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	public static enum ZeroCrossing {
		NO(0), YES(1);
		
		private int value = -1;

		private ZeroCrossing(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static ZeroCrossing parseValue(int newValue) {
			for(ZeroCrossing ret : ZeroCrossing.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	
	/**
	 * Metodo che converte un array di N byte nel corrispondente intero
	 * 
	 * @param bytes
	 * @return
	 */
	private int getIntFromNBytes(byte[] bytes, int length) {
		if (bytes == null || bytes.length != length)
			throw new IllegalArgumentException("Byte array must be not null and contains "+length+" bytes");

		int ret = 0;
		for (int i = 0; i < length; i++) {
			ret = (ret | ((int) bytes[i] & 0xff) << (i * 8));
		}
		return ret;
	}
	
	private byte[] getByteFromInt(int valore) {
		
		byte[] b = new byte[4];
		
		b[0] = (byte)(valore & 0xFF);
		b[1] = (byte)((valore>>>8) & 0xFF);
		b[2] = (byte)((valore>>>16) & 0xFF);
		b[3] = (byte)((valore>>>24) & 0xFF);
		
		return b;
		
	}
	
	public byte[] asByteArray() {
		return rawData;
	}

	public byte[] getRawData() {
		return rawData;
	}


	public int getOpMode() {
		return opMode;
	}


	public int getRestoreTimeout() {
		return restoreTimeout;
	}


	public int getTypeBERMode() {
		return typeBERMode;
	}


	public int getPclFrequency() {
		return pclFrequency;
	}

	public int getPhaseSynchr() {
		return phaseSynchr;
	}

	public int getToneGeneration() {
		return toneGeneration;
	}

	public int getZeroCrossing() {
		return zeroCrossing;
	}

	public void setRawData(byte[] rawData) {
		this.rawData = rawData;
	}

	public void setOpMode(int opMode) {
		this.opMode = opMode;
	}

	public void setRestoreTimeout(int restoreTimeout) {
		this.restoreTimeout = restoreTimeout;
	}

	public void setTypeBERMode(int typeBERMode) {
		this.typeBERMode = typeBERMode;
	}

	public void setPclFrequency(int pclFrequency) {
		this.pclFrequency = pclFrequency;
	}

	public void setPhaseSynchr(int phaseSynchr) {
		this.phaseSynchr = phaseSynchr;
	}

	public void setToneGeneration(int toneGeneration) {
		this.toneGeneration = toneGeneration;
	}

	public void setZeroCrossing(int zeroCrossing) {
		this.zeroCrossing = zeroCrossing;
	}
	
	
	

}
