package test;

import com.ericsson.gestionesw.persistence.dto.Trps;
import com.ericsson.gestionesw.persistence.dto.TrpsId;
import com.ericsson.gestionesw.persistence.dto.datatype.TipoUsoRel;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.OracleHibernateSessionManagement;
import com.ericsson.urm.persistence.RadiusHibernateSessionManagement;
import com.ericsson.urm.persistence.core.dao.radius.RadiusDAO;
import com.ericsson.urm.persistence.core.dao.readings.AcqMultipleFileDAO;
import com.ericsson.urm.persistence.core.dto.RadCheck;
import com.ericsson.urm.persistence.core.dto.RadiusCMSInfoDTO;
import com.ericsson.urm.persistence.core.dto.TestDto;
import com.ericsson.urm.persistence.dao.gestionesw.TrpsDAO;
import com.ericsson.urm.persistence.dao.mds.AcqFileCcsDAO;
import com.ericsson.urm.persistence.dao.mgcf.DeviceReachabilityDAO;
import com.ericsson.urm.persistence.dao.mgcf.ReachabilityStatusDAO;
import com.ericsson.urm.persistence.dao.mgre.*;
import com.ericsson.urm.persistence.dto.mds.AcqFileCcs;
import com.ericsson.urm.persistence.dto.mds.AcqFileCcsId;
import com.ericsson.urm.persistence.dto.mgcf.DeviceReachabilityStatus;
import com.ericsson.urm.persistence.dto.mgcf.ReachabilityStatistic;
import com.ericsson.urm.persistence.dto.mgre.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {

    public static void main(String[] args) {

        System.out.println("Maven + Hibernate + Oracle");

        // OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        /*AcqFileCcsDAO acqFileCcsDAO = new AcqFileCcsDAO(sm);

        Date dataAcquisizione = new GregorianCalendar(2016, Calendar.FEBRUARY, 18).getTime();
        String idConcentratore = "0508530013199";            // COD_CONCENTRATORE
        String fileName ="CCS/DATA/VI/G1413199.VI";                    // FILE_NAME

        System.out.println("Reperimento da DB riga data acq:" + dataAcquisizione + " idConc:"+idConcentratore+" fileName:"+fileName);

        AcqFileCcsId acqFileCcsId = new AcqFileCcsId(dataAcquisizione,idConcentratore,fileName);

        AcqFileCcs acqFileCcs = acqFileCcsDAO.getById(acqFileCcsId);

        System.out.println("Record trovato:"+acqFileCcs.toString());

        fileName="ADD03936.cfg";
        idConcentratore = "0506530003936";

        System.out.println("Reperimento da DB riga con file "+fileName+" e idconc:"+idConcentratore);

        acqFileCcs = acqFileCcsDAO.getLastFetchedFileByCcsIdAndFileName(idConcentratore,fileName);

        System.out.println("Record trovato:"+acqFileCcs.toString());

        String utenzaRadius="utenzaradius";
        idConcentratore="0504490000634";

        ConcentratoreDAO concentratoreDAO = new ConcentratoreDAO(sm);

        System.out.println("Aggiornamento status CCS rimossi per utenza radius "+utenzaRadius+" e CCS:"+idConcentratore);

        int recordAggiornati = concentratoreDAO.updateStatusCCSRimosso(utenzaRadius,idConcentratore);

        System.out.println("Record aggiornati:"+recordAggiornati);

        concentratoreDAO.closeTransaction();*/

        /* System.out.println("Maven + Hibernate + MySql");

        RadiusHibernateSessionManagement sm = new RadiusHibernateSessionManagement();

        RadiusDAO dao = new RadiusDAO(sm);

        String radiusUser="0506530003406";

        TestDto testDTO = dao.testMethod();

        System.out.println(" Info trovate per il test : "+testDTO);

        RadiusCMSInfoDTO radiusCMSInfoDTO = dao.getRadiusInfoByRadiusUsername2("0506530003406"); // 0506530003406
        radiusCMSInfoDTO.setUser("0506530003406");

        System.out.println(" Info trovate per il radius: "+radiusCMSInfoDTO);

        List<RadCheck> list = dao.getAllRadCheck();

        //for (RadCheck rc : list)
        System.out.println(list.get(0));


        dao.closeTransaction(); */

        //testTRPS();

        //testTables_CR52();

        //testDateHibernate();

        testJDBCConnection();
    }

    static public void  testReachability(){

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        ReachabilityStatusDAO reachabilityStatusDAO = new ReachabilityStatusDAO(sm);

        DeviceReachabilityStatus deviceReachabilityStatus = reachabilityStatusDAO.getLast();

        System.out.println(" Info trovate per il test : "+deviceReachabilityStatus);

        //reachabilityStatusDAO.closeTransaction();


        DeviceReachabilityDAO deviceReachabilityDAO = new DeviceReachabilityDAO(sm);

        ReachabilityStatistic stat = deviceReachabilityDAO.getStatistics(1000);


        System.out.println("Statistiche:"+stat);

        deviceReachabilityDAO.closeTransaction();

    }

    static public void  testTRPS(){

        System.out.println("Maven + Hibernate + Oracle + Tabella TRPS");

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        TrpsDAO trpsDAO = new TrpsDAO(sm);

       //List<Trps> list = trpsDAO.getAll();

        /* for(Trps trps:list)
            System.out.println(trps);

        list = trpsDAO.getAllViewJsp();

        for(Trps trps:list)
            System.out.println(trps);

        list = trpsDAO.getTrpsGroup("MA","TEST",	"SMA");

        for(Trps trps:list)
            System.out.println(trps);*/

        // SET	SB	PSA_UPD14.SET	12346	TEST	201	500

        String codice="PAR";
        String tipoInstallazione ="ANG";
        String fileName="ANG_UPD.PAR";
        String checkSum="36600";
        String ambiente ="TEST";
        String minValue="1";
        String maxValue="10";

        TrpsId trpsId = new TrpsId(codice, TipoUsoRel.parse(ambiente), tipoInstallazione, Long.parseLong(minValue));
        Trps trps = new Trps(trpsId,fileName,checkSum,Long.parseLong(maxValue));

        //trpsDAO.update(trps);

        trpsDAO.deleteGroup(tipoInstallazione,ambiente,codice);

        trpsDAO.closeTransaction();

    }

    static void testTables_CR52(){

        System.out.println("Maven + Hibernate + Oracle + Bug Ojdbc");

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        /*FileAddressDAO fileAddressDAO = new FileAddressDAO(sm);

        FileAddressId fileAddressId = new FileAddressId("codConcentrat", new Date(), "0123456789");

        FileAddress fileAddress = new FileAddress(fileAddressId,"gruppo","progressivo","fase","indirizzoHDLC","dataAss","oraAss",new Date());

        fileAddressDAO.save(fileAddress);

        fileAddressDAO.closeTransaction();*/

/*        FileDemDAO fileDemDAO = new FileDemDAO(sm);

        FileDemId fileDemId = new FileDemId("codConcentra2", new Date(), "012345678_2");

        FileDem fileDem = new FileDem(fileDemId,"data2","ora2",new Date());

        fileDemDAO.save(fileDem);

        fileDemDAO.closeTransaction();*/

        /*FileComDAO fileComDAO = new FileComDAO(sm);

        FileComId fileComId = new FileComId("codConcentra2", new Date(), "012345678_2");

        FileCom fileCom = new FileCom(fileComId,"commOk1","commTOT2","commPer2",new Date());

        fileComDAO.save(fileCom);

        fileComDAO.closeTransaction();*/

        /* FileRoutingDAO fileRoutingDAO = new FileRoutingDAO(sm);
        FileAddressDAO fileAddressDAO = new FileAddressDAO(sm);
        FileDemDAO fileDemDAO = new FileDemDAO(sm);
        FileComDAO fileComDAO = new FileComDAO(sm);

        // Inseriamo 100 righe: con 4 concentratori diversi
       FileRoutingId fileRoutingId;

        FileRouting fileRouting;

        for(int i=1;i<=4;i++){
            for(int j=0;j<25;j++){

                fileRoutingId = new FileRoutingId("codConcentr"+i, new Date(), "MATR_"+j);
                fileRouting = new FileRouting(fileRoutingId,"rip1","rip2","rip3","rip4",new Date());
                fileRoutingDAO.save(fileRouting)
                ;
            }
        }*/


        /*String string = "15 Febbraio 2019";
        DateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        Date testDate = null;
        try {
            testDate = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long nRows = fileRoutingDAO.getTotalRowsByDate(testDate);

        System.out.println("Data: "+testDate+" Numero di righe della tabella GRE_FILE_ROU: "+nRows);

        List<FileRouting> list = fileRoutingDAO.getRowsByDateAndRange(testDate,3,7);

        for(Object fileRouting:list){
            System.out.println("FileRouting " +fileRouting);
        }

        nRows = fileAddressDAO.getTotalRowsByDate(testDate);

        System.out.println("Numero di righe della tabella GRE_FILE_ADDRESS: "+nRows);

        nRows = fileComDAO.getTotalRowsByDate(testDate);

        System.out.println("Numero di righe della tabella GRE_FILE_COM: "+nRows);

        nRows = fileDemDAO.getTotalRowsByDate(testDate);

        System.out.println("Numero di righe della tabella GRE_FILE_DEM: "+nRows);

        fileAddressDAO.closeTransaction();
        fileComDAO.closeTransaction();
        fileDemDAO.closeTransaction();
        fileRoutingDAO.closeTransaction();*/

    }

    static void testJDBCConnection(){

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@172.30.6.80:1521:svil", "URMTEST3", "URMTEST3");

            PreparedStatement stmt=connection.prepareStatement(AcqMultipleFileDAO.NATIVE_QUERY_FILES_TO_BE_PROCESSED_4);

            stmt.setString(1,"G_EEA");

            stmt.setString(2,"G_EEA");
            stmt.setString(3,"G_EEA");

            String string = "03 Giugno 2019 15:41:00";
            DateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");

           /* String string = "01 Giugno 2019";
            DateFormat format = new SimpleDateFormat("dd MMMM yyyy");*/
            Date acqDate = null;
            try {
                acqDate = format.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            /*Calendar cal = Calendar.getInstance();
            cal.setTime(acqDate);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            acqDate = cal.getTime();*/

            java.sql.Date testDate = new java.sql.Date(acqDate.getTime());

            System.out.println("Data passata alla query: "+testDate);

            stmt.setDate(4, testDate);
            stmt.setString(5,"G_EEA");
            stmt.setDate(6, testDate);
            stmt.setString(7,"G");

            //ResultSet rs=stmt.executeQuery();

            int re =stmt.executeUpdate();

            // System.out.println("Statement query: "+ rs.getStatement().toString());
            System.out.println("Record inseriti"+ re);

            /*if (!rs.next() ) {
                System.out.println("no data");
            }
            else {
                while (rs.next()) {
                    String codConc = rs.getString("COD_CONCENTRATORE");
                    String fileType = rs.getString("FILE_TYPE");
                    String fileName = rs.getString("FILE_NAME");
                    Date acqDate1 =rs.getDate("ACQ_DATE");
                    String insertTime = rs.getString("INSERT_TIME");
                    Date dataElab =rs.getDate("DATA_ELAB");
                    String fileCorrente = rs.getString("FILE_CORRENTE");

                    System.out.println(codConc + "\t" + fileType +
                            "\t" + fileName + "\t" + acqDate1 +
                            "\t" + insertTime + "\t" + dataElab + "\t" + fileCorrente);
                }
            }*/

            connection.close();


        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    static void testDateHibernate() {

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        String string = "01 Giugno 2019 15:41:00";
        DateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
        Date acqDate = null;
        try {
            acqDate = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*Calendar cal = Calendar.getInstance();
        cal.setTime(acqDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        acqDate = cal.getTime();*/

        System.out.println("Data acquisizione:"+acqDate);

        Set<String> fileTypes = new HashSet<String>();

        fileTypes.add("G_EEA");

        AcqMultipleFileDAO dao = new AcqMultipleFileDAO(sm);

        Map<String,Set<String>> filesForCCS = dao.getFilesToBeProcessed(fileTypes, acqDate);

        if(filesForCCS.isEmpty()){
            System.out.println("Nessun risultato !!!!");
        }
        else{
            for (Map.Entry<String, Set<String>> entry : filesForCCS.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }
        }
        dao.closeTransaction();


    }
}
