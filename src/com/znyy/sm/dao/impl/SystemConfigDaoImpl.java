package com.znyy.sm.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmSystemConfig;
import com.znyy.sm.dao.SystemConfigDao;

@SuppressWarnings("unchecked")
public class SystemConfigDaoImpl extends GenericDaoImpl<SmSystemConfig, String> implements
SystemConfigDao {

	
	 /** 
	 * @方法名称: getConfigList
	 * @功能描述:获取系统及参数配置信息
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:47:40
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.SystemConfigDao#getConfigList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getConfigList(String code, String xname, String fl, String yx,  int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page sps = new Page();
		if (xname != null && !xname.equals("")&&code != null && !code.equals("")&&fl != null && !fl.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_system_config where name like :xname and code like :code and category like :fl and enable = :yx order by id  ";
			paramMap.put("xname", "%" + xname.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage, pageSize, SmSystemConfig.class);
		}else if (xname != null && !xname.equals("")&&code != null && !code.equals("")&&fl != null && !fl.equals("")) {
			String sql = " select * from sm_system_config where name like :xname and code like :code and category like :fl order by id  ";
			paramMap.put("xname", "%" + xname.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage, pageSize, SmSystemConfig.class);
		}else if (xname != null && !xname.equals("")&&fl != null && !fl.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_system_config where name like :xname and code like :code and category like :fl and enable = :yx order by id  ";
			paramMap.put("xname", "%" + xname.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage, pageSize, SmSystemConfig.class);
		}else if (xname != null && !xname.equals("")&&code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_system_config where name like :xname and code like :code and enable = :yx order by id  ";
			paramMap.put("xname", "%" + xname.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage, pageSize, SmSystemConfig.class);
		}else if (code != null && !code.equals("")&&fl != null && !fl.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_system_config where code like :code and category like :fl and enable = :yx order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage, pageSize, SmSystemConfig.class);
		}else if (xname != null && !xname.equals("")&&code != null && !code.equals("")&&fl != null && !fl.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_system_config where name like :xname and code like :code order by id  ";
			paramMap.put("xname", "%" + xname.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage, pageSize, SmSystemConfig.class);
		}else if (xname != null && !xname.equals("")&&fl != null && !fl.equals("")) {
			String sql = " select * from sm_system_config where name like :xname and  category like :fl  order by id  ";
			paramMap.put("xname", "%" + xname.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage, pageSize, SmSystemConfig.class);
		}else if (xname != null && !xname.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_system_config where name like :xname and enable = :yx order by id  ";
			paramMap.put("xname", "%" + xname.trim() + "%");
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage, pageSize, SmSystemConfig.class);
		}else if (code != null && !code.equals("")&&fl != null && !fl.equals("")) {
			String sql = " select * from sm_system_config where code like :code and category like :fl  order by id  ";
		
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");

			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage, pageSize, SmSystemConfig.class);
		}else if (code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_system_config where  code like :code  and enable = :yx order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage, pageSize, SmSystemConfig.class);
		}else if (fl != null && !fl.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_system_config where  category like :fl and enable = :yx order by id  ";
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage, pageSize, SmSystemConfig.class);
		}else if (xname != null && !xname.equals("")) {
			String sql = " select * from sm_system_config where name like :xname order by id  ";
			paramMap.put("xname", "%" + xname.trim() + "%");
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmSystemConfig.class);
		} else if (code != null && !code.equals("")) {
			String sql = " select * from sm_system_config where code like :code order by id  ";
			paramMap.put("code", "%" + code.trim() + "%");
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmSystemConfig.class);
		} else if (fl != null && !fl.equals("")) {
			String sql = " select * from sm_system_config where category like :fl order by id  ";
			paramMap.put("fl", "%" + fl.trim() + "%");
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmSystemConfig.class);
		}else if (yx != null && !yx.equals("")) {
			String sql = " select * from sm_system_config where enable = :yx order by id  ";
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmSystemConfig.class);
		}else{
			String sql = "select * from sm_system_config where 1=1 order by id";
			sps = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmSystemConfig.class);
		}
		return sps;
	}

	
	 /** 
	 * @方法名称: getConfigById
	 * @功能描述:系统及参数配置修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:58:11
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.SystemConfigDao#getConfigById(java.lang.Integer)
	 */
	 
	@Override
	public SmSystemConfig getConfigById(Integer id) {
		String hql = "from SmSystemConfig where id=?";
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmSystemConfig) list.get(0);
		} else {
			return null;
	}
	}
	
	 /** 
	 * @方法名称: modConfigList
	 * @功能描述:系统及参数配置修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午1:58:14
	 * @param con
	 * @see com.znyy.sm.dao.SystemConfigDao#modConfigList(com.znyy.bean.SmSystemConfig)
	 */
	 
	@Override
	public void modConfigList(SmSystemConfig con) {
		
		this.getHibernateTemplate().merge(con);
		
	}


	
	 /** 
	 * @方法名称: addConfig
	 * @功能描述:添加系统及参数配置信息
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午2:20:38
	 * @param config
	 * @see com.znyy.sm.dao.SystemConfigDao#addConfig(com.znyy.bean.SmSystemConfig)
	 */
	 
	@Override
	public void addConfig(SmSystemConfig config) {
		
		this.getHibernateTemplate().save(config);
		
	}


	
	 /** 
	 * @方法名称: getConfigByName
	 * @功能描述:ajax系统及参数配置名称
	 * @作者:付士山
	 * @创建时间:2016-1-12 下午2:48:21
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.SystemConfigDao#getConfigByName(java.lang.String)
	 */
	 
	@Override
	public List<SmSystemConfig> getConfigByName(String name) {
		String hql = " from SmSystemConfig where name = ? ";

		List<SmSystemConfig> list = this.getHibernateTemplate().find(hql, name);
		return list;
	}

}
