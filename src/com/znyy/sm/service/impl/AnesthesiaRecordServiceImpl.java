package com.znyy.sm.service.impl;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.znyy.bean.SmAnaesEvent;
import com.znyy.bean.SmAnaesEventItems;
import com.znyy.bean.SmAnaesRecord;
import com.znyy.bean.SmBloodtypeItem;
import com.znyy.bean.SmBodyPosition;
import com.znyy.bean.SmBreathEvent;
import com.znyy.bean.SmIoDefination;
import com.znyy.bean.SmIoEvent;
import com.znyy.bean.SmMedicalEvent;
import com.znyy.bean.SmMedicalTakeWay;
import com.znyy.bean.SmMedicine;
import com.znyy.bean.SmOperationEvent;
import com.znyy.bean.SmOutRoomStatus;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmRemarkPoint;
import com.znyy.bean.SmWaveData;
import com.znyy.sm.dao.AnesthesiaRecordDao;
import com.znyy.sm.service.AnesthesiaRecordService;

public class AnesthesiaRecordServiceImpl implements AnesthesiaRecordService{

	private AnesthesiaRecordDao anesthesiaRecordDao;
	
	public AnesthesiaRecordDao getAnesthesiaRecordDao() {
		return anesthesiaRecordDao;
	}
	public void setAnesthesiaRecordDao(AnesthesiaRecordDao anesthesiaRecordDao) {
		this.anesthesiaRecordDao = anesthesiaRecordDao;
	}
	
	
	public  SmRegOpt  loadAnesthesiaRecordMainView(String ylwsid) {
		return  anesthesiaRecordDao.loadAnesthesiaRecordMainViewById(ylwsid);
	}
	
	
	public List<SmRemarkPoint> collectItemsPointByOptId(String operationId,String id) {
		return anesthesiaRecordDao.getCollectItemsPointByOptId(operationId,id);
	}
	
	public List<SmMedicine> getSmMedicineAllList() {
		
		return anesthesiaRecordDao.getSmMedicineList();
	}
	
	public List<SmMedicine> getMedicineNameByPinYin(String mpyCode) {
		
		return anesthesiaRecordDao.getMedicineNameByPy(mpyCode);
	}
	
	public SmMedicine getMedicineById(Integer medicineId){
		return anesthesiaRecordDao.getMedicinesById(medicineId);
	}
	
	public List<SmMedicalTakeWay> getSmMedicalTakeWayAllList() {
		
		return anesthesiaRecordDao.getSmMedicalTakeWayList();
	}
	
	public SmIoDefination getInPutById(Integer inPutId) {
		
		return anesthesiaRecordDao.getAInPutById(inPutId);
	}
	
	public List<SmIoDefination> getSmIoDefinationList() {
		
		return anesthesiaRecordDao.getSmIoDefinationAllList();
	}
	
	public List<SmBloodtypeItem> getSmBloodtypeItemList() {
		
		return anesthesiaRecordDao.getBloodtypeItemList();
	}

	@Override
	public void addSmIoEvent(SmIoEvent smie) {
		anesthesiaRecordDao.addSmIoEvent(smie);
	}
	@Override
	public SmIoEvent getSmIoEventById(String operationId,String itemId) {
		
		return anesthesiaRecordDao.getSmIoEventById(operationId,itemId);
	}
	@Override
	public void updateSmIoEvent(SmIoEvent smie) {
		 anesthesiaRecordDao.UpdateSmIoEvent(smie);
		
	}
	@Override
	public List<SmIoEvent> getSmIoEventListByOperationId(String operationId,String type) {
		return anesthesiaRecordDao.getSmIoEventListByOperationId(operationId,type);
	}
	
	public SmIoEvent getSmIoEventById(Integer id){
		return anesthesiaRecordDao.getIoEventById(id);
	}
	@Override
	public List<SmIoDefination> getInChildNamesBySubType(String subType) {	
		return anesthesiaRecordDao.getInNamesBySubType(subType);
	}
	@Override
	public void addSmAnesthesiaEvent(SmAnaesEvent sae) {
		anesthesiaRecordDao.addSmAnesEvent(sae);	
	}
	@Override
	public void updateSmRegOpt(SmRegOpt sro) {
		anesthesiaRecordDao.updateSmRegOpt(sro);
		
	}
	@Override
	public void updateSmAnesthesiaEvent(SmAnaesEvent sae) {
		anesthesiaRecordDao.updateSmAnesEvent(sae);
		
	}
	@Override
	public SmAnaesEvent getSmAnesEventByOptIdAndCode(String operationId,String code) {
	
		return anesthesiaRecordDao.getSmAnesEventByOperationIdAndCode(operationId,code);
	}
	@Override
	public List<SmAnaesEvent> getSmAnesEventByOptId(String operationId) {
		
		return anesthesiaRecordDao.getSmAnesEventByOperationId(operationId);
	}
	
	@Override
	public List<SmAnaesEventItems> getSmAnaesEventItemsList() {		
		return anesthesiaRecordDao.getSmAnaesEventItems();
	}
	@Override
	public List<SmAnaesEvent> getSmAnesthesiaEventsListByOptId(String operationId) {
		
		return anesthesiaRecordDao.getSmAnesEventsListByOperationId(operationId);
	}
	
