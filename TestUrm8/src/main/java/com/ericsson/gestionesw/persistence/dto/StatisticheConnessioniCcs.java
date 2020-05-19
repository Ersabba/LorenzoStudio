package com.ericsson.gestionesw.persistence.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity()
@Table(name="STATISTICHE_CONNESSIONI_CCS")
public class StatisticheConnessioniCcs implements Serializable {

    @EmbeddedId
    private StatisticheConnessioniCcsId id;

    @Column(name="NUM_POST_HTTP")
    private long numPostHttp;

    public StatisticheConnessioniCcs() {
    }

    public StatisticheConnessioniCcs(StatisticheConnessioniCcsId statisticheConnessioniCcsId, long numPostHttp) {
        this.numPostHttp=numPostHttp;
        this.id=statisticheConnessioniCcsId;
    }

    public StatisticheConnessioniCcsId getId() {
        return id;
    }

    public void setId(StatisticheConnessioniCcsId id) {
        this.id = id;
    }

    public long getNumPostHttp() {
        return numPostHttp;
    }

    public void setNumPostHttp(long numPostHttp) {
        this.numPostHttp = numPostHttp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticheConnessioniCcs that = (StatisticheConnessioniCcs) o;
        return numPostHttp == that.numPostHttp &&
                id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numPostHttp);
    }
}
