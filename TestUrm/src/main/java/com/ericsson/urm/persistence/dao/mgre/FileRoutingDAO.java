package com.ericsson.urm.persistence.dao.mgre;

import com.ericsson.urm.exceptions.URMBusinessException;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.mgre.FileRouting;
import com.ericsson.urm.persistence.dto.mgre.FileRoutingId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;

import java.util.Date;
import java.util.List;

public class FileRoutingDAO extends GenericDAO {

    private final static String NATIVE_QUERY_GET_ROWS_BY_DATE_AND_RANGE;
    private final static String HQL_QUERY_GET_ROWS_BY_DATE_AND_RANGE;

    static {

/*        StringBuffer app = new StringBuffer();
        app.append("select a.*                                      ");
        app.append("from (                                          ");
        app.append("select  *                                       ");
        app.append("        from GRE_FILE_ROU                       ");
        app.append("        where TRUNC(ACQ_DATE) =TRUNC(:acq_date) ");
        app.append("        order by  cod_concentratore, mtr        ");
        app.append("                                                ");
        app.append(") a                                             ");
        app.append("where rownum between :minRow and :maxRow        ");
        NATIVE_QUERY_GET_ROWS_BY_DATE_AND_RANGE = app.toString();*/

        StringBuffer app = new StringBuffer();

        app.append("SELECT  mtr as mtr,                                                                ");
        app.append("        rip1 as rip1,                                                               ");
        app.append("        RIP2 as RIP2,                                                               ");
        app.append("        RIP3 as RIP3,                                                               ");
        app.append("        RIP4,                                                               ");
        app.append("        ACQ_DATE,                                                           ");
        app.append("        COD_CONCENTRATORE,                                                  ");
        app.append("        EXPORT_DATE                                                         ");
        app.append("FROM (                                                                      ");
        app.append("        SELECT  b.*,                                                        ");
        app.append("                ROW_NUMBER() OVER (ORDER BY COD_CONCENTRATORE, MTR) as RN   ");
        app.append("        FROM GRE_FILE_ROU b                                                 ");
        app.append("        WHERE TRUNC(ACQ_DATE) =TRUNC(:acq_date)                             ");
        app.append(") a WHERE a.RN BETWEEN :minRow AND :maxRow                                  ");
        NATIVE_QUERY_GET_ROWS_BY_DATE_AND_RANGE = app.toString();

        app = new StringBuffer();

        app.append("from   FileRouting f                                                      ");
        app.append("where  trunc(fileRoutingId.acquisitionDate)=trunc(:acqDate)               ");
        app.append("order by fileRoutingId.codiceConcentratore asc,fileRoutingId.matricola asc");
        HQL_QUERY_GET_ROWS_BY_DATE_AND_RANGE = app.toString();
    }

    public FileRoutingDAO(HibernateSessionManagement sm) {
        super(sm);
    }

    public FileRouting getById(FileRoutingId fileRoutingId) {
        ArgumentsCheckerUtil.checkNull(fileRoutingId, "FileRoutingId");
        return (FileRouting) getSession().get(FileRouting.class, fileRoutingId);
    }

    public void save(FileRouting obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileRouting");
        getSession().save(obj);
    }

    public void update(FileRouting obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileRouting");
        getSession().update(obj);
    }

    public void saveOrUpdate(FileRouting obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileRouting");
        getSession().saveOrUpdate(obj);
    }

    public void delete(FileRouting obj) {
        ArgumentsCheckerUtil.checkNull(obj, "FileRouting");
        getSession().delete(obj);
    }

    public long getTotalRowsByDate(Date acqDate){

        Query query = getSession().createQuery(
                "select count(*) from FileRouting a where trunc(a.fileRoutingId.acquisitionDate)=trunc(:acqDate)");
        query.setDate("acqDate", acqDate);
        Long count = (Long)query.uniqueResult();

        return count;

    }

    public List<FileRouting> getRowsByRange2(Date acqDate, long min_row_number, long max_row_number)  {
        ArgumentsCheckerUtil.checkNull(acqDate, "Data Acquisizione");

        SQLQuery qry = getSession().createSQLQuery(NATIVE_QUERY_GET_ROWS_BY_DATE_AND_RANGE);
        qry.setDate("acq_date", acqDate);
        qry.setLong("minRow",min_row_number);
        qry.setLong("maxRow",max_row_number);

        qry.addScalar("mtr",   Hibernate.STRING);
        qry.addScalar("rip1",   Hibernate.STRING);

        qry.setResultTransformer(Transformers.aliasToBean(FileRouting.class));

        List<FileRouting> list=qry.list();

        return list;

    }

    public List<FileRouting> getRowsByDateAndRange(Date acqDate, long min_row_number, long max_row_number) {

        Query query = session.createQuery(HQL_QUERY_GET_ROWS_BY_DATE_AND_RANGE);
        query.setDate("acqDate",acqDate);

        query.setFirstResult((int)min_row_number-1);
        query.setMaxResults((int)(max_row_number-min_row_number));
        List<FileRouting> result = query.list();

        return result;
    }
}
