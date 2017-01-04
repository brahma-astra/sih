package com.brahmastra.sih.report.util;

public interface Directory {
	String JASPER = ".jasper";
	
	// Constants for report types
	String RPT_REPORT_NAME_A = "rptReportNameA";
	String RPT_REPORT_NAME_B = "rptReportNameB";
	String RPT_REKAP_KASUS = "rptLaporanRekapKasus";
	String RPT_KASUS_BULANAN = "rptLaporanKasusBulanan";

	// Directories of jasper files
	String DEFAULT_DIR = "reports/";
	String RPT_REPORT_NAME_A_DIR = DEFAULT_DIR + RPT_REPORT_NAME_A + JASPER;
	String RPT_REPORT_NAME_B_DIR = DEFAULT_DIR + RPT_REPORT_NAME_B + JASPER;
	String RPT_REKAP_KASUS_DIR = DEFAULT_DIR + RPT_REKAP_KASUS + JASPER;
	String RPT_KASUS_BULANAN_DIR = DEFAULT_DIR + RPT_KASUS_BULANAN + JASPER;
	
}
