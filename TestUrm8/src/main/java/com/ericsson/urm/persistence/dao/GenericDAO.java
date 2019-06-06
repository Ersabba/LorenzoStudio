package com.ericsson.urm.persistence.dao;

import com.ericsson.urm.exceptions.ConfigurationException;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.OracleHibernateSessionManagement;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import com.ericsson.urm.persistence.Hibernate;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.Date;

public abstract class GenericDAO {

	protected HibernateSessionManagement sm = null;
	protected Session session;
	protected Transaction transaction;

	private static Logger logger = Logger.getLogger(GenericDAO.class);

	public GenericDAO(HibernateSessionManagement sm) {
		super();
		this.sm = sm;
	}

	public GenericDAO() {
		super();
	}

	protected Session getSession() throws ConfigurationException {

		session = getSessionManagement().getSession();

		transaction=session.beginTransaction(); // Una porcata ma per renderlo compatibile con URM

		//logger.info("Stato transazione: "+transaction.getStatus());

		return session;
	}

	public HibernateSessionManagement getSessionManagement() {
		if (sm == null)
			throw new IllegalStateException("OracleHibernateSessionManagement not setted");
		return sm;
	}
	
	public long getSequenceValue(String sequenceName) {
		ArgumentsCheckerUtil.checkString(sequenceName,"sequenceName");
		
		Query query = getSession().createSQLQuery("select "+sequenceName+".nextval as num from dual")
			    .addScalar("num", Hibernate.BIG_INTEGER);

			    return ((BigInteger) query.uniqueResult()).longValue();
	}


	public Date parseDate(String dateTimeValue, String sqlFormatDateTime) {
		SQLQuery qry = getSession().createSQLQuery("SELECT to_timestamp(:dateTimeValue, :formatDateTime) as result FROM DUAL");
		qry.setString("dateTimeValue", dateTimeValue);
		qry.setString("formatDateTime", sqlFormatDateTime);
		qry.addScalar("result", Hibernate.TIMESTAMP);
		
		return (Date)qry.uniqueResult();
	}
	
	public String formatDate(Date dateTimeValue, String sqlFormatDateTime) {
		SQLQuery qry = getSession().createSQLQuery("SELECT to_char(:dateTimeValue, :formatDateTime) as result FROM DUAL");
		qry.setTimestamp("dateTimeValue", dateTimeValue);
		qry.setString("formatDateTime", sqlFormatDateTime);
		qry.addScalar("result", Hibernate.STRING);
		
		return (String)qry.uniqueResult();
	}
	
	public Date getSqlDateTime() {
		SQLQuery qry = getSession().createSQLQuery("SELECT systimestamp as result FROM DUAL");
		qry.addScalar("result", Hibernate.TIMESTAMP);
		
		return (Date)qry.uniqueResult();
	}

	public void closeTransaction(){
		transaction.commit();
		//session.close();
	}

}
