/**
 * @author viper
 * @date May 21, 2011
 */
package com.brahmastra.sih.service.panitera;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brahmastra.sih.common.vo.PaginatedResult;
import com.brahmastra.sih.persistence.panitera.dao.PaniteraDao;
import com.brahmastra.sih.persistence.panitera.domain.Panitera;

/**
 * @author viper
 * 
 */
@Service("PaniteraService")
public class PaniteraServiceImpl implements PaniteraService {
	@Autowired
	private PaniteraDao paniteraDao;

	/**
	 * @author viper
	 * @return the paniteraDao
	 */
	public PaniteraDao getPaniteraDao() {
		return paniteraDao;
	}

	/**
	 * @author viper
	 * @param paniteraDao
	 *            the paniteraDao to set
	 */
	public void setPaniteraDao(PaniteraDao paniteraDao) {
		this.paniteraDao = paniteraDao;
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#insert(com.cakra.sih.core.domain.CoreDomain)
	 * @param transientInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Panitera insert(Panitera transientInstance) {
		return paniteraDao.insert(transientInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#update(com.cakra.sih.core.domain.CoreDomain)
	 * @param detachedInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Panitera update(Panitera detachedInstance) {
		return paniteraDao.update(detachedInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#remove(com.cakra.sih.core.domain.CoreDomain)
	 * @param persistentInstance
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean remove(Panitera persistentInstance) {
		return paniteraDao.remove(persistentInstance);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#removeList(java.util.List)
	 * @param list
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean removeList(List<Panitera> list) {
		return paniteraDao.removeList(list);
	}

	/**
	 * @author viper
	 * @see com.cakra.sih.core.service.CoreService#findById(java.lang.String)
	 * @param id
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Panitera findById(String id) {
		return paniteraDao.findById(id);
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
	public List<Panitera> findByExample(Panitera instance,
			int... rowStartIdxAndCount) {
		return paniteraDao.findByExample(instance, rowStartIdxAndCount);
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
	public List<Panitera> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		return paniteraDao.findByProperty(propertyName, value,
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
	public List<Panitera> findAll(int... rowStartIdxAndCount) {
		return paniteraDao.findAll(rowStartIdxAndCount);
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
	public List<Panitera> findLikeProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		return paniteraDao.findLikeProperty(propertyName, value,
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
	public List<Panitera> findLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return paniteraDao.findLikeMapOfProperties(propertiesMap,
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
	public List<Panitera> findByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return paniteraDao.findByMapOfProperties(propertiesMap,
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
		return paniteraDao.countAll();
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
		return paniteraDao.countLikeProperty(propertyName, value);
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
		return paniteraDao.countByProperty(propertyName, value);
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
		return paniteraDao.countLikeMapOfProperties(propertiesMap);
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
		return paniteraDao.countByMapOfProperties(propertiesMap);
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
	public PaginatedResult<Panitera> paginateLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return paniteraDao.paginateLikeMapOfProperties(propertiesMap,
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
	public PaginatedResult<Panitera> paginateAll(int... rowStartIdxAndCount) {
		return paniteraDao.paginateAll(rowStartIdxAndCount);
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
	public PaginatedResult<Panitera> paginateByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return paniteraDao.paginateByMapOfProperties(propertiesMap,
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
	public List<Panitera> findLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		return paniteraDao.findLikeMapOfPropertiesWithKasus(idKasus,
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
		return paniteraDao.countLikeMapOfPropertiesWithKasus(idKasus,
				propertiesMap);
	}

	@Override
	public List<Panitera> findLikePropertyWithKasus(String idKasus,
			String propertyName, Object value, int... rowStartIdxAndCount) {
		return paniteraDao.findLikePropertyWithKasus(idKasus, propertyName,
				value, rowStartIdxAndCount);
	}

	@Override
	public Integer countLikePropertyWithKasus(String idKasus,
			String propertyName, Object value) {
		return paniteraDao.countLikePropertyWithKasus(idKasus, propertyName,
				value);
	}
}
