/**  
 * @Title: InstrumentAction.java
 * @Package com.znyy.sm.action
 * @Description: TODO
 * @author 白东旭
 * @date 2016年8月2日
 */
package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.common.action.CommAction;
import com.common.util.Page;
import com.common.util.Util;
import com.common.util.XmlUtil;
import com.znyy.bean.SmInstrument;
import com.znyy.bean.SmInstrumentPackage;
import com.znyy.bean.SmInstrumentPackageItem;
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.service.InstrumentService;
import com.znyy.sys.user.service.PermissionService;

/**
 * ClassName: InstrumentAction 
 * @Description: TODO
 * @author 白东旭
 * @date 2016年8月2日
 */
public class InstrumentAction extends CommAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private InstrumentService instrumentService;


	/**
	 * @return the instrumentService
	 */
	public InstrumentService getInstrumentService() {
		return instrumentService;
	}


	/**
	 * @param instrumentService the instrumentService to set
	 */
	public void setInstrumentService(InstrumentService instrumentService) {
		this.instrumentService = instrumentService;
	}
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	private Integer pageSize;
	private String page;
	private String name;
	private String common;
	
	private String specifications;
	
	private SmInstrument i;
	private String info;
	private String id;
	
	private SmInstrumentPackage p;
	private List<String> iid;
	private List<String> inum;
	
	private List<String> itype;
	/**
	 * 
	 * @Description: 获取手术器械列表
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	public String getInstrumentList() {
		if (page == null || page.equals("")) {
			page = "1";
		}
		int parmpage = Integer.parseInt(page);

		if (pageSize == null) {
			pageSize = 8;
		}
		
		Page list = instrumentService.getInstrumentList(name, common,parmpage, pageSize);
		request.setAttribute("totalP", list.getTotalPageCount());
		request.setAttribute("totalN", list.getTotalCount());
		request.setAttribute("list", list.getData());
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		updateRole = btnCodes.contains("update");
		addRole = btnCodes.contains("add");
		selectRole = btnCodes.contains("select");
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 添加器械跳转
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	public String addInstrumentTo() {
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 校验手术器械
	 * @param    
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月30日
	 */
	public void checkNameSpecifications() {
		boolean r = instrumentService.getCheckNameSpecifications(name,specifications);
		try {
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	
			
			PrintWriter out = response.getWriter();
			out.print(r);
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Description: 添加手术器械
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	public String addInstrument() {
		instrumentService.addInstrument(i);
		info="添加成功！";
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 修改手术器械跳转
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	public String modInstrumentTo() {
		i = instrumentService.getInstrumentById(id);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 修改手术器械
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	public String modInstrument() {
		instrumentService.addInstrument(i);
		info="修改成功！";
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 删除手术器械
	 * @param    
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	public void delInstrument() {
		instrumentService.delInstrument(id);
	}
	
	/**
	 * 
	 * @Description: 获取手术器械包列表
	 * @param    
	 * @return String  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月4日
	 */
	public String getInstrumentPackageList() {
		if (page == null || page.equals("")) {
			page = "1";
		}
		int parmpage = Integer.parseInt(page);

		if (pageSize == null) {
			pageSize = 8;
		}
		
		Page list = instrumentService.getInstrumentPackageList(name, common,parmpage, pageSize);
		request.setAttribute("totalP", list.getTotalPageCount());
		request.setAttribute("totalN", list.getTotalCount());
		request.setAttribute("list", list.getData());
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		updateRole = btnCodes.contains("update");
		addRole = btnCodes.contains("add");
		selectRole = btnCodes.contains("select");
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 添加手术包跳转
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月4日
	 */
	public String addInstrumentPackageTo() {
		List<SmInstrument> ilist = instrumentService.getInstrumentList();
		request.setAttribute("ilist", ilist);
		return SUCCESS;
	}
	
	/**
	 * 
	 * Description: 添加手术包
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月4日
	 */
	public String addInstrumentPackage() {
		boolean r = instrumentService.getCheckPackageName(p.getName());
		if(r) {
			info="存在相同名称手术包！";
		} else {
			info="添加成功！";
			instrumentService.addInstrumentPackage(p,iid,inum);
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 修改手术包跳转
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月5日
	 */
	public String modInstrumentPackageTo() {
		List<SmInstrument> ilist = instrumentService.getInstrumentList();
		request.setAttribute("ilist", ilist);
		p = instrumentService.getInstrumentPackageById(id);
		List<SmInstrumentPackageItem> item = instrumentService.getPackageItemList(id);
		request.setAttribute("item", item);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 修改手术包
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月5日
	 */
	public String modInstrumentPackage() {
		boolean r = instrumentService.getCheckPackageName(p.getName());
		if(r) {
			info="存在相同名称手术包！";
		} else {
			info="修改成功！";
			instrumentService.modInstrumentPackage(p,iid,inum);
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 删除手术包
	 * @param    
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月5日
	 */
	public void delInstrumentPackage() {
		instrumentService.delInstrumentPackage(id);
	}
	
	/**
	 * 
	 * @Description: 器械清点跳转
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月5日
	 */
	public String checkInstrumentTo() {
		SmRegOpt sro = instrumentService.getSmRegOpt(id);
		request.setAttribute("sro", sro);
		
		List<Map<String,Object>> ip = instrumentService.getInstrumentPackage();
		request.setAttribute("ip", ip);
		
		List<SmInstrument> ilist = instrumentService.getInstrumentList();
		request.setAttribute("ilist", ilist);
		
		List<Map<String,Object>> pcheck = instrumentService.getInstrumentCheckPackage(id);
		request.setAttribute("pcheck", pcheck);
		
		List<Map<String,Object>> icheck = instrumentService.getInstrumentCheckInstrument(id);
		request.setAttribute("icheck", icheck);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 获取手术器械信息
	 * @param    
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月8日
	 */
	public void getInstrumentInfo() {
		Map<String,String> info = instrumentService.getInstrumentInfo(id);
		try {
	
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			String json = JSONArray.fromObject(info).toString();
			
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Description: 保存手术器械清点信息
	 * @param    
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月10日
	 */
	public void saveOrUpdateInstrumentCheck() {
		instrumentService.saveOrUpdateInstrumentCheck(id,iid,itype,inum);
	}
	
	/**
	 * 
	 * @Description: 获取打印信息
	 * @param    
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月10日
	 */
	public void loadPrint() {
		try {
			
			List<Map<String, Object>> info = instrumentService.getPrintInfo(id);
			List<Map<String, Object>> list = instrumentService.getPrintList(id);
		
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			PrintWriter out = response.getWriter();
			out.print(XmlUtil.xmlAssemble(list,info));
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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


	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}


	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}


	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the common
	 */
	public String getCommon() {
		return common;
	}


	/**
	 * @param common the common to set
	 */
	public void setCommon(String common) {
		this.common = common;
	}


	/**
	 * @return the i
	 */
	public SmInstrument getI() {
		return i;
	}


	/**
	 * @param i the i to set
	 */
	public void setI(SmInstrument i) {
		this.i = i;
	}


	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}


	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the p
	 */
	public SmInstrumentPackage getP() {
		return p;
	}


	/**
	 * @param p the p to set
	 */
	public void setP(SmInstrumentPackage p) {
		this.p = p;
	}


	/**
	 * @return the iid
	 */
	public List<String> getIid() {
		return iid;
	}


	/**
	 * @param iid the iid to set
	 */
	public void setIid(List<String> iid) {
		this.iid = iid;
	}


	/**
	 * @return the inum
	 */
	public List<String> getInum() {
		return inum;
	}


	/**
	 * @param inum the inum to set
	 */
	public void setInum(List<String> inum) {
		this.inum = inum;
	}


	/**
	 * @return the itype
	 */
	public List<String> getItype() {
		return itype;
	}


	/**
	 * @param itype the itype to set
	 */
	public void setItype(List<String> itype) {
		this.itype = itype;
	}


	/**
	 * @return the specifications
	 */
	public String getSpecifications() {
		return specifications;
	}


	/**
	 * @param specifications the specifications to set
	 */
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}


}
