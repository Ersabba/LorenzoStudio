package com.ericsson.mgre.biz.countersMgmt.load;

import java.io.Serializable;

final public class CaricoTrasformatoreBeanPK implements Serializable {
  public Long codTrasformatore;
  public java.util.Date dataCurva;
  public Long numPeriodo;

  public CaricoTrasformatoreBeanPK() {}

  public CaricoTrasformatoreBeanPK(Long codTrasformatore, java.util.Date dataCurva, Long numPeriodo) {
    this.codTrasformatore = codTrasformatore;
    this.dataCurva = dataCurva;
    this.numPeriodo = numPeriodo;

  }

  private int m_hashCode = 0;
  public int hashCode() {
    if (0 == m_hashCode) {
      m_hashCode = (codTrasformatore.hashCode()) ^ (dataCurva.hashCode()) ^ (numPeriodo.hashCode());
    }
    return m_hashCode;
  }

  public boolean equals(Object other) {
    if (other == this) return true;
    if (null == other) return false;
    if (other.hashCode() != hashCode()) return false;
    try {
      CaricoTrasformatoreBeanPK other2 = (CaricoTrasformatoreBeanPK) other;
      return (this.codTrasformatore.equals(other2.codTrasformatore)) && (this.dataCurva.equals(other2.dataCurva)) && (this.numPeriodo.equals(other2.numPeriodo));
    }
    catch(ClassCastException ex) {
      return false;
    }


  }
  public String toString() { 
    StringBuffer result = new StringBuffer("[CaricoTrasformatoreBeanPK ");
    result.append("codTrasformatore:" + (null == codTrasformatore ? "null" : codTrasformatore.toString())).append(" ");
    result.append("dataCurva:" + (null == dataCurva ? "null" : dataCurva.toString())).append(" ");
    result.append("numPeriodo:" + (null == numPeriodo ? "null" : numPeriodo.toString())).append(" ");
    result.append("]");
    return result.toString();
  }

}
