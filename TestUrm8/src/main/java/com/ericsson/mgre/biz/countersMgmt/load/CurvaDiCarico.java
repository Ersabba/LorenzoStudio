package com.ericsson.mgre.biz.countersMgmt.load;

import javax.ejb.EJBLocalObject;

public interface CurvaDiCarico extends EJBLocalObject {
  public Long getAttAss() ;
  public Long getAttEr() ;
  public java.util.Date getDataCurva() ;
  public String getMatricolaLenntCliente() ;
  public Long getNumPeriodo() ;
  public String getPeriodoAcquisizione() ;
  public Long getPeriodoIntegrazione() ;
  public Long getReattCapAss() ;
  public Long getReattCapEr() ;
  public Long getReattIndAss() ;
  public Long getReattIndEr() ;
  public void setAttAss(Long val) ;
  public void setAttEr(Long val) ;
  public void setDataCurva(java.util.Date val) ;
  public void setMatricolaLenntCliente(String val) ;
  public void setNumPeriodo(Long val) ;
  public void setPeriodoAcquisizione(String val) ;
  public void setPeriodoIntegrazione(Long val) ;
  public void setReattCapAss(Long val) ;
  public void setReattCapEr(Long val) ;
  public void setReattIndAss(Long val) ;
  public void setReattIndEr(Long val) ;
}
