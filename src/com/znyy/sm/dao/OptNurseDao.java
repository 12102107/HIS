/**  
 * @Title: OptNurseDao.java 
 * @Package com.znyy.sm.dao 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-3-7 上午11:24:33 
 */ 
package com.znyy.sm.dao;

import java.util.List;
import java.util.Map;

import com.znyy.bean.SmNurseAnaes;
import com.znyy.bean.SmOptNurse;
import com.znyy.bean.SmWritTemplate;

/** 
 * @ClassName: OptNurseDao 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-3-7 上午11:24:33 
 */
public interface OptNurseDao {

	/**
	 * @Title: getSopVague 
	 * @Description: 模糊查询手术人员
	 * @author 白东旭
	 * @date 2016-3-8 上午10:59:35
	 * @param @param word
	 * @param @return
	 * @return List<Map<String,String>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, String>> getSopVague(String word);

	/**
	 * @Title: saveOptNurse 
	 * @Description: 保存手术护理单
	 * @author 白东旭
	 * @date 2016-3-9 上午10:09:56
	 * @param @param nurse
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void saveOptNurse(SmOptNurse nurse);

	/**
	 * @Title: getOptNurseBySroId 
	 * @Description: 根据手术id获取手术护理单
	 * @author 白东旭
	 * @date 2016-3-9 上午10:50:49
	 * @param @param ylwsid
	 * @param @return
	 * @return SmOptNurse
	 * @throws 
	 *
	 */ 
	
	SmOptNurse getOptNurseBySroId(String ylwsid);

	/**
	 * @Title: getSmNurseAnaesBySroid 
	 * @Description: 获取手术护理体征信息
	 * @author 白东旭
	 * @date 2016-3-9 下午2:15:27
	 * @param @param ylwsid
	 * @param @return
	 * @return List<SmNurseAnaes>
	 * @throws 
	 *
	 */ 
	
	List<SmNurseAnaes> getSmNurseAnaesBySroid(String ylwsid);

	/**
	 * @Title: saveSmNurseAnaes 
	 * @Description: 保存体征信息
	 * @author 白东旭
	 * @date 2016-3-9 下午2:54:45
	 * @param @param a
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void saveSmNurseAnaes(SmNurseAnaes a);

	/**
	 * @Title: getOptNursePrint 
	 * @Description: 获取打印数据
	 * @author 白东旭
	 * @date 2016-3-10 下午1:21:40
	 * @param @param ylwsid
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getOptNursePrint(String ylwsid);

	/**
	 * @Title: saveSmWritTemplate 
	 * @Description: 保存模板
	 * @author 白东旭
	 * @date 2016-4-5 上午11:07:18
	 * @param @param wt
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void saveSmWritTemplate(SmWritTemplate wt);

	/**
	 * @Title: getSmWritTemplatePersonal 
	 * @Description: TODO
	 * @author 白东旭
	 * @date 2016-4-5 上午11:09:58
	 * @param @param userid
	 * @param @return
	 * @return List<SmWritTemplate>
	 * @throws 
	 *
	 */ 
	
	List<SmWritTemplate> getSmWritTemplatePersonal(String userid);

	/**
	 * @Title: getSmWritTemplatePublic 
	 * @Description: TODO
	 * @author 白东旭
	 * @date 2016-4-5 上午11:10:02
	 * @param @return
	 * @return List<SmWritTemplate>
	 * @throws 
	 *
	 */ 
	
	List<SmWritTemplate> getSmWritTemplatePublic();

	/**
	 * @Title: delTemplate 
	 * @Description: 删除模板
	 * @author 白东旭
	 * @date 2016-4-5 上午11:11:17
	 * @param @param templateId
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void delTemplate(String templateId);

	/**
	 * @Title: getTemplateVal 
	 * @Description: 获取模板值
	 * @author 白东旭
	 * @date 2016-4-5 上午11:29:31
	 * @param @param templateId
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getTemplateVal(String templateId);

}
