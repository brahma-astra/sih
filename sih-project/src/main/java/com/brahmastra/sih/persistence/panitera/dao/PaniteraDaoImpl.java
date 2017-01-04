/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.panitera.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.HistoricalCoreDaoImpl;
import com.brahmastra.sih.persistence.panitera.domain.Panitera;

/**
 * @author viper
 * 
 */
@Repository
public class PaniteraDaoImpl extends HistoricalCoreDaoImpl<Panitera> implements
		PaniteraDao {
	public PaniteraDaoImpl() {
		super();
	}

	@Autowired
	public PaniteraDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
