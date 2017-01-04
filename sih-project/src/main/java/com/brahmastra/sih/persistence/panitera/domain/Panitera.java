package com.brahmastra.sih.persistence.panitera.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.HistoricalCoreDomain;
import com.brahmastra.sih.persistence.kasus.domain.Kasus;

/**
 * The persistent class for the panitera_tbl database table.
 * 
 */
@Entity
@Table(name = "panitera_tbl")
public class Panitera extends HistoricalCoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String nrp;
	private String pangkat;
	private String panitera;
	private Kasus kasus;

	public Panitera() {
	}

	@Override
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "Id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "NRP", nullable = false, length = 30)
	public String getNrp() {
		return this.nrp;
	}

	public void setNrp(String nrp) {
		this.nrp = nrp;
	}

	@Column(name = "Pangkat", nullable = false, length = 30)
	public String getPangkat() {
		return this.pangkat;
	}

	public void setPangkat(String pangkat) {
		this.pangkat = pangkat;
	}

	@Column(name = "Panitera", nullable = false, length = 200)
	public String getPanitera() {
		return this.panitera;
	}

	public void setPanitera(String panitera) {
		this.panitera = panitera;
	}

	// bi-directional many-to-one association to KasusTbl
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_Kasus", nullable = false)
	public Kasus getKasus() {
		return this.kasus;
	}

	public void setKasus(Kasus kasus) {
		this.kasus = kasus;
	}

}