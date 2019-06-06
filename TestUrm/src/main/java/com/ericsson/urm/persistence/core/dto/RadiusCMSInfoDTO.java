package com.ericsson.urm.persistence.core.dto;

import java.io.Serializable;

public class RadiusCMSInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String password;
    private String simnumber;
    private String ipaddr;
    private String operator;
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSimnumber() {
        return simnumber;
    }

    public void setSimnumber(String simnumber) {
        this.simnumber = simnumber;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RadiusCMSInfoDTO that = (RadiusCMSInfoDTO) o;

        if (getPassword() != null ? !getPassword().equals(that.getPassword()) : that.getPassword() != null)
            return false;
        if (getSimnumber() != null ? !getSimnumber().equals(that.getSimnumber()) : that.getSimnumber() != null)
            return false;
        if (getIpaddr() != null ? !getIpaddr().equals(that.getIpaddr()) : that.getIpaddr() != null) return false;
        if (getOperator() != null ? !getOperator().equals(that.getOperator()) : that.getOperator() != null)
            return false;
        return getUser() != null ? getUser().equals(that.getUser()) : that.getUser() == null;
    }

    @Override
    public int hashCode() {
        int result = getPassword() != null ? getPassword().hashCode() : 0;
        result = 31 * result + (getSimnumber() != null ? getSimnumber().hashCode() : 0);
        result = 31 * result + (getIpaddr() != null ? getIpaddr().hashCode() : 0);
        result = 31 * result + (getOperator() != null ? getOperator().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RadiusCMSInfoDTO{" +
                "password='" + password + '\'' +
                ", simnumber='" + simnumber + '\'' +
                ", ipaddr='" + ipaddr + '\'' +
                ", operator='" + operator + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
