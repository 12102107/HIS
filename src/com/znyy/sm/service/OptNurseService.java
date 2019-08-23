/**  
 * @Title: OptNurseService.java 
 * @Package com.znyy.sm.service 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-3-7 上午11:21:54 
 */ 
package com.znyy.sm.service;

import java.util.List;
import java.util.Map;

import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmNurseAnaes;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.bean.SmOptNurse;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;

/** 
 * @ClassName: OptNurseService 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-3-7 上午11:21:54 
 */
public interface OptNurseService {

	/**
	 * @Title: getSmRegOptById 
	 * @Description: 获取手术信息
	 * @author 白东旭
	 * @date 2016-3-8 上午9:14:01
	 * @param @param ylwsid
	 * @param @return
	 * @return SmRegOpt
	 * @throws 
	 *
	 */ 
	
	SmRegOpt getSmRegOptById(String ylwsid);

	/**
	 * @Title: getSmOperdefList 
	 * @Description: 获取手术列表
	 * @author 白东旭
	 * @date 2016-3-8 上午10:02:43
	 * @param @return
	 * @return List<SmOperdef>
	 * @throws 
	 *
	 */ 
	
	List<SmOperdef> getSmOperdefList();

	/**
	 * @Title: getSmDiagnosedefList 
	 * @Description: 获取诊断列表
	 * @author 白东旭
	 * @date 2016-3-8 上午10:07:08
	 * @param @return
	 * @return List<SmDiagnosedef>
	 * @throws 
	 *
	 */ 
	
	List<SmDiagnosedef> getSmDiagnosedefList();

	/**
	 * @Title: getSopVague 
	 * @Description: 模糊查询手术人员
	 * @author 白东旭
	 * @date 2016-3-8 上午10:57:47
	 * @param @param word
	 * @param @return
	 * @return List<Map<String,String>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, String>> getSopVague(String word);

	/**
	 * @Title: getSmOperationPeopleList 
	 * @Description: 获取手术人员
	 * @author 白东旭
	 * @date 2016-3-8 上午11:48:12
	 * @param @param string
	 * @param @return
	 * @return List<SmOperationPeople>
	 * @throws 
	 *
	 */ 
	
	List<SmOperationPeople> getSmOperationPeopleList(String string);

	/**
	 * @param anaes 
	 * @Title: saveOptNurse 
	 * @Description: 保存手术护理单
	 * @author 白东旭
	 * @date 2016-3-9 上午10:09:16
	 * @param @param nurse
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void saveOptNurse(SmOptNurse nurse, List<SmNurseAnaes> anaes);

	/**
	 * @Title: getOptNurseBySroId 
	 * @Description: 根据手术id获取手术护理单
	 * @author 白东旭
	 * @date 2016-3-9 上午10:49:47
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
	 * @date 2016-3-9 下午2:14:52
	 * @param @param ylwsid
	 * @param @return
	 * @return List<SmNurseAnaes>
	 * @throws 
	 *
	 */ 
	
	List<SmNurseAnaes> getSmNurseAnaesBySroid(String ylwsid);

	/**
	 * @Title: saveOptNurseCommit 
	 * @Description: 提交手术护理
	 * @author 白东旭
	 * @date 2016-3-9 下午4:20:11
	 * @param @param nurse
	 * @param @param anaes
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void saveOptNurseCommit(SmOptNurse nurse, List<SmNurseAnaes> anaes);

	/**
	 * @Title: getOptNursePrint 
	 * @Description: 获取打印数据
	 * @author 白东旭
	 * @date 2016-3-10 下午1:20:31
	 * @param @param ylwsid
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getOptNursePrint(String ylwsid);

	/**
	 * @Title: saveOptNurseTemplate 
	 * @Description: 保存模板
	 * @author 白东旭
	 * @date 2016-4-5 上午11:04:14
	 * @param @param nurse
	 * @param @param anaes
	 * @param @param templateType
	 * @param @param templateName
	 * @param @param userid
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void saveOptNurseTemplate(SmOptNurse nurse, List<SmNurseAnaes> anaes,
			String templateType, String templateName, String userid);

	/**
	 * @Title: getSmWritTemplatePersonal 
	 * @Description: 获取个人模板
	 * @author 白东旭
	 * @date 2016-4-5 上午11:08:14
	 * @param @param userid
	 * @param @return
	 * @return List<SmWritTemplate>
	 * @throws 
	 *
	 */ 
	
	List<SmWritTemplate> getSmWritTemplatePersonal(String userid);

	/**
	 * @Title: getSmWritTemplatePublic 
	 * @Description: 获取公共模板
	 * @author 白东旭
	 * @date 2016-4-5 上午11:08:17
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
	 * @date 2016-4-5 上午11:10:52
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
	 * @date 2016-4-5 上午11:12:13
	 * @param @param templateId
	 * @param @return
	 * @return List<Map<String,String>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getTemplateVal(String templateId);

}
