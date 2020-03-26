package com.ericsson.urm.device.driver.qltyvoltage;

import java.io.Serializable;
import java.util.Date;

public class QualityDataVoltageResponse implements Serializable {
	
	private static final long serialVersionUID = -1L;
	private boolean currentReadings = true;
	private Date dataRiferimento = null;
	private int vMaxR = -1;
	private int vMaxS = -1;
	private int vMaxT = -1;
	private int vMinR = -1;
	private int vMinS = -1;
	private int vMinT = -1;
	private int durataFuoriRange = -1;
	
	
	public boolean isCurrentReadings() {
		return currentReadings;
	}
	public void setCurrentReadings(boolean currentReadings) {
		this.currentReadings = currentReadings;
	}
	public Date getDataRiferimento() {
		return dataRiferimento;
	}
	public void setDataRiferimento(Date dataRiferimento) {
		this.dataRiferimento = dataRiferimento;
	}
	public int getvMaxR() {
		return vMaxR;
	}
	public void setvMaxR(int vMaxR) {
		this.vMaxR = vMaxR;
	}
	public int getvMaxS() {
		return vMaxS;
	}
	public void setvMaxS(int vMaxS) {
		this.vMaxS = vMaxS;
	}
	public int getvMaxT() {
		return vMaxT;
	}
	public void setvMaxT(int vMaxT) {
		this.vMaxT = vMaxT;
	}
	public int getvMinR() {
		return vMinR;
	}
	public void setvMinR(int vMinR) {
		this.vMinR = vMinR;
	}
	public int getvMinS() {
		return vMinS;
	}
	public void setvMinS(int vMinS) {
		this.vMinS = vMinS;
	}
	public int getvMinT() {
		return vMinT;
	}
	public void setvMinT(int vMinT) {
		this.vMinT = vMinT;
	}
	public int getDurataFuoriRange() {
		return durataFuoriRange;
	}
	public void setDurataFuoriRange(int durataFuoriRange) {
		this.durataFuoriRange = durataFuoriRange;
	}

}
