package com.ericsson.urm.persistence.dao.gestionesw;


import com.ericsson.gestionesw.persistence.dto.SincrCcs;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;

import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import org.hibernate.SQLQuery;

import java.util.List;

public class SincrCcsDAO extends GenericDAO {

	private static final Logger logger = Logger.getLogger(SincrCcsDAO.class);

	private final static String NATIVE_SQL_GET_LAST_CCS_SINCHRONIZATION;

	static {

		StringBuilder sb = new StringBuilder();

		sb.append("select aa.* from (												");
		sb.append("		select * from GRE_SINCR_CCS 								");
		sb.append("		where mtrccs=:cid and esito=:result							");
		sb.append("		order by id desc											");
		sb.append(") aa where rownum<=1												");
		NATIVE_SQL_GET_LAST_CCS_SINCHRONIZATION = sb.toString();
	}

	public SincrCcsDAO(HibernateSessionManagement sm){
		super(sm);
	}

	public SincrCcs getById(Long id){
		return (SincrCcs)getSession().get(SincrCcs.class, id);
	}

	public List<SincrCcs> getAll(){
		Criteria crit = getSession().createCriteria(SincrCcs.class);
		List<SincrCcs> res = crit.list();
		return res;
	}

	public void save(SincrCcs obj) {
		ArgumentsCheckerUtil.checkNull(obj, "SincrCcs");
		getSession().save(obj);
	}

	public void saveOrUpdate(SincrCcs obj) {
		ArgumentsCheckerUtil.checkNull(obj, "SincrCcs");
		getSession().saveOrUpdate(obj);
	}

	public void delete(SincrCcs obj) {
		ArgumentsCheckerUtil.checkNull(obj, "SincrCcs");
		getSession().delete(obj);
	}

	public SincrCcs getLastCcsSyncronization(String ccsId){

		Object result=null;

		try {

			SQLQuery query = getSession().createSQLQuery(NATIVE_SQL_GET_LAST_CCS_SINCHRONIZATION);
			query.addEntity("aa", SincrCcs.class);
			query.setString("cid", ccsId);
			query.setString("result", SincrCcs.Esito.SUCCESS.toString());

			result = query.uniqueResult();

			return (SincrCcs) result;

		}
		catch (ClassCastException ex) {
			logger.info("Object classloader: " + result.getClass().getClassLoader());
			logger.info("Target class classloader: " + SincrCcs.class.getClassLoader());
			if(result.getClass().getClassLoader() != SincrCcs.class.getClassLoader()) {
				logger.warn("Different classloaders detected!");
			}

		}

		return null;
	}
}
