package com.ericsson.urm.device.driver.registersreading;

import java.util.Set;

import com.ericsson.urm.device.driver.registersblockprogramming.AbilitazioneDati.Measurement;

public interface IEnablingMeasurementResponse extends IReadingRegisterResponse {
	
	public Set<Measurement> getEnabledMeasurement();
}
