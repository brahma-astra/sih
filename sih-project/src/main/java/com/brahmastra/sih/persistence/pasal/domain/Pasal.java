package com.brahmastra.sih.persistence.pasal.domain;

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
import com.brahmastra.sih.persistence.kitabHukum.domain.KitabHukum;

/**
 * The persistent class for the pasal_tbl database table.
 * 
 */
@Entity
@Table(name = "pasal_tbl")
public class Pasal extends CoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String keteranganPasal;
	private String pasal;
	private Kasus kasus;
	private KitabHukum kitabHukum;

	public Pasal() {
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

	@Column(name = "Keterangan_Pasal", nullable = false, length = 255)
	public String getKeteranganPasal() {
		return this.keteranganPasal;
	}

	public void setKeteranganPasal(String keteranganPasal) {
		this.keteranganPasal = keteranganPasal;
	}

	@Column(name = "Pasal", nullable = false, length = 255)
	public String getPasal() {
		return this.pasal;
	}

	public void setPasal(String pasal) {
		this.pasal = pasal;
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

	// bi-directional many-to-one association to KitabHukumTbl
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Kitab_Hukum", referencedColumnName = "Kitab_Hukum", nullable = false)
	public KitabHukum getKitabHukum() {
		return this.kitabHukum;
	}

	public void setKitabHukum(KitabHukum kitabHukum) {
		this.kitabHukum = kitabHukum;
	}

}