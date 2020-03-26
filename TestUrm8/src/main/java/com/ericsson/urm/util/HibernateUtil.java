package com.ericsson.urm.util;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


public class HibernateUtil {

	public static Criterion makeInClause(String propertyName, List<Object> values) {
		if (values.size() <= 1000)
			return Restrictions.in(propertyName, values);
		else {
			return Restrictions.or(	Restrictions.in(propertyName, values.subList(0, 1000)),
									makeInClause(propertyName, values.subList(1000, values.size())));
		}
	}
}
