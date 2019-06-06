package com.ericsson.urm.persistence.dao.gestionesw;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.ericsson.gestionesw.persistence.dto.Trps;
import com.ericsson.gestionesw.persistence.dto.TrpsId;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import org.hibernate.SQLQuery;

public class TrpsDAO extends GenericDAO {

	private static Logger logger = Logger.getLogger(TrpsDAO.class);

	private final static String QUERY_ALL = " from Trps";

	private static String GET_TRPS_GROUP ;
	private static String NATIVE_QUERY_ALL_VIEW_JSP;
    private static String DELETE_TRPS_GROUP;

	// Query che contiene anche l'header di gruppo
	static {
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT      TYPE_INSTALL_UFF,                                     ");
		sb.append("            TIPO_USO_REL,                                         ");
		sb.append("            CODE,                                                 ");
		sb.append("            FILE_NAME,                                            ");
		sb.append("            CHECKSUM,                                             ");
		sb.append("            MIN_VALUE,                                            ");
		sb.append("            MAX_VALUE                                             ");
		sb.append("FROM (                                                            ");
		sb.append("                                                                  ");
		sb.append("    select      TYPE_INSTALL_UFF,                                 ");
		sb.append("                TIPO_USO_REL,                                     ");
		sb.append("                CODE,                                             ");
		sb.append("                '' as FILE_NAME,                                  ");
		sb.append("                '' as CHECKSUM,                                   ");
		sb.append("                -2 as MIN_VALUE,                                  ");
		sb.append("                -2 as MAX_VALUE                                   ");
		sb.append("    from        GRE_TRPS                                          ");
		sb.append("    group by    TYPE_INSTALL_UFF,TIPO_USO_REL,CODE                ");
		sb.append("                                                                  ");
		sb.append("    union                                                         ");
		sb.append("                                                                  ");
		sb.append("    select  TYPE_INSTALL_UFF,                                     ");
		sb.append("            TIPO_USO_REL,                                         ");
		sb.append("            CODE,                                                 ");
		sb.append("            FILE_NAME,                                            ");
		sb.append("            CHECKSUM,                                             ");
		sb.append("            MIN_VALUE,                                            ");
		sb.append("            MAX_VALUE                                             ");
		sb.append("    from GRE_TRPS a                                               ");
		sb.append("                                                                  ");
		sb.append(") b                                                               ");
		sb.append("order by b.TYPE_INSTALL_UFF,b.tipo_uso_rel,b.CODE,b.MIN_VALUE asc ");

		NATIVE_QUERY_ALL_VIEW_JSP = sb.toString();

		sb.setLength(0);

		sb.append("from 	Trps t																			");
		sb.append("where  	t.typeInstallUff =:typeInstallUff and t.trpsId.tipoUsoRelease=:tipoUsoRelease   ");
		sb.append("			and t.trpsId.code=:code 														");
		sb.append("order by t.trpsId.rangeMinValue asc														");

		GET_TRPS_GROUP = sb.toString();

        sb.setLength(0);

        sb.append("delete	from 	Trps t																			");
        sb.append("where  	t.trpsId.typeInstallUff =:typeInstallUff and t.trpsId.tipoUsoRelease=:tipoUsoRelease   	");
        sb.append("			and t.trpsId.code=:code 																");

        DELETE_TRPS_GROUP = sb.toString();
	}

	public TrpsDAO(HibernateSessionManagement sm) {
		super(sm);
	}

	public List<Trps> getAll() throws HibernateException, IllegalArgumentException{
		@SuppressWarnings("unchecked")

		List<Trps> listAll = getSession().createQuery(QUERY_ALL).list();
		return listAll;

	}

	public List<Trps> getAllViewJsp() throws HibernateException, IllegalArgumentException{
		@SuppressWarnings("unchecked")

		SQLQuery qry = getSession().createSQLQuery(NATIVE_QUERY_ALL_VIEW_JSP).addEntity(Trps.class);
		List<Trps> listAll = qry.list();
		return listAll;
	}

	public Trps getById(TrpsId trpsId) throws HibernateException, IllegalArgumentException{
		ArgumentsCheckerUtil.checkNull(trpsId,"trpsId");
		Trps trps = (Trps) getSession().get(Trps.class, trpsId);
		return trps;
	}

	public void save(Trps trps) throws HibernateException, IllegalArgumentException{
		ArgumentsCheckerUtil.checkNull(trps,"trps");
		getSession().save( trps );
	}

	public void delete(Trps trps) throws HibernateException, IllegalArgumentException{
		ArgumentsCheckerUtil.checkNull(trps,"trps");
		getSession().delete( trps );
	}

	public void update(Trps trps) throws HibernateException, IllegalArgumentException{
		ArgumentsCheckerUtil.checkNull(trps,"trps");
		getSession().update( trps );
	}

	public void saveOrUpdate(Trps trps) throws HibernateException, IllegalArgumentException{
		ArgumentsCheckerUtil.checkNull(trps,"trps");
		getSession().saveOrUpdate( trps );
	}

	public void merge(Trps trps) throws HibernateException, IllegalArgumentException{
		ArgumentsCheckerUtil.checkNull(trps,"trps");
		getSession().merge( trps );
	}

	public void resetIdParSetRange(long id) throws HibernateException, IllegalArgumentException{
		getSession().createQuery("update gre_trps set id_par_set_range = null where id_par_set_range = " + id).executeUpdate();

	}

	public List<Trps>  getTrpsGroup(String typeInstallUff, String tipoUsoRelease, String code ){

		return getSession().createQuery(GET_TRPS_GROUP)
				.setString("typeInstallUff",typeInstallUff)
				.setString("tipoUsoRelease",tipoUsoRelease)
				.setString("code",code).list();
	}

    public int deleteGroup(String tipoInstallazione, String ambiente, String codice) {
        return getSession().createQuery(DELETE_TRPS_GROUP)
                .setString("typeInstallUff",tipoInstallazione)
                .setString("tipoUsoRelease",ambiente)
                .setString("code",codice).executeUpdate();
    }

    public void insertAll(List<Trps> trpsToInsert) {
        for(Trps trps:trpsToInsert)
            getSession().save(trps);
    }
}