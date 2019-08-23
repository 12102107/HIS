package com.znyy.sm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.DateUtil;
import com.common.util.Util;
import com.znyy.bean.SmAnaesMethod;
import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SysCvFyzflb;
import com.znyy.bean.SysDiseaseArea;
import com.znyy.bean.SysIcdCode;
import com.znyy.bean.XtUnit;
import com.znyy.sm.service.AnaesMethodService;
import com.znyy.sm.service.DeptService;
import com.znyy.sm.service.DiagnosedefService;
import com.znyy.sm.service.OperationPeopleService;
import com.znyy.sm.service.OperdefService;
import com.znyy.sm.service.RegOptService;
import com.znyy.sm.service.RegionService;
import com.znyy.sys.user.service.PermissionService;

/**
 * @类名称: SsdjAction
 * @类描述:手术登记Action
 * @作者:付士山
 * @创建时间:2016-1-18 上午9:24:35
 */

public class SsdjAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private RegionService regionService;
	private List<SysDiseaseArea> regionList;
	private DeptService deptService;
	private List<XtUnit> deptList;
	private AnaesMethodService anaesMethodService;
	private List<SmAnaesMethod> mzffList;
	private OperationPeopleService operationPeopleService;
	private List<SmOperationPeople> sopList;
	private DiagnosedefService diagnosedefService;
	private List<SysIcdCode> zdList;
	private OperdefService operdefService;
	private List<SmOperdef> operList;
	private String id;
	private Integer pageSize;
	private String page;
	private String name;
	private String info;
	private SmRegOpt sro;
	private RegOptService regOptService;
	private List<SmRegOpt> sroList;
	private String zimu;
	private String data = "";

	private String operatorId;
	
	private PermissionService permissionService;
	private boolean submitRole; 
	private boolean updateRole; 
	private String functionid;
	private String YYoperdate;
	private String renyuanID;
	
	 /**
	 * @方法名称: getSsdjList
	 * @功能描述: 查询手术登记列表
	 * @作者:付士山
	 * @创建时间:2016-1-20 下午1:55:34
	 * @return String   
	 */
	 
	public String getSsdjList() {
		if (id!=null &&  id.trim().length()>0) {
			sro = regOptService.modSsdjListTo(id);
		}
		String hospitalId = (String) this.session.get("hospitalid");
		deptList = deptService.getDepts(hospitalId);
		
		sroList = regOptService.getRoList(hospitalId);
		
		operList=operdefService.getOps("0");
		zdList=diagnosedefService.getSysIcdCodeList();
		sopList = operationPeopleService.getSops("0","手术医师");
		regionList = regionService.getRegions();
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		submitRole = btnCodes.contains("submit");
		updateRole = btnCodes.contains("update");
		
		List<SysCvFyzflb> l = regOptService.getSysCvFyzflbList();
		request.setAttribute("sysCvFyzflb", l);
		
		return SUCCESS;
	}

	/**
	 * @方法名称: selectMzff
	 * @功能描述: 选择麻醉方法列表
	 * @作者:付士山
	 * @创建时间:2016-1-15 上午9:16:02
	 * @return String
	 */

	public String selectMzff() {
		
		String result = "success";

		/*if (page == null || page.equals("")) {
			page = "1";
		}
		int parmpage = Integer.parseInt(page);

		if (pageSize == null) {
			pageSize = 8;
		}
		int newPage = Integer.parseInt(page);
		int xh = (newPage - 1) * pageSize + 1;
		Page pageSpList = anaesMethodService.getMzffList2(name, parmpage,
				pageSize);
		request.setAttribute("totalP", pageSpList.getTotalPageCount());
		request.setAttribute("totalN", pageSpList.getTotalCount());
		request.setAttribute("mzffList", pageSpList.getData());
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", parmpage);
		request.setAttribute("xh", xh);*/
		
		List s = anaesMethodService.getMzffList2(name);
		request.setAttribute("mzffList", s);
		return result;
	}

	/**
	 * @方法名称: addSsdj
	 * @功能描述: 添加手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-18 上午9:46:15
	 * @return String
	 * @throws ParseException
	 */

	public String addSsdj() throws ParseException {
		
		
		String result = "success";
		
		String hospitalId = (String) this.session.get("hospitalid");
		
		if(id!=null  && id.trim().length()>0){ 
			SmRegOpt sros = regOptService.modSsdjListTo(id);
			sros.setAge(sro.getAge());
			sros.setAgeDay(sro.getAgeDay());
			sros.setAgeMon(sro.getAgeMon());
			sros.setBed(sro.getBed());
			sros.setBirthday(sro.getBirthday());
			sros.setChargesType(sro.getChargesType());
			sros.setCreateTime(sros.getCreateTime());
			sros.setPreengagementnumber(sro.getPreengagementnumber());
			sros.setDept(sro.getDept());
			sros.setRegion(sro.getRegion());
			sros.setEndtime(sro.getEndtime());
			sros.setStarttime(sro.getStarttime());
			sros.setHid(sro.getHid());
			sros.setName(sro.getName());
			sros.setOperdate(DateUtil.toDate(YYoperdate, DateUtil.DATE_PATTERN));
			sros.setOperatorId(sro.getOperatorId());
			sros.setOperatorName(sro.getOperatorName());
			sros.setType(sro.getType());
			sros.setState("01");
			sros.setSex(sro.getSex());
			sros.setDiagnosisName(sro.getDiagnosisName());
			sros.setDesignedOptName(sro.getDesignedOptName());
			sros.setOptLevel(sro.getOptLevel());
			sros.setRemark(sro.getRemark());
			sros.setDesignedAnaesMethodName(sro.getDesignedAnaesMethodName());
			try {
				regOptService.modSsdjList(sros);
				info = "修改成功";
			} catch (Exception e) {
				e.printStackTrace();
				info = "修改失败";
			}
		}
		else{
			sro.setOperdate(DateUtil.toDate(YYoperdate, DateUtil.DATE_PATTERN));
			sro.setCreateTime(new Date());
			sro.setState("01");
			sro.setArchstate("00");
			sro.setHospitalId(hospitalId);
			try {
				regOptService.addSsdj(sro);
				info = "添加成功";
			} catch (Exception e) {
				info = "添加失败";
				e.printStackTrace();
			}
		}
		
		
		return result;
	}

	/**
	 * @方法名称: getNameByZimu
	 * @功能描述: AJAX联动查询手术人员
	 * @作者:付士山
	 * @创建时间:2016-1-18 下午3:13:19
	 * @return String  ，"title".toUpperCase()
	 */

	public String getNameByZimu() {

		List<SmOperationPeople> list = operationPeopleService
				.getSopsByZimu(zimu.toUpperCase());
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				SmOperationPeople p = (SmOperationPeople) list.get(i);
				data += "<option class=\"xl\" value=\"" + p.getCode() + "\">" + p.getName()
						+ "</option>";
			}
		}
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @方法名称: getNameById
	 * @功能描述: AJAX联动查询手术人员
	 * @作者；崔连瑞
	 * @创建时间:2016-1-18 下午3:13:19
	 * @return String  ，"title".toUpperCase()
	 */
	
	public String getNameById() {
		if(renyuanID.contains(",")){
			String[] s = renyuanID.split(",");
			String data1="";
			for (int i = 0; i < s.length; i++) {
				SmOperationPeople sop = operationPeopleService.getSpById(Integer.parseInt(s[i]));
				if(sop!=null){
					data1+=sop.getName()+",";
				}
				
			}
			data=data1.substring(0, data1.length()-1);
		}else{
			SmOperationPeople sop = operationPeopleService.getSpById(Integer.parseInt(renyuanID));
			if(sop!=null){
				data=sop.getName();
				
			}
		}
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * @方法名称: getSqzdNameByZimu
	 * @功能描述: AJAX联动查询术前诊断
	 * @作者:崔连瑞
	 * @创建时间:2016-4-28 下午3:13:19
	 * @return String  ，"title".toUpperCase()
	 */
	
	public String getSqzdNameByZimu() {
		
		List<SmDiagnosedef> list = operationPeopleService
				.getSqzdNameByZimu(zimu.toUpperCase());
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				SmDiagnosedef sp = (SmDiagnosedef) list.get(i);
				data += "<option class=\"xl1\" value=\"" + sp.getId() + "\">" + sp.getName()
						+ "</option>";
			}
		}
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @Description: ajax查询诊断
	 * @param    
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-16
	 */
	public void querySqzdName() {
		List<SysIcdCode> list = diagnosedefService.querySqzdName(zimu);
		String json = JSONArray.fromObject(list).toString();
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @方法名称: getSqzdNameByZimu
	 * @功能描述: AJAX联动查询手术人员
	 * @作者:崔连瑞
	 * @创建时间:2016-4-28 下午3:13:19
	 * @return String  ，"title".toUpperCase()
	 */
	
	public String getNsssNameByZimu() {
		
		List<SmOperdef> list = operationPeopleService
				.getNsssNameByZimu(zimu.toUpperCase());
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				SmOperdef sp = (SmOperdef) list.get(i);
				data += "<option class=\"xl2\" value=\"" + sp.getCode() + "\">" + sp.getName()
						+ "</option>";
			}
		}
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: getOperatorNameById 
	 * @Description: 查询手术人员名字
	 * @author 白东旭
	 * @date 2016-2-19 下午4:19:39
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void getOperatorNameById() {
		
		String name = operationPeopleService.getOperatorNameById(operatorId);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");	

		try {
			PrintWriter out = response.getWriter();
			out.print(name);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public RegionService getRegionService() {

		return regionService;
	}

	public void setRegionService(RegionService regionService) {

		this.regionService = regionService;
	}


	public static long getSerialversionuid() {

		return serialVersionUID;
	}

	public List<SysDiseaseArea> getRegionList() {

		return regionList;
	}

	public void setRegionList(List<SysDiseaseArea> regionList) {

		this.regionList = regionList;
	}

	public DeptService getDeptService() {

		return deptService;
	}

	public void setDeptService(DeptService deptService) {

		this.deptService = deptService;
	}

	public List<XtUnit> getDeptList() {

		return deptList;
	}

	public void setDeptList(List<XtUnit> deptList) {

		this.deptList = deptList;
	}

	public AnaesMethodService getAnaesMethodService() {

		return anaesMethodService;
	}

	public void setAnaesMethodService(AnaesMethodService anaesMethodService) {

		this.anaesMethodService = anaesMethodService;
	}

	public List<SmAnaesMethod> getMzffList() {

		return mzffList;
	}

	public void setMzffList(List<SmAnaesMethod> mzffList) {

		this.mzffList = mzffList;
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

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getInfo() {

		return info;
	}

	public void setInfo(String info) {

		this.info = info;
	}

	public OperationPeopleService getOperationPeopleService() {

		return operationPeopleService;
	}

	public void setOperationPeopleService(
			OperationPeopleService operationPeopleService) {

		this.operationPeopleService = operationPeopleService;
	}

	public List<SmOperationPeople> getSopList() {

		return sopList;
	}

	public void setSopList(List<SmOperationPeople> sopList) {

		this.sopList = sopList;
	}

	public SmRegOpt getSro() {

		return sro;
	}

	public void setSro(SmRegOpt sro) {

		this.sro = sro;
	}

	public RegOptService getRegOptService() {

		return regOptService;
	}

	public void setRegOptService(RegOptService regOptService) {

		this.regOptService = regOptService;
	}

	public String getZimu() {

		return zimu;
	}

	public void setZimu(String zimu) {

		this.zimu = zimu;
	}

	public String getData() {

		return data;
	}

	public void setData(String data) {

		this.data = data;
	}

	public DiagnosedefService getDiagnosedefService() {
	
		return diagnosedefService;
	}

	public void setDiagnosedefService(DiagnosedefService diagnosedefService) {
	
		this.diagnosedefService = diagnosedefService;
	}



	public OperdefService getOperdefService() {
	
		return operdefService;
	}

	public void setOperdefService(OperdefService operdefService) {
	
		this.operdefService = operdefService;
	}

	public List<SmOperdef> getOperList() {
	
		return operList;
	}

	public void setOperList(List<SmOperdef> operList) {
	
		this.operList = operList;
	}

	public List<SmRegOpt> getSroList() {
	
		return sroList;
	}

	public void setSroList(List<SmRegOpt> sroList) {
	
		this.sroList = sroList;
	}

	public String getId() {
	
		return id;
	}

	public void setId(String id) {
	
		this.id = id;
	}

	/**
	 * @return the operatorId
	 */
	public String getOperatorId() {
		return operatorId;
	}

	/**
	 * @param operatorId the operatorId to set
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
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
	 * @return the submitRole
	 */
	public boolean isSubmitRole() {
		return submitRole;
	}

	/**
	 * @param submitRole the submitRole to set
	 */
	public void setSubmitRole(boolean submitRole) {
		this.submitRole = submitRole;
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

	public String getYYoperdate() {
	
		return YYoperdate;
	}

	public void setYYoperdate(String yYoperdate) {
	
		YYoperdate = yYoperdate;
	}

	/**
	 * @return the zdList
	 */
	public List<SysIcdCode> getZdList() {
		return zdList;
	}

	/**
	 * @param zdList the zdList to set
	 */
	public void setZdList(List<SysIcdCode> zdList) {
		this.zdList = zdList;
	}

	/**
	 * @return the renyuanID
	 */
	public String getRenyuanID() {
		return renyuanID;
	}

	/**
	 * @param renyuanID the renyuanID to set
	 */
	public void setRenyuanID(String renyuanID) {
		this.renyuanID = renyuanID;
	}

}
