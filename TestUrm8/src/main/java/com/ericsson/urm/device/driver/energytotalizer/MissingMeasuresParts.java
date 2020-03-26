package com.ericsson.urm.device.driver.energytotalizer;

import java.io.Serializable;
import java.util.Date;

public class MissingMeasuresParts implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Date dataMissing = null; 
	
	private int status = 0;

	public Date getDataMissing() {
		return dataMissing;
	}

	public void setDataMissing(Date dataMissing) {
		this.dataMissing = dataMissing;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
//	private int missedIntegerPart = 0;
//	private int missedGenFrazPart = 0;
//	private int missedFractionalPart = 0;
//	
//	
//	public Date getDataMissing() {
//		return dataMissing;
//	}
//	public void SetDataMissing(Date dataMissing) {
//		this.dataMissing = dataMissing;
//	}
//	public int getMissedIntegerPart() {
//		return missedIntegerPart;
//	}
//	public void setMissedIntegerPart(int missedIntegerPart) {
//		this.missedIntegerPart = missedIntegerPart;
//	}
//	public int getMissedGenFrazPart() {
//		return missedGenFrazPart;
//	}
//	public void setMissedGenFrazPart(int missedGenFrazPart) {
//		this.missedGenFrazPart = missedGenFrazPart;
//	}
//	public int getMissedFractionalPart() {
//		return missedFractionalPart;
//	}
//	public void setMissedFractionalPart(int missedFractionalPart) {
//		this.missedFractionalPart = missedFractionalPart;
//	}
}
