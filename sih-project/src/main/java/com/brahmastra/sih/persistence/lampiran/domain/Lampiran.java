package com.brahmastra.sih.persistence.lampiran.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.HistoricalCoreDomain;
import com.brahmastra.sih.persistence.kasus.domain.Kasus;

/**
 * The persistent class for the lampiran_tbl database table.
 * 
 */
@Entity
@Table(name = "lampiran_tbl")
public class Lampiran extends HistoricalCoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String namaFile;
	private FileLampiran fileLampiran;
	private Kasus kasus;

	public Lampiran() {
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

	@Column(name = "Nama_File", nullable = false, length = 255)
	public String getNamaFile() {
		return this.namaFile;
	}

	public void setNamaFile(String namaFile) {
		this.namaFile = namaFile;
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

	// uni-directional one-to-one association to FileLampiranTbl
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Id_File_Lampiran", nullable = false)
	public FileLampiran getFileLampiran() {
		return fileLampiran;
	}

	/**
	 * @author viper
	 * @param fileLampiran
	 *            the fileLampiran to set
	 */
	public void setFileLampiran(FileLampiran fileLampiran) {
		this.fileLampiran = fileLampiran;
	}

}