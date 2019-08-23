package com.znyy.sm.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmSyslogger;
import com.znyy.sm.dao.SysloggerDao;

@SuppressWarnings("unchecked")
public class SysloggerDaoImpl extends GenericDaoImpl<SmSyslogger, String> implements
SysloggerDao {

	
	 /** 
	 * @方法名称: getSyslogList
	 * @功能描述:获取系统日志信息
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午9:52:36
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.SysloggerDao#getSyslogList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getSyslogList(String yhid, String qxm, String jg,  int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page logs = new Page();
		if (yhid != null && !yhid.equals("")&&qxm != null && !qxm.equals("")&&jg != null && !jg.equals("")) {
			String sql = " select * from sm_syslogger where userid like :yhid  and permissionkey like :qxm and  result like :jg order by id  ";
			paramMap.put("yhid", "%" + yhid.trim() + "%");
			paramMap.put("qxm", "%" + qxm.trim() + "%");
			paramMap.put("jg", "%" + jg.trim() + "%");
			logs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmSyslogger.class);
		}else if (yhid != null && !yhid.equals("")&&qxm != null && !qxm.equals("")) {
			String sql = " select * from sm_syslogger where userid like :yhid  and permissionkey like :qxm order by id  ";
			paramMap.put("yhid", "%" + yhid.trim() + "%");
			paramMap.put("qxm", "%" + qxm.trim() + "%");
			logs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmSyslogger.class);
		}else if (yhid != null && !yhid.equals("")&&jg != null && !jg.equals("")) {
			String sql = " select * from sm_syslogger where userid like :yhid and  result like :jg order by id  ";
			paramMap.put("yhid", "%" + yhid.trim() + "%");
			paramMap.put("jg", "%" + jg.trim() + "%");
			logs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmSyslogger.class);
		}else if (qxm != null && !qxm.equals("")&&jg != null && !jg.equals("")) {
			String sql = " select * from sm_syslogger where permissionkey like :qxm and  result like :jg order by id  ";
			paramMap.put("qxm", "%" + qxm.trim() + "%");
			paramMap.put("jg", "%" + jg.trim() + "%");
			logs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmSyslogger.class);
		}else if (yhid != null && !yhid.equals("")) {
			String sql = " select * from sm_syslogger where userid like :yhid order by id  ";
			paramMap.put("yhid", "%" + yhid.trim() + "%");
			logs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmSyslogger.class);
		}else if (qxm != null && !qxm.equals("")) {
			String sql = " select * from sm_syslogger where permissionkey like :qxm order by id  ";
			paramMap.put("qxm", "%" + qxm.trim() + "%");
			logs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmSyslogger.class);
		}else if (jg != null && !jg.equals("")) {
			String sql = " select * from sm_syslogger where result like :jg order by id  ";
			paramMap.put("jg", "%" + jg.trim() + "%");
			logs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmSyslogger.class);
		}else {
			String sql = "select * from sm_syslogger  order by id";
			logs = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmSyslogger.class);
		}
		return logs;
	}

	
	 /** 
	 * @方法名称: getSyslogById
	 * @功能描述:系统日志修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午10:18:13
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.SysloggerDao#getSyslogById(java.lang.Integer)
	 */
	 
	@Override
	public SmSyslogger getSyslogById(Integer id) {
		String hql = "from SmSyslogger where id=?";
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmSyslogger) list.get(0);
		} else {
			return null;
	}
	}


	
	 /** 
	 * @方法名称: modSyslogList
	 * @功能描述:系统日志修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午10:43:34
	 * @param slog
	 * @see com.znyy.sm.dao.SysloggerDao#modSyslogList(com.znyy.bean.SmSyslogger)
	 */
	 
	@Override
	public void modSyslogList(SmSyslogger slog) {
		
		this.getHibernateTemplate().merge(slog);
		
	}


	
	 /** 
	 * @方法名称: addSyslog
	 * @功能描述:添加系统日志信息
	 * @作者:付士山
	 * @创建时间:2016-1-13 上午11:13:01
	 * @param syslog
	 * @see com.znyy.sm.dao.SysloggerDao#addSyslog(com.znyy.bean.SmSyslogger)
	 */
	 
	@Override
	public void addSyslog(SmSyslogger syslog) {
		
		this.getHibernateTemplate().save(syslog);
		
	}
}
