package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmCheckItem;
import com.znyy.sm.service.CheckItemService;
import com.znyy.sys.user.service.PermissionService;



 /** 
 * @类名称: CheckItemAction
 * @类描述:项目检出Action
 * @作者:付士山
 * @创建时间:2016-1-7 下午2:13:54
 */
 
public class CheckItemAction extends AbstractAction {
	private CheckItemService checkItemService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String cname;
	private String info;
	private String id;
	private SmCheckItem sci;
	private String code;
	private String dw;
	private String yx;
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	 /**
	 * @方法名称: getCheckList
	 * @功能描述: 获取检验项目信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:14:27
	 * @return String   
	 */
	 
	public String getCheckList() {
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
		Page pageCheckList = checkItemService.getCheckList(cname,dw,code,yx, parmpage, pageSize);
		request.setAttribute("totalP", pageCheckList.getTotalPageCount());
		request.setAttribute("totalN", pageCheckList.getTotalCount());
		request.setAttribute("checkList", pageCheckList.getData());
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
	 * @方法名称: modCheckListTo
	 * @功能描述: 检验项目修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:40:43
	 * @return String   
	 */
	 
	public String modCheckListTo() {
		sci = checkItemService.getCheckById(id);
		return "success";
	}
	
	 /**
	 * @方法名称: modCheckList
	 * @功能描述: 检验项目修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:40:46
	 * @return String   
	 */
	 
	public String modCheckList() {
		SmCheckItem ci = checkItemService.getCheckById(id);
		ci.setName(sci.getName());
		ci.setUnit(sci.getUnit());
		ci.setEnable(sci.getEnable());
		try {
			checkItemService.modCheckList(ci);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	
	 /**
	 * @方法名称: addCheckGo
	 * @功能描述: 跳转到添加检验项目的页面
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午4:41:32
	 * @return String   
	 */
	 
	public String addCheckGo(){
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: addCheck
	 * @功能描述: 添加检验项目信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午5:14:41
	 * @return String   
	 */
	 
	public String addCheck(){
		String result="success";
		try {
			checkItemService.addCheck(sci);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	 /**
	 * @方法名称: getCheckByName
	 * @功能描述: ajax验证检验项目名称
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午4:55:31
	 * @return String   
	 */
	 
	public String getCheckByName(){
		String responseInfo="";
		
		try {
			String name=request.getParameter("name");
			List<SmCheckItem> list=checkItemService.getCheckByName(name);
			
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
	 * @方法名称: getCheckByCode
	 * @功能描述: ajax验证检验项目代码 
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午4:55:35
	 * @return String   
	 */
	 
	public String getCheckByCode(){
		String responseInfo="";
		
		try {
			String code=request.getParameter("code");
			List<SmCheckItem> list=checkItemService.getCheckByCode(code);
			
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
	public CheckItemService getCheckItemService() {
	
		return checkItemService;
	}
	public void setCheckItemService(CheckItemService checkItemService) {
	
		this.checkItemService = checkItemService;
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
	public SmCheckItem getSci() {
	
		return sci;
	}
	public void setSci(SmCheckItem sci) {
	
		this.sci = sci;
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

	public String getDw() {
	
		return dw;
	}

	public void setDw(String dw) {
	
		this.dw = dw;
	}

	public String getYx() {
	
		return yx;
	}

	public void setYx(String yx) {
	
		this.yx = yx;
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
