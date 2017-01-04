package com.brahmastra.sih.core.dao;

import java.util.List;
import java.util.Map;

import com.brahmastra.sih.core.domain.CoreDomain;

public interface WithKasusDao<T extends CoreDomain> {
	List<T> findLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap, final int... rowStartIdxAndCount);

	Integer countLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap);

	List<T> findLikePropertyWithKasus(String idKasus, String propertyName,
			Object value, final int... rowStartIdxAndCount);

	Integer countLikePropertyWithKasus(String idKasus, String propertyName,
			Object value);
}
