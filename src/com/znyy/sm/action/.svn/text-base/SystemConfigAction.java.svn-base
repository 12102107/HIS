package com.znyy.sm.action;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmSystemConfig;
import com.znyy.sm.service.SystemConfigService;
import com.znyy.sys.user.service.PermissionService;

 /** 
 * @类名称: SystemConfigAction
 * @类描述:系统及参数配置Action
 * @作者:付士山
 * @创建时间:2016-1-12 下午1:40:28
 */
 
public class SystemConfigAction extends AbstractAction {
	private SystemConfigService systemConfigService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String code;
	private Integer id;
	private SmSystemConfig config;
	private String info;
	private String yx;
	private String xname;
	private String fl;
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	 /**
	 * @方法名称: getConfigList
	 * @功能描述: 获取系统及参数配置信息
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:46:08
	 * @return String   
	 */
	 
	public String getConfigList() {
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
		Page pageConfigList = systemConfigService.getConfigList(code,xname,fl,yx, parmpage, pageSize);
		request.setAttribute("totalP", pageConfigList.getTotalPageCount());
		request.setAttribute("totalN", pageConfigList.getTotalCount());
		request.setAttribute("configList", pageConfigList.getData());
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
	 * @方法名称: modConfigListTo
	 * @功能描述: 系统及参数配置修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:55:47
	 * @return String   
	 */
	 
	public String modConfigListTo() {
		config = systemConfigService.getConfigById(id);
		return "success";
	}
	
	
	 
	
	 /**
	 * @方法名称: modConfigList
	 * @功能描述: 系统及参数配置修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:55:51
	 * @return String   
	 */
	 
	public String modConfigList() {
		SmSystemConfig con =  systemConfigService.getConfigById(id);
		con.setCode(config.getCode());
		con.setEnable(config.getEnable());
		con.setCategory(config.getCategory());
		con.setName(config.getName());
		con.setValue(config.getValue());
		try {
			systemConfigService.modConfigList(con);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	
	 /**
	 * @方法名称: addConfigGo
	 * @功能描述: 跳转到添加系统及参数配置的页面 
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午2:05:46
	 * @return String   
	 */
	 
	public String addConfigGo(){
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: addConfig
	 * @功能描述: 添加系统及参数配置信息
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午2:19:51
	 * @return String   
	 */
	 
	public String addConfig(){
		String result="success";
		try {
			systemConfigService.addConfig(config);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	
	
	 /**
	 * @方法名称: getConfigByName
	 * @功能描述: ajax系统及参数配置名称
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午2:46:23
	 * @return String   
	 */
	 
	public String getConfigByName(){
		String responseInfo="";
		
		try {
			String name=request.getParameter("name");
			List<SmSystemConfig> list=systemConfigService.getConfigByName(name);
			
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
	public SystemConfigService getSystemConfigService() {
	
		return systemConfigService;
	}
	public void setSystemConfigService(SystemConfigService systemConfigService) {
	
		this.systemConfigService = systemConfigService;
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
	public Integer getId() {
	
		return id;
	}
	public void setId(Integer id) {
	
		this.id = id;
	}
	public SmSystemConfig getConfig() {
	
		return config;
	}
	public void setConfig(SmSystemConfig config) {
	
		this.config = config;
	}
	public String getInfo() {
	
		return info;
	}
	public void setInfo(String info) {
	
		this.info = info;
	}
	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}


	public String getCode() {
	
		return code;
	}


	public void setCode(String code) {
	
		this.code = code;
	}


	public String getYx() {
	
		return yx;
	}


	public void setYx(String yx) {
	
		this.yx = yx;
	}


	public String getXname() {
	
		return xname;
	}


	public void setXname(String xname) {
	
		this.xname = xname;
	}


	public String getFl() {
	
		return fl;
	}


	public void setFl(String fl) {
	
		this.fl = fl;
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
