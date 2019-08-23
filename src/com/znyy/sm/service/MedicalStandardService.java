package com.znyy.sm.service;

import java.util.List;

import com.znyy.bean.SmMedicalStandard;

public interface MedicalStandardService {

	List<SmMedicalStandard> getMs();

	void addFile(SmMedicalStandard ms);

	SmMedicalStandard queryZskSummaryById(String knowId);

	List<SmMedicalStandard> getCatalogList();

	void zskDel(SmMedicalStandard ms);

	SmMedicalStandard queryZskById(String knowId);


}