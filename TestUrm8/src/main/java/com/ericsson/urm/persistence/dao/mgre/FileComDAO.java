package com.ericsson.urm.persistence.dao.mgre;

import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.mgre.FileCom;
import com.ericsson.urm.persistence.dto.mgre.FileComId;
import com.ericsson.urm.persistence.dto.mgre.FileDem;
import com.ericsson.urm.persistence.dto.mgre.FileDemId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import org.hibernate.Query;

import java.util.Date;

public class FileComDAO extends GenericDAO {

    public FileComDAO(HibernateSessionManagement sm) {
        super(sm);
    }

    public FileCom getById(FileComId fileComId) {
        ArgumentsCheckerUtil.checkNull(fileComId, "fileComId");
        return (FileCom) getSession().get(FileCom.class, fileComId);
    }

    public void save(FileCom obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileDem");
        getSession().save(obj);
    }

    public void update(FileCom obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileDem");
        getSession().update(obj);
    }

    public void saveOrUpdate(FileCom obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileDem");
        getSession().saveOrUpdate(obj);
    }

    public void delete(FileCom obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileDem");
        getSession().delete(obj);
    }

    public long getTotalRowsByDate(Date acqDate){

        Query query = getSession().createQuery(
                "select count(*) from FileCom a where trunc(a.fileComId.acquisitionDate)=trunc(:acqDate)");
        query.setDate("acqDate", acqDate);
        Long count = (Long)query.uniqueResult();

        return count;

    }
}
