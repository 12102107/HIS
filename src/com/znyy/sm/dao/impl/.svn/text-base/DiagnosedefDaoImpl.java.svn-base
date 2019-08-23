package com.znyy.sm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SysIcdCode;
import com.znyy.sm.dao.DiagnosedefDao;

@SuppressWarnings("unchecked")
public class DiagnosedefDaoImpl extends GenericDaoImpl<SmDiagnosedef, String> implements
		DiagnosedefDao {
	/**
	 * 
	 * @方法名称: getZdList
	 * @功能描述:获取诊断信息列表
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:34:43
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.DiagnosedefDao#getZdList(java.lang.String, int,
	 *      java.lang.Integer)
	 */
	@Override
	public Page getZdList(String name, String yx, String pinyin,  int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page zds = new Page();
		if (name != null && !name.equals("") && yx != null && !yx.equals("") && pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_diagnosedef where name like :name and enable=:yx  and pinyin like :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx",  yx.trim() );
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			zds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDiagnosedef.class);
		}else if (name != null && !name.equals("") && yx != null && !yx.equals("") ) {
			String sql = " select * from sm_diagnosedef where name like :name and enable=:yx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx",  yx.trim() );
			zds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDiagnosedef.class);
		}else if (name != null && !name.equals("")   && pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_diagnosedef where name like :name   and pinyin like :pinyin order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			zds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDiagnosedef.class);
		}else if (  yx != null && !yx.equals("") && pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_diagnosedef where  enable=:yx  and pinyin like :pinyin order by id  ";
			paramMap.put("yx",  yx.trim()  );
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			zds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDiagnosedef.class);
		}else if (name != null && !name.equals("")) {
			String sql = " select * from sm_diagnosedef where name like :name order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			zds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDiagnosedef.class);
		} else if (yx != null && !yx.equals("")) {
			String sql = " select * from sm_diagnosedef where enable=:yx order by id  ";
			paramMap.put("yx",  yx.trim() );
			zds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDiagnosedef.class);
		}else if (pinyin != null && !pinyin.equals("")) {
			String sql = " select * from sm_diagnosedef where pinyin like :pinyin order by id  ";
			paramMap.put("pinyin", "%" + pinyin.trim() + "%");
			zds = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDiagnosedef.class);
		}else {
			String sql = "select * from sm_diagnosedef order by id";
			zds = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmDiagnosedef.class);
		}
		return zds;
	}

	/**
	 * 
	 * @方法名称: getZdById
	 * @功能描述:根据id获取一条诊断信息
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:34:48
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.DiagnosedefDao#getZdById(java.lang.Integer)
	 */
	@Override
	public SmDiagnosedef getZdById(Integer id) {

		String hql = "from SmDiagnosedef where id=?";
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmDiagnosedef) list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @方法名称: modZdList
	 * @功能描述:修改诊断列表信息
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:34:54
	 * @param sm
	 * @see com.znyy.sm.dao.DiagnosedefDao#modZdList(com.znyy.bean.SmDiagnosedef)
	 */
	@Override
	public void modZdList(SmDiagnosedef sm) {

		this.getHibernateTemplate().merge(sm);

	}

	/**
	 * 
	 * @方法名称: addZd
	 * @功能描述:添加诊断列表信息
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:34:59
	 * @param zdd
	 * @see com.znyy.sm.dao.DiagnosedefDao#addZd(com.znyy.bean.SmDiagnosedef)
	 */
	@Override
	public void addZd(SmDiagnosedef zdd) {

		this.getHibernateTemplate().save(zdd);

	}

	/**
	 * @方法名称: getZdByName
	 * @功能描述:ajax验证诊断名称
	 * @作者:付士山
	 * @创建时间:2015-12-25 上午10:38:12
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.DiagnosedefDao#getZdByName(java.lang.String)
	 */

	@Override
	public List<SmDiagnosedef> getZdByName(String name) {

		String hql = " from SmDiagnosedef where name = ? ";

		List<SmDiagnosedef> list = this.getHibernateTemplate().find(hql, name);
		return list;
	}

	@Override
	public List<SmDiagnosedef> getZds(String enable) {
		String hql=" from SmDiagnosedef where enable=?";
		return this.getHibernateTemplate().find(hql,enable);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.DiagnosedefDao#getSysIcdCodeList()
	 */
	@Override
	public List<SysIcdCode> getSysIcdCodeList() {
		String hql=" from SysIcdCode where startFlag='0'";
		return this.getHibernateTemplate().find(hql);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.DiagnosedefDao#querySqzdName(java.lang.String)
	 */
	@Override
	public List<SysIcdCode> querySqzdName(String zimu) {
		StringBuffer hql = new StringBuffer("from SysIcdCode where startFlag='0'");
		if(zimu!=null&&!"".equals(zimu.trim())) {
			hql.append(" and(diseasename like ? or pycode like ?)");
			return this.getHibernateTemplate().find(hql.toString(), new Object[]{"%"+zimu.trim()+"%","%"+zimu.trim().toUpperCase()+"%"});
		}
		return this.getHibernateTemplate().find(hql.toString()); 
	}
}
