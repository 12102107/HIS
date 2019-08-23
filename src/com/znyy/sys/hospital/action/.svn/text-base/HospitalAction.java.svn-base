
package com.znyy.sys.hospital.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.common.action.CommAction;
import com.common.util.JsonUtils;
import com.znyy.sys.hospital.service.HospitalService;

 /** 
 * @类名称: HospitalAction
 * @类描述:系统医院表action
 * @作者:慕金剑
 * @创建时间:2016-3-21 下午4:14:55
 */
 
public class HospitalAction extends CommAction{
	private HospitalService hospitalService;
	
	 /**
	 * @方法名称: getHospitalForLogin
	 * @功能描述: 为登录页面获取有效医院信息
	 * @作者:慕金剑
	 * @创建时间:2016-4-1 下午5:34:01
	 * @return String   
	 */
	 
	public void getHospitalForLogin(){
		try {
		List<Map<String, Object>> hospitaList=hospitalService.getHospitalAll();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(JsonUtils.toJSON(hospitaList));
		out.flush();
		out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HospitalService getHospitalService() {
	
		return hospitalService;
	}

	public void setHospitalService(HospitalService hospitalService) {
	
		this.hospitalService = hospitalService;
	}
	
	
}