	@Override
	public SmAnaesEventItems getSmAnaesEventItem(String code) {
		return anesthesiaRecordDao.getAnaesEventItem(code);
	}
	@Override
	public void addSmAnaesRecord(SmAnaesRecord sar) {
		anesthesiaRecordDao.addAnaesRecord(sar);
		
	}
	@Override
	public void updateSmAnaesRecord(SmAnaesRecord sar) {
		anesthesiaRecordDao.updateAnaesRecord(sar);
		
	}
	@Override
	public SmAnaesRecord getSmAnaesRecordByoperationId(String operationId) {
		
		return anesthesiaRecordDao.getAnaesRecordByoperationId(operationId);
	}
	@Override
	public SmMedicalEvent getSmMedicalEventByOptIdAndMedCode(String operationId,
			String medId) {
		return anesthesiaRecordDao.getMedicalEventByOptIdAndMedCode(operationId,medId);
	}
	@Override
	public void addSmMedicalEvent(SmMedicalEvent sme) {
		anesthesiaRecordDao.addMedicalEvent(sme);
		
	}
	@Override
	public void updateSmMedicalEvent(SmMedicalEvent sme) {
		anesthesiaRecordDao.updateMedicalEvent(sme);
		
	}
	
	 public SmMedicalEvent getMedEventById(Integer id){
		 return anesthesiaRecordDao.getMedEventaById(id);
	 }
	 
	@Override
	public List<SmMedicalEvent> getSmMedicalEventListByOperationId(
			String operationId) {
		return anesthesiaRecordDao.getMedicalEventListByOperationId(operationId);
	}
	@Override
	public void addMonitoringSign(SmWaveData smwd) {
		anesthesiaRecordDao.addMonitSign(smwd);
		
	}
	@Override
	public SmWaveData getMonitoringSignByOperationIdAndTime(String operationId, Integer xpoint) {
		return anesthesiaRecordDao.getMonitoringSignByOptIdAndTime(operationId,xpoint);
	}
	@Override
	public void updateMonitoringSign(SmWaveData smwd) {
		anesthesiaRecordDao.updateMonitSign(smwd);
		
	}
	@Override
	public List<SmWaveData> getMonitoringSignListByOperationId(
			String operationId) {
		return anesthesiaRecordDao.getMonitListByOperationId(operationId);
	}
	@Override
	public  List<Map<String, Object>> getAnesthesiaRecordWeekPrint(String operationId){	
		 //List<Map<String, Object>> result  = anesthesiaRecordDao.getAnesthesiaRecordByOperationIdPrint(operationId);
		 List<Map<String, Object>> result  = anesthesiaRecordDao.getAnesthesiaRecordPrint(operationId);
		return result;
	}
	@Override
	public SmOperationEvent getOperationEventById(String id) {
		return anesthesiaRecordDao. getOptEventById(id);
	}
	@Override
	public List<SmOperationEvent> getOperationEventByOperationId(
			String operationId) {
		return anesthesiaRecordDao.getOptEventByOperationId(operationId);
	}
	@Override
	public void addOperationEvent(SmOperationEvent sopet) {
		anesthesiaRecordDao.addOptEvent(sopet);
		
	}
	@Override
	public void updateOperationEvent(SmOperationEvent sopet) {
		anesthesiaRecordDao.updateOptEvent(sopet);
		
	}
	@Override
	public SmBreathEvent getSmBreathEventById(String id) {
		return anesthesiaRecordDao. getBreathEventById(id);
	}
	@Override
	public List<SmBreathEvent> getSmBreathEventByOperationId(String operationId) {
		return anesthesiaRecordDao.getBreathEventByOperationId(operationId);
	}
	@Override
	public void addSmBreathEvent(SmBreathEvent sbet) {
		anesthesiaRecordDao.addBreathEvent(sbet);
		
	}
	@Override
	public void updateSmBreathEvent(SmBreathEvent sbet) {
		anesthesiaRecordDao.updateBreathEvent(sbet);
		
	}

	@Override
	public SmBodyPosition getSmBodyPositionByOperationId(
			String operationId) {
		
		return anesthesiaRecordDao.getBodyPositionByOperationId(operationId);
	}
	@Override
	public void addSmBodyPosition(SmBodyPosition sbp) {
		anesthesiaRecordDao.addBodyPosition(sbp);
		
	}
	@Override
	public void updateSmBodyPosition(SmBodyPosition sbp) {
		anesthesiaRecordDao.updateBodyPosition(sbp);
	}
	@Override
	public SmOutRoomStatus getSmOutRoomStatusByoperationId(String operationId) {
		return anesthesiaRecordDao.getOutRoomStatusByoperationId(operationId);
	}
	@Override
	public void addSmOutRoomStatus(SmOutRoomStatus sors) {
		anesthesiaRecordDao.addOutRoomStatus(sors);
	}
	@Override
	public void updateSmOutRoomStatus(SmOutRoomStatus sors) {
		anesthesiaRecordDao.updateOutRoomStatus(sors);
	}
	@Override
	public List<Map<String, Object>> loadAllDocumentState() {
		
		return anesthesiaRecordDao.LoadDocumentState();
	}

