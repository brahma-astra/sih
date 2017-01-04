/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.kasus.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.HistoricalCoreDaoImpl;
import com.brahmastra.sih.persistence.kasus.domain.Kasus;

/**
 * @author viper
 * 
 */
@Repository
public class KasusDaoImpl extends HistoricalCoreDaoImpl<Kasus> implements
		KasusDao {
	
	public KasusDaoImpl() {
		super();
	}

	@Autowired
	public KasusDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<Kasus> findKasusBetweenDate(String columnName, Date startDate, Date endDate, int... rowStartIdxAndCount) {
		log.debug("finding " + this.persistentClass.getName()
				+ " instance between: " + startDate.toString() + ", to: " + endDate.toString());
		
		try {
			String queryString = "from " + this.persistentClass.getName()
					+ " as model where model." + columnName + " between :start and :end";
			
			System.out.println(queryString);
			
			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);
			
			query.setParameter("start", startDate);
            query.setParameter("end", endDate);
            
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}
				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			// return getHibernateTemplate().find(queryString, value);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find " + this.persistentClass.getName()
					+ " between " + startDate.toString() + " to " + endDate.toString() + " failed", re);
			throw re;
		}
	}
}
