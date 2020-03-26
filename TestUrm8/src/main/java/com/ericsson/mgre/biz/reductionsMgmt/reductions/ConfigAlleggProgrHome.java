package com.ericsson.mgre.biz.reductionsMgmt.reductions;


/*
  ** This file was automatically generated by EJBGen 2.15 beta - Workshop 8.1
  ** Build: 20030408-0944
*/

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface ConfigAlleggProgrHome extends EJBLocalHome {
  public Collection findAll()     throws FinderException;
  public Collection findByCodConfigAll(String codConfigAll)     throws FinderException;
  public Collection findByCoeffLimitazione(Long coeffLimitazione)     throws FinderException;
  public ConfigAlleggProgr findByPrimaryKey(com.ericsson.mgre.biz.reductionsMgmt.reductions.ConfigAlleggProgrBeanPK primaryKey)     throws FinderException;
  public ConfigAlleggProgr create(String codConfigAll, String giornoSettimana)     throws CreateException;
  public String[] getAllCodConfigAll()  throws javax.ejb.FinderException;
}
