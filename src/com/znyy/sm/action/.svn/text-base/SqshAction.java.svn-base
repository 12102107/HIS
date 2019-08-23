package com.znyy.sm.action;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import com.common.action.AbstractAction;
import com.znyy.sm.service.TongJiService;


 /** 
 * @类名称: SqshAction
 * @类描述:术前术后诊断统计Action
 * @作者:付士山
 * @创建时间:2016-3-22 下午1:39:20
 */
 
public class SqshAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private List sqshList;
	private TongJiService tongJiService;
	private String dateFrom;
	private String dateTo;
	private String checkbox;
	private String xuanze;
	
	public String getSqList() {
		
		if(dateFrom==null&&dateTo==null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DATE, 1);
			calendar.roll(Calendar.DATE, -1);
			DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			dateTo = f.format(calendar.getTime());
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			dateFrom = f.format(calendar.getTime());
			checkbox = "1";
		}
		
		sqshList = tongJiService.getSqshList(dateFrom,dateTo,xuanze);

		return SUCCESS;
	}

	public TongJiService getTongJiService() {
	
		return tongJiService;
	}

	public void setTongJiService(TongJiService tongJiService) {
	
		this.tongJiService = tongJiService;
	}

	public String getDateFrom() {
	
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
	
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
	
		return dateTo;
	}

	public void setDateTo(String dateTo) {
	
		this.dateTo = dateTo;
	}

	public String getCheckbox() {
	
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
	
		this.checkbox = checkbox;
	}

	public String getXuanze() {
	
		return xuanze;
	}

	public void setXuanze(String xuanze) {
	
		this.xuanze = xuanze;
	}

	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}

	public void setSqshList(List sqshList) {
	
		this.sqshList = sqshList;
	}

	public List getSqshList() {
	
		return sqshList;
	}

}
