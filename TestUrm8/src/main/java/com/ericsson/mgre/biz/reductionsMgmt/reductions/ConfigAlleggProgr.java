package com.ericsson.mgre.biz.reductionsMgmt.reductions;

/*
  ** This file was automatically generated by EJBGen 2.15 beta - Workshop 8.1
  ** Build: 20030408-0944
*/

import javax.ejb.EJBLocalObject;


public interface ConfigAlleggProgr extends EJBLocalObject {
  public String getCodConfigAll() ;
  public Long getCoeffLimitazione() ;
  public String getGiornoSettimana() ;
  public Integer getOraFine() ;
  public Integer getOraInizio() ;
  public void setCodConfigAll(String val) ;
  public void setCoeffLimitazione(Long val) ;
  public void setGiornoSettimana(String val) ;
  public void setOraFine(Integer val) ;
  public void setOraInizio(Integer val) ;
}