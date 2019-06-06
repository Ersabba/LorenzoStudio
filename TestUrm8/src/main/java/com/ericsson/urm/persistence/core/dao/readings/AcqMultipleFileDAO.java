package com.ericsson.urm.persistence.core.dao.readings;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.jdbc.Work;

import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.FileCcsFetchedData;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import org.hibernate.type.DateType;


public class AcqMultipleFileDAO extends GenericDAO {

    private final static Logger logger = Logger.getLogger(AcqMultipleFileDAO.class);

    public final static String NATIVE_QUERY_FILES_TO_BE_PROCESSED;
    public final static String NATIVE_QUERY_FILES_TO_BE_PROCESSED_2;
    public final static String NATIVE_QUERY_FILES_TO_BE_PROCESSED_3;
    public final static String NATIVE_QUERY_FILES_TO_BE_PROCESSED_4;
    public final static String DELETE_QUERY_FILES_TO_BE_PROCESSED;

    public AcqMultipleFileDAO(HibernateSessionManagement sm) {
        super(sm);
    }

    static{
        StringBuffer app = new StringBuffer();
        app.append(" select t.cod_concentratore,       ");
        app.append("        t.file_name 			   ");
        app.append("   from mds_file_ccs_fetched t     ");
        app.append("  where t.file_type in(:fileTypes) ");
        //app.append("    and t.acq_date = trunc(:acqDate)");
        app.append("    and t.acq_date = :acqDate");
        app.append("    and t.data_elab is null        ");
        NATIVE_QUERY_FILES_TO_BE_PROCESSED = app.toString();
    }

    static{
        StringBuffer app = new StringBuffer();
        app.append(" select t.cod_concentratore,        ");
        app.append("        t.file_name 			    ");
        app.append("   from mds_file_ccs_fetched t      ");
        app.append("  where t.file_type = ?     ");
        app.append("    and t.acq_date = ?       ");
        app.append("    and t.data_elab is null         ");
        NATIVE_QUERY_FILES_TO_BE_PROCESSED_2 = app.toString();
    }

    static{
        StringBuffer app = new StringBuffer();
        app.append(" select t.cod_concentratore,            ");
        app.append("        t.file_name, 			        ");
        app.append("        t.file_type, 			        ");
        app.append("        t.acq_date,   			        ");
        app.append("        t.insert_time,			        ");
        app.append("        t.data_elab, 			        ");
        app.append("        t.file_corrente 			    ");

        app.append("   from mds_file_ccs_fetched t      ");
        /*app.append("  where t.file_type = :fileType     ");
        app.append("    and t.data_elab is null         ");*/
        NATIVE_QUERY_FILES_TO_BE_PROCESSED_3 = app.toString();
    }

    static{
        StringBuffer app = new StringBuffer();
        app.append(" INSERT INTO mds_file_ccs_fetched VALUES (?,?,?,?,?,?,?)           ");
        NATIVE_QUERY_FILES_TO_BE_PROCESSED_4 = app.toString();
    }

    static{
        StringBuffer app = new StringBuffer();
        app.append(" DELETE MDS_FILE_CCS_FETCHED WHERE cod_concentratore='G_EEA'");
        DELETE_QUERY_FILES_TO_BE_PROCESSED = app.toString();
    }

    public Map<String,Set<String>> getFilesToBeProcessed(Set<String> fileTypes, Date acqDate) {

        ArgumentsCheckerUtil.checkNull(fileTypes, "fieldname");

        Map<String,Set<String>> filesToBeProcessedMap = new HashMap<String, Set<String>>();
        Set<String> fileNameSet = null;

        SQLQuery sqlQuery = getSession().createSQLQuery(NATIVE_QUERY_FILES_TO_BE_PROCESSED);

        sqlQuery.setParameterList("fileTypes", fileTypes);

        logger.info("Data Acquisizione:"+acqDate);

        sqlQuery.setDate("acqDate", acqDate);

        //sqlQuery.setParameter("acqDate", acqDate, DateType.INSTANCE);

        logger.info("Parametri impostati");

        sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

        List data = sqlQuery.list();

        logger.info("Query eseguita");

        for(Object object : data){
            Map row = (Map)object;

            String codConcentratore = (String)row.get("COD_CONCENTRATORE");
            String fileName = (String)row.get("FILE_NAME");

            fileNameSet = filesToBeProcessedMap.get(codConcentratore);

            if(fileNameSet==null){
                fileNameSet = new HashSet<String>();
            }

            fileNameSet.add(fileName);
            filesToBeProcessedMap.put(codConcentratore, fileNameSet);
        }

        logger.info("Elaborazione risultato query eseguito");

        return filesToBeProcessedMap;
    }

    private final static String NATIVE_QUERY_FILES_TO_BE_PROCESSED_DATAELAB_NULL;
    static{
        StringBuffer app = new StringBuffer();
        app.append(" select t.cod_concentratore,		");
        app.append("        t.file_name,				");
        app.append("        t.acq_date					");
        app.append("   from mds_file_ccs_fetched t		");
        app.append("  where t.file_type in(:fileTypes)	");
        app.append("    and t.data_elab is null			");
        NATIVE_QUERY_FILES_TO_BE_PROCESSED_DATAELAB_NULL = app.toString();
    }

    public Map<String,Set<FileCcsFetchedData>> getFilesToBeProcessedDataElabNull(Set<String> fileTypes) {
        ArgumentsCheckerUtil.checkNull(fileTypes, "fieldname");

        Map<String,Set<FileCcsFetchedData>> filesToBeProcessedMap = new HashMap<String, Set<FileCcsFetchedData>>();
        Set<FileCcsFetchedData> fileNameSet = null;

        SQLQuery sqlQuery = getSession().createSQLQuery(NATIVE_QUERY_FILES_TO_BE_PROCESSED_DATAELAB_NULL);

        sqlQuery.setParameterList("fileTypes", fileTypes);
        sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

        List data = sqlQuery.list();

        for(Object object : data){
            Map row = (Map)object;

            String codConcentratore = (String)row.get("COD_CONCENTRATORE");
            String fileName = (String)row.get("FILE_NAME");
            Date acqDateFile = (Date)row.get("ACQ_DATE");
            FileCcsFetchedData fileCcsFetched = new FileCcsFetchedData(fileName, acqDateFile);

            fileNameSet = filesToBeProcessedMap.get(codConcentratore);

            if(fileNameSet==null){
                fileNameSet = new HashSet<FileCcsFetchedData>();
            }

            fileNameSet.add(fileCcsFetched);
            filesToBeProcessedMap.put(codConcentratore, fileNameSet);
        }

        return filesToBeProcessedMap;
    }

    public Map<String,Set<String>> getCcsFileNeededForReadings(String queryProps, String ccsRequest) {

        Map<String,Set<String>> result = new LinkedHashMap<String, Set<String>>();

        sm.getSession().doWork((new Work() {

            private String queryProps = null;
            private String ccsRequest = null;
            private Map<String,Set<String>> result = null;

            public Work initialize(String queryProps, String ccsRequest, Map<String,Set<String>> result) {
                ArgumentsCheckerUtil.checkString(queryProps,"queryProps");
                ArgumentsCheckerUtil.checkNull(result,"result");
                this.queryProps = queryProps;
                this.ccsRequest = ccsRequest;
                this.result = result;
                return this;
            }

            @Override
            public void execute(Connection connection) throws SQLException {

                CallableStatement stmt = null;
                String ccsId = null;
                String fileName = null;
                Set<String> fileNameSet = null;
                try {
                    stmt = connection.prepareCall("{ ? = call FCcsFileMissing(?,?) }");
                    stmt.registerOutParameter(1, OracleTypes.CURSOR);
                    stmt.setString(2, queryProps);
                    if(ccsRequest!=null && !ccsRequest.trim().isEmpty()) {
                        stmt.setString(3, ccsRequest);
                    } else {
                        stmt.setNull(3, OracleTypes.NULL);
                    }

                    stmt.execute();
                    ResultSet rs = ((OracleCallableStatement)stmt).getCursor(1);
                    while (rs.next()) {
                        ccsId    = rs.getString("cod_concentratore");
                        fileName = rs.getString("file_name");
                        fileNameSet = result.get(ccsId);
                        if(fileNameSet==null) {
                            fileNameSet = new LinkedHashSet<String>();
                        }
                        fileNameSet.add(fileName);

                        result.put(ccsId,fileNameSet);
                    }
                }
                catch(SQLException e) {
                    throw e;
                }
                catch (Exception e) {
                    throw new SQLException(e.getMessage(),e);
                }
                finally {
                    if(stmt!=null) {
                        try {
                            stmt.close();
                        } catch (Exception e) {
                            logger.error("Close CallableStatement failed; "+e.getMessage());
                        }
                    }
                }
            }
        }).initialize(queryProps, ccsRequest,result));

        return result;
    }



    public void deleteObsoleteFileCcsFetched(Date acquisitionDate) {

        sm.getSession().doWork((new Work() {

            private Date acquisitionDate = null;

            public Work initialize(Date acquisitionDate) {
                ArgumentsCheckerUtil.checkNull(acquisitionDate,"acquisitionDate");
                this.acquisitionDate = acquisitionDate;
                return this;
            }

            @Override
            public void execute(Connection connection) throws SQLException {

                CallableStatement stmt = null;
                try {
                    stmt = connection.prepareCall("{ call TruncateFileCcsFetched(?) }");
                    stmt.setDate(1, new java.sql.Date(acquisitionDate.getTime()));

                    stmt.executeUpdate();
                }
                catch(SQLException e) {
                    throw e;
                }
                catch (Exception e) {
                    throw new SQLException(e.getMessage(),e);
                }
                finally {
                    if(stmt!=null) {
                        try {
                            stmt.close();
                        } catch (Exception e) {
                            logger.error("Close CallableStatement failed; "+e.getMessage());
                        }
                    }
                }
            }
        }).initialize(acquisitionDate));

    }
}

