/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.jenisTindakPidana.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.CoreDaoImpl;
import com.brahmastra.sih.persistence.jenisTindakPidana.domain.JenisTindakPidana;

/**
 * @author viper
 * 
 */
@Repository
public class JenisTindakPidanaDaoImpl extends CoreDaoImpl<JenisTindakPidana>
		implements JenisTindakPidanaDao {
	public JenisTindakPidanaDaoImpl() {
		super();
	}

	@Autowired
	public JenisTindakPidanaDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
