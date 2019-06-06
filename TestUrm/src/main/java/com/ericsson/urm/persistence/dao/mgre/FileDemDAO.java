package com.ericsson.urm.persistence.dao.mgre;

import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.mgre.FileDem;
import com.ericsson.urm.persistence.dto.mgre.FileDemId;
import com.ericsson.urm.persistence.dto.mgre.FileDem;
import com.ericsson.urm.persistence.dto.mgre.FileDemId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import org.hibernate.Query;

import java.util.Date;

public class FileDemDAO extends GenericDAO {

    public FileDemDAO(HibernateSessionManagement sm) {
        super(sm);
    }

    public FileDem getById(FileDemId fileDemId) {
        ArgumentsCheckerUtil.checkNull(fileDemId, "fileDemId");
        return (FileDem) getSession().get(FileDem.class, fileDemId);
    }

    public void save(FileDem obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileDem");
        getSession().save(obj);
    }

    public void update(FileDem obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileDem");
        getSession().update(obj);
    }

    public void saveOrUpdate(FileDem obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileDem");
        getSession().saveOrUpdate(obj);
    }

    public void delete(FileDem obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileDem");
        getSession().delete(obj);
    }

    public long getTotalRowsByDate(Date acqDate){

        Query query = getSession().createQuery(
                "select count(*) from FileDem a where trunc(a.fileDemId.acquisitionDate)=trunc(:acqDate)");
        query.setDate("acqDate", acqDate);
        Long count = (Long)query.uniqueResult();

        return count;

    }
}
