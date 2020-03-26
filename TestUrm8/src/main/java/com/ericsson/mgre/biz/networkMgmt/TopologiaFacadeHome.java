package com.ericsson.mgre.biz.networkMgmt;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface TopologiaFacadeHome extends EJBHome {
  public TopologiaFacade create()     throws CreateException, RemoteException;

}
