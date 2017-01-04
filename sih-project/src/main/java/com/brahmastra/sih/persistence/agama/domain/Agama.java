package com.brahmastra.sih.persistence.agama.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.CoreDomain;

/**
 * The persistent class for the agama_tbl database table.
 * 
 */
@Entity
@Table(name = "agama_tbl")
public class Agama extends CoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String agama;

	public Agama() {
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

	@Column(name = "Agama", nullable = false, length = 30)
	public String getAgama() {
		return this.agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}
}