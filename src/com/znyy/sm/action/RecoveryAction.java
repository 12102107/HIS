/**
 * 
 */
package com.znyy.sm.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.common.action.CommAction;
import com.common.util.XmlUtil;
import com.znyy.bean.SmRecoveryData;
import com.znyy.bean.SmRecoveryFromMachine;
import com.znyy.bean.SmRecoveryroomRecord;
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.service.RecoveryService;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author 白东旭
 * @date 2016-5-4
 */
public class RecoveryAction extends CommAction {

	private RecoveryService recoveryService;

	/**
	 * @return the recoveryService
	 */
	public RecoveryService getRecoveryService() {
		return recoveryService;
	}

	/**
	 * @param recoveryService the recoveryService to set
	 */
	public void setRecoveryService(RecoveryService recoveryService) {
		this.recoveryService = recoveryService;
	}
	private static String START="01";//开始
	private static String END="02";//结束
	private String ylwsid;
	private String functionid; 
	private String roomCode; 
	private String operationId; 
	private String startTime; 
	private String recoveryEndtime; 
	private String collectInterval; 
	private String userId; 
	private String collectDateResult; 
	private String recoveryDataResult; 
	
	private SmRecoveryroomRecord record;
	private SmRecoveryData smdata;
	
	
	/**
	 * 
	 * @Description: 获取恢复室记录单
	 * @param @return   
	 * @return String  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-5-4
	 */
	public String getRecoveryRecordByYlwsid() {
		
		SmRegOpt sro = recoveryService.getSmRegOptByYlwsid(ylwsid);
		request.setAttribute("sro", sro);
		
		record = recoveryService.getRecordByYlwsid(ylwsid);
		
		return SUCCESS;
	}

