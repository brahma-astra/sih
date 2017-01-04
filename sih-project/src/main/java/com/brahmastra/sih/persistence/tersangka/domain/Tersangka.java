package com.brahmastra.sih.persistence.tersangka.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.CoreDomain;
import com.brahmastra.sih.persistence.kasus.domain.Kasus;
import com.brahmastra.sih.persistence.tindakPidana.domain.TindakPidana;

/**
 * The persistent class for the tersangka_tbl database table.
 * 
 */
@Entity
@Table(name = "tersangka_tbl")
public class Tersangka extends CoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String agama;
	private String alamat;
	private String angkatan;
	private int bulan;
	private int hari;
	private String jabatan;
	private String jenisKelamin;
	private String kesatuan;
	private String kewarganegaraan;
	private String namaLengkap;
	private String nrp;
	private String pangkat;
	private String SKPembebasan;
	private String SKPenahanan;
	private String statusTahanan;
	private int tahun;
	private Date tanggalLahir;
	private Date tanggalPembebasan;
	private Date tanggalPenahanan;
	private String tempatLahir;
	private Kasus kasus;
	private Set<TindakPidana> tindakPidanas;

	public Tersangka() {
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

	@Column(name = "Agama", nullable = false, length = 30)
	public String getAgama() {
		return this.agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}

	@Column(name = "Alamat", nullable = false, length = 255)
	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	@Column(name = "Angkatan", nullable = false, length = 50)
	public String getAngkatan() {
		return this.angkatan;
	}

	public void setAngkatan(String angkatan) {
		this.angkatan = angkatan;
	}

	@Column(name = "Bulan")
	public int getBulan() {
		return this.bulan;
	}

	public void setBulan(int bulan) {
		this.bulan = bulan;
	}

	@Column(name = "Hari")
	public int getHari() {
		return this.hari;
	}

	public void setHari(int hari) {
		this.hari = hari;
	}

	@Column(name = "Jabatan", nullable = false, length = 100)
	public String getJabatan() {
		return this.jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	@Column(name = "Jenis_Kelamin", nullable = false, length = 1)
	public String getJenisKelamin() {
		return this.jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	@Column(name = "Kesatuan", nullable = false, length = 100)
	public String getKesatuan() {
		return this.kesatuan;
	}

	public void setKesatuan(String kesatuan) {
		this.kesatuan = kesatuan;
	}

	@Column(name = "Kewarganegaraan", nullable = false, length = 30)
	public String getKewarganegaraan() {
		return this.kewarganegaraan;
	}

	public void setKewarganegaraan(String kewarganegaraan) {
		this.kewarganegaraan = kewarganegaraan;
	}

	@Column(name = "Nama_Lengkap", nullable = false, length = 100)
	public String getNamaLengkap() {
		return this.namaLengkap;
	}

	public void setNamaLengkap(String namaLengkap) {
		this.namaLengkap = namaLengkap;
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

	@Column(name = "SK_Pembebasan", length = 255)
	public String getSKPembebasan() {
		return this.SKPembebasan;
	}

	public void setSKPembebasan(String SKPembebasan) {
		this.SKPembebasan = SKPembebasan;
	}

	@Column(name = "SK_Penahanan", length = 255)
	public String getSKPenahanan() {
		return this.SKPenahanan;
	}

	public void setSKPenahanan(String SKPenahanan) {
		this.SKPenahanan = SKPenahanan;
	}

	@Column(name = "Status_Tahanan", nullable = false, length = 45)
	public String getStatusTahanan() {
		return this.statusTahanan;
	}

	public void setStatusTahanan(String statusTahanan) {
		this.statusTahanan = statusTahanan;
	}

	@Column(name = "Tahun")
	public int getTahun() {
		return this.tahun;
	}

	public void setTahun(int tahun) {
		this.tahun = tahun;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_Lahir", nullable = false)
	public Date getTanggalLahir() {
		return this.tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_Pembebasan")
	public Date getTanggalPembebasan() {
		return this.tanggalPembebasan;
	}

	public void setTanggalPembebasan(Date tanggalPembebasan) {
		this.tanggalPembebasan = tanggalPembebasan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_Penahanan")
	public Date getTanggalPenahanan() {
		return this.tanggalPenahanan;
	}

	public void setTanggalPenahanan(Date tanggalPenahanan) {
		this.tanggalPenahanan = tanggalPenahanan;
	}

	@Column(name = "Tempat_Lahir", nullable = false, length = 30)
	public String getTempatLahir() {
		return this.tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
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

	// bi-directional many-to-one association to TindakPidanaTbl
	@OneToMany(mappedBy = "tersangka")
	public Set<TindakPidana> getTindakPidanas() {
		return this.tindakPidanas;
	}

	public void setTindakPidanas(Set<TindakPidana> tindakPidanas) {
		this.tindakPidanas = tindakPidanas;
	}

}