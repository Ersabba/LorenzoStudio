package com.ericsson.urm.device.driver.energytotalizer;

import java.io.Serializable;
import java.util.Date;

public class DailyActiveAbsorbedTotResponse implements Serializable {

	private Date totalizerDate = null;

	private long energyAbssorbedTotal = -1;
	private long energyAbssorbedT1 = -1;
	private long energyAbssorbedT2 = -1;
	private long energyAbssorbedT3 = -1;
	private long energyAbssorbedT4 = -1;

	public void setEnergyAbssorbedTotal(long energyAbssorbedTotal) {
		this.energyAbssorbedTotal = energyAbssorbedTotal;
	}

	public void setEnergyAbssorbedT1(long energyAbssorbedT1) {
		this.energyAbssorbedT1 = energyAbssorbedT1;
	}

	public void setEnergyAbssorbedT2(long energyAbssorbedT2) {
		this.energyAbssorbedT2 = energyAbssorbedT2;
	}

	public void setEnergyAbssorbedT3(long energyAbssorbedT3) {
		this.energyAbssorbedT3 = energyAbssorbedT3;
	}

	public void setEnergyAbssorbedT4(long energyAbssorbedT4) {
		this.energyAbssorbedT4 = energyAbssorbedT4;
	}

	public long getEnergyAbssorbedTotal() {
		return energyAbssorbedTotal;
	}

	public long getEnergyAbssorbedT1() {
		return energyAbssorbedT1;
	}

	public long getEnergyAbssorbedT2() {
		return energyAbssorbedT2;
	}

	public long getEnergyAbssorbedT3() {
		return energyAbssorbedT3;
	}

	public long getEnergyAbssorbedT4() {
		return energyAbssorbedT4;
	}

	public Date getTotalizerDate() {
		return totalizerDate;
	}

	public void setTotalizerDate(Date totalizerDate) {
		this.totalizerDate = totalizerDate;
	}

}
