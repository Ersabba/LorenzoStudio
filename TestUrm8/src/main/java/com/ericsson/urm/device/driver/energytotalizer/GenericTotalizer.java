package com.ericsson.urm.device.driver.energytotalizer;

import java.io.Serializable;
import java.util.Date;

public class GenericTotalizer implements Serializable {

	private static final long serialVersionUID = -1L;
	
	public static final int CURRENT_FREQUENCY_TYPE = 1;
	public static final int DAILY_FREQUENCY_TYPE = 2;
	public static final int MONTHLY_FREQUENCY_TYPE = 3;

	private int sampleFrequencyType = -1;
	private Date sampleDate = null;

	public int getSampleFrequencyType() {
		return sampleFrequencyType;
	}

	public void setSampleFrequencyType(int sampleFrequencyType) {
		this.sampleFrequencyType = sampleFrequencyType;
	}

	public Date getSampleDate() {
		return sampleDate;
	}

	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}

}
