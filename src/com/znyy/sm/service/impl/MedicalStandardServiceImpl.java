package com.znyy.sm.service.impl;

import java.util.List;

import com.znyy.bean.SmMedicalStandard;
import com.znyy.sm.dao.MedicalStandardDao;
import com.znyy.sm.service.MedicalStandardService;

public class MedicalStandardServiceImpl implements MedicalStandardService {

	private MedicalStandardDao medicalStandardDao;

	public MedicalStandardDao getMedicalStandardDao() {
		return medicalStandardDao;
	}

	public void setMedicalStandardDao(MedicalStandardDao medicalStandardDao) {
		this.medicalStandardDao = medicalStandardDao;
	}

	@Override
	public List<SmMedicalStandard> getMs() {
		return medicalStandardDao.getMs();
	}

	@Override
	public void addFile(SmMedicalStandard ms) {
		medicalStandardDao.addFile(ms);
	}

	@Override
	public SmMedicalStandard queryZskSummaryById(String knowId) {
		
		return medicalStandardDao.queryZskSummaryById(knowId);
	}

	@Override
	public List<SmMedicalStandard> getCatalogList() {
		return medicalStandardDao.getCatalogList();
	}
	@Override
	public void zskDel(SmMedicalStandard ms) {
		medicalStandardDao.zskDel(ms);
	}

	@Override
	public SmMedicalStandard queryZskById(String knowId) {
		return medicalStandardDao.queryZskById(knowId);
	}

}
