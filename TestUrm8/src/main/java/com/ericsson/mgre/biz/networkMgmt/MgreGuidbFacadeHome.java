package com.ericsson.mgre.biz.networkMgmt;


import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MgreGuidbFacadeHome extends EJBHome {

	public MgreGuidbFacade create() throws CreateException, RemoteException;

}
