/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.konfigurasi.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.CoreDaoImpl;
import com.brahmastra.sih.persistence.konfigurasi.domain.Konfigurasi;

/**
 * @author viper
 * 
 */
@Repository
public class KonfigurasiDaoImpl extends CoreDaoImpl<Konfigurasi> implements
		KonfigurasiDao {
	
	public KonfigurasiDaoImpl() {
		super();
	}

	@Autowired
	public KonfigurasiDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
