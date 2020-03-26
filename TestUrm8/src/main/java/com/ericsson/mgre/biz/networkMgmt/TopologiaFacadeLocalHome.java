package com.ericsson.mgre.biz.networkMgmt;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface TopologiaFacadeLocalHome extends EJBLocalHome {
  public TopologiaFacadeLocal create()     throws CreateException;
}
