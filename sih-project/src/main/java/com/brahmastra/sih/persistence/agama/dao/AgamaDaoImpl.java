/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.agama.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.CoreDaoImpl;
import com.brahmastra.sih.persistence.agama.domain.Agama;

/**
 * @author viper
 * 
 */
@Repository
public class AgamaDaoImpl extends CoreDaoImpl<Agama> implements AgamaDao {
	public AgamaDaoImpl() {
		super();
	}

	@Autowired
	public AgamaDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
