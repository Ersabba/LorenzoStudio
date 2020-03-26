package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Date;

public class GUIReadingDataBO implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private String ccsId = null;
	private String substCode;
	private String meterId;
	private String component=null;
	private String readingType;
	private Date rilDate=null;
	private String registry;
	private String firstValueAttAssStr;//CR 23 -  valore completo (intero + decimale)
	private String integerValue;
	private String decimalValue;//CR 23
	private Date firstSurveyDate = null;
	private String unitMeasure = null;
	private String provenance;// CR042 //
	
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getReadingType() {
		return readingType;
	}
	public void setReadingType(String readingType) {
		this.readingType = readingType;
	}
	public Date getRilDate() {
		return rilDate;
	}
	public void setRilDate(Date rilDate) {
		this.rilDate = rilDate;
	}
	public String getRegistry() {
		return registry;
	}
	public void setRegistry(String registry) {
		this.registry = registry;
	}
	public String getIntegerValue() {
		return integerValue;
	}
	public void setIntegerValue(String integerValue) {
		this.integerValue = integerValue;
	}
	public String getDecimalValue() {
		return decimalValue;
	}
	public void setDecimalValue(String decimalValue) {
		this.decimalValue = decimalValue;
	}
	public String getFirstValueAttAssStr() {
		return firstValueAttAssStr;
	}
	public void setFirstValueAttAssStr(String firstValueAttAssStr) {
		this.firstValueAttAssStr = firstValueAttAssStr;
	}
	public String getSubstCode() {
		return substCode;
	}
	public void setSubstCode(String substCode) {
		this.substCode = substCode;
	}
	public Date getFirstSurveyDate() {
		return firstSurveyDate;
	}
	public void setFirstSurveyDate(Date firstSurveyDate) {
		this.firstSurveyDate = firstSurveyDate;
	}
	public String getCcsId() {
		return ccsId;
	}
	public void setCcsId(String ccsId) {
		this.ccsId = ccsId;
	}
	public String getUnitMeasure() {
		return unitMeasure;
	}
	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
	}
	public String getProvenance() {
		return provenance;
	}
	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccsId == null) ? 0 : ccsId.hashCode());
		result = prime * result + ((component == null) ? 0 : component.hashCode());
		result = prime * result + ((decimalValue == null) ? 0 : decimalValue.hashCode());
		result = prime * result + ((firstSurveyDate == null) ? 0 : firstSurveyDate.hashCode());
		result = prime * result + ((firstValueAttAssStr == null) ? 0 : firstValueAttAssStr.hashCode());
		result = prime * result + ((integerValue == null) ? 0 : integerValue.hashCode());
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
		result = prime * result + ((provenance == null) ? 0 : provenance.hashCode());
		result = prime * result + ((readingType == null) ? 0 : readingType.hashCode());
		result = prime * result + ((registry == null) ? 0 : registry.hashCode());
		result = prime * result + ((rilDate == null) ? 0 : rilDate.hashCode());
		result = prime * result + ((substCode == null) ? 0 : substCode.hashCode());
		result = prime * result + ((unitMeasure == null) ? 0 : unitMeasure.hashCode());
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
		GUIReadingDataBO other = (GUIReadingDataBO) obj;
		if (ccsId == null) {
			if (other.ccsId != null)
				return false;
		} else if (!ccsId.equals(other.ccsId))
			return false;
		if (component == null) {
			if (other.component != null)
				return false;
		} else if (!component.equals(other.component))
			return false;
		if (decimalValue == null) {
			if (other.decimalValue != null)
				return false;
		} else if (!decimalValue.equals(other.decimalValue))
			return false;
		if (firstSurveyDate == null) {
			if (other.firstSurveyDate != null)
				return false;
		} else if (!firstSurveyDate.equals(other.firstSurveyDate))
			return false;
		if (firstValueAttAssStr == null) {
			if (other.firstValueAttAssStr != null)
				return false;
		} else if (!firstValueAttAssStr.equals(other.firstValueAttAssStr))
			return false;
		if (integerValue == null) {
			if (other.integerValue != null)
				return false;
		} else if (!integerValue.equals(other.integerValue))
			return false;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
			return false;
		if (provenance == null) {
			if (other.provenance != null)
				return false;
		} else if (!provenance.equals(other.provenance))
			return false;
		if (readingType == null) {
			if (other.readingType != null)
				return false;
		} else if (!readingType.equals(other.readingType))
			return false;
		if (registry == null) {
			if (other.registry != null)
				return false;
		} else if (!registry.equals(other.registry))
			return false;
		if (rilDate == null) {
			if (other.rilDate != null)
				return false;
		} else if (!rilDate.equals(other.rilDate))
			return false;
		if (substCode == null) {
			if (other.substCode != null)
				return false;
		} else if (!substCode.equals(other.substCode))
			return false;
		if (unitMeasure == null) {
			if (other.unitMeasure != null)
				return false;
		} else if (!unitMeasure.equals(other.unitMeasure))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GUIReadingDataBO [ccsId=" + ccsId + ", substCode=" + substCode + ", meterId=" + meterId + ", component="
				+ component + ", readingType=" + readingType + ", rilDate=" + rilDate + ", registry=" + registry
				+ ", firstValueAttAssStr=" + firstValueAttAssStr + ", integerValue=" + integerValue + ", decimalValue="
				+ decimalValue + ", firstSurveyDate=" + firstSurveyDate + ", unitMeasure=" + unitMeasure
				+ ", provenance=" + provenance + "]";
	}
}