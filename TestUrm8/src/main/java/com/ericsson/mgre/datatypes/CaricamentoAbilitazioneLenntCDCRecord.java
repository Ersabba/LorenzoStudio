package com.ericsson.mgre.datatypes;

import java.io.Serializable;

public class CaricamentoAbilitazioneLenntCDCRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente;
	private String abilAttAss;
	private String abilAttEr;
	private String abilReattIndAss;
	
	private String abilReattIndEr;
	private String abilReattCapAss;
	private String abilReattCapEr;
	
	private String periodoCurveDiCarico;
	private String abilDisponibCampioni;
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public String getAbilAttAss() {
		return abilAttAss;
	}
	public void setAbilAttAss(String abilAttAss) {
		this.abilAttAss = abilAttAss;
	}
	public String getAbilAttEr() {
		return abilAttEr;
	}
	public void setAbilAttEr(String abilAttEr) {
		this.abilAttEr = abilAttEr;
	}
	public String getAbilReattIndAss() {
		return abilReattIndAss;
	}
	public void setAbilReattIndAss(String abilReattIndAss) {
		this.abilReattIndAss = abilReattIndAss;
	}
	public String getAbilReattIndEr() {
		return abilReattIndEr;
	}
	public void setAbilReattIndEr(String abilReattIndEr) {
		this.abilReattIndEr = abilReattIndEr;
	}
	public String getAbilReattCapAss() {
		return abilReattCapAss;
	}
	public void setAbilReattCapAss(String abilReattCapAss) {
		this.abilReattCapAss = abilReattCapAss;
	}
	public String getAbilReattCapEr() {
		return abilReattCapEr;
	}
	public void setAbilReattCapEr(String abilReattCapEr) {
		this.abilReattCapEr = abilReattCapEr;
	}
	public String getPeriodoCurveDiCarico() {
		return periodoCurveDiCarico;
	}
	public void setPeriodoCurveDiCarico(String periodoCurveDiCarico) {
		this.periodoCurveDiCarico = periodoCurveDiCarico;
	}
	public String getAbilDisponibCampioni() {
		return abilDisponibCampioni;
	}
	public void setAbilDisponibCampioni(String abilDisponibCampioni) {
		this.abilDisponibCampioni = abilDisponibCampioni;
	}
	@Override
	public String toString() {
		return "CaricamentoAbilitazioneLenntCDCRecord [matricolaLenntCliente="
				+ matricolaLenntCliente + ", abilAttAss=" + abilAttAss
				+ ", abilAttEr=" + abilAttEr + ", abilReattIndAss="
				+ abilReattIndAss + ", abilReattIndEr=" + abilReattIndEr
				+ ", abilReattCapAss=" + abilReattCapAss + ", abilReattCapEr="
				+ abilReattCapEr + ", periodoCurveDiCarico="
				+ periodoCurveDiCarico + ", abilDisponibCampioni="
				+ abilDisponibCampioni + "]";
	}
	
	
}
