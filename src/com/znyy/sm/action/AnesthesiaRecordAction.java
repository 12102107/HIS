package com.znyy.sm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.OAMSUtils;
import com.common.util.XmlUtil;
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
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOutRoomStatus;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmRemarkPoint;
import com.znyy.bean.SmWaveData;
import com.znyy.sm.service.AnesthesiaRecordService;
import com.znyy.sm.service.OperationPeopleService;

public class AnesthesiaRecordAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private static String IS_ENABLE="0";//有效
	private static String NOT_ENABLE="1";//无效
	private static String START_OPERATION="04";//术中
	private static String END_OPERATION="05";//术后
	
	private String ylwsid;
	private String yishiRole; 
	private String functionid;
	
	
	private SmRegOpt sro;
	private AnesthesiaRecordService anesthesiaRecordService;
	private OperationPeopleService operationPeopleService;
	private SmBloodtypeItem smbti;
	private List<?> smbtiList;
	


	private String startTime;
	private String startRecordTime;
	private String operationEndtime;
	private String timeInterval;
	private String collectItemsResult;
	private String smIoEventListResult;
	private String smMedicalEventListResult;
	private String inChildNamesResult;
	private String smAnaesEventItemsResult;
	private String smMonitoringSignResult;
	private String smAnaesEventsResult;
	
	private String operationId;
	
	
	private List<SmMedicine> smdList;
	private List<SmMedicalTakeWay> smtwList;
	
	private SmRemarkPoint smRemarkPoint;
	private SmAnaesEvent sae;
	private SmAnaesRecord smard;
	private String smieid;
	private String liquidsId;
	private String liquidsInSubType;
	private String eventItemCode;
	private String anesthEventX;
	private String userId;
	private String anaesEventItemsX;
	private String collectIntervals;
	private String hollowCircles;
	private String solidCircles;
	private String downTriangles;
	private String upTriangles;
	private String specialStatus;






