package com.znyy.sm.action;
import java.util.List;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmSyslogger;
import com.znyy.sm.service.SysloggerService;
import com.znyy.sys.user.service.PermissionService;
 /** 
 * @类名称: SysloggerAction
 * @类描述:系统日志Action
 * @作者:付士山
 * @创建时间:2016-1-13 上午9:25:19
 */
 
public class SysloggerAction extends AbstractAction {
	private SysloggerService SysloggerService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private Integer id;
	private SmSyslogger syslog;
	private String info;
	private String yhid;
	private String qxm;
	private String jg;
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	 /**
	 * @方法名称: getSyslogList
	 * @功能描述: 获取系统日志信息
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午9:50:47
	 * @return String   
	 */
	 
	public String getSyslogList() {
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
		Page pageSyslogList = SysloggerService.getSyslogList(yhid,qxm,jg, parmpage, pageSize);
		request.setAttribute("totalP", pageSyslogList.getTotalPageCount());
		request.setAttribute("totalN", pageSyslogList.getTotalCount());
		request.setAttribute("syslogList", pageSyslogList.getData());
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", parmpage);
		request.setAttribute("xh", xh);
		System.out.println(yhid);
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		updateRole = btnCodes.contains("update");
		addRole = btnCodes.contains("add");
		selectRole = btnCodes.contains("select");
		
		return result;
	}
	
	 /**
	 * @方法名称: modSyslogListTo
	 * @功能描述: 系统日志修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午10:16:51
	 * @return String   
	 */
	 
	public String modSyslogListTo() {
		syslog = SysloggerService.getSyslogById(id);
		return "success";
	}
	
	 /**
	 * @方法名称: modSyslogList
	 * @功能描述: 系统日志修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午10:42:06
	 * @return String   
	 */
	 
	public String modSyslogList() {
		SmSyslogger slog=  SysloggerService.getSyslogById(id);
		slog.setContent(syslog.getContent());
		slog.setPermissionkey(syslog.getPermissionkey());
		slog.setUserid(syslog.getUserid());
		slog.setResult(syslog.getResult());
		try {
			SysloggerService.modSyslogList(slog);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	
	 /**
	 * @方法名称: addSyslogGo
	 * @功能描述: 跳转到添加系统日志的页面
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午11:06:15
	 * @return String   
	 */
	 
	public String addSyslogGo(){
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: addSyslog
	 * @功能描述: 添加系统日志信息  
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午11:11:49
	 * @return String   
	 */
	 
	public String addSyslog(){
		String result="success";
		try {
			SysloggerService.addSyslog(syslog);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	public SysloggerService getSysloggerService() {
	
		return SysloggerService;
	}
	public void setSysloggerService(SysloggerService sysloggerService) {
	
		SysloggerService = sysloggerService;
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
	public SmSyslogger getSyslog() {
	
		return syslog;
	}
	public void setSyslog(SmSyslogger syslog) {
	
		this.syslog = syslog;
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

	public String getYhid() {
	
		return yhid;
	}

	public void setYhid(String yhid) {
	
		this.yhid = yhid;
	}

	public String getQxm() {
	
		return qxm;
	}

	public void setQxm(String qxm) {
	
		this.qxm = qxm;
	}

	public String getJg() {
	
		return jg;
	}

	public void setJg(String jg) {
	
		this.jg = jg;
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
