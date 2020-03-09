package com.ericsson.urm.persistence.dao.mds;

import com.ericsson.urm.persistence.OracleHibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;

import com.ericsson.urm.persistence.dto.mds.StatsAcqFileCcs;
import com.ericsson.urm.persistence.dto.mds.StatsAcqFileCcsId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;


public class StatsAcqFileCcsDAO extends GenericDAO {


	public StatsAcqFileCcsDAO(OracleHibernateSessionManagement sm) {
		super(sm);
	}

	public StatsAcqFileCcs getById(StatsAcqFileCcsId id){
		ArgumentsCheckerUtil.checkNull(id,"StatsAcqFileCcsId");

		return  getSession().get(StatsAcqFileCcs.class, id);
	}
	
	public void update(StatsAcqFileCcs status){
		ArgumentsCheckerUtil.checkNull(status, "StatsAcqFileCcs");
		getSession().update(status);
	}
	
	public void saveOrUpdate(StatsAcqFileCcs status){
		ArgumentsCheckerUtil.checkNull(status, "StatsAcqFileCcs");
		getSession().saveOrUpdate(status);
	}
	
	public void delete(StatsAcqFileCcs status){
		ArgumentsCheckerUtil.checkNull(status, "StatsAcqFileCcs");
		getSession().delete(status);
	}
	
	public void insert(StatsAcqFileCcs status){
		ArgumentsCheckerUtil.checkNull(status, "StatsAcqFileCcs");
		getSession().persist(status);
	}

}
