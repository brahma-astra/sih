/**
 * @author viper
 * @date May 21, 2011
 */
package com.brahmastra.sih.service.user;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brahmastra.sih.common.util.PasswordUtil;
import com.brahmastra.sih.common.vo.PaginatedResult;
import com.brahmastra.sih.persistence.user.dao.UserDao;
import com.brahmastra.sih.persistence.user.domain.User;

/**
 * @author viper
 * 
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * @author viper
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @author viper
	 * @param userDao
	 *            the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#insert(com.cakra.sih.core.domain.CoreDomain)
	 * @param transientInstance
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	@Override
	@Transactional(readOnly = false)
	public User insert(User transientInstance) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		String unEncryptedPwd = transientInstance.getPassword();
		String encryptedPwd = PasswordUtil.getInstance()
				.encrypt(unEncryptedPwd);
		transientInstance.setPassword(encryptedPwd);
		return userDao.insert(transientInstance);
	}

	/**
	 * @author viper
	 * @param detachedInstance
	 * @param isUpdatePassword
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	@Override
	@Transactional(readOnly = false)
	public User update(User detachedInstance, Boolean isUpdatePassword)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// List<User> users = (List<User>) userDao.findByProperty("id",
		// detachedInstance.getId());
		// User user = users.get(0);
		// String unEncryptedPwd = detachedInstance.getPassword();
		// System.out.println("-----unEncryptedPwd----" + unEncryptedPwd);
		// System.out.println("-----user.getPassword()----" +
		// user.getPassword());
		// only encrypt when password entered is different
		// from the password stored in the database
		// if (isUpdatePassword) {
		// String encryptedPwd = PasswordUtil.getInstance()
		// .encrypt(detachedInstance.getPassword());
		// detachedInstance.setPassword(encryptedPwd);
		// }
		User user = userDao.findById(detachedInstance.getId());
		String unEncryptedPwd = detachedInstance.getPassword();
		if (!unEncryptedPwd.equals(user.getPassword())) {
			String encryptedPwd = PasswordUtil.getInstance().encrypt(
					detachedInstance.getPassword());
			detachedInstance.setPassword(encryptedPwd);
		}
		return userDao.update(detachedInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#update(com.cakra.sih.core.domain.CoreDomain)
	 * @param detachedInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
	public User update(User detachedInstance) {
		return userDao.update(detachedInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#remove(com.cakra.sih.core.domain.CoreDomain)
	 * @param persistentInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
	public Boolean remove(User persistentInstance) {
		return userDao.remove(persistentInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#removeList(java.util.List)
	 * @param list
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
	public Boolean removeList(List<User> list) {
		return userDao.removeList(list);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findById(java.lang.String)
	 * @param id
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findById(String id) {
		return userDao.findById(id);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findByExample(com.cakra.sih.core.domain.CoreDomain,
	 *      int[])
	 * @param instance
	 * @param rowStartIdxAndCount
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<User> findByExample(User instance, int... rowStartIdxAndCount) {
		return userDao.findByExample(instance, rowStartIdxAndCount);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findByProperty(java.lang.String,
	 *      java.lang.Object, int[])
	 * @param propertyName
	 * @param value
	 * @param rowStartIdxAndCount
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<User> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		return userDao.findByProperty(propertyName, value, rowStartIdxAndCount);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findAll(int[])
	 * @param rowStartIdxAndCount
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<User> findAll(int... rowStartIdxAndCount) {
		return userDao.findAll(rowStartIdxAndCount);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findLikeProperty(java.lang.String,
	 *      java.lang.Object, int[])
	 * @param propertyName
	 * @param value
	 * @param rowStartIdxAndCount
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<User> findLikeProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		return userDao.findLikeProperty(propertyName, value,
				rowStartIdxAndCount);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findLikeMapOfProperties(java.util.Map,
	 *      int[])
	 * @param propertiesMap
	 * @param rowStartIdxAndCount
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<User> findLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return userDao.findLikeMapOfProperties(propertiesMap,
				rowStartIdxAndCount);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findByMapOfProperties(java.util.Map,
	 *      int[])
	 * @param propertiesMap
	 * @param rowStartIdxAndCount
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<User> findByMapOfProperties(Map<String, Object> propertiesMap,
			int... rowStartIdxAndCount) {
		return userDao
				.findByMapOfProperties(propertiesMap, rowStartIdxAndCount);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#countAll()
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Integer countAll() {
		return userDao.countAll();
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#countLikeProperty(java.lang.String,
	 *      java.lang.Object)
	 * @param propertyName
	 * @param value
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Integer countLikeProperty(String propertyName, Object value) {
		return userDao.countLikeProperty(propertyName, value);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#countByProperty(java.lang.String,
	 *      java.lang.Object)
	 * @param propertyName
	 * @param value
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Integer countByProperty(String propertyName, Object value) {
		return userDao.countByProperty(propertyName, value);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#countLikeMapOfProperties(java.util.Map)
	 * @param propertiesMap
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Integer countLikeMapOfProperties(Map<String, Object> propertiesMap) {
		return userDao.countLikeMapOfProperties(propertiesMap);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#countByMapOfProperties(java.util.Map)
	 * @param propertiesMap
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Integer countByMapOfProperties(Map<String, Object> propertiesMap) {
		return userDao.countByMapOfProperties(propertiesMap);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#paginateLikeMapOfProperties(java.util.Map,
	 *      int[])
	 * @param propertiesMap
	 * @param rowStartIdxAndCount
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PaginatedResult<User> paginateLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return userDao.paginateLikeMapOfProperties(propertiesMap,
				rowStartIdxAndCount);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#paginateAll(int[])
	 * @param rowStartIdxAndCount
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PaginatedResult<User> paginateAll(int... rowStartIdxAndCount) {
		return userDao.paginateAll(rowStartIdxAndCount);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#paginateByMapOfProperties(java.util.Map,
	 *      int[])
	 * @param propertiesMap
	 * @param rowStartIdxAndCount
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PaginatedResult<User> paginateByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return userDao.paginateByMapOfProperties(propertiesMap,
				rowStartIdxAndCount);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
	public User updateWithoutPassword(User user) {
		return userDao.updateWithoutPassword(user);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
	public User updatePassword(User user) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		String encryptedPwd = PasswordUtil.getInstance().encrypt(
				user.getPassword());
		user.setPassword(encryptedPwd);
		return userDao.updatePassword(user);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User login(String username, String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		List<User> users = userDao.findByProperty("username", username, null);
		if (users.isEmpty()) {
			return null;
		}
		User user = users.get(0);
		String encryptedPwd = PasswordUtil.getInstance().encrypt(password);
		if (!user.getPassword().equals(encryptedPwd)) {
			return null;
		}
		return user;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public void doLogout() {
		// FlexSession session = FlexContext.getFlexSession();
		// if (FlexContext.getHttpRequest() != null
		// && FlexContext.getHttpRequest().getSession() != null) {
		// FlexContext.getHttpRequest().getSession().invalidate();
		// }
		// if (session != null) {
		// session.invalidate();
		// }
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findLikeMapOfPropertiesWithKasus(java.lang.String,
	 *      java.util.Map, int[])
	 * @param idKasus
	 * @param propertiesMap
	 * @param rowStartIdxAndCount
	 * @return
	 */
	@Override
	public List<User> findLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return userDao.findLikeMapOfPropertiesWithKasus(idKasus, propertiesMap,
				rowStartIdxAndCount);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#countLikeMapOfPropertiesWithKasus(java.lang.String,
	 *      java.util.Map)
	 * @param idKasus
	 * @param propertiesMap
	 * @return
	 */
	@Override
	public Integer countLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap) {
		return userDao
				.countLikeMapOfPropertiesWithKasus(idKasus, propertiesMap);
	}

	@Override
	public List<User> findLikePropertyWithKasus(String idKasus,
			String propertyName, Object value, int... rowStartIdxAndCount) {
		return userDao.findLikePropertyWithKasus(idKasus, propertyName, value,
				rowStartIdxAndCount);
	}

	@Override
	public Integer countLikePropertyWithKasus(String idKasus,
			String propertyName, Object value) {
		return userDao.countLikePropertyWithKasus(idKasus, propertyName, value);
	}
}
