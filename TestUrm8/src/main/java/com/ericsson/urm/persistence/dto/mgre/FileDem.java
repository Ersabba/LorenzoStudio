package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="GRE_FILE_DEM")
public class FileDem  implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FileDemId fileDemId;

    @Column(name="DATA")
    private String data;

    @Column(name="ORA")
    private String ora;

    @Temporal(TemporalType.DATE)
    @Column(name="EXPORT_DATE")
    private Date exportDate;

    public FileDem(){};

    public FileDem(FileDemId fileDemId, String data, String ora, Date exportDate) {
        this.fileDemId = fileDemId;
        this.data = data;
        this.ora = ora;
        this.exportDate = exportDate;
    }

    public FileDemId getFileDemId() {
        return fileDemId;
    }

    public void setFileDemId(FileDemId fileDemId) {
        this.fileDemId = fileDemId;
    }

    public String getData() {
        return data;
    }

    public void setDataAssociazioneLentt(String dataAssociazioneLentt) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOraAssociazioneLentt(String oraAssociazioneLentt) {
        this.ora = ora;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

	@Override
	public String toString() {
		return "FileDem [fileDemId=" + fileDemId + ", data=" + data + ", ora=" + ora + ", exportDate=" + exportDate
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((exportDate == null) ? 0 : exportDate.hashCode());
		result = prime * result + ((fileDemId == null) ? 0 : fileDemId.hashCode());
		result = prime * result + ((ora == null) ? 0 : ora.hashCode());
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
		FileDem other = (FileDem) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (exportDate == null) {
			if (other.exportDate != null)
				return false;
		} else if (!exportDate.equals(other.exportDate))
			return false;
		if (fileDemId == null) {
			if (other.fileDemId != null)
				return false;
		} else if (!fileDemId.equals(other.fileDemId))
			return false;
		if (ora == null) {
			if (other.ora != null)
				return false;
		} else if (!ora.equals(other.ora))
			return false;
		return true;
	}



}
