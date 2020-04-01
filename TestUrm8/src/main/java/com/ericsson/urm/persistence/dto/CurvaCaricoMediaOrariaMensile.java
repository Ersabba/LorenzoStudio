package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.core.enumeration.HalfDayTimeSlot;
import com.ericsson.urm.core.enumeration.Power;


public class CurvaCaricoMediaOrariaMensile implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private String				matricolaLenntCliente;
	private Date				acquisitionDate;
	private Date				dataCurva;
	private String				tipoPotenza;
	private Integer				fasciaOraria;
	private Integer				potenzaPeriodo_01;
	private Integer				potenzaPeriodo_02;
	private Integer				potenzaPeriodo_03;
	private Integer				potenzaPeriodo_04;
	private Integer				potenzaPeriodo_05;
	private Integer				potenzaPeriodo_06;
	private Integer				potenzaPeriodo_07;
	private Integer				potenzaPeriodo_08;
	private Integer				potenzaPeriodo_09;
	private Integer				potenzaPeriodo_10;
	private Integer				potenzaPeriodo_11;
	private Integer				potenzaPeriodo_12;
	private Date				timestampExport;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public Date getDataCurva() {
		return dataCurva;
	}

	public void setDataCurva(Date dataCurva) {
		this.dataCurva = dataCurva;
	}

	public Power getTipoPotenza() {
		return Power.parse(tipoPotenza);
	}

	public void setTipoPotenza(Power tipoPotenza) {
		if (tipoPotenza != null)
			this.tipoPotenza = tipoPotenza.toString();
		else
			this.tipoPotenza = null;
	}

	public HalfDayTimeSlot getFasciaOraria() {
		if (fasciaOraria == null)
			return null;
		return HalfDayTimeSlot.fromValue(fasciaOraria);
	}

	public void setFasciaOraria(HalfDayTimeSlot fasciaOraria) {
		if (fasciaOraria != null)
			this.fasciaOraria = fasciaOraria.dbValue();
		else
			this.fasciaOraria = null;
	}

	public Integer getPotenzaPeriodo_01() {
		return potenzaPeriodo_01;
	}

	public void setPotenzaPeriodo_01(Integer potenzaPeriodo_01) {
		this.potenzaPeriodo_01 = potenzaPeriodo_01;
	}

	public Integer getPotenzaPeriodo_02() {
		return potenzaPeriodo_02;
	}

	public void setPotenzaPeriodo_02(Integer potenzaPeriodo_02) {
		this.potenzaPeriodo_02 = potenzaPeriodo_02;
	}

	public Integer getPotenzaPeriodo_03() {
		return potenzaPeriodo_03;
	}

	public void setPotenzaPeriodo_03(Integer potenzaPeriodo_03) {
		this.potenzaPeriodo_03 = potenzaPeriodo_03;
	}

	public Integer getPotenzaPeriodo_04() {
		return potenzaPeriodo_04;
	}

	public void setPotenzaPeriodo_04(Integer potenzaPeriodo_04) {
		this.potenzaPeriodo_04 = potenzaPeriodo_04;
	}

	public Integer getPotenzaPeriodo_05() {
		return potenzaPeriodo_05;
	}

	public void setPotenzaPeriodo_05(Integer potenzaPeriodo_05) {
		this.potenzaPeriodo_05 = potenzaPeriodo_05;
	}

	public Integer getPotenzaPeriodo_06() {
		return potenzaPeriodo_06;
	}

	public void setPotenzaPeriodo_06(Integer potenzaPeriodo_06) {
		this.potenzaPeriodo_06 = potenzaPeriodo_06;
	}

	public Integer getPotenzaPeriodo_07() {
		return potenzaPeriodo_07;
	}

	public void setPotenzaPeriodo_07(Integer potenzaPeriodo_07) {
		this.potenzaPeriodo_07 = potenzaPeriodo_07;
	}

	public Integer getPotenzaPeriodo_08() {
		return potenzaPeriodo_08;
	}

	public void setPotenzaPeriodo_08(Integer potenzaPeriodo_08) {
		this.potenzaPeriodo_08 = potenzaPeriodo_08;
	}

	public Integer getPotenzaPeriodo_09() {
		return potenzaPeriodo_09;
	}

	public void setPotenzaPeriodo_09(Integer potenzaPeriodo_09) {
		this.potenzaPeriodo_09 = potenzaPeriodo_09;
	}

	public Integer getPotenzaPeriodo_10() {
		return potenzaPeriodo_10;
	}

	public void setPotenzaPeriodo_10(Integer potenzaPeriodo_10) {
		this.potenzaPeriodo_10 = potenzaPeriodo_10;
	}

	public Integer getPotenzaPeriodo_11() {
		return potenzaPeriodo_11;
	}

	public void setPotenzaPeriodo_11(Integer potenzaPeriodo_11) {
		this.potenzaPeriodo_11 = potenzaPeriodo_11;
	}

	public Integer getPotenzaPeriodo_12() {
		return potenzaPeriodo_12;
	}

	public void setPotenzaPeriodo_12(Integer potenzaPeriodo_12) {
		this.potenzaPeriodo_12 = potenzaPeriodo_12;
	}

	public Date getTimestampExport() {
		return timestampExport;
	}

	public void setTimestampExport(Date timestampExport) {
		this.timestampExport = timestampExport;
	}
}
