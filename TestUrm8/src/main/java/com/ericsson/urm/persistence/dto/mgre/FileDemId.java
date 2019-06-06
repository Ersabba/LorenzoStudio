package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class FileDemId implements Serializable{

    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

/*    ACQ_DATE TIMESTAMP(6) NOT NULL,
    COD_CONCENTRATORE VARCHAR2(13 BYTE) NOT NULL,
    MTR VARCHAR2(30 BYTE) NOT NULL,*/

    @Column(name="COD_CONCENTRATORE", nullable=false, length=13)
    private String codiceConcentratore;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ACQ_DATE", nullable=false, length=13)
    private Date acquisitionDate;

    @Column(name="MTR", nullable=false, length=30)
    private String matricola;

    public FileDemId(){};

    public FileDemId(String codiceConcentratore, Date acquisitionDate, String matricola) {
        this.codiceConcentratore = codiceConcentratore;
        this.acquisitionDate = acquisitionDate;
        this.matricola = matricola;
    }

    public String getCodiceConcentratore() {
        return codiceConcentratore;
    }

    public void setCodiceConcentratore(String codiceConcentratore) {
        this.codiceConcentratore = codiceConcentratore;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileDemId that = (FileDemId) o;

        if (!getCodiceConcentratore().equals(that.getCodiceConcentratore())) return false;
        if (!getAcquisitionDate().equals(that.getAcquisitionDate())) return false;
        return getMatricola().equals(that.getMatricola());
    }

    @Override
    public int hashCode() {
        int result = getCodiceConcentratore().hashCode();
        result = 31 * result + getAcquisitionDate().hashCode();
        result = 31 * result + getMatricola().hashCode();
        return result;
    }
}
