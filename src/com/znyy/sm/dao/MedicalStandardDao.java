/**
 * 
 */
package com.znyy.sm.dao;

import java.util.List;

import com.znyy.bean.SmMedicalStandard;

public interface MedicalStandardDao {

	List<SmMedicalStandard> getMs();

	void addFile(SmMedicalStandard ms);

	SmMedicalStandard queryZskSummaryById(String knowId);

	List<SmMedicalStandard> getCatalogList();

	void zskDel(SmMedicalStandard ms);

	SmMedicalStandard queryZskById(String knowId);


}
