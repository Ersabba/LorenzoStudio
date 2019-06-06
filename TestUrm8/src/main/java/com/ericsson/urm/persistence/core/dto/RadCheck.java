package com.ericsson.urm.persistence.core.dto;

public class RadCheck {

    int id;
    String username;
    String attribute;
    String op;
    String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RadCheck radCheck = (RadCheck) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(getId(), radCheck.getId())
                .append(getUsername(), radCheck.getUsername())
                .append(getAttribute(), radCheck.getAttribute())
                .append(getOp(), radCheck.getOp())
                .append(getValue(), radCheck.getValue())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(getId())
                .append(getUsername())
                .append(getAttribute())
                .append(getOp())
                .append(getValue())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "RadCheck{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", attribute='" + attribute + '\'' +
                ", op='" + op + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
