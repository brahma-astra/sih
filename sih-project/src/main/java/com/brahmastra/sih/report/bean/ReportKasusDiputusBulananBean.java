package com.brahmastra.sih.report.bean;

import java.util.Date;

public class ReportKasusDiputusBulananBean {
	private String noPerkara;
	private Date tanggalPutus;
	private String klasifikasiTindakPidana;
	private String majelisHakim;
	private String panitera;
	
	public String getNoPerkara() {
		return noPerkara;
	}
	public void setNoPerkara(String noPerkara) {
		this.noPerkara = noPerkara;
	}
	public Date getTanggalPutus() {
		return tanggalPutus;
	}
	public void setTanggalPutus(Date tanggalPutus) {
		this.tanggalPutus = tanggalPutus;
	}
	public String getKlasifikasiTindakPidana() {
		return klasifikasiTindakPidana;
	}
	public void setKlasifikasiTindakPidana(String klasifikasiTindakPidana) {
		this.klasifikasiTindakPidana = klasifikasiTindakPidana;
	}
	public String getMajelisHakim() {
		return majelisHakim;
	}
	public void setMajelisHakim(String majelisHakim) {
		this.majelisHakim = majelisHakim;
	}
	public String getPanitera() {
		return panitera;
	}
	public void setPanitera(String panitera) {
		this.panitera = panitera;
	}
}
