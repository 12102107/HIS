/**
 * 
 */
package com.znyy.sm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.znyy.bean.SmRecoveryData;
import com.znyy.bean.SmRecoveryFromMachine;
import com.znyy.bean.SmRecoveryroomRecord;
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.dao.RecoveryDao;
import com.znyy.sm.service.RecoveryService;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author 白东旭
 * @date 2016-5-4
 */
public class RecoveryServiceImpl implements RecoveryService {

	private RecoveryDao recoveryDao;

	/**
	 * @return the recoveryDao
	 */
	public RecoveryDao getRecoveryDao() {
		return recoveryDao;
	}

	/**
	 * @param recoveryDao the recoveryDao to set
	 */
	public void setRecoveryDao(RecoveryDao recoveryDao) {
		this.recoveryDao = recoveryDao;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.RecoveryService#getSmRegOptByYlwsid(java.lang.String)
	 */
	@Override
	public SmRegOpt getSmRegOptByYlwsid(String ylwsid) {
		return recoveryDao.getSmRegOptByYlwsid(ylwsid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.RecoveryService#saveRecord(com.znyy.bean.SmRecoveryroomRecord, java.lang.String)
	 */
	@Override
	public void saveRecord(SmRecoveryroomRecord record, String username) {
		if("".equals(record.getId())) {
			record.setId(null);
		}
		record.setCreatOperation(username);
		record.setCreatTime(new Date());
		recoveryDao.saveRecord(record);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.RecoveryService#getRecordByYlwsid(java.lang.String)
	 */
	@Override
	public SmRecoveryroomRecord getRecordByYlwsid(String ylwsid) {
		return recoveryDao.getRecordByYlwsid(ylwsid);
	}

	@Override
	public void addVitalSignsData(SmRecoveryFromMachine recovery) {
		recoveryDao.saveVitalSignsData(recovery);
		
	}

	@Override
	public Map<String, Object> getCollectDateByRoomAndTime(String roomCode) {
		return recoveryDao.getCollectDatesByRoomAndTime(roomCode);
	}

	@Override
	public void createRecoveryRecord(SmRecoveryroomRecord record) {
		recoveryDao.saveRecord(record);
	}

	@Override
	public void updateRecoveryRecord(SmRecoveryroomRecord record) {
		recoveryDao.updateRecord(record);
		
	}

	@Override
	public void addRecoveryData(SmRecoveryData srdata) {
		recoveryDao.addRecoveryDatas(srdata);
	}

	@Override
	public List<Map<String, Object>> loadSmRecoveryData(String operationId) {
		return recoveryDao.loadRecoveryData(operationId);
	}

	@Override
	public List<Map<String, Object>> loadRecoveryPrintData(String operationId) {
		 List<Map<String, Object>> result  = recoveryDao.loadRecoveryPrintDataByOptId(operationId);
		return result;
	}


	
}
