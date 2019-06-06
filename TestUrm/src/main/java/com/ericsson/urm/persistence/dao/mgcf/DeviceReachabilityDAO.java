package com.ericsson.urm.persistence.dao.mgcf;

import com.ericsson.urm.exceptions.ConfigurationException;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.mgcf.DeviceReachability;
import com.ericsson.urm.persistence.dto.mgcf.ReachabilityStatistic;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import java.util.List;

public class DeviceReachabilityDAO extends GenericDAO {

	public static String QUERY_ALL = "from DeviceReachability ";
	public static String QUERY_DELETE_OLD = "delete from DeviceReachability where trunc(changeStatusTime)<trunc(sysdate - :nDaysOld)";


	public DeviceReachabilityDAO(HibernateSessionManagement sm) {
		super(sm);

	}

	/**
	 * This method return all the records contained in the table
	 * 
	 * @return
	 * @throws ConfigurationException
	 */
	public DeviceReachability[] getAll() throws ConfigurationException {
		List list = getSession().createQuery(QUERY_ALL).list();

		DeviceReachability[] ret = null;
		if (list != null && list.size() > 0) {
			ret = new DeviceReachability[list.size()];
			ret = (DeviceReachability[]) list.toArray(ret);
		} else
			ret = new DeviceReachability[0];

		return ret;
	}

	/**
	 * The method saves the record in the DB
	 * 
	 * @param ti
	 * @throws ConfigurationException
	 */
	public void save(DeviceReachability tt) throws ConfigurationException {
		ArgumentsCheckerUtil.checkNull(tt);
		getSession().save(tt);
	}

	public void saveOrUpdate(DeviceReachability tt) throws ConfigurationException {
		ArgumentsCheckerUtil.checkNull(tt);
		getSession().saveOrUpdate(tt);
	}

	/**
	 * this method permits to find a record by its primary key field id
	 * 
	 * @param codice
	 * @return 
	 * @throws ConfigurationException
	 */
	public DeviceReachability getById(Long id) throws ConfigurationException {
		ArgumentsCheckerUtil.checkNull(id);

		DeviceReachability ret = (DeviceReachability) getSession().get(DeviceReachability.class, id);
		return ret;
	}
	
	public void deleteOldest(int nDaysOld) {
		getSession().createQuery(QUERY_DELETE_OLD).setInteger("nDaysOld", nDaysOld).executeUpdate();
	}
	
	public ReachabilityStatistic getStatistics(int pMon) throws ConfigurationException {
		
		String sql = "Select count(1) as ncurr, nvl(sum(STATUS_UNREACHABILITY),0) as nfail from GCF_DEVICE_REACHABILITY dr "+
		             " inner join GCF_ACTIVITY act on dr.id_request = act.id_request inner join GCF_TASK_TYPE tt on act.tasktype_id = tt.code " +
					 " where tt.mon_int ='Y' and dr.CHANGE_STATUS_TIME between (sysdate-(:pMon/1440)) and sysdate";

	  
		SQLQuery qry = getSession().createSQLQuery(sql);
		qry.setInteger("pMon", pMon);

		qry.addScalar("ncurr",   Hibernate.LONG);
		qry.addScalar("nfail",  Hibernate.LONG);

		qry.setResultTransformer(Transformers.aliasToBean(ReachabilityStatistic.class));
		return (ReachabilityStatistic)qry.uniqueResult();

	}

}
