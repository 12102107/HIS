package com.znyy.sm.dao;

import java.util.List;
import java.util.Map;

import com.common.util.Page;
import com.znyy.bean.Accede;
import com.znyy.bean.SmAnaesPlanDocument;
import com.znyy.bean.SmAnaesWatch;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;

public interface YlwsDao {

	public Page getYlwsList(int parmpage, Integer pageSize, String hospitalId);

	
	 /**
	 * @方法名称: getYlwsList
	 * @功能描述: 医疗文书跳转到麻醉同意书
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:36:16
	 * @param ylwsid
	 * @return List<SmRegOpt>   
	 */
	 
	public List<SmRegOpt> getYlwsList(String ylwsid);

	
	 /**
	 * @方法名称: getMztysById
	 * @功能描述: 根据医疗文书id查询麻醉同意书
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:34:14
	 * @param ylwsid
	 * @return Accede   
	 */
	 
	public Accede getMztysById(String ylwsid);

	
	 /**
	 * @方法名称: modMztysList
	 * @功能描述: 同意书修改
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:35:07
	 * @param mztys void   
	 */
	 
	public void modMztysList(Accede mztys);


	
	 /**
	 * @方法名称: addMztys
	 * @功能描述: 同意书添加
	 * @作者:付士山
	 * @创建时间:2016-2-25 上午9:15:44
	 * @param tys void   
	 */
	 
	public void addMztys(Accede tys);


	public List<Map<String, Object>> getMzPrint(String ylwsid);


	
	 /**
	 * @方法名称: getMzjhById
	 * @功能描述: 根据医疗文书id查询麻醉计划
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午10:18:19
	 * @param ylwsid
	 * @return SmAnaesPlanDocument   
	 */
	 
	public SmAnaesPlanDocument getMzjhById(String ylwsid);


	
	 /**
	 * @方法名称: modMzjhList
	 * @功能描述: 麻醉计划修改
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午11:05:03
	 * @param mzjhs void   
	 */
	 
	public void modMzjhList(SmAnaesPlanDocument mzjhs);


	
	 /**
	 * @方法名称: addMzjh
	 * @功能描述: 麻醉计划添加
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午11:07:03
	 * @param mzjh void   
	 */
	 
	public void addMzjh(SmAnaesPlanDocument mzjh);


	public List<Map<String, Object>> getMzPrintMzjh(String ylwsid);


	
	 /**
	 * @方法名称: getShsfById
	 * @功能描述: 根据医疗文书id查询术后随访
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:24:44
	 * @param ylwsid
	 * @return SmAnaesWatch   
	 */
	 
	public SmAnaesWatch getShsfById(String ylwsid);


	
	 /**
	 * @方法名称: modShfsList
	 * @功能描述: 术后随访修改
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:46:57
	 * @param shsfs void   
	 */
	 
	public void modShfsList(SmAnaesWatch shsfs);


	
	 /**
	 * @方法名称: addShfs
	 * @功能描述: 术后随访添加
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:49:05
	 * @param shsf void   
	 */
	 
	public void addShfs(SmAnaesWatch shsf);


	public List<Map<String, Object>> getPrintSf(String ylwsid);

	/**
	 * @Title: getSmRegOpt 
	 * @Description: 获取文书
	 * @author 白东旭
	 * @date 2016-3-11 上午11:05:08
	 * @param @param id
	 * @param @return
	 * @return SmRegOpt
	 * @throws 
	 *
	 */ 
	
	public SmRegOpt getSmRegOpt(String id);


	/**
	 * @Title: saveSmRegOpt 
	 * @Description: 更新或保存文书
	 * @author 白东旭
	 * @date 2016-3-11 上午11:06:12
	 * @param @param sro
	 * @return void
	 * @throws 
	 *
	 */ 
	
	public void saveSmRegOpt(SmRegOpt sro);


	/**
	 * @Description: 保存模板
	 * @param @param wt   
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public void saveSmWritTemplate(SmWritTemplate wt);


	/**
	 * @Description: TODO
	 * @param @param userid
	 * @param @return   
	 * @return List<SmWritTemplate>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public List<SmWritTemplate> getSmWritTemplatePersonal(String userid);


	/**
	 * @Description: TODO
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
	 * @Description: 获取模板值
	 * @param @param templateId
	 * @param @return   
	 * @return SmAnaesWatch  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-4-8
	 */
	public SmAnaesWatch getTemplateVal(String templateId);

}
