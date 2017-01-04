package com.brahmastra.sih.persistence.barangBukti.domain;

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
 * The persistent class for the barang_bukti_tbl database table.
 * 
 */
@Entity
@Table(name = "barang_bukti_tbl")
public class BarangBukti extends HistoricalCoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String deskripsi;
	private String namaBarang;
	private Kasus kasus;

	public BarangBukti() {
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "Id", unique = true, nullable = false, length = 32)
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "Deskripsi", length = 400)
	public String getDeskripsi() {
		return this.deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	@Column(name = "Nama_Barang", nullable = false, length = 255)
	public String getNamaBarang() {
		return this.namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
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