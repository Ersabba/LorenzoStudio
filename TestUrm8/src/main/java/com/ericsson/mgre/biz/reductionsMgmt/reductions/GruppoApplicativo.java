package com.ericsson.mgre.biz.reductionsMgmt.reductions;

/*
  ** This file was automatically generated by EJBGen 2.15 beta - Workshop 8.1
  ** Build: 20030408-0944
*/

import javax.ejb.EJBLocalObject;


public interface GruppoApplicativo extends EJBLocalObject {
  public String getCodCabinaSecondaria() ;
  public String getCodConfigAll() ;
  public String getCodGruppoApplicativo() ;
  public String getCodTiputt() ;
  public Long getCoeffLimitazione() ;
  public String getGiornoSettimana() ;
  public Long getPrimoProgrUtile() ;
  public String getStatoAlleggEmerg() ;
  public String getStatoAlleggProgr() ;
  public void setCodCabinaSecondaria(String val) ;
  public void setCodConfigAll(String val) ;
  public void setCodGruppoApplicativo(String val) ;
  public void setCodTiputt(String val) ;
  public void setCoeffLimitazione(Long val) ;
  public void setGiornoSettimana(String val) ;
  public void setPrimoProgrUtile(Long val) ;
  public void setStatoAlleggEmerg(String val) ;
  public void setStatoAlleggProgr(String val) ;
}