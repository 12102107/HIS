/**  
 * @Title: QueryAction.java 
 * @Package com.znyy.sm.action 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-19 上午9:17:13 
 */ 
package com.znyy.sm.action;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.common.action.CommAction;
import com.common.util.Util;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SysCvFyzflb;
import com.znyy.bean.SysDiseaseArea;
import com.znyy.bean.SysIcdCode;
import com.znyy.bean.XtUnit;
import com.znyy.sm.service.QueryService;
import com.znyy.sys.user.service.PermissionService;

/** 
 * @ClassName: QueryAction 
 * @Description: 手术查询Action
 * @author 白东旭
 * @date 2016-2-19 上午9:17:13 
 */
public class QueryAction extends CommAction {

	private static final long serialVersionUID = 1L;

	private QueryService queryService;

	/**
	 * @return the queryService
	 */
	public QueryService getQueryService() {
		return queryService;
	}

	/**
	 * @param queryService the queryService to set
	 */
	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}
	
	private String sroid;
	
	private String reason;
	
	private SmRegOpt sro;
	
	private Date operdate;
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean removeRole;
	private boolean activateRole;
	private boolean affirmRole;
	private String functionid; 
	
	private String dateFrom;
	private String dateTo;
	private String sex;
	private String age;
	private String zd;
	private String ss;
	private String mz;
	
	
	/**
	 * 
	 * @Title: getSroList 
	 * @Description: 获取七天内的手术登记信息
	 * @author 白东旭
	 * @date 2016-2-19 上午9:31:57
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String getSroList() {
		
		try {
			String hospitalId = (String) this.session.get("hospitalid");
			List<Map<String,Object>> result = queryService.getSroListWeek(hospitalId);
			
			request.setAttribute("list", result);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		activateRole = btnCodes.contains("activate");
		removeRole = btnCodes.contains("remove");
		updateRole = btnCodes.contains("update");
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: cancelSro 
	 * @Description: 取消手术信息
	 * @author 白东旭
	 * @date 2016-2-19 下午1:49:57
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void cancelSro() {
		
		queryService.modCancelSro(sroid,reason);
		
	}

	/**
	 * 
	 * @Title: activateSro 
	 * @Description: 激活手术信息
	 * @author 白东旭
	 * @date 2016-2-19 下午2:14:35
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void activateSro() {
		
		queryService.activateSro(sroid);
		
	}
	
	/**
	 * 
	 * @Title: changeSroTo 
	 * @Description: 变更手术信息跳转
	 * @author 白东旭
	 * @date 2016-2-19 下午2:42:31
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String changeSroTo() {
		
		SmRegOpt sro;
		try {
			sro = queryService.getSmRegOptById(sroid);
			request.setAttribute("sro", sro);
			
			List<SysCvFyzflb> l = queryService.getSysCvFyzflbList();
			request.setAttribute("sysCvFyzflb", l);
			
			String hospitalId = (String) this.session.get("hospitalid");
			List<XtUnit> deptList = queryService.getDepts(hospitalId);
			request.setAttribute("deptList", deptList);
			
			List<SysDiseaseArea> regionList = queryService.getSmRegionList();
			request.setAttribute("regionList", regionList);
			request.setAttribute("region", sro.getRegion());
			
			/*List<SmDiagnosedef> diagnosedef = queryService.getSmDiagnosedefList();*/
			List<SysIcdCode> diagnosedef = queryService.getSysIcdCodeList();
			request.setAttribute("diagnosedef", sro.getDiagnosisName());
			request.setAttribute("diagnosedefList", diagnosedef);
		
			List<SmOperdef> designedOptName = queryService.getSmOperdefList();
			request.setAttribute("designedOptName", sro.getDesignedOptName());
			request.setAttribute("designedOptNameList", designedOptName);
		
			List<SmOperationPeople> operator = queryService.getSmOperationPeopleList("手术医师");
			request.setAttribute("operatorId", sro.getOperatorId());
			request.setAttribute("operatorName", sro.getOperatorName());
			request.setAttribute("operatorList", operator);
			
			List<SmOperroom> roomList = queryService.getSmOperroomList();
			request.setAttribute("roomList", roomList);
			request.setAttribute("room", sro.getRoom());
			
			List<SmOperationPeople> circunurse = queryService.getSmOperationPeopleList("器械护士");
			List<SmOperationPeople> instrnurse = queryService.getSmOperationPeopleList("巡回护士");
			request.setAttribute("circunurse", circunurse);
			request.setAttribute("instrnurse", instrnurse);
			
			request.setAttribute("circunurse1", sro.getCircunurse1());
			request.setAttribute("instrnurse1", sro.getInstrnurse1());
			request.setAttribute("circunurse2", sro.getCircunurse2());
			request.setAttribute("instrnurse2", sro.getInstrnurse2());
			
			List<SmOperationPeople> anesthetist = queryService.getSmOperationPeopleList("手术麻醉医师");
			List<SmOperationPeople> circuanesthetist = queryService.getSmOperationPeopleList("巡台麻醉医师");
			List<SmOperationPeople> anaesAssistant = queryService.getSmOperationPeopleList("灌注医师");
			request.setAttribute("anesthetistList", anesthetist);
			request.setAttribute("circuanesthetistList", circuanesthetist);
			request.setAttribute("anaesAssistantList", anaesAssistant);
			
			request.setAttribute("anesthetist", sro.getAnesthetist());
			request.setAttribute("circuanesthetist", sro.getCircuanesthetist());
			request.setAttribute("anaesAssistant", sro.getAnaesAssistant());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
		
	}
	
	/**
	 * 
	 * @Title: changeSro 
	 * @Description: 变更手术信息
	 * @author 白东旭
	 * @date 2016-2-22 下午1:16:20
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void changeSro() {
		queryService.modChangeSro(sro,operdate);
	}
	
	/**
	 * 
	 * @Title: emergencyTo 
	 * @Description: 紧急手术跳转
	 * @author 白东旭
	 * @date 2016-2-22 下午3:53:49
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String emergencyTo() {
		
		String hospitalId = (String) this.session.get("hospitalid");
		List<XtUnit> deptList = queryService.getDepts(hospitalId);
		request.setAttribute("deptList", deptList);
		
		List<SysCvFyzflb> l = queryService.getSysCvFyzflbList();
		request.setAttribute("sysCvFyzflb", l);
		
		List<SysDiseaseArea> regionList = queryService.getSmRegionList();
		request.setAttribute("regionList", regionList);
		
		/*List<SmDiagnosedef> diagnosedef = queryService.getSmDiagnosedefList();*/
		List<SysIcdCode> diagnosedef = queryService.getSysIcdCodeList();
		request.setAttribute("diagnosedefList", diagnosedef);
	
		List<SmOperdef> designedOptName = queryService.getSmOperdefList();
		request.setAttribute("designedOptNameList", designedOptName);
	
		List<SmOperationPeople> operator = queryService.getSmOperationPeopleList("手术医师");
		request.setAttribute("operatorList", operator);
		
		List<SmOperroom> roomList = queryService.getSmOperroomList();
		request.setAttribute("roomList", roomList);
		
		List<SmOperationPeople> circunurse = queryService.getSmOperationPeopleList("器械护士");
		List<SmOperationPeople> instrnurse = queryService.getSmOperationPeopleList("巡回护士");
		request.setAttribute("circunurse", circunurse);
		request.setAttribute("instrnurse", instrnurse);
		
		List<SmOperationPeople> anesthetist = queryService.getSmOperationPeopleList("手术麻醉医师");
		List<SmOperationPeople> circuanesthetist = queryService.getSmOperationPeopleList("巡台麻醉医师");
		List<SmOperationPeople> anaesAssistant = queryService.getSmOperationPeopleList("灌注医师");
		request.setAttribute("anesthetistList", anesthetist);
		request.setAttribute("circuanesthetistList", circuanesthetist);
		request.setAttribute("anaesAssistantList", anaesAssistant);
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		affirmRole = btnCodes.contains("affirm");
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: addEmergencySro 
	 * @Description: 添加紧急手术
	 * @author 白东旭
	 * @date 2016-2-22 下午4:53:49
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void addEmergencySro() {
		String hospitalId = (String) this.session.get("hospitalid");
		queryService.addEmergencySro(sro,operdate,hospitalId);
	}
	
	/**
	 * 
	 * @Title: getOutside 
	 * @Description: 手术室外大屏幕
	 * @author 白东旭
	 * @date 2016-3-21 下午1:11:44
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String getOutside() {
		String hospitalId = (String) this.session.get("hospitalid");
		List<Map<String,Object>> r = queryService.getOutsideScreen(hospitalId);
		request.setAttribute("r", r);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: getInside 
	 * @Description: 手术室内大屏幕
	 * @author 白东旭
	 * @date 2016-3-21 下午1:12:03
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String getInside() {
		String hospitalId = (String) this.session.get("hospitalid");
		List<Map<String, Object>> r;
		try {
			r = queryService.getInsideScreen(hospitalId);
			request.setAttribute("r", r);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 科研查询
	 * @param @return   
	 * @return String  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-27
	 */
	public String scientificQuery() {
		
		try {
			List<Map<String, Object>> list = queryService.getScientificQuery(dateFrom,dateTo,sex,age,zd,ss,mz);
			request.setAttribute("list", list);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
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
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the sro
	 */
	public SmRegOpt getSro() {
		return sro;
	}

	/**
	 * @param sro the sro to set
	 */
	public void setSro(SmRegOpt sro) {
		this.sro = sro;
	}

	/**
	 * @return the operdate
	 */
	public Date getOperdate() {
		return operdate;
	}

	/**
	 * @param operdate the operdate to set
	 */
	public void setOperdate(Date operdate) {
		this.operdate = operdate;
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
	 * @return the updateRole
	 */
	public boolean isUpdateRole() {
		return updateRole;
	}

	/**
	 * @param updateRole the updateRole to set
	 */
	public void setUpdateRole(boolean updateRole) {
		this.updateRole = updateRole;
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
	 * @return the activateRole
	 */
	public boolean isActivateRole() {
		return activateRole;
	}

	/**
	 * @param activateRole the activateRole to set
	 */
	public void setActivateRole(boolean activateRole) {
		this.activateRole = activateRole;
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
	 * @return the dateFrom
	 */
	public String getDateFrom() {
		return dateFrom;
	}

	/**
	 * @param dateFrom the dateFrom to set
	 */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	/**
	 * @return the dateTo
	 */
	public String getDateTo() {
		return dateTo;
	}

	/**
	 * @param dateTo the dateTo to set
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the zd
	 */
	public String getZd() {
		return zd;
	}

	/**
	 * @param zd the zd to set
	 */
	public void setZd(String zd) {
		this.zd = zd;
	}

	/**
	 * @return the ss
	 */
	public String getSs() {
		return ss;
	}

	/**
	 * @param ss the ss to set
	 */
	public void setSs(String ss) {
		this.ss = ss;
	}

	/**
	 * @return the mz
	 */
	public String getMz() {
		return mz;
	}

	/**
	 * @param mz the mz to set
	 */
	public void setMz(String mz) {
		this.mz = mz;
	}
}
