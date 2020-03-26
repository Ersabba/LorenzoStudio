package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="FILEROU_HIST")
public class FileRouHist  implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FileRouHistId fileRouId;

    @Column(name="RIP1")
    private String rip1;

    @Column(name="RIP2")
    private String rip2;

    @Column(name="RIP3")
    private String rip3;
    
    @Column(name="RIP4")
    private String rip4;

    @Column(name="DATA_RIF")
    private Date dataRif;

    public FileRouHist(){}

	public FileRouHist(FileRouHistId fileRouId, String rip1, String rip2, String rip3, String rip4, Date dataRif) {
		super();
		this.fileRouId = fileRouId;
		this.rip1 = rip1;
		this.rip2 = rip2;
		this.rip3 = rip3;
		this.rip4 = rip4;
		this.dataRif = dataRif;
	}

	public FileRouHistId getFileRouId() {
		return fileRouId;
	}

	public void setFileRouId(FileRouHistId fileRouId) {
		this.fileRouId = fileRouId;
	}

	public String getRip1() {
		return rip1;
	}

	public void setRip1(String rip1) {
		this.rip1 = rip1;
	}

	public String getRip2() {
		return rip2;
	}

	public void setRip2(String rip2) {
		this.rip2 = rip2;
	}

	public String getRip3() {
		return rip3;
	}

	public void setRip3(String rip3) {
		this.rip3 = rip3;
	}

	public String getRip4() {
		return rip4;
	}

	public void setRip4(String rip4) {
		this.rip4 = rip4;
	}

	public Date getDataRif() {
		return dataRif;
	}

	public void setDataRif(Date dataRif) {
		this.dataRif = dataRif;
	}

	@Override
	public String toString() {
		return "FileRouCurrent [fileRouId=" + fileRouId + ", rip1=" + rip1 + ", rip2=" + rip2 + ", rip3=" + rip3
				+ ", rip4=" + rip4 + ", dataRif=" + dataRif + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRif == null) ? 0 : dataRif.hashCode());
		result = prime * result + ((fileRouId == null) ? 0 : fileRouId.hashCode());
		result = prime * result + ((rip1 == null) ? 0 : rip1.hashCode());
		result = prime * result + ((rip2 == null) ? 0 : rip2.hashCode());
		result = prime * result + ((rip3 == null) ? 0 : rip3.hashCode());
		result = prime * result + ((rip4 == null) ? 0 : rip4.hashCode());
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
		FileRouHist other = (FileRouHist) obj;
		if (dataRif == null) {
			if (other.dataRif != null)
				return false;
		} else if (!dataRif.equals(other.dataRif))
			return false;
		if (fileRouId == null) {
			if (other.fileRouId != null)
				return false;
		} else if (!fileRouId.equals(other.fileRouId))
			return false;
		if (rip1 == null) {
			if (other.rip1 != null)
				return false;
		} else if (!rip1.equals(other.rip1))
			return false;
		if (rip2 == null) {
			if (other.rip2 != null)
				return false;
		} else if (!rip2.equals(other.rip2))
			return false;
		if (rip3 == null) {
			if (other.rip3 != null)
				return false;
		} else if (!rip3.equals(other.rip3))
			return false;
		if (rip4 == null) {
			if (other.rip4 != null)
				return false;
		} else if (!rip4.equals(other.rip4))
			return false;
		return true;
	}
    

}
