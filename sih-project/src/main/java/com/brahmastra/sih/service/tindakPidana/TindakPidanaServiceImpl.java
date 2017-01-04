/**
 * @author viper
 * @date May 21, 2011
 */
package com.brahmastra.sih.service.tindakPidana;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brahmastra.sih.common.vo.PaginatedResult;
import com.brahmastra.sih.persistence.tindakPidana.dao.TindakPidanaDao;
import com.brahmastra.sih.persistence.tindakPidana.domain.TindakPidana;

/**
 * @author viper
 * 
 */
@Service("TindakPidanaService")
public class TindakPidanaServiceImpl implements TindakPidanaService {
	@Autowired
	private TindakPidanaDao tindakPidanaDao;

	/**
	 * @author viper
	 * @return the tindakPidanaDao
	 */
	public TindakPidanaDao getTindakPidanaDao() {
		return tindakPidanaDao;
	}

	/**
	 * @author viper
	 * @param tindakPidanaDao
	 *            the tindakPidanaDao to set
	 */
	public void setTindakPidanaDao(TindakPidanaDao tindakPidanaDao) {
		this.tindakPidanaDao = tindakPidanaDao;
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#insert(com.cakra.sih.core.domain.CoreDomain)
	 * @param transientInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public TindakPidana insert(TindakPidana transientInstance) {
		return tindakPidanaDao.insert(transientInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#update(com.cakra.sih.core.domain.CoreDomain)
	 * @param detachedInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public TindakPidana update(TindakPidana detachedInstance) {
		return tindakPidanaDao.update(detachedInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#remove(com.cakra.sih.core.domain.CoreDomain)
	 * @param persistentInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean remove(TindakPidana persistentInstance) {
		return tindakPidanaDao.remove(persistentInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#removeList(java.util.List)
	 * @param list
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean removeList(List<TindakPidana> list) {
		return tindakPidanaDao.removeList(list);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findById(java.lang.String)
	 * @param id
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public TindakPidana findById(String id) {
		return tindakPidanaDao.findById(id);
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
	public List<TindakPidana> findByExample(TindakPidana instance,
			int... rowStartIdxAndCount) {
		return tindakPidanaDao.findByExample(instance, rowStartIdxAndCount);
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
	public List<TindakPidana> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		return tindakPidanaDao.findByProperty(propertyName, value,
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
	public List<TindakPidana> findAll(int... rowStartIdxAndCount) {
		return tindakPidanaDao.findAll(rowStartIdxAndCount);
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
	public List<TindakPidana> findLikeProperty(String propertyName,
			Object value, int... rowStartIdxAndCount) {
		return tindakPidanaDao.findLikeProperty(propertyName, value,
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
	public List<TindakPidana> findLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return tindakPidanaDao.findLikeMapOfProperties(propertiesMap,
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
	public List<TindakPidana> findByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return tindakPidanaDao.findByMapOfProperties(propertiesMap,
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
		return tindakPidanaDao.countAll();
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
		return tindakPidanaDao.countLikeProperty(propertyName, value);
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
		return tindakPidanaDao.countByProperty(propertyName, value);
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
		return tindakPidanaDao.countLikeMapOfProperties(propertiesMap);
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
		return tindakPidanaDao.countByMapOfProperties(propertiesMap);
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
	public PaginatedResult<TindakPidana> paginateLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return tindakPidanaDao.paginateLikeMapOfProperties(propertiesMap,
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
	public PaginatedResult<TindakPidana> paginateAll(int... rowStartIdxAndCount) {
		return tindakPidanaDao.paginateAll(rowStartIdxAndCount);
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
	public PaginatedResult<TindakPidana> paginateByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return tindakPidanaDao.paginateByMapOfProperties(propertiesMap,
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
	public List<TindakPidana> findLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return tindakPidanaDao.findLikeMapOfPropertiesWithKasus(idKasus,
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
		return tindakPidanaDao.countLikeMapOfPropertiesWithKasus(idKasus,
				propertiesMap);
	}

	@Override
	public List<TindakPidana> findLikePropertyWithKasus(String idKasus,
			String propertyName, Object value, int... rowStartIdxAndCount) {
		return tindakPidanaDao.findLikePropertyWithKasus(idKasus, propertyName,
				value, rowStartIdxAndCount);
	}

	@Override
	public Integer countLikePropertyWithKasus(String idKasus,
			String propertyName, Object value) {
		return tindakPidanaDao.countLikePropertyWithKasus(idKasus,
				propertyName, value);
	}
}
