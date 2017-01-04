package com.brahmastra.sih.persistence.user.dao;

import com.brahmastra.sih.core.dao.CoreDao;
import com.brahmastra.sih.persistence.user.domain.User;

/**
 * @author viper
 * 
 */
public interface UserDao extends CoreDao<User> {

	/**
	 * @author viper
	 * @param user
	 * @return User
	 */
	User updateWithoutPassword(User user);

	/**
	 * @author viper
	 * @param user
	 * @return User
	 */
	User updatePassword(User user);
}
