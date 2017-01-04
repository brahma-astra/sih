package com.brahmastra.sih.report.factory;

import java.io.Serializable;

import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;

import com.brahmastra.sih.report.command.ReportCommand;
import com.brahmastra.sih.report.util.ReportMap;

public final class GeneralReportFactory implements Serializable {

	private static final long serialVersionUID = 8043415433286751975L;
	private static final org.apache.commons.logging.Log LOG = LogFactory
			.getLog(GeneralReportFactory.class);

	private GeneralReportFactory() {
		// to prevent instantiation
	}

	public static ReportCommand getReportCommand(String reportType,
			WebApplicationContext ctx) {
		ReportCommand reportCommand = null;
		
		Class<? extends ReportCommand> reportCommandClass = ReportMap.REPORT_COMMAND_MAP
				.get(reportType);
		
		if (reportCommandClass != null) {
			try {
				reportCommand = reportCommandClass.newInstance();
			} catch (Exception e) {
				LOG.debug("Can't create a ReportCommand object.", e);
			}
		}
		return reportCommand;
	}
}
