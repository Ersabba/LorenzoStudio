package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="GRE_CONFIG_CLUSTERING")
public class ClusteringConfigRange implements Serializable {

    private static final long serialVersionUID = 1L;

    private long    lenntNum;
    private long    rangeMinValue;
    private long    rangeMaxValue;

    public ClusteringConfigRange() {
    }

    public ClusteringConfigRange(long lenntNum, long rangeMinValue, long rangeMaxValue) {
        this.lenntNum = lenntNum;
        this.rangeMinValue = rangeMinValue;
        this.rangeMaxValue = rangeMaxValue;
    }

    @Column(name="NUMERO_LENNTT")
    public long getLenntNum() {
        return lenntNum;
    }

    public void setLenntNum(long lenntNum) {
        this.lenntNum = lenntNum;
    }

    @Id
    @Column(name="MIN_VALUE")
    public long getRangeMinValue() {
        return rangeMinValue;
    }

    public void setRangeMinValue(long rangeMinValue) {
        this.rangeMinValue = rangeMinValue;
    }

    @Column(name="MAX_VALUE")
    public long getRangeMaxValue() {
        return rangeMaxValue;
    }

    public void setRangeMaxValue(long rangeMaxValue) {
        this.rangeMaxValue = rangeMaxValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClusteringConfigRange)) return false;

        ClusteringConfigRange that = (ClusteringConfigRange) o;

        if (getLenntNum() != that.getLenntNum()) return false;
        if (getRangeMinValue() != that.getRangeMinValue()) return false;
        return getRangeMaxValue() == that.getRangeMaxValue();
    }

    @Override
    public int hashCode() {
        int result = (int) (getLenntNum() ^ (getLenntNum() >>> 32));
        result = 31 * result + (int) (getRangeMinValue() ^ (getRangeMinValue() >>> 32));
        result = 31 * result + (int) (getRangeMaxValue() ^ (getRangeMaxValue() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ClusteringConfigRange{" +
                "lenntNum=" + lenntNum +
                ", rangeMinValue=" + rangeMinValue +
                ", rangeMaxValue=" + rangeMaxValue +
                '}';
    }
}
