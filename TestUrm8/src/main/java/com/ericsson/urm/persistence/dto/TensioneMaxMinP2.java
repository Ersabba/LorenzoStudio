package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;


public class TensioneMaxMinP2 implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private String				matricolaLenntCliente;
	private String				codConcentratore;
	private Date				acquisitionDate;
	private Date				settimanaRiferimento;
	private Integer				tensioneMinR;
	private Integer				tensioneMaxR;
	private Integer				tensioneMinS;
	private Integer				tensioneMaxS;
	private Integer				tensioneMinT;
	private Integer				tensioneMaxT;
	private Integer				durataFuoriRange;

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

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public Date getSettimanaRiferimento() {
		return settimanaRiferimento;
	}

	public void setSettimanaRiferimento(Date settimanaRiferimento) {
		this.settimanaRiferimento = settimanaRiferimento;
	}

	public Integer getTensioneMinR() {
		return tensioneMinR;
	}

	public void setTensioneMinR(Integer tensioneMinR) {
		this.tensioneMinR = tensioneMinR;
	}

	public Integer getTensioneMaxR() {
		return tensioneMaxR;
	}

	public void setTensioneMaxR(Integer tensioneMaxR) {
		this.tensioneMaxR = tensioneMaxR;
	}

	public Integer getTensioneMinS() {
		return tensioneMinS;
	}

	public void setTensioneMinS(Integer tensioneMinS) {
		this.tensioneMinS = tensioneMinS;
	}

	public Integer getTensioneMaxS() {
		return tensioneMaxS;
	}

	public void setTensioneMaxS(Integer tensioneMaxS) {
		this.tensioneMaxS = tensioneMaxS;
	}

	public Integer getTensioneMinT() {
		return tensioneMinT;
	}

	public void setTensioneMinT(Integer tensioneMinT) {
		this.tensioneMinT = tensioneMinT;
	}

	public Integer getTensioneMaxT() {
		return tensioneMaxT;
	}

	public void setTensioneMaxT(Integer tensioneMaxT) {
		this.tensioneMaxT = tensioneMaxT;
	}

	public Integer getDurataFuoriRange() {
		return durataFuoriRange;
	}

	public void setDurataFuoriRange(Integer durataFuoriRange) {
		this.durataFuoriRange = durataFuoriRange;
	}
}
