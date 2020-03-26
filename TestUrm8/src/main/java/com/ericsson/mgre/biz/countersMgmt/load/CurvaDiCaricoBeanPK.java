package com.ericsson.mgre.biz.countersMgmt.load;

import java.io.Serializable;

final public class CurvaDiCaricoBeanPK implements Serializable {
  public java.util.Date dataCurva;
  public String matricolaLenntCliente;
  public Long numPeriodo;

  public CurvaDiCaricoBeanPK() {}

  public CurvaDiCaricoBeanPK(java.util.Date dataCurva, String matricolaLenntCliente, Long numPeriodo) {
    this.dataCurva = dataCurva;
    this.matricolaLenntCliente = matricolaLenntCliente;
    this.numPeriodo = numPeriodo;

  }

  private int m_hashCode = 0;
  public int hashCode() {
    if (0 == m_hashCode) {
      m_hashCode = (dataCurva.hashCode()) ^ (matricolaLenntCliente.hashCode()) ^ (numPeriodo.hashCode());
    }
    return m_hashCode;
  }

  public boolean equals(Object other) {
    if (other == this) return true;
    if (null == other) return false;
    if (other.hashCode() != hashCode()) return false;
    try {
      CurvaDiCaricoBeanPK other2 = (CurvaDiCaricoBeanPK) other;
      return (this.dataCurva.equals(other2.dataCurva)) && (this.matricolaLenntCliente.equals(other2.matricolaLenntCliente)) && (this.numPeriodo.equals(other2.numPeriodo));
    }
    catch(ClassCastException ex) {
      return false;
    }


  }
  public String toString() { 
    StringBuffer result = new StringBuffer("[CurvaDiCaricoBeanPK ");
    result.append("dataCurva:" + (null == dataCurva ? "null" : dataCurva.toString())).append(" ");
    result.append("matricolaLenntCliente:" + (null == matricolaLenntCliente ? "null" : matricolaLenntCliente.toString())).append(" ");
    result.append("numPeriodo:" + (null == numPeriodo ? "null" : numPeriodo.toString())).append(" ");
    result.append("]");
    return result.toString();
  }

}
