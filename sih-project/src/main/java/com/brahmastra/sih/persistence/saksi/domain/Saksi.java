package com.brahmastra.sih.persistence.saksi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.CoreDomain;
import com.brahmastra.sih.persistence.kasus.domain.Kasus;

/**
 * The persistent class for the saksi_tbl database table.
 * 
 */
@Entity
@Table(name = "saksi_tbl")
public class Saksi extends CoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String agama;
	private String alamat;
	private String angkatan;
	private String jabatan;
	private String jenisKelamin;
	private String kesatuan;
	private String kewarganegaraan;
	private String namaLengkap;
	private String nrp;
	private String pangkat;
	private String pekerjaan;
	private String statusPersonil;
	private Date tanggalLahir;
	private String tempatLahir;
	private Kasus kasus;

	public Saksi() {
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

	@Column(name = "Pekerjaan", length = 100)
	public String getPekerjaan() {
		return this.pekerjaan;
	}

	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}

	@Column(name = "Status_Personil", nullable = false)
	public String getStatusPersonil() {
		return this.statusPersonil;
	}

	public void setStatusPersonil(String statusPersonil) {
		this.statusPersonil = statusPersonil;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_Lahir", nullable = false)
	public Date getTanggalLahir() {
		return this.tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
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

}