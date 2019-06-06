package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;

public class FileCcsFetchedData implements Serializable{
    private static final long serialVersionUID = 1L;

    private String	fileName;
    private Date	acqDate;

    public FileCcsFetchedData(String fileName, Date acqDate) {
        super();
        this.fileName = fileName;
        this.acqDate = acqDate;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public Date getAcqDate() {
        return acqDate;
    }
    public void setAcqDate(Date acqDate) {
        this.acqDate = acqDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((acqDate == null) ? 0 : acqDate.hashCode());
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
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
        FileCcsFetchedData other = (FileCcsFetchedData) obj;
        if (acqDate == null) {
            if (other.acqDate != null)
                return false;
        } else if (!acqDate.equals(other.acqDate))
            return false;
        if (fileName == null) {
            if (other.fileName != null)
                return false;
        } else if (!fileName.equals(other.fileName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FileCcsFetchedData [fileName=" + fileName + ", acqDate=" + acqDate + "]";
    }
}