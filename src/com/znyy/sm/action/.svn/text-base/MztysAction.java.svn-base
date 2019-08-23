package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.XmlUtil;
import com.znyy.bean.Accede;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.service.OperationPeopleService;
import com.znyy.sm.service.YlwsService;

/**
 * @类名称: MztysAction
 * @类描述:麻醉同意书Action
 * @作者:付士山
 * @创建时间:2016-2-24 上午10:04:01
 */

public class MztysAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Accede tys;
	private List<SmRegOpt> tysList;
	private YlwsService ylwsService;
	private String ylwsid;
	private OperationPeopleService operationPeopleService;
	private List<SmOperationPeople> opList;
	private String info;

	private String functionid;
	
	/**
	 * @方法名称: ylwsToMztys
	 * @功能描述: 医疗文书跳转到麻醉同意书
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午10:05:10
	 * @return String
	 */

	public String ylwsToMztys() {

		tysList = ylwsService.getMztysList(ylwsid);
		opList = operationPeopleService.getOpList("0");
		tys = ylwsService.getMztysById(ylwsid);
		return SUCCESS;
	}

	/**
	 * @方法名称: modMztysList
	 * @功能描述: 麻醉知情同意书修改
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午10:04:18
	 * @return String
	 */

	public String modMztysList() {

		Accede mztys = ylwsService.getMztysById(ylwsid);
		if (mztys != null) {
			String notice = tys.getNotice();
			if (notice != null) {
				mztys.setNotice(notice);
			} else {
				mztys.setNotice("");
			}
			mztys.setOperationId(tys.getOperationId());
			mztys.setVisitDate(tys.getVisitDate());
			mztys.setChoosePain(tys.getChoosePain());

			try {
				ylwsService.modMztysList(mztys);
				info = "保存成功";
			} catch (Exception e) {
				e.printStackTrace();
				info = "保存失败";
			}
		} else {

			try {
				ylwsService.addMztys(tys);
				info = "保存成功";
			} catch (Exception e) {
				info = "保存失败";
				e.printStackTrace();
			}
		}

		return "success";
	}

	/**
	 * @方法名称: modMztysList2
	 * @功能描述: 自体输血治疗知情同意书修改
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午10:04:18
	 * @return String
	 */

	public String modMztysList2() {

		Accede mztys = ylwsService.getMztysById(ylwsid);
		if (mztys != null) {
			mztys.setOperationId(tys.getOperationId());
			mztys.setVisitDate(tys.getVisitDate());
			mztys.setTransfusionMerit(tys.getTransfusionMerit());
			mztys.setTransfusionYn(tys.getTransfusionYn());
			try {
				ylwsService.modMztysList(mztys);
				info = "保存成功";
			} catch (Exception e) {
				e.printStackTrace();
				info = "保存失败";
			}
		} else {

			try {
				ylwsService.addMztys(tys);
				info = "保存成功";
			} catch (Exception e) {
				info = "保存失败";
				e.printStackTrace();
			}
		}

		return "success";
	}

	/**
	 * @方法名称: modMztysList3
	 * @功能描述: 气管插管术知情同意书修改
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午10:04:18
	 * @return String
	 */

	public String modMztysList3() {

		Accede mztys = ylwsService.getMztysById(ylwsid);
		if (mztys != null) {
			mztys.setOperationId(tys.getOperationId());
			mztys.setVisitDate(tys.getVisitDate());
			mztys.setChooseAirtube(tys.getChooseAirtube());
			mztys.setAccidentConcurrency(tys.getAccidentConcurrency());

			try {
				ylwsService.modMztysList(mztys);
				info = "保存成功";
			} catch (Exception e) {
				e.printStackTrace();
				info = "保存失败";
			}
		} else {

			try {
				ylwsService.addMztys(tys);
				info = "保存成功";
			} catch (Exception e) {
				info = "保存失败";
				e.printStackTrace();
			}

		}
		return "success";
	}

	/**
	 * @方法名称: modMztysList4
	 * @功能描述: 中心静脉穿刺告知书修改
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午10:04:18
	 * @return String
	 */

	public String modMztysList4() {

		Accede mztys = ylwsService.getMztysById(ylwsid);
		if (mztys != null) {
			mztys.setOperationId(tys.getOperationId());
			mztys.setVisitDate(tys.getVisitDate());
			mztys.setOtherPuncture(tys.getOtherPuncture());

			try {
				ylwsService.modMztysList(mztys);
				info = "保存成功";
			} catch (Exception e) {
				e.printStackTrace();
				info = "保存失败";
			}
		} else {

			try {
				ylwsService.addMztys(tys);
				info = "保存成功";
			} catch (Exception e) {
				info = "保存失败";
				e.printStackTrace();
			}

		}
		return "success";
	}

	/**
	 * @方法名称: loadPrintMz
	 * @功能描述: 麻醉知情同意书打印数据
	 * @作者:付士山
	 * @创建时间:2016-2-29 上午10:23:06 void
	 */

	public void loadPrintMz() {
		String id = request.getParameter("id");

		try {

			List<Map<String, Object>> result = ylwsService.getMzPrint(id);

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");

			PrintWriter out = response.getWriter();
			out.print(XmlUtil.xmlAssemble(result, null));
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public YlwsService getYlwsService() {

		return ylwsService;
	}

	public void setYlwsService(YlwsService ylwsService) {

		this.ylwsService = ylwsService;
	}

	public List<SmRegOpt> getTysList() {

		return tysList;
	}

	public void setTysList(List<SmRegOpt> tysList) {

		this.tysList = tysList;
	}

	public String getYlwsid() {

		return ylwsid;
	}

	public void setYlwsid(String ylwsid) {

		this.ylwsid = ylwsid;
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

	public Accede getTys() {

		return tys;
	}

	public void setTys(Accede tys) {

		this.tys = tys;
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
