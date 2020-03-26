package com.ericsson.urm.device.driver.display;

import java.io.Serializable;

import com.ericsson.urm.device.driver.registersblockprogramming.Block1;
import com.ericsson.urm.device.driver.registersreading.TipoRegistro;

public class DisplayStatus implements Serializable {

	private static final long serialVersionUID = -1L;
	private byte[] statusWord = null;
	private TipoRegistro tipoRegistro = null;
	private Block1 block1 = null;
	
	
	
	public byte[] getStatusWord() {
		return statusWord;
	}

	public void setStatusWord(byte[] statusWord) {
		this.statusWord = statusWord;
	}

	public TipoRegistro getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(TipoRegistro tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public void setBlock1(byte[] regValues) {
		block1 = new Block1();
		block1.setDisplayParameter(regValues);
	}

	public Block1 getBlock1() {
		return block1;
	}


	public void setBlock1(Block1 block1) {
		this.block1 = block1;
	}
	
	
}
