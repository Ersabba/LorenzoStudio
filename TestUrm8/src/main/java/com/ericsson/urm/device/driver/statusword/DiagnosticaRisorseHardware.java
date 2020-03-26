package com.ericsson.urm.device.driver.statusword;

import java.io.Serializable;

public class DiagnosticaRisorseHardware implements Serializable {
	
	
	private static final long serialVersionUID = -1L;
	
	private byte[]  rawData;

	private int parolaStatoMoc = -1;	
														
	private boolean modem = false;		// = 0 Modem spento
										// = 1 modem acceso
		
	public DiagnosticaRisorseHardware() {
		super();
	}

	public DiagnosticaRisorseHardware(byte[] toParse) {
		super();
		parse(toParse);
	}
	
	public void parse(byte[] toParse) {
		rawData = toParse;
	//Byte 49:57 informazioni riguardanti la diagnostica delle risorse hardware	
		if (toParse == null || toParse.length < 9)
			throw new IllegalArgumentException("Invalid message: it's null or has invalid length");		
		
		byte[] app = new byte[1];
		System.arraycopy(toParse, 0, app, 0, 1);
		int i = 1;
		this.parolaStatoMoc = toParse[i++] & 0xff;			
		this.modem = (toParse[i++] & 0xff) == 1;
		
	}

	
//	2Byte 49-50 -> dal bit 0 al bit 15

	public boolean isBaseTempiMocAssente() {
		return (parolaStatoMoc & 0x01) == 0x01;
	}
	
	public boolean isAnagraficaMocAssente() {
		return (parolaStatoMoc & 0x02) == 0x02;
	}
	
	public boolean isTamperingCC() {
		return (parolaStatoMoc & 0x04) == 0x04;
	}
	
	public boolean isMio2InAnomalia() {
		return (parolaStatoMoc & 0x08) == 0x08;
	}
	
	public boolean isMio1InAnomalia() {
		return (parolaStatoMoc & 0x10) == 0x10;
	}
		
	public boolean isEventiProvenientiDaMio() {
		return (parolaStatoMoc & 0x20) == 0x20;
	}
	
	public boolean isPnPInCorso() {
		return (parolaStatoMoc & 0x40) == 0x40;
	}
	
	public boolean isFabbrica() {
		return (parolaStatoMoc & 0x80) != 0x80;
	}	
	public boolean isTariffazione() {
		return (parolaStatoMoc & 0x80) == 0x80;
	}
	
	public boolean isPliniusFaseRGuasto() {
		return (parolaStatoMoc & 0x100) == 0x100;
	}
	
	public boolean isPliniusFaseSGuasto() {
		return (parolaStatoMoc & 0x200) == 0x200;
	}
	
	public boolean isPliniusFaseTGuasto() {
		return (parolaStatoMoc & 0x400) == 0x400;
	}
	
	public boolean isOrologioHardwareMocGuasto() {
		return (parolaStatoMoc & 0x800) == 0x800;
	}
	
	public boolean isLineaSerialeVersoMioGuasta() {
		return (parolaStatoMoc & 0x800) == 0x800;
	}
	
	public boolean isPerditaProgrammazioneDiUnPlinius() {
		return (parolaStatoMoc & 0x1000) == 0x1000;
	}
	
	public boolean isAttivitaPeriodicaMocInCorso() {
		return (parolaStatoMoc & 0x2000) == 0x2000;
	}
	
	public byte[] asByteArray() {
		return rawData;
	}
}
