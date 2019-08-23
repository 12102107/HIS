package com.znyy.sm.service.impl;
import java.util.List;
import com.common.util.Page;
import com.znyy.bean.SmSystemConfig;
import com.znyy.sm.dao.SystemConfigDao;
import com.znyy.sm.service.SystemConfigService;
public class SystemConfigServiceImpl implements SystemConfigService {

	private SystemConfigDao systemConfigDao;

	public SystemConfigDao getSystemConfigDao() {
	
		return systemConfigDao;
	}

	public void setSystemConfigDao(SystemConfigDao systemConfigDao) {
	
		this.systemConfigDao = systemConfigDao;
	}

	
	 /** 
	 * @方法名称: getConfigList
	 * @功能描述:获取系统及参数配置信息
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:46:40
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.SystemConfigService#getConfigList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getConfigList(String code, String xname, String fl, String yx, int parmpage, Integer pageSize) {
		
		return systemConfigDao.getConfigList(code,xname,fl,yx,parmpage,pageSize);
		
	}

	
	 /** 
	 * @方法名称: getConfigById
	 * @功能描述:系统及参数配置修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:56:27
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.SystemConfigService#getConfigById(java.lang.Integer)
	 */
	 
	@Override
	public SmSystemConfig getConfigById(Integer id) {
		
		SmSystemConfig config=systemConfigDao.getConfigById(id);
		return config;
		
	}

	
	 /** 
	 * @方法名称: modConfigList
	 * @功能描述:系统及参数配置修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:56:30
	 * @param con
	 * @see com.znyy.sm.service.SystemConfigService#modConfigList(com.znyy.bean.SmSystemConfig)
	 */
	 
	@Override
	public void modConfigList(SmSystemConfig con) {
		
		systemConfigDao.modConfigList(con);
		
	}

	
	 /** 
	 * @方法名称: addConfig
	 * @功能描述:添加系统及参数配置信息
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午2:20:06
	 * @param config
	 * @see com.znyy.sm.service.SystemConfigService#addConfig(com.znyy.bean.SmSystemConfig)
	 */
	 
	@Override
	public void addConfig(SmSystemConfig config) {
		
		systemConfigDao.addConfig(config);
		
	}

	
	 /** 
	 * @方法名称: getConfigByName
	 * @功能描述:ajax系统及参数配置名称
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午2:47:05
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.SystemConfigService#getConfigByName(java.lang.String)
	 */
	 
	@Override
	public List<SmSystemConfig> getConfigByName(String name) {
		
	
		return systemConfigDao.getConfigByName(name);
		
	}

	
}
