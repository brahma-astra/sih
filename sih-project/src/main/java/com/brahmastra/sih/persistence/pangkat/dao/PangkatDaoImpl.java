/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.pangkat.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.CoreDaoImpl;
import com.brahmastra.sih.persistence.pangkat.domain.Pangkat;

/**
 * @author viper
 * 
 */
@Repository
public class PangkatDaoImpl extends CoreDaoImpl<Pangkat> implements PangkatDao {
	public PangkatDaoImpl() {
		super();
	}

	@Autowired
	public PangkatDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
