package com.znyy.sm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmOperdef;
import com.znyy.sm.dao.OperdefDao;


@SuppressWarnings("unchecked")
public class OperdefDaoImpl extends GenericDaoImpl<SmOperdef, String> implements
OperdefDao {

	
	 /** 
	 * @方法名称: getSsList
	 * @功能描述:获取手术名称列表信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 上午10:21:36
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.OperdefDao#getSsList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getSsList(String name, String yx, String pinyin, String code,int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page sss = new Page();
		if (name != null && !name.equals("")&&yx != null && !yx.equals("")&&code != null && !code.equals("")&&pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_operdef where name like :name and enable = :yx  and code like :code and pinyin like:pinyin order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx",yx.trim());
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		} else if (name != null && !name.equals("")&&yx != null && !yx.equals("")&&
				code != null && !code.equals("")) {
			String sql = " select * from sm_operdef where name like :name and enable = :yx  and code like :code order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx",yx.trim());
			paramMap.put("code", "%" + code.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		}  else if (name != null && !name.equals("") &&code != null && !code.equals("")&&pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_operdef where name like :name and code like :code and pinyin like:pinyin order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		} else if (name != null && !name.equals("")&&yx != null && !yx.equals("") &&pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_operdef where name like :name and enable = :yx  and pinyin like:pinyin order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx",yx.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		}else if (yx != null && !yx.equals("")&&code != null && !code.equals("")&&pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_operdef where enable = :yx  and code like :code and pinyin like:pinyin order by code  ";
			paramMap.put("yx",yx.trim());
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		}else if (name != null && !name.equals("")&&yx != null && !yx.equals("")&&code != null && !code.equals("")&&pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_operdef where name like :name and enable = :yx  and code like :code and pinyin like:pinyin order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx",yx.trim());
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		}else if (name != null && !name.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_operdef where name like :name and enable = :yx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx",yx.trim());
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")) {
			String sql = " select * from sm_operdef where name like :name code like :code order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		}else if (name != null && !name.equals("") &&pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_operdef where name like :name and pinyin like:pinyin order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		}else if ( yx != null && !yx.equals("")&&code != null && !code.equals("")) {
			String sql = " select * from sm_operdef where enable = :yx  and code like :code order by code  ";
			paramMap.put("yx",yx.trim());
			paramMap.put("code", "%" + code.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		}else if (yx != null && !yx.equals("")&&pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_operdef where  enable = :yx and pinyin like:pinyin order by code  ";
			paramMap.put("yx",yx.trim());
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		}else if (code != null && !code.equals("")&&pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_operdef where code like :code and pinyin like:pinyin order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		} else if (name != null && !name.equals("")) {
			String sql = " select * from sm_operdef where name like :name order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		} else if (yx != null && !yx.equals("")) {
			String sql = " select * from sm_operdef where enable = :yx order by code  ";
			paramMap.put("yx",yx.trim());
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		} else if (code != null && !code.equals("")) {
			String sql = " select * from sm_operdef where code like :code order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		}
		else if (pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_operdef where pinyin like:pinyin order by code  ";
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			sss = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperdef.class);
		}else {
			String sql = "select * from sm_operdef order by code";
			sss = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmOperdef.class);
		}
		return sss;
	}

	
	 /** 
	 * @方法名称: getSsById
	 * @功能描述:修改手术名称跳转
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:23:17
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.OperdefDao#getSsById(java.lang.String)
	 */
	 
	@Override
	public SmOperdef getSsById(String id) {String hql = "from SmOperdef where code=?";
	List list = this.getHibernateTemplate().find(hql, id);
	if (!list.isEmpty()) {
		return (SmOperdef) list.get(0);
	} else {
		return null;
	}
  }


	
	 /** 
	 * @方法名称: modSsList
	 * @功能描述:修改手术名称
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:59:09
	 * @param ss
	 * @see com.znyy.sm.dao.OperdefDao#modSsList(com.znyy.bean.SmOperdef)
	 */
	 
	@Override
	public void modSsList(SmOperdef ss) {
		
		this.getHibernateTemplate().merge(ss);
		
	}


	
	 /** 
	 * @方法名称: addSs
	 * @功能描述:添加手术信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午2:49:27
	 * @param so
	 * @see com.znyy.sm.dao.OperdefDao#addSs(com.znyy.bean.SmOperdef)
	 */
	 
	@Override
	public void addSs(SmOperdef so) {

		this.getHibernateTemplate().save(so);
		
	}


	
	 /** 
	 * @方法名称: getSsByName
	 * @功能描述:ajax验证手术名称
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:16:01
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.OperdefDao#getSsByName(java.lang.String)
	 */
	 
	@Override
	public List<SmOperdef> getSsByName(String name) {
		

		String hql = " from SmOperdef where name = ? ";

		List<SmOperdef> list = this.getHibernateTemplate().find(hql, name);
		return list;
	}


	
	 /** 
	 * @方法名称: getSsByCode
	 * @功能描述:ajax验证手术代码
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:47:53
	 * @param code
	 * @return
	 * @see com.znyy.sm.dao.OperdefDao#getSsByCode(java.lang.String)
	 */
	 
	@Override
	public List<SmOperdef> getSsByCode(String code) {
		
		

		String hql = " from SmOperdef where code = ? ";

		List<SmOperdef> list = this.getHibernateTemplate().find(hql, code);
		return list;
	}


	@Override
	public List<SmOperdef> getOps(String enable) {
		String hql=" from SmOperdef where enable=?";
		return this.getHibernateTemplate().find(hql,enable);
	}
}