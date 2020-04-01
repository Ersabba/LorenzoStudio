package com.ericsson.urm.persistence.dto;

import java.io.Serializable;


public class GestioneFornitura implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private Long				taskId;
	private String				matricolaLennt;
	private String				potenzaContraT1;
	private String				potenzaContraT2;
	private String				potenzaContraT3;
	private String				potenzaContraT4;
	private Long				dataInizioContra;
	private Long				dataFineContra;
	private String				potRidottaMorosita;
	private String				potRidottaAllegg;
	private String				abilLettCurveCarico;
	private String				periodIntegCurveCarico;
	private String				abilAlleggCarico;
	private Serializable		listaAzioni;
	private Serializable		paramAllegg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getMatricolaLennt() {
		return matricolaLennt;
	}

	public void setMatricolaLennt(String matricolaLennt) {
		this.matricolaLennt = matricolaLennt;
	}

	public String getPotenzaContraT1() {
		return potenzaContraT1;
	}

	public void setPotenzaContraT1(String potenzaContraT1) {
		this.potenzaContraT1 = potenzaContraT1;
	}

	public String getPotenzaContraT2() {
		return potenzaContraT2;
	}

	public void setPotenzaContraT2(String potenzaContraT2) {
		this.potenzaContraT2 = potenzaContraT2;
	}

	public String getPotenzaContraT3() {
		return potenzaContraT3;
	}

	public void setPotenzaContraT3(String potenzaContraT3) {
		this.potenzaContraT3 = potenzaContraT3;
	}

	public String getPotenzaContraT4() {
		return potenzaContraT4;
	}

	public void setPotenzaContraT4(String potenzaContraT4) {
		this.potenzaContraT4 = potenzaContraT4;
	}

	public Long getDataInizioContra() {
		return dataInizioContra;
	}

	public void setDataInizioContra(Long dataInizioContra) {
		this.dataInizioContra = dataInizioContra;
	}

	public Long getDataFineContra() {
		return dataFineContra;
	}

	public void setDataFineContra(Long dataFineContra) {
		this.dataFineContra = dataFineContra;
	}

	public String getPotRidottaMorosita() {
		return potRidottaMorosita;
	}

	public void setPotRidottaMorosita(String potRidottaMorosita) {
		this.potRidottaMorosita = potRidottaMorosita;
	}

	public String getPotRidottaAllegg() {
		return potRidottaAllegg;
	}

	public void setPotRidottaAllegg(String potRidottaAllegg) {
		this.potRidottaAllegg = potRidottaAllegg;
	}

	public String getAbilLettCurveCarico() {
		return abilLettCurveCarico;
	}

	public void setAbilLettCurveCarico(String abilLettCurveCarico) {
		this.abilLettCurveCarico = abilLettCurveCarico;
	}

	public String getPeriodIntegCurveCarico() {
		return periodIntegCurveCarico;
	}

	public void setPeriodIntegCurveCarico(String periodIntegCurveCarico) {
		this.periodIntegCurveCarico = periodIntegCurveCarico;
	}

	public String getAbilAlleggCarico() {
		return abilAlleggCarico;
	}

	public void setAbilAlleggCarico(String abilAlleggCarico) {
		this.abilAlleggCarico = abilAlleggCarico;
	}

	public Serializable getListaAzioni() {
		return listaAzioni;
	}

	public void setListaAzioni(Serializable listaAzioni) {
		this.listaAzioni = listaAzioni;
	}

	public Serializable getParamAllegg() {
		return paramAllegg;
	}

	public void setParamAllegg(Serializable paramAllegg) {
		this.paramAllegg = paramAllegg;
	}
}
