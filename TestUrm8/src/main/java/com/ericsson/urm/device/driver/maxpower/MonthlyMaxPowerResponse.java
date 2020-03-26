package com.ericsson.urm.device.driver.maxpower;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ericsson.urm.device.driver.datatype.ComponentId;

public class MonthlyMaxPowerResponse implements Serializable {

	private static final long serialVersionUID = -1L;
	
	public static final int TARIFF_TYPE_T1 = 1;
	public static final int TARIFF_TYPE_T2 = 2;
	public static final int TARIFF_TYPE_T3 = 3;
	public static final int TARIFF_TYPE_T4 = 4;
	
	public static enum TariffType {
		T1(TARIFF_TYPE_T1),
		T2(TARIFF_TYPE_T2),
		T3(TARIFF_TYPE_T3),
		T4(TARIFF_TYPE_T4);

		private TariffType(int index) {
			this.index = index;
		}

		private int index;

		public int getIndex() {
			return index;
		}

		public static TariffType getByIndex(int index) {
			for(TariffType curr : TariffType.values()) {
				if(curr.index == index) {
					return curr;
				}
			}
			throw new IllegalArgumentException("Unknown index:"+index+" valid (1-4)");
		}
	}
	
	

	public static class MaxPower implements Serializable  {
		private static final long serialVersionUID = 1L;
		
		private TariffType tariffType = null;
		private int maxPowerValue = -1;
		private Date maxPowerDate = null;
		
		public MaxPower(TariffType tariffType, int maxPowerValue, Date maxPowerDate) {
			super();
			if(tariffType== null) {
				throw new IllegalArgumentException("Undefined tariffType");
			}
			this.tariffType =  tariffType;
			this.maxPowerValue = maxPowerValue;
			this.maxPowerDate = maxPowerDate;
		}

		public TariffType getTariffType() {
			return tariffType;
		}

		public int getMaxPowerValue() {
			return maxPowerValue;
		}

		public Date getMaxPowerDate() {
			return maxPowerDate;
		}

	}

	private ComponentId powerType = null;
	private Date monthRequested = null;

	private Map<TariffType, MaxPower> maxPowers = new HashMap<TariffType, MaxPower>();

	public MaxPower getMaxPower(TariffType tariffType) {
		return maxPowers.get(tariffType);
	}

	public void addMaxPower(MaxPower power) {
		if (power == null)
			throw new IllegalArgumentException("Power must be not null");
		maxPowers.put(power.tariffType, power);
	}

	public ComponentId getPowerType() {
		return powerType;
	}

	public void setPowerType(ComponentId powerType) {
		this.powerType = powerType;
	}

	public Date getMonthRequested() {
		return monthRequested;
	}

	public void setMonthRequested(Date monthRequested) {
		this.monthRequested = monthRequested;
	}

	public boolean isValuesPresent() {
		return !maxPowers.isEmpty();
	}
}
