package com.ericsson.mgre.biz.networkMgmt;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface ReteFacadeHome extends EJBHome {
  public ReteFacade create()     throws CreateException, RemoteException;

}
