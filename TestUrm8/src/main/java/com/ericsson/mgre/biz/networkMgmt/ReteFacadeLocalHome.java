package com.ericsson.mgre.biz.networkMgmt;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface ReteFacadeLocalHome extends EJBLocalHome {
  public ReteFacadeLocal create()     throws CreateException;
}
