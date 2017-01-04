package com.brahmastra.sih.persistence.pangkat.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.CoreDomain;

/**
 * The persistent class for the pangkat_tbl database table.
 * 
 */
@Entity
@Table(name = "pangkat_tbl")
public class Pangkat extends CoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String pangkat;
	private int urutan;

	public Pangkat() {
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

	@Column(name = "Pangkat", nullable = false, length = 40)
	public String getPangkat() {
		return this.pangkat;
	}

	public void setPangkat(String pangkat) {
		this.pangkat = pangkat;
	}

	@Column(name = "Urutan", nullable = false)
	public int getUrutan() {
		return this.urutan;
	}

	public void setUrutan(int urutan) {
		this.urutan = urutan;
	}

}