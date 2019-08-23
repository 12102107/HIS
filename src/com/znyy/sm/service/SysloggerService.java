package com.znyy.sm.service;
import com.common.util.Page;
import com.znyy.bean.SmSyslogger;

public interface SysloggerService {

	
	 /**
	 * @方法名称: getSyslogList
	 * @功能描述: 获取系统日志信息
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午9:51:23
	 * @param yhid
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
	 * @创建时间:2016-1-13 上午10:16:57
	 * @param id
	 * @return SmSyslogger   
	 */
	 
	SmSyslogger getSyslogById(Integer id);


	
	 /**
	 * @方法名称: modSyslogList
	 * @功能描述: 系统日志修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午10:42:32
	 * @param slog void   
	 */
	 
	void modSyslogList(SmSyslogger slog);


	
	 /**
	 * @方法名称: addSyslog
	 * @功能描述: 添加系统日志信息
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午11:12:03
	 * @param syslog void   
	 */
	 
	void addSyslog(SmSyslogger syslog);

}
