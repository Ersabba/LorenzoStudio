package com.ericsson.mgre.biz.networkMgmt;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface ConfigurazioniFacadeLocalHome extends EJBLocalHome {
  public ConfigurazioniFacadeLocal create()     throws CreateException;
}
