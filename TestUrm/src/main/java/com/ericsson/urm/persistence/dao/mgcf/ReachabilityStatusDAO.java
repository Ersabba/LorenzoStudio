package com.ericsson.urm.persistence.dao.mgcf;

import java.util.List;

import com.ericsson.urm.exceptions.ConfigurationException;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.mgcf.DeviceReachabilityStatus;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class ReachabilityStatusDAO extends GenericDAO {

    public static String QUERY_ALL = "from DeviceReachabilityStatus ";
    public static String QUERY_ORDERED_DESC = "from DeviceReachabilityStatus order by changeTime";

    public static String QUERY_ORDERED_LAST = "from DeviceReachabilityStatus order by changeTime DESC LIMIT 1";

    public ReachabilityStatusDAO(HibernateSessionManagement sm) {
        super(sm);

    }

    /**
     * This method return all the records contained in the table
     *
     * @return
     * @throws ConfigurationException
     */
    public DeviceReachabilityStatus[] getAll() throws  ConfigurationException {
        List list = getSession().createQuery(QUERY_ALL).list();

        DeviceReachabilityStatus[] ret = null;
        if (list != null && list.size() > 0) {
            ret = new DeviceReachabilityStatus[list.size()];
            ret = (DeviceReachabilityStatus[]) list.toArray(ret);
        } else
            ret = new DeviceReachabilityStatus[0];

        return ret;
    }

    /**
     * The method saves the record in the DB
     *
     * @param
     * @throws ConfigurationException
     */
    public void save(DeviceReachabilityStatus tt) throws ConfigurationException {
        ArgumentsCheckerUtil.checkNull(tt);
        getSession().save(tt);
    }

//	public void saveOrUpdate(DeviceReachabilityStatus tt) throws ConfigurationException {
//		ArgumentsCheckerUtil.checkNull(tt);
//		getSession().saveOrUpdate(tt);
//	}

    /**
     * this method permits to find a record by its primary key field id
     *
     * @param
     * @return
     * @throws ConfigurationException
     */
    public DeviceReachabilityStatus getById(Long idRequest) throws  ConfigurationException {
        ArgumentsCheckerUtil.checkNull(idRequest);

        DeviceReachabilityStatus ret = (DeviceReachabilityStatus) getSession().get(DeviceReachabilityStatus.class, idRequest);
        return ret;
    }


    public DeviceReachabilityStatus getLast() throws  ConfigurationException {

        DeviceReachabilityStatus ret = (DeviceReachabilityStatus)getSession().createQuery(QUERY_ORDERED_DESC)
                                                                            .setMaxResults(1)
                                                                            .uniqueResult();

        return ret;
    }




}
