/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.saksi.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.CoreDaoImpl;
import com.brahmastra.sih.persistence.saksi.domain.Saksi;

/**
 * @author viper
 * 
 */
@Repository
public class SaksiDaoImpl extends CoreDaoImpl<Saksi> implements SaksiDao {
	public SaksiDaoImpl() {
		super();
	}

	@Autowired
	public SaksiDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