//麻醉用药字段

	private String data = "";

    //出入量字段
	private String outPutOperationId; 
	private String  outPutId ;
	private String  outPutName ;
	private String  outPutDosage ;
	private String  outPutDosageUnit ;
	private String  outPutX ;
	private String  outPutY ;
	private String  outPutDataId ;
	
	
	
	private String  inPutOperationId ;
	private String  inPutId ;
	private String  inPutName ;
	private String  inPutSpec ;
	private String  inPutFirm ;
	private String  inPutDosage ;
	private String  inPutDosageUnit ;
	private String  inPutAmount ;
	private String  inPutPrice ;
	private String  inPutCharge ;
	private String  inPutStartX ;
	private String  inPutStartY ;
	private String  inPutEndX ;
	private String  inPutEndY ;
	private String  inPutEnded ;
	private String  inPutDataId ;
	
	
	
	private String  medOperationId ;
	private String  medId ;
	private String  medName ;
	private String  medSpec ;
	private String  medTakewayCode ;
	private String  medFirm ;
	private String  medDosage ;
	private String  medDosageUnit ;
	private String  medAmount ;
	private String  medIsCharge ;
	private String  medThickness ;
	private String  medThicknessUnit ;
	private String  medSpeed ;
	private String  medSpeedUnit ;
	private String  medReasonSelect ;
	private String  medReason ;
	private String  medStartX ;
	private String  medSY ;
	private String  medEndX ;
	private String  medHeight ;
	private String  medIsEnded ;
	private String  medIsContinued ;
	
	
	
	private String anaesCode;
	
	
	
	
    //手术事件
	private SmOperationEvent operationEvent;
	private String smOperationEventListResult;
	private String operationEventId;
    //呼吸事件  
	private SmBreathEvent breathEvent;
	private String smBreathEventListResult;
	private String breathEventId;
	//麻醉人员
	private String anesthetisterResult;
	//手术人员
	private String operatorsResult;
	//体位信息
	private SmBodyPosition bodyPosition;
	private String bodyPositionValues;
	private String bodyPositionId;
	private String bodyPositionResult;
	
	private String monitoringSign;
	//麻醉小结
	private String anesthSummaryResult;
	
	private SmOutRoomStatus sors;
	private String outRoomStatusResult;
	
	private String regOptHeight;
	private String regOptWeight;
	private String regOptBloodType;
	private String regOptAsa01;
	
	private String documentStateResult;

	private String anesthesiaDoctorsResult;
	private String anesthesiaDoctorType;
	private String anesthesiaDoctorName;
	private String operationDoctorName;
	private String tourNurseType;
	private String tourNurseName;
	private String instrumentNurseType;
	private String instrumentNurseName;
	private String mpyCode;
	private String vitalSignResult;
	private String hospitalCode;
	private String roomCode;
	private String collectItemsListResult;
	private String outputLiquidResult;
	private String optStartTimeResult;
	
	private Integer medicineId;
	private String smMedicineResult;
	private String smInPutIdResult;

	
	
	
	
	private String info;
	private List<SmIoDefination> liquidsOutList;
	//private List<SmIoEvent> smIoEventList;
	private String itemCode;
	
	private String title;
	private String content;
	private String time;
	private String id;
	private String breathFlag;

	/**
	 * @方法名称: loadAnesthesiaRecord
	 * @功能描述: 医疗文书跳转到麻醉记录
	 * @作者:崔连瑞
	 * @创建时间:2016-3-2 10:36:04
	 * @param ylwsid
	 * @return String
	 */
	
	public String loadAnesthesiaRecord(){
		sro = anesthesiaRecordService.loadAnesthesiaRecordMainView(ylwsid);
		smard = anesthesiaRecordService.getSmAnaesRecordByoperationId(ylwsid);  
		smdList = anesthesiaRecordService.getSmMedicineAllList();
		smtwList = anesthesiaRecordService.getSmMedicalTakeWayAllList();
		smbtiList = anesthesiaRecordService.getSmBloodtypeItemList();
		return SUCCESS;
	}

	/**
	* @方法名称: getVitalSignFromMachine
	* @功能描述: 从监护仪获取患者生命体征信息
	* @作者:崔连瑞
	* @创建时间:2016-3-2 10:36:04
	* @return String
	*/
	public String getVitalSignFromMachine(){
		//String[] s = {"341","506","507","504","505","521","523","522","561","508","503","541","562","581","321","322"};
		//new MachineSocket("192.168.1.33",4601,operationId,hospitalCode,roomCode,anesthesiaRecordService);
		new MachineSocket("127.0.0.1",20006,operationId,hospitalCode,roomCode,anesthesiaRecordService);
		return SUCCESS;

	
	}
	//采集项
			String[] collectItems1 = {"BPDIA","BPSYS","RR","HR"};
   /**
	* @方法名称: getCollectItems
	* @功能描述: 获得体征信息
	* @作者:崔连瑞
	* @创建时间:2016-3-2 10:36:04
	* @param ylwsid
	* @return String
	*/
	public String getCollectItems(){
			Map<String,Map<String,Double>> collectItem = new HashMap<String, Map<String, Double>>();
			try {
			SmAnaesRecord anaesRecord = anesthesiaRecordService.getSmAnaesRecordByoperationId(operationId);  
			//List<Date> times = anesthesiaRecordService.getTimesByOptId(operationId,"","");

			Long  l = (new Date().getTime() - anaesRecord.getOptStartTime().getTime()) / (anaesRecord.getRemarkInterval() * 60 *1000);
			System.out.println("--------------"+l);
			//int  col = OAMSUtils.minutesOfBetweenTwoDates(new Date(), anaesRecord.getOptStartTime()) / anaesRecord.getRemarkInterval();
			int  col = l.intValue();
			System.out.println("==============="+col);
				for (int i = 0; i < collectItems1.length; i++) {
					Map<String,Double> collectPoint = new HashMap<String, Double>();
					//Date time = OAMSUtils.getDateByDateGroups(times , new Date());
					SmRemarkPoint remarkPoint = anesthesiaRecordService.collectItemsPointByOptId(operationId,collectItems1[i],"",roomCode ,new Date());
					Double startY = this.collectDrawToolY(remarkPoint.getItemCode(), remarkPoint.getValue());
					collectPoint.put("startX",(double)col*OAMSUtils.ROW_SPACE+OAMSUtils.ROW_SPACE);
					collectPoint.put("startY",startY);
					collectItem.put(remarkPoint.getItemCode(), collectPoint);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			JSONObject jsonObject = JSONObject.fromObject(collectItem); 
			this.collectItemsResult=jsonObject.toString();
			return SUCCESS;
		}
	
	public Double collectDrawToolY(String itemCode,Double value){
		Double startTopNumber = 300D;

		if(collectItems1[0].equals(itemCode)){
			Double pointY = (startTopNumber-value)*1.5;
			return pointY;
		}
		if(collectItems1[1].equals(itemCode)){
			Double pointY = (startTopNumber-value)*1.5;
			return pointY;
		}
		if(collectItems1[2].equals(itemCode)){
			Double pointY = (startTopNumber-value)*1.5;
			return pointY;
		}
		if(collectItems1[3].equals(itemCode)){
			Double pointY = (startTopNumber-value)*1.5;
			return pointY;
		}
		return 0d;
	}


	
	
	
	/**
	 * @方法名称: addStartRecordTime
	 * @功能描述: 添加开始采集时间
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String addStartRecordTime(){
		SmAnaesRecord smar = anesthesiaRecordService.getSmAnaesRecordByoperationId(operationId); 
		if(smar!=null){
			smar.setRecordStartTime(new Date());
			try {
				anesthesiaRecordService.updateSmAnaesRecord(smar);
				info = "添加成功";
			} catch (Exception e) {
				info = "添加失败";
				e.printStackTrace();
			}
		}
		
		return SUCCESS;
	}
	
	
	
	
	/**
	 * @方法名称: loadMedicineList
	 * @功能描述: 加载麻醉用药
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String updateStopRecordTime(){
		SmAnaesRecord smar = anesthesiaRecordService.getSmAnaesRecordByoperationId(operationId); 
		if(smar!=null){
			smar.setRecordEndTime(new Date());
			try {
				anesthesiaRecordService.updateSmAnaesRecord(smar);
				info = "保存成功";
			} catch (Exception e) {
				info = "保存失败";
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	/**
	 * @方法名称: updateStopTime
	 * @功能描述: 添加手术结束时间
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String updateStopTime(){
		SmAnaesRecord smar = anesthesiaRecordService.getSmAnaesRecordByoperationId(operationId); 
		if(smar!=null){
			smar.setOptEndTime(OAMSUtils.getStringToDate(operationEndtime,OAMSUtils.DATETIME_PATTERN_LINE));
			try {
				anesthesiaRecordService.updateSmAnaesRecord(smar);
				info = "保存成功";
			} catch (Exception e) {
				info = "保存失败";
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	/**
	 * @方法名称: getOptStartTime
	 * @功能描述: 获取手术开始时间
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String getOptStartTime(){
		SmAnaesRecord smar = anesthesiaRecordService.getSmAnaesRecordByoperationId(operationId); 
		Map<String, Object> m = new HashMap<String, Object>();
		if(smar!=null){
			m.put("opt_start_time", OAMSUtils.getDateFormatString(smar.getOptStartTime(),OAMSUtils.DATETIME_PATTERN_LINE) );   
			m.put("interval", smar.getRemarkInterval()); 
		}
		JSONObject jsonObject = JSONObject.fromObject(m); 
		this.optStartTimeResult=jsonObject.toString();
		return SUCCESS;
	}
	
	/**
	 * @方法名称: updateRegOptToStart
	 * @功能描述: 修改手术状态到术中
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String updateRegOptToStart() {
		SmRegOpt sroOld = anesthesiaRecordService
				.loadAnesthesiaRecordMainView(operationId);
		if (sroOld != null) {
			sroOld.setState(START_OPERATION);
			try {
				anesthesiaRecordService.updateSmRegOpt(sroOld);
				info = "修改成功";
			} catch (Exception e) {
				info = "修改失败";
				e.printStackTrace();
			}
		}

		return SUCCESS;
	}
	
	/**
	 * @方法名称: updateRegOptToEnd
	 * @功能描述: 修改手术状态到术后
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String updateRegOptToEnd() {
		SmRegOpt sroOld = anesthesiaRecordService
				.loadAnesthesiaRecordMainView(operationId);
		if (sroOld != null) {
			sroOld.setState(END_OPERATION);
			try {
				anesthesiaRecordService.updateSmRegOpt(sroOld);
				info = "修改成功";
			} catch (Exception e) {
				info = "修改失败";
				e.printStackTrace();
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * @方法名称: saveOutPutEvent
	 * @功能描述: 保存出量
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param
	 * @return String
	 */
	public String saveOutPutEvent() {
		SmIoEvent o = anesthesiaRecordService.getSmIoEventById(
				outPutOperationId, outPutId);
		if (o != null) {
				o.setName(outPutName);
				o.setDosage(outPutDosage);
				o.setDosageUnit(outPutDosageUnit);
				o.setStartXpoint((new Double(outPutX)).doubleValue());
				o.setYpoint(Integer.parseInt(outPutY));
				try {
					anesthesiaRecordService.updateSmIoEvent(o);
				} catch (Exception e) {
					e.printStackTrace();
				}
		} else {
			SmIoEvent outE = new SmIoEvent();
			outE.setOperationId(outPutOperationId);
			outE.setName(outPutName);
			outE.setItemId(outPutId);
			outE.setDosage(outPutDosage);
			outE.setDosageUnit(outPutDosageUnit);
			outE.setType("0");
			outE.setEnable("0");
			outE.setStartXpoint((new Double(outPutX)).doubleValue());
			outE.setYpoint(Integer.parseInt(outPutY));
			try {
				anesthesiaRecordService.addSmIoEvent(outE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}

	/**
	 * @方法名称: returnOutPutData
	 * @功能描述: 保存返回出量ID
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param
	 * @return String
	 */
	public String returnOutPutData() {
		List<SmIoEvent> list = anesthesiaRecordService
				.getSmIoEventListByOperationId(outPutOperationId,"0");
		Map< String , String > m = new HashMap< String , String >();
		for (int i = 0; i < list.size(); i++) {
			if (outPutY.equals(list.get(i).getYpoint().toString())) {
				m.put("OID", list.get(i).getId().toString());
				m.put("OY", list.get(i).getYpoint().toString());
				JSONObject jsonObject = JSONObject.fromObject(m); 
				this.smIoEventListResult=jsonObject.toString();
			}
		}

		return SUCCESS;
	}
	/**
	 * @方法名称: getOutPutEvents
	 * @功能描述: 加载出量
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param
	 * @return String
	 */
	public String getOutPutEvents(){
		List<SmIoEvent> list = anesthesiaRecordService.getSmIoEventListByOperationId(operationId,"0");
		JSONArray jsonArray = JSONArray.fromObject(list);
		this.smIoEventListResult=jsonArray.toString();
		return SUCCESS;
	}
	/**
	 * @方法名称: deleteOutPutEvent
	 * @功能描述: 删除出量
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param
	 * @return String
	 */
	public String deleteOutPutEvent(){
		SmIoEvent o = anesthesiaRecordService.getSmIoEventById(Integer.parseInt(outPutDataId));
		if(o!=null){
			o.setEnable("1");
			try {
				anesthesiaRecordService.updateSmIoEvent(o);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	/**
	 * @方法名称: saveInPutEvent
	 * @功能描述: 保存入量
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param
	 * @return String
	 */
	public String saveInPutEvent(){
		SmIoEvent iup = anesthesiaRecordService.getSmIoEventById(
				inPutOperationId, inPutId);
		if(iup != null){
			iup.setName(inPutName);
			iup.setDosage(inPutDosage);
			iup.setDosageUnit(inPutDosageUnit);
			iup.setStartXpoint((new Double(inPutStartX)).doubleValue());
			iup.setYpoint(Integer.parseInt(inPutStartY));
			if("1".equals(inPutEnded)){
				iup.setEndXpoint((new Double(inPutEndX)).doubleValue());
			}
			iup.setFirm(inPutFirm);
			iup.setSpec(inPutSpec);
			iup.setEnable("0");
			try {
				anesthesiaRecordService.updateSmIoEvent(iup);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			SmIoEvent inE = new SmIoEvent();
			inE.setOperationId(inPutOperationId);
			inE.setName(inPutName);
			inE.setItemId(inPutId);
			inE.setDosage(inPutDosage);
			inE.setDosageUnit(inPutDosageUnit);
			inE.setStartXpoint((new Double(inPutStartX)).doubleValue());
			inE.setYpoint(Integer.parseInt(inPutStartY));
			inE.setEndXpoint((new Double(inPutEndX)).doubleValue());
			inE.setFirm(inPutFirm);
			inE.setSpec(inPutSpec);
			inE.setEnable("0");
			inE.setType("1");
			try {
				anesthesiaRecordService.addSmIoEvent(inE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	
	/**
	 * @方法名称: returnInPutData
	 * @功能描述: 保存返回出量ID
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param
	 * @return String
	 */
	public String returnInPutData() {
		List<SmIoEvent> list = anesthesiaRecordService
				.getSmIoEventListByOperationId(inPutOperationId,"1");
		Map< String , String > m = new HashMap< String , String >();
		for (int i = 0; i < list.size(); i++) {
			if (inPutStartY.equals(list.get(i).getYpoint().toString())) {
				m.put("IID", list.get(i).getId().toString());
				m.put("IY", list.get(i).getYpoint().toString());
				JSONObject jsonObject = JSONObject.fromObject(m); 
				this.smIoEventListResult=jsonObject.toString();
			}
		}

		return SUCCESS;
	}
	
	/**
	 * @方法名称: getInPutEvents
	 * @功能描述: 加载入量
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param
	 * @return String
	 */
	public String getInPutEvents(){
		List<SmIoEvent> list = anesthesiaRecordService.getSmIoEventListByOperationId(operationId,"1");
		JSONArray jsonArray = JSONArray.fromObject(list);
		this.smIoEventListResult=jsonArray.toString();
		return SUCCESS;
	}
	/**
	 * @方法名称: deleteInPutEvent
	 * @功能描述: 删除入量
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param
	 * @return String
	 */
	public String deleteInPutEvent(){
		SmIoEvent o = anesthesiaRecordService.getSmIoEventById(Integer.parseInt(inPutDataId));
		if(o!=null){
			o.setEnable("1");
			try {
				anesthesiaRecordService.updateSmIoEvent(o);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	/**
	 * @方法名称: saveMedEvent
	 * @功能描述: 保存麻醉用药
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param
	 * @return String
	 */
	public String saveMedEvent(){
		SmMedicalEvent smeOld = anesthesiaRecordService.getSmMedicalEventByOptIdAndMedCode(medOperationId, medId);
		if(smeOld!=null){
			smeOld.setStartXpoint((new Double(medStartX)).doubleValue());
			smeOld.setEndXpoint((new Double(medEndX)).doubleValue());
			smeOld.setYpoint(Integer.parseInt(medSY));
			smeOld.setEnded(medIsEnded);
			try {
				anesthesiaRecordService.updateSmMedicalEvent(smeOld);
				info = "添加成功";
			} catch (Exception e) {
				info = "添加失败";
				e.printStackTrace();
			}
		}else{
			SmMedicalEvent sme = new SmMedicalEvent();	
			sme.setOperationId(medOperationId);
			sme.setCardinalEventId(0);
			sme.setSpec(medSpec);
			sme.setDosage((new Double(medDosage)).doubleValue());
			sme.setDosageUnit(medDosageUnit);
			sme.setFlow((new Double(medSpeed)).doubleValue());
			sme.setFlowUnit(medSpeedUnit);
			sme.setTakewayCode(medTakewayCode);
			sme.setDurable(medIsContinued);
			sme.setReason(medReason);
			sme.setUsemedicineEventId(medReasonSelect);
			sme.setMedicineCode(medId);
			sme.setMedicineName(medName);
			sme.setMedicineFirm(medFirm);
			sme.setEnable(IS_ENABLE);
			sme.setStartXpoint((new Double(medStartX)).doubleValue());
			if("1".equals(medIsContinued)){
				sme.setEndXpoint((new Double(medEndX)).doubleValue());
			}
			sme.setYpoint(Integer.parseInt(medSY));
			sme.setEnded(medIsEnded);
			try {
				anesthesiaRecordService.addSmMedicalEvent(sme);
				info = "添加成功";
			} catch (Exception e) {
				info = "添加失败";
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	/**
	 * @方法名称: getMedEvents
	 * @功能描述: 加载麻醉用药
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param
	 * @return String
	 */
	public String getMedEvents(){
		List<SmMedicalEvent> list = anesthesiaRecordService.getSmMedicalEventListByOperationId(operationId);
		JSONArray jsonArray = JSONArray.fromObject(list);
		this.smMedicalEventListResult=jsonArray.toString();
		return SUCCESS;
	}
	/**
	 * @方法名称: deleteMedEventa
	 * @功能描述: 删除麻醉用药
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param
	 * @return String
	 */
	public String deleteMedEventa(){
		SmMedicalEvent smeOld = anesthesiaRecordService.getMedEventById(Integer.parseInt(medId));
		if(smeOld!=null){
			smeOld.setEnable(NOT_ENABLE);
			try {
				anesthesiaRecordService.updateSmMedicalEvent(smeOld);
				info = "添加成功";
			} catch (Exception e) {
				info = "添加失败";
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	/**
	 * @方法名称: getOutputLiquid
	 * @功能描述: 加载出量
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String getOutputLiquid() {
		List<SmIoDefination> outlist = anesthesiaRecordService
				.getSmIoDefinationList();
		List<Map<String , String>> l =  new ArrayList<Map<String , String>>();
		if(outlist!=null){
			for (int i = 0; i < outlist.size(); i++) {
				Map<String , String> m = new HashMap<String , String>();
				SmIoDefination so =  outlist.get(i);
				m.put("ID", so.getId().toString());
				m.put("NAME", so.getName());
				l.add(m);
			}
			JSONArray jsonArray = JSONArray.fromObject(l);
			this.outputLiquidResult = jsonArray.toString();
		}
		return SUCCESS;
	}
	
	/**
	 * @方法名称: getInChildNamesBySubType
	 * @功能描述: 
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String getInChildNamesBySubType(){
		List<SmIoDefination> liquidsInChildNamesList = anesthesiaRecordService.getInChildNamesBySubType(liquidsInSubType);
		JSONArray jsonArray = JSONArray.fromObject(liquidsInChildNamesList);
		this.inChildNamesResult=jsonArray.toString();
		return SUCCESS;
	}
	
	/**
	 * @方法名称: getInChildNamesBySubType
	 * @功能描述: 
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String getSmAnaesEventItems(){
		List<SmAnaesEventItems> saeiList = anesthesiaRecordService.getSmAnaesEventItemsList();
		JSONArray jsonArray = JSONArray.fromObject(saeiList);
		this.smAnaesEventItemsResult=jsonArray.toString();
		return SUCCESS;
	}
	
	/**
	 * @方法名称: getAnaeEventItem
	 * @功能描述: 
	 * @作者:崔连瑞
	 * @创建时间:2016-3-10 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String getAnaeEventItem(){
		SmAnaesEventItems aei = anesthesiaRecordService.getSmAnaesEventItem(anaesCode);
		Map<String , String> m = new HashMap<String , String>();
		m.put("id", aei.getId().toString());
		m.put("code", aei.getCode());
		m.put("name", aei.getName());
		m.put("graphElements", aei.getGraphElements());
		m.put("graphCode", aei.getGraphCode());
		m.put("color", aei.getColor());
		m.put("isCustom", aei.getIsCustom());
		
		JSONObject jsonObject = JSONObject.fromObject(m); 
		this.smAnaesEventsResult=jsonObject.toString();
		return SUCCESS;
	}
	/**
	 * @方法名称: saveAnesthEvent
	 * @功能描述: 添加与修改麻醉事件
	 * @作者:崔连瑞
	 * @创建时间:2016-3-31 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String saveAnesthEvent(){
		SmAnaesEvent saeOld = anesthesiaRecordService.getSmAnesEventByOptIdAndCode(operationId, eventItemCode);
		SmAnaesRecord smar = anesthesiaRecordService.getSmAnaesRecordByoperationId(operationId);
		long startTimes = smar.getOptStartTime().getTime();
		long difference =  (long) ((((new Double(anesthEventX)).doubleValue()*smar.getRemarkInterval())/15)*60*1000);
		if(saeOld!=null){
			saeOld.setXpoint((new Double(anesthEventX)).doubleValue());
			saeOld.setOccurtime(OAMSUtils.millisecondToDate (startTimes+difference,OAMSUtils.DATETIME_PATTERN_SLASH));
			
			try {
				
				anesthesiaRecordService.updateSmAnesthesiaEvent(saeOld);
				info = "添加成功";
			} catch (Exception e) {
				info = "添加失败";
				e.printStackTrace();
			}
		}else{
			SmAnaesEvent saes = new SmAnaesEvent();	
			saes.setCode(eventItemCode);
			saes.setXpoint((new Double(anesthEventX)).doubleValue());
			saes.setOccurtime(OAMSUtils.millisecondToDate (startTimes+difference,OAMSUtils.DATETIME_PATTERN_SLASH));
			saes.setOperationId(operationId);
			saes.setEnable(IS_ENABLE);
			try {
				anesthesiaRecordService.addSmAnesthesiaEvent(saes);
				info = "添加成功";
			} catch (Exception e) {
				info = "添加失败";
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	/**
	 * @方法名称: anesthesiaEventSave
	 * @功能描述: 添加麻醉记录单中手术开始时间、手术结束时间、麻醉开始时间、麻醉结束时间
	 * @作者:崔连瑞
	 * @创建时间:2016-3-31 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String updateAnaesRecordSomething(){
		List<SmAnaesEvent> saeList = anesthesiaRecordService.getSmAnesEventByOptId(operationId);
		SmAnaesRecord smar = anesthesiaRecordService.getSmAnaesRecordByoperationId(operationId);
		if(saeList!=null){
			for (Iterator<SmAnaesEvent> iterator = saeList.iterator(); iterator.hasNext();) {
				SmAnaesEvent smAnaesEvent = (SmAnaesEvent) iterator.next();
				if(smar!=null){
					if("ANAES_START_EVENT".equals(smAnaesEvent.getCode().trim())){
						smar.setAnaesStartTime(smAnaesEvent.getOccurtime());
					}
					if("OPERATION_START_EVENT".equals(smAnaesEvent.getCode().trim())){
						smar.setOptStartTime(smAnaesEvent.getOccurtime());
					}
					if("OPERATION_END_EVENT".equals(smAnaesEvent.getCode().trim())){
						smar.setOptEndTime(smAnaesEvent.getOccurtime());
					}
					if("ANAES_END_EVENT".equals(smAnaesEvent.getCode().trim())){
						smar.setAnaesEndTime(smAnaesEvent.getOccurtime());
					}
					try {
						anesthesiaRecordService.updateSmAnaesRecord(smar);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return SUCCESS;
	}
	/**
	 * @方法名称: getSmAnesthesiaEventList
	 * @功能描述: 获得麻醉事件
	 * @作者:崔连瑞
	 * @创建时间:2016-3-31 上午9:36:04
	 * @param  
	 * @return String
	 * 
	 * 
	 */
	public String getSmAnesthesiaEventsList() throws ParseException {
		List<SmAnaesEvent> saeList = anesthesiaRecordService.getSmAnesthesiaEventsListByOptId(operationId);
		List<SmAnaesEventItems> saeiList = anesthesiaRecordService.getSmAnaesEventItemsList();
		List<Map<String , String >> saet = new ArrayList<Map<String , String >>();
		for(int i = 0; i < saeList.size(); i++){
			for (int j = 0; j < saeiList.size(); j++) {
				Map<String , String > m = new HashMap<String , String >();
				if(saeiList.get(j).getCode().equals(saeList.get(i).getCode())){
					m.put("anesthEventX", saeList.get(i).getXpoint().toString());
					m.put("eventItemCode", saeiList.get(j).getCode());
					m.put("graphElements", saeiList.get(j).getGraphElements());
					m.put("graphCode", saeiList.get(j).getGraphCode());
					m.put("eventName", saeiList.get(j).getName());
					saet.add(m);
				}
			}
		}

		JSONArray jsonArray = JSONArray.fromObject(saet);
		this.smAnaesEventsResult = jsonArray.toString();
		return SUCCESS;
	}
	
	
	
	/**
	 * @方法名称: yyyyMMddToStr
	 * @功能描述: yyyy-MM-dd 转String 类型
	 * @作者:崔连瑞
	 * @创建时间:2016-3-31 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String yyyyMMddToStr(Date date){
		String str = "";
		try {			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			str=sdf.format(date);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * @方法名称: StringYyyyMMddHHmmssToLong
	 * @功能描述: String 类型 yyyy-MM-dd HH:mm:ss 转long型时间戳 
	 * @作者:崔连瑞
	 * @创建时间:2016-3-31 上午9:36:04
	 * @param  
	 * @return Long
	 */
	 public Long StringYyyyMMddHHmmssToLong(String time){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = null;
			try {
				date = sdf.parse(time);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
		 return date.getTime();
	 }
	
	
	/**
	 * @方法名称: updateStartTimeToRegOpt
	 * @功能描述: 更新病人手术信息
	 * @作者:崔连瑞
	 * @创建时间:2016-3-31 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String updateToSmRegOpt() throws ParseException{
			sro = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
			try {
			 DateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd");
			 String[] dates = startTime.split(",");
			 Date operdate = dt1.parse(dates[0]);
			 sro.setOperdate(operdate);
	         sro.setStarttime(dates[1]);
	         sro.setState(START_OPERATION);
		
			anesthesiaRecordService.updateSmRegOpt(sro);
			info = "修改成功";
		} catch (Exception e) {
			info = "修改失败";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * @方法名称: stringToDate
	 * @功能描述: 字符串转date
	 * @作者:崔连瑞
	 * @创建时间:2016-3-31 上午9:36:04
	 * @param  String date  
	 * @return Date
	 */
	public static Date stringToDate(String date){
		Date result =null;
		   try {
			   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			   result = sdf.parse(date); 
		       } catch (Exception e) {
			         e.printStackTrace();
		            }
		 return result;
	} 
	

	/**
	 * @方法名称: anesthesiaEventSave
	 * @功能描述: 添加麻醉记录单
	 * @作者:崔连瑞
	 * @创建时间:2016-3-31 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String addSmAnaesRecord(){
		SmAnaesRecord smar = anesthesiaRecordService.getSmAnaesRecordByoperationId(operationId);  
		if(smar!=null){
			
			try {
				anesthesiaRecordService.updateSmAnaesRecord(smar);
				info = "添加成功";
			} catch (Exception e) {
				info = "添加失败";
				e.printStackTrace();
			}
		}else{
			SmAnaesRecord sar = new SmAnaesRecord();	
			   sar.setOperationId(operationId);
			   sar.setDocId(ylwsid);
			   sar.setOwnerId(userId);
			   sar.setCreateTime(new Date());
		       Date date = stringToDate(startTime); 
			   sar.setOptStartTime(date);
			   sar.setRemarkInterval(Integer.parseInt(collectIntervals));
			   sar.setEnable(IS_ENABLE);

			   try {
				anesthesiaRecordService.addSmAnaesRecord(sar);
				info = "添加成功";
			} catch (Exception e) {
				info = "添加失败";
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	/**
	 * @方法名称: deleteSmAnesEvent
	 * @功能描述: 删除麻醉事件
	 * @作者:崔连瑞
	 * @创建时间:2016-3-31 上午9:36:04
	 * @param  
	 * @return String
	 */
	public String deleteSmAnesEvent(){
		SmAnaesEvent saeOld = anesthesiaRecordService.getSmAnesEventByOptIdAndCode(operationId, eventItemCode);
		if(saeOld != null){
			saeOld.setEnable(NOT_ENABLE);
			try {
				anesthesiaRecordService.updateSmAnesthesiaEvent(saeOld);
				info = "添加成功";
			} catch (Exception e) {
				info = "添加失败";
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	
	/**
	 * @方法名称: saveMonitorSign
	 * @功能描述: 保存采集项
	 * @作者:崔连瑞
	 * @创建时间:2016-4-19 下午7:36:04 
	 */
	
	public String saveMonitorSign(){
		Map< String , Double > hollowCircleMap = new HashMap< String , Double >();
		Map< String , Double > solidCircleMap = new HashMap< String , Double >();
		Map< String , Double > downTriangleMap = new HashMap< String , Double >();
		Map< String , Double > upTriangleMap = new HashMap< String , Double >();
		List<Integer> firstx = new ArrayList<Integer>();
		List<Integer> lastx = new ArrayList<Integer>();
		int minPontx = -1 ;
		int maxPontx = -1 ;
		
		if(!"".equals(hollowCircles)&&null!=hollowCircles){
			firstx.add(Integer.parseInt(hollowCircles.split(",")[0].split(":")[0]));
			lastx.add(Integer.parseInt(hollowCircles.split(",")[hollowCircles.split(",").length-1].split(":")[0]));
		}
		if(!"".equals(solidCircles)&&null!=solidCircles){
			firstx.add(Integer.parseInt(solidCircles.split(",")[0].split(":")[0]));
			lastx.add(Integer.parseInt(solidCircles.split(",")[solidCircles.split(",").length-1].split(":")[0]));
		}
		if(!"".equals(downTriangles)&&null!=downTriangles){
			firstx.add(Integer.parseInt(downTriangles.split(",")[0].split(":")[0]));
			lastx.add(Integer.parseInt(downTriangles.split(",")[downTriangles.split(",").length-1].split(":")[0]));
		}
		if(!"".equals(upTriangles)&&null!=upTriangles){
			firstx.add(Integer.parseInt(upTriangles.split(",")[0].split(":")[0]));
			lastx.add(Integer.parseInt(upTriangles.split(",")[upTriangles.split(",").length-1].split(":")[0]));
		}
		
		if(!"".equals(hollowCircles)&&null!=hollowCircles){
			String[] hollowCircle = hollowCircles.split(",");
			for (int i = 0; i < hollowCircle.length; i++) {
				hollowCircleMap.put(hollowCircle[i].split(":")[0], (new Double(hollowCircle[i].split(":")[1])).doubleValue());
			}
		}
		if(!"".equals(solidCircles)&&null!=solidCircles){
			String[] solidCircle =  solidCircles.split(",");
			for (int i = 0; i < solidCircle.length; i++) {
				solidCircleMap.put(solidCircle[i].split(":")[0], (new Double(solidCircle[i].split(":")[1])).doubleValue());
			}
		}
		if(!"".equals(downTriangles)&&null!=downTriangles){
			String[] downTriangle =  downTriangles.split(",");
			for (int i = 0; i < downTriangle.length; i++) {
				downTriangleMap.put(downTriangle[i].split(":")[0], (new Double(downTriangle[i].split(":")[1])).doubleValue());
			}
		}
		if(!"".equals(upTriangles)&&null!=upTriangles){
			String[] upTriangle =  upTriangles.split(",");
			for (int i = 0; i < upTriangle.length; i++) {
				upTriangleMap.put(upTriangle[i].split(":")[0], (new Double(upTriangle[i].split(":")[1])).doubleValue());
			}
		}
		
		if(firstx != null){
			minPontx = OAMSUtils.getMin(firstx);
		}
		if(lastx != null){
			maxPontx = OAMSUtils.getMax(lastx);
		}
		 
		if (minPontx >= 0 && maxPontx >= 0) {
			for (int i = minPontx; i <= maxPontx; i += 15) {
				SmWaveData smwdOld = anesthesiaRecordService
						.getMonitoringSignByOperationIdAndTime(operationId, i);
				if (smwdOld != null) {
					smwdOld.setOperationId(operationId);
					smwdOld.setResprate(hollowCircleMap.get(i + ""));
					smwdOld.setPulserate(solidCircleMap.get(i + ""));
					smwdOld.setBpSys(downTriangleMap.get(i + ""));
					smwdOld.setBpDias(upTriangleMap.get(i + ""));
					try {
						anesthesiaRecordService.updateMonitoringSign(smwdOld);
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					SmWaveData swava = new SmWaveData();
					swava.setOperationId(operationId);
					swava.setXpoint(i);
					swava.setResprate(hollowCircleMap.get(i + ""));
					swava.setPulserate(solidCircleMap.get(i + ""));
					swava.setBpSys(downTriangleMap.get(i + ""));
					swava.setBpDias(upTriangleMap.get(i + ""));
					try {
						anesthesiaRecordService.addMonitoringSign(swava);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}
		return SUCCESS;
	}
	
	/**
	 * @方法名称: getWaveDataByDocId
	 * @功能描述: 获取采集项List BY 手术ID
	 * @作者:崔连瑞
	 * @创建时间:2016-4-12 上午9:36:04
	 * @param  operationId
	 * @return String
	 */
	public String getWaveDataByDocId(){
		List<SmWaveData> l = anesthesiaRecordService.getMonitoringSignListByOperationId(operationId);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < l.size(); i++) {
			Map<String,String> MonitoringSignsMap = new HashMap<String, String>();
			MonitoringSignsMap.put("moniSignX", l.get(i).getXpoint()+"");
			MonitoringSignsMap.put("Resprate", l.get(i).getResprate()+"");
			MonitoringSignsMap.put("Pulserate", l.get(i).getPulserate()+"");
			MonitoringSignsMap.put("BpSys", l.get(i).getBpSys()+"");
			MonitoringSignsMap.put("BpDias", l.get(i).getBpDias()+"");
			MonitoringSignsMap.put("BpMean", l.get(i).getBpMean()+"");
			MonitoringSignsMap.put("Heartrate", l.get(i).getHeartrate()+"");
			MonitoringSignsMap.put("Temp", l.get(i).getTemp()+"");
			MonitoringSignsMap.put("Vtidalvol", l.get(i).getVtidalvol()+"");
			MonitoringSignsMap.put("Petco2", l.get(i).getPetco2()+"");
			MonitoringSignsMap.put("IbpwCv", l.get(i).getIbpwCv()+"");
			MonitoringSignsMap.put("Bloodpres", l.get(i).getBloodpres()+"");
			MonitoringSignsMap.put("Spo2", l.get(i).getSpo2()+"");
			MonitoringSignsMap.put("OperationId", l.get(i).getOperationId());
			list.add(MonitoringSignsMap);
		}
		JSONArray jsonArray = JSONArray.fromObject(list);
		this.smMonitoringSignResult=jsonArray.toString();
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @Title: loadAnesthesiaRecordPrint 
	 * @Description: 获取打印数据
	 * @author 崔连瑞
	 * @date 2016-4-24 下午5:58:41
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void loadAnesthesiaRecordPrint() {
		String id = request.getParameter("id");
		try {
			
			List<Map<String, Object>> result = anesthesiaRecordService.getAnesthesiaRecordWeekPrint(id);
		
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			PrintWriter out = response.getWriter();
			out.print(XmlUtil.xmlAssemble(result,result));
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * 
	 * @Title: saveOperationEvent 
	 * @Description: 添加修改手术事件
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param 
	 * @return void
	 * @throws   .getOperationEventById(operationEventId);
	 *
	 */
	public String saveOperationEvent() throws ParseException{
		
		if(null!=operationEvent.getId()&&!"".equals(operationEvent.getId())){
			SmOperationEvent operationEventOld = anesthesiaRecordService.getOperationEventById(operationEvent.getId()+"");
			operationEventOld.setTime(operationEvent.getTime());
			operationEventOld.setTitle(operationEvent.getTitle());
			operationEventOld.setContent(operationEvent.getContent());
			
			try {
				anesthesiaRecordService.updateOperationEvent(operationEventOld);
				info="添加成功";
			} catch (Exception e) {
				e.printStackTrace();
				info="添加失败";
			}
		}else{
			operationEvent.setEnable(IS_ENABLE);
			try {
				anesthesiaRecordService.addOperationEvent(operationEvent);
				info="添加成功";
			} catch (Exception e) {
				e.printStackTrace();
				info="添加失败";
			}
		}
		operationId=operationEvent.getOperationId();
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: getOperationEventListByoperationId 
	 * @Description: 获取手术事件
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param operationId
	 * @return String
	 * @throws 
	 *
	 */
	public String getOperationEventListByoperationId() throws ParseException{
		List<SmOperationEvent> operationEventList = anesthesiaRecordService.getOperationEventByOperationId(operationId);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		int operationEventNum=1;
		for (Iterator<SmOperationEvent> iterator = operationEventList.iterator(); iterator.hasNext();) {
			Map<String,String> operationEventMap = new HashMap<String, String>();
			SmOperationEvent smOperationEvent = (SmOperationEvent) iterator.next();
			operationEventMap.put("num", operationEventNum+"");
			operationEventMap.put("id", smOperationEvent.getId()+"");
			operationEventMap.put("operationId", smOperationEvent.getOperationId());
			operationEventMap.put("title", smOperationEvent.getTitle());
			operationEventMap.put("content", smOperationEvent.getContent());
			String times = smOperationEvent.getTime().toString();
			String times1 = times.split(" ")[1].substring(0, 8);
			operationEventMap.put("time", times1);
			list.add(operationEventMap);
			operationEventNum++;
		}
		JSONArray jsonArray = JSONArray.fromObject(list);
		this.smOperationEventListResult=jsonArray.toString();
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * @Title: deleteOperationEvent 
	 * @Description: 删除手术事件
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param id
	 * @return String
	 * @throws 
	 *
	 */
	public String deleteOperationEvent() throws ParseException{
		SmOperationEvent operationEvent1 = anesthesiaRecordService.getOperationEventById(operationEventId);
		if(null!=operationEvent1){
			operationEvent1.setEnable(NOT_ENABLE);
			try {
				anesthesiaRecordService.updateOperationEvent(operationEvent1);
				info="删除成功";
			} catch (Exception e) {
				e.printStackTrace();
				info="删除失败";
			}
		}
		operationId=operationEvent1.getOperationId();
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * @Title: saveBreathEvent 
	 * @Description: 添加修改呼吸事件
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param 
	 * @return String
	 * @throws 
	 *
	 */
	public String saveBreathEvent() throws ParseException{
		if(null!=breathEvent.getId()&&!"".equals(breathEvent.getId())){
			SmBreathEvent breathEventOld = anesthesiaRecordService.getSmBreathEventById(breathEvent.getId()+"");
			breathEventOld.setStarttime(breathEvent.getStarttime());
			breathEventOld.setFlag(breathEvent.getFlag());
			try {
				anesthesiaRecordService.updateSmBreathEvent(breathEventOld);
				info="修改成功";
			} catch (Exception e) {
				e.printStackTrace();
				info="修改失败";
			}
		}else{
			breathEvent.setEnable(IS_ENABLE);
			try {
				anesthesiaRecordService.addSmBreathEvent(breathEvent);
				info="添加成功";
			} catch (Exception e) {
				e.printStackTrace();
				info="添加失败";
			}
		}
		operationId=breathEvent.getOperationId();
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * @Title: getBreathEventListByoperationId 
	 * @Description: 获取呼吸事件
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param operationId
	 * @return String
	 * @throws 
	 *
	 */
	public String getBreathEventListByoperationId() throws ParseException{
		List<SmBreathEvent> breathEventList = anesthesiaRecordService.getSmBreathEventByOperationId(operationId);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		int breathEventNum=1;
		for (Iterator<SmBreathEvent> iterator = breathEventList.iterator(); iterator.hasNext();) {
			Map<String,String> breathEventMap = new HashMap<String, String>();
			SmBreathEvent smBreathEvent = (SmBreathEvent) iterator.next();
			breathEventMap.put("breathEventNum", breathEventNum+"");
			breathEventMap.put("id", smBreathEvent.getId()+"");
			breathEventMap.put("operationId", smBreathEvent.getOperationId());
			if("01".equals(smBreathEvent.getFlag())){
				breathEventMap.put("flagText", "自主呼吸");	
			}
			if("02".equals(smBreathEvent.getFlag())){
				breathEventMap.put("flagText", "辅助呼吸");	
			}
			if("03".equals(smBreathEvent.getFlag())){
				breathEventMap.put("flagText", "控制呼吸");	
			}
			breathEventMap.put("flag", "控制呼吸");	
			String times = smBreathEvent.getStarttime().toString();
			String times1 = times.split(" ")[1].substring(0, 8);
			breathEventMap.put("starttime", times1);
			list.add(breathEventMap);
			breathEventNum++;
		}
		JSONArray jsonArray = JSONArray.fromObject(list);
		this.smBreathEventListResult=jsonArray.toString();
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * @Title: deleteBreathEvent 
	 * @Description: 删除呼吸事件
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param 
	 * @return String
	 * @throws 
	 *
	 */
	public String deleteBreathEvent() throws ParseException{
		SmBreathEvent breathEvent1 = anesthesiaRecordService.getSmBreathEventById(breathEventId);
		if(null!=breathEvent1){
			breathEvent1.setEnable(NOT_ENABLE);
			try {
				anesthesiaRecordService.updateSmBreathEvent(breathEvent1);
				info="删除成功";
			} catch (Exception e) {
				e.printStackTrace();
				info="删除失败";
			}
		}
		operationId=breathEvent1.getOperationId();
		return SUCCESS;
	}
	
	
	
	
	/**
	 * 
	 * @Title: getAnesthetistersListByoperationId 
	 * @Description: 获取麻醉人员
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param operationId
	 * @return String
	 * @throws 
	 *  
	 */
	public String getAnesthetistersListByoperationId() throws ParseException{
		SmRegOpt smropt = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
		Map<String,String> anesthetisterMap = new HashMap<String, String>();
		if(null!=smropt){
			if(null!=smropt.getAnesthetist()&&!"".equals(smropt.getAnesthetist())){
				anesthetisterMap.put("anesthetist", smropt.getAnesthetist());	
			}else{
				anesthetisterMap.put("anesthetist", "");	
			}
			if(null!=smropt.getCircuanesthetist()&&!"".equals(smropt.getCircuanesthetist())){
				anesthetisterMap.put("circuanesthetist", smropt.getCircuanesthetist());
			}else{
				anesthetisterMap.put("circuanesthetist", "");
			}
			if(null!=smropt.getAnaesAssistant()&&!"".equals(smropt.getAnaesAssistant())){
				anesthetisterMap.put("anaesassistant", smropt.getAnaesAssistant());
			}else{
				anesthetisterMap.put("anaesassistant", "");
			}
			JSONObject jsonObject = JSONObject.fromObject(anesthetisterMap); 
			this.anesthetisterResult=jsonObject.toString();
		}
		return SUCCESS;
	}
	
	

	
	 /**
	 * @方法名称: deleteAnesthetistersByoperationName
	 * @功能描述: 根据姓名修改麻醉人员
	 * @作者:付士山
	 * @创建时间:2016-6-17 下午1:48:45
	 * @return String   
	 */
	 
	public String deleteAnesthetistersByoperationName(){
		
		String hiddenName=request.getParameter("HiddenName").trim();
		SmRegOpt sross = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
		System.out.println(sross);
	    if (hiddenName.equals(sross.getAnaesAssistant())) {
			sross.setAnaesAssistant("");
			 anesthesiaRecordService.modAnesthetistersByoperationName(sross);
		} 
	    if(hiddenName.equals(sross.getAnesthetist())) {
	    	
	    	sross.setAnesthetist("");
	    	 anesthesiaRecordService.modAnesthetistersByoperationName(sross);
		}
	  if(hiddenName.equals(sross.getCircuanesthetist())) {
	    	sross.setCircuanesthetist("");
	    	 anesthesiaRecordService.modAnesthetistersByoperationName(sross);
		} 
	   
	    try {
			getAnesthetistersListByoperationId();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	 /**
		 * @方法名称: deleteAnesthetistersByoperationName
		 * @功能描述: 根据姓名修改手术人员
		 * @作者:付士山
		 * @创建时间:2016-6-17 下午1:48:45
		 * @return String   
		 */
		 
		public String deleteAnesthetistersByoperationName1(){
			
			String hiddenName=request.getParameter("HiddenName").trim();
			SmRegOpt sross = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
			System.out.println(sross);
		    if (hiddenName.equals(sross.getOperatorName())) {
				sross.setOperatorName("");
				 anesthesiaRecordService.modAnesthetistersByoperationName(sross);
			} 
		    if(hiddenName.equals(sross.getInstrnurse1())) {
		    	
		    	sross.setInstrnurse1("");
		    	 anesthesiaRecordService.modAnesthetistersByoperationName(sross);
			}
		  if(hiddenName.equals(sross.getInstrnurse2())) {
		    	sross.setInstrnurse2("");
		    	 anesthesiaRecordService.modAnesthetistersByoperationName(sross);
			} 
		  if(hiddenName.equals(sross.getCircunurse1())) {
		    	
		    	sross.setCircunurse1("");
		    	 anesthesiaRecordService.modAnesthetistersByoperationName(sross);
			}
		  if(hiddenName.equals(sross.getCircunurse2())) {
		    	sross.setCircunurse2("");
		    	 anesthesiaRecordService.modAnesthetistersByoperationName(sross);
			} 
		    try {
		    	getOperatorsByoperationId();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return SUCCESS;
		}
	
	
	 /**
	 * @方法名称: addAnesthetistersByRole
	 * @功能描述: 通过姓名添加麻醉人员
	 * @作者:付士山
	 * @创建时间:2016-6-22 下午3:00:50
	 */
	 
	public String addAnesthetistersByRole(){
		
		String yishiName=request.getParameter("yishiName").trim();
		SmRegOpt smropt = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
		if (smropt.getAnaesAssistant()==null&&smropt.getAnesthetist()==null&&smropt.getCircuanesthetist()==null) {
			return "";
		}
		
		if (smropt.getAnaesAssistant()==null&&yishiRole.equals("灌注医师")) {
			smropt.setAnaesAssistant(yishiName);	
			anesthesiaRecordService.modAnesthetistersByoperationName(smropt);
		}
		if (smropt.getAnesthetist()==null&&yishiRole.equals("手术麻醉医师")) {
			smropt.setAnesthetist(yishiName);
			System.out.println(yishiName);
			anesthesiaRecordService.modAnesthetistersByoperationName(smropt);
		}
		if (smropt.getCircuanesthetist()==null&&yishiRole.equals("巡台麻醉医师")) {
			smropt.setCircuanesthetist(yishiName);
			anesthesiaRecordService.modAnesthetistersByoperationName(smropt);	
		}

		 try {
				getAnesthetistersListByoperationId();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return SUCCESS;
	}
	
	 /**
		 * @方法名称: addAnesthetistersByRole1
		 * @功能描述: 通过姓名添加手术人员
		 * @作者:付士山
		 * @创建时间:2016-6-22 下午3:00:50
		 */
		 
		public String addAnesthetistersByRole1(){
			
			String yishiName=request.getParameter("yishiName").trim();
			SmRegOpt smropt = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
			if (yishiRole.equals("")) {
				return "";
			}
			
			if (smropt.getOperatorName()==null&&yishiRole.equals("手术医师")) {
				smropt.setOperatorName(yishiName);
				anesthesiaRecordService.modAnesthetistersByoperationName(smropt);
			}

			 try {
				 getOperatorsByoperationId();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			return SUCCESS;
		}
	
		/**
		 * @方法名称: addAnesthetistersByRole2
		 * @功能描述: 通过姓名添加手术护士
		 * @作者:付士山
		 * @创建时间:2016-6-22 下午3:00:50
		 */
		 
		public String addAnesthetistersByRole2(){
			
			String yishiName=request.getParameter("yishiName").trim();
			SmRegOpt smropt = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
			if (yishiRole.equals("")) {
				return "";
			}
			if (smropt.getInstrnurse1()==null&&yishiRole.equals("巡回护士")&&!yishiName.equals(smropt.getInstrnurse2())) {
				smropt.setInstrnurse1(yishiName);
				anesthesiaRecordService.modAnesthetistersByoperationName(smropt);
			}
			if (smropt.getInstrnurse2()==null&&yishiRole.equals("巡回护士")&&!yishiName.equals(smropt.getInstrnurse1())) {
				smropt.setInstrnurse2(yishiName);
				anesthesiaRecordService.modAnesthetistersByoperationName(smropt);
			}
			if (smropt.getCircunurse1()==null&&yishiRole.equals("器械护士")&&!yishiName.equals(smropt.getCircunurse2())) {
				smropt.setCircunurse1(yishiName);
				anesthesiaRecordService.modAnesthetistersByoperationName(smropt);
			}
			if (smropt.getCircunurse2()==null&&yishiRole.equals("器械护士")&&!yishiName.equals(smropt.getCircunurse1())) {
				smropt.setCircunurse2(yishiName);
				anesthesiaRecordService.modAnesthetistersByoperationName(smropt);
			}
			 try {
				 getOperatorsByoperationId();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			return SUCCESS;
		}
	
	/**
	 * 
	 * @Title: getOperatorsByoperationId 
	 * @Description: 获取手术人员
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param operationId
	 * @return String
	 * @throws 
	 *  
	 */
	public String getOperatorsByoperationId() throws ParseException{
		SmRegOpt smropt = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
		Map<String,String> operatorsMap = new HashMap<String, String>();
		if(null!=smropt){
			if(null!=smropt.getOperatorName()&&!"".equals(smropt.getOperatorName())){
				String[] opterNames = smropt.getOperatorName().split(",");
				int operatorNum=0;
				for (int i = 0; i < opterNames.length; i++) {
					operatorNum++;
					operatorsMap.put("operatorName"+operatorNum, opterNames[i]);	
				}
			}else{
				operatorsMap.put("operatorName", "");	
			}
			
			if(null!=smropt.getInstrnurse1()&&!"".equals(smropt.getInstrnurse1())){
				operatorsMap.put("instrnurse1", smropt.getInstrnurse1());
			}else{
				operatorsMap.put("instrnurse1", "");
			}
			
			if(null!=smropt.getInstrnurse2()&&!"".equals(smropt.getInstrnurse2())){
				operatorsMap.put("instrnurse2", smropt.getInstrnurse2());
			}else{
				operatorsMap.put("instrnurse2", "");
			}
			
			if(null!=smropt.getCircunurse1()&&!"".equals(smropt.getCircunurse1())){
				operatorsMap.put("circunurse1", smropt.getCircunurse1());
			}else{
				operatorsMap.put("circunurse1", "");
			}
			
			if(null!=smropt.getCircunurse2()&&!"".equals(smropt.getCircunurse2())){
				operatorsMap.put("circunurse2", smropt.getCircunurse2());
			}else{
				operatorsMap.put("circunurse2", "");
			}
			
			JSONObject jsonObject = JSONObject.fromObject(operatorsMap); 
			this.operatorsResult=jsonObject.toString();
		}
		return SUCCESS;
	}
	
	
	
	/**
	 * 
	 * @Title: saveBodyPosition 
	 * @Description: 添加修改体位
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param 
	 * @return String
	 * @throws 
	 *
	 */
	public String saveBodyPosition() throws ParseException{
		SmBodyPosition bodyPositionOld = anesthesiaRecordService.getSmBodyPositionByOperationId(operationId);
		
		if(null!=bodyPositionOld){
			bodyPositionOld.setItemValue(bodyPositionValues);
			String bodyPosNames =  bodyPositionValues;
			if(!"".equals(bodyPosNames)&&null!=bodyPosNames){
				bodyPosNames = bodyPosNames.replace("01", "仰卧位");
				bodyPosNames = bodyPosNames.replace("02", "俯卧位");
				bodyPosNames = bodyPosNames.replace("03", "左侧位");
				bodyPosNames = bodyPosNames.replace("04", "右侧位");
				bodyPosNames = bodyPosNames.replace("05", "结石位");
				bodyPosNames = bodyPosNames.replace("06", "坐位");
			}
			bodyPositionOld.setItemName(bodyPosNames);
			try {
				anesthesiaRecordService.updateSmBodyPosition(bodyPositionOld);
				info="修改成功";
			} catch (Exception e) {
				e.printStackTrace();
				info="修改失败";
			}
		}else{
			SmBodyPosition smbp = new SmBodyPosition();
			smbp.setOperationId(operationId);
			smbp.setItemValue(bodyPositionValues);
			String bodyPosNames =  bodyPositionValues;
			if(!"".equals(bodyPosNames)&&null!=bodyPosNames){
				bodyPosNames = bodyPosNames.replace("01", "仰卧位");
				bodyPosNames = bodyPosNames.replace("02", "俯卧位");
				bodyPosNames = bodyPosNames.replace("03", "左侧位");
				bodyPosNames = bodyPosNames.replace("04", "右侧位");
				bodyPosNames = bodyPosNames.replace("05", "结石位");
				bodyPosNames = bodyPosNames.replace("06", "坐位");
			}
			smbp.setItemName(bodyPosNames);
			smbp.setEnable(IS_ENABLE);
			try {
				anesthesiaRecordService.addSmBodyPosition(smbp);
				info="添加成功";
			} catch (Exception e) {
				e.printStackTrace();
				info="添加失败";
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: getBodyPositionByOptId 
	 * @Description: 获取体位信息
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param 
	 * @return String
	 * @throws 
	 *
	 */
	public String getBodyPositionByOptId() throws ParseException{
		SmBodyPosition bodyPositionOld = anesthesiaRecordService.getSmBodyPositionByOperationId(operationId);
		Map<String,String> bodyPositionMap = new HashMap<String, String>();
		if(null!=bodyPositionOld){
			bodyPositionMap.put("bodyPosition", bodyPositionOld.getItemValue());
			JSONObject jsonObject = JSONObject.fromObject(bodyPositionMap); 
			this.bodyPositionResult=jsonObject.toString();	
		}
		return SUCCESS;
	}
	
	
	
	
	/**
	 * 
	 * @Title: getAnesthSummary 
	 * @Description: 获取麻醉小结的信息
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param 
	 * @return String
	 * @throws 
	 *
	 */
	public String getAnesthSummary()throws ParseException{
		SmAnaesRecord smar = anesthesiaRecordService.getSmAnaesRecordByoperationId(operationId);
		Map<String,String> summaryMap = new HashMap<String, String>();
		if(smar!=null){
			if(null!=smar.getOptStartTime()){
				summaryMap.put("optStartTime", smar.getOptStartTime().toString());
			}else{
				summaryMap.put("optStartTime", "");
			}
			if(null!=smar.getOptEndTime()){
				summaryMap.put("optEndTime", smar.getOptEndTime().toString());
			}else{
				summaryMap.put("optEndTime", "");
			}
			if(null!=smar.getAnaesStartTime()){
				summaryMap.put("anaesStartTime", smar.getAnaesStartTime().toString());
			}else{
				summaryMap.put("anaesStartTime", "");
			}
			if(null!=smar.getAnaesEndTime()){
				summaryMap.put("anaesEndTime", smar.getAnaesEndTime().toString());
			}else{
				summaryMap.put("anaesEndTime", "");
			}
			if(null!=smar.getAsaLevel()){
				summaryMap.put("asalevel", smar.getAsaLevel());
			}else{
				summaryMap.put("asalevel", "");
			}
			if(null!=smar.getOptStartTime()&&null!=smar.getOptEndTime()){
				String optCha=getDatePoor(smar.getOptEndTime(),smar.getOptStartTime());
				summaryMap.put("optCha", optCha);
			}else{
				summaryMap.put("optCha", "");
			}
			if(null!=smar.getAnaesStartTime()&&null!=smar.getAnaesEndTime()){
				String anasCha=getDatePoor(smar.getAnaesEndTime(),smar.getAnaesStartTime());
				summaryMap.put("anasCha", anasCha);
			}else{
				summaryMap.put("anasCha", "");
			}
			JSONObject jsonObject = JSONObject.fromObject(summaryMap); 
			this.anesthSummaryResult=jsonObject.toString();	
		}
		return SUCCESS;
	}
	//获取两个Date 所差的天、小时、分钟
	public static String getDatePoor(Date endDate, Date nowDate) {
	    long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
	    long nm = 1000 * 60;
	    long diff = endDate.getTime() - nowDate.getTime();
	    long day = diff / nd;
	    long hour = diff % nd / nh;
	    long min = diff % nd % nh / nm;
	    return day + " 天 " + hour + " 小时 " + min + " 分钟 ";
	}
	
	
	/**
	 * 
	 * @Title: addOutRoomStatus 
	 * @Description: 保存出室情况
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param 
	 * @return String
	 * @throws 
	 */
	public String addOutRoomStatus(){
		System.out.println();
		SmOutRoomStatus sorsOld = anesthesiaRecordService.getSmOutRoomStatusByoperationId(sors.getOperationId());
		System.out.println(sors.getOperationId()+"ddddddddddddddddddddddddddddddddddd");
		if(sorsOld!=null){
			sorsOld.setEasePainManner(sors.getEasePainManner());
			sorsOld.setMentalState(sors.getMentalState());
			sorsOld.setCoughReflact(sors.getCoughReflact());
			sorsOld.setDirePower(sors.getDirePower());
			sorsOld.setMuscleRecover(sors.getMuscleRecover());
			sorsOld.setLeaveTo(sors.getLeaveTo());
			try {
				anesthesiaRecordService.updateSmOutRoomStatus(sorsOld);
				info="修改成功";
			} catch (Exception e) {
				e.printStackTrace();
				info="修改失败";
			}
		}else{
			try {
				anesthesiaRecordService.addSmOutRoomStatus(sors);
				info="添加成功";
			} catch (Exception e) {
				e.printStackTrace();
				info="添加失败";
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: getOutRoomStatus 
	 * @Description: 获取出室情况
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param 
	 * @return String
	 * @throws 
	 */
	public String getOutRoomStatus() throws ParseException{
		SmOutRoomStatus sorsOld = anesthesiaRecordService.getSmOutRoomStatusByoperationId(operationId);
		Map<String,String> outRoomMap = new HashMap<String, String>();
		if(sorsOld!=null){
			if(!"".equals(sorsOld.getEasePainManner())&&null!=sorsOld.getEasePainManner()){
				outRoomMap.put("easePainManner", sorsOld.getEasePainManner());
			}else{
				outRoomMap.put("easePainManner","");
			}
			if(!"".equals(sorsOld.getMentalState())&&null!=sorsOld.getMentalState()){
				outRoomMap.put("mentalState", sorsOld.getMentalState());
			}else{
				outRoomMap.put("mentalState", "");
			}
			if(!"".equals(sorsOld.getCoughReflact())&&null!=sorsOld.getCoughReflact()){
				outRoomMap.put("coughReflact", sorsOld.getCoughReflact());
			}else{
				outRoomMap.put("coughReflact", "");
			}
			if(!"".equals(sorsOld.getDirePower())&&null!=sorsOld.getDirePower()){
				outRoomMap.put("direPower", sorsOld.getDirePower());
			}else{
				outRoomMap.put("direPower", "");
			}
			if(!"".equals(sorsOld.getMuscleRecover())&&null!=sorsOld.getMuscleRecover()){
				outRoomMap.put("muscleRecover", sorsOld.getMuscleRecover());
			}else{
				outRoomMap.put("muscleRecover", "");
			}
			if(!"".equals(sorsOld.getLeaveTo())&&null!=sorsOld.getLeaveTo()){
				outRoomMap.put("leaveTo", sorsOld.getLeaveTo());
			}else{
				outRoomMap.put("leaveTo", "");
			}
			JSONObject jsonObject = JSONObject.fromObject(outRoomMap); 
			this.outRoomStatusResult=jsonObject.toString();	
		}
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * @Title: updateSmRegOptSomething 
	 * @Description: 更新基本信息部分数据
	 * @author 崔连瑞
	 * @date 2016-5-3 上午09:58:41
	 * @param 
	 * @return String
	 * @throws 
	 */
	public String updateSmRegOptSomething(){
		SmRegOpt sroOld = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
		SmAnaesRecord smar = anesthesiaRecordService.getSmAnaesRecordByoperationId(operationId);
		if(sroOld!=null){
			sroOld.setHeight(Integer.parseInt(regOptHeight));
			sroOld.setWeight(Integer.parseInt(regOptWeight));
			sroOld.setBloodType(regOptBloodType);
			try {
				anesthesiaRecordService.updateSmRegOpt(sroOld);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(smar!=null){
			smar.setAsaLevel(regOptAsa01);
			try {
				anesthesiaRecordService.updateSmAnaesRecord(smar);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: stopOperation 
	 * @Description: 结束手术
	 * @author 崔连瑞
	 * @date 2016-5-16 上午09:58:41
	 * @param 
	 * @return String
	 * @throws 
	 */
	public String stopOperation(){
		SmRegOpt sroOld = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
		if(sroOld!=null){
			sroOld.setState(END_OPERATION);
			Calendar calendar = Calendar.getInstance();
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			sroOld.setEndtime(hour+":"+minute);
			try {
				anesthesiaRecordService.updateSmRegOpt(sroOld);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	/**
	 * 
	 * @Title: loadDocumentState 
	 * @Description: 加载个文书的状态
	 * @author 崔连瑞
	 * @date 2016-5-16 上午09:58:41
	 * @param 
	 * @return String
	 * @throws 
	 */
	public String loadDocumentState(){
		List<Map<String, Object>> list = anesthesiaRecordService.loadAllDocumentState();
		JSONArray jsonArray = JSONArray.fromObject(list);
		this.documentStateResult=jsonArray.toString();
		return SUCCESS;
	}
	
	
	 /**
	 * @方法名称: getAnesthesiaDoctor
	 * @功能描述: 通过角色查询麻醉人员
	 * @作者:崔连瑞
	 * @创建时间:2016-6-21 下午5:06:45
	 * @return String   
	 */
	 
	public String getAnesthesiaDoctor() {
		List<SmOperationPeople> list = operationPeopleService.getAnesthetistersByRole(yishiRole);
		JSONArray jsonArray = JSONArray.fromObject(list);
		this.anesthesiaDoctorsResult=jsonArray.toString();
		return SUCCESS;
	}
	 /**
		 * @方法名称: editAnesthesiaDoctor
		 * @功能描述: 修改麻醉医生
		 * @作者:崔连瑞
		 * @创建时间:2016-6-21 下午5:06:45
		 * @return String   
		 */
	public String editAnesthesiaDoctor(){
		SmRegOpt sroOld = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
		if("anesthetist".equals(anesthesiaDoctorType)){
			sroOld.setAnesthetist(anesthesiaDoctorName);
		}
		if("circuanesthetist".equals(anesthesiaDoctorType)){
			sroOld.setAnesthetist(anesthesiaDoctorName);
		}
		if("anaesAssistant".equals(anesthesiaDoctorType)){
			sroOld.setAnesthetist(anesthesiaDoctorName);
		}
		try {
			anesthesiaRecordService.updateSmRegOpt(sroOld);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	 /**
		 * @方法名称: editTourNurse
		 * @功能描述: 修改巡回护士 
		 * @作者:崔连瑞
		 * @创建时间:2016-6-21 下午5:06:45 
		 * @return String     
		 */
	public String editTourNurse(){
		SmRegOpt sroOld = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
		if("tourNurseO".equals(tourNurseType)){
			sroOld.setInstrnurse1(tourNurseName);
		}
		if("tourNurseT".equals(tourNurseType)){
			sroOld.setInstrnurse2(tourNurseName);
		}
		try {
			anesthesiaRecordService.updateSmRegOpt(sroOld);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	

	 /**
		 * @方法名称: editInstrumentNurse
		 * @功能描述: 修改器械护士 
		 * @作者:崔连瑞
		 * @创建时间:2016-6-21 下午5:06:45 
		 * @return String     
		 */
	public String editInstrumentNurse(){
		SmRegOpt sroOld = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
		if("instrumentNurseO".equals(instrumentNurseType)){
			sroOld.setCircunurse1(instrumentNurseName);
		}
		if("instrumentNurseT".equals(instrumentNurseType)){
			sroOld.setCircunurse2(instrumentNurseName);
		}
		try {
			anesthesiaRecordService.updateSmRegOpt(sroOld);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	

	
	 /**
		 * @方法名称: editOperationDoctor
		 * @功能描述: 修改手术医生
		 * @作者:崔连瑞
		 * @创建时间:2016-6-21 下午5:06:45
		 * @return String     editTourNurse
		 */
	public String editOperationDoctor(){
		SmRegOpt sroOld = anesthesiaRecordService.loadAnesthesiaRecordMainView(operationId);
		sroOld.setOperatorName(operationDoctorName);
		try {
			anesthesiaRecordService.updateSmRegOpt(sroOld);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 /**
	 * @方法名称: getAnesthetistersByRole
	 * @功能描述: 通过角色查询手术医生
	 * @作者:付士山
	 * @创建时间:2016-6-21 下午5:06:45
	 * @return String   
	 */
	 
	public String getAnesthetistersByRole1() {
		System.out.println(yishiRole);
		List<SmOperationPeople> list = operationPeopleService.getAnesthetistersByRole(yishiRole);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				SmOperationPeople p = (SmOperationPeople) list.get(i);
				data +="<option class=\"sl\">" + p.getName()
						+ "</option>";
			}
		}
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	 /**
		 * @方法名称: getAnesthetistersByRole
		 * @功能描述: 通过角色查询护士
		 * @作者:付士山
		 * @创建时间:2016-6-21 下午5:06:45
		 * @return String   
		 */
		 
		public String getAnesthetistersByRole2() {
			System.out.println(yishiRole);
			List<SmOperationPeople> list = operationPeopleService.getAnesthetistersByRole(yishiRole);
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					SmOperationPeople p = (SmOperationPeople) list.get(i);
					data +="<option class=\"hs\">" + p.getName()
							+ "</option>";
				}
			}
			
			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out;
				out = response.getWriter();
				out.print(data);
				out.flush();
				out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
	 /**
	 * @方法名称: getAnesthetistersByPy
	 * @功能描述: 通过拼音查询麻醉人员
	 * @作者:付士山
	 * @创建时间:2016-6-21 下午5:06:45
	 * @return String   
	 */
	 
	public String getAnesthetistersByPy() {
		String zimu=request.getParameter("zimu").trim().toUpperCase();
		List<SmOperationPeople> list = operationPeopleService.getAnesthetistersByPy(zimu);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				SmOperationPeople p = (SmOperationPeople) list.get(i);
				data +="<option class=\"xl\">" + p.getName()
						+ "</option>";
			}
		}
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	 /**
		 * @方法名称: getAnesthetistersByPy1
		 * @功能描述: 通过拼音查询手术医生
		 * @作者:付士山
		 * @创建时间:2016-6-21 下午5:06:45
		 * @return String   
		 */
		 
		public String getAnesthetistersByPy1() {
			String zimu=request.getParameter("zimu").trim().toUpperCase();
			List<SmOperationPeople> list = operationPeopleService.getAnesthetistersByPy1(zimu);
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					SmOperationPeople p = (SmOperationPeople) list.get(i);
					data +="<option class=\"sl\">" + p.getName()
							+ "</option>";
				}
			}
			
			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out;
				out = response.getWriter();
				out.print(data);
				out.flush();
				out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		 /**
		 * @方法名称: getAnesthetistersByPy2
		 * @功能描述: 通过拼音查询手术护士
		 * @作者:付士山
		 * @创建时间:2016-6-21 下午5:06:45
		 * @return String   
		 */
		 
		public String getAnesthetistersByPy2() {
			String zimu=request.getParameter("zimu").trim().toUpperCase();
			List<SmOperationPeople> list = operationPeopleService.getAnesthetistersByPy2(zimu);
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					SmOperationPeople p = (SmOperationPeople) list.get(i);
					data +="<option class=\"hs\">" + p.getName()
							+ "</option>";
				}
			}
			
			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out;
				out = response.getWriter();
				out.print(data);
				out.flush();
				out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	 /**
	 * @方法名称: AnesthetistersByyishiName
	 * @功能描述: 通过姓名查询麻醉人员角色
	 * @作者:付士山
	 * @创建时间:2016-6-21 下午5:06:45
	 * @return String   
	 */
	 
	public String AnesthetistersByyishiName() {
		
		String yishiName=request.getParameter("yishiName");
		List<SmOperationPeople> list = operationPeopleService.AnesthetistersByyishiName(yishiName);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				SmOperationPeople p = (SmOperationPeople) list.get(i);
				data +=p.getRole();
			}
		}
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	 /**
		 * @方法名称: AnesthetistersByyishiName1
		 * @功能描述: 通过姓名查询手术护士角色
		 * @作者:付士山
		 * @创建时间:2016-6-21 下午5:06:45
		 * @return String   
		 */
		 
		public String AnesthetistersByyishiName1() {
			
			String yishiName=request.getParameter("yishiName");
			List<SmOperationPeople> list = operationPeopleService.AnesthetistersByyishiName(yishiName);
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					SmOperationPeople p = (SmOperationPeople) list.get(i);
					data +=p.getRole();
				}
			}
			
			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out;
				out = response.getWriter();
				out.print(data);
				out.flush();
				out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
		 /**
		 * @方法名称: saveZhenTong
		 * @功能描述: 保存镇痛等信息
		 * @作者:付士山
		 * @创建时间:2016-7-19 上午10:27:59
		 * @return String   
		 */
		 
		public String saveZhenTong() {
			String analgesia=request.getParameter("analgesia");
			String cpr=request.getParameter("cpr");
			String incisionCleanliness=request.getParameter("incisionCleanliness");
			SmAnaesRecord sar=anesthesiaRecordService.getAnaesRecordByoperationId(operationId);
			if(sar!=null){
				sar.setAnalgesia(analgesia);
				sar.setCpr(cpr);
				sar.setIncisionCleanliness(incisionCleanliness);
				try {
					anesthesiaRecordService.updateSmAnaesRecord(sar);
			
				} catch (Exception e) {
					e.printStackTrace();

				}
			}		
			
			return SUCCESS;
			
		}
		
		/**
		 * @方法名称: getMedicineNameByPinYin
		 * @功能描述: AJAX联动查询麻醉用药
		 * @作者:付士山
		 * @创建时间:2016-1-18 下午3:13:19
		 * @return String  ，"title".toUpperCase()
		 */

		public String getMedicineNameByPinYin() {
			System.out.println(mpyCode);
			List<SmMedicine> list = anesthesiaRecordService.getMedicineNameByPinYin(mpyCode.toUpperCase());
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					SmMedicine sm = (SmMedicine) list.get(i);
					data += "<option class=\"medicineNameClass\" value=\"" + sm.getId() + "\">" + sm.getBriefName()+"["+sm.getPinyin()+"]"
							+ "</option>";
				}
			}
			
			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out;
				out = response.getWriter();
				out.print(data);
				out.flush();
				out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		/**
		 * @方法名称: getMedicineById
		 * @功能描述: 查询麻醉用药
		 * @作者:
		 * @创建时间:2016-1-18 下午3:13:19
		 * @return 
		 */
		public String getMedicineById(){
			SmMedicine sm = anesthesiaRecordService.getMedicineById(medicineId);
			JSONArray jsonArray = JSONArray.fromObject(sm);
			this.smMedicineResult=jsonArray.toString();
			return SUCCESS;
		}
		
		/**
		 * @方法名称: getMedicineById
		 * @功能描述: 查询麻醉用药
		 * @作者:
		 * @创建时间:2016-1-18 下午3:13:19
		 * @return 
		 */
		public String getInPutById(){
			SmIoDefination inPu = anesthesiaRecordService.getInPutById(Integer.parseInt(inPutId));
			JSONArray jsonArray = JSONArray.fromObject(inPu);
			this.smInPutIdResult=jsonArray.toString();
			return SUCCESS;
		}
		
		
		
		/**
		 * 
		 * @Description: 获取麻醉事件列表
		 * @param    
		 * @return void  
		 * @throws
		 * @author 白东旭
		 * @date 2016年7月25日
		 */
		public void getAnesEventList() {
			List<Map<String,Object>> map = anesthesiaRecordService.getAnesEventList();
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			String json = JSONArray.fromObject(map).toString();
			
			try {
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 
		 * @Description: 添加麻醉事件
		 * @param    
		 * @return void  
		 * @throws
		 * @author 白东旭
		 * @date 2016年7月25日
		 */
		public void addAnesEventItem() {
			String userid = (String) this.getSession().get("userid");
			
			Map<String,Object> event = anesthesiaRecordService.addAnesEventItem(itemCode,operationId,userid);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			String json = JSONArray.fromObject(event).toString();
			
			try {
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 
		 * @Description: 添加手术事件
		 * @param    
		 * @return void  
		 * @throws
		 * @author 白东旭
		 * @date 2016年7月26日
		 */
		public void addOperationEventItem() {
			try {
				SmOperationEvent event = anesthesiaRecordService.addOperationEvent(title,content,time,operationId);
			
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");	

				String json = JSONArray.fromObject(event).toString();
			
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 
		 * @Description: 删除手术事件
		 * @param    
		 * @return void  
		 * @throws
		 * @author 白东旭
		 * @date 2016年7月27日
		 */
		public void delOperationEventItem() {
			anesthesiaRecordService.delOperationEventItem(id);
		}
		
		/**
		 * 
		 * @Description: 根据id获取手术事件
		 * @param    
		 * @return void  
		 * @throws
		 * @author 白东旭
		 * @date 2016年7月27日
		 */
		public void getOpEventById() {
			
			Map<String,Object> event = anesthesiaRecordService.getOpEventById(id);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			String json = JSONArray.fromObject(event).toString();
			try {
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * 
		 * @Description: 修改手术信息
		 * @param    
		 * @return void  
		 * @throws
		 * @author 白东旭
		 * @date 2016年7月27日
		 */
		public void modOperationEventItem() {
			try {
				SmOperationEvent event = anesthesiaRecordService.modOperationEvent(title,content,time,id);
			
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");	

				String json = JSONArray.fromObject(event).toString();
			
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 
		 * @Description: 添加呼吸事件
		 * @param    
		 * @return void  
		 * @throws
		 * @author 白东旭
		 * @date 2016年7月28日
		 */
		public void addBreathEvent() {
			try {
				SmBreathEvent event = anesthesiaRecordService.addBreathEvent(operationId,time,breathFlag);
			
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");	

				String json = JSONArray.fromObject(event).toString();
			
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 
		 * @Description: 删除呼吸事件信息
		 * @param    
		 * @return void  
		 * @throws
		 * @author 白东旭
		 * @date 2016年7月28日
		 */
		public void delBreathEventItem() {
			anesthesiaRecordService.delBreathEventItem(id);
		}
		
		
		
		
		
		
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSmieid() {
		return smieid;
	}
	public void setSmieid(String smieid) {
		this.smieid = smieid;
	}
	public List<SmIoDefination> getLiquidsOutList() {
		return liquidsOutList;
	}
	public void setLiquidsOutList(List<SmIoDefination> liquidsOutList) {
		this.liquidsOutList = liquidsOutList;
	}
	
	public List<SmMedicine> getSmdList() {
		return smdList;
	}
	public void setSmdList(List<SmMedicine> smdList) {
		this.smdList = smdList;
	}
	public String getOperationId() {
		return operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	
	
	public List<SmMedicalTakeWay> getSmtwList() {
		return smtwList;
	}
	public void setSmtwList(List<SmMedicalTakeWay> smtwList) {
		this.smtwList = smtwList;
	}
	

	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStartRecordTime() {
		return startRecordTime;
	}
	public void setStartRecordTime(String startRecordTime) {
		this.startRecordTime = startRecordTime;
	}
	public String getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}
	public String getYlwsid() {
		return ylwsid;
	}

	public String getCollectItemsResult() {
		return collectItemsResult;
	}
	public void setCollectItemsResult(String collectItemsResult) {
		this.collectItemsResult = collectItemsResult;
	}
	public void setYlwsid(String ylwsid) {
		this.ylwsid = ylwsid;
	}
	
	public AnesthesiaRecordService getAnesthesiaRecordService() {
		return anesthesiaRecordService;
	}


	public void setAnesthesiaRecordService(
			AnesthesiaRecordService anesthesiaRecordService) {
		this.anesthesiaRecordService = anesthesiaRecordService;
	}


	public SmRegOpt getSro() {
		return sro;
	}


	public void setSro(SmRegOpt sro) {
		this.sro = sro;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SmRemarkPoint getSmRemarkPoint() {
		return smRemarkPoint;
	}
	public void setSmRemarkPoint(SmRemarkPoint smRemarkPoint) {
		this.smRemarkPoint = smRemarkPoint;
	}
	public String getSmIoEventListResult() {
		return smIoEventListResult;
	}
	public SmAnaesEvent getSae() {
		return sae;
	}
	public void setSae(SmAnaesEvent sae) {
		this.sae = sae;
	}
	public void setSmIoEventListResult(String smIoEventListResult) {
		this.smIoEventListResult = smIoEventListResult;
	}



	
	public String getLiquidsId() {
		return liquidsId;
	}
	public void setLiquidsId(String liquidsId) {
		this.liquidsId = liquidsId;
	}
	public String getLiquidsInSubType() {
		return liquidsInSubType;
	}
	public void setLiquidsInSubType(String liquidsInSubType) {
		this.liquidsInSubType = liquidsInSubType;
	}



	public String getInChildNamesResult() {
		return inChildNamesResult;
	}
	public void setInChildNamesResult(String inChildNamesResult) {
		this.inChildNamesResult = inChildNamesResult;
	}
	public String getSmAnaesEventItemsResult() {
		return smAnaesEventItemsResult;
	}
	public void setSmAnaesEventItemsResult(String smAnaesEventItemsResult) {
		this.smAnaesEventItemsResult = smAnaesEventItemsResult;
	}
	public String getSmAnaesEventsResult() {
		return smAnaesEventsResult;
	}
	public void setSmAnaesEventsResult(String smAnaesEventsResult) {
		this.smAnaesEventsResult = smAnaesEventsResult;
	}
	
	public String getEventItemCode() {
		return eventItemCode;
	}

	public void setEventItemCode(String eventItemCode) {
		this.eventItemCode = eventItemCode;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAnaesEventItemsX() {
		return anaesEventItemsX;
	}
	public void setAnaesEventItemsX(String anaesEventItemsX) {
		this.anaesEventItemsX = anaesEventItemsX;
	}
	public String getCollectIntervals() {
		return collectIntervals;
	}
	public void setCollectIntervals(String collectIntervals) {
		this.collectIntervals = collectIntervals;
	}
	public String getSmMedicalEventListResult() {
		return smMedicalEventListResult;
	}
	public void setSmMedicalEventListResult(String smMedicalEventListResult) {
		this.smMedicalEventListResult = smMedicalEventListResult;
	}
	public SmAnaesRecord getSmard() {
		return smard;
	}
	public void setSmard(SmAnaesRecord smard) {
		this.smard = smard;
	}

	public String getMonitoringSign() {
		return monitoringSign;
	}
	public void setMonitoringSign(String monitoringSign) {
		this.monitoringSign = monitoringSign;
	}
	public String getSmMonitoringSignResult() {
		return smMonitoringSignResult;
	}
	public void setSmMonitoringSignResult(String smMonitoringSignResult) {
		this.smMonitoringSignResult = smMonitoringSignResult;
	}
	public String getHollowCircles() {
		return hollowCircles;
	}
	public void setHollowCircles(String hollowCircles) {
		this.hollowCircles = hollowCircles;
	}
	public String getSolidCircles() {
		return solidCircles;
	}
	public void setSolidCircles(String solidCircles) {
		this.solidCircles = solidCircles;
	}
	public String getDownTriangles() {
		return downTriangles;
	}
	public void setDownTriangles(String downTriangles) {
		this.downTriangles = downTriangles;
	}
	public String getUpTriangles() {
		return upTriangles;
	}
	public void setUpTriangles(String upTriangles) {
		this.upTriangles = upTriangles;
	}
	/**
	 * @return the functionid
	 */
	public String getFunctionid() {
		return functionid;
	}
	/**
	 * @param functionid the functionid to set
	 */
	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}
	public String getSpecialStatus() {
		return specialStatus;
	}
	public void setSpecialStatus(String specialStatus) {
		this.specialStatus = specialStatus;
	}
	public SmOperationEvent getOperationEvent() {
		return operationEvent;
	}
	public void setOperationEvent(SmOperationEvent operationEvent) {
		this.operationEvent = operationEvent;
	}
	public String getSmOperationEventListResult() {
		return smOperationEventListResult;
	}
	public void setSmOperationEventListResult(String smOperationEventListResult) {
		this.smOperationEventListResult = smOperationEventListResult;
	}
	public SmBreathEvent getBreathEvent() {
		return breathEvent;
	}
	public void setBreathEvent(SmBreathEvent breathEvent) {
		this.breathEvent = breathEvent;
	}
	public String getSmBreathEventListResult() {
		return smBreathEventListResult;
	}
	public void setSmBreathEventListResult(String smBreathEventListResult) {
		this.smBreathEventListResult = smBreathEventListResult;
	}
	public String getBreathEventId() {
		return breathEventId;
	}
	public void setBreathEventId(String breathEventId) {
		this.breathEventId = breathEventId;
	}
	public String getOperationEventId() {
		return operationEventId;
	}
	public void setOperationEventId(String operationEventId) {
		this.operationEventId = operationEventId;
	}
	public String getAnesthetisterResult() {
		return anesthetisterResult;
	}
	public void setAnesthetisterResult(String anesthetisterResult) {
		this.anesthetisterResult = anesthetisterResult;
	}
	public String getOperatorsResult() {
		return operatorsResult;
	}
	public void setOperatorsResult(String operatorsResult) {
		this.operatorsResult = operatorsResult;
	}
	public SmBodyPosition getBodyPosition() {
		return bodyPosition;
	}
	public void setBodyPosition(SmBodyPosition bodyPosition) {
		this.bodyPosition = bodyPosition;
	}
	public String getBodyPositionValues() {
		return bodyPositionValues;
	}
	public void setBodyPositionValues(String bodyPositionValues) {
		this.bodyPositionValues = bodyPositionValues;
	}
	public String getBodyPositionId() {
		return bodyPositionId;
	}
	public void setBodyPositionId(String bodyPositionId) {
		this.bodyPositionId = bodyPositionId;
	}
	public String getAnesthSummaryResult() {
		return anesthSummaryResult;
	}
	public void setAnesthSummaryResult(String anesthSummaryResult) {
		this.anesthSummaryResult = anesthSummaryResult;
	}
	public SmOutRoomStatus getSors() {
		return sors;
	}
	public void setSors(SmOutRoomStatus sors) {
		this.sors = sors;
	}
	public String getOutRoomStatusResult() {
		return outRoomStatusResult;
	}
	public void setOutRoomStatusResult(String outRoomStatusResult) {
		this.outRoomStatusResult = outRoomStatusResult;
	}
	public String getBodyPositionResult() {
		return bodyPositionResult;
	}
	public void setBodyPositionResult(String bodyPositionResult) {
		this.bodyPositionResult = bodyPositionResult;
	}
	public String getRegOptHeight() {
		return regOptHeight;
	}
	public void setRegOptHeight(String regOptHeight) {
		this.regOptHeight = regOptHeight;
	}
	public String getRegOptWeight() {
		return regOptWeight;
	}
	public void setRegOptWeight(String regOptWeight) {
		this.regOptWeight = regOptWeight;
	}
	public String getRegOptBloodType() {
		return regOptBloodType;
	}
	public void setRegOptBloodType(String regOptBloodType) {
		this.regOptBloodType = regOptBloodType;
	}
	public String getRegOptAsa01() {
		return regOptAsa01;
	}
	public void setRegOptAsa01(String regOptAsa01) {
		this.regOptAsa01 = regOptAsa01;
	}
	public SmBloodtypeItem getSmbti() {
		return smbti;
	}
	public void setSmbti(SmBloodtypeItem smbti) {
		this.smbti = smbti;
	}
	public List<?> getSmbtiList() {
		return smbtiList;
	}
	public void setSmbtiList(List<?> smbtiList) {
		this.smbtiList = smbtiList;
	}
	public String getDocumentStateResult() {
		return documentStateResult;
	}
	public void setDocumentStateResult(String documentStateResult) {
		this.documentStateResult = documentStateResult;
	}

	public static String getIS_ENABLE() {
		return IS_ENABLE;
	}
	public static void setIS_ENABLE(String iS_ENABLE) {
		IS_ENABLE = iS_ENABLE;
	}
	public static String getNOT_ENABLE() {
		return NOT_ENABLE;
	}
	public static void setNOT_ENABLE(String nOT_ENABLE) {
		NOT_ENABLE = nOT_ENABLE;
	}
	public static String getSTART_OPERATION() {
		return START_OPERATION;
	}
	public static void setSTART_OPERATION(String sTART_OPERATION) {
		START_OPERATION = sTART_OPERATION;
	}
	public static String getEND_OPERATION() {
		return END_OPERATION;
	}
	public static void setEND_OPERATION(String eND_OPERATION) {
		END_OPERATION = eND_OPERATION;
	}

	public String getYishiRole() {
		return yishiRole;
	}
	public void setYishiRole(String yishiRole) {
		this.yishiRole = yishiRole;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public OperationPeopleService getOperationPeopleService() {
		return operationPeopleService;
	}
	public void setOperationPeopleService(
			OperationPeopleService operationPeopleService) {
		this.operationPeopleService = operationPeopleService;
	}
	public String getVitalSignResult() {
		return vitalSignResult;
	}
	public void setVitalSignResult(String vitalSignResult) {
		this.vitalSignResult = vitalSignResult;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getCollectItemsListResult() {
		return collectItemsListResult;
	}
	public void setCollectItemsListResult(String collectItemsListResult) {
		this.collectItemsListResult = collectItemsListResult;
	}
	public String getOutputLiquidResult() {
		return outputLiquidResult;
	}
	public void setOutputLiquidResult(String outputLiquidResult) {
		this.outputLiquidResult = outputLiquidResult;
	}

	public String getAnesthesiaDoctorsResult() {
		return anesthesiaDoctorsResult;
	}

	public void setAnesthesiaDoctorsResult(String anesthesiaDoctorsResult) {
		this.anesthesiaDoctorsResult = anesthesiaDoctorsResult;
	}

	public String getAnesthesiaDoctorType() {
		return anesthesiaDoctorType;
	}

	public void setAnesthesiaDoctorType(String anesthesiaDoctorType) {
		this.anesthesiaDoctorType = anesthesiaDoctorType;
	}

	public String getAnesthesiaDoctorName() {
		return anesthesiaDoctorName;
	}

	public void setAnesthesiaDoctorName(String anesthesiaDoctorName) {
		this.anesthesiaDoctorName = anesthesiaDoctorName;
	}

	public String getMpyCode() {
		return mpyCode;
	}

	public void setMpyCode(String mpyCode) {
		this.mpyCode = mpyCode;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public String getSmMedicineResult() {
		return smMedicineResult;
	}

	public void setSmMedicineResult(String smMedicineResult) {
		this.smMedicineResult = smMedicineResult;
	}

	public String getInPutId() {
		return inPutId;
	}

	public void setInPutId(String inPutId) {
		this.inPutId = inPutId;
	}

	public String getSmInPutIdResult() {
		return smInPutIdResult;
	}

	public void setSmInPutIdResult(String smInPutIdResult) {
		this.smInPutIdResult = smInPutIdResult;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBreathFlag() {
		return breathFlag;
	}

	public void setBreathFlag(String breathFlag) {
		this.breathFlag = breathFlag;
	}



	public String getOperationEndtime() {
		return operationEndtime;
	}

	public void setOperationEndtime(String operationEndtime) {
		this.operationEndtime = operationEndtime;
	}

	public String getOptStartTimeResult() {
		return optStartTimeResult;
	}

	public void setOptStartTimeResult(String optStartTimeResult) {
		this.optStartTimeResult = optStartTimeResult;
	}

	public String getOutPutOperationId() {
		return outPutOperationId;
	}

	public void setOutPutOperationId(String outPutOperationId) {
		this.outPutOperationId = outPutOperationId;
	}

	public String getOutPutId() {
		return outPutId;
	}

	public void setOutPutId(String outPutId) {
		this.outPutId = outPutId;
	}

	public String getOutPutName() {
		return outPutName;
	}

	public void setOutPutName(String outPutName) {
		this.outPutName = outPutName;
	}

	public String getOutPutDosage() {
		return outPutDosage;
	}

	public void setOutPutDosage(String outPutDosage) {
		this.outPutDosage = outPutDosage;
	}

	public String getOutPutDosageUnit() {
		return outPutDosageUnit;
	}

	public void setOutPutDosageUnit(String outPutDosageUnit) {
		this.outPutDosageUnit = outPutDosageUnit;
	}

	public String getOutPutX() {
		return outPutX;
	}

	public void setOutPutX(String outPutX) {
		this.outPutX = outPutX;
	}

	public String getOutPutY() {
		return outPutY;
	}

	public void setOutPutY(String outPutY) {
		this.outPutY = outPutY;
	}

	public String getOutPutDataId() {
		return outPutDataId;
	}

	public void setOutPutDataId(String outPutDataId) {
		this.outPutDataId = outPutDataId;
	}

	public String getInPutOperationId() {
		return inPutOperationId;
	}

	public void setInPutOperationId(String inPutOperationId) {
		this.inPutOperationId = inPutOperationId;
	}

	public String getInPutName() {
		return inPutName;
	}

	public void setInPutName(String inPutName) {
		this.inPutName = inPutName;
	}

	public String getInPutSpec() {
		return inPutSpec;
	}

	public void setInPutSpec(String inPutSpec) {
		this.inPutSpec = inPutSpec;
	}

	public String getInPutFirm() {
		return inPutFirm;
	}

	public void setInPutFirm(String inPutFirm) {
		this.inPutFirm = inPutFirm;
	}

	public String getInPutDosage() {
		return inPutDosage;
	}

	public void setInPutDosage(String inPutDosage) {
		this.inPutDosage = inPutDosage;
	}

	public String getInPutDosageUnit() {
		return inPutDosageUnit;
	}

	public void setInPutDosageUnit(String inPutDosageUnit) {
		this.inPutDosageUnit = inPutDosageUnit;
	}

	public String getInPutAmount() {
		return inPutAmount;
	}

	public void setInPutAmount(String inPutAmount) {
		this.inPutAmount = inPutAmount;
	}

	public String getInPutPrice() {
		return inPutPrice;
	}

	public void setInPutPrice(String inPutPrice) {
		this.inPutPrice = inPutPrice;
	}

	public String getInPutCharge() {
		return inPutCharge;
	}

	public void setInPutCharge(String inPutCharge) {
		this.inPutCharge = inPutCharge;
	}

	public String getInPutStartX() {
		return inPutStartX;
	}

	public void setInPutStartX(String inPutStartX) {
		this.inPutStartX = inPutStartX;
	}

	public String getInPutStartY() {
		return inPutStartY;
	}

	public void setInPutStartY(String inPutStartY) {
		this.inPutStartY = inPutStartY;
	}

	public String getInPutEndX() {
		return inPutEndX;
	}

	public void setInPutEndX(String inPutEndX) {
		this.inPutEndX = inPutEndX;
	}

	public String getInPutEndY() {
		return inPutEndY;
	}

	public void setInPutEndY(String inPutEndY) {
		this.inPutEndY = inPutEndY;
	}

	public String getInPutEnded() {
		return inPutEnded;
	}

	public void setInPutEnded(String inPutEnded) {
		this.inPutEnded = inPutEnded;
	}

	public String getInPutDataId() {
		return inPutDataId;
	}

	public void setInPutDataId(String inPutDataId) {
		this.inPutDataId = inPutDataId;
	}

	public String getMedOperationId() {
		return medOperationId;
	}

	public void setMedOperationId(String medOperationId) {
		this.medOperationId = medOperationId;
	}

	public String getMedId() {
		return medId;
	}

	public void setMedId(String medId) {
		this.medId = medId;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public String getMedSpec() {
		return medSpec;
	}

	public void setMedSpec(String medSpec) {
		this.medSpec = medSpec;
	}

	public String getMedTakewayCode() {
		return medTakewayCode;
	}

	public void setMedTakewayCode(String medTakewayCode) {
		this.medTakewayCode = medTakewayCode;
	}

	public String getMedFirm() {
		return medFirm;
	}

	public void setMedFirm(String medFirm) {
		this.medFirm = medFirm;
	}

	public String getMedDosage() {
		return medDosage;
	}

	public void setMedDosage(String medDosage) {
		this.medDosage = medDosage;
	}

	public String getMedDosageUnit() {
		return medDosageUnit;
	}

	public void setMedDosageUnit(String medDosageUnit) {
		this.medDosageUnit = medDosageUnit;
	}

	public String getMedAmount() {
		return medAmount;
	}

	public void setMedAmount(String medAmount) {
		this.medAmount = medAmount;
	}

	public String getMedIsCharge() {
		return medIsCharge;
	}

	public void setMedIsCharge(String medIsCharge) {
		this.medIsCharge = medIsCharge;
	}

	public String getMedThickness() {
		return medThickness;
	}

	public void setMedThickness(String medThickness) {
		this.medThickness = medThickness;
	}

	public String getMedThicknessUnit() {
		return medThicknessUnit;
	}

	public void setMedThicknessUnit(String medThicknessUnit) {
		this.medThicknessUnit = medThicknessUnit;
	}

	public String getMedSpeed() {
		return medSpeed;
	}

	public void setMedSpeed(String medSpeed) {
		this.medSpeed = medSpeed;
	}

	public String getMedSpeedUnit() {
		return medSpeedUnit;
	}

	public void setMedSpeedUnit(String medSpeedUnit) {
		this.medSpeedUnit = medSpeedUnit;
	}

	public String getMedReasonSelect() {
		return medReasonSelect;
	}

	public void setMedReasonSelect(String medReasonSelect) {
		this.medReasonSelect = medReasonSelect;
	}

	public String getMedReason() {
		return medReason;
	}

	public void setMedReason(String medReason) {
		this.medReason = medReason;
	}

	public String getMedStartX() {
		return medStartX;
	}

	public void setMedStartX(String medStartX) {
		this.medStartX = medStartX;
	}

	public String getMedSY() {
		return medSY;
	}

	public void setMedSY(String medSY) {
		this.medSY = medSY;
	}

	public String getMedEndX() {
		return medEndX;
	}

	public void setMedEndX(String medEndX) {
		this.medEndX = medEndX;
	}

	public String getMedHeight() {
		return medHeight;
	}

	public void setMedHeight(String medHeight) {
		this.medHeight = medHeight;
	}

	public String getMedIsEnded() {
		return medIsEnded;
	}

	public void setMedIsEnded(String medIsEnded) {
		this.medIsEnded = medIsEnded;
	}

	public String getMedIsContinued() {
		return medIsContinued;
	}

	public void setMedIsContinued(String medIsContinued) {
		this.medIsContinued = medIsContinued;
	}

	public String getAnaesCode() {
		return anaesCode;
	}

	public void setAnaesCode(String anaesCode) {
		this.anaesCode = anaesCode;
	}

	public String getOperationDoctorName() {
		return operationDoctorName;
	}

	public void setOperationDoctorName(String operationDoctorName) {
		this.operationDoctorName = operationDoctorName;
	}

	public String getTourNurseType() {
		return tourNurseType;
	}

	public void setTourNurseType(String tourNurseType) {
		this.tourNurseType = tourNurseType;
	}

	public String getTourNurseName() {
		return tourNurseName;
	}

	public void setTourNurseName(String tourNurseName) {
		this.tourNurseName = tourNurseName;
	}

	public String getInstrumentNurseType() {
		return instrumentNurseType;
	}

	public void setInstrumentNurseType(String instrumentNurseType) {
		this.instrumentNurseType = instrumentNurseType;
	}

	public String getInstrumentNurseName() {
		return instrumentNurseName;
	}

	public void setInstrumentNurseName(String instrumentNurseName) {
		this.instrumentNurseName = instrumentNurseName;
	}

	public String getAnesthEventX() {
		return anesthEventX;
	}

	public void setAnesthEventX(String anesthEventX) {
		this.anesthEventX = anesthEventX;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
