package com.znyy.sm.action;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmOperroom;
import com.znyy.sm.service.OperroomService;
import com.znyy.sys.user.service.PermissionService;

 

 /** 
 * @类名称: OperroomAction
 * @类描述:手术室Action
 * @作者:付士山
 * @创建时间:2016-1-4 下午1:01:39
 */
 
public class OperroomAction extends AbstractAction {
	private OperroomService operroomService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String name;
	private Integer id;
	private SmOperroom sor;
	private String info;
	private String sname;
	private String lx;
	private String yx;
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	 /**
	 * @方法名称: getOrList
	 * @功能描述: 获得手术室信息列表
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午1:02:01
	 * @return String   
	 */
	 
	public String getOrList() {
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
		Page pageOrList = operroomService.getOrList(sname,lx,yx, parmpage, pageSize);
		request.setAttribute("totalP", pageOrList.getTotalPageCount());
		request.setAttribute("totalN", pageOrList.getTotalCount());
		request.setAttribute("orList", pageOrList.getData());
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
	 * @方法名称: addOrGo
	 * @功能描述: 添加手术室信息跳转页面
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午1:08:52
	 * @return String   
	 */
	 
	public String addOrGo(){
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: addOr
	 * @功能描述: 添加手术室信息
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午1:28:24
	 * @return String   
	 */
	 
	public String addOr(){
		String result="success";
		try {
			operroomService.addOr(sor);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	
	 /**
	 * @方法名称: modOrListTo
	 * @功能描述: 手术室修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午3:31:29
	 * @return String   
	 */
	 
	public String modOrListTo() {
		sor = operroomService.getOrById(id);
		return "success";
	}
	
	 /**
	 * @方法名称: modOrList
	 * @功能描述: 修改手术室数据
	 * @作者:付士山
	 * @创建时间:2016-1-5 上午9:15:14
	 * @return String   
	 */
	 
	public String modOrList() {
		SmOperroom or = operroomService.getOrById(id);
		or.setName(sor.getName());
		or.setRoomType(sor.getRoomType());
		or.setEnable(sor.getEnable());
		try {
			operroomService.modOrList(or);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	
	 /**
	 * @方法名称: getOrByName
	 * @功能描述: ajax验证手术室名称
	 * @作者:付士山
	 * @创建时间:2016-1-5 上午9:46:30
	 * @return String   
	 */
	 
	public String getOrByName(){
		String responseInfo="";
		
		try {
			String name=request.getParameter("name");
			List<SmOperroom> list=operroomService.getOrByName(name);
			
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
	
	public OperroomService getOperroomService() {
	
		return operroomService;
	}


	public void setOperroomService(OperroomService operroomService) {
	
		this.operroomService = operroomService;
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


	public Integer getId() {
	
		return id;
	}


	public void setId(Integer id) {
	
		this.id = id;
	}


	public SmOperroom getSor() {
	
		return sor;
	}


	public void setSor(SmOperroom sor) {
	
		this.sor = sor;
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


	public String getSname() {
	
		return sname;
	}


	public void setSname(String sname) {
	
		this.sname = sname;
	}


	public String getLx() {
	
		return lx;
	}


	public void setLx(String lx) {
	
		this.lx = lx;
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
