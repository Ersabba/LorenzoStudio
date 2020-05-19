package com.ericsson.gestionesw.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class StatisticheConnessioniCcsId implements Serializable {

    @Column(name="MTR_CCS")
    private String matricolaCcs		= null;

    @Column(name="DATA_RICEZIONE")
    @Temporal(TemporalType.DATE)
    private Date dataRicezione		= null;

    public StatisticheConnessioniCcsId() {
    }

    public StatisticheConnessioniCcsId(String matricolaCcs, Date dataRicezione) {
        this.matricolaCcs = matricolaCcs;
        this.dataRicezione = dataRicezione;
    }

    public String getMatricolaCcs() {
        return matricolaCcs;
    }

    public void setMatricolaCcs(String matricolaCcs) {
        this.matricolaCcs = matricolaCcs;
    }

    public Date getDataRicezione() {
        return dataRicezione;
    }

    public void setDataRicezione(Date dataRicezione) {
        this.dataRicezione = dataRicezione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticheConnessioniCcsId that = (StatisticheConnessioniCcsId) o;
        return matricolaCcs.equals(that.matricolaCcs) &&
                dataRicezione.equals(that.dataRicezione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricolaCcs, dataRicezione);
    }
}
