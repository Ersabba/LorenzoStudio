package com.ericsson.mgre.biz.countersMgmt.load;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface CurvaDiCaricoHome extends EJBLocalHome {
  public Collection findAll()     throws FinderException;
  public Collection findByLenntAndInterval(String matricolaLenntCliente, java.util.Date start, java.util.Date end)     throws FinderException;
  public Collection findByMatricolaLenntCliente(String matricolaLenntCliente)     throws FinderException;
  public CurvaDiCarico findByPrimaryKey(com.ericsson.mgre.biz.countersMgmt.load.CurvaDiCaricoBeanPK primaryKey)     throws FinderException;
  public CurvaDiCarico create(java.util.Date dataCurva, String matricolaLenntCliente, Long numPeriodo)     throws CreateException;
}
