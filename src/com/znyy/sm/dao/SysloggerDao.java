package com.znyy.sm.dao;
import com.common.util.Page;
import com.znyy.bean.SmSyslogger;


public interface SysloggerDao {

	
	 /**
	 * @方法名称: getSyslogList
	 * @功能描述: 获取系统日志信息
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午9:52:21
	 * @param name
	 * @param jg 
	 * @param qxm 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getSyslogList(String yhid, String qxm, String jg, int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: getSyslogById
	 * @功能描述: 系统日志修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午10:17:58
	 * @param id
	 * @return SmSyslogger   
	 */
	 
	SmSyslogger getSyslogById(Integer id);


	
	 /**
	 * @方法名称: modSyslogList
	 * @功能描述: 系统日志修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午10:43:15
	 * @param slog void   
	 */
	 
	void modSyslogList(SmSyslogger slog);


	
	 /**
	 * @方法名称: addSyslog
	 * @功能描述: 添加系统日志信息
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午11:12:38
	 * @param syslog void   
	 */
	 
	void addSyslog(SmSyslogger syslog);

}
