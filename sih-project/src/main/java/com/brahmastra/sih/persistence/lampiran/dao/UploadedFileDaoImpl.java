package com.brahmastra.sih.persistence.lampiran.dao;

import org.springframework.stereotype.Component;

import com.brahmastra.sih.persistence.lampiran.domain.FileLampiran;

@Component("UploadedFileDao")
public class UploadedFileDaoImpl implements UploadedFileDao {

	public UploadedFileDaoImpl() {

	}

	// @Override
	// public Integer upload(UploadedFile file) throws Exception {
	// System.out.println("File size: " + file.getContent().length);
	// System.out.println("File type: " + file.getType());
	// System.out.println("Table name: " + file.getTableName());
	//
	// FileProcessorCommand fileProcessorCommand = null;
	//
	// fileProcessorCommand =
	// FileProcessorUtil.getFileProcessorCommand(file);
	//
	// if (fileProcessorCommand != null) {
	// fileProcessorCommand.execute(getMap());
	// } else {
	// throw new Exception("Proses upload ke tabel " + file.getTableName()
	// + " gagal.");
	// }
	//
	// return 1;
	// }

	@Override
	public Integer upload(FileLampiran file) throws Exception {
		System.out.println("File size: " + file.getId());
		System.out.println("File type: " + file.getData().length);

		return 1;
	}
}
