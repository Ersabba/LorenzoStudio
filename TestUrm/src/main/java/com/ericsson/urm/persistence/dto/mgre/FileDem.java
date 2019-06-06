package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="GRE_FILE_DEM")
public class FileDem {

    @EmbeddedId
    private FileDemId fileDemId;

    @Column(name="DATA",  length=30)
    private String data;

    @Column(name="ORA",  length=30)
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



}
