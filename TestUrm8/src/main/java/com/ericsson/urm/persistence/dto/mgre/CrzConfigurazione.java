package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.AccessType;

import com.ericsson.urm.persistence.dto.mgre.datatype.CrzConfigParamName;


/**
 * The persistent class for the GRE_CRZ_CONFIGURAZIONE database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_CONFIGURAZIONE")
@NamedQuery(name="CrzConfigurazione.findAll", query="SELECT c FROM CrzConfigurazione c")
public class CrzConfigurazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PARAM_NAME", unique=true, nullable=false)
	@AccessType("field")
	private String paramName;

	@Column(name="PARAM_VALUE")
	private String paramValue;
	
	@Column(name="RANGE")
	private String range;
	
	
	public CrzConfigurazione() {
	}
	
	
	/**
	 * @param paramName
	 * @param paramValue
	 */
	public CrzConfigurazione(CrzConfigParamName paramName, String paramValue) {
		this(paramName, paramValue, null);
	}
	
	/**
	 * @param paramName
	 * @param paramValue
	 * @param range
	 */
	public CrzConfigurazione(CrzConfigParamName paramName, String paramValue, String range) {
		super();
		setParamName(paramName);
		this.paramValue = paramValue;
		this.range = range;
	}


	public CrzConfigParamName getParamName() {
		return CrzConfigParamName.fromString(this.paramName);
	}

	public void setParamName(CrzConfigParamName paramName) {
		this.paramName = paramName != null ? paramName.toString() : null;
	}

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}


	public String getRange() {
		return range;
	}


	public void setRange(String range) {
		this.range = range;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paramName == null) ? 0 : paramName.hashCode());
		result = prime * result + ((paramValue == null) ? 0 : paramValue.hashCode());
		result = prime * result + ((range == null) ? 0 : range.hashCode());
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
		CrzConfigurazione other = (CrzConfigurazione) obj;
		if (paramName == null) {
			if (other.paramName != null)
				return false;
		} else if (!paramName.equals(other.paramName))
			return false;
		if (paramValue == null) {
			if (other.paramValue != null)
				return false;
		} else if (!paramValue.equals(other.paramValue))
			return false;
		if (range == null) {
			if (other.range != null)
				return false;
		} else if (!range.equals(other.range))
			return false;
		return true;
	}



}