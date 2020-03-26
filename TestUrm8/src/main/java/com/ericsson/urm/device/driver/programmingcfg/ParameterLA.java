package com.ericsson.urm.device.driver.programmingcfg;

import java.io.Serializable;
import java.math.BigInteger;

public class ParameterLA implements Serializable {

	private byte body = 0;

	public ParameterLA() {
		super();
	}

	public ParameterLA(byte body) {
		super();
		this.body = body;
	}

	public void setVariazioneParametriContrattuali(boolean value) {
		byte app = value ? (byte) 1 : (byte) 0;
		body = (byte) ((body & 0xFE) | app);
	}

	public boolean getVariazioneParametriContrattuali() {
		return (body & 0x1) == 1;
	}

	public void setComandoAttivazioneFornitura(boolean value) {
		byte app = value ? (byte) 0x2 : (byte) 0;
		body = (byte) ((body & 0xFD) | app);
	}

	public boolean getComandoAttivazioneFornitura() {
		return ((body >> 1) & 0x1) == 1;
	}

	public void setComandoDistacco(boolean value) {
		byte app = value ? (byte) 0x4 : (byte) 0;
		body = (byte) ((body & 0xFB) | app);
	}

	public boolean getComandoDistacco() {
		return ((body >> 2) & 0x1) == 1;
	}

	public void setAbilitazioneAperturaInterruttore(boolean value) {
		byte app = value ? (byte) 0x8 : (byte) 0;
		body = (byte) ((body & 0xF7) | app);
	}

	public boolean getAbilitazioneAperturaInterruttore() {
		return ((body >> 3) & 0x1) == 1;
	}

	public void setComandoSegregazioneFatturazione(boolean value) {
		byte app = value ? (byte) 0x10 : (byte) 0;
		body = (byte) ((body & 0xEF) | app);
	}

	public boolean getComandoSegregazioneFatturazione() {
		return ((body >> 4) & 0x1) == 1;
	}

	public void setComandoRiarmoCG(boolean value) {
		byte app = value ? (byte) 0x20 : (byte) 0;
		body = (byte) ((body & 0xDF) | app);
	}

	public boolean getComandoRiarmoCG() {
		return ((body >> 5) & 0x1) == 1;
	}

	public void setComandoTariffaBase(boolean value) {
		byte app = value ? (byte) 0x40 : (byte) 0;
		body = (byte) ((body & 0xBF) | app);
	}

	public boolean getComandoTariffaBase() {
		return ((body >> 6) & 0x1) == 1;
	}

	public void setComandoAnnullamentoProceduraCommerciale(boolean value) {
		byte app = value ? (byte) 0x80 : (byte) 0;
		body = (byte) ((body & 0x7F) | app);
	}

	public boolean getComandoAnnullamentoProceduraCommerciale() {
		return ((body >> 7) & 0x1) == 1;
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
		return "BtLA [body=" + buf + "]";
	}

	public static void main(String[] args) {
		// 11110011
		byte app = (byte) 0xf3;

		ParameterLA bt = new ParameterLA();
		bt.setVariazioneParametriContrattuali(true);
		bt.setComandoAttivazioneFornitura(true);
		bt.setComandoDistacco(true);
		bt.setAbilitazioneAperturaInterruttore(true);
		bt.setComandoSegregazioneFatturazione(true);
		bt.setComandoRiarmoCG(true);
		bt.setComandoTariffaBase(true);
		bt.setComandoAnnullamentoProceduraCommerciale(true);

		System.out.println(bt.toString());

	}

}
