package com.ericsson.mgre.biz.networkMgmt.element;

import javax.ejb.EJBLocalObject;

public interface AceaLink extends EJBLocalObject {
  public String getAnnoFabbrAL() ;
  public String getCostruttoreAL() ;
  public Integer getIndirizzoAL() ;
  public String getMatricolaAL() ;
  public String getMatricolaLenntCliente() ;
  public String getNumProgrAL() ;
  public String getTipoApparatoAL() ;
  public void setAnnoFabbrAL(String val) ;
  public void setCostruttoreAL(String val) ;
  public void setIndirizzoAL(Integer val) ;
  public void setMatricolaAL(String val) ;
  public void setMatricolaLenntCliente(String val) ;
  public void setNumProgrAL(String val) ;
  public void setTipoApparatoAL(String val) ;
}
