package com.ericsson.mgre.biz.networkMgmt;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;


public interface MgreGuidbFacadeLocalHome extends EJBLocalHome {

	public MgreGuidbFacadeLocal create() throws CreateException;
}
