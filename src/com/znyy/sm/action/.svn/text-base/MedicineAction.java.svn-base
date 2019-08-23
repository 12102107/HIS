package com.znyy.sm.action;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmMedicine;
import com.znyy.sm.service.MedicineService;
import com.znyy.sys.user.service.PermissionService;


 /** 
 * @类名称: MedicineAction
 * @类描述:药品库Action
 * @作者:付士山
 * @创建时间:2016-1-11 上午9:24:04
 */
 
public class MedicineAction extends AbstractAction {
	private MedicineService medicineService;

	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private String page;
	private String rows;
	private String ypname;
	private Integer id;
	private SmMedicine med;
	private String info;
	private String code;
	private String fl;
	private String dw;
	private String pinyin;
	private String yx;
	private List<SmMedicine> dwList;
	private List<SmMedicine> flList;
	
	private PermissionService permissionService;
	private boolean updateRole; 
	private boolean addRole;
	private boolean selectRole;
	private String functionid; 

	/**
	 * @方法名称: getMedList
	 * @功能描述: 获取药品库信息
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午9:42:49
	 * @return String   
	 */
	 
	public String getMedList() {
		 /*前台下拉的药品单位去重选项*/
		dwList= medicineService.getDwList();
		 /*前台下拉的药品分类去重选项*/
		flList= medicineService.getFlList();
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
		Page pageMedList = medicineService.getMedList(ypname,code,fl,dw,pinyin,yx, parmpage, pageSize);
		request.setAttribute("totalP", pageMedList.getTotalPageCount());
		request.setAttribute("totalN", pageMedList.getTotalCount());
		request.setAttribute("medList", pageMedList.getData());
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
	 * @方法名称: modMedListTo
	 * @功能描述: 药品库修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午10:43:21
	 * @return String   
	 */
	 
	public String modMedListTo() {
		med = medicineService.getMedById(id);
		return "success";
	}
	
	 /**
	 * @方法名称: modMedList
	 * @功能描述: 药品库修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午10:48:57
	 * @return String   
	 */
	 
	public String modMedList() {
		SmMedicine smed = medicineService.getMedById(id);
		smed.setName(med.getName());
		smed.setEnable(med.getEnable());
		smed.setBriefName(med.getBriefName());
		smed.setDosageUnit(med.getDosageUnit());
		smed.setHismedicineCode(med.getHismedicineCode());
		smed.setPackageDosageAmount(med.getPackageDosageAmount());
		smed.setRoughType(med.getRoughType());
		smed.setType(med.getType());
		smed.setPinyin(med.getPinyin());
		try {
			medicineService.modMedList(smed);
			info = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			info = "修改失败";
		}
		return "success";
	}
	
	 /**
	 * @方法名称: addMedGo
	 * @功能描述: 跳转到添加药品库的页面
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午11:03:43
	 * @return String   
	 */
	 
	public String addMedGo(){
		return SUCCESS;
	}
	
	
	 /**
	 * @方法名称: addMed
	 * @功能描述: 添加药品库信息
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午11:25:28
	 * @return String   
	 */
	 
	public String addMed(){
		String result="success";
		try {
			medicineService.addMed(med);
			info="添加成功";
		} catch (Exception e) {
			info="添加失败";
			e.printStackTrace();
		}
		return result;
	}
	 /**
	 * @方法名称: getMedByName
	 * @功能描述: ajax验证药品库名称
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午11:11:41
	 * @return String   
	 */
	 
	public String getMedByName(){
		String responseInfo="";
		
		try {
			String name=request.getParameter("name");
			List<SmMedicine> list=medicineService.getMedByName(name);
			
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
	public String getInfo() {
	
		return info;
	}



	public void setInfo(String info) {
	
		this.info = info;
	}



	public MedicineService getMedicineService() {
	
		return medicineService;
	}



	public void setMedicineService(MedicineService medicineService) {
	
		this.medicineService = medicineService;
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
	
		return ypname;
	}



	public void setName(String name) {
	
		this.ypname = name;
	}



	public Integer getId() {
	
		return id;
	}



	public void setId(Integer id) {
	
		this.id = id;
	}



	public SmMedicine getMed() {
	
		return med;
	}



	public void setMed(SmMedicine med) {
	
		this.med = med;
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



	public List<SmMedicine> getFlList() {
	
		return flList;
	}

	public void setFlList(List<SmMedicine> flList) {
	
		this.flList = flList;
	}

	public List<SmMedicine> getDwList() {
	
		return dwList;
	}

	public void setDwList(List<SmMedicine> dwList) {
	
		this.dwList = dwList;
	}

	public String getFl() {
	
		return fl;
	}

	public void setFl(String fl) {
	
		this.fl = fl;
	}

	public String getDw() {
	
		return dw;
	}

	public void setDw(String dw) {
	
		this.dw = dw;
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

	public String getYpname() {
	
		return ypname;
	}

	public void setYpname(String ypname) {
	
		this.ypname = ypname;
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
