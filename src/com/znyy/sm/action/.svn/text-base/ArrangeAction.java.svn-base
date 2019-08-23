/**  
 * @Title: ArrangeAction.java 
 * @Package com.znyy.sm.action 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-23 下午1:20:22 
 */ 
package com.znyy.sm.action;


import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.CommAction;
import com.common.util.Util;
import com.common.util.XmlUtil;

import com.znyy.sm.service.ArrangeService;
import com.znyy.sys.user.service.PermissionService;

/** 
 * @ClassName: ArrangeAction 
 * @Description: 排班管理action 
 * @author 白东旭
 * @date 2016-2-23 下午1:20:22 
 */
public class ArrangeAction extends CommAction {

	private static final long serialVersionUID = 1L;
	private String dateFrom;
	private String dateTo;
	private ArrangeService arrangeService;

	/**
	 * @return the arrangeService
	 */
	public ArrangeService getArrangeService() {
		return arrangeService;
	}

	/**
	 * @param arrangeService the arrangeService to set
	 */
	public void setArrangeService(ArrangeService arrangeService) {
		this.arrangeService = arrangeService;
	}
	
	private PermissionService permissionService;
	private boolean selectRole; 
	private boolean selectTodayRole; 
	private boolean printRole; 
	private String functionid; 
	
	/**
	 * 
	 * @Title: myArrangeList 
	 * @Description: 获取我的排班 默认一周内
	 * @author 白东旭
	 * @date 2016-2-24 上午9:17:41
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String myArrangeList() {

		try {
			String userid = (String) session.get("userid");
			
			List<Map<String,Object>> result = arrangeService.getMyArrangeWeek(userid,dateFrom,dateTo);
			
			request.setAttribute("list", result);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: arrangePrintTo 
	 * @Description: 
	 * @author 白东旭
	 * @date 2016-2-24 上午9:18:03
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String arrangePrintTo() {
		
		try {

			List<Map<String,Object>> result = arrangeService.getArrangeWeek(dateFrom,dateTo);
			
			request.setAttribute("list", result);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		selectRole = btnCodes.contains("select");
		selectTodayRole = btnCodes.contains("selectToday");
		printRole = btnCodes.contains("print");
		
		return SUCCESS;
		
	}
	
	/**
	 * 
	 * @Title: loadPrint 
	 * @Description: 获取打印数据
	 * @author 白东旭
	 * @date 2016-2-24 下午5:58:41
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void loadPrint() {
		try {
			
			List<Map<String, Object>> result = arrangeService.getArrangeWeekPrint();
		
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

	public String getDateFrom() {
	
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
	
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
	
		return dateTo;
	}

	public void setDateTo(String dateTo) {
	
		this.dateTo = dateTo;
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
	 * @return the selectRole
	 */
	public boolean isSelectRole() {
		return selectRole;
	}

	/**
	 * @param selectRole the selectRole to set
	 */
	public void setSelectRole(boolean selectRole) {
		this.selectRole = selectRole;
	}

	/**
	 * @return the selectTodayRole
	 */
	public boolean isSelectTodayRole() {
		return selectTodayRole;
	}

	/**
	 * @param selectTodayRole the selectTodayRole to set
	 */
	public void setSelectTodayRole(boolean selectTodayRole) {
		this.selectTodayRole = selectTodayRole;
	}

	/**
	 * @return the printRole
	 */
	public boolean isPrintRole() {
		return printRole;
	}

	/**
	 * @param printRole the printRole to set
	 */
	public void setPrintRole(boolean printRole) {
		this.printRole = printRole;
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
