package com.ericsson.mgre.biz.reductionsMgmt.reductions;


/*
  ** This file was automatically generated by EJBGen 2.15 beta - Workshop 8.1
  ** Build: 20030408-0944
*/

import java.io.Serializable;

final public class ProgressiviLiberatiBeanPK implements Serializable {
  public String codGruppoApplicativo;
  public Long progrLiberato;

  public ProgressiviLiberatiBeanPK() {}

  public ProgressiviLiberatiBeanPK(String codGruppoApplicativo, Long progrLiberato) {
    this.codGruppoApplicativo = codGruppoApplicativo;
    this.progrLiberato = progrLiberato;

  }

  private int m_hashCode = 0;
  public int hashCode() {
    if (0 == m_hashCode) {
      m_hashCode = (codGruppoApplicativo.hashCode()) ^ (progrLiberato.hashCode());
    }
    return m_hashCode;
  }

  public boolean equals(Object other) {
    if (other == this) return true;
    if (null == other) return false;
    if (other.hashCode() != hashCode()) return false;
    try {
      ProgressiviLiberatiBeanPK other2 = (ProgressiviLiberatiBeanPK) other;
      return (this.codGruppoApplicativo.equals(other2.codGruppoApplicativo)) && (this.progrLiberato.equals(other2.progrLiberato));
    }
    catch(ClassCastException ex) {
      return false;
    }


  }
  public String toString() { 
    StringBuffer result = new StringBuffer("[ProgressiviLiberatiBeanPK ");
    result.append("codGruppoApplicativo:" + (null == codGruppoApplicativo ? "null" : codGruppoApplicativo.toString())).append(" ");
    result.append("progrLiberato:" + (null == progrLiberato ? "null" : progrLiberato.toString())).append(" ");
    result.append("]");
    return result.toString();
  }

}
