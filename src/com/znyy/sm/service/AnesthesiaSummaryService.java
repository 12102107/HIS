/**
 * 
 */
package com.znyy.sm.service;

import java.util.List;
import java.util.Map;

import com.znyy.bean.SmAnaesSummary;
import com.znyy.bean.SmWritTemplate;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author 白东旭
 * @date 2016-4-28
 */
public interface AnesthesiaSummaryService {

	/**
	 * @Description: 获取麻醉总结
	 * @param @param ylwsid
	 * @param @return   
	 * @return SmAnaesSummary  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	SmAnaesSummary getSummaryByYlwsid(String ylwsid);

	/**
	 * @param username 
	 * @Description: 保存麻醉总结
	 * @param @param summary   
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	void saveSummary(SmAnaesSummary summary, String username);

	/**
	 * @Description: 保存模板
	 * @param @param summary
	 * @param @param templateType
	 * @param @param templateName
	 * @param @param userid   
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	void saveSummaryTemplate(SmAnaesSummary summary, String templateType,
			String templateName, String userid);

	/**
	 * @Description: 获取个人模板
	 * @param @param userid
	 * @param @return   
	 * @return List<SmWritTemplate>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	List<SmWritTemplate> getSmWritTemplatePersonal(String userid);

	/**
	 * @Description: 获取公告模板
	 * @param @return   
	 * @return List<SmWritTemplate>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	List<SmWritTemplate> getSmWritTemplatePublic();

	/**
	 * @Description: 获取模板内容
	 * @param @param templateId
	 * @param @return   
	 * @return SmAnaesSummary  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	SmAnaesSummary getTemplateVal(String templateId);

	/**
	 * @Description: 删除模板
	 * @param @param templateId   
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	void delTemplate(String templateId);

	/**
	 * @Description: 获取打印内容
	 * @param @param ylwsid
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-5-4
	 */
	List<Map<String, Object>> getSummaryPrint(String ylwsid);

}
