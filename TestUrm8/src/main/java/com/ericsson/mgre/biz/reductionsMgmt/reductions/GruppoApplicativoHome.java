package com.ericsson.mgre.biz.reductionsMgmt.reductions;


/*
  ** This file was automatically generated by EJBGen 2.15 beta - Workshop 8.1
  ** Build: 20030408-0944
*/

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface GruppoApplicativoHome extends EJBLocalHome {
  public Collection findAll()     throws FinderException;
  public Collection findByCodCabinaSecondaria(String codCabinaSecondaria)     throws FinderException;
  public Collection findByCodConfigAll(String codConfigAll)     throws FinderException;
  public Collection findByCodTiputt(String codTiputt)     throws FinderException;
  public Collection findByCoeffLimitazione(long coeffLimitazione)     throws FinderException;
  public Collection findByGiornoSettimana(String giornoSettimana)     throws FinderException;
  public GruppoApplicativo findByPrimaryKey(String primaryKey)     throws FinderException;
  public Collection findByStatoAlleggEmerg(String statoAlleggEmerg)     throws FinderException;
  public Collection findByStatoAlleggProgr(String statoAlleggProgr)     throws FinderException;
  public GruppoApplicativo create(String codGruppoApplicativo)     throws CreateException;
}
