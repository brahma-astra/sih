package com.brahmastra.sih.report.command;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

public abstract class ReportCommand {
	protected static final Log LOG = LogFactory.getLog(ReportCommand.class);
	protected WebApplicationContext ctx;
	private static String outputFilename;
	
	@Autowired
	public ReportCommand(WebApplicationContext ctx) {
		super();
		this.ctx = ctx;
	}

	protected void generalPDFReports(Object[] pMyData,
			HttpServletResponse response, Map<String, Object> myMap,
			String pJasperReportFile) throws ServletException {
		try {
			byte[] bytes = null;
			net.sf.jasperreports.engine.data.JRBeanArrayDataSource myJrDataSource = new JRBeanArrayDataSource(
					pMyData);
			bytes = JasperRunManager.runReportToPdf(pJasperReportFile, myMap,
					myJrDataSource);
			ServletOutputStream servletOutputStream = response
					.getOutputStream();
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			servletOutputStream.write(bytes, 0, bytes.length);
			servletOutputStream.flush();
			servletOutputStream.close();
		} catch (Exception e) {
			LOG.error("Failed to Generate General PDF Report", e);
			throw new ServletException(e);
		}
	}

	protected void generalXlsReports(Object[] pMyData,
			HttpServletResponse response, Map<String, Object> myMap,
			String pJasperReportFile) throws ServletException {
		try {
			byte[] bytes = null;
			net.sf.jasperreports.engine.data.JRBeanArrayDataSource myJrDataSource = new JRBeanArrayDataSource(
					pMyData);
			bytes = runReportToXls(pJasperReportFile, myMap, myJrDataSource);
			ServletOutputStream servletOutputStream = response
					.getOutputStream();
			response.setContentType("application/xls");
			// response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-disposition",
					"attachment; filename=filename.xls");
			response.setContentLength(bytes.length);
			servletOutputStream.write(bytes, 0, bytes.length);
			servletOutputStream.flush();
			servletOutputStream.close();
		} catch (Exception e) {
			LOG.error("Failed to Generate General Excel Report", e);
			throw new ServletException(e);
		}
	}

	protected static byte[] runReportToXls(String sourceFileName,
			Map<String, Object> parameters, JRDataSource jrDataSource)
			throws JRException {
		JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName,
				parameters, jrDataSource);
		return exportReportToXls(jasperPrint);
	}

	protected static byte[] exportReportToXls(JasperPrint jasperPrint)
			throws JRException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		JRXlsExporter exporterXLS = new JRXlsExporter();
		exporterXLS.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporterXLS.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exporterXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
				outputFilename);
		exporterXLS.setParameter(
				JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET,
				Boolean.FALSE);
		exporterXLS.setParameter(
				JRXlsAbstractExporterParameter.IS_DETECT_CELL_TYPE,
				Boolean.TRUE);
		exporterXLS.setParameter(
				JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND,
				Boolean.FALSE);
		exporterXLS
				.setParameter(
						JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
						Boolean.TRUE);
		exporterXLS.exportReport();

		return baos.toByteArray();
	}

	public abstract void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException;

	public static void setOutputFilename(String outputFilename) {
		ReportCommand.outputFilename = outputFilename;
	}

	public static String getOutputFilename() {
		return outputFilename;
	}
}
