package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="GRE_FILE_ROU")
public class FileRouting {

    @EmbeddedId
    private FileRoutingId fileRoutingId;

    @Column(name="RIP1", length=30)
    private String rip1;

    @Column(name="RIP2",  length=30)
    private String rip2;

    @Column(name="RIP3", length=13)
    private String rip3;

    @Column(name="RIP4",  length=30)
    private String rip4;

    @Temporal(TemporalType.DATE)
    @Column(name="EXPORT_DATE",nullable=false)
    private Date exportDate;

    public FileRouting(){};

    public FileRouting(FileRoutingId fileRoutingId, String rip1, String rip2, String rip3, String rip4, Date exportDate) {
        this.fileRoutingId = fileRoutingId;
        this.rip1 = rip1;
        this.rip2 = rip2;
        this.rip3 = rip3;
        this.rip4 = rip4;
        this.exportDate = exportDate;
    }

    public FileRoutingId getFileRoutingId() {
        return fileRoutingId;
    }

    public void setFileRoutingId(FileRoutingId fileRoutingId) {
        this.fileRoutingId = fileRoutingId;
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

        FileRouting that = (FileRouting) o;

        if (!getFileRoutingId().equals(that.getFileRoutingId())) return false;
        if (getRip1() != null ? !getRip1().equals(that.getRip1()) : that.getRip1() != null) return false;
        if (getRip2() != null ? !getRip2().equals(that.getRip2()) : that.getRip2() != null) return false;
        if (getRip3() != null ? !getRip3().equals(that.getRip3()) : that.getRip3() != null) return false;
        if (getRip4() != null ? !getRip4().equals(that.getRip4()) : that.getRip4() != null) return false;
        return getExportDate().equals(that.getExportDate());
    }

    @Override
    public int hashCode() {
        int result = getFileRoutingId().hashCode();
        result = 31 * result + (getRip1() != null ? getRip1().hashCode() : 0);
        result = 31 * result + (getRip2() != null ? getRip2().hashCode() : 0);
        result = 31 * result + (getRip3() != null ? getRip3().hashCode() : 0);
        result = 31 * result + (getRip4() != null ? getRip4().hashCode() : 0);
        result = 31 * result + getExportDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FileRouting{" +
                "fileRoutingId=" + fileRoutingId +
                ", rip1='" + rip1 + '\'' +
                ", rip2='" + rip2 + '\'' +
                ", rip3='" + rip3 + '\'' +
                ", rip4='" + rip4 + '\'' +
                ", exportDate=" + exportDate +
                '}';
    }
}
