/**
 * 
 */
package com.g4s.travelaware.api.repository.utility;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author GhostRider
 *
 */
public class HibernateUtility {
	public int hqlTruncate(String myTable, Session session){
	    String hql = String.format("delete from %s",myTable);
	    Query query = session.createQuery(hql);
	    return query.executeUpdate();
	}
}
