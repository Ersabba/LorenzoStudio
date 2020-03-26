package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="FILECOM")
public class FileComCurrent  implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FileComCurrentId fileComId;

    @Column(name="COMANDI_TRASMESSI")
    private Long commOK;

    @Column(name="COMANDI_RICEVUTI")
    private Long commTOT;

    @Column(name="STATISTICA_COMUNICAZIONE")
    private Long commPer;


    @Column(name="DATA_RIF")
    private Date dataRif;
    
    @Column(name="DATA_ACQUISIZIONE_FILE")
    private Date acquisitionDate;

    public FileComCurrent(){}

	public FileComCurrent(FileComCurrentId fileComId, Long commOK, Long commTOT, Long commPer, Date dataRif,
			Date acquisitionDate) {
		super();
		this.fileComId = fileComId;
		this.commOK = commOK;
		this.commTOT = commTOT;
		this.commPer = commPer;
		this.dataRif = dataRif;
		this.acquisitionDate = acquisitionDate;
	}

	public FileComCurrentId getFileComId() {
		return fileComId;
	}

	public void setFileComId(FileComCurrentId fileComId) {
		this.fileComId = fileComId;
	}

	public Long getCommOK() {
		return commOK;
	}

	public void setCommOK(Long commOK) {
		this.commOK = commOK;
	}

	public Long getCommTOT() {
		return commTOT;
	}

	public void setCommTOT(Long commTOT) {
		this.commTOT = commTOT;
	}

	public Long getCommPer() {
		return commPer;
	}

	public void setCommPer(Long commPer) {
		this.commPer = commPer;
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
		return "FileComCurrent [fileComId=" + fileComId + ", commOK=" + commOK + ", commTOT=" + commTOT + ", commPer="
				+ commPer + ", dataRif=" + dataRif + ", acquisitionDate=" + acquisitionDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquisitionDate == null) ? 0 : acquisitionDate.hashCode());
		result = prime * result + ((commOK == null) ? 0 : commOK.hashCode());
		result = prime * result + ((commPer == null) ? 0 : commPer.hashCode());
		result = prime * result + ((commTOT == null) ? 0 : commTOT.hashCode());
		result = prime * result + ((dataRif == null) ? 0 : dataRif.hashCode());
		result = prime * result + ((fileComId == null) ? 0 : fileComId.hashCode());
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
		FileComCurrent other = (FileComCurrent) obj;
		if (acquisitionDate == null) {
			if (other.acquisitionDate != null)
				return false;
		} else if (!acquisitionDate.equals(other.acquisitionDate))
			return false;
		if (commOK == null) {
			if (other.commOK != null)
				return false;
		} else if (!commOK.equals(other.commOK))
			return false;
		if (commPer == null) {
			if (other.commPer != null)
				return false;
		} else if (!commPer.equals(other.commPer))
			return false;
		if (commTOT == null) {
			if (other.commTOT != null)
				return false;
		} else if (!commTOT.equals(other.commTOT))
			return false;
		if (dataRif == null) {
			if (other.dataRif != null)
				return false;
		} else if (!dataRif.equals(other.dataRif))
			return false;
		if (fileComId == null) {
			if (other.fileComId != null)
				return false;
		} else if (!fileComId.equals(other.fileComId))
			return false;
		return true;
	}
    


	
}
