package com.znyy.sm.service;
import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmSystemConfig;
public interface SystemConfigService {

	
	 /**
	 * @方法名称: getConfigList
	 * @功能描述: 获取系统及参数配置信息
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:46:26
	 * @param name
	 * @param yx 
	 * @param fl 
	 * @param xname 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getConfigList(String code, String xname, String fl, String yx, int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: getConfigById
	 * @功能描述: 系统及参数配置修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:56:01
	 * @param id
	 * @return SmSystemConfig   
	 */
	 
	SmSystemConfig getConfigById(Integer id);


	
	 /**
	 * @方法名称: modConfigList
	 * @功能描述: 系统及参数配置修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:56:15
	 * @param con void   
	 */
	 
	void modConfigList(SmSystemConfig con);


	
	 /**
	 * @方法名称: addConfig
	 * @功能描述: 添加系统及参数配置信息
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午2:19:55
	 * @param config void   
	 */
	 
	void addConfig(SmSystemConfig config);


	
	 /**
	 * @方法名称: getConfigByName
	 * @功能描述: ajax系统及参数配置名称
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午2:46:32
	 * @param name
	 * @return List<SmSystemConfig>   
	 */
	 
	List<SmSystemConfig> getConfigByName(String name);

	
}
