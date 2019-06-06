package com.ericsson.urm.persistence.core.dao.radius;

import com.ericsson.urm.exceptions.URMBusinessException;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.core.dto.RadCheck;
import com.ericsson.urm.persistence.core.dto.RadiusCMSInfoDTO;
import com.ericsson.urm.persistence.core.dto.TestDto;
import com.ericsson.urm.persistence.dao.GenericDAO;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

public class RadiusDAO extends GenericDAO {

    private static Logger logger = Logger.getLogger(RadiusDAO.class);

    public RadiusDAO(HibernateSessionManagement sm) {
        super(sm);
    }

    public RadiusCMSInfoDTO getRadiusInfoByRadiusUsername(String radiusUsername){

        StringBuffer sb = new StringBuffer();

        sb.append("select max(case                                                                                  ");
        sb.append("			when attribute='User-Password'                                                          ");
        sb.append("	   then                                                                                         ");
        sb.append("	   		value                                                                                   ");
        sb.append("	   else ''                                                                                      ");
        sb.append("	   end) as password,                                                                                 ");
        sb.append("	                                                                                                ");
        sb.append("	   max(case                                                                                     ");
        sb.append("			when attribute='Calling-Station-Id'                                                     ");
        sb.append("	   then                                                                                         ");
        sb.append("	   		value                                                                                   ");
        sb.append("	   else ''                                                                                      ");
        sb.append("	   end) as simnumber,                                                                              ");
        sb.append("	                                                                                                ");
        sb.append("	   max(case                                                                                     ");
        sb.append("			when attribute='Framed-IP-Address'                                                      ");
        sb.append("	   then                                                                                         ");
        sb.append("	   		value                                                                                   ");
        sb.append("	   else ''                                                                                      ");
        sb.append("	   end) as ipaddr                                                                               ");
        sb.append("		                                                                                            ");
        sb.append("		from (                                                                                      ");
        sb.append("                                                                                                 ");
        sb.append("		select  username,                                                                           ");
        sb.append("				attribute,                                                                          ");
        sb.append("				value                                                                               ");
        sb.append("		from 	radcheck                                                                            ");
        sb.append("		where 	username='"+radiusUsername+"' and attribute in('Calling-Station-Id', 'User-Password')    ");
        sb.append("		                                                                                            ");
        sb.append("		union                                                                                       ");
        sb.append("		                                                                                            ");
        sb.append("		select 	username,                                                                           ");
        sb.append("				attribute,                                                                          ");
        sb.append("				value                                                                               ");
        sb.append("		from 	radreply where username='"+radiusUsername+"' and attribute ='Framed-IP-Address'          ");
        sb.append("                                                                                                 ");
        sb.append(") a                                                                                              ");
        sb.append("group by username                                                                                ");

        SQLQuery qry=getSession().createSQLQuery(sb.toString());

        qry.addScalar("password",   Hibernate.STRING);
        qry.addScalar("simnumber",  Hibernate.STRING);
        qry.addScalar("ipaddr",     Hibernate.STRING);

        qry.setResultTransformer(Transformers.aliasToBean(RadiusCMSInfoDTO.class));

        RadiusCMSInfoDTO ret = (RadiusCMSInfoDTO)qry.uniqueResult();

        return ret;

    }

    public RadiusCMSInfoDTO getRadiusInfoByRadiusUsername2(String radiusUsername){

        StringBuffer sb = new StringBuffer();

        sb.append("	select		r.value as ipaddr,                                                     ");
        sb.append("				rc.value as simnumber,                                                 ");
        sb.append("				rc2.value as password,                                                 ");
        sb.append("				u.operatore as operator                                                ");
        sb.append("	from  		radreply r                                                             ");
        sb.append("	left join 	urmiprange u on r.value=u.ipAddress                                    ");
        sb.append("	inner join (                                                                       ");
        sb.append("		                                                                               ");
        sb.append("		select 	username,                                                              ");
        sb.append("				value                                                                  ");
        sb.append("		from 	radcheck                                                               ");
        sb.append("		where 	attribute = 'Calling-Station-Id'                                       ");
        sb.append("                                                                                    ");
        sb.append("	) rc on rc.username=r.username                                                     ");
        sb.append("	inner join (                                                                       ");
        sb.append("		                                                                               ");
        sb.append("		select 	username,                                                              ");
        sb.append("				value                                                                  ");
        sb.append("		from 	radcheck                                                               ");
        sb.append("		where 	attribute = 'User-Password'                                            ");
        sb.append("                                                                                    ");
        sb.append("	) rc2 on rc2.username=r.username                                                   ");
        sb.append("	where 	r.username='"+radiusUsername+"' and r.attribute ='Framed-IP-Address'       ");
        SQLQuery qry=getSession().createSQLQuery(sb.toString());

        qry.addScalar("password",   Hibernate.STRING);
        qry.addScalar("simnumber",  Hibernate.STRING);
        qry.addScalar("ipaddr",     Hibernate.STRING);
        qry.addScalar("operator",   Hibernate.STRING);

        qry.setResultTransformer(Transformers.aliasToBean(RadiusCMSInfoDTO.class));

        RadiusCMSInfoDTO ret = (RadiusCMSInfoDTO)qry.uniqueResult();

        return ret;
    }

    public List<RadCheck> getAllRadCheck(){


        String hql = "from RadCheck";
        Query query = session.createQuery(hql);
        List<RadCheck> listRadcheck = query.list();

        return listRadcheck;
    }
    
    public RadiusCMSInfoDTO aggiornaRadiusUserAndSim(String sim, String utenteRadius, String operatoreTelefonico) throws URMBusinessException{
    	
    	//mysql stored proc updateRadiusCambioSim(sim varchar(30), utenteRadius varchar(30), operatoreTelefonico varchar(30),  out ipRadius varchar(30), out pwdRadius varchar(30))


		CallableStatement cs = null;
		try {
			cs = sm.getSession().connection().prepareCall("{call updateRadiusCambioSim(?, ?, ?, ?, ?)}" );
			cs.setString(1, sim);
			cs.setString(2, utenteRadius);
			cs.setString(3, operatoreTelefonico);
			
			cs.executeUpdate();
			
			String ipRadius  = cs.getString(4);
			String pwdRadius  = cs.getString(5);
			
			RadiusCMSInfoDTO res = new RadiusCMSInfoDTO();
			res.setIpaddr(ipRadius);
			res.setPassword(pwdRadius);
			res.setSimnumber(sim);
			return res;
			
		} catch (Exception e) {
			throw new URMBusinessException("Error updating sim: "+e.getMessage(), e);
		} finally {
			if(cs!=null) {
				try { cs.close(); } catch (SQLException e) { logger.error(e.toString(),e); }
			}
		}

    }

    public TestDto testMethod(){

        StringBuffer sb = new StringBuffer();

        sb.append("select r.username as par1, \n");
        sb.append("r.attribute as par2, \n");
        sb.append("r.value as par3  \n");
        sb.append("from radreply r where r.username='0506530003406' \n");

        SQLQuery qry=getSession().createSQLQuery(sb.toString());

        qry.addScalar("par1",   Hibernate.STRING);
        qry.addScalar("par2",  Hibernate.STRING);
        qry.addScalar("par3",     Hibernate.STRING);


/*        Object[] objs = (Object[])qry.uniqueResult();

        for(int i=0;i<objs.length;i++)
            System.out.println("Oggetto "+i+" :"+objs[i]);*/

        qry.setResultTransformer(Transformers.aliasToBean(TestDto.class));

        TestDto ret = (TestDto)qry.uniqueResult();

        return ret;

    }

}
