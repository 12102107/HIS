package com.znyy.sm.action;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.common.action.AbstractAction;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.XtUnit;
import com.znyy.sm.service.DeptService;
import com.znyy.sm.service.OperationPeopleService;
import com.znyy.sm.service.TongJiService;

 /** 
 * @类名称: AsaAction
 * @类描述:Asa统计Action
 * @作者:付士山
 * @创建时间:2016-3-18 下午12:45:38
 */
 
public class AsaAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private List asaJiList;
	private TongJiService tongJiService;
	private OperationPeopleService operationPeopleService;
	private List<SmOperationPeople> opList;
	private List<XtUnit> deptList;
	private List<SmOperationPeople> nurseList;
	private List<SmOperationPeople> nurseList2;
	private DeptService deptService;
	private String asaDateFrom;
	private String asaDateTo;
	private String asaCheckbox;
	private String xuanze;
	private String asayi;
	private String asahu;
	private String asake;
	/**
	 * @方法名称: getAsaList
	 * @功能描述: 获取ASA统计数据
	 * @作者:付士山
	 * @创建时间:2016-3-14 上午10:53:32
	 * @return String
	 */

	public String getAsaList() {
		
		if(asaDateFrom==null&&asaDateTo==null) {
			asaJiList = null;
		} else {
			try {
				asaJiList = tongJiService.getAsaList(asaDateFrom,asaDateTo,asake,asayi,asahu,xuanze);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		opList = operationPeopleService.getSops("0", "手术医师");
		nurseList = operationPeopleService.getSops("0", "巡回护士");
		nurseList2 = operationPeopleService.getSops("0", "器械护士");
		nurseList.addAll(nurseList2);
		
		String hospitalId = (String) this.session.get("hospitalid");
		deptList = deptService.getDepts(hospitalId);
	
		return SUCCESS;
	}

	

	public OperationPeopleService getOperationPeopleService() {

		return operationPeopleService;
	}

	public void setOperationPeopleService(
			OperationPeopleService operationPeopleService) {

		this.operationPeopleService = operationPeopleService;
	}

	public List<SmOperationPeople> getOpList() {

		return opList;
	}

	public List<SmOperationPeople> getNurseList() {
	
		return nurseList;
	}

	public void setNurseList(List<SmOperationPeople> nurseList) {
	
		this.nurseList = nurseList;
	}

	public DeptService getDeptService() {
	
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
	
		this.deptService = deptService;
	}

	public List<SmOperationPeople> getNurseList2() {
	
		return nurseList2;
	}

	public void setNurseList2(List<SmOperationPeople> nurseList2) {
	
		this.nurseList2 = nurseList2;
	}

	public List<XtUnit> getDeptList() {
	
		return deptList;
	}

	public void setDeptList(List<XtUnit> deptList) {
	
		this.deptList = deptList;
	}

	public TongJiService getTongJiService() {
	
		return tongJiService;
	}

	public void setTongJiService(TongJiService tongJiService) {
	
		this.tongJiService = tongJiService;
	}

	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}

	public void setOpList(List<SmOperationPeople> opList) {
	
		this.opList = opList;
	}


	public List getAsaJiList() {
	
		return asaJiList;
	}



	public void setAsaJiList(List asaJiList) {
	
		this.asaJiList = asaJiList;
	}



	public String getAsaDateFrom() {
	
		return asaDateFrom;
	}



	public void setAsaDateFrom(String asaDateFrom) {
	
		this.asaDateFrom = asaDateFrom;
	}



	public String getAsaDateTo() {
	
		return asaDateTo;
	}



	public void setAsaDateTo(String asaDateTo) {
	
		this.asaDateTo = asaDateTo;
	}



	public String getAsaCheckbox() {
	
		return asaCheckbox;
	}



	public void setAsaCheckbox(String asaCheckbox) {
	
		this.asaCheckbox = asaCheckbox;
	}



	public String getXuanze() {
	
		return xuanze;
	}



	public void setXuanze(String xuanze) {
	
		this.xuanze = xuanze;
	}



	public String getAsayi() {
	
		return asayi;
	}



	public void setAsayi(String asayi) {
	
		this.asayi = asayi;
	}



	public String getAsahu() {
	
		return asahu;
	}



	public void setAsahu(String asahu) {
	
		this.asahu = asahu;
	}



	public String getAsake() {
	
		return asake;
	}



	public void setAsake(String asake) {
	
		this.asake = asake;
	}




}
