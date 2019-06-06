package com.ericsson.urm.persistence.dao.mgre;

import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.mgre.FileAddress;
import com.ericsson.urm.persistence.dto.mgre.FileAddressId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import org.hibernate.Query;

import java.util.Date;

public class FileAddressDAO extends GenericDAO {

    public FileAddressDAO(HibernateSessionManagement sm) {
        super(sm);
    }


    public FileAddress getById(FileAddressId fileAddressId) {
        ArgumentsCheckerUtil.checkNull(fileAddressId, "fileAddressId");
        return (FileAddress) getSession().get(FileAddress.class, fileAddressId);
    }

    public void save(FileAddress obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileAddress");
        getSession().save(obj);
    }

    public void update(FileAddress obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileAddress");
        getSession().update(obj);
    }

    public void saveOrUpdate(FileAddress obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileAddress");
        getSession().saveOrUpdate(obj);
    }

    public void delete(FileAddress obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileAddress");
        getSession().delete(obj);
    }

    public long getTotalRowsByDate(Date acqDate){

        Query query = getSession().createQuery(
                "select count(*) from FileAddress a where trunc(a.fileAddressId.acquisitionDate)=trunc(:acqDate)");
        query.setDate("acqDate", acqDate);
        Long count = (Long)query.uniqueResult();

        return count;

    }
}
