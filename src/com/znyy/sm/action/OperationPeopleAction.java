package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmOperationPeople;
import com.znyy.sm.service.OperationPeopleService;
import com.znyy.sys.user.service.PermissionService;
 /** 
 * @类名称: OperationPeopleAction
 * @类描述:手术人员Action
 * @作者:付士山
 * @创建时间:2015-12-28 上午10:02:13
 */
 
public class OperationPeopleAction extends AbstractAction {
	private OperationPeopleService operationPeopleService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String code;
	private String lb;
	private String lx;
	private String yx;
	private String info;
	private Integer id;
	private SmOperationPeople sp;
	private List<SmOperationPeople> lxList;
	
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	
	
	public SmOperationPeople getSp() {
	
		return sp;
	}



	public void setSp(SmOperationPeople sp) {
	
		this.sp = sp;
	}



	public Integer getId() {
	
		return id;
	}



	public void setId(Integer id) {
	
		this.id = id;
	}



	public String getInfo() {
	
		return info;
	}



	public void setInfo(String info) {
	
		this.info = info;
	}
	
	
	 /**
	 * @方法名称: getSpList
	 * @功能描述: 获取手术人员列表
	 * @作者:付士山
	 * @创建时间:2015-12-28 上午10:07:12
	 * @return String   
	 */
	 
	public String getSpList() {
		/*前台下拉的人员类型去重选项*/
		lxList=operationPeopleService.getLxList();
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
		Page pageSpList = operationPeopleService.getSpList(code,lb,lx,yx,parmpage, pageSize);
		request.setAttribute("totalP", pageSpList.getTotalPageCount());
		request.setAttribute("totalN", pageSpList.getTotalCount());
		request.setAttribute("spList", pageSpList.getData());
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
	 * @方法名称: modSpListTo
	 * @功能描述: 修改手术人员列表跳转
	 * @作者:付士山
	 * @创建时间:2015-12-29 下午1:59:20
	 * @return String   
	 */
	 
	public String modSpListTo() {
		sp = operationPeopleService.getSpById(id);
		return "success";
	}
	
	 /**
	 * @方法名称: modSpList
	 * @功能描述: 修改手术人员列表
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:59:33
	 * @return String   
	 */
	 
	public String modSpList() {
		SmOperationPeople sop = operationPeopleService.getSpById(id);
		sop.setName(sp.getName());
		sop.setPinyin(sp.getPinyin());
		sop.setEnable(sp.getEnable());
		sop.setRole(sp.getRole());
		sop.setRegion(sp.getRegion());
		try {
			operationPeopleService.modSpList(sop);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	
	 /**
	 * @方法名称: addSpGo
	 * @功能描述: 跳转到手术人员添加页
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午2:31:03
	 * @return String   
	 */
	 
	public String addSpGo(){
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: addSp
	 * @功能描述:添加手术人员信息 
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午2:44:05
	 * @return String   
	 */
	 
	public String addSp(){
		String result="success";
		try {
			operationPeopleService.addSp(sp);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	
	
	 /**
	 * @方法名称: getSpByName
	 * @功能描述: ajax验证手术人员
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:13:55
	 * @return String   
	 */
	 
	public String getSpByName(){
		String responseInfo="";
		
		try {
			String name=request.getParameter("name");
			List<SmOperationPeople> list=operationPeopleService.getSpByName(name);
			
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
	 * @方法名称: getSpByCode
	 * @功能描述: ajax验证手术代码
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午5:57:45
	 * @return String   
	 */
	 
	public String getSpByCode(){
		String responseInfo="";
		
		try {
			String code=request.getParameter("code");
			List<SmOperationPeople> list=operationPeopleService.getSpByCode(Integer.parseInt(code));
			
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

	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}



	public OperationPeopleService getSpService() {
	
		return operationPeopleService;
	}



	public void setSpService(OperationPeopleService operationPeopleService) {
	
		this.operationPeopleService = operationPeopleService;
	}



	public OperationPeopleService getOperationPeopleService() {
	
		return operationPeopleService;
	}



	public void setOperationPeopleService(
			OperationPeopleService operationPeopleService) {
	
		this.operationPeopleService = operationPeopleService;
	}



	public List<SmOperationPeople> getLxList() {
	
		return lxList;
	}



	public void setLxList(List<SmOperationPeople> lxList) {
	
		this.lxList = lxList;
	}



	public String getCode() {
	
		return code;
	}



	public void setCode(String code) {
	
		this.code = code;
	}



	public String getLb() {
	
		return lb;
	}



	public void setLb(String lb) {
	
		this.lb = lb;
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
