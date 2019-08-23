package com.znyy.sm.action;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmDiagnosedef;
import com.znyy.sm.service.DiagnosedefService;
import com.znyy.sys.user.service.PermissionService;


 /** 
 * @类名称:DiagnosedefAction
 * @类描述:诊断action
 * @作者:付士山
 * @创建时间:2015-12-24 上午9:04:33
 */
 
public class DiagnosedefAction extends AbstractAction {
	private DiagnosedefService diagnosedefService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;//每页有几条数据
	private String page;//当前页是第几页
	private String rows;
	private Integer id;
	private SmDiagnosedef zd;
	private String info;
	private String zdname;
	private String pinyin;
	private String yx;
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	/**
	 * 
	 * @方法名称: getZdList
	 * @功能描述: 获取诊断名称列表
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:06:35
	 * @return String
	 */
	public String getZdList() {
		String result = "success";
	    //当前页为第几页
		if (page == null || page.equals("")) {
			page = "1";
		}
		int parmpage = Integer.parseInt(page);
        //每页显示的条数
		if (pageSize == null) {
			pageSize = 8;
		}
		int newPage = Integer.parseInt(page);
		//从第几条数据开始查询
		int xh = (newPage - 1) * pageSize + 1;
		Page pageZdList = diagnosedefService.getZdList(zdname,yx,pinyin,parmpage, pageSize);
		request.setAttribute("totalP", pageZdList.getTotalPageCount());
		request.setAttribute("totalN", pageZdList.getTotalCount());
		request.setAttribute("zdList", pageZdList.getData());
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
	 * 
	 * @方法名称: modZdListTo
	 * @功能描述: 修改诊断列表跳转
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:07:53
	 * @return String
	 */
	public String modZdListTo() {
		zd = diagnosedefService.getZdById(id);
		return "success";
	}
/**
 * 
 * @方法名称: modZdList
 * @功能描述:修改诊断列表信息
 * @作者:付士山
 * @创建时间:2015-12-24 上午9:10:21
 * @return String
 */
	public String modZdList() {
		SmDiagnosedef sm = diagnosedefService.getZdById(id);
		sm.setName(zd.getName());
		sm.setPinyin(zd.getPinyin());
		sm.setEnable(zd.getEnable());
		try {
			diagnosedefService.modZdList(sm);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	/**
	 * 
	 * @方法名称: addDzGo
	 * @功能描述:添加诊断信息列表跳转 
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:11:07
	 * @return String
	 */
	public String addDzGo(){
		return SUCCESS;
	}
	/**
	 * 
	 * @方法名称: addZd
	 * @功能描述: 添加诊断列表信息
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:11:33
	 * @return String
	 */
	public String addZd(){
		String result="success";
		try {
			diagnosedefService.addZd(zd);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	
	
	 /**
	 * @方法名称: getZdByName
	 * @功能描述: ajax验证诊断名称
	 * @作者:付士山
	 * @创建时间:2015-12-25 上午10:31:27
	 * @return String   
	 */
	public String getZdByName(){
		String responseInfo="";
		
		try {
			String name=request.getParameter("name");
			List<SmDiagnosedef> list=diagnosedefService.getZdByName(name);
			
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



	public SmDiagnosedef getZd() {
	
		return zd;
	}



	public void setZd(SmDiagnosedef zd) {
	
		this.zd = zd;
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



	public DiagnosedefService getZdService() {
	
		return diagnosedefService;
	}



	public void setZdService(DiagnosedefService diagnosedefService) {
	
		this.diagnosedefService = diagnosedefService;
	}



	public DiagnosedefService getDiagnosedefService() {
	
		return diagnosedefService;
	}



	public void setDiagnosedefService(DiagnosedefService diagnosedefService) {
	
		this.diagnosedefService = diagnosedefService;
	}

	public String getZdname() {
	
		return zdname;
	}

	public void setZdname(String zdname) {
	
		this.zdname = zdname;
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
