package com.ericsson.urm.persistence.dao.mgre;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.mgre.LenntConcentratore;
import com.ericsson.urm.persistence.dto.mgre.LenntConcentratoreId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class LenntConcentratoreDAO extends GenericDAO {
		
	private static String QUERY_ALL = "from LenntConcentratore a";
	
	
	

	public LenntConcentratoreDAO(HibernateSessionManagement sm) {
		super(sm);		
	}
	
	
	public LenntConcentratore getById(LenntConcentratoreId lenntConcentratoreId){
		ArgumentsCheckerUtil.checkNull(lenntConcentratoreId,"lenntConcentratoreId");
		return (LenntConcentratore)getSession().get(LenntConcentratore.class, lenntConcentratoreId);
	}

	public void save(LenntConcentratore obj) {
		ArgumentsCheckerUtil.checkNull(obj, "LenntConcentratore");
		getSession().save(obj);
	}

	public void saveOrUpdate(LenntConcentratore obj) {
		ArgumentsCheckerUtil.checkNull(obj, "LenntConcentratore");
		getSession().saveOrUpdate(obj);
	}

	public void delete(LenntConcentratore obj) {
		ArgumentsCheckerUtil.checkNull(obj, "LenntConcentratore");
		getSession().delete(obj);
	}
	
	public LenntConcentratore[] getAll() {
		
		Query query = getSession().createQuery(QUERY_ALL);
	
		List list = query.list();
		LenntConcentratore[] ret = null;
		if(list.size()>0) {
			ret = new LenntConcentratore[list.size()];
			ret = (LenntConcentratore[])list.toArray(ret);
		} else {
			ret = new LenntConcentratore[0];
		}
		return ret;
	}
	
	
	public LenntConcentratore[] getByDateBindingRange(Date beginDate, Date endDate) {
		
		StringBuffer sb = new StringBuffer(QUERY_ALL);
		String ope = " where";
		
		if(beginDate!=null) {
			sb.append(ope);
			sb.append(" a.id.dateBinding > :beginDate");
			ope = " and";
		}
		if(endDate!=null) {
			sb.append(ope);
			sb.append(" a.id.dateBinding <= :endDate");
			ope = " and";
		}
		sb.append(" order by a.id.dateBinding, a.id.concentratorId, a.id.meterId");
			
		Query query = getSession().createQuery(sb.toString());
		if(beginDate!=null) {
			query.setDate("beginDate", beginDate);
		}
		if(endDate!=null) {
			query.setDate("endDate", endDate);
		}
		
		List list = query.list();
		LenntConcentratore[] ret = null;
		if(list.size()>0) {
			ret = new LenntConcentratore[list.size()];
			ret = (LenntConcentratore[])list.toArray(ret);
		} else {
			ret = new LenntConcentratore[0];
		}
		return ret;
	}
	
}
