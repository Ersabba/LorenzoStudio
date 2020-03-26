package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ericsson.urm.persistence.dto.mgre.datatype.StatoClusterCabina;

public class InterruzioneInputFile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codCabinaSecondaria;
	private Date dataInterruzione;
	private Date dataAcqFile;
	private StatoClusterCabina stato;
	private String fileName;
	private List<InterruzioneConcentratore> interruzioni;
	
	public InterruzioneInputFile() {}

	public InterruzioneInputFile(String codCabinaSecondaria,
			Date dataInterruzione, Date dataAcqFile, StatoClusterCabina stato, String fileName,
			List<InterruzioneConcentratore> interruzioni) {
		super();
		this.codCabinaSecondaria = codCabinaSecondaria;
		this.dataInterruzione = dataInterruzione;
		this.dataAcqFile = dataAcqFile;
		this.stato = stato;
		this.fileName = fileName;
		this.interruzioni = interruzioni;
	}

	public String getCodCabinaSecondaria() {
		return codCabinaSecondaria;
	}

	public void setCodCabinaSecondaria(String codCabinaSecondaria) {
		this.codCabinaSecondaria = codCabinaSecondaria;
	}

	public Date getDataInterruzione() {
		return dataInterruzione;
	}

	public void setDataInterruzione(Date dataInterruzione) {
		this.dataInterruzione = dataInterruzione;
	}

	public Date getDataAcqFile() {
		return dataAcqFile;
	}

	public void setDataAcqFile(Date dataAcqFile) {
		this.dataAcqFile = dataAcqFile;
	}

	public StatoClusterCabina getStato() {
		return stato;
	}

	public void setStato(StatoClusterCabina stato) {
		this.stato = stato;
	}

	public List<InterruzioneConcentratore> getInterruzioni() {
		if(interruzioni==null){
			interruzioni = new ArrayList<InterruzioneConcentratore>();
		}
		return interruzioni;
	}

	public void setInterruzioni(List<InterruzioneConcentratore> interruzioni) {
		this.interruzioni = interruzioni;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCabinaSecondaria == null) ? 0 : codCabinaSecondaria.hashCode());
		result = prime * result + ((dataAcqFile == null) ? 0 : dataAcqFile.hashCode());
		result = prime * result + ((dataInterruzione == null) ? 0 : dataInterruzione.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((interruzioni == null) ? 0 : interruzioni.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
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
		InterruzioneInputFile other = (InterruzioneInputFile) obj;
		if (codCabinaSecondaria == null) {
			if (other.codCabinaSecondaria != null)
				return false;
		}
		else if (!codCabinaSecondaria.equals(other.codCabinaSecondaria))
			return false;
		if (dataAcqFile == null) {
			if (other.dataAcqFile != null)
				return false;
		}
		else if (!dataAcqFile.equals(other.dataAcqFile))
			return false;
		if (dataInterruzione == null) {
			if (other.dataInterruzione != null)
				return false;
		}
		else if (!dataInterruzione.equals(other.dataInterruzione))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		}
		else if (!fileName.equals(other.fileName))
			return false;
		if (interruzioni == null) {
			if (other.interruzioni != null)
				return false;
		}
		else if (!interruzioni.equals(other.interruzioni))
			return false;
		if (stato != other.stato)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InterruzioneInputFile [codCabinaSecondaria=" + codCabinaSecondaria + ", dataInterruzione=" + dataInterruzione + ", dataAcqFile="
				+ dataAcqFile + ", stato=" + stato + ", fileName=" + fileName + ", interruzioni=" + interruzioni + "]";
	}
}
