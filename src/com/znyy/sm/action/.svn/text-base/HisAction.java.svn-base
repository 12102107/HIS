package com.znyy.sm.action;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.common.action.AbstractAction;
import com.common.util.DateUtil;
import com.common.util.Util;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SysCvFyzflb;
import com.znyy.bean.SysDiseaseArea;
import com.znyy.bean.SysIcdCode;
import com.znyy.bean.ZyOperationApply;
import com.znyy.sm.service.HisService;
import com.znyy.sm.service.QueryService;
import com.znyy.sm.service.RegOptService;
import com.znyy.sys.user.service.PermissionService;



/** 
* @类名称: HisAction
* @类描述:HISAction
* @作者:崔连瑞
* @创建时间:2016-5-18 上午10:23:13
*/
public class HisAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QueryService queryService;
	private HisService hisService;
	private SmRegOpt sro;
	private RegOptService regOptService;
	private List<ZyOperationApply> zoaList;
	private String info;
	private String id;
	private ZyOperationApply his;
	private String YYoperdate;
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean removeRole;
	private boolean activateRole;
	private boolean affirmRole;
	private String functionid;  
	
	
	
	
	
	
	
	
	 /**
	 * @方法名称: getHisList
	 * @功能描述: 获取His预约病人
	 * @作者:崔连瑞
	 * @创建时间:2016-5-18上午10:40:11
	 * @return String   
	 */
	public String getHisList() throws ParseException{
	
		if (id!=null &&  id.trim().length()>0) {
			his = hisService.getHisById(Long.parseLong(id) );}
			zoaList = hisService.getZyOperationApply();

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
		
		request.setAttribute("info", info);
		List<String> btnCodes = permissionService.getBtnCode(Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		affirmRole = btnCodes.contains("affirm");
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: modHisList
	 * @功能描述: 修改His
	 * @作者:付士山
	 * @创建时间:2016-5-18 下午5:58:58
	 * @return String   
	 */
	 
	public String modHisList() {
		String result="success";
		sro.setOperdate(DateUtil.toDate(YYoperdate, DateUtil.DATE_PATTERN));
		sro.setCreateTime(new Date());
		sro.setState("03");
		sro.setArchstate("00");
		try {
			regOptService.addSsdj(sro);
			ZyOperationApply hiss = hisService.getHisById(Long.parseLong(id) );
			hiss.setState("2");
			hisService.modHisList(hiss);
			info = "添加成功";
		} catch (Exception e) {
			info = "添加失败";
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public String modStateList() {
		String result="success";
		try {
			ZyOperationApply hiss = hisService.getHisById(Long.parseLong(id) );
			System.out.println(hiss+"Ssssssssssssssssssssssssssss");
			hiss.setState("1");
			hisService.modHisList(hiss);
			info = "取消成功";
		} catch (Exception e) {
			info = "取消失败";
			e.printStackTrace();
		}
		
		return result;
	}
	public QueryService getQueryService() {
	
		return queryService;
	}

	public void setQueryService(QueryService queryService) {
	
		this.queryService = queryService;
	}

	public HisService getHisService() {
	
		return hisService;
	}

	public void setHisService(HisService hisService) {
	
		this.hisService = hisService;
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



	public String getInfo() {
	
		return info;
	}

	public void setInfo(String info) {
	
		this.info = info;
	}

	public String getId() {
	
		return id;
	}

	public void setId(String id) {
	
		this.id = id;
	}

	public ZyOperationApply getHis() {
	
		return his;
	}

	public void setHis(ZyOperationApply his) {
	
		this.his = his;
	}

	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}

	public String getYYoperdate() {
	
		return YYoperdate;
	}

	public void setYYoperdate(String yYoperdate) {
	
		YYoperdate = yYoperdate;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public boolean isAffirmRole() {
		return affirmRole;
	}

	public void setAffirmRole(boolean affirmRole) {
		this.affirmRole = affirmRole;
	}

	public boolean isRemoveRole() {
		return removeRole;
	}

	public void setRemoveRole(boolean removeRole) {
		this.removeRole = removeRole;
	}

	public String getFunctionid() {
		return functionid;
	}

	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}

	public boolean isUpdateRole() {
		return updateRole;
	}

	public void setUpdateRole(boolean updateRole) {
		this.updateRole = updateRole;
	}

	public boolean isActivateRole() {
		return activateRole;
	}

	public void setActivateRole(boolean activateRole) {
		this.activateRole = activateRole;
	}

	/**
	 * @return the zoaList
	 */
	public List<ZyOperationApply> getZoaList() {
		return zoaList;
	}

	/**
	 * @param zoaList the zoaList to set
	 */
	public void setZoaList(List<ZyOperationApply> zoaList) {
		this.zoaList = zoaList;
	}
	

}
