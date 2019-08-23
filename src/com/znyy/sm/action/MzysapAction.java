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
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.service.OperationPeopleService;
import com.znyy.sm.service.RegOptService;
import com.znyy.sys.user.service.PermissionService;
public class MzysapAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private String qxid;
	private String value;
	private String id;
	private String info;
	private SmRegOpt sro;
	private RegOptService regOptService;
	private List<SmRegOpt> sroList;
	private List<SmRegOpt> sroMzysapList;
	private OperationPeopleService operationPeopleService;
	private List<SmOperationPeople> opList;

	
	private String sroid;
	
	private String anesthetist;
	private String circuanesthetist;
	private String anaesAssistant;
	
	private PermissionService permissionService;
	private boolean affirmRole; 
	private boolean removeRole; 
	private String functionid; 
	
	public String getMzysList() {
		
		String hospitalId = (String) this.session.get("hospitalid");
		List<Map<String,Object>> yyList = regOptService.getSroMzysList(hospitalId);
		request.setAttribute("yyList", yyList);
		
		opList= operationPeopleService.getOpList("0");

		sroList = regOptService.getMzysList(hospitalId);
		
		List<SmOperationPeople> anesthetist = operationPeopleService.getSops("0", "手术麻醉医师");
		List<SmOperationPeople> circuanesthetist = operationPeopleService.getSops("0", "巡台麻醉医师");
		List<SmOperationPeople> anaesAssistant = operationPeopleService.getSops("0", "灌注医师");
		
		request.setAttribute("anesthetist", anesthetist);
		request.setAttribute("circuanesthetist", circuanesthetist);
		request.setAttribute("anaesAssistant", anaesAssistant);
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		affirmRole = btnCodes.contains("affirm");
		removeRole = btnCodes.contains("remove");
		
		return SUCCESS;
	}
	
	
	 /**
	 * @方法名称: ssapQxList
	 * @功能描述: 麻醉医生安排取消
	 * @作者:付士山
	 * @创建时间:2016-1-27 上午10:51:09
	 * @return String   
	 */
	 
	public String mzysQxList() {
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
	 * @Description: 麻醉医生安排
	 * @author 白东旭
	 * @date 2016-2-18 上午10:10:46
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void reservation() {
		regOptService.modMzysReservation(sroid,anesthetist,circuanesthetist,anaesAssistant);
	}
	
	/**
	 * 
	 * @Title: reservationList 
	 * @Description: 已安排麻醉医生列表
	 * @author 白东旭
	 * @date 2016-2-18 上午10:15:12
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void reservationList() {
		String hospitalId = (String) this.session.get("hospitalid");
		List<Map<String,Object>> sroYuYueList = regOptService.getSroMzysList(hospitalId);
		
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


	public List<SmRegOpt> getSroMzysapList() {
	
		return sroMzysapList;
	}


	public void setSroMzysapList(List<SmRegOpt> sroMzysapList) {
	
		this.sroMzysapList = sroMzysapList;
	}


	/**
	 * @return the sroid
	 */
	public String getSroid() {
		return sroid;
	}


	/**
	 * @param sroid the sroid to set
	 */
	public void setSroid(String sroid) {
		this.sroid = sroid;
	}


	/**
	 * @return the anesthetist
	 */
	public String getAnesthetist() {
		return anesthetist;
	}


	/**
	 * @param anesthetist the anesthetist to set
	 */
	public void setAnesthetist(String anesthetist) {
		this.anesthetist = anesthetist;
	}


	/**
	 * @return the circuanesthetist
	 */
	public String getCircuanesthetist() {
		return circuanesthetist;
	}


	/**
	 * @param circuanesthetist the circuanesthetist to set
	 */
	public void setCircuanesthetist(String circuanesthetist) {
		this.circuanesthetist = circuanesthetist;
	}


	/**
	 * @return the anaesAssistant
	 */
	public String getAnaesAssistant() {
		return anaesAssistant;
	}


	/**
	 * @param anaesAssistant the anaesAssistant to set
	 */
	public void setAnaesAssistant(String anaesAssistant) {
		this.anaesAssistant = anaesAssistant;
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
