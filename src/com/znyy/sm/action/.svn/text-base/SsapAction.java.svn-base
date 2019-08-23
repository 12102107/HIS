package com.znyy.sm.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;


import com.common.action.AbstractAction;
import com.common.util.Util;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.service.OperationPeopleService;
import com.znyy.sm.service.OperroomService;
import com.znyy.sm.service.RegOptService;
import com.znyy.sys.user.service.PermissionService;
public class SsapAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private String qxid;
	private String value;
	private String id;
	private String info;
	private SmRegOpt sro;
	private RegOptService regOptService;
	private List<SmRegOpt> sroList;
	private List<SmRegOpt> sroYuyYueList;
	private OperroomService operroomService;
	private List<SmOperroom> roomList;
	private OperationPeopleService operationPeopleService;
	private List<SmOperationPeople> opList;
	
	
	private String sroid;
	
	private String roomid;
	private String circunurse1;
	private String circunurse2;
	private String instrnurse1;
	private String instrnurse2;
	
	private PermissionService permissionService;
	private boolean affirmRole; 
	private boolean removeRole; 
	private String functionid; 

	
	 /**
	 * @方法名称: getSsapList
	 * @功能描述: 查询手术登记人员
	 * @作者:付士山
	 * @创建时间:2016-1-22 下午5:22:55
	 * @return String   
	 */
	 
	public String getSsapList() {
		sroYuyYueList = regOptService.getRoYuYueList();	
		opList= operationPeopleService.getOpList("0");
		roomList= operroomService.getRoomList("0","0");//查询手术室
		
		String hospitalId = (String) this.session.get("hospitalid");
		sroList = regOptService.getRoList(hospitalId);
		
		List<SmOperationPeople> circunurse = operationPeopleService.getSops("0", "器械护士");
		List<SmOperationPeople> instrnurse = operationPeopleService.getSops("0", "巡回护士");
		
		request.setAttribute("circunurse", circunurse);
		request.setAttribute("instrnurse", instrnurse);
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		affirmRole = btnCodes.contains("affirm");
		removeRole = btnCodes.contains("remove");
		
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: ssapQxList
	 * @功能描述: 手术登记取消
	 * @作者:付士山
	 * @创建时间:2016-1-27 上午10:51:09
	 * @return String   
	 */
	 
	public String ssapQxList() {
		SmRegOpt ros = regOptService.modSsdjListTo(qxid);
		ros.setState("00");
		ros.setReasons(value);
		try {
			regOptService.modSsapList1(ros);
			info = "取消成功！";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 
	 * @Title: reservation 
	 * @Description: 预约手术
	 * @author 白东旭
	 * @date 2016-2-17 下午1:33:19
	 * @param 
	 * @return void
	 * @throws
	 * 
	 */
	public void reservation() {
		regOptService.modOSroReservation(sroid,roomid,circunurse1,circunurse2,instrnurse1,instrnurse2);
	}
	
	/**
	 * 
	 * @Title: reservationList 
	 * @Description: 获取预约列表
	 * @author 白东旭
	 * @date 2016-2-17 下午2:01:04
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void reservationList(){
		
		String hospitalId = (String) this.session.get("hospitalid");
		List<Map<String,Object>> sroYuYueList = regOptService.getSroYuYueList(hospitalId);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");	

		String json = JSONArray.fromObject(sroYuYueList).toString();
		
		try {
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			

	}
	
	
	public String getId() {
	
		return id;
	}

	public void setId(String id) {
	
		this.id = id;
	}

	public String getInfo() {
	
		return info;
	}

	public void setInfo(String info) {
	
		this.info = info;
	}

	public SmRegOpt getSro() {
	
		return sro;
	}

	public void setSro(SmRegOpt sro) {
	
		this.sro = sro;
	}

	public RegOptService getRegOptService() {
	
		return regOptService;
	}

	public void setRegOptService(RegOptService regOptService) {
	
		this.regOptService = regOptService;
	}

	public List<SmRegOpt> getSroList() {
	
		return sroList;
	}

	public void setSroList(List<SmRegOpt> sroList) {
	
		this.sroList = sroList;
	}

	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}


	public OperroomService getOperroomService() {
	
		return operroomService;
	}


	public void setOperroomService(OperroomService operroomService) {
	
		this.operroomService = operroomService;
	}


	public List<SmOperroom> getRoomList() {
	
		return roomList;
	}


	public void setRoomList(List<SmOperroom> roomList) {
	
		this.roomList = roomList;
	}


	public OperationPeopleService getOperationPeopleService() {
	
		return operationPeopleService;
	}


	public void setOperationPeopleService(
			OperationPeopleService operationPeopleService) {
	
		this.operationPeopleService = operationPeopleService;
	}


	public List<SmOperationPeople> getOpList() {
	
		return opList;
	}


	public void setOpList(List<SmOperationPeople> opList) {
	
		this.opList = opList;
	}


	public List<SmRegOpt> getSroYuyYueList() {
	
		return sroYuyYueList;
	}


	public void setSroYuyYueList(List<SmRegOpt> sroYuyYueList) {
	
		this.sroYuyYueList = sroYuyYueList;
	}


	public String getQxid() {
	
		return qxid;
	}


	public void setQxid(String qxid) {
	
		this.qxid = qxid;
	}


	public String getValue() {
	
		return value;
	}


	public void setValue(String value) {
	
		this.value = value;
	}

	public String getSroid() {
		return sroid;
	}

	public void setSroid(String sroid) {
		this.sroid = sroid;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getCircunurse1() {
		return circunurse1;
	}

	public void setCircunurse1(String circunurse1) {
		this.circunurse1 = circunurse1;
	}

	public String getCircunurse2() {
		return circunurse2;
	}

	public void setCircunurse2(String circunurse2) {
		this.circunurse2 = circunurse2;
	}

	public String getInstrnurse1() {
		return instrnurse1;
	}

	public void setInstrnurse1(String instrnurse1) {
		this.instrnurse1 = instrnurse1;
	}

	public String getInstrnurse2() {
		return instrnurse2;
	}

	public void setInstrnurse2(String instrnurse2) {
		this.instrnurse2 = instrnurse2;
	}

	/**
	 * @return the permissionService
	 */
	public PermissionService getPermissionService() {
		return permissionService;
	}

	/**
	 * @param permissionService the permissionService to set
	 */
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	/**
	 * @return the affirmRole
	 */
	public boolean isAffirmRole() {
		return affirmRole;
	}

	/**
	 * @param affirmRole the affirmRole to set
	 */
	public void setAffirmRole(boolean affirmRole) {
		this.affirmRole = affirmRole;
	}

	/**
	 * @return the removeRole
	 */
	public boolean isRemoveRole() {
		return removeRole;
	}

	/**
	 * @param removeRole the removeRole to set
	 */
	public void setRemoveRole(boolean removeRole) {
		this.removeRole = removeRole;
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

}
