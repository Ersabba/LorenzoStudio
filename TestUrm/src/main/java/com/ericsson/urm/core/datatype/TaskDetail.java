package com.ericsson.urm.core.datatype;

import java.sql.Timestamp;
import java.util.List;

public class TaskDetail {

    private String origin;
    private String taskCode;
    private String taskDescription;
    private String period;
    private Long taskId = null;
    private String taskState;
    private Timestamp expectedStartDate;
    private Timestamp startDate;
    private Timestamp endDate;
    private List targets;
    private String targetType;
    private String chronScheduling;


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public Timestamp getExpectedStartDate() {
        return expectedStartDate;
    }

    public void setExpectedStartDate(Timestamp expectedStartDate) {
        this.expectedStartDate = expectedStartDate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public List getTargets() {
        return targets;
    }

    public void setTargets(List targets) {
        this.targets = targets;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getChronScheduling() {
        return chronScheduling;
    }

    public void setChronScheduling(String chronScheduling) {
        this.chronScheduling = chronScheduling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskDetail that = (TaskDetail) o;

        if (!getOrigin().equals(that.getOrigin())) return false;
        if (!getTaskCode().equals(that.getTaskCode())) return false;
        if (!getTaskDescription().equals(that.getTaskDescription())) return false;
        if (getPeriod() != null ? !getPeriod().equals(that.getPeriod()) : that.getPeriod() != null) return false;
        if (!getTaskId().equals(that.getTaskId())) return false;
        if (getTaskState() != null ? !getTaskState().equals(that.getTaskState()) : that.getTaskState() != null)
            return false;
        if (getExpectedStartDate() != null ? !getExpectedStartDate().equals(that.getExpectedStartDate()) : that.getExpectedStartDate() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(that.getStartDate()) : that.getStartDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(that.getEndDate()) : that.getEndDate() != null) return false;
        if (getTargets() != null ? !getTargets().equals(that.getTargets()) : that.getTargets() != null) return false;
        if (getTargetType() != null ? !getTargetType().equals(that.getTargetType()) : that.getTargetType() != null)
            return false;
        return getChronScheduling() != null ? getChronScheduling().equals(that.getChronScheduling()) : that.getChronScheduling() == null;
    }

    @Override
    public int hashCode() {
        int result = getOrigin().hashCode();
        result = 31 * result + getTaskCode().hashCode();
        result = 31 * result + getTaskDescription().hashCode();
        result = 31 * result + (getPeriod() != null ? getPeriod().hashCode() : 0);
        result = 31 * result + getTaskId().hashCode();
        result = 31 * result + (getTaskState() != null ? getTaskState().hashCode() : 0);
        result = 31 * result + (getExpectedStartDate() != null ? getExpectedStartDate().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getTargets() != null ? getTargets().hashCode() : 0);
        result = 31 * result + (getTargetType() != null ? getTargetType().hashCode() : 0);
        result = 31 * result + (getChronScheduling() != null ? getChronScheduling().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaskDetail{" +
                "origin='" + origin + '\'' +
                ", taskCode='" + taskCode + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", period='" + period + '\'' +
                ", taskId=" + taskId +
                ", taskState='" + taskState + '\'' +
                ", expectedStartDate=" + expectedStartDate +
                ", expectedStartDate in millisec=" + expectedStartDate.getTime() +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", targets=" + targets +
                ", targetType='" + targetType + '\'' +
                ", chronScheduling='" + chronScheduling + '\'' +
                '}';
    }
}
