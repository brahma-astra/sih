package com.brahmastra.sih.core.dao;

/**
 * 
 */

import java.util.List;
import java.util.Map;

import com.brahmastra.sih.common.vo.PaginatedResult;
import com.brahmastra.sih.core.domain.CoreDomain;

public interface CoreDao<T extends CoreDomain> {

	T insert(T transientInstance);

	T update(T detachedInstance);

	Boolean remove(T persistentInstance);

	Boolean removeList(List<T> list);

	T findById(java.lang.String id);

	List<T> findByExample(T instance, final int... rowStartIdxAndCount);

	List<T> findByProperty(String propertyName, Object value,
			final int... rowStartIdxAndCount);

	List<T> findAll(final int... rowStartIdxAndCount);

	List<T> findLikeProperty(String propertyName, Object value,
			final int... rowStartIdxAndCount);

	List<T> findLikeMapOfProperties(Map<String, Object> propertiesMap,
			final int... rowStartIdxAndCount);

	List<T> findByMapOfProperties(Map<String, Object> propertiesMap,
			final int... rowStartIdxAndCount);

	Integer countAll();

	Integer countLikeProperty(String propertyName, Object value);

	Integer countByProperty(String propertyName, Object value);

	Integer countLikeMapOfProperties(Map<String, Object> propertiesMap);

	Integer countByMapOfProperties(Map<String, Object> propertiesMap);

	PaginatedResult<T> paginateLikeMapOfProperties(
			Map<String, Object> propertiesMap, final int... rowStartIdxAndCount);

	PaginatedResult<T> paginateAll(final int... rowStartIdxAndCount);

	PaginatedResult<T> paginateByMapOfProperties(
			Map<String, Object> propertiesMap, final int... rowStartIdxAndCount);

	List<T> findLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap, final int... rowStartIdxAndCount);

	Integer countLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap);

	List<T> findLikePropertyWithKasus(String idKasus, String propertyName,
			Object value, final int... rowStartIdxAndCount);

	Integer countLikePropertyWithKasus(String idKasus, String propertyName,
			Object value);
}
