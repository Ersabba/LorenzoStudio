package com.ericsson.mgre.biz.networkMgmt.element.config;


/*
  ** This file was automatically generated by EJBGen 2.15 beta - Workshop 8.1
  ** Build: 20030408-0944
*/

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface ZonaHome extends EJBLocalHome {
  public Collection findAll()     throws FinderException;
  public Zona findByPrimaryKey(String primaryKey)     throws FinderException;
  public Zona create(String codZona)     throws CreateException;
}
