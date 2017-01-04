package com.brahmastra.sih.persistence.hakim.domain;

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

import com.brahmastra.sih.core.domain.CoreDomain;
import com.brahmastra.sih.persistence.kasus.domain.Kasus;

/**
 * The persistent class for the hakim_tbl database table.
 * 
 */
@Entity
@Table(name = "hakim_tbl")
public class Hakim extends CoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String majelisHakim;
	private String nrp;
	private String pangkat;
	private Kasus kasus;

	public Hakim() {
	}

	@Override
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "Id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "Majelis_Hakim", nullable = false, length = 200)
	public String getMajelisHakim() {
		return this.majelisHakim;
	}

	public void setMajelisHakim(String majelisHakim) {
		this.majelisHakim = majelisHakim;
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

	// bi-directional many-to-one association to Kasus
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_Kasus", nullable = false, insertable = true, updatable = true)
	public Kasus getKasus() {
		return this.kasus;
	}

	public void setKasus(Kasus kasus) {
		this.kasus = kasus;
	}

}