package com.ericsson.urm.persistence.dto.mds;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "MDS_STATS_ACQ_FILE_CCS")
public class StatsAcqFileCcs {

    @EmbeddedId
    StatsAcqFileCcsId id;

    @Column(name ="NUM_TENTATIVI_GIORNALIERI")
    long numDailyTries;

    @Column(name ="NUM_MATRICOLE_PRESENTI")
    long numMatricolePresenti;

    @Column(name ="NUM_LETTURE")
    long numReadings;

    @Column(name ="NUM_TENTATITIVI_POST_HTTP")
    long postHttpNumTries;

    @Column(name ="TASK_CODE")
    String taskCode;

    @Column(name ="PARTITION_ID")
    private int partitionId;

    public StatsAcqFileCcs(){};

    public StatsAcqFileCcs(StatsAcqFileCcsId id, long numDailyTries, long numMatricolePresenti, long numReadings, long postHttpNumTries, String taskCode) {
        setId(id);
        this.numDailyTries = numDailyTries;
        this.numMatricolePresenti = numMatricolePresenti;
        this.numReadings = numReadings;
        this.postHttpNumTries = postHttpNumTries;
        this.taskCode = taskCode;
    }

    public StatsAcqFileCcsId getId() {
        return id;
    }

    public void setId(StatsAcqFileCcsId id) {
        this.id = id;

        if(id!=null) {
            this.partitionId = getMonth(id.getAcquisitionDate());
        }
        else {
            this.partitionId = 0;
        }
    }

    private int getMonth (Date date)
    {
        if(date!=null) {
            GregorianCalendar calendar = new GregorianCalendar ();
            calendar.setTime(date);
            return calendar.get (GregorianCalendar.MONTH);
        }
        return 0;
    }

    public long getNumDailyTries() {
        return numDailyTries;
    }

    public void setNumDailyTries(long numDailyTries) {
        this.numDailyTries = numDailyTries;
    }

    public long getNumMatricolePresenti() {
        return numMatricolePresenti;
    }

    public void setNumMatricolePresenti(long numMatricolePresenti) {
        this.numMatricolePresenti = numMatricolePresenti;
    }

    public long getNumReadings() {
        return numReadings;
    }

    public void setNumReadings(long numReadings) {
        this.numReadings = numReadings;
    }

    public long getPostHttpNumTries() {
        return postHttpNumTries;
    }

    public void setPostHttpNumTries(long postHttpNumTries) {
        this.postHttpNumTries = postHttpNumTries;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public int getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(int partitionId) {
        this.partitionId = partitionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatsAcqFileCcs that = (StatsAcqFileCcs) o;

        if (getNumDailyTries() != that.getNumDailyTries()) return false;
        if (getNumMatricolePresenti() != that.getNumMatricolePresenti()) return false;
        if (getNumReadings() != that.getNumReadings()) return false;
        if (getPostHttpNumTries() != that.getPostHttpNumTries()) return false;
        if (getPartitionId() != that.getPartitionId()) return false;
        if (!getId().equals(that.getId())) return false;
        return getTaskCode().equals(that.getTaskCode());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (int) (getNumDailyTries() ^ (getNumDailyTries() >>> 32));
        result = 31 * result + (int) (getNumMatricolePresenti() ^ (getNumMatricolePresenti() >>> 32));
        result = 31 * result + (int) (getNumReadings() ^ (getNumReadings() >>> 32));
        result = 31 * result + (int) (getPostHttpNumTries() ^ (getPostHttpNumTries() >>> 32));
        result = 31 * result + getTaskCode().hashCode();
        result = 31 * result + getPartitionId();
        return result;
    }
}
