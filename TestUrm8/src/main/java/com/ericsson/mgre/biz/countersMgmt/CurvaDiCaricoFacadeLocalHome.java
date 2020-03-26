package com.ericsson.mgre.biz.countersMgmt;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface CurvaDiCaricoFacadeLocalHome extends EJBLocalHome {
  public CurvaDiCaricoFacadeLocal create()     throws CreateException;
}
