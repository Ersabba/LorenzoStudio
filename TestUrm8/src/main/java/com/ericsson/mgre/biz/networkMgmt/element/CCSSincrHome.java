package com.ericsson.mgre.biz.networkMgmt.element;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;


/**
 * CSSSincro bean local home interface.
 */
public interface CCSSincrHome extends EJBHome{

	public CCSSincr create(String mtrCcs, String ip) throws java.rmi.RemoteException, CreateException;
	public CCSSincr findByPrimaryKey(String mtrCcs) throws java.rmi.RemoteException, FinderException;
}