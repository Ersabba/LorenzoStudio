package com.ericsson.mgre.datatypes.monthlymeasures;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentId;

public class MonthlyMeasureRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private EnergyComponentId energyComponentId;
	private String meterId;
	private String measureType;
	private String status;
	private Date   dateDetection;
	private String strValueTG;
	private String strValueT1;
	private String strValueT2;
	private String strValueT3;
	private String strValueT4;
	private Date dataRilT1 = null;
	private Date dataRilT2 = null;
	private Date dataRilT3 = null;
	private Date dataRilT4 = null;
	
	private boolean  persisted = false;
	
	    	
	public MonthlyMeasureRecord() {}
	
	public MonthlyMeasureRecord(String meterId,EnergyComponentId energyComponentId, String measureType) {
		super();
		this.energyComponentId = energyComponentId;
		this.meterId = meterId;
		this.measureType = measureType;
	}

	public EnergyComponentId getEnergyComponentId() {
		return energyComponentId;
	}

	public void setEnergyComponentId(EnergyComponentId energyComponentId) {
		this.energyComponentId = energyComponentId;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getMeasureType() {
		return measureType;
	}

	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateDetection() {
		return dateDetection;
	}

	public void setDateDetection(Date dateDetection) {
		this.dateDetection = dateDetection;
	}

	public String getStrValueTG() {
		return strValueTG;
	}

	public void setStrValueTG(String strValueTG) {
		this.strValueTG = strValueTG;
	}

	public String getStrValueT1() {
		return strValueT1;
	}

	public void setStrValueT1(String strValueT1) {
		this.strValueT1 = strValueT1;
	}

	public String getStrValueT2() {
		return strValueT2;
	}

	public void setStrValueT2(String strValueT2) {
		this.strValueT2 = strValueT2;
	}

	public String getStrValueT3() {
		return strValueT3;
	}

	public void setStrValueT3(String strValueT3) {
		this.strValueT3 = strValueT3;
	}

	public String getStrValueT4() {
		return strValueT4;
	}

	public void setStrValueT4(String strValueT4) {
		this.strValueT4 = strValueT4;
	}

	public Date getDataRilT1() {
		return dataRilT1;
	}

	public void setDataRilT1(Date dataRilT1) {
		this.dataRilT1 = dataRilT1;
	}

	public Date getDataRilT2() {
		return dataRilT2;
	}

	public void setDataRilT2(Date dataRilT2) {
		this.dataRilT2 = dataRilT2;
	}

	public Date getDataRilT3() {
		return dataRilT3;
	}

	public void setDataRilT3(Date dataRilT3) {
		this.dataRilT3 = dataRilT3;
	}

	public Date getDataRilT4() {
		return dataRilT4;
	}

	public void setDataRilT4(Date dataRilT4) {
		this.dataRilT4 = dataRilT4;
	}

	
	
	public boolean isPersisted() {
		return persisted;
	}

	public void setPersisted(boolean persisted) {
		this.persisted = persisted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataRilT1 == null) ? 0 : dataRilT1.hashCode());
		result = prime * result
				+ ((dataRilT2 == null) ? 0 : dataRilT2.hashCode());
		result = prime * result
				+ ((dataRilT3 == null) ? 0 : dataRilT3.hashCode());
		result = prime * result
				+ ((dataRilT4 == null) ? 0 : dataRilT4.hashCode());
		result = prime * result
				+ ((dateDetection == null) ? 0 : dateDetection.hashCode());
		result = prime
				* result
				+ ((energyComponentId == null) ? 0 : energyComponentId
						.hashCode());
		result = prime * result
				+ ((measureType == null) ? 0 : measureType.hashCode());
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
		result = prime * result + (persisted ? 1231 : 1237);
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((strValueT1 == null) ? 0 : strValueT1.hashCode());
		result = prime * result
				+ ((strValueT2 == null) ? 0 : strValueT2.hashCode());
		result = prime * result
				+ ((strValueT3 == null) ? 0 : strValueT3.hashCode());
		result = prime * result
				+ ((strValueT4 == null) ? 0 : strValueT4.hashCode());
		result = prime * result
				+ ((strValueTG == null) ? 0 : strValueTG.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonthlyMeasureRecord other = (MonthlyMeasureRecord) obj;
		if (dataRilT1 == null) {
			if (other.dataRilT1 != null)
				return false;
		} else if (!dataRilT1.equals(other.dataRilT1))
			return false;
		if (dataRilT2 == null) {
			if (other.dataRilT2 != null)
				return false;
		} else if (!dataRilT2.equals(other.dataRilT2))
			return false;
		if (dataRilT3 == null) {
			if (other.dataRilT3 != null)
				return false;
		} else if (!dataRilT3.equals(other.dataRilT3))
			return false;
		if (dataRilT4 == null) {
			if (other.dataRilT4 != null)
				return false;
		} else if (!dataRilT4.equals(other.dataRilT4))
			return false;
		if (dateDetection == null) {
			if (other.dateDetection != null)
				return false;
		} else if (!dateDetection.equals(other.dateDetection))
			return false;
		if (energyComponentId == null) {
			if (other.energyComponentId != null)
				return false;
		} else if (!energyComponentId.equals(other.energyComponentId))
			return false;
		if (measureType == null) {
			if (other.measureType != null)
				return false;
		} else if (!measureType.equals(other.measureType))
			return false;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
			return false;
		if (persisted != other.persisted)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (strValueT1 == null) {
			if (other.strValueT1 != null)
				return false;
		} else if (!strValueT1.equals(other.strValueT1))
			return false;
		if (strValueT2 == null) {
			if (other.strValueT2 != null)
				return false;
		} else if (!strValueT2.equals(other.strValueT2))
			return false;
		if (strValueT3 == null) {
			if (other.strValueT3 != null)
				return false;
		} else if (!strValueT3.equals(other.strValueT3))
			return false;
		if (strValueT4 == null) {
			if (other.strValueT4 != null)
				return false;
		} else if (!strValueT4.equals(other.strValueT4))
			return false;
		if (strValueTG == null) {
			if (other.strValueTG != null)
				return false;
		} else if (!strValueTG.equals(other.strValueTG))
			return false;
		return true;
	}

	

}
