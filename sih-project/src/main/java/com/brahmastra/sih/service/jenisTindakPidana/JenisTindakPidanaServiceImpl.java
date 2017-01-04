/**
 * @author viper
 * @date May 21, 2011
 */
package com.brahmastra.sih.service.jenisTindakPidana;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brahmastra.sih.common.vo.PaginatedResult;
import com.brahmastra.sih.persistence.jenisTindakPidana.dao.JenisTindakPidanaDao;
import com.brahmastra.sih.persistence.jenisTindakPidana.domain.JenisTindakPidana;

/**
 * @author viper
 * 
 */
@Service("JenisTindakPidanaService")
public class JenisTindakPidanaServiceImpl implements JenisTindakPidanaService {
	@Autowired
	private JenisTindakPidanaDao jenisTindakPidanaDao;

	/**
	 * @author viper
	 * @return the jenisTindakPidanaDao
	 */
	public JenisTindakPidanaDao getJenisTindakPidanaDao() {
		return jenisTindakPidanaDao;
	}

	/**
	 * @author viper
	 * @param jenisTindakPidanaDao
	 *            the jenisTindakPidanaDao to set
	 */
	public void setJenisTindakPidanaDao(
			JenisTindakPidanaDao jenisTindakPidanaDao) {
		this.jenisTindakPidanaDao = jenisTindakPidanaDao;
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#insert(com.cakra.sih.core.domain.CoreDomain)
	 * @param transientInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public JenisTindakPidana insert(JenisTindakPidana transientInstance) {
		return jenisTindakPidanaDao.insert(transientInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#update(com.cakra.sih.core.domain.CoreDomain)
	 * @param detachedInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public JenisTindakPidana update(JenisTindakPidana detachedInstance) {
		return jenisTindakPidanaDao.update(detachedInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#remove(com.cakra.sih.core.domain.CoreDomain)
	 * @param persistentInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean remove(JenisTindakPidana persistentInstance) {
		return jenisTindakPidanaDao.remove(persistentInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#removeList(java.util.List)
	 * @param list
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean removeList(List<JenisTindakPidana> list) {
		return jenisTindakPidanaDao.removeList(list);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findById(java.lang.String)
	 * @param id
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public JenisTindakPidana findById(String id) {
		return jenisTindakPidanaDao.findById(id);
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
	public List<JenisTindakPidana> findByExample(JenisTindakPidana instance,
			int... rowStartIdxAndCount) {
		return jenisTindakPidanaDao
				.findByExample(instance, rowStartIdxAndCount);
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
	public List<JenisTindakPidana> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount) {
		return jenisTindakPidanaDao.findByProperty(propertyName, value,
				rowStartIdxAndCount);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findAll(int[])
	 * @param rowStartIdxAndCount
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<JenisTindakPidana> findAll(int... rowStartIdxAndCount) {
		return jenisTindakPidanaDao.findAll(rowStartIdxAndCount);
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
	public List<JenisTindakPidana> findLikeProperty(String propertyName,
			Object value, int... rowStartIdxAndCount) {
		return jenisTindakPidanaDao.findLikeProperty(propertyName, value,
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
	public List<JenisTindakPidana> findLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return jenisTindakPidanaDao.findLikeMapOfProperties(propertiesMap,
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
	public List<JenisTindakPidana> findByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return jenisTindakPidanaDao.findByMapOfProperties(propertiesMap,
				rowStartIdxAndCount);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#countAll()
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Integer countAll() {
		return jenisTindakPidanaDao.countAll();
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
		return jenisTindakPidanaDao.countLikeProperty(propertyName, value);
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
		return jenisTindakPidanaDao.countByProperty(propertyName, value);
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
		return jenisTindakPidanaDao.countLikeMapOfProperties(propertiesMap);
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
		return jenisTindakPidanaDao.countByMapOfProperties(propertiesMap);
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
	public PaginatedResult<JenisTindakPidana> paginateLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return jenisTindakPidanaDao.paginateLikeMapOfProperties(propertiesMap,
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
	public PaginatedResult<JenisTindakPidana> paginateAll(
			int... rowStartIdxAndCount) {
		return jenisTindakPidanaDao.paginateAll(rowStartIdxAndCount);
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
	public PaginatedResult<JenisTindakPidana> paginateByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return jenisTindakPidanaDao.paginateByMapOfProperties(propertiesMap,
				rowStartIdxAndCount);
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
	public List<JenisTindakPidana> findLikeMapOfPropertiesWithKasus(
			String idKasus, Map<String, Object> propertiesMap,
			int... rowStartIdxAndCount) {
		return jenisTindakPidanaDao.findLikeMapOfPropertiesWithKasus(idKasus,
				propertiesMap, rowStartIdxAndCount);
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
		return jenisTindakPidanaDao.countLikeMapOfPropertiesWithKasus(idKasus,
				propertiesMap);
	}

	@Override
	public List<JenisTindakPidana> findLikePropertyWithKasus(String idKasus,
			String propertyName, Object value, int... rowStartIdxAndCount) {
		return jenisTindakPidanaDao.findLikePropertyWithKasus(idKasus,
				propertyName, value, rowStartIdxAndCount);
	}

	@Override
	public Integer countLikePropertyWithKasus(String idKasus,
			String propertyName, Object value) {
		return jenisTindakPidanaDao.countLikePropertyWithKasus(idKasus,
				propertyName, value);
	}
}
