package com.brahmastra.sih.persistence.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.HistoricalCoreDomain;

/**
 * The persistent class for the user_tbl database table.
 * 
 */
@Entity
@Table(name = "user_tbl")
public class User extends HistoricalCoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String jabatan;
	private String namaLengkap;
	private String nrp;
	private String pangkat;
	private String password;
	private String username;
	private String aktif;
	private String email;
	private String lisensi;
	private String profil;

	public User() {
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

	@Column(name = "Jabatan", nullable = false, length = 100)
	public String getJabatan() {
		return this.jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
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

	@Column(name = "Password", nullable = false, length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Username", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Aktif", nullable = false, length = 10)
	public String getAktif() {
		return this.aktif;
	}

	public void setAktif(String aktif) {
		this.aktif = aktif;
	}

	@Column(name = "Email", nullable = true, length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Lisensi", nullable = true, length = 32)
	public String getLisensi() {
		return this.lisensi;
	}

	public void setLisensi(String lisensi) {
		this.lisensi = lisensi;
	}

	@Column(name = "Profil", nullable = false, length = 10)
	public String getProfil() {
		return this.profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}
}