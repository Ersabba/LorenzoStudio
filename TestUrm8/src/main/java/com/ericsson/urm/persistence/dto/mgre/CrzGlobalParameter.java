package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import com.ericsson.urm.persistence.dto.mgre.datatype.CrzCodeGlobalParameter;

/**
 * The persistent class for the GRE_CRZ_PARAMETRI_GLOBALI database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_PARAMETRI_GLOBALI")
@NamedQuery(name="CrzGlobalParameter.findAll", query="SELECT c FROM CrzGlobalParameter c")
public class CrzGlobalParameter implements Serializable {
	private static final long serialVersionUID = -1L;

	@Id
	@Column(name="PARAM_CODE", unique=true, nullable=false)
	@AccessType("field")
	private String paramCode;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="PARAM_VALUE")
	private String paramValue;

	public CrzGlobalParameter() {
	}

	public CrzCodeGlobalParameter getParamCode() {
		return CrzCodeGlobalParameter.fromString(this.paramCode);
	}

	public void setParamCode(CrzCodeGlobalParameter paramCode) {
		this.paramCode = paramCode!=null ? paramCode.toString() : null;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((paramCode == null) ? 0 : paramCode.hashCode());
		result = prime * result + ((paramValue == null) ? 0 : paramValue.hashCode());
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
		CrzGlobalParameter other = (CrzGlobalParameter) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (paramCode == null) {
			if (other.paramCode != null)
				return false;
		} else if (!paramCode.equals(other.paramCode))
			return false;
		if (paramValue == null) {
			if (other.paramValue != null)
				return false;
		} else if (!paramValue.equals(other.paramValue))
			return false;
		return true;
	}

	
}
