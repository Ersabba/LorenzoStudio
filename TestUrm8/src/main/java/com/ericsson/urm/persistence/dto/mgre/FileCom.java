package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="GRE_FILE_COM")
public class FileCom  implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FileComId fileComId;

    @Column(name="commOK")
    private String commOK;

    @Column(name="commTOT")
    private String commTOT;

    @Column(name="commPer")
    private String commPer;

    @Temporal(TemporalType.DATE)
    @Column(name="EXPORT_DATE")
    private Date exportDate;

    public FileCom(){};

    public FileCom(FileComId fileComId, String commOK, String commTOT, String commPer, Date exportDate) {
        this.fileComId = fileComId;
        this.commOK = commOK;
        this.commTOT = commTOT;
        this.commPer = commPer;
        this.exportDate = exportDate;
    }

    public FileComId getFileComId() {
        return fileComId;
    }

    public void setFileComId(FileComId fileComId) {
        this.fileComId = fileComId;
    }

    public String getCommOK() {
        return commOK;
    }

    public void setCommOK(String commOK) {
        this.commOK = commOK;
    }

    public String getCommTOT() {
        return commTOT;
    }

    public void setCommTOT(String commTOT) {
        this.commTOT = commTOT;
    }

    public String getCommPer() {
        return commPer;
    }

    public void setCommPer(String commPer) {
        this.commPer = commPer;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

	@Override
	public String toString() {
		return "FileCom [fileComId=" + fileComId + ", commOK=" + commOK + ", commTOT=" + commTOT + ", commPer="
				+ commPer + ", exportDate=" + exportDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commOK == null) ? 0 : commOK.hashCode());
		result = prime * result + ((commPer == null) ? 0 : commPer.hashCode());
		result = prime * result + ((commTOT == null) ? 0 : commTOT.hashCode());
		result = prime * result + ((exportDate == null) ? 0 : exportDate.hashCode());
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
		FileCom other = (FileCom) obj;
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
		if (exportDate == null) {
			if (other.exportDate != null)
				return false;
		} else if (!exportDate.equals(other.exportDate))
			return false;
		if (fileComId == null) {
			if (other.fileComId != null)
				return false;
		} else if (!fileComId.equals(other.fileComId))
			return false;
		return true;
	}

}
