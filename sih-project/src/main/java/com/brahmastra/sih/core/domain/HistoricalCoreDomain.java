package com.brahmastra.sih.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class HistoricalCoreDomain extends CoreDomain {

	private static final long serialVersionUID = 1379959565884819529L;

	private Date deleteDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "delete_date")
	public Date getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

}
