package com.brahmastra.sih.persistence.lampiran.dao;

import com.brahmastra.sih.persistence.lampiran.domain.FileLampiran;

public interface UploadedFileDao {
	Integer upload(FileLampiran file) throws Exception;
}
