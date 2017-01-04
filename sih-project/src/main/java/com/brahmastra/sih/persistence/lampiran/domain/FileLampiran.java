package com.brahmastra.sih.persistence.lampiran.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.HistoricalCoreDomain;

/**
 * The persistent class for the file_lampiran_tbl database table.
 * 
 */
@Entity
@Table(name = "file_lampiran_tbl")
public class FileLampiran extends HistoricalCoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private byte[] data;

	public FileLampiran() {
	}

	/**
	 * @author viper
	 * @return the id
	 */
	@Override
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "Id", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	/**
	 * @author viper
	 * @param id
	 *            the id to set
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @author viper
	 * @return the data
	 */
	@Lob()
	@Column(name = "Data", nullable = false)
	public byte[] getData() {
		return data;
	}

	/**
	 * @author viper
	 * @param data
	 *            the data to set
	 */
	public void setData(byte[] data) {
		this.data = data;
	}

}
