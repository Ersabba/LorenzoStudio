package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="FILEDEM")
public class FileDemCurrent  implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FileDemCurrentId fileDemId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="TIME_STAMP_RIMOZIONE")
    private Date dataOraRimozione;


    @Column(name="DATA_RIF")
    private Date dataRif;
    


    @Column(name="DATA_ACQUISIZIONE_FILE")
    private Date acquisitionDate;

    public FileDemCurrent(){}

	public FileDemCurrent(FileDemCurrentId fileDemId, Date dataOraRimozione, Date dataRif, Date acquisitionDate) {
		super();
		this.fileDemId = fileDemId;
		this.dataOraRimozione = dataOraRimozione;
		this.dataRif = dataRif;
		this.acquisitionDate = acquisitionDate;
	}

	public FileDemCurrentId getFileDemId() {
		return fileDemId;
	}

	public void setFileDemId(FileDemCurrentId fileDemId) {
		this.fileDemId = fileDemId;
	}

	public Date getDataOraRimozione() {
		return dataOraRimozione;
	}

	public void setDataOraRimozione(Date dataOraRimozione) {
		this.dataOraRimozione = dataOraRimozione;
	}

	public Date getDataRif() {
		return dataRif;
	}

	public void setDataRif(Date dataRif) {
		this.dataRif = dataRif;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	@Override
	public String toString() {
		return "FileDemHist [fileDemId=" + fileDemId + ", dataOraRimozione=" + dataOraRimozione + ", dataRif=" + dataRif
				+ ", acquisitionDate=" + acquisitionDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquisitionDate == null) ? 0 : acquisitionDate.hashCode());
		result = prime * result + ((dataOraRimozione == null) ? 0 : dataOraRimozione.hashCode());
		result = prime * result + ((dataRif == null) ? 0 : dataRif.hashCode());
		result = prime * result + ((fileDemId == null) ? 0 : fileDemId.hashCode());
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
		FileDemCurrent other = (FileDemCurrent) obj;
		if (acquisitionDate == null) {
			if (other.acquisitionDate != null)
				return false;
		} else if (!acquisitionDate.equals(other.acquisitionDate))
			return false;
		if (dataOraRimozione == null) {
			if (other.dataOraRimozione != null)
				return false;
		} else if (!dataOraRimozione.equals(other.dataOraRimozione))
			return false;
		if (dataRif == null) {
			if (other.dataRif != null)
				return false;
		} else if (!dataRif.equals(other.dataRif))
			return false;
		if (fileDemId == null) {
			if (other.fileDemId != null)
				return false;
		} else if (!fileDemId.equals(other.fileDemId))
			return false;
		return true;
	}

	

}
