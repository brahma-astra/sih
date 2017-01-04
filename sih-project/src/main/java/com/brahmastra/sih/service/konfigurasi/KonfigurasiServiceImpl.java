/**
 * @author viper
 * @date May 21, 2011
 */
package com.brahmastra.sih.service.konfigurasi;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brahmastra.sih.common.vo.PaginatedResult;
import com.brahmastra.sih.persistence.konfigurasi.dao.KonfigurasiDao;
import com.brahmastra.sih.persistence.konfigurasi.domain.Konfigurasi;

/**
 * @author viper
 * 
 */
@Service("KonfigurasiService")
public class KonfigurasiServiceImpl implements KonfigurasiService {
	@Autowired
	private KonfigurasiDao konfigurasiDao;

	/**
	 * @author viper
	 * @return the konfigurasiDao
	 */
	public KonfigurasiDao getKonfigurasiDao() {
		return konfigurasiDao;
	}

	/**
	 * @author viper
	 * @param konfigurasiDao
	 *            the konfigurasiDao to set
	 */
	public void setKonfigurasiDao(KonfigurasiDao konfigurasiDao) {
		this.konfigurasiDao = konfigurasiDao;
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#insert(com.cakra.sih.core.domain.CoreDomain)
	 * @param transientInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Konfigurasi insert(Konfigurasi transientInstance) {
		return konfigurasiDao.insert(transientInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#update(com.cakra.sih.core.domain.CoreDomain)
	 * @param detachedInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Konfigurasi update(Konfigurasi detachedInstance) {
		return konfigurasiDao.update(detachedInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#remove(com.cakra.sih.core.domain.CoreDomain)
	 * @param persistentInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean remove(Konfigurasi persistentInstance) {
		return konfigurasiDao.remove(persistentInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#removeList(java.util.List)
	 * @param list
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean removeList(List<Konfigurasi> list) {
		return konfigurasiDao.removeList(list);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findById(java.lang.String)
	 * @param id
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Konfigurasi findById(String id) {
		return konfigurasiDao.findById(id);
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
	public List<Konfigurasi> findByExample(Konfigurasi instance,
			int... rowStartIdxAndCount) {
		return konfigurasiDao.findByExample(instance, rowStartIdxAndCount);
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
	public List<Konfigurasi> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		return konfigurasiDao.findByProperty(propertyName, value,
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
	public List<Konfigurasi> findAll(int... rowStartIdxAndCount) {
		return konfigurasiDao.findAll(rowStartIdxAndCount);
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
	public List<Konfigurasi> findLikeProperty(String propertyName,
			Object value, int... rowStartIdxAndCount) {
		return konfigurasiDao.findLikeProperty(propertyName, value,
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
	public List<Konfigurasi> findLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return konfigurasiDao.findLikeMapOfProperties(propertiesMap,
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
	public List<Konfigurasi> findByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return konfigurasiDao.findByMapOfProperties(propertiesMap,
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
		return konfigurasiDao.countAll();
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
		return konfigurasiDao.countLikeProperty(propertyName, value);
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
		return konfigurasiDao.countByProperty(propertyName, value);
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
		return konfigurasiDao.countLikeMapOfProperties(propertiesMap);
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
		return konfigurasiDao.countByMapOfProperties(propertiesMap);
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
	public PaginatedResult<Konfigurasi> paginateLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return konfigurasiDao.paginateLikeMapOfProperties(propertiesMap,
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
	public PaginatedResult<Konfigurasi> paginateAll(int... rowStartIdxAndCount) {
		return konfigurasiDao.paginateAll(rowStartIdxAndCount);
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
	public PaginatedResult<Konfigurasi> paginateByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return konfigurasiDao.paginateByMapOfProperties(propertiesMap,
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
	public List<Konfigurasi> findLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return konfigurasiDao.findLikeMapOfPropertiesWithKasus(idKasus,
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
		return konfigurasiDao.countLikeMapOfPropertiesWithKasus(idKasus,
				propertiesMap);
	}

	@Override
	public List<Konfigurasi> findLikePropertyWithKasus(String idKasus,
			String propertyName, Object value, int... rowStartIdxAndCount) {
		return konfigurasiDao.findLikePropertyWithKasus(idKasus, propertyName,
				value, rowStartIdxAndCount);
	}

	@Override
	public Integer countLikePropertyWithKasus(String idKasus,
			String propertyName, Object value) {
		return konfigurasiDao.countLikePropertyWithKasus(idKasus, propertyName,
				value);
	}
}
