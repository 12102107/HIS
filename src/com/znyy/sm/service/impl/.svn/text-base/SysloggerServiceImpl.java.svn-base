package com.znyy.sm.service.impl;

import com.common.util.Page;
import com.znyy.bean.SmSyslogger;
import com.znyy.sm.dao.SysloggerDao;
import com.znyy.sm.service.SysloggerService;


public class SysloggerServiceImpl implements SysloggerService {

	private SysloggerDao sysloggerDao;

	public SysloggerDao getSysloggerDao() {
	
		return sysloggerDao;
	}

	public void setSysloggerDao(SysloggerDao sysloggerDao) {
	
		this.sysloggerDao = sysloggerDao;
	}

	
	 /** 
	 * @方法名称: getSyslogList
	 * @功能描述:获取系统日志信息
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午9:51:40
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.SysloggerService#getSyslogList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getSyslogList(String yhid, String qxm, String jg,  int parmpage, Integer pageSize) {
		
		return sysloggerDao.getSyslogList(yhid,qxm,jg,parmpage,pageSize);
		
	}

	
	 /** 
	 * @方法名称: getSyslogById
	 * @功能描述:系统日志修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午10:17:08
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.SysloggerService#getSyslogById(java.lang.Integer)
	 */
	 
	@Override
	public SmSyslogger getSyslogById(Integer id) {
		
		SmSyslogger syslog=sysloggerDao.getSyslogById(id);
		return syslog;
		
	}

	
	 /** 
	 * @方法名称: modSyslogList
	 * @功能描述:系统日志修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午10:42:47
	 * @param slog
	 * @see com.znyy.sm.service.SysloggerService#modSyslogList(com.znyy.bean.SmSyslogger)
	 */
	 
	@Override
	public void modSyslogList(SmSyslogger slog) {
		
		sysloggerDao.modSyslogList(slog);
		
	}

	
	 /** 
	 * @方法名称: addSyslog
	 * @功能描述:添加系统日志信息
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午11:12:15
	 * @param syslog
	 * @see com.znyy.sm.service.SysloggerService#addSyslog(com.znyy.bean.SmSyslogger)
	 */
	 
	@Override
	public void addSyslog(SmSyslogger syslog) {
		
		sysloggerDao.addSyslog(syslog);
		
	}
	

}
