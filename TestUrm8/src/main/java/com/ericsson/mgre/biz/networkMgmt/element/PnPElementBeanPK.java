package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;

final public class PnPElementBeanPK implements Serializable {

    public String ccs;
    public String lennt;

    public PnPElementBeanPK() {}

    public PnPElementBeanPK(String codConcentratore, String matricolaLenntCliente) {
        this.ccs = codConcentratore;
        this.lennt = matricolaLenntCliente;
    }

    private int m_hashCode = 0;
    public int hashCode() {
        if (0 == m_hashCode) {
            m_hashCode = (ccs.hashCode()) ^ (lennt.hashCode());
        }
        return m_hashCode;
    }

    public boolean equals(Object other) {
        if (other == this) return true;
        if (null == other) return false;
        if (other.hashCode() != hashCode()) return false;
        try {
            PnPElementBeanPK other2 = (PnPElementBeanPK) other;
            return (this.ccs.equals(other2.ccs)) && (this.lennt == other2.lennt);
        } catch(ClassCastException ex) {
            return false;
        }
    }
    public String toString() {
        StringBuffer result = new StringBuffer("[PnPElementBeanPK ");
        result.append("CCS:" + (null == ccs ? "null" : ccs.toString())).append(" ");
        result.append("Lennt:" + lennt);
        result.append("]");
        return result.toString();
    }
}
