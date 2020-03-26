package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FILEADD")
public class FileAddCurrent  implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FileAddCurrentId fileAddressId;


    @Column(name="DATA_ACQUISIZIONE_FILE")
    private Date acquisitionDate;
    
    @Column(name="GRUPPO")
    private String gruppo;

    @Column(name="PROGRESSIVO")
    private String progressivo;

    @Column(name="FASE")
    private String fase;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="TIME_STAMP_ASSOCIAZIONE_LENNT")
    private Date dataOraAssociazioneLennt;

    @Column(name="DATA_RIF")
    private Date dataRif;
    


	public FileAddCurrent() {}

	public FileAddCurrent(FileAddCurrentId fileAddressId, Date acquisitionDate, String gruppo, String progressivo,
			String fase, Date dataOraAssociazioneLennt, Date dataRif) {
		super();
		this.fileAddressId = fileAddressId;
		this.acquisitionDate = acquisitionDate;
		this.gruppo = gruppo;
		this.progressivo = progressivo;
		this.fase = fase;
		this.dataOraAssociazioneLennt = dataOraAssociazioneLennt;
		this.dataRif = dataRif;
	}

	public FileAddCurrentId getFileAddressId() {
		return fileAddressId;
	}

	public void setFileAddressId(FileAddCurrentId fileAddressId) {
		this.fileAddressId = fileAddressId;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public String getGruppo() {
		return gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	public String getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(String progressivo) {
		this.progressivo = progressivo;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public Date getDataOraAssociazioneLennt() {
		return dataOraAssociazioneLennt;
	}

	public void setDataOraAssociazioneLennt(Date dataOraAssociazioneLennt) {
		this.dataOraAssociazioneLennt = dataOraAssociazioneLennt;
	}

	public Date getDataRif() {
		return dataRif;
	}

	public void setDataRif(Date dataRif) {
		this.dataRif = dataRif;
	}

	@Override
	public String toString() {
		return "FileAddCurrent [fileAddressId=" + fileAddressId + ", acquisitionDate=" + acquisitionDate + ", gruppo="
				+ gruppo + ", progressivo=" + progressivo + ", fase=" + fase + ", dataOraAssociazioneLennt="
				+ dataOraAssociazioneLennt + ", dataRif=" + dataRif + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquisitionDate == null) ? 0 : acquisitionDate.hashCode());
		result = prime * result + ((dataOraAssociazioneLennt == null) ? 0 : dataOraAssociazioneLennt.hashCode());
		result = prime * result + ((dataRif == null) ? 0 : dataRif.hashCode());
		result = prime * result + ((fase == null) ? 0 : fase.hashCode());
		result = prime * result + ((fileAddressId == null) ? 0 : fileAddressId.hashCode());
		result = prime * result + ((gruppo == null) ? 0 : gruppo.hashCode());
		result = prime * result + ((progressivo == null) ? 0 : progressivo.hashCode());
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
		FileAddCurrent other = (FileAddCurrent) obj;
		if (acquisitionDate == null) {
			if (other.acquisitionDate != null)
				return false;
		} else if (!acquisitionDate.equals(other.acquisitionDate))
			return false;
		if (dataOraAssociazioneLennt == null) {
			if (other.dataOraAssociazioneLennt != null)
				return false;
		} else if (!dataOraAssociazioneLennt.equals(other.dataOraAssociazioneLennt))
			return false;
		if (dataRif == null) {
			if (other.dataRif != null)
				return false;
		} else if (!dataRif.equals(other.dataRif))
			return false;
		if (fase == null) {
			if (other.fase != null)
				return false;
		} else if (!fase.equals(other.fase))
			return false;
		if (fileAddressId == null) {
			if (other.fileAddressId != null)
				return false;
		} else if (!fileAddressId.equals(other.fileAddressId))
			return false;
		if (gruppo == null) {
			if (other.gruppo != null)
				return false;
		} else if (!gruppo.equals(other.gruppo))
			return false;
		if (progressivo == null) {
			if (other.progressivo != null)
				return false;
		} else if (!progressivo.equals(other.progressivo))
			return false;
		return true;
	}

    

   
}
