package com.brahmastra.sih.service.kasus;

import java.util.Date;
import java.util.List;

import com.brahmastra.sih.core.service.CoreService;
import com.brahmastra.sih.persistence.kasus.domain.Kasus;

public interface KasusService extends CoreService<Kasus> {

	public List<Kasus> findKasusBetweenDate(String columnName, Date startDate, Date endDate, int... rowStartIdxAndCount);

}
