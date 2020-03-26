package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="FILEADD_HIST")
public class FileAddHist  implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FileAddHistId fileAddressId;

    @Column(name="GRUPPO")
    private String gruppo;

    @Column(name="PROGRESSIVO")
    private String progressivo;

    @Column(name="FASE")
    private String fase;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="TIME_STAMP_ASSOCIAZIONE_LENNT")
    private Date dataOraAssociazioneLentt;

    @Column(name="DATA_RIF")
    private Date dataRif;

    public FileAddHist(){}

	public FileAddHist(FileAddHistId fileAddressId, String gruppo, String progressivo, String fase,
			Date dataOraAssociazioneLentt, Date dataRif) {
		super();
		this.fileAddressId = fileAddressId;
		this.gruppo = gruppo;
		this.progressivo = progressivo;
		this.fase = fase;
		this.dataOraAssociazioneLentt = dataOraAssociazioneLentt;
		this.dataRif = dataRif;
	}

	public FileAddHistId getFileAddressId() {
		return fileAddressId;
	}

	public void setFileAddressId(FileAddHistId fileAddressId) {
		this.fileAddressId = fileAddressId;
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

	public Date getDataOraAssociazioneLentt() {
		return dataOraAssociazioneLentt;
	}

	public void setDataOraAssociazioneLentt(Date dataOraAssociazioneLentt) {
		this.dataOraAssociazioneLentt = dataOraAssociazioneLentt;
	}

	public Date getDataRif() {
		return dataRif;
	}

	public void setDataRif(Date dataRif) {
		this.dataRif = dataRif;
	}

	@Override
	public String toString() {
		return "FileAddHist [fileAddressId=" + fileAddressId + ", gruppo=" + gruppo + ", progressivo=" + progressivo
				+ ", fase=" + fase + ", dataOraAssociazioneLentt=" + dataOraAssociazioneLentt + ", dataRif=" + dataRif
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataOraAssociazioneLentt == null) ? 0 : dataOraAssociazioneLentt.hashCode());
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
		FileAddHist other = (FileAddHist) obj;
		if (dataOraAssociazioneLentt == null) {
			if (other.dataOraAssociazioneLentt != null)
				return false;
		} else if (!dataOraAssociazioneLentt.equals(other.dataOraAssociazioneLentt))
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
	};

    

   
}
