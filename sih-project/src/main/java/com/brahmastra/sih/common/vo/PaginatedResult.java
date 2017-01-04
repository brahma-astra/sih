package com.brahmastra.sih.common.vo;

import java.io.Serializable;
import java.util.List;

import com.brahmastra.sih.core.domain.CoreDomain;

public final class PaginatedResult<T extends CoreDomain> implements
		Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5184271530368841140L;
	private Integer rowCount = 0;
	private List<T> resultList;

	/**
	 * Constructor.
	 */
	public PaginatedResult() {
		super();
	}

	public PaginatedResult(Integer rowCount, List<T> resultList) {
		super();
		this.rowCount = rowCount;
		this.resultList = resultList;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
}
