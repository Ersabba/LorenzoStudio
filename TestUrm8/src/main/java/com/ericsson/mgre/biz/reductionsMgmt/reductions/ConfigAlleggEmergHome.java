package com.ericsson.mgre.biz.reductionsMgmt.reductions;


/*
  ** This file was automatically generated by EJBGen 2.15 beta - Workshop 8.1
  ** Build: 20030408-0944
*/

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface ConfigAlleggEmergHome extends EJBLocalHome {
  public Collection findAll()     throws FinderException;
  public ConfigAlleggEmerg findByPrimaryKey(Long primaryKey)     throws FinderException;
  public ConfigAlleggEmerg create(Long coeffLimitazione)     throws CreateException;
}
