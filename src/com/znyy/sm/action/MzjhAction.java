package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.action.AbstractAction;
import com.common.util.XmlUtil;
import com.znyy.bean.SmAnaesPlanDocument;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.service.OperationPeopleService;
import com.znyy.sm.service.YlwsService;

/**
 * @类名称: MzjhAction
 * @类描述:麻醉计划Action
 * @作者:付士山
 * @创建时间:2016-3-7 上午10:44:42
 */

public class MzjhAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private SmAnaesPlanDocument mzjh;
	private List<SmRegOpt> mzjhList;
	private YlwsService ylwsService;
	private String ylwsid;
	private OperationPeopleService operationPeopleService;
	private List<SmOperationPeople> opList;
	private String info;

	private String functionid;
	
	/**
	 * @方法名称: ylwsToMzjh
	 * @功能描述: 医疗文书跳转麻醉计划
	 * @作者:付士山
	 * @创建时间:2016-3-7 上午10:45:26
	 * @return String
	 */

	public String ylwsToMzjh() {

		mzjhList = ylwsService.getMztysList(ylwsid);
		opList = operationPeopleService.getOpList("0");
		mzjh = ylwsService.getMzjhById(ylwsid);
		return SUCCESS;
	}

	/**
	 * @方法名称: modMzjhList
	 * @功能描述: 麻醉计划修改
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午10:04:18
	 * @return String
	 */

	public String modMzjhList() {

		SmAnaesPlanDocument mzjhs = ylwsService.getMzjhById(ylwsid);
		if (mzjhs != null) {
			String ganaesUserMedicine = mzjh.getGanaesUserMedicine();
			if (ganaesUserMedicine!=null) {
				mzjhs.setGanaesUserMedicine(ganaesUserMedicine);
			} else {
				mzjhs.setGanaesUserMedicine("");
			}

			String abUserMedicine = mzjh.getAbUserMedicine();
			if (abUserMedicine!=null) {
				mzjhs.setAbUserMedicine(abUserMedicine);
			
			} else {
				mzjhs.setAbUserMedicine("");
			}

			String intubattonApproach = mzjh.getIntubattonApproach();
			if (intubattonApproach!=null) {
				mzjhs.setIntubattonApproach(intubattonApproach);
			} else {
				mzjhs.setIntubattonApproach("");
			}

			String anaesMethod = mzjh.getAnaesMethod();
			if (anaesMethod!=null) {
				mzjhs.setAnaesMethod(anaesMethod);
			} else {
				mzjhs.setAnaesMethod("");
			}

			String direction = mzjh.getDirection();
			if (direction!=null) {
				mzjhs.setDirection(direction);
			} else {
				mzjhs.setDirection("");
			}

			String intubattonWay = mzjh.getIntubattonWay();
			if (intubattonWay!=null) {
				mzjhs.setIntubattonWay(intubattonWay);
			} else {
				mzjhs.setIntubattonWay("");
			}
			String specialTechnology = mzjh.getSpecialTechnology();
			if (specialTechnology!=null) {
				mzjhs.setSpecialTechnology(specialTechnology);
			} else {
				mzjhs.setSpecialTechnology("");
			}
			String inspect = mzjh.getInspect();
			if (inspect!=null) {
				mzjhs.setInspect(inspect);
			} else {
				mzjhs.setInspect("");
			}
			String hurtInspect = mzjh.getHurtInspect();
			if (hurtInspect!=null) {
				mzjhs.setHurtInspect(hurtInspect);
			} else {
				mzjhs.setHurtInspect("");
			}
			String liquorCure = mzjh.getLiquorCure();
			if (liquorCure!=null) {
				mzjhs.setLiquorCure(liquorCure);
			} else {
				mzjhs.setLiquorCure("");
			}
			String anaesMatch = mzjh.getAnaesMatch();
			if (anaesMatch!=null) {
				mzjhs.setAnaesMatch(anaesMatch);
			} else {
				mzjhs.setAnaesMatch("");
			}
			mzjhs.setAbduction(mzjh.getAbduction());
			mzjhs.setIntubattonTypeone(mzjh.getIntubattonTypeone());
			mzjhs.setIntubattonTypetwo(mzjh.getIntubattonTypetwo());
			mzjhs.setIntubattonTypeAppendone(mzjh.getIntubattonTypeAppendone());
			mzjhs.setIntubattonTypeAppendtwo(mzjh.getIntubattonTypeAppendtwo());
			mzjhs.setCanalPrepareone(mzjh.getCanalPrepareone());
			mzjhs.setCanalPreparetwo(mzjh.getCanalPreparetwo());
			mzjhs.setCanalPreparethree(mzjh.getCanalPreparethree());
			mzjhs.setDoctorSopite(mzjh.getDoctorSopite());
			mzjhs.setPossibiHappen(mzjh.getPossibiHappen());
			mzjhs.setDiscuss(mzjh.getDiscuss());
			mzjhs.setBloodPreH(mzjh.getBloodPreH());
			mzjhs.setBloodPreL(mzjh.getBloodPreL());
			mzjhs.setHeartRhythm(mzjh.getHeartRhythm());
			mzjhs.setBreathFre(mzjh.getBreathFre());
			mzjhs.setSpo2(mzjh.getSpo2());
			mzjhs.setPrefastingtime(mzjh.getPrefastingtime());
			mzjhs.setEquipmentInspection(mzjh.getEquipmentInspection());
			mzjhs.setConclusion(mzjh.getConclusion());
			mzjhs.setAneasdoctor(mzjh.getAneasdoctor());
			mzjhs.setVisitDate(mzjh.getVisitDate());

			try {
				ylwsService.modMzjhList(mzjhs);
				info = "保存成功";
			} catch (Exception e) {
				e.printStackTrace();
				info = "保存失败";
			}
		} else {

			try {
				ylwsService.addMzjh(mzjh);
				info = "保存成功";
			} catch (Exception e) {
				info = "保存失败";
				e.printStackTrace();
			}
		}

		return "success";
	}

	/**
	 * @方法名称: loadPrintMzjh
	 * @功能描述: 麻醉计划打印数据
	 * @作者:付士山
	 * @创建时间:2016-2-29 上午10:23:06 void
	 */

	public void loadPrintMzjh() {
		String id = request.getParameter("id");

		try {

			List<Map<String, Object>> result = ylwsService.getMzPrintMzjh(id);

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

	public String getInfo() {

		return info;
	}

	public void setInfo(String info) {

		this.info = info;
	}

	public static long getSerialversionuid() {

		return serialVersionUID;
	}

	public SmAnaesPlanDocument getMzjh() {

		return mzjh;
	}

	public void setMzjh(SmAnaesPlanDocument mzjh) {

		this.mzjh = mzjh;
	}

	public List<SmRegOpt> getMzjhList() {

		return mzjhList;
	}

	public void setMzjhList(List<SmRegOpt> mzjhList) {

		this.mzjhList = mzjhList;
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
