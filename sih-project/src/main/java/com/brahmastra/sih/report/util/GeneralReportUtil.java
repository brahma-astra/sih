package com.brahmastra.sih.report.util;

import java.util.List;


public final class GeneralReportUtil {

	private GeneralReportUtil() {
		// NOOP
	}

	public static String getDefaultDirectory() {
		return Directory.DEFAULT_DIR;
	}

	public static String constructColumnVerticalNumbered(List<String> column) {
		StringBuilder strResult = new StringBuilder();
		
		for (int idx = 0; idx < column.size(); idx++) {
			strResult.append(new Integer(idx+1).toString());
			strResult.append(". ");
			strResult.append(column.get(idx));
			strResult.append("\n");
		}

		return strResult.toString();
	}
}
