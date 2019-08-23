package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmIoDefination;
import com.znyy.sm.service.IoDefinationService;
import com.znyy.sys.user.service.PermissionService;

 
public class IoDefinationAction extends AbstractAction {
	private IoDefinationService ioDefinationService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String ioname;
	private String jc;
	private String lx;
	private String zlx;
	private String dw;
	private String yx;
	private Integer id;
	private SmIoDefination sio;
	private String info;
	private List<SmIoDefination> lxList;
	private List<SmIoDefination> zlxList;
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 
	
	 /**
	 * @方法名称: getIoList
	 * @功能描述: 获取出入量信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午3:20:11
	 * @return String   
	 */
	 
	public String getIoList() {
		//获取类型选项
		lxList=ioDefinationService.getLxList();
		//获取子类型选项
		zlxList=ioDefinationService.getZlxList();
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
		Page pageIoList = ioDefinationService.getIoList(ioname,dw,yx,lx,zlx,jc, parmpage, pageSize);
		request.setAttribute("totalP", pageIoList.getTotalPageCount());
		request.setAttribute("totalN", pageIoList.getTotalCount());
		request.setAttribute("ioList", pageIoList.getData());
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
	 * @方法名称: addIoGo
	 * @功能描述: 跳转到添加出入量的页面
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午9:10:49
	 * @return String   
	 */
	 
	public String addIoGo(){
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: addIo
	 * @功能描述: 添加出入量信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午9:35:44
	 * @return String   
	 */
	 
	public String addIo(){
		String result="success";
		try {
			ioDefinationService.addIo(sio);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	 /**
	 * @方法名称: getIoByName
	 * @功能描述: ajax验证出入量名称
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午9:26:00
	 * @return String   
	 */
	 
	public String getIoByName(){
		String responseInfo="";
		
		try {
			String name=request.getParameter("name");
			List<SmIoDefination> list=ioDefinationService.getIoByName(name);
			
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
	 * @方法名称: modIoListTo
	 * @功能描述: 出入量修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午10:33:04
	 * @return String   
	 */
	 
	public String modIoListTo() {
		sio = ioDefinationService.getIoById(id);
		return "success";
	}
	
	 /**
	 * @方法名称: modIoList
	 * @功能描述: 出入量修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-7 上午11:11:43
	 * @return String   
	 */
	 
	public String modIoList() {
		SmIoDefination io = ioDefinationService.getIoById(id);
		io.setName(sio.getName());
		io.setEnable(sio.getEnable());
		io.setBriefName(sio.getBriefName());
		io.setDosageUnit(sio.getDosageUnit());
		io.setPackageDosageAmount(sio.getPackageDosageAmount());
		io.setType(sio.getType());
		io.setPinyin(sio.getPinyin());
		io.setSubType(sio.getSubType());
		try {
			ioDefinationService.modIoList(io);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	public IoDefinationService getIoDefinationService() {
	
		return ioDefinationService;
	}
	public void setIoDefinationService(IoDefinationService ioDefinationService) {
	
		this.ioDefinationService = ioDefinationService;
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
	public SmIoDefination getSio() {
	
		return sio;
	}
	public void setSio(SmIoDefination sio) {
	
		this.sio = sio;
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

	public List<SmIoDefination> getLxList() {
	
		return lxList;
	}

	public void setLxList(List<SmIoDefination> lxList) {
	
		this.lxList = lxList;
	}

	public List<SmIoDefination> getZlxList() {
	
		return zlxList;
	}

	public void setZlxList(List<SmIoDefination> zlxList) {
	
		this.zlxList = zlxList;
	}

	public String getIoname() {
	
		return ioname;
	}

	public void setIoname(String ioname) {
	
		this.ioname = ioname;
	}

	public String getJc() {
	
		return jc;
	}

	public void setJc(String jc) {
	
		this.jc = jc;
	}

	public String getLx() {
	
		return lx;
	}

	public void setLx(String lx) {
	
		this.lx = lx;
	}

	public String getZlx() {
	
		return zlx;
	}

	public void setZlx(String zlx) {
	
		this.zlx = zlx;
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
