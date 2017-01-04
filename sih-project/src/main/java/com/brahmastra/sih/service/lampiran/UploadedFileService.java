package com.brahmastra.sih.service.lampiran;

import org.springframework.transaction.annotation.Transactional;

import com.brahmastra.sih.persistence.lampiran.domain.FileLampiran;

public interface UploadedFileService {
	@Transactional(readOnly = false)
	Integer upload(FileLampiran file) throws Exception;
}
