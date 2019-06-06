package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="GRE_FILE_ADD")
public class FileAddress {

    @EmbeddedId
    private FileAddressId fileAddressId;

    @Column(name="GRUPPO", length=30)
    private String gruppo;

    @Column(name="PROGRESSIVO",  length=30)
    private String progressivo;

    @Column(name="FASE", length=13)
    private String fase;

    @Column(name="INDIRIZZO_HDLC",  length=30)
    private String indirizzoHDLC;

    @Column(name="DATA_ASSOCIAZIONELENNT",  length=30)
    private String dataAssociazioneLentt;

    @Column(name="ORA_ASSOCIAZIONELENNT",  length=30)
    private String oraAssociazioneLentt;

    @Temporal(TemporalType.DATE)
    @Column(name="EXPORT_DATE")
    private java.util.Date exportDate;

    public FileAddress(){};

    public FileAddress(FileAddressId fileAddressId, String gruppo, String progressivo, String fase, String indirizzoHDLC, String dataAssociazioneLentt, String oraAssociazioneLentt, Date exportDate) {
        this.fileAddressId = fileAddressId;
        this.gruppo = gruppo;
        this.progressivo = progressivo;
        this.fase = fase;
        this.indirizzoHDLC = indirizzoHDLC;
        this.dataAssociazioneLentt = dataAssociazioneLentt;
        this.oraAssociazioneLentt = oraAssociazioneLentt;
        this.exportDate = exportDate;
    }

    public FileAddressId getFileAddressId() {
        return fileAddressId;
    }

    public void setFileAddressId(FileAddressId fileAddressId) {
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

    public String getIndirizzoHDLC() {
        return indirizzoHDLC;
    }

    public void setIndirizzoHDLC(String indirizzoHDLC) {
        this.indirizzoHDLC = indirizzoHDLC;
    }

    public String getDataAssociazioneLentt() {
        return dataAssociazioneLentt;
    }

    public void setDataAssociazioneLentt(String dataAssociazioneLentt) {
        this.dataAssociazioneLentt = dataAssociazioneLentt;
    }

    public String getOraAssociazioneLentt() {
        return oraAssociazioneLentt;
    }

    public void setOraAssociazioneLentt(String oraAssociazioneLentt) {
        this.oraAssociazioneLentt = oraAssociazioneLentt;
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
        if (!(o instanceof FileAddress)) return false;

        FileAddress that = (FileAddress) o;

        if (getFileAddressId() != null ? !getFileAddressId().equals(that.getFileAddressId()) : that.getFileAddressId() != null)
            return false;
        if (getGruppo() != null ? !getGruppo().equals(that.getGruppo()) : that.getGruppo() != null) return false;
        if (getProgressivo() != null ? !getProgressivo().equals(that.getProgressivo()) : that.getProgressivo() != null)
            return false;
        if (getFase() != null ? !getFase().equals(that.getFase()) : that.getFase() != null) return false;
        if (getIndirizzoHDLC() != null ? !getIndirizzoHDLC().equals(that.getIndirizzoHDLC()) : that.getIndirizzoHDLC() != null)
            return false;
        if (getDataAssociazioneLentt() != null ? !getDataAssociazioneLentt().equals(that.getDataAssociazioneLentt()) : that.getDataAssociazioneLentt() != null)
            return false;
        if (getOraAssociazioneLentt() != null ? !getOraAssociazioneLentt().equals(that.getOraAssociazioneLentt()) : that.getOraAssociazioneLentt() != null)
            return false;
        return getExportDate().equals(that.getExportDate());
    }

    @Override
    public int hashCode() {
        int result = getFileAddressId() != null ? getFileAddressId().hashCode() : 0;
        result = 31 * result + (getGruppo() != null ? getGruppo().hashCode() : 0);
        result = 31 * result + (getProgressivo() != null ? getProgressivo().hashCode() : 0);
        result = 31 * result + (getFase() != null ? getFase().hashCode() : 0);
        result = 31 * result + (getIndirizzoHDLC() != null ? getIndirizzoHDLC().hashCode() : 0);
        result = 31 * result + (getDataAssociazioneLentt() != null ? getDataAssociazioneLentt().hashCode() : 0);
        result = 31 * result + (getOraAssociazioneLentt() != null ? getOraAssociazioneLentt().hashCode() : 0);
        result = 31 * result + getExportDate().hashCode();
        return result;
    }

    /*
    GRUPPO VARCHAR2(30 BYTE),
    PROGRESSIVO VARCHAR2(30 BYTE),
    FASE VARCHAR2(30 BYTE),
    INDIRIZZO_HDLC VARCHAR2(30 BYTE),
    DATA_ASSOCIAZIONELENNT VARCHAR2(30 BYTE),
    ORA_ASSOCIAZIONELENNT VARCHAR2(30 BYTE),,
    EXPORT_DATE DATE NOT NULL,*/



}
