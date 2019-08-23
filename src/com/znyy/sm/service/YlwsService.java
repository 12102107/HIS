package com.znyy.sm.service;

import java.util.List;
import java.util.Map;

import com.common.util.Page;
import com.znyy.bean.Accede;
import com.znyy.bean.SmAnaesPlanDocument;
import com.znyy.bean.SmAnaesWatch;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;


 /** 
 * @类名称: YlwsService
 * @类描述:
 * @作者:付士山
 * @创建时间:2016-3-10 上午10:48:02
 */
 
public interface YlwsService {

	public Page getYlwsList(int parmpage, Integer pageSize, String hospitalId);

	
	 /**
	 * @方法名称: getMztysList
	 * @功能描述: 医疗文书跳转到麻醉同意书
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:36:04
	 * @param ylwsid
	 * @return List<SmRegOpt>   
	 */
	 
	public List<SmRegOpt> getMztysList(String ylwsid);

	
	 /**
	 * @方法名称: getMztysById
	 * @功能描述: 根据医疗文书id查询麻醉同意书
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:33:49
	 * @param ylwsid
	 * @return Accede   
	 */
	 
	public Accede getMztysById(String ylwsid);

	
	 /**
	 * @方法名称: modMztysList
	 * @功能描述: 同意书修改
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:34:43
	 * @param mztys void   
	 */
	 
	public void modMztysList(Accede mztys);


	
	 /**
	 * @方法名称: addMztys
	 * @功能描述: 同意书添加
	 * @作者:付士山
	 * @创建时间:2016-2-25 上午9:15:03
	 * @param tys void   
	 */
	 
	public void addMztys(Accede tys);


	public List<Map<String, Object>> getMzPrint(String ylwsid);


	
	 /**
	 * @方法名称: getMzjhById
	 * @功能描述: 根据医疗文书id查询麻醉计划
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午10:16:34
	 * @param ylwsid
	 * @return SmAnaesPlanDocument   
	 */
	 
	public SmAnaesPlanDocument getMzjhById(String ylwsid);


	
	 /**
	 * @方法名称: modMzjhList
	 * @功能描述: 麻醉计划修改
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午11:04:01
	 * @param mzjhs void   
	 */
	 
	public void modMzjhList(SmAnaesPlanDocument mzjhs);


	
	 /**
	 * @方法名称: addMzjh
	 * @功能描述: 麻醉计划添加
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午11:06:19
	 * @param mzjh void   
	 */
	 
	public void addMzjh(SmAnaesPlanDocument mzjh);


	public List<Map<String, Object>> getMzPrintMzjh(String id);


	
	 /**
	 * @方法名称: getShsfById
	 * @功能描述: 根据医疗文书id查询术后随访
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:23:19
	 * @param ylwsid
	 * @return SmAnaesWatch   
	 */
	 
	public SmAnaesWatch getShsfById(String ylwsid);


	
	 /**
	 * @方法名称: modShfsList
	 * @功能描述: 术后随访修改
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:46:08
	 * @param shsfs void   
	 */
	 
	public void modShfsList(SmAnaesWatch shsfs);


	 
	 /**
	 * @方法名称: addShfs
	 * @功能描述: 术后随访添加
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:48:05
	 * @param shsf void   
	 */
	 
	void addShfs(SmAnaesWatch shsf);


	public List<Map<String, Object>> getPrintSf(String ylwsid);


	/**
	 * @Title: modArchived 
	 * @Description: 医疗文书归档
	 * @author 白东旭
	 * @date 2016-3-11 上午11:03:22
	 * @param @param id
	 * @return void
	 * @throws 
	 *
	 */ 
	
	public void modArchived(String id);
	
	/**
	 * @Title: getSmWirtstateVal 
	 * @Description: 获取文书状态
	 * @author 白东旭
	 * @date 2016-3-14 上午10:59:03
	 * @param @param id
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */ 
	
	public String getSmWirtstateVal(String id);


	/**
	 * @Description: 保存术后随访模板
	 * @param @param shsf
	 * @param @param templateType
	 * @param @param templateName
	 * @param @param userid   
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public void saveShsfTemplate(SmAnaesWatch shsf, String templateType,
			String templateName, String userid);


	/**
	 * @Description: 获取个人模板
	 * @param @param userid
	 * @param @return   
	 * @return List<SmWritTemplate>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public List<SmWritTemplate> getSmWritTemplatePersonal(String userid);


	/**
	 * @Description: 获取公共模板
	 * @param @return   
	 * @return List<SmWritTemplate>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public List<SmWritTemplate> getSmWritTemplatePublic();


	/**
	 * @Description: 删除模板
	 * @param @param templateId   
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public void delTemplate(String templateId);


	/**
	 * @Description: 获取模板内容
	 * @param @param templateId
	 * @param @return   
	 * @return SmAnaesWatch 
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public SmAnaesWatch getTemplateVal(String templateId);
}
