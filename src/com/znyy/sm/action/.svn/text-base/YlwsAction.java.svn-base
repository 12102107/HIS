package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.Page;
import com.common.util.Util;
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.service.RegOptService;
import com.znyy.sm.service.YlwsService;
import com.znyy.sys.user.service.PermissionService;

public class YlwsAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private static String NOT_STARTED="03";
	private String id;
	private String name;
	private String hid;
	private String room;
	private Date operDate;
	private String state;
	private String designed_opt_name;
	private Integer pageSize;//每页有几条数据
	private String page;//当前页是第几页
	private String info;

	private SmRegOpt sro;
	private RegOptService regOptService;
	private List<SmRegOpt> ylwsList;
	private YlwsService ylwsService;
	
	private PermissionService permissionService;
	private boolean optNurseRole; //手术护理
	private boolean followUpRole; //术后随访
	private boolean anesthesiaSummaryRole; //麻醉总结
	private boolean anesthesiaPlanRole; // 麻醉计划
	private boolean anestheticRecordRole; //麻醉记录
	private boolean agreementRole; //同意书
	private boolean preVisitRole; //术前访视
	private boolean archivedRole; //归档权限
	private String functionid; 
	
	
	/** 
	 * @类名称: YlwsAction
	 * @类描述:医疗文书Action
	 * @作者:崔连瑞
	 * @创建时间:2016-2-18 下午14:30:44
	 */
	public String getYlwsList1(){
		//当前页为第几页
		if (page == null || page.equals("")) {
			page = "1";
		}
		int parmpage = Integer.parseInt(page);
		        //每页显示的条数
		if (pageSize == null) {
			pageSize = 20;
		}
		int newPage = Integer.parseInt(page);
				//从第几条数据开始查询
		int xh = (newPage - 1) * pageSize + 1;
		String hospitalId = (String) this.session.get("hospitalid");
		Page pageYlwsList = ylwsService.getYlwsList(parmpage, pageSize,hospitalId);
		request.setAttribute("totalP", pageYlwsList.getTotalPageCount());
		request.setAttribute("totalN", pageYlwsList.getTotalCount());
		request.setAttribute("ylwsList", pageYlwsList.getData());
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", parmpage);
		request.setAttribute("xh", xh);
		
		List<String> btnCodes = permissionService.getBtnCode(
				Util.getIntegerValue(this.session.get("userid")), functionid,(String) this.session.get("sysid"));
		optNurseRole = btnCodes.contains("optNurse");
		followUpRole = btnCodes.contains("followUp");
		anesthesiaSummaryRole = btnCodes.contains("anesthesiaSummary");
		anesthesiaPlanRole = btnCodes.contains("anesthesiaPlan");
		anestheticRecordRole = btnCodes.contains("anestheticRecord");
		agreementRole = btnCodes.contains("agreement");
		preVisitRole = btnCodes.contains("preVisit");
		archivedRole = btnCodes.contains("archived");
		
		
		return SUCCESS;
	}
	
	/** 
	 * @类名称: YlwsAction
	 * @类描述:创建医疗文书Action
	 * @作者:崔连瑞
	 * @创建时间:2016-2-18 下午15:30:44
	 */
	public List<SmRegOpt> createDocument(List<SmRegOpt> list){
		
		List<SmRegOpt> result = new ArrayList<SmRegOpt>();
		
		if(list!=null&&!list.isEmpty()){
			for (Iterator<SmRegOpt> iterator = list.iterator(); iterator.hasNext();) {
				SmRegOpt smRegOpt = (SmRegOpt) iterator.next();
				smRegOpt.setState(NOT_STARTED);
				result.add(smRegOpt);
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @Title: modArchived 
	 * @Description: 医疗文书归档
	 * @author 白东旭
	 * @date 2016-3-11 上午11:01:12
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void modArchived() {
		ylwsService.modArchived(id);
	}
	/**
	 * 
	 * @Title: checkSmWirtstate 
	 * @Description: 检查文书状态
	 * @author 白东旭
	 * @date 2016-3-14 上午11:29:19
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void checkSmWirtstate() {
		try {
			String result = ylwsService.getSmWirtstateVal(id);
		
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	
	
			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
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
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getHid() {
		return hid;
	}


	public void setHid(String hid) {
		this.hid = hid;
	}


	public String getRoom() {
		return room;
	}


	public void setRoom(String room) {
		this.room = room;
	}








	public Date getOperDate() {
		return operDate;
	}


	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}


	public List<SmRegOpt> getYlwsList() {
		return ylwsList;
	}


	public YlwsService getYlwsService() {
		return ylwsService;
	}


	public void setYlwsService(YlwsService ylwsService) {
		this.ylwsService = ylwsService;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getDesigned_opt_name() {
		return designed_opt_name;
	}


	public void setDesigned_opt_name(String designed_opt_name) {
		this.designed_opt_name = designed_opt_name;
	}
	public void setRegOptService(RegOptService regOptService) {
		this.regOptService = regOptService;
	}

	public void setYlwsList(List<SmRegOpt> ylwsList) {
		this.ylwsList = ylwsList;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getNOT_STARTED() {
	
		return NOT_STARTED;
	}

	public static void setNOT_STARTED(String nOT_STARTED) {
	
		NOT_STARTED = nOT_STARTED;
	}

	public String getInfo() {
	
		return info;
	}

	public void setInfo(String info) {
	
		this.info = info;
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
	 * @return the optNurseRole
	 */
	public boolean isOptNurseRole() {
		return optNurseRole;
	}

	/**
	 * @param optNurseRole the optNurseRole to set
	 */
	public void setOptNurseRole(boolean optNurseRole) {
		this.optNurseRole = optNurseRole;
	}

	/**
	 * @return the followUpRole
	 */
	public boolean isFollowUpRole() {
		return followUpRole;
	}

	/**
	 * @param followUpRole the followUpRole to set
	 */
	public void setFollowUpRole(boolean followUpRole) {
		this.followUpRole = followUpRole;
	}

	/**
	 * @return the anesthesiaSummaryRole
	 */
	public boolean isAnesthesiaSummaryRole() {
		return anesthesiaSummaryRole;
	}

	/**
	 * @param anesthesiaSummaryRole the anesthesiaSummaryRole to set
	 */
	public void setAnesthesiaSummaryRole(boolean anesthesiaSummaryRole) {
		this.anesthesiaSummaryRole = anesthesiaSummaryRole;
	}

	/**
	 * @return the anesthesiaPlanRole
	 */
	public boolean isAnesthesiaPlanRole() {
		return anesthesiaPlanRole;
	}

	/**
	 * @param anesthesiaPlanRole the anesthesiaPlanRole to set
	 */
	public void setAnesthesiaPlanRole(boolean anesthesiaPlanRole) {
		this.anesthesiaPlanRole = anesthesiaPlanRole;
	}

	/**
	 * @return the anestheticRecordRole
	 */
	public boolean isAnestheticRecordRole() {
		return anestheticRecordRole;
	}

	/**
	 * @param anestheticRecordRole the anestheticRecordRole to set
	 */
	public void setAnestheticRecordRole(boolean anestheticRecordRole) {
		this.anestheticRecordRole = anestheticRecordRole;
	}

	/**
	 * @return the agreementRole
	 */
	public boolean isAgreementRole() {
		return agreementRole;
	}

	/**
	 * @param agreementRole the agreementRole to set
	 */
	public void setAgreementRole(boolean agreementRole) {
		this.agreementRole = agreementRole;
	}

	/**
	 * @return the preVisitRole
	 */
	public boolean isPreVisitRole() {
		return preVisitRole;
	}

	/**
	 * @param preVisitRole the preVisitRole to set
	 */
	public void setPreVisitRole(boolean preVisitRole) {
		this.preVisitRole = preVisitRole;
	}

	/**
	 * @return the archivedRole
	 */
	public boolean isArchivedRole() {
		return archivedRole;
	}

	/**
	 * @param archivedRole the archivedRole to set
	 */
	public void setArchivedRole(boolean archivedRole) {
		this.archivedRole = archivedRole;
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
