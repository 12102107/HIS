package com.znyy.sm.action;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmDept;
import com.znyy.sm.service.DeptService;
import com.znyy.sys.user.service.PermissionService;

 /** 
 * @类名称: DeptAction
 * @类描述:科室Action
 * @作者:付士山
 * @创建时间:2016-1-5 下午2:31:54
 */
 
public class DeptAction extends AbstractAction {
	private DeptService deptService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String kname;
	private Integer id;
	private SmDept dept;
	private String info;
	private String yx;
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	 /**
	 * @方法名称: getDeptList
	 * @功能描述: 获取科室信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午9:43:42
	 * @return String   
	 */
	 
	public String getDeptList() {
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
		Page pageDeptList = deptService.getDeptList(kname, yx,parmpage, pageSize);
		request.setAttribute("totalP", pageDeptList.getTotalPageCount());
		request.setAttribute("totalN", pageDeptList.getTotalCount());
		request.setAttribute("deptList", pageDeptList.getData());
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
	 * @方法名称: addDeptGo
	 * @功能描述: 跳转到添加科室的页面
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:30:03
	 * @return String   
	 */
	 
	public String addDeptGo(){
		return SUCCESS;
	}
	
	
	 /**
	 * @方法名称: addDept
	 * @功能描述: 添加科室信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:44:48
	 * @return String   
	 */
	 
	public String addDept(){
		String result="success";
		try {
			deptService.addDept(dept);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	
	
	 /**
	 * @方法名称: getDeptByName
	 * @功能描述: ajax验证科室名称
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:51:03
	 * @return String   
	 */
	 
	public String getDeptByName(){
		String responseInfo="";
		
		try {
			String name=request.getParameter("name");
			List<SmDept> list=deptService.getDeptByName(name);
			
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
	 * @方法名称: modDeptListTo
	 * @功能描述: 科室修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:57:59
	 * @return String   
	 */
	 
	public String modDeptListTo() {
		dept = deptService.getDeptById(id);
		return "success";
	}
	
	 /**
	 * @方法名称: modDeptList
	 * @功能描述: 科室修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:05:26
	 * @return String   
	 */
	 
	public String modDeptList() {
		SmDept sdt = deptService.getDeptById(id);
		sdt.setName(dept.getName());
		sdt.setEnable(dept.getEnable());
		try {
			deptService.modDeptList(sdt);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	
	public DeptService getDeptService() {
	
		return deptService;
	}
	public void setDeptService(DeptService deptService) {
	
		this.deptService = deptService;
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
	public SmDept getDept() {
	
		return dept;
	}
	public void setDept(SmDept dept) {
	
		this.dept = dept;
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


	public String getKname() {
	
		return kname;
	}


	public void setKname(String kname) {
	
		this.kname = kname;
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
