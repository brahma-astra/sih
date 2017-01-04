package com.brahmastra.sih.persistence.jenisTindakPidana.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.CoreDomain;

/**
 * The persistent class for the jenis_tindak_pidana_tbl database table.
 * 
 */
@Entity
@Table(name = "jenis_tindak_pidana_tbl")
public class JenisTindakPidana extends CoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String description;
	private String jenisTindakPidana;

	// private Set<TindakPidana> tindakPidanas;

	public JenisTindakPidana() {
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

	@Column(name = "Description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Jenis_Tindak_Pidana", nullable = false, length = 50)
	public String getJenisTindakPidana() {
		return this.jenisTindakPidana;
	}

	public void setJenisTindakPidana(String jenisTindakPidana) {
		this.jenisTindakPidana = jenisTindakPidana;
	}

	// bi-directional many-to-one association to TindakPidanaTbl
	// @OneToMany(mappedBy = "jenisTindakPidana")
	// public Set<TindakPidana> getTindakPidanas() {
	// return this.tindakPidanas;
	// }
	//
	// public void setTindakPidanas(Set<TindakPidana> tindakPidanas) {
	// this.tindakPidanas = tindakPidanas;
	// }

}