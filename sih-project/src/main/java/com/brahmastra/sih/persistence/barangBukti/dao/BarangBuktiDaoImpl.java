/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.barangBukti.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.HistoricalCoreDaoImpl;
import com.brahmastra.sih.persistence.barangBukti.domain.BarangBukti;

/**
 * @author viper
 * 
 */
@Repository
public class BarangBuktiDaoImpl extends HistoricalCoreDaoImpl<BarangBukti>
		implements BarangBuktiDao {
	public BarangBuktiDaoImpl() {
		super();
	}

	@Autowired
	public BarangBuktiDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
