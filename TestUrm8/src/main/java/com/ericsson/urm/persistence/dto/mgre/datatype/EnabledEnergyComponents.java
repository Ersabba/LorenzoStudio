package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;
public class EnabledEnergyComponents implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer abilAttAss;
	private Integer abilAttEr;
	private Integer abilReattIndAss;
	private Integer abilReattIndEr;
	private Integer abilReattCapAss;
	private Integer abilReattCapEr;
	
	public Integer getAbilAttAss() {
		return abilAttAss;
	}
	public void setAbilAttAss(Integer abilAttAss) {
		this.abilAttAss = abilAttAss;
	}
	public Integer getAbilAttEr() {
		return abilAttEr;
	}
	public void setAbilAttEr(Integer abilAttEr) {
		this.abilAttEr = abilAttEr;
	}
	public Integer getAbilReattIndAss() {
		return abilReattIndAss;
	}
	public void setAbilReattIndAss(Integer abilReattIndAss) {
		this.abilReattIndAss = abilReattIndAss;
	}
	public Integer getAbilReattIndEr() {
		return abilReattIndEr;
	}
	public void setAbilReattIndEr(Integer abilReattIndEr) {
		this.abilReattIndEr = abilReattIndEr;
	}
	public Integer getAbilReattCapAss() {
		return abilReattCapAss;
	}
	public void setAbilReattCapAss(Integer abilReattCapAss) {
		this.abilReattCapAss = abilReattCapAss;
	}
	public Integer getAbilReattCapEr() {
		return abilReattCapEr;
	}
	public void setAbilReattCapEr(Integer abilReattCapEr) {
		this.abilReattCapEr = abilReattCapEr;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abilAttAss == null) ? 0 : abilAttAss.hashCode());
		result = prime * result
				+ ((abilAttEr == null) ? 0 : abilAttEr.hashCode());
		result = prime * result
				+ ((abilReattCapAss == null) ? 0 : abilReattCapAss.hashCode());
		result = prime * result
				+ ((abilReattCapEr == null) ? 0 : abilReattCapEr.hashCode());
		result = prime * result
				+ ((abilReattIndAss == null) ? 0 : abilReattIndAss.hashCode());
		result = prime * result
				+ ((abilReattIndEr == null) ? 0 : abilReattIndEr.hashCode());
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
		EnabledEnergyComponents other = (EnabledEnergyComponents) obj;
		if (abilAttAss == null) {
			if (other.abilAttAss != null)
				return false;
		} else if (!abilAttAss.equals(other.abilAttAss))
			return false;
		if (abilAttEr == null) {
			if (other.abilAttEr != null)
				return false;
		} else if (!abilAttEr.equals(other.abilAttEr))
			return false;
		if (abilReattCapAss == null) {
			if (other.abilReattCapAss != null)
				return false;
		} else if (!abilReattCapAss.equals(other.abilReattCapAss))
			return false;
		if (abilReattCapEr == null) {
			if (other.abilReattCapEr != null)
				return false;
		} else if (!abilReattCapEr.equals(other.abilReattCapEr))
			return false;
		if (abilReattIndAss == null) {
			if (other.abilReattIndAss != null)
				return false;
		} else if (!abilReattIndAss.equals(other.abilReattIndAss))
			return false;
		if (abilReattIndEr == null) {
			if (other.abilReattIndEr != null)
				return false;
		} else if (!abilReattIndEr.equals(other.abilReattIndEr))
			return false;
		return true;
	}
		
}
