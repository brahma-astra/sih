package com.brahmastra.sih.persistence.tindakPidana.domain;

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
import com.brahmastra.sih.persistence.jenisTindakPidana.domain.JenisTindakPidana;
import com.brahmastra.sih.persistence.kasus.domain.Kasus;
import com.brahmastra.sih.persistence.tersangka.domain.Tersangka;

/**
 * The persistent class for the tindak_pidana_tbl database table.
 * 
 */
@Entity
@Table(name = "tindak_pidana_tbl")
public class TindakPidana extends CoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String klasifikasiDelik;
	private String tindakPidana;
	private Kasus kasus;
	private JenisTindakPidana jenisTindakPidana;
	private Tersangka tersangka;

	public TindakPidana() {
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

	@Column(name = "Klasifikasi_Delik", length = 255, nullable = true)
	public String getKlasifikasiDelik() {
		return this.klasifikasiDelik;
	}

	public void setKlasifikasiDelik(String klasifikasiDelik) {
		this.klasifikasiDelik = klasifikasiDelik;
	}

	@Column(name = "Tindak_Pidana", nullable = false, length = 255)
	public String getTindakPidana() {
		return this.tindakPidana;
	}

	public void setTindakPidana(String tindakPidana) {
		this.tindakPidana = tindakPidana;
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

	// bi-directional many-to-one association to JenisTindakPidanaTbl
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_Jenis_Tindak_Pidana", nullable = false)
	public JenisTindakPidana getJenisTindakPidana() {
		return this.jenisTindakPidana;
	}

	public void setJenisTindakPidana(JenisTindakPidana jenisTindakPidana) {
		this.jenisTindakPidana = jenisTindakPidana;
	}

	// bi-directional many-to-one association to TersangkaTbl
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_Tersangka", nullable = false)
	public Tersangka getTersangka() {
		return this.tersangka;
	}

	public void setTersangka(Tersangka tersangka) {
		this.tersangka = tersangka;
	}

}