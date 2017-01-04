/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.kitabHukum.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.CoreDaoImpl;
import com.brahmastra.sih.persistence.kitabHukum.domain.KitabHukum;

/**
 * @author viper
 * 
 */
@Repository
public class KitabHukumDaoImpl extends CoreDaoImpl<KitabHukum> implements
		KitabHukumDao {
	public KitabHukumDaoImpl() {
		super();
	}

	@Autowired
	public KitabHukumDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