	/**
	 * 
	 * @Description: 保存恢复室记录单
	 * @param    
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-5-6
	 */
	public void saveRecord() {
		String username = (String) this.session.get("sessionusername");
		recoveryService.saveRecord(record,username);
	}
	/**
	 * @方法名称: saveRecovery
	 * @功能描述: 保存恢复室记录单
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return void
	 * 
	 */
	public void saveRecovery(){
		SmRecoveryroomRecord srr = recoveryService.getRecordByYlwsid(record.getOperationId());
		srr.setPortablePipe(record.getPortablePipe());
		srr.setPortablePipeOther(record.getPortablePipeOther());
		srr.setSoberScore(record.getSoberScore());
		srr.setBreathingScore(record.getBreathingScore());
		srr.setPhysicalActivityScore(record.getPhysicalActivityScore());
		srr.setTotalScore(record.getTotalScore());
		srr.setDestination(record.getDestination());
		srr.setWsid(record.getWsid());
		try {
			recoveryService.updateRecoveryRecord(srr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @方法名称: createRecovery
	 * @功能描述: 创建恢复室记录单
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return void
	 */
	public void createRecovery(){
		SmRecoveryroomRecord srr =new SmRecoveryroomRecord();
		Date startDate = strToDate(startTime);
		srr.setOperationId(operationId);
		srr.setEnterTime(startDate);
		srr.setRemarkInterval(Integer.parseInt(collectInterval));
		srr.setState(START);
		srr.setCreatOperation(userId);
		srr.setCreatTime(new Date());
		try {
			recoveryService.createRecoveryRecord(srr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @方法名称: addRecoveryMonitorStartTime
	 * @功能描述: 开始记录时间
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return void
	 */
	public void addMonitorStartTime(){
		SmRecoveryroomRecord srr = recoveryService.getRecordByYlwsid(operationId);
		srr.setMonitorStartTime(new Date());
		try {
			recoveryService.updateRecoveryRecord(srr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @方法名称: addRecoveryMonitorEndTime
	 * @功能描述: 结束记录时间
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return void
	 */
	public void addMonitorEndTime(){
		SmRecoveryroomRecord srr = recoveryService.getRecordByYlwsid(operationId);
		srr.setMonitorEndTime(new Date());
		try {
			recoveryService.updateRecoveryRecord(srr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @方法名称: addRecoveryMonitorEndTime
	 * @功能描述: 结束记录时间
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return void
	 */
	public void endRecovery(){
		SmRecoveryroomRecord srr = recoveryService.getRecordByYlwsid(operationId);
		Date endTime = strToDate(recoveryEndtime);
		srr.setExitTime(endTime);
		srr.setState(END);
		try {
			recoveryService.updateRecoveryRecord(srr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Description: 获取体征信息
	 * @param    getCollectDate
	 * @return void  
	 * @throws 
	 * @author 崔连瑞
	 * @date 2016-5-17   collectDateResult
	 */
	public String getCollectDate(){
		SmRecoveryroomRecord srr = recoveryService.getRecordByYlwsid(operationId);
		int i = srr.getRemarkInterval();
		long l = new Date().getTime()-srr.getEnterTime().getTime();
		double dou= l/(i*60*1000);
		int d3 = (int) Math.floor(dou);
		
		Map<String, Object> map = recoveryService.getCollectDateByRoomAndTime(roomCode);
		map.put("POINT", d3);
		addSmRecoveryData(srr,map);
		JSONObject jsonObject = JSONObject.fromObject(map); 
		this.collectDateResult=jsonObject.toString();
		return SUCCESS;
	}
	/**
	 * @方法名称: addRecoveryData
	 * @功能描述: 保存采集的体征信息
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return void
	 */
	public void addSmRecoveryData(SmRecoveryroomRecord srr,Map<String, Object> map){
		SmRecoveryData srdata = new SmRecoveryData();
		srdata.setOperationId(srr.getOperationId());
		srdata.setCreateuser(srr.getCreatOperation());
		srdata.setRemarkInterval(srr.getRemarkInterval());
		srdata.setTime(new Date());
		srdata.setBpSys((new Double((String) map.get("BP_SYS"))).doubleValue());
		srdata.setBpDias((new Double((String) map.get("BP_DIAS"))).doubleValue());
		srdata.setHeartrate((new Double((String) map.get("HEARTRATE"))).doubleValue());
		srdata.setResprate((new Double((String) map.get("RESPRATE"))).doubleValue());
		srdata.setSpo2((new Double((String) map.get("SPO2"))).doubleValue());
		try {
			recoveryService.addRecoveryData(srdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * @方法名称: addRecoveryData
	 * @功能描述: 保存采集的体征信息
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return void
	 */
	public String loadRecoveryData(){
		List<Map<String, Object>> list = recoveryService.loadSmRecoveryData(operationId);
		JSONArray jsonArray = JSONArray.fromObject(list);
		this.recoveryDataResult=jsonArray.toString();
		return SUCCESS;
	}
	/**
	 * 
	 * @Description: 模拟生成体征信息
	 * @param    
	 * @return void  
	 * @throws 
	 * @author 崔连瑞
	 * @date 2016-5-17
	 */
	public void generateData() {
		SmRecoveryFromMachine recovery = new SmRecoveryFromMachine();
		Date nowTime = new Date();
		String[] str = {"BP_SYS","BP_DIAS","HEARTRATE","RESPRATE","SPO2"};
		for (int i = 0; i < str.length; i++) {
			recovery.setItemCode(str[i]);
			recovery.setRoomCode(roomCode);
			recovery.setTime(nowTime);
			if("BP_SYS".equals(str[i])){
				int random = getRandom(140,90);
				recovery.setItemValue(random+"");
			}
			if("BP_DIAS".equals(str[i])){
				int random = getRandom(90,60);
				recovery.setItemValue(random+"");
			}
			if("HEARTRATE".equals(str[i])){
				int random = getRandom(100,70);
				recovery.setItemValue(random+"");
			}
			if("RESPRATE".equals(str[i])){
				int random = getRandom(30,10);
				recovery.setItemValue(random+"");
			}
			if("SPO2".equals(str[i])){
				int random = getRandom(100,80);
				recovery.setItemValue(random+"");
			}
			try {
				recoveryService.addVitalSignsData(recovery);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	}
	/**
	 * 
	 * @Description:按照指定范围生成随机数 
	 * @param    getRandom
	 * @return int  
	 * @throws 
	 * @author 崔连瑞
	 * @date 2016-5-17
	 */
	public static int getRandom(int max,int min){
	        Random random = new Random();
	        return random.nextInt(max)%(max-min+1) + min;
	} 
	/**
	 * @方法名称: strToDate
	 * @功能描述: 字符串转date
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return Date
	 */
	public static Date strToDate(String date){
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		Date date1 =null;
		try {
			date1 =formatter.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date1;
	}
	
	
	/**
	 * @方法名称: strToDate
	 * @功能描述: 字符串转date
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return Date
	 */
	public void recoveryPrint() {
		String id = request.getParameter("id");
		try {
			
			List<Map<String, Object>> result = recoveryService.loadRecoveryPrintData(id);
		
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			PrintWriter out = response.getWriter();
			out.print(XmlUtil.xmlAssemble(result,null));
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * @return the ylwsid
	 */
	public String getYlwsid() {
		return ylwsid;
	}

	/**
	 * @param ylwsid the ylwsid to set
	 */
	public void setYlwsid(String ylwsid) {
		this.ylwsid = ylwsid;
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

	/**
	 * @return the record
	 */
	public SmRecoveryroomRecord getRecord() {
		return record;
	}

	/**
	 * @param record the record to set
	 */
	public void setRecord(SmRecoveryroomRecord record) {
		this.record = record;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getCollectDateResult() {
		return collectDateResult;
	}

	public void setCollectDateResult(String collectDateResult) {
		this.collectDateResult = collectDateResult;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getCollectInterval() {
		return collectInterval;
	}

	public void setCollectInterval(String collectInterval) {
		this.collectInterval = collectInterval;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRecoveryEndtime() {
		return recoveryEndtime;
	}

	public void setRecoveryEndtime(String recoveryEndtime) {
		this.recoveryEndtime = recoveryEndtime;
	}

	public SmRecoveryData getSmdata() {
		return smdata;
	}

	public void setSmdata(SmRecoveryData smdata) {
		this.smdata = smdata;
	}

	public String getRecoveryDataResult() {
		return recoveryDataResult;
	}

	public void setRecoveryDataResult(String recoveryDataResult) {
		this.recoveryDataResult = recoveryDataResult;
	}
	
	
}
