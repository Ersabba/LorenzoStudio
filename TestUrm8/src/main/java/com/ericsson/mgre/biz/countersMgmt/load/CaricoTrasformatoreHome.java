package com.ericsson.mgre.biz.countersMgmt.load;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface CaricoTrasformatoreHome extends EJBLocalHome {
  public CaricoTrasformatore findByPrimaryKey(com.ericsson.mgre.biz.countersMgmt.load.CaricoTrasformatoreBeanPK primaryKey)     throws FinderException;
  public Collection findByTrasformatoreAndData(Long codTrasformatore, java.util.Date dataCurva)     throws FinderException;
  public CaricoTrasformatore create(Long codTrasformatore, java.util.Date dataCurva, Long numPeriodo)     throws CreateException;
}
