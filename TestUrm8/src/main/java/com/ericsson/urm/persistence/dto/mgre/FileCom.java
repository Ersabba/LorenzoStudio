package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="GRE_FILE_COM")
public class FileCom {

    @EmbeddedId
    private FileComId fileComId;

    @Column(name="commOK",  length=30)
    private String commOK;

    @Column(name="commTOT",  length=30)
    private String commTOT;

    @Column(name="commPer",  length=30)
    private String commPer;

    @Temporal(TemporalType.DATE)
    @Column(name="EXPORT_DATE",nullable=false)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileCom fileCom = (FileCom) o;

        if (!getFileComId().equals(fileCom.getFileComId())) return false;
        if (getCommOK() != null ? !getCommOK().equals(fileCom.getCommOK()) : fileCom.getCommOK() != null) return false;
        if (getCommTOT() != null ? !getCommTOT().equals(fileCom.getCommTOT()) : fileCom.getCommTOT() != null)
            return false;
        if (getCommPer() != null ? !getCommPer().equals(fileCom.getCommPer()) : fileCom.getCommPer() != null)
            return false;
        return getExportDate().equals(fileCom.getExportDate());
    }

    @Override
    public int hashCode() {
        int result = getFileComId().hashCode();
        result = 31 * result + (getCommOK() != null ? getCommOK().hashCode() : 0);
        result = 31 * result + (getCommTOT() != null ? getCommTOT().hashCode() : 0);
        result = 31 * result + (getCommPer() != null ? getCommPer().hashCode() : 0);
        result = 31 * result + getExportDate().hashCode();
        return result;
    }
}
