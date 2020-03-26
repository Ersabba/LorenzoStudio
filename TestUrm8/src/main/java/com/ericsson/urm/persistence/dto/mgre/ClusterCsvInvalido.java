package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;

import com.ericsson.mgre.interruzioni.IbtRecord;


public class ClusterCsvInvalido extends IbtRecord {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private String				fileName;
	private Date				acquisitionTimestamp;
	private Date				updateTimestamp;
	private String				note;
	
	public ClusterCsvInvalido() {}
	
	public ClusterCsvInvalido(IbtRecord ibtRecord, String fileName, Date acquisitionTimestamp, Date updateTimestamp, String note) {
		super.setCodCabinaSecondaria(ibtRecord.getCodCabinaSecondaria());
		super.setCodConcentratore(ibtRecord.getCodConcentratore());
		super.setCodiceTrasformatore(ibtRecord.getCodiceTrasformatore());
		super.setCodInterruttore(ibtRecord.getCodInterruttore());
		super.setDataInterruzione(ibtRecord.getDataInterruzione());
		super.setDurataInterruzione(ibtRecord.getDurataInterruzione());
		super.setFormazioneCavo(ibtRecord.getFormazioneCavo());
		super.setMatricolaTrasformatore(ibtRecord.getMatricolaTrasformatore());
		super.setOraInterruzione(ibtRecord.getOraInterruzione());
		super.setPrimoSportello(ibtRecord.getPrimoSportello());
		super.setStatoInterruttore(ibtRecord.getStatoInterruttore());
		super.setTensione(ibtRecord.getTensione());
		
		this.fileName = fileName;
		this.acquisitionTimestamp = acquisitionTimestamp;
		this.updateTimestamp = updateTimestamp;
		this.note = note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getAcquisitionTimestamp() {
		return acquisitionTimestamp;
	}

	public void setAcquisitionTimestamp(Date acquisitionTimestamp) {
		this.acquisitionTimestamp = acquisitionTimestamp;
	}

	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "ClusterCsvInvalido [id=" + id + ", fileName=" + fileName + ", acquisitionTimestamp=" + acquisitionTimestamp + ", updateTimestamp="
				+ updateTimestamp + ", note=" + note + ", getCodCabinaSecondaria()=" + getCodCabinaSecondaria() + ", getDataInterruzione()="
				+ getDataInterruzione() + ", getCodiceTrasformatore()=" + getCodiceTrasformatore() + ", getMatricolaTrasformatore()="
				+ getMatricolaTrasformatore() + ", getCodConcentratore()=" + getCodConcentratore() + ", getCodInterruttore()=" + getCodInterruttore()
				+ ", getOraInterruzione()=" + getOraInterruzione() + ", getDurataInterruzione()=" + getDurataInterruzione()
				+ ", getStatoInterruttore()=" + getStatoInterruttore() + ", getTensione()=" + getTensione() + ", getPrimoSportello()="
				+ getPrimoSportello() + ", getFormazioneCavo()=" + getFormazioneCavo() + "]";
	}
}
