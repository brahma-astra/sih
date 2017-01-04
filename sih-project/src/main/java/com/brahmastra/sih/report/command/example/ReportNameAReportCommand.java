package com.brahmastra.sih.report.command.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import com.brahmastra.sih.report.command.ReportCommand;

public class ReportNameAReportCommand extends ReportCommand {

	public ReportNameAReportCommand(WebApplicationContext ctx) {
		super(ctx);
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// BarangService barangService;
		// barangService = (BarangService) ctx.getBean("BarangService");

		// Object barangId = request.getParameter("barangId");
		// Map<String, Object> myMap = new HashMap<String, Object>();
		// myMap.put("ADDITIONAL_TITLE", "Barang: "
		// + barangService.findById(barangId.toString()).getNama());
		// String baseDir =
		// request.getSession().getServletContext().getRealPath("/WEB-INF/");
		// String fileName = baseDir + "/" + Directory.RPT_REPORT_NAME_A;

		// Object[] list = processReport(barangId);
		// this.generalPDFReports(list, response, myMap, fileName);
		// this.generalXlsReports(list, response, myMap, fileName);
	}

	private Object[] processReport(Object instansiId) {
		return null;
	}
}
