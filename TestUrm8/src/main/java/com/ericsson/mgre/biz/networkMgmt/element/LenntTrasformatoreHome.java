package com.ericsson.mgre.biz.networkMgmt.element;


/*
  ** This file was automatically generated by EJBGen 2.15 beta - Workshop 8.1
  ** Build: 20030408-0944
*/

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface LenntTrasformatoreHome extends EJBLocalHome {
  public Collection findAll()     throws FinderException;
  public Collection findAvailable()     throws FinderException;
  public Collection findAvailableForSbarraBt()     throws FinderException;
  public Collection findByCodConcentratore(String codConcentratore)     throws FinderException;
  public Collection findByCodSbarraBt(Long codSbarraBt)     throws FinderException;
  public LenntTrasformatore findByPrimaryKey(String primaryKey)     throws FinderException;
  public LenntTrasformatore create(String matricolaLennt)     throws CreateException;
  public String[] getByRaggiungLennt(String raggiungLennt)  throws javax.ejb.FinderException;
}
