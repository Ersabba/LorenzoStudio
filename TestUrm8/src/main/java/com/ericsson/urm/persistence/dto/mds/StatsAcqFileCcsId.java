package com.ericsson.urm.persistence.dto.mds;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class StatsAcqFileCcsId implements Serializable {

    @Column(name = "ACQ_DATE")
    private Date acquisitionDate=null;

    @Column(name = "COD_CONCENTRATORE")
    private String concentratorId=null;

    @Column(name = "FILE_NAME")
    private String fileName=null;

    public StatsAcqFileCcsId(Date acquisitionDate, String concentratorId, String fileName) {
        this.acquisitionDate = acquisitionDate;
        this.concentratorId = concentratorId;
        this.fileName = fileName;
    }

    public StatsAcqFileCcsId(){}

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getConcentratorId() {
        return concentratorId;
    }

    public void setConcentratorId(String concentratorId) {
        this.concentratorId = concentratorId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatsAcqFileCcsId that = (StatsAcqFileCcsId) o;

        if (!getAcquisitionDate().equals(that.getAcquisitionDate())) return false;
        if (!getConcentratorId().equals(that.getConcentratorId())) return false;
        return getFileName().equals(that.getFileName());
    }

    @Override
    public int hashCode() {
        int result = getAcquisitionDate().hashCode();
        result = 31 * result + getConcentratorId().hashCode();
        result = 31 * result + getFileName().hashCode();
        return result;
    }
}
