/**
 * @author viper
 * @date May 21, 2011
 */
package com.brahmastra.sih.service.tersangka;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brahmastra.sih.common.vo.PaginatedResult;
import com.brahmastra.sih.persistence.tersangka.dao.TersangkaDao;
import com.brahmastra.sih.persistence.tersangka.domain.Tersangka;

/**
 * @author viper
 * 
 */
@Service("TersangkaService")
public class TersangkaServiceImpl implements TersangkaService {
	@Autowired
	private TersangkaDao tersangkaDao;

	/**
	 * @author viper
	 * @return the tersangkaDao
	 */
	public TersangkaDao getTersangkaDao() {
		return tersangkaDao;
	}

	/**
	 * @author viper
	 * @param tersangkaDao
	 *            the tersangkaDao to set
	 */
	public void setTersangkaDao(TersangkaDao tersangkaDao) {
		this.tersangkaDao = tersangkaDao;
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#insert(com.cakra.sih.core.domain.CoreDomain)
	 * @param transientInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Tersangka insert(Tersangka transientInstance) {
		return tersangkaDao.insert(transientInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#update(com.cakra.sih.core.domain.CoreDomain)
	 * @param detachedInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Tersangka update(Tersangka detachedInstance) {
		return tersangkaDao.update(detachedInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#remove(com.cakra.sih.core.domain.CoreDomain)
	 * @param persistentInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean remove(Tersangka persistentInstance) {
		return tersangkaDao.remove(persistentInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#removeList(java.util.List)
	 * @param list
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean removeList(List<Tersangka> list) {
		return tersangkaDao.removeList(list);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findById(java.lang.String)
	 * @param id
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Tersangka findById(String id) {
		return tersangkaDao.findById(id);
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
	public List<Tersangka> findByExample(Tersangka instance,
			int... rowStartIdxAndCount) {
		return tersangkaDao.findByExample(instance, rowStartIdxAndCount);
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
	public List<Tersangka> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		return tersangkaDao.findByProperty(propertyName, value,
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
	public List<Tersangka> findAll(int... rowStartIdxAndCount) {
		return tersangkaDao.findAll(rowStartIdxAndCount);
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
	public List<Tersangka> findLikeProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		return tersangkaDao.findLikeProperty(propertyName, value,
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
	public List<Tersangka> findLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return tersangkaDao.findLikeMapOfProperties(propertiesMap,
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
	public List<Tersangka> findByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return tersangkaDao.findByMapOfProperties(propertiesMap,
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
		return tersangkaDao.countAll();
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
		return tersangkaDao.countLikeProperty(propertyName, value);
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
		return tersangkaDao.countByProperty(propertyName, value);
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
		return tersangkaDao.countLikeMapOfProperties(propertiesMap);
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
		return tersangkaDao.countByMapOfProperties(propertiesMap);
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
	public PaginatedResult<Tersangka> paginateLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return tersangkaDao.paginateLikeMapOfProperties(propertiesMap,
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
	public PaginatedResult<Tersangka> paginateAll(int... rowStartIdxAndCount) {
		return tersangkaDao.paginateAll(rowStartIdxAndCount);
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
	public PaginatedResult<Tersangka> paginateByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return tersangkaDao.paginateByMapOfProperties(propertiesMap,
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
	public List<Tersangka> findLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return tersangkaDao.findLikeMapOfPropertiesWithKasus(idKasus,
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
		return tersangkaDao.countLikeMapOfPropertiesWithKasus(idKasus,
				propertiesMap);
	}

	@Override
	public List<Tersangka> findLikePropertyWithKasus(String idKasus,
			String propertyName, Object value, int... rowStartIdxAndCount) {
		return tersangkaDao.findLikePropertyWithKasus(idKasus, propertyName,
				value, rowStartIdxAndCount);
	}

	@Override
	public Integer countLikePropertyWithKasus(String idKasus,
			String propertyName, Object value) {
		return tersangkaDao.countLikePropertyWithKasus(idKasus, propertyName,
				value);
	}
}
