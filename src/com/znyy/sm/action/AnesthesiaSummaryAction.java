/**
 * 
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
import com.znyy.bean.SmAnaesSummary;
import com.znyy.bean.SmWritTemplate;
import com.znyy.sm.service.AnesthesiaSummaryService;
import com.znyy.sys.user.service.PermissionService;

/**
 * <p>Title: 麻醉总结</p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author 白东旭
 * @date 2016-4-28
 */
public class AnesthesiaSummaryAction extends CommAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AnesthesiaSummaryService anesthesiaSummaryService;
	
	private PermissionService permissionService;
	
	/**
	 * @return the anesthesiaSummaryService
	 */
	public AnesthesiaSummaryService getAnesthesiaSummaryService() {
		return anesthesiaSummaryService;
	}

	/**
	 * @param anesthesiaSummaryService the anesthesiaSummaryService to set
	 */
	public void setAnesthesiaSummaryService(
			AnesthesiaSummaryService anesthesiaSummaryService) {
		this.anesthesiaSummaryService = anesthesiaSummaryService;
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

	private String functionid;
	
	private SmAnaesSummary summary;

	private String ylwsid;
	
	private String templateType;
	private String templateName;
	private String templateId;
	/**
	 * 
	 * @Description: 获取病人麻醉总结
	 * @param @return   
	 * @return String  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	public String getSummaryByYlwsid() {
		summary = anesthesiaSummaryService.getSummaryByYlwsid(ylwsid);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 保存麻醉总结
	 * @param    
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	public void saveSummary() {
		String username = (String) this.session.get("sessionusername");
		anesthesiaSummaryService.saveSummary(summary,username);
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
	public void saveSummaryTemplate() {
		String userid = (String) session.get("userid");
		anesthesiaSummaryService.saveSummaryTemplate(summary,templateType,templateName,userid); 
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
		
		List<SmWritTemplate> personalTemplate = anesthesiaSummaryService.getSmWritTemplatePersonal(userid);
		request.setAttribute("personal", personalTemplate);
		
		List<SmWritTemplate> publicTemplate = anesthesiaSummaryService.getSmWritTemplatePublic();
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
		
		SmAnaesSummary summary = anesthesiaSummaryService.getTemplateVal(templateId);
		try {
	
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			String json = JSONArray.fromObject(summary).toString();
			
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
		anesthesiaSummaryService.delTemplate(templateId);
	}
	
	/**
	 * 
	 * @Description: 获取打印数据
	 * @param    
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-5-4
	 */
	public void loadPrint() {
		
		try {
			
			List<Map<String, Object>> result = anesthesiaSummaryService.getSummaryPrint(ylwsid);
		
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
	 * @return the summary
	 */
	public SmAnaesSummary getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(SmAnaesSummary summary) {
		this.summary = summary;
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

}
