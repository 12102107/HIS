package com.znyy.sm.action;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmRegion;
import com.znyy.sm.service.RegionService;
import com.znyy.sys.user.service.PermissionService;

 

 /** 
 * @类名称: RegionAction
 * @类描述:病区Action
 * @作者:付士山
 * @创建时间:2016-1-6 上午11:19:44
 */
 
public class RegionAction extends AbstractAction {
	private RegionService regionService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String bname;
	private Integer id;
	private SmRegion sr;
	private String info;
	private String yx;
	
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	 /**
	 * @方法名称: getRegionList
	 * @功能描述: 获取病区信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:36:16
	 * @return String   
	 */
	 
	public String getRegionList() {
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
		Page pageRegionList = regionService.getRegionList(bname,yx, parmpage, pageSize);
		request.setAttribute("totalP", pageRegionList.getTotalPageCount());
		request.setAttribute("totalN", pageRegionList.getTotalCount());
		request.setAttribute("regionList", pageRegionList.getData());
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
	 * @方法名称: addRegionGo
	 * @功能描述: 跳转到添加病区的页面
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:52:46
	 * @return String   
	 */
	 
	public String addRegionGo(){
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: addRegion
	 * @功能描述: 添加病区信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午12:58:41
	 * @return String   
	 */
	 
	public String addRegion(){
		String result="success";
		try {
			regionService.addRegion(sr);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	 /**
	 * @方法名称: getRegionByName
	 * @功能描述: ajax验证病区名称
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:58:36
	 * @return String   
	 */
	 
	public String getRegionByName(){
		String responseInfo="";
		
		try {
			String name=request.getParameter("name");
			List<SmRegion> list=regionService.getRegionByName(name);
			
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
	 * @方法名称: modRegionListTo
	 * @功能描述: 病区修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午1:05:53
	 * @return String   
	 */
	 
	public String modRegionListTo() {
		sr = regionService.getRegionById(id);
		return "success";
	}
	
	 /**
	 * @方法名称: modRegionList
	 * @功能描述: 病区修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午1:14:04
	 * @return String   
	 */
	 
	public String modRegionList() {
		SmRegion srn = regionService.getRegionById(id);
		srn.setName(sr.getName());
		srn.setEnable(sr.getEnable());
		try {
			regionService.modRegionList(srn);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
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
	public SmRegion getSr() {
	
		return sr;
	}
	public void setSr(SmRegion sr) {
	
		this.sr = sr;
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
	public RegionService getRegionService() {
	
		return regionService;
	}
	public void setRegionService(RegionService regionService) {
	
		this.regionService = regionService;
	}

	public String getBname() {
	
		return bname;
	}

	public void setBname(String bname) {
	
		this.bname = bname;
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
