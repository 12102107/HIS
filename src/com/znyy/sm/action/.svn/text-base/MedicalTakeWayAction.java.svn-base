package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmMedicalTakeWay;
import com.znyy.sm.service.MedicalTakeWayService;
import com.znyy.sys.user.service.PermissionService;


 /** 
 * @类名称: MedicalTakeWayAction
 * @类描述:给药途径Action
 * @作者:付士山
 * @创建时间:2016-1-8 上午11:22:37
 */
 
public class MedicalTakeWayAction extends AbstractAction {
	private MedicalTakeWayService medicalTakeWayService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String cname;
	private String info;
	private String id;
	private SmMedicalTakeWay mtw;
	private String code;
	private String fl;
	private String way;
	private String cx;

	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	 /**
	 * @方法名称: getWayList
	 * @功能描述: 获取给药途径信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:22:21
	 * @return String   
	 */
	 
	public String getWayList() {
		String result = "success";
	
		if (page == null || page.equals("")) {
			page = "1";
		}
		int parmpage = Integer.parseInt(page);

		if (pageSize == null) {
			pageSize = 8;
		}
		int newPage = Integer.parseInt(page);
		int xh = (newPage - 1) * pageSize + 1;
		Page pageWayList = medicalTakeWayService.getWayList(cname,code,way,fl,cx, parmpage, pageSize);
		request.setAttribute("totalP", pageWayList.getTotalPageCount());
		request.setAttribute("totalN", pageWayList.getTotalCount());
		request.setAttribute("wayList", pageWayList.getData());
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", parmpage);
		request.setAttribute("xh", xh);
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		updateRole = btnCodes.contains("update");
		addRole = btnCodes.contains("add");
		selectRole = btnCodes.contains("select");
		
		return result;
	}
	
	 /**
	 * @方法名称: modWayListTo
	 * @功能描述: 给药途径修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:38:34
	 * @return String   
	 */
	 
	public String modWayListTo() {
		mtw = medicalTakeWayService.getWayById(id);
		return "success";
	}
	
	 /**
	 * @方法名称: modWayList
	 * @功能描述: 给药途径修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:38:37
	 * @return String   
	 */
	 
	public String modWayList() {
		SmMedicalTakeWay way =  medicalTakeWayService.getWayById(id);
		way.setName(mtw.getName());
		way.setCategory(mtw.getCategory());
		way.setDurable(mtw.getDurable());
		way.setMeasureMode(mtw.getMeasureMode());
		try {
			medicalTakeWayService.modWayList(way);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	
	 /**
	 * @方法名称: addWayGo
	 * @功能描述: 跳转到添加给药途径的页面
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午2:11:13
	 * @return String   
	 */
	 
	public String addWayGo(){
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: getWayByName
	 * @功能描述: 
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午2:15:39
	 * @return String   
	 */
	 
	public String getWayByName(){
		String responseInfo="";
		
		try {
			String name=request.getParameter("name");
			List<SmMedicalTakeWay> list=medicalTakeWayService.getWayByName(name);
			
			if(list.size()>0){
				responseInfo="1";
			}else{
				responseInfo="0";
			}
			
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");   
	        PrintWriter out=response.getWriter();    
	        out.print(responseInfo);    
	        out.flush();    
	        out.close();  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	} 
	
	 /**
	 * @方法名称: getWayByCode
	 * @功能描述: 
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午2:15:30
	 * @return String   
	 */
	 
	public String getWayByCode(){
		String responseInfo="";
		
		try {
			String code=request.getParameter("code");
			List<SmMedicalTakeWay> list=medicalTakeWayService.getWayByCode(code);
			
			if(list.size()>0){
				responseInfo="1";
			}else{
				responseInfo="0";
			}
			
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");   
	        PrintWriter out=response.getWriter();    
	        out.print(responseInfo);    
	        out.flush();    
	        out.close();  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	 /**
	 * @方法名称: addWay
	 * @功能描述: 添加给药途径信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午4:28:52
	 * @return String   
	 */
	 
	public String addWay(){
		String result="success";
		try {
			medicalTakeWayService.addWay(mtw);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	public MedicalTakeWayService getMedicalTakeWayService() {
	
		return medicalTakeWayService;
	}
	public void setMedicalTakeWayService(MedicalTakeWayService medicalTakeWayService) {
	
		this.medicalTakeWayService = medicalTakeWayService;
	}
	public Integer getPageSize() {
	
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
	
		this.pageSize = pageSize;
	}
	public String getPage() {
	
		return page;
	}
	public void setPage(String page) {
	
		this.page = page;
	}
	public String getRows() {
	
		return rows;
	}
	public void setRows(String rows) {
	
		this.rows = rows;
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
	public SmMedicalTakeWay getMtw() {
	
		return mtw;
	}
	public void setMtw(SmMedicalTakeWay mtw) {
	
		this.mtw = mtw;
	}
	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}

	public String getCname() {
	
		return cname;
	}

	public void setCname(String cname) {
	
		this.cname = cname;
	}

	public String getCode() {
	
		return code;
	}

	public void setCode(String code) {
	
		this.code = code;
	}

	public String getFl() {
	
		return fl;
	}

	public void setFl(String fl) {
	
		this.fl = fl;
	}

	public String getWay() {
	
		return way;
	}

	public void setWay(String way) {
	
		this.way = way;
	}

	public String getCx() {
	
		return cx;
	}

	public void setCx(String cx) {
	
		this.cx = cx;
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
	 * @return the addRole
	 */
	public boolean isAddRole() {
		return addRole;
	}

	/**
	 * @param addRole the addRole to set
	 */
	public void setAddRole(boolean addRole) {
		this.addRole = addRole;
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
