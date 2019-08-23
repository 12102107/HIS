package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import com.common.action.AbstractAction;
import com.common.util.XmlUtil;
import com.znyy.bean.SmAnaesWatch;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;
import com.znyy.sm.service.OperationPeopleService;
import com.znyy.sm.service.YlwsService;

/**
 * @类名称: ShsfAction
 * @类描述:术后随访Action
 * @作者:付士山
 * @创建时间:2016-3-9 上午10:27:20
 */

public class ShsfAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private SmAnaesWatch shsf;
	private List<SmRegOpt> shsfList;
	private YlwsService ylwsService;
	private String ylwsid;
	private OperationPeopleService operationPeopleService;
	private List<SmOperationPeople> opList;
	private String info;
	
	private String templateType;
	private String templateName;
	private String templateId;
	
	private String functionid;
	
	/**
	 * @方法名称: ylwsToShsf
	 * @功能描述: 医疗文书跳转术后随访
	 * @作者:付士山
	 * @创建时间:2016-3-7 上午10:45:26
	 * @return String
	 */

	public String ylwsToShsf() {

		shsfList = ylwsService.getMztysList(ylwsid);
		opList = operationPeopleService.getOpList("0");
		shsf = ylwsService.getShsfById(ylwsid);
		return SUCCESS;
	}

	/**
	 * @方法名称: modShsfList
	 * @功能描述: 术后随访修改
	 * @作者:付士n山
	 * @创建时间:2016-2-24 上午10:04:18
	 * @return String
	 */

	public String modShsfList() {

		SmAnaesWatch shsfs = ylwsService.getShsfById(ylwsid);
		if (shsfs != null) {
			shsfs.setBloodPressure(shsf.getBloodPressure());
			shsfs.setPulse(shsf.getPulse());
			shsfs.setObservetime(shsf.getObservetime());
			shsfs.setAwarenessOperation(shsf.getAwarenessOperation());
			shsfs.setMuscularSoreness(shsf.getMuscularSoreness());
			shsfs.setAllsick(shsf.getAllsick());
			shsfs.setAllvomit(shsf.getAllvomit());
			shsfs.setFaucesache(shsf.getFaucesache());
			shsfs.setSoundhoarseness(shsf.getSoundhoarseness());
			shsfs.setObservepeople(shsf.getObservepeople());
			shsfs.setNerveBlockedRemark(shsf.getNerveBlockedRemark());
			shsfs.setNerveBlockedObservetime(shsf.getNerveBlockedObservetime());
			shsfs.setLumbago(shsf.getLumbago());
			shsfs.setNeuralsick(shsf.getNeuralsick());
			shsfs.setNeuralvomit(shsf.getNeuralvomit());
			shsfs.setLegParesthesia(shsf.getLegParesthesia());
			shsfs.setLegMovement(shsf.getLegMovement());
			shsfs.setNeuralObservepeople(shsf.getNeuralObservepeople());
			shsfs.setNeuralRemark(shsf.getNeuralRemark());
			shsfs.setRemark(shsf.getRemark());
			shsfs.setAnalgesiaplan(shsf.getAnalgesiaplan());
			shsfs.setObserveaftertime(shsf.getObserveaftertime());
			shsfs.setQuietvas(shsf.getQuietvas());
			shsfs.setExercisevas(shsf.getExercisevas());
			shsfs.setNaupathia(shsf.getNaupathia());
			shsfs.setVomit(shsf.getVomit());
			shsfs.setPruritus(shsf.getPruritus());
			shsfs.setObservepeopleafter(shsf.getObservepeopleafter());
			shsfs.setRemarkafter(shsf.getRemarkafter());

			try {
				ylwsService.modShfsList(shsfs);
				info = "保存成功";
			} catch (Exception e) {
				e.printStackTrace();
				info = "保存失败";
			}
		} else {

			try {
				ylwsService.addShfs(shsf);
				info = "保存成功";
			} catch (Exception e) {
				info = "保存失败";
				e.printStackTrace();
			}
		}

		return "success";
	}

	/**
	 * @方法名称: loadPrintShsf
	 * @功能描述: 术后随访打印数据
	 * @作者:付士山
	 * @创建时间:2016-2-29 上午10:23:06 void
	 */

	public void loadPrintSf() {
		String id = request.getParameter("id");

		try {

			List<Map<String, Object>> result = ylwsService.getPrintSf(id);

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
	
	/**
	 * 
	 * @Description: 保存模板跳转
	 * @param @return   
	 * @return String  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public String templateTo() {
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 保存术后随访模板
	 * @param    
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public void saveShsfTemplate() {
		String userid = (String) session.get("userid");
		ylwsService.saveShsfTemplate(shsf,templateType,templateName,userid);
	}
	
	/**
	 * 
	 * @Description: 选则模板跳转
	 * @param @return   
	 * @return String  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public String choseTemplateTo() {
		
		String userid = (String) session.get("userid"); 
		
		List<SmWritTemplate> personalTemplate = ylwsService.getSmWritTemplatePersonal(userid);
		request.setAttribute("personal", personalTemplate);
		
		List<SmWritTemplate> publicTemplate = ylwsService.getSmWritTemplatePublic();
		request.setAttribute("publicT", publicTemplate);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 获取模板内容
	 * @param    
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public void getTemplateVal() {
		
		SmAnaesWatch template = ylwsService.getTemplateVal(templateId);
		try {
	
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			String json = JSONArray.fromObject(template).toString();
			
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
	 * @Description: 删除模板
	 * @param    
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public void delTemplate() {
		ylwsService.delTemplate(templateId);
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

	public SmAnaesWatch getShsf() {

		return shsf;
	}

	public void setShsf(SmAnaesWatch shsf) {

		this.shsf = shsf;
	}

	public List<SmRegOpt> getShsfList() {

		return shsfList;
	}

	public void setShsfList(List<SmRegOpt> shsfList) {

		this.shsfList = shsfList;
	}

	/**
	 * @return the templateType
	 */
	public String getTemplateType() {
		return templateType;
	}

	/**
	 * @param templateType the templateType to set
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	/**
	 * @return the templateName
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * @return the templateId
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
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
