package com.ericsson.mgre.biz.networkMgmt;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJBLocalObject;

import com.ericsson.urm.db.MgdbDto;
import com.ericsson.urm.exceptions.URMBusinessException;


public interface MgreGuidbFacadeLocal extends EJBLocalObject {


	public List searchItemsByFilter(String tableName, Map columnParams, String dtoClass, int maxResults) throws URMBusinessException;

	public List searchItemsByWhereCondition(String tableName, String whereCondition, String dtoClass, int maxResults) throws URMBusinessException;

	public void updateAfterRecovery(MgdbDto mappedObj) throws URMBusinessException;
	
	// ritorna l'oggetto precedentemente esistente, null se non esisteva
	public MgdbDto saveOrUpdateAfterRecovery(MgdbDto mappedObj) throws URMBusinessException;

	public void save(Object mappedObj) throws URMBusinessException;

	public void delete(Object objToDelete) throws URMBusinessException;

	public Object getById(Class clazz, Serializable id) throws URMBusinessException;
}
