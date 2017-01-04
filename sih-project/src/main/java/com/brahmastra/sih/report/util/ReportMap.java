package com.brahmastra.sih.report.util;

import java.util.HashMap;
import java.util.Map;

import com.brahmastra.sih.report.command.ReportCommand;
import com.brahmastra.sih.report.command.ReportKasusBulananCommand;
import com.brahmastra.sih.report.command.ReportRekapKasusCommand;
import com.brahmastra.sih.report.command.example.ReportNameAReportCommand;

public final class ReportMap {

	private ReportMap() {
	}

	public static final Map<String, Class<? extends ReportCommand>> REPORT_COMMAND_MAP = new HashMap<String, Class<? extends ReportCommand>>();

	static {
		REPORT_COMMAND_MAP.put(Directory.RPT_REPORT_NAME_A,
				ReportNameAReportCommand.class);
		REPORT_COMMAND_MAP.put(Directory.RPT_REKAP_KASUS,
				ReportRekapKasusCommand.class);
		REPORT_COMMAND_MAP.put(Directory.RPT_KASUS_BULANAN,
				ReportKasusBulananCommand.class);
	}

}
