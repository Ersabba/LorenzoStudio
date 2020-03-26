package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class CurvaCaricoConfigShort implements Serializable {
	private static final long serialVersionUID = 1L;

	private String matricola;
	private Integer abilAttAss;
	private Integer abilAttEr;
	private Integer abilReattIndAss;
	private Integer abilReattIndEr;
	private Integer abilReattCapAss;
	private Integer abilReattCapEr;

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Integer getAbilAttAss() {
		return abilAttAss;
	}
	
	public Boolean getAbilAttAssBool() {
		if (abilAttAss != null)
			return abilAttAss == 0 ? false : true;
		return null;
	}

	public void setAbilAttAss(Integer abilAttAss) {
		this.abilAttAss = abilAttAss;
	}

	public Integer getAbilAttEr() {
		return abilAttEr;
	}
	
	public Boolean getAbilAttErBool() {
		if (abilAttEr != null)
			return abilAttEr == 0 ? false : true;
		return null;
	}

	public void setAbilAttEr(Integer abilAttEr) {
		this.abilAttEr = abilAttEr;
	}

	public Integer getAbilReattIndAss() {
		return abilReattIndAss;
	}
	
	public Boolean getAbilReattIndAssBool() {
		if (abilReattIndAss != null)
			return abilReattIndAss == 0 ? false : true;
		return null;
	}

	public void setAbilReattIndAss(Integer abilReattIndAss) {
		this.abilReattIndAss = abilReattIndAss;
	}

	public Integer getAbilReattIndEr() {
		return abilReattIndEr;
	}
	
	public Boolean getAbilReattIndErBool() {
		if (abilReattIndEr != null)
			return abilReattIndEr == 0 ? false : true;
		return null;
	}

	public void setAbilReattIndEr(Integer abilReattIndEr) {
		this.abilReattIndEr = abilReattIndEr;
	}

	public Integer getAbilReattCapAss() {
		return abilReattCapAss;
	}
	
	public Boolean getAbilReattCapAssBool() {
		if (abilReattCapAss != null)
			return abilReattCapAss == 0 ? false : true;
		return null;
	}

	public void setAbilReattCapAss(Integer abilReattCapAss) {
		this.abilReattCapAss = abilReattCapAss;
	}

	public Integer getAbilReattCapEr() {
		return abilReattCapEr;
	}
	
	public Boolean getAbilReattCapErBool() {
		if (abilReattCapEr != null)
			return abilReattCapEr == 0 ? false : true;
		return null;
	}

	public void setAbilReattCapEr(Integer abilReattCapEr) {
		this.abilReattCapEr = abilReattCapEr;
	}
}
