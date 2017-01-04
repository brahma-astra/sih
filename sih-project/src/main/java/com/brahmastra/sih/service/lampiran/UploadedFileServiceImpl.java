package com.brahmastra.sih.service.lampiran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brahmastra.sih.persistence.lampiran.dao.UploadedFileDao;
import com.brahmastra.sih.persistence.lampiran.domain.FileLampiran;

@Service("UploadedFileService")
public class UploadedFileServiceImpl implements UploadedFileService {
	@Autowired
	private UploadedFileDao uploadedFileDao;

	@Override
	@Transactional(readOnly = false)
	public Integer upload(FileLampiran file) throws Exception {
		return uploadedFileDao.upload(file);
	}

	/**
	 * @author viper
	 * @param uploadedFileDao
	 *            the uploadedFileDao to set
	 */
	public void setUploadedFileDao(UploadedFileDao uploadedFileDao) {
		this.uploadedFileDao = uploadedFileDao;
	}

	/**
	 * @author viper
	 * @return the uploadedFileDao
	 */
	public UploadedFileDao getUploadedFileDao() {
		return uploadedFileDao;
	}

}