	@Override
	public void modAnesthetistersByoperationName(SmRegOpt sross) {
		
		anesthesiaRecordDao.modAnesthetistersByoperationName(sross);
	}
	@Override
	public SmAnaesRecord getAnaesRecordByoperationId(String operationId) {
		return anesthesiaRecordDao.getAnaesRecordByoperationId(operationId);
	}
	
	@Override
	public void createVitalSign(SmRemarkPoint srp) {
		anesthesiaRecordDao.addVitalSign(srp);
	}
	@Override
	public List<Date> getTimesByOptId(String operationId,String hospitalCode,String roomCode) {
		return anesthesiaRecordDao.getTimesPointByOptId(operationId,hospitalCode,roomCode);
	}
	@Override
	public SmRemarkPoint collectItemsPointByOptId(String operationId,String itemCode, String hospitalCode,String roomCode,Date time) {
		return anesthesiaRecordDao.getCollectItemsPointByOptId(operationId,itemCode,hospitalCode,roomCode,time);
	}
	
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaRecordService#getAnesEventList()
	 */
	@Override
	public List<Map<String, Object>> getAnesEventList() {
		return anesthesiaRecordDao.getAnesEventList();
	}
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaRecordService#addAnesEventItem(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String,Object> addAnesEventItem(String itemCode, String operationId,
			String userid) {
		SmAnaesEvent event = new SmAnaesEvent();
		event.setCode(itemCode);
		event.setCreateuser(userid);
		event.setEnable("0");
		event.setOccurtime(new Date());
		event.setOperationId(operationId);
		anesthesiaRecordDao.saveSmAnaesEvent(event);
		Map<String,Object> map = new HashMap<String,Object>();
		DateFormat f = new SimpleDateFormat("HH:mm");
		map.put("occurtime", f.format(event.getOccurtime()));
		map.put("name", anesthesiaRecordDao.getSmAnesEventItemByCode(itemCode).getName());
		return map;
	}
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaRecordService#getAnesEventByOperationId(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getAnesEventByOperationId(String ylwsid) {
		return anesthesiaRecordDao.getAnesEventByOperationId(ylwsid);
	}
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaRecordService#addOperationEvent(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public SmOperationEvent addOperationEvent(String title, String content,
			String time, String operationId) throws ParseException {
		SmOperationEvent event = new SmOperationEvent();
		event.setContent(content);
		event.setEnable("0");
		event.setTitle(title);
		event.setOperationId(operationId);
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		event.setTime(f.parse(time));
		anesthesiaRecordDao.saveSmOperationEvent(event);
		return event;
	}
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaRecordService#getOpEventByOperationId(java.lang.String)
	 */
	@Override
	public List<SmOperationEvent> getOpEventByOperationId(String ylwsid) {
		return anesthesiaRecordDao.getOpEventByOperationId(ylwsid);
	}
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaRecordService#delOperationEventItem(java.lang.String)
	 */
	@Override
	public void delOperationEventItem(String id) {
		SmOperationEvent event = anesthesiaRecordDao.getOpEventById(id);
		event.setEnable("1");
		anesthesiaRecordDao.saveSmOperationEvent(event);
	}
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaRecordService#getOpEventById(java.lang.String)
	 */
	@Override
	public Map<String, Object> getOpEventById(String id) {
		SmOperationEvent event = anesthesiaRecordDao.getOpEventById(id);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", event.getId());
		map.put("title", event.getTitle());
		map.put("content", event.getContent());
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("time", f.format(event.getTime()));
		return map;
	}
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaRecordService#modOperationEvent(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public SmOperationEvent modOperationEvent(String title, String content,
			String time, String id) throws ParseException {
		SmOperationEvent event = anesthesiaRecordDao.getOpEventById(id);
		event.setContent(content);
		event.setTitle(title);
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		event.setTime(f.parse(time));
		anesthesiaRecordDao.saveSmOperationEvent(event);
		return event;
	}
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaRecordService#addBreathEvent(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public SmBreathEvent addBreathEvent(String operationId, String time,
			String breathFlag) throws ParseException {
		SmBreathEvent event = new SmBreathEvent();
		event.setFlag(breathFlag);
		event.setEnable("0");
		event.setOperationId(operationId);
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		event.setStarttime(f.parse(time));
		anesthesiaRecordDao.saveSmBreathEvent(event);
		return event;
	}
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaRecordService#getBreathEventByOperationId(java.lang.String)
	 */
	@Override
	public List<SmBreathEvent> getBreathEventByOperationId(String ylwsid) {
		return anesthesiaRecordDao.getBreathEventByOperationId(ylwsid);
	}
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaRecordService#delBreathEventItem(java.lang.String)
	 */
	@Override
	public void delBreathEventItem(String id) {
		SmBreathEvent event = anesthesiaRecordDao.getBreathEventById(id);
		event.setEnable("1");
		anesthesiaRecordDao.saveSmBreathEvent(event);
	}
}
