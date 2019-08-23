/**  
 * @Title: StatisticsAction.java 
 * @Package com.znyy.sm.action 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-3-15 下午1:33:29 
 */ 
package com.znyy.sm.action;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.common.action.CommAction;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.XtUnit;
import com.znyy.sm.service.StatisticsService;

/** 
 * @ClassName: StatisticsAction 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-3-15 下午1:33:29 
 */
public class StatisticsAction extends CommAction {

	private StatisticsService statisticsService;

	/**
	 * @return the statisticsService
	 */
	public StatisticsService getStatisticsService() {
		return statisticsService;
	}

	/**
	 * @param statisticsService the statisticsService to set
	 */
	public void setStatisticsService(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}

	private String start;
	private String end;
	private String month;
	private String sType;
	private String deptname;
	private String sopname;
	private String nursename;
	
	/**
	 * 
	 * @Title: levelStatistics 
	 * @Description: 手术等级统计
	 * @author 白东旭
	 * @date 2016-3-17 上午10:31:33
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String levelStatistics() {
		
		List<XtUnit> dept = statisticsService.getSmDept();
		request.setAttribute("dept", dept);
		
		List<SmOperationPeople> sop = statisticsService.getAnesthetist();
		request.setAttribute("sop", sop);
		
		List<SmOperationPeople> nurse = statisticsService.getNurse();
		request.setAttribute("nurse", nurse);
		
		List<Map<String, String>> result;
		try {
			result = statisticsService.getLevelStatistics(start,end,sType,deptname,sopname,nursename);				
			request.setAttribute("result", result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: workingTime 
	 * @Description: 工作时间统计
	 * @author 白东旭
	 * @date 2016-3-17 上午10:32:24
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String workingTime() {
		
		List<XtUnit> dept = statisticsService.getSmDept();
		request.setAttribute("dept", dept);
		
		List<SmOperationPeople> sop = statisticsService.getAnesthetist();
		request.setAttribute("sop", sop);
		
		List<SmOperationPeople> nurse = statisticsService.getNurse();
		request.setAttribute("nurse", nurse);
		
		List<Map<String, String>> result;
		try {
			result = statisticsService.getWorkingTime(start,end,sType,deptname,sopname,nursename);				
			request.setAttribute("result", result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	/**
	 * 
	 * @Description: 镇痛治疗例数统计
	 * @param @return   
	 * @return String  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-12
	 */
	public String analgesiaStatistics() {
		
		if(start==null&&end==null) {
			month = "1";
		}
		
		List<Object> result;
		try {
			result = statisticsService.getAnalgesiaStatistics(start,end);				
			request.setAttribute("result", result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 心肺复苏例数统计
	 * @param @return   
	 * @return String  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-12
	 */
	public String cprStatistics() {
		
		if(start==null&&end==null) {
			month = "1";
		}
		
		List<Object> result;
		try {
			result = statisticsService.getCprStatistics(start,end);				
			request.setAttribute("result", result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 麻醉复苏管理例数统计
	 * @param @return   
	 * @return String  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-12
	 */
	public String recoveryStatistics() {
		
		if(start==null&&end==null) {
			month = "1";
		}
		
		List<Object> result;
		try {
			result = statisticsService.getRecoveryStatistics(start,end);				
			request.setAttribute("result", result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: NISS统计
	 * @param @return   
	 * @return String  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-13
	 */
	public String nissStatistics() {
		
		if(start==null&&end==null) {
			month = "1";
		}
		
		List<Object> result;
		try {
			result = statisticsService.getNissStatistics(start,end);				
			request.setAttribute("result", result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 麻醉方法统计
	 * @param @return   
	 * @return String  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-14
	 */
	public String methodStatistics() {
		
		if(start==null&&end==null) {
			month = "1";
		}
		if(sType==null) {
			sType = "0";
		}
		List<XtUnit> dept = statisticsService.getSmDept();
		request.setAttribute("dept", dept);
		
		List<SmOperationPeople> sop = statisticsService.getAnesthetist();
		request.setAttribute("sop", sop);
		
		List<Map<String, Object>> result;
		try {
			result = statisticsService.getMethodStatistics(start,end,sType,deptname,sopname);				
			request.setAttribute("result", result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(String end) {
		this.end = end;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the sType
	 */
	public String getSType() {
		return sType;
	}

	/**
	 * @param sType the sType to set
	 */
	public void setSType(String sType) {
		this.sType = sType;
	}

	/**
	 * @return the deptname
	 */
	public String getDeptname() {
		return deptname;
	}

	/**
	 * @param deptname the deptname to set
	 */
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	/**
	 * @return the sopname
	 */
	public String getSopname() {
		return sopname;
	}

	/**
	 * @param sopname the sopname to set
	 */
	public void setSopname(String sopname) {
		this.sopname = sopname;
	}

	/**
	 * @return the nursename
	 */
	public String getNursename() {
		return nursename;
	}

	/**
	 * @param nursename the nursename to set
	 */
	public void setNursename(String nursename) {
		this.nursename = nursename;
	}
	
}
