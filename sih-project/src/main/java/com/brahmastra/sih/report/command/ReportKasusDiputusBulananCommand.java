package com.brahmastra.sih.report.command;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import com.brahmastra.sih.common.util.DateUtil;
import com.brahmastra.sih.persistence.hakim.domain.Hakim;
import com.brahmastra.sih.persistence.kasus.domain.Kasus;
import com.brahmastra.sih.persistence.konfigurasi.domain.Konfigurasi;
import com.brahmastra.sih.persistence.panitera.domain.Panitera;
import com.brahmastra.sih.persistence.tersangka.domain.Tersangka;
import com.brahmastra.sih.persistence.tindakPidana.domain.TindakPidana;
import com.brahmastra.sih.report.util.Directory;
import com.brahmastra.sih.service.hakim.HakimService;
import com.brahmastra.sih.service.kasus.KasusService;
import com.brahmastra.sih.service.konfigurasi.KonfigurasiService;
import com.brahmastra.sih.service.panitera.PaniteraService;
import com.brahmastra.sih.service.tindakPidana.TindakPidanaService;

public class ReportKasusDiputusBulananCommand extends ReportCommand {
	
	private KonfigurasiService konfigurasiService;
	private KasusService kasusService;
	private PaniteraService paniteraService;
	private HakimService hakimService;
	private TindakPidanaService tindakPidanaService;	

	public ReportKasusDiputusBulananCommand(WebApplicationContext ctx) {
		super(ctx);
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		Calendar calendar = new GregorianCalendar();

		int month = Integer.parseInt(request.getParameter("month"));
		String year = request.getParameter("year");

		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, Integer.parseInt(year));
		
		calendar.set(Calendar.DATE, 1);
		Date startDate = calendar.getTime();
		System.out.println(startDate);

		
		calendar.set(Calendar.DATE, 1);
		Date endDate = null;
		if (calendar.get(Calendar.MONTH) == 11) {
			calendar.set(Calendar.MONTH, 0);
			calendar.set(Calendar.YEAR, Integer.parseInt(year) + 1);
		} else {
			calendar.set(Calendar.MONTH, month + 1);			
		}

		endDate = calendar.getTime();
				
		int thisMonth = calendar.get(Calendar.MONTH);
		String thisYear = Integer.toString(calendar.get(Calendar.YEAR));
		
		konfigurasiService = (KonfigurasiService) ctx.getBean("KonfigurasiService");
		Map<String, Object> myMap = new HashMap<String, Object>();
		List<Konfigurasi> listKonfigurasi = konfigurasiService.findAll();

		if (listKonfigurasi.size() > 0)  {
			Konfigurasi konfigurasi = listKonfigurasi.get(0);
			
			myMap.put("PARAM_INSTANSI", konfigurasi.getNamaInstitusi().toUpperCase());
			myMap.put("PARAM_KOTA", konfigurasi.getKota().toUpperCase());
			myMap.put("PARAM_BULAN", DateUtil.indonesianDate[month].toUpperCase());
			myMap.put("PARAM_TAHUN", year);
			myMap.put("PARAM_BULAN_SEKARANG", DateUtil.indonesianDate[thisMonth]);
			myMap.put("PARAM_TAHUN_SEKARANG", thisYear);
			myMap.put("PARAM_NAMA_INSTITUSI", konfigurasi.getNamaInstitusi());
			myMap.put("PARAM_NAMA_KEPALA", konfigurasi.getNamaKepala());
			myMap.put("PARAM_PANGKAT_NRP", konfigurasi.getPangkatNRPKepala());
						
		}
			
		kasusService = (KasusService) ctx.getBean("KasusService");
		List<Kasus> listKasus = kasusService.findKasusBetweenDate("tanggalRegister", startDate, endDate);

		paniteraService = (PaniteraService) ctx.getBean("PaniteraService");
		List<List<String>> listPanitera = getListPanitera(listKasus, paniteraService);

		hakimService = (HakimService) ctx.getBean("HakimService");
		List<List<String>> listHakim = getListHakim(listKasus, hakimService);
		
		tindakPidanaService = (TindakPidanaService) ctx.getBean("TindakPidanaService");
		List<List<String>> listTindakPidana = getListTindakPidana(listKasus, tindakPidanaService);
		
		String baseDir = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/");
		String fileName = baseDir + "/" + Directory.RPT_KASUS_BULANAN_DIR;
		
		Object[] list = listKasus.toArray();

		this.generalPDFReports(list, response, myMap, fileName);
	}

	private String constructColumnNoPerkara(Kasus kasus, Tersangka tersangka) {
		StringBuilder strResult = new StringBuilder();
		
		strResult.append(kasus.getNoPutusan());
		strResult.append("\n");
		strResult.append(tersangka.getNamaLengkap());
		strResult.append("\n");
		strResult.append(tersangka.getNrp());
		strResult.append("\n");
		
		return strResult.toString();
	}
	
	private List<List<String>> getListPanitera(List<Kasus> listKasus, PaniteraService paniteraService) {
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

	private List<List<String>> getListHakim(List<Kasus> listKasus, HakimService hakimService) {
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
	
	private List<List<String>> getListTindakPidana(List<Kasus> listKasus, TindakPidanaService tindakPidanaService) {
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
	
	// private List<EntitasBiaya> setGroupNumber(List<EntitasBiaya> list) {
	// int counter = 1;
	// String previousId = "";
	// for (EntitasBiaya entitas : list) {
	// entitas.setNumber(counter);
	// if (!previousId.equals(entitas.getDetailId())) {
	// previousId = entitas.getDetailId();
	// counter++;
	// }
	// }
	// return list;
	// }
}
