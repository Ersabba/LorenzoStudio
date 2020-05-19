package com.ericsson.urm.persistence.dao.gestionesw;

import com.ericsson.gestionesw.persistence.dto.SincrCcs;
import com.ericsson.gestionesw.persistence.dto.StatisticheConnessioniCcs;
import com.ericsson.gestionesw.persistence.dto.StatisticheConnessioniCcsId;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import com.ericsson.urm.util.DateUtil;
import org.apache.log4j.Logger;

import java.util.Date;

public class StatConnCcsDAO extends GenericDAO {

    private static final Logger logger = Logger.getLogger(StatConnCcsDAO.class);

    public StatConnCcsDAO(HibernateSessionManagement sm){
        super(sm);
    }

    public StatisticheConnessioniCcs getById(StatisticheConnessioniCcsId id){
        return (StatisticheConnessioniCcs)getSession().get(StatisticheConnessioniCcs.class, id);
    }

    public void save(StatisticheConnessioniCcs obj) {
        ArgumentsCheckerUtil.checkNull(obj, "StatisticheConnessioniCcs");
        getSession().save(obj);
    }

    public void saveOrUpdate(StatisticheConnessioniCcs obj) {
        ArgumentsCheckerUtil.checkNull(obj, "StatisticheConnessioniCcs");
        getSession().saveOrUpdate(obj);
    }

    public void delete(StatisticheConnessioniCcs obj) {
        ArgumentsCheckerUtil.checkNull(obj, "StatisticheConnessioniCcs");
        getSession().delete(obj);
    }

    public void incrementNumPostHttp(String matricolaCcs){

        StatisticheConnessioniCcsId statisticheConnessioniCcsId = new StatisticheConnessioniCcsId(matricolaCcs, DateUtil.azzeraHHMMSS(new Date()));

        StatisticheConnessioniCcs statisticheConnessioniCcs = getById(statisticheConnessioniCcsId);

        if(statisticheConnessioniCcs!=null)
            statisticheConnessioniCcs.setNumPostHttp(statisticheConnessioniCcs.getNumPostHttp()+1);
        else
            statisticheConnessioniCcs = new StatisticheConnessioniCcs(statisticheConnessioniCcsId,1);

        saveOrUpdate(statisticheConnessioniCcs);
    }
}
