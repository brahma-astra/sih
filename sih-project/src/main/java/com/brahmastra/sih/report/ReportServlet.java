package com.brahmastra.sih.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.brahmastra.sih.report.command.ReportCommand;
import com.brahmastra.sih.report.factory.GeneralReportFactory;

public class ReportServlet extends HttpServlet {

	private WebApplicationContext ctx;

	private static final long serialVersionUID = 2685741441100298349L;

	public ReportServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this
				.getServletContext());
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReportCommand reportCommand = null;

		String reportType = request.getParameter("reportType");
		//String month = request.getParameter("month");
		//String year = request.getParameter("year");
		
		if (reportType == null) {
			printException(response);
		} 
		
		reportCommand = GeneralReportFactory.getReportCommand(
				reportType, ctx);

		if (reportCommand != null) {
			reportCommand.execute(request, response);
		} else {
			printException(response);
		}
	}

	public void printException(HttpServletResponse response) throws IOException {
		ServletOutputStream servletOutputStream = response.getOutputStream();
		servletOutputStream.print("<html>");
		servletOutputStream.print("<header>");
		servletOutputStream.print("</header>");
		servletOutputStream.print("<body>");
		servletOutputStream.print("Report tidak ditemukan !");
		servletOutputStream.print("</body>");
		servletOutputStream.print("</html>");
		servletOutputStream.flush();
		servletOutputStream.close();
	}

}
