package com.brahmastra.sih.report.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import com.brahmastra.sih.report.util.Directory;
import com.brahmastra.sih.service.konfigurasi.KonfigurasiService;

public class ReportRekapKasusCommand extends ReportCommand {

	private KonfigurasiService konfigurasiService;
	
	public ReportRekapKasusCommand(WebApplicationContext ctx) {
		super(ctx);
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// SubDetailEstimasiBiayaService subService =
		// (SubDetailEstimasiBiayaService) ctx
		// .getBean("SubDetailEstimasiBiayaService");
		//
		// String estimasiId = request.getParameter("estimasiId");
		Map<String, Object> myMap = new HashMap<String, Object>();
		
		System.out.println(konfigurasiService);
		
		//List<Konfigurasi> listKonfigurasi = konfigurasiService.findAll();
		//if (listKonfigurasi.size() == 1)  {
			//Konfigurasi konfigurasi = listKonfigurasi.get(1);
			
			myMap.put("PARAM_INSTANSI", "Pengadilan Militer".toUpperCase());
			myMap.put("PARAM_KOTA", "Semarang".toUpperCase());
			myMap.put("PARAM_BULAN", "Oktober".toUpperCase());
			myMap.put("PARAM_TAHUN", "2012");
						
		//}
			
		// List<EntitasBiaya> entitasBiayas = subService
		// .findByEstimasiId(estimasiId);
		// entitasBiayas = setGroupNumber(entitasBiayas);
		String baseDir = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/");
		String fileName = baseDir + "/" + Directory.RPT_REKAP_KASUS_DIR;
		// Object[] list = entitasBiayas.toArray();
		Object[] list = null;
		this.generalPDFReports(list, response, myMap, fileName);
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
