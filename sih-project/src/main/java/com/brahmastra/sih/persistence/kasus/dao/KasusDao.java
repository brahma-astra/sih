package com.brahmastra.sih.persistence.kasus.dao;

import java.util.Date;
import java.util.List;

import com.brahmastra.sih.core.dao.CoreDao;
import com.brahmastra.sih.persistence.kasus.domain.Kasus;

public interface KasusDao extends CoreDao<Kasus> {
	
	public List<Kasus> findKasusBetweenDate(String columnName, Date startDate, Date endDate, int... rowStartIdxAndCount);

}
