package com.znyy.sys.unit.action;

import java.util.List;
import java.util.Map;

import com.common.action.CommAction;
import com.common.util.Util;
import com.znyy.sys.unit.service.UnitService;

public class UnitAction extends CommAction{
	
	private UnitService unitService;
	 /**
	 * @方法名称: selMoreUnitTo
	 * @功能描述: 跳转到多科室选择页面
	 * @作者:慕金剑
	 * @创建时间:2016-4-6 上午9:27:33
	 * @return String   
	 */
	public String selMoreUnitTo(){
		String moreunitflag=request.getParameter("moreunitflag");
		Integer loginUserId=Util.getIntegerValue(session.get("userid"));
		String hospitalid=(String) session.get("hospitalid");
		//根据当前登录人员id，多科室选择标示，查询符合条件的科室信息
		List<Map<String, Object>> units = unitService.getMoreUnitSel(
				loginUserId,hospitalid,moreunitflag);
		request.setAttribute("units", units);
		request.setAttribute("loginUserId", loginUserId);
		request.setAttribute("MoreUnitUrl", request.getParameter("MoreUnitUrl"));
		return SUCCESS;
	}
	public UnitService getUnitService() {
	
		return unitService;
	}
	public void setUnitService(UnitService unitService) {
	
		this.unitService = unitService;
	}

}
