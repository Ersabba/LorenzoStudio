package com.ericsson.mgre.biz.networkMgmt;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

//import javax.ejb.EJBObject;

//import com.ericsson.urm.db.CrudPerformer;
import com.ericsson.urm.db.MgdbDto;
import com.ericsson.urm.exceptions.URMBusinessException;


public interface MgreGuidbFacade  {

	public List searchItemsByFilter(String tableName, Map columnParams, String dtoClass, int maxResults) throws URMBusinessException, RemoteException;

	public List searchItemsByWhereCondition(String tableName, String whereCondition, String dtoClass, int maxResults) throws URMBusinessException,
			RemoteException;

	public void updateAfterRecovery(MgdbDto mappedObj) throws URMBusinessException, RemoteException;
	
	// ritorna l'oggetto precedentemente esistente, null se non esisteva
	public MgdbDto saveOrUpdateAfterRecovery(MgdbDto mappedObj) throws URMBusinessException, RemoteException;

	public void save(Object mappedObj) throws URMBusinessException, RemoteException;

	public void delete(Object objToDelete) throws URMBusinessException, RemoteException;

	public Object getById(Class clazz, Serializable id) throws URMBusinessException, RemoteException;
}
