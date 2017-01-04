/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.pasal.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.CoreDaoImpl;
import com.brahmastra.sih.persistence.pasal.domain.Pasal;

/**
 * @author viper
 * 
 */
@Repository
public class PasalDaoImpl extends CoreDaoImpl<Pasal> implements PasalDao {
	public PasalDaoImpl() {
		super();
	}

	@Autowired
	public PasalDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
