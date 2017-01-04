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
import com.brahmastra.sih.persistence.kasus.domain.Kasus;
import com.brahmastra.sih.persistence.konfigurasi.domain.Konfigurasi;
import com.brahmastra.sih.report.bean.ReportKasusBulananBean;
import com.brahmastra.sih.report.util.Directory;
import com.brahmastra.sih.report.util.GeneralReportUtil;
import com.brahmastra.sih.report.util.ReportKasusUtil;
import com.brahmastra.sih.service.hakim.HakimService;
import com.brahmastra.sih.service.kasus.KasusService;
import com.brahmastra.sih.service.konfigurasi.KonfigurasiService;
import com.brahmastra.sih.service.panitera.PaniteraService;
import com.brahmastra.sih.service.tersangka.TersangkaService;
import com.brahmastra.sih.service.tindakPidana.TindakPidanaService;

public class ReportKasusBulananCommand extends ReportCommand {
	
	private KonfigurasiService konfigurasiService;
	private KasusService kasusService;
	private PaniteraService paniteraService;
	private HakimService hakimService;
	private TindakPidanaService tindakPidanaService;	
	private TersangkaService tersangkaService;

	public ReportKasusBulananCommand(WebApplicationContext ctx) {
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
		List<List<String>> listPanitera = ReportKasusUtil.getListPanitera(listKasus, paniteraService);

		hakimService = (HakimService) ctx.getBean("HakimService");
		List<List<String>> listHakim = ReportKasusUtil.getListHakim(listKasus, hakimService);
		
		tindakPidanaService = (TindakPidanaService) ctx.getBean("TindakPidanaService");
		List<List<String>> listTindakPidana = ReportKasusUtil.getListTindakPidana(listKasus, tindakPidanaService);
		
		tersangkaService = (TersangkaService) ctx.getBean("TersangkaService");
		List<List<String>> listTersangka = ReportKasusUtil.getListTersangka(listKasus, tersangkaService);		
		
		List<ReportKasusBulananBean> listData = getData(listKasus, listPanitera, listHakim, listTindakPidana, listTersangka);
		
		String baseDir = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/");
		String fileName = baseDir + "/" + Directory.RPT_KASUS_BULANAN_DIR;
		
		Object[] list = listData.toArray();

		this.generalPDFReports(list, response, myMap, fileName);
	}

	private List<ReportKasusBulananBean> getData(List<Kasus> listKasus, List<List<String>> listPanitera, List<List<String>> listHakim, List<List<String>> listTindakPidana, List<List<String>> listTersangka) {
		List<ReportKasusBulananBean> result = new ArrayList<ReportKasusBulananBean>();
		ReportKasusBulananBean row = null;
		
		for (int idxKasus = 0; idxKasus < listKasus.size(); idxKasus++) {
			row = new ReportKasusBulananBean();
			
			row.setNomorRegister(listKasus.get(idxKasus).getNomorRegister());
			row.setTanggalRegister(listKasus.get(idxKasus).getTanggalRegister());
			row.setNoSKEPPERA(listKasus.get(idxKasus).getNoSKEPPERA());
			row.setTersangka(GeneralReportUtil.constructColumnVerticalNumbered(listTersangka.get(idxKasus)));
			row.setTindakPidana(GeneralReportUtil.constructColumnVerticalNumbered(listTindakPidana.get(idxKasus)));
			row.setMajelisHakim(GeneralReportUtil.constructColumnVerticalNumbered(listHakim.get(idxKasus)));
			row.setPanitera(GeneralReportUtil.constructColumnVerticalNumbered(listPanitera.get(idxKasus)));
			
			result.add(row);
		}
		
		return result;
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
