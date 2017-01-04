/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.lampiran.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.HistoricalCoreDaoImpl;
import com.brahmastra.sih.persistence.lampiran.domain.Lampiran;

/**
 * @author viper
 * 
 */
@Repository
public class LampiranDaoImpl extends HistoricalCoreDaoImpl<Lampiran> implements
		LampiranDao {
	public LampiranDaoImpl() {
		super();
	}

	@Autowired
	public LampiranDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
