/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.tersangka.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.CoreDaoImpl;
import com.brahmastra.sih.persistence.tersangka.domain.Tersangka;

/**
 * @author viper
 * 
 */
@Repository
public class TersangkaDaoImpl extends CoreDaoImpl<Tersangka> implements
		TersangkaDao {
	public TersangkaDaoImpl() {
		super();
	}

	@Autowired
	public TersangkaDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
