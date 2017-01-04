package com.brahmastra.sih.report.util;

import java.util.ArrayList;
import java.util.List;

import com.brahmastra.sih.persistence.hakim.domain.Hakim;
import com.brahmastra.sih.persistence.kasus.domain.Kasus;
import com.brahmastra.sih.persistence.panitera.domain.Panitera;
import com.brahmastra.sih.persistence.tersangka.domain.Tersangka;
import com.brahmastra.sih.persistence.tindakPidana.domain.TindakPidana;
import com.brahmastra.sih.service.hakim.HakimService;
import com.brahmastra.sih.service.panitera.PaniteraService;
import com.brahmastra.sih.service.tersangka.TersangkaService;
import com.brahmastra.sih.service.tindakPidana.TindakPidanaService;

public final class ReportKasusUtil {

	public static List<List<String>> getListPanitera(List<Kasus> listKasus, PaniteraService paniteraService) {
		List<String> listPerColumnPanitera = null;
		List<List<String>> listResultPanitera = null;
		
		List<Panitera> listPanitera = paniteraService.findAll();
		listResultPanitera = new ArrayList<List<String>>();
		
		for (int idxKasus = 0; idxKasus < listKasus.size(); idxKasus++) {
			Kasus kasus = listKasus.get(idxKasus);

			listPerColumnPanitera =  new ArrayList<String>();
			for (int idxPanitera = 0; idxPanitera < listPanitera.size(); idxPanitera++) {
				Panitera panitera = listPanitera.get(idxPanitera);
				
				if (kasus.getId().equals(panitera.getKasus().getId())) {
					listPerColumnPanitera.add(panitera.getPanitera());
				}
			}
			
			listResultPanitera.add(listPerColumnPanitera);
		}
		
		System.out.println("Panitera:" + listResultPanitera.size());
		
		return listResultPanitera;
	}

	public static List<List<String>> getListHakim(List<Kasus> listKasus, HakimService hakimService) {
		List<String> listPerColumnHakim = null;
		List<List<String>> listResultHakim = null;
		
		List<Hakim> listHakim = hakimService.findAll();
		listResultHakim = new ArrayList<List<String>>();
		
		for (int idxKasus = 0; idxKasus < listKasus.size(); idxKasus++) {
			Kasus kasus = listKasus.get(idxKasus);

			listPerColumnHakim =  new ArrayList<String>();
			for (int idxHakim = 0; idxHakim < listHakim.size(); idxHakim++) {
				Hakim hakim = listHakim.get(idxHakim);
				
				if (kasus.getId().equals(hakim.getKasus().getId())) {
					listPerColumnHakim.add(hakim.getMajelisHakim());
				}
			}
			
			listResultHakim.add(listPerColumnHakim);
		}
		
		System.out.println("Hakim:" + listResultHakim.size());
		
		return listResultHakim;
	}
	
	public static List<List<String>> getListTindakPidana(List<Kasus> listKasus, TindakPidanaService tindakPidanaService) {
		List<String> listPerColumnTindakPidana = null;
		List<List<String>> listResultTindakPidana = null;
		
		List<TindakPidana> listTindakPidana = tindakPidanaService.findAll();
		listResultTindakPidana = new ArrayList<List<String>>();
		
		for (int idxKasus = 0; idxKasus < listKasus.size(); idxKasus++) {
			Kasus kasus = listKasus.get(idxKasus);

			listPerColumnTindakPidana =  new ArrayList<String>();
			for (int idxTindakPidana = 0; idxTindakPidana < listTindakPidana.size(); idxTindakPidana++) {
				TindakPidana tindakPidana = listTindakPidana.get(idxTindakPidana);
				
				if (kasus.getId().equals(tindakPidana.getKasus().getId())) {
					listPerColumnTindakPidana.add(tindakPidana.getTindakPidana());
				}
			}
			
			listResultTindakPidana.add(listPerColumnTindakPidana);
		}
		
		System.out.println("TindakPidana:" + listResultTindakPidana.size());
		
		return listResultTindakPidana;
	}	

	public static List<List<String>> getListTersangka(List<Kasus> listKasus, TersangkaService tersangkaService) {
		List<String> listPerColumnTersangka = null;
		List<List<String>> listResultTersangka = null;
		
		List<Tersangka> listTersangka = tersangkaService.findAll();
		listResultTersangka = new ArrayList<List<String>>();
		
		for (int idxKasus = 0; idxKasus < listKasus.size(); idxKasus++) {
			Kasus kasus = listKasus.get(idxKasus);

			listPerColumnTersangka =  new ArrayList<String>();
			for (int idxTersangka = 0; idxTersangka < listTersangka.size(); idxTersangka++) {
				Tersangka tersangka = listTersangka.get(idxTersangka);
				
				if (kasus.getId().equals(tersangka.getKasus().getId())) {
					listPerColumnTersangka.add(tersangka.getNamaLengkap() + "\n" + tersangka.getNrp());
				}
			}
			
			listResultTersangka.add(listPerColumnTersangka);
		}
		
		System.out.println("Tersangka:" + listResultTersangka.size());
		
		return listResultTersangka;
	}
}
