package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;

import com.ericsson.urm.persistence.dto.mgre.StorMisuPotMensili;

public class MaxPowerReadingSelectBO   extends ReadingSelectBO implements Serializable {

	
	private static final long serialVersionUID = -1L;
	private StorMisuPotMensili[] response=null;
	private String type=null;
	private String powerType=null;
	
	// renponse methods
	
	
	public MaxPowerReadingSelectBO() {
		super();
	}

	public MaxPowerReadingSelectBO(String type, String powerType) {
		super();
		this.type = type;
		this.powerType = powerType;
	}

	public StorMisuPotMensili[] getResponse(){
		return response;
	}

	public void setResponse(StorMisuPotMensili[] response) {
		this.response = response;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPowerType() {
		return powerType;
	}

	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}
}
