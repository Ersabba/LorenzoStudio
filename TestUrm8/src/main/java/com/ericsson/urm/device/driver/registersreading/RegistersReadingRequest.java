package com.ericsson.urm.device.driver.registersreading;

import java.io.Serializable;

public class RegistersReadingRequest implements Serializable {
	
	private TipoRegistro tipoRegistro = null;
	private byte[] parametri = null;
	
	private RegistersReadingRequest(TipoRegistro tipoRegistro, byte[] parametri) {
		super();
		this.tipoRegistro = tipoRegistro;
		this.parametri = parametri;
	}
	public TipoRegistro getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(TipoRegistro tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public byte[] getParametri() {
		return parametri;
	}
	public void setParametri(byte[] parametri) {
		this.parametri = parametri;
	}
	
}
