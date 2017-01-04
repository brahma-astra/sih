package com.brahmastra.sih.persistence.konfigurasi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.CoreDomain;

/**
 * The persistent class for the konfigurasi_tbl database table.
 * 
 */
@Entity
@Table(name = "konfigurasi_tbl")
public class Konfigurasi extends CoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String alamatInstitusi;
	private String kota;
	private String namaDatabase;
	private String namaInstitusi;
	private String namaKepala;
	private String pangkatNRPKepala;
	private String passwordDatabase;
	private String serverDatabase;
	private String userIdDatabase;

	public Konfigurasi() {
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

	@Column(name = "Alamat_Institusi", length = 255)
	public String getAlamatInstitusi() {
		return this.alamatInstitusi;
	}

	public void setAlamatInstitusi(String alamatInstitusi) {
		this.alamatInstitusi = alamatInstitusi;
	}
	
	@Column(name = "Kota", nullable = false, length = 100)
	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}
	
	@Column(name = "Nama_Database", nullable = false, length = 255)
	public String getNamaDatabase() {
		return this.namaDatabase;
	}

	public void setNamaDatabase(String namaDatabase) {
		this.namaDatabase = namaDatabase;
	}

	@Column(name = "Nama_Institusi", length = 255)
	public String getNamaInstitusi() {
		return this.namaInstitusi;
	}

	public void setNamaInstitusi(String namaInstitusi) {
		this.namaInstitusi = namaInstitusi;
	}

	@Column(name = "Nama_Kepala", length = 255)
	public String getNamaKepala() {
		return this.namaKepala;
	}

	public void setNamaKepala(String namaKepala) {
		this.namaKepala = namaKepala;
	}

	@Column(name = "Pangkat_NRP_Kepala", length = 255)
	public String getPangkatNRPKepala() {
		return this.pangkatNRPKepala;
	}

	public void setPangkatNRPKepala(String pangkatNRPKepala) {
		this.pangkatNRPKepala = pangkatNRPKepala;
	}

	@Column(name = "Password_Database", nullable = false, length = 255)
	public String getPasswordDatabase() {
		return this.passwordDatabase;
	}

	public void setPasswordDatabase(String passwordDatabase) {
		this.passwordDatabase = passwordDatabase;
	}

	@Column(name = "Server_Database", nullable = false, length = 255)
	public String getServerDatabase() {
		return this.serverDatabase;
	}

	public void setServerDatabase(String serverDatabase) {
		this.serverDatabase = serverDatabase;
	}

	@Column(name = "User_Id_Database", nullable = false, length = 255)
	public String getUserIdDatabase() {
		return this.userIdDatabase;
	}

	public void setUserIdDatabase(String userIdDatabase) {
		this.userIdDatabase = userIdDatabase;
	}

}