package com.brahmastra.sih.persistence.kitabHukum.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.brahmastra.sih.core.domain.CoreDomain;

/**
 * The persistent class for the kitab_hukum_tbl database table.
 * 
 */
@Entity
@Table(name = "kitab_hukum_tbl")
public class KitabHukum extends CoreDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String kitabHukum;
	private String penjelasan;

	// private Set<Pasal> pasals;

	public KitabHukum() {
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

	/**
	 * @author viper
	 * @return the kitabHukum
	 */
	@Column(name = "Kitab_Hukum", nullable = false, length = 255)
	public String getKitabHukum() {
		return kitabHukum;
	}

	/**
	 * @author viper
	 * @param kitabHukum
	 *            the kitabHukum to set
	 */
	public void setKitabHukum(String kitabHukum) {
		this.kitabHukum = kitabHukum;
	}

	@Column(name = "Penjelasan", nullable = false, length = 255)
	public String getPenjelasan() {
		return this.penjelasan;
	}

	public void setPenjelasan(String penjelasan) {
		this.penjelasan = penjelasan;
	}

	// bi-directional many-to-one association to PasalTbl
	// @OneToMany(mappedBy = "kitabHukum")
	// public Set<Pasal> getPasals() {
	// return this.pasals;
	// }
	//
	// public void setPasals(Set<Pasal> pasals) {
	// this.pasals = pasals;
	// }

}