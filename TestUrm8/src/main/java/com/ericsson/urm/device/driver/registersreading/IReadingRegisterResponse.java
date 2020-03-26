package com.ericsson.urm.device.driver.registersreading;

import java.io.Serializable;

public interface IReadingRegisterResponse extends Serializable {
	
	public byte[] getStatusWord();

	public TipoRegistro getTipoRegistro();

	public byte[] getRawRegisterValue();

}
