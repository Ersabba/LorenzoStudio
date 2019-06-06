package com.ericsson.urm.persistence.dao.mds;

import com.ericsson.urm.persistence.OracleHibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.mds.AcqFileCcs;
import com.ericsson.urm.persistence.dto.mds.AcqFileCcsId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import org.hibernate.SQLQuery;
import org.hibernate.type.StringType;

import java.util.Date;
import java.util.List;

public class AcqFileCcsDAO extends GenericDAO {
	
	private final static String NATIVE_QUERY_FILE_CCS_FETCHED;
	private final static String NATIVE_QUERY_CCS_TO_BE_CHECKED;
	private final static String HQL_GET_LAST_FILE_FETCHED;

	static {
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(1) existsFile from mds_acq_file_ccs t                          ");
		sb.append(" where upper(t.error_type)='FETCHED'                                         ");
		sb.append(" and upper(substr(trim(t.file_name), -length(:fileName))) = upper(:fileName) ");
		sb.append(" and t.acq_date>=:beginDate                                                  ");
		sb.append(" and t.acq_date<=trunc(sysdate)                                              ");
		NATIVE_QUERY_FILE_CCS_FETCHED = sb.toString();
		
		sb = new StringBuilder();
		sb.append(" select distinct (t.cod_concentratore) codConcentratore                  ");
		sb.append("   from mds_acq_file_ccs t                                               ");
		sb.append("  where upper(t.error_type) <> 'FETCHED'                                 ");
		sb.append("    and (upper(substr(t.file_name, -12)) =                               ");
		sb.append("         upper('M' || to_char(sysdate, 'MM') ||                          ");
		sb.append("               substr(t.cod_concentratore, -5) || '.' || :fileExt))      ");
		sb.append("    and t.acq_date >= :beginDate                                         ");
		sb.append("    and t.acq_date <= trunc(sysdate)                                     ");
		NATIVE_QUERY_CCS_TO_BE_CHECKED = sb.toString();

        sb = new StringBuilder();
        sb.append(" select  s from AcqFileCcs as s                                          ");
        sb.append(" where   s.id.concentratorId=:cid and									");
        sb.append("         upper(s.id.fileName) like :file and								");
        sb.append("         s.errorType='FETCHED'											");
        sb.append(" ORDER BY s.id.acquisitionDate DESC LIMIT 1                    			");

        HQL_GET_LAST_FILE_FETCHED=sb.toString();
	}


	public AcqFileCcsDAO(OracleHibernateSessionManagement sm) {
		super(sm);
	}

	public AcqFileCcs getById(AcqFileCcsId id){
		ArgumentsCheckerUtil.checkNull(id,"AcqFileCcsId");

		return (AcqFileCcs) getSession().get(AcqFileCcs.class, id);
	}
	
	public void update(AcqFileCcs status){
		ArgumentsCheckerUtil.checkNull(status, "AcqFileCcs");
		getSession().update(status);
	}
	
	public void saveOrUpdate(AcqFileCcs status){
		ArgumentsCheckerUtil.checkNull(status, "AcqFileCcs");
		getSession().saveOrUpdate(status);
	}
	
	public void delete(AcqFileCcs status){
		ArgumentsCheckerUtil.checkNull(status, "AcqFileCcs");
		getSession().delete(status);
	}
	
	public void insert(AcqFileCcs status){
		ArgumentsCheckerUtil.checkNull(status, "AcqFileCcs");
		getSession().persist(status);
	}
	
	public List<String> getCcsWithFileNotProduced(Date beginDate, String fileExt) {
		
		ArgumentsCheckerUtil.checkNull(beginDate, "beginDate");
		ArgumentsCheckerUtil.checkString(fileExt, "fileExt");
		
		SQLQuery qry = getSession().createSQLQuery(NATIVE_QUERY_CCS_TO_BE_CHECKED);
		
		qry.setDate("beginDate", beginDate);
		qry.setString("fileExt", fileExt);
		qry.addScalar("codConcentratore", new StringType());
		
		List<String> list = qry.list();

		return list;
	}

	public boolean isCcsFileFetched(Date beginDate, String fileName) {
		ArgumentsCheckerUtil.checkNull(beginDate);
		ArgumentsCheckerUtil.checkString(fileName,"fileName");
	
		SQLQuery qry=getSession().createSQLQuery(NATIVE_QUERY_FILE_CCS_FETCHED);
		qry.setDate("beginDate", beginDate);
		qry.setString("fileName", fileName);
		qry.addScalar("existsFile", new org.hibernate.type.IntegerType());
		Integer ret = (Integer)qry.uniqueResult();
		
		return (ret!=null && ret>0);
	}

    public AcqFileCcs getLastFetchedFileByCcsIdAndFileName(String ccsId, String fileName){

        AcqFileCcs acqFileCcs = (AcqFileCcs)getSession().createQuery(HQL_GET_LAST_FILE_FETCHED)
                .setString("cid", ccsId)
                .setString("file", "%"+fileName.toUpperCase())
                .setMaxResults(1)
                .uniqueResult();

        return acqFileCcs;

    }
}
