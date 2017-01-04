/**
 * 
 */
package com.brahmastra.sih.common.exception.message;

import java.io.Serializable;

public final class ExceptionMessage implements Serializable {

	private static final long serialVersionUID = -1555663428834085727L;

	public static final String MSG_DATA_ALREADY_EXIST = "Data telah ada dalam database";
	public static final String MSG_DATE_PARSE_ERROR = "Format tanggal salah";
	public static final String MSG_ILLEGAL_ARGUMENT = "Argumen salah";
	public static final String MSG_INCOMPLETE_ARGUMENT = "Argumen tidak lengkap";
	public static final String MSG_INCORRECT_DATE_PARAM = "Parameter tanggal tidak sesuai";
	public static final String MSG_INSERT_NOT_SUPPORTED = "Tidak diijinkan menciptakan data";
	public static final String MSG_INSTANCE_WAS_ALREADY_REMOVED = "Data telah dihapus";
	public static final String MSG_INSTANCE_WAS_NOT_REMOVED = "Data tidak dapat dihapus";
	public static final String MSG_LOGIN_FAILED = "Login gagal";
	public static final String MSG_NOT_YET_IMPLEMENTED = "Belum diimplementasikan";
	public static final String MSG_OPERATION_FAILED = "Operasi gagal";
	public static final String MSG_PARAM_CANNOT_BE_NULL = "Parameter tidak boleh null";
	public static final String MSG_PARAM_MUST_BE_NULL = "Parameter harus null";
	public static final String MSG_PROPERTY_CANNOT_BE_NULL = "Properti tidak boleh null atau data belum tersimpan";
	public static final String MSG_RECORDS_ALREADY_EXIST = "Data telah ada sebelumnya";
	public static final String MSG_REMOVE_NOT_SUPPORTED = "Tidak diijinkan menghapus data";
	public static final String MSG_REPORT_NOT_FOUND = "Laporan tidak ditemukan";
	public static final String MSG_UPDATE_NOT_SUPPORTED = "Tidak diijinkan mengubah data";
	public static final String MSG_USERNAME_ALREADY_EXIST = "Username sudah ada";
	public static final String MSG_SHA_NOT_SUPPORTED = "Sistem tidak mendukung enkripsi dengan algoritma SHA";
	public static final String MSG_UTF8_NOT_SUPPORTED = "Sistem tidak mendukung konversi ke UTF-8";

	private ExceptionMessage() {
		super();
	}
}
