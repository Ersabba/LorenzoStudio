package com.ericsson.urm.device.driver.registersblockprogramming;

import java.util.Arrays;


public class Block8 implements RegistersBlock {

	private static final long	serialVersionUID	= -1L;

	private byte[] regValues = new byte[30];
	
	public Block8() {
		super();
		
		regValues[0] = (byte)(0x00);
		regValues[1] = (byte)(0x01);
		regValues[2] = (byte)(0x01);
	}
	
	public Block8(byte[] val_reg, boolean programmazioneLineaZVEIAbilitata,
			boolean festivitaNazionaliAbilitata,
			boolean gestioneOraLegaleAbilitata) {
		super();
		this.regValues = val_reg;
		
	}

	public Block8(byte[] regValues) {
		setRegValues(regValues);
	}

	public byte[] getRegValues() {
		return regValues;
	}

	public void setRegValues(byte[] regValues) {
		if( regValues!= null ) {
			int len = regValues.length > this.regValues.length ? this.regValues.length : regValues.length;
			
			this.regValues = Arrays.copyOfRange(regValues, 0, len);
		}
	}

	public boolean isProgrammazioneLineaZVEIAbilitata() {
		return (regValues[0] == 0x01);
	}

	public void setProgrammazioneLineaZVEIAbilitata(boolean programmazioneLineaZVEIAbilitata) {
		regValues[0] = (byte)(programmazioneLineaZVEIAbilitata ? 1 : 0);
	}

	public boolean isFestivitaNazionaliAbilitata() {
		return (regValues[1] == 0x01);
	}

	public void setFestivitaNazionaliAbilitata(boolean festivitaNazionaliAbilitata) {
		regValues[1] = (byte)(festivitaNazionaliAbilitata ? 1 : 0);
	}

	public boolean isGestioneOraLegaleAbilitata() {
		return (regValues[2] == 0x01);
	}

	public void setGestioneOraLegaleAbilitata(boolean gestioneOraLegaleAbilitata) {
		regValues[2] = (byte)(gestioneOraLegaleAbilitata ? 1 : 0);
	}
}
