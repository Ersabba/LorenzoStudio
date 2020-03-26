package com.ericsson.urm.device.driver.configuration;

import java.io.Serializable;
import java.util.ArrayList;

public class ReadoutResponse implements Serializable {

	private ArrayList<String> lines = null;

	public ReadoutResponse(ArrayList<String> lines) {
		super();
		this.lines = lines;
	}

	public ArrayList<String> getLines() {
		return lines;
	}

	public void setLines(ArrayList<String> lines) {
		this.lines = lines;
	}

}
