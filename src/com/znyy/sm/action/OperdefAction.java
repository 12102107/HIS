package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmOperdef;
import com.znyy.sm.service.OperdefService;
import com.znyy.sys.user.service.PermissionService;
 /** 
 * @类名称: OperdefAction
 * @类描述:手术Action
 * @作者:付士山
 * @创建时间:2015-12-28 上午10:02:13
 */
 
public class OperdefAction extends AbstractAction {
	private OperdefService operdefService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String name;
	private String info;
	private String id;
	private SmOperdef so;
	private String ssname;
	private String pinyin;
	private String yx;
	private String code;

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
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid;
	
	 /**
	 * @方法名称: getSsList
	 * @功能描述: 获取手术名称列表
	 * @作者:付士山
	 * @创建时间:2015-12-28 上午10:07:12
	 * @return String   
	 */
	 
	public String getSsList() {
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
		Page pageSsList = operdefService.getSsList(ssname,yx,pinyin,code, parmpage, pageSize);
		request.setAttribute("totalP", pageSsList.getTotalPageCount());
		request.setAttribute("totalN", pageSsList.getTotalCount());
		request.setAttribute("ssList", pageSsList.getData());
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
	 * @方法名称: modSsListTo
	 * @功能描述: 修改手术名称列表跳转
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:18:06
	 * @return String   
	 */
	 
	public String modSsListTo() {
		so = operdefService.getSsById(id);
		return "success";
	}
	
	 /**
	 * @方法名称: modSsList
	 * @功能描述: 修改手术名称列表
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:59:33
	 * @return String   
	 */
	 
	public String modSsList() {
		SmOperdef ss = operdefService.getSsById(id);
		ss.setName(so.getName());
		ss.setPinyin(so.getPinyin());
		ss.setEnable(so.getEnable());
		try {
			operdefService.modSsList(ss);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	
	 /**
	 * @方法名称: addSsGo
	 * @功能描述: 跳转到手术名称添加页
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午2:31:03
	 * @return String   
	 */
	 
	public String addSsGo(){
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: addSs
	 * @功能描述:添加手术信息 
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午2:44:05
	 * @return String   
	 */
	 
	public String addSs(){
		String result="success";
		try {
			operdefService.addSs(so);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	
	
	 /**
	 * @方法名称: getSsByName
	 * @功能描述: ajax验证手术名称
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:13:55
	 * @return String   
	 */
	 
	public String getSsByName(){
		String responseInfo="";
		
		try {
			String name=request.getParameter("name");
			List<SmOperdef> list=operdefService.getSsByName(name);
			
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
	 * @方法名称: getSsByCode
	 * @功能描述: ajax验证手术代码
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午5:57:45
	 * @return String   
	 */
	 
	public String getSsByCode(){
		String responseInfo="";
		
		try {
			String code=request.getParameter("code");
			List<SmOperdef> list=operdefService.getSsByCode(code);
			
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



	public String getName() {
	
		return name;
	}



	public void setName(String name) {
	
		this.name = name;
	}

	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}



	public SmOperdef getSo() {
	
		return so;
	}



	public void setSo(SmOperdef so) {
	
		this.so = so;
	}



	public OperdefService getSsService() {
	
		return operdefService;
	}



	public void setSsService(OperdefService operdefService) {
	
		this.operdefService = operdefService;
	}



	public OperdefService getOperdefService() {
	
		return operdefService;
	}



	public void setOperdefService(OperdefService operdefService) {
	
		this.operdefService = operdefService;
	}



	public String getSsname() {
	
		return ssname;
	}



	public void setSsname(String ssname) {
	
		this.ssname = ssname;
	}



	public String getPinyin() {
	
		return pinyin;
	}



	public void setPinyin(String pinyin) {
	
		this.pinyin = pinyin;
	}



	public String getYx() {
	
		return yx;
	}



	public void setYx(String yx) {
	
		this.yx = yx;
	}



	public String getCode() {
	
		return code;
	}



	public void setCode(String code) {
	
		this.code = code;
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
