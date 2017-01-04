/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.hakim.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.CoreDaoImpl;
import com.brahmastra.sih.persistence.hakim.domain.Hakim;

/**
 * @author viper
 * 
 */
@Repository
public class HakimDaoImpl extends CoreDaoImpl<Hakim> implements HakimDao {
	public HakimDaoImpl() {
		super();
	}

	@Autowired
	public HakimDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
