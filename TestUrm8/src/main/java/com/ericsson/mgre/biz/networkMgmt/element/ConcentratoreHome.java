package com.ericsson.mgre.biz.networkMgmt.element;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface ConcentratoreHome extends EJBLocalHome {
  public Collection findAll()     throws FinderException;
  public Collection findAvailable()     throws FinderException;
  public Collection findByCodCabinaSecondaria(String codCabinaSecondaria)     throws FinderException;
  public Collection findByCodTrasformatore(Long codTrasformatore)     throws FinderException;
  public String[] getCodConcentratoreForNetworkWideActivities()  throws javax.ejb.FinderException;
  public Concentratore findByPrimaryKey(String primaryKey)     throws FinderException;
  public Concentratore create(String codConcentratore)     throws CreateException;
}
