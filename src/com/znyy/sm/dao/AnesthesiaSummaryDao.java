/**
 * 
 */
package com.znyy.sm.dao;

import java.util.List;
import com.znyy.bean.SmAnaesSummary;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author 白东旭
 * @date 2016-4-28
 */
public interface AnesthesiaSummaryDao {

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
	 * @Description: 保存麻醉总结
	 * @param @param summary   
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	void saveSummary(SmAnaesSummary summary);

	/**
	 * @Description: 保存模板信息
	 * @param @param wt   
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	void saveSmWritTemplate(SmWritTemplate wt);

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
	 * @Description: 获取公共模板
	 * @param @return   
	 * @return List<SmWritTemplate>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-29
	 */
	List<SmWritTemplate> getSmWritTemplatePublic();

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
	 * @Description: 获取手术信息
	 * @param @param ylwsid
	 * @param @return   
	 * @return SmRegOpt  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-5-4
	 */
	SmRegOpt getSmRegOpt(String ylwsid);

}
