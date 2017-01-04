package com.brahmastra.sih.persistence.kasus.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.HistoricalCoreDomain;

/**
 * The persistent class for the kasus_tbl database table.
 * 
 */
@Entity
@Table(name = "kasus_tbl")
public class Kasus extends HistoricalCoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private BigDecimal denda;
	private BigDecimal biayaPerkara;
	private String kpFlag;
	private String keterangan;
	private String noPutusan;
	private String noSKEPPERA;
	private String nomorRegister;
	private String putusan;
	private String status;
	private Date tanggalAkhirPerbuatan;
	private Date tanggalAwalPerbuatan;
	private Date tanggalPutusan;
	private Date tanggalRegister;
	private Date tanggalSKEPPERA;
	private Date tanggalTerima;
	private String tempatPerbuatan;
	private String tuntutan;

	// private Set<BarangBukti> barangBuktis;
	// private Set<Hakim> hakims;
	// private Set<Lampiran> lampirans;
	// private Set<Panitera> paniteras;
	// private Set<Pasal> pasals;
	// private Set<Saksi> saksis;
	// private Set<Tersangka> tersangkas;
	// private Set<TindakPidana> tindakPidanas;

	public Kasus() {
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

	@Column(name = "Denda", nullable = false, precision = 10)
	public BigDecimal getDenda() {
		return this.denda;
	}

	public void setDenda(BigDecimal denda) {
		this.denda = denda;
	}

	@Column(name = "Kp_Flag", length = 1)
	public String getKpFlag() {
		return this.kpFlag;
	}

	public void setKpFlag(String kpFlag) {
		this.kpFlag = kpFlag;
	}

	@Lob()
	@Column(name = "Keterangan")
	public String getKeterangan() {
		return this.keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	@Column(name = "No_Putusan", nullable = false, length = 200)
	public String getNoPutusan() {
		return this.noPutusan;
	}

	public void setNoPutusan(String noPutusan) {
		this.noPutusan = noPutusan;
	}

	@Column(name = "No_SKEPPERA", nullable = false, length = 200)
	public String getNoSKEPPERA() {
		return this.noSKEPPERA;
	}

	public void setNoSKEPPERA(String noSKEPPERA) {
		this.noSKEPPERA = noSKEPPERA;
	}

	@Column(name = "Nomor_Register", nullable = false, length = 200)
	public String getNomorRegister() {
		return this.nomorRegister;
	}

	public void setNomorRegister(String nomorRegister) {
		this.nomorRegister = nomorRegister;
	}

	@Lob()
	@Column(name = "Putusan", nullable = false)
	public String getPutusan() {
		return this.putusan;
	}

	public void setPutusan(String putusan) {
		this.putusan = putusan;
	}

	@Column(name = "Status", nullable = false, length = 255)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_Akhir_Perbuatan", nullable = false)
	public Date getTanggalAkhirPerbuatan() {
		return this.tanggalAkhirPerbuatan;
	}

	public void setTanggalAkhirPerbuatan(Date tanggalAkhirPerbuatan) {
		this.tanggalAkhirPerbuatan = tanggalAkhirPerbuatan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_Awal_Perbuatan", nullable = false)
	public Date getTanggalAwalPerbuatan() {
		return this.tanggalAwalPerbuatan;
	}

	public void setTanggalAwalPerbuatan(Date tanggalAwalPerbuatan) {
		this.tanggalAwalPerbuatan = tanggalAwalPerbuatan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_Putusan", nullable = false)
	public Date getTanggalPutusan() {
		return this.tanggalPutusan;
	}

	public void setTanggalPutusan(Date tanggalPutusan) {
		this.tanggalPutusan = tanggalPutusan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_Register", nullable = false)
	public Date getTanggalRegister() {
		return this.tanggalRegister;
	}

	public void setTanggalRegister(Date tanggalRegister) {
		this.tanggalRegister = tanggalRegister;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_SKEPPERA", nullable = false)
	public Date getTanggalSKEPPERA() {
		return this.tanggalSKEPPERA;
	}

	public void setTanggalSKEPPERA(Date tanggalSKEPPERA) {
		this.tanggalSKEPPERA = tanggalSKEPPERA;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_Terima", nullable = false)
	public Date getTanggalTerima() {
		return this.tanggalTerima;
	}

	public void setTanggalTerima(Date tanggalTerima) {
		this.tanggalTerima = tanggalTerima;
	}

	@Column(name = "Tempat_Perbuatan", nullable = false, length = 50)
	public String getTempatPerbuatan() {
		return this.tempatPerbuatan;
	}

	public void setTempatPerbuatan(String tempatPerbuatan) {
		this.tempatPerbuatan = tempatPerbuatan;
	}

	@Lob()
	@Column(name = "Tuntutan", nullable = false)
	public String getTuntutan() {
		return this.tuntutan;
	}

	public void setTuntutan(String tuntutan) {
		this.tuntutan = tuntutan;
	}

	/**
	 * @author viper
	 * @return the biayaPerkara
	 */
	@Column(name = "Biaya_Perkara", nullable = false, precision = 10)
	public BigDecimal getBiayaPerkara() {
		return biayaPerkara;
	}

	/**
	 * @author viper
	 * @param biayaPerkara
	 *            the biayaPerkara to set
	 */
	public void setBiayaPerkara(BigDecimal biayaPerkara) {
		this.biayaPerkara = biayaPerkara;
	}

	// bi-directional many-to-one association to BarangBuktiTbl
	// @OneToMany(mappedBy = "kasus")
	// public Set<BarangBukti> getBarangBuktis() {
	// return this.barangBuktis;
	// }
	//
	// public void setBarangBuktis(Set<BarangBukti> barangBuktis) {
	// this.barangBuktis = barangBuktis;
	// }

	// bi-directional many-to-one association to HakimTbl
	// @OneToMany(mappedBy = "kasus")
	// @OneToMany(fetch = FetchType.EAGER)
	// @JoinColumn(name = "Id_Kasus", nullable = false, insertable = false,
	// updatable = false)
	// public Set<Hakim> getHakims() {
	// return this.hakims;
	// }
	//
	// public void setHakims(Set<Hakim> hakims) {
	// this.hakims = hakims;
	// }

	// bi-directional many-to-one association to LampiranTbl
	// @OneToMany(mappedBy = "kasus")
	// public Set<Lampiran> getLampirans() {
	// return this.lampirans;
	// }
	//
	// public void setLampirans(Set<Lampiran> lampirans) {
	// this.lampirans = lampirans;
	// }

	// bi-directional many-to-one association to PaniteraTbl
	// @OneToMany(mappedBy = "kasus")
	// public Set<Panitera> getPaniteras() {
	// return this.paniteras;
	// }
	//
	// public void setPaniteras(Set<Panitera> paniteras) {
	// this.paniteras = paniteras;
	// }

	// bi-directional many-to-one association to PasalTbl
	// @OneToMany(mappedBy = "kasus")
	// public Set<Pasal> getPasals() {
	// return this.pasals;
	// }
	//
	// public void setPasals(Set<Pasal> pasals) {
	// this.pasals = pasals;
	// }

	// bi-directional many-to-one association to SaksiTbl
	// @OneToMany(mappedBy = "kasus")
	// public Set<Saksi> getSaksis() {
	// return this.saksis;
	// }
	//
	// public void setSaksis(Set<Saksi> saksis) {
	// this.saksis = saksis;
	// }

	// bi-directional many-to-one association to TersangkaTbl
	// @OneToMany(mappedBy = "kasus")
	// public Set<Tersangka> getTersangkas() {
	// return this.tersangkas;
	// }
	//
	// public void setTersangkas(Set<Tersangka> tersangkas) {
	// this.tersangkas = tersangkas;
	// }

	// bi-directional many-to-one association to TindakPidanaTbl
	// @OneToMany(mappedBy = "kasus")
	// public Set<TindakPidana> getTindakPidanas() {
	// return this.tindakPidanas;
	// }
	//
	// public void setTindakPidanas(Set<TindakPidana> tindakPidanas) {
	// this.tindakPidanas = tindakPidanas;
	// }

}