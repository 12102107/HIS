/**  
 * @Title: OptNurseAction.java 
 * @Package com.znyy.sm.action 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-3-7 上午11:17:48 
 */ 
package com.znyy.sm.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.common.action.CommAction;
import com.common.util.XmlUtil;
import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmNurseAnaes;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.bean.SmOptNurse;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;
import com.znyy.sm.service.OptNurseService;

/** 
 * @ClassName: OptNurseAction 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-3-7 上午11:17:48 
 */
public class OptNurseAction extends CommAction {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	
	private OptNurseService optNurseService;

	/**
	 * @return the optNurseService
	 */
	public OptNurseService getOptNurseService() {
		return optNurseService;
	}

	/**
	 * @param optNurseService the optNurseService to set
	 */
	public void setOptNurseService(OptNurseService optNurseService) {
		this.optNurseService = optNurseService;
	}

	private String ylwsid;//OPERATION_ID
	
	private SmOptNurse nurse;
	
	private List<SmNurseAnaes> anaes;
	
	private String word;
	
	private String templateId;
	private String templateType;
	private String templateName;
	
	private String functionid;
	
	/**
	 * 
	 * @Title: optNurseList 
	 * @Description: 跳转到护理页面
	 * @author 白东旭
	 * @date 2016-3-7 上午11:35:45
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String optNurseList() {
		
		SmRegOpt sro = optNurseService.getSmRegOptById(ylwsid);
		request.setAttribute("sro", sro);
		
		List<SmOperdef> designedOptName = optNurseService.getSmOperdefList();
		request.setAttribute("designedOptNameList", designedOptName);
		
		List<SmDiagnosedef> diagnosedef = optNurseService.getSmDiagnosedefList();
		request.setAttribute("diagnosedefList", diagnosedef);
		
		List<SmOperationPeople> sopList = optNurseService.getSmOperationPeopleList("手术医师");	
		request.setAttribute("sopList", sopList);
		
		List<SmOperationPeople> mzList = optNurseService.getSmOperationPeopleList("手术麻醉医师");	
		request.setAttribute("mzList", mzList);
		
		List<SmOperationPeople> qxList = optNurseService.getSmOperationPeopleList("器械护士");	
		request.setAttribute("qxList", qxList);
		
		List<SmOperationPeople> xhList = optNurseService.getSmOperationPeopleList("巡回护士");	
		request.setAttribute("xhList", xhList);
		
		nurse = optNurseService.getOptNurseBySroId(ylwsid);
		
		anaes = optNurseService.getSmNurseAnaesBySroid(ylwsid);
		if(anaes!=null&&!anaes.isEmpty()) {
			int n = 0;
			for(int i=0;i<anaes.size();i++) {
				if(anaes.get(i).getType().equals("0")) {
					request.setAttribute("anaes0", anaes.get(i));
				}
				if(anaes.get(i).getType().equals("1")) {
					if(n==0) request.setAttribute("anaes1", anaes.get(i));
					if(n==1) request.setAttribute("anaes2", anaes.get(i));
					if(n==2) request.setAttribute("anaes3", anaes.get(i));
					n++;
				}
				if(anaes.get(i).getType().equals("2")) {
					request.setAttribute("anaes4", anaes.get(i));
				}
			}
		}
		
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: getSopVague 
	 * @Description: 模糊查询手术人员
	 * @author 白东旭
	 * @date 2016-3-8 上午10:56:23
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void getSopVague() {
		
		List<Map<String,String>> sop = optNurseService.getSopVague(word);
		try {
	
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			String json = JSONArray.fromObject(sop).toString();
			
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
	 * @Title: saveOptNurse 
	 * @Description: 保存手术护理
	 * @author 白东旭
	 * @date 2016-3-9 上午10:08:45
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void saveOptNurse() {
		optNurseService.saveOptNurse(nurse,anaes);
	}
	
	/**
	 * 
	 * @Title: commitOptNurse 
	 * @Description: 提交手术护理
	 * @author 白东旭
	 * @date 2016-3-9 下午4:19:40
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void commitOptNurse() {
		optNurseService.saveOptNurseCommit(nurse,anaes);
	}
	
	/**
	 * 
	 * @Title: loadPrint 
	 * @Description: 获取打印数据
	 * @author 白东旭
	 * @date 2016-3-10 下午1:18:44
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void loadPrint() {
		try {
			
			List<Map<String, Object>> result = optNurseService.getOptNursePrint(ylwsid);
		
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			PrintWriter out = response.getWriter();
			out.print(XmlUtil.xmlAssemble(null,result));
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title: templateTo 
	 * @Description: 模板信息跳转
	 * @author 白东旭
	 * @date 2016-4-5 上午11:01:35
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String templateTo() {
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: saveOptNurseTemplate 
	 * @Description: 保存模板
	 * @author 白东旭
	 * @date 2016-4-5 上午11:01:44
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void saveOptNurseTemplate() {
		String userid = (String) session.get("userid");
		optNurseService.saveOptNurseTemplate(nurse,anaes,templateType,templateName,userid); 
	}
	
	/**
	 * 
	 * @Title: choseTemplateTo 
	 * @Description: 选择模板页跳转
	 * @author 白东旭
	 * @date 2016-4-5 上午11:01:58
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String choseTemplateTo() {
		
		String userid = (String) session.get("userid"); 
		
		List<SmWritTemplate> personalTemplate = optNurseService.getSmWritTemplatePersonal(userid);
		request.setAttribute("personal", personalTemplate);
		
		List<SmWritTemplate> publicTemplate = optNurseService.getSmWritTemplatePublic();
		request.setAttribute("publicT", publicTemplate);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: getTemplateVal 
	 * @Description: 获取模板内容
	 * @author 白东旭
	 * @date 2016-4-5 上午11:02:05
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void getTemplateVal() {
		
		List<Map<String,Object>> template = optNurseService.getTemplateVal(templateId);
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
	 * @Title: delTemplate 
	 * @Description: 删除模板
	 * @author 白东旭
	 * @date 2016-4-5 上午11:02:14
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void delTemplate() {
		optNurseService.delTemplate(templateId);
	}
	
	
	/**
	 * @return the ylwsid
	 */
	public String getYlwsid() {
		return ylwsid;
	}

	/**
	 * @param ylwsid the ylwsid to set
	 */
	public void setYlwsid(String ylwsid) {
		this.ylwsid = ylwsid;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the nurse
	 */
	public SmOptNurse getNurse() {
		return nurse;
	}

	/**
	 * @param nurse the nurse to set
	 */
	public void setNurse(SmOptNurse nurse) {
		this.nurse = nurse;
	}

	/**
	 * @return the anaes
	 */
	public List<SmNurseAnaes> getAnaes() {
		return anaes;
	}

	/**
	 * @param anaes the anaes to set
	 */
	public void setAnaes(List<SmNurseAnaes> anaes) {
		this.anaes = anaes;
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
