package com.znyy.sm.action;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.common.action.AbstractAction;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.service.OperationPeopleService;
import com.znyy.sm.service.TongJiService;

/**
 * @类名称: MzlsAction
 * @类描述:麻醉例数统计Action
 * @作者:付士山
 * @创建时间:2016-3-14 上午10:04:57
 */

public class MzlsAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private List regOptList;
	private List regOptListAll;
	private TongJiService tongJiService;
	private OperationPeopleService operationPeopleService;
	private List<SmOperationPeople> opList;
	private String yishi;
	private String dateFrom;
	private String dateTo;
	private String mzlsCheckbox;

	/**
	 * @方法名称: getMzlsList
	 * @功能描述: 获取麻醉例数统计数据
	 * @作者:付士山
	 * @创建时间:2016-3-14 上午10:53:32
	 * @return String
	 */

	public String getMzlsList() {

		if(dateFrom==null&&dateTo==null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DATE, 1);
			calendar.roll(Calendar.DATE, -1);
			DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			dateTo = f.format(calendar.getTime());
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			dateFrom = f.format(calendar.getTime());
			mzlsCheckbox = "1";
		}
		
		regOptList = tongJiService.getMzlsList(yishi, dateFrom, dateTo);
		regOptListAll = tongJiService.getMzlsListAll(yishi, dateFrom, dateTo);
		opList = operationPeopleService.getSops("0", "手术医师");
		return SUCCESS;
	}

	public List<SmRegOpt> getRegOptList() {

		return regOptList;
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

	public void setOpList(List<SmOperationPeople> opList) {

		this.opList = opList;
	}

	public static long getSerialversionuid() {

		return serialVersionUID;
	}

	public TongJiService getTongJiService() {

		return tongJiService;
	}

	public void setTongJiService(TongJiService tongJiService) {

		this.tongJiService = tongJiService;
	}

	public String getYishi() {

		return yishi;
	}

	public void setYishi(String yishi) {

		this.yishi = yishi;
	}

	public String getDateFrom() {

		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {

		this.dateFrom = dateFrom;
	}

	public void setDateTo(String dateTo) {

		this.dateTo = dateTo;
	}

	public String getDateTo() {

		return dateTo;
	}

	public String getMzlsCheckbox() {

		return mzlsCheckbox;
	}

	public void setMzlsCheckbox(String mzlsCheckbox) {

		this.mzlsCheckbox = mzlsCheckbox;
	}

	public List getRegOptListAll() {
	
		return regOptListAll;
	}

	public void setRegOptListAll(List regOptListAll) {
	
		this.regOptListAll = regOptListAll;
	}

	public void setRegOptList(List regOptList) {
	
		this.regOptList = regOptList;
	}

}
