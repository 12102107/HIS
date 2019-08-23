package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmDrugOrGoods;
import com.znyy.sm.service.DrugOrGoodsService;
import com.znyy.sys.user.service.PermissionService;

 /** 
 * @类名称: DrugOrGoodsAction
 * @类描述:使用贵重或自费药品(物品)定义Action
 * @作者:付士山
 * @创建时间:2016-1-8 上午9:12:27
 */
 
public class DrugOrGoodsAction extends AbstractAction {
	private DrugOrGoodsService drugOrGoodsService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String dname;
	private String info;
	private Integer id;
	private SmDrugOrGoods sdg;
	private String code;
	private String yx;
	private String lx;
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	 /**
	 * @方法名称: getDrugList
	 * @功能描述: 获取药品物品信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:36:52
	 * @return String   
	 */
	 
	public String getDrugList() {
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
		Page pageDrugList = drugOrGoodsService.getDrugList(dname,lx,yx,code, parmpage, pageSize);
		request.setAttribute("totalP", pageDrugList.getTotalPageCount());
		request.setAttribute("totalN", pageDrugList.getTotalCount());
		request.setAttribute("drugList", pageDrugList.getData());
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
	 * @方法名称: modDrugListTo
	 * @功能描述:药品物品修改跳转 
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:45:47
	 * @return String   
	 */
	 
	public String modDrugListTo() {
		sdg = drugOrGoodsService.getDrugById(id);
		return "success";
	}
	

	
	 /**
	 * @方法名称: modDrugList
	 * @功能描述: 药品物品修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:46:07
	 * @return String   
	 */
	 
	public String modDrugList() {
		SmDrugOrGoods dg = drugOrGoodsService.getDrugById(id);
		dg.setName(sdg.getName());
		dg.setPrice(sdg.getPrice());
		dg.setEnable(sdg.getEnable());
		dg.setType(sdg.getType());
		try {
			drugOrGoodsService.modDrugList(dg);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	 
		
		 /**
		 * @方法名称: addDrugGo
		 * @功能描述: 跳转到添加药品物品的页面
		 * @作者:付士山
		 * @创建时间:2016-1-8 上午10:02:18
		 * @return String   
		 */
		 
		public String addDrugGo(){
			return SUCCESS;
		}
		
	
		
		 /**
		 * @方法名称: addDrug
		 * @功能描述: 添加药品物品信息
		 * @作者:付士山
		 * @创建时间:2016-1-8 上午10:02:20
		 * @return String   
		 */
		 
		public String addDrug(){
			String result="success";
			try {
				drugOrGoodsService.addDrug(sdg);
				info="添加成功";
			} catch (Exception e) {
				info="添加失败";
				e.printStackTrace();
			}
			return result;
		}

		
		 /**
		 * @方法名称: getDrugByName
		 * @功能描述: ajax验证药品物品名称
		 * @作者:付士山
		 * @创建时间:2016-1-8 上午10:08:15
		 * @return String   
		 */
		 
		public String getDrugByName(){
			String responseInfo="";
			
			try {
				String name=request.getParameter("name");
				List<SmDrugOrGoods> list=drugOrGoodsService.getDrugByName(name);
				
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
		 * @方法名称: getDrugByCode
		 * @功能描述: ajax验证药品物品代码
		 * @作者:付士山
		 * @创建时间:2016-1-8 上午10:08:11
		 * @return String   
		 */
		 
		public String getDrugByCode(){
			String responseInfo="";
			
			try {
				String code=request.getParameter("code");
				List<SmDrugOrGoods> list=drugOrGoodsService.getDrugByCode(Integer.parseInt(code));
				
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
	public DrugOrGoodsService getDrugOrGoodsService() {
	
		return drugOrGoodsService;
	}
	public void setDrugOrGoodsService(DrugOrGoodsService drugOrGoodsService) {
	
		this.drugOrGoodsService = drugOrGoodsService;
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
	public Integer getId() {
	
		return id;
	}
	public void setId(Integer id) {
	
		this.id = id;
	}
	public SmDrugOrGoods getSdg() {
	
		return sdg;
	}
	public void setSdg(SmDrugOrGoods sdg) {
	
		this.sdg = sdg;
	}
	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}

	public String getDname() {
	
		return dname;
	}

	public void setDname(String dname) {
	
		this.dname = dname;
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

	public String getLx() {
	
		return lx;
	}

	public void setLx(String lx) {
	
		this.lx = lx;
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
