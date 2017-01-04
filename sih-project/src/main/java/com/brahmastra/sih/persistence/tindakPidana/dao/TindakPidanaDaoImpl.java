/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.tindakPidana.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.CoreDaoImpl;
import com.brahmastra.sih.persistence.tindakPidana.domain.TindakPidana;

/**
 * @author viper
 * 
 */
@Repository
public class TindakPidanaDaoImpl extends CoreDaoImpl<TindakPidana> implements
		TindakPidanaDao {
	public TindakPidanaDaoImpl() {
		super();
	}

	@Autowired
	public TindakPidanaDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
