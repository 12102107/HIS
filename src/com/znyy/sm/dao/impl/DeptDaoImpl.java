package com.znyy.sm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmDept;
import com.znyy.bean.XtUnit;
import com.znyy.sm.dao.DeptDao;

@SuppressWarnings("unchecked")
public class DeptDaoImpl extends GenericDaoImpl<SmDept, String> implements
		DeptDao {

	/**
	 * @方法名称: getDeptList
	 * @功能描述:获取科室信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午9:45:28
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.DeptDao#getDeptList(java.lang.String, int,
	 *      java.lang.Integer)
	 */

	@Override
	public Page getDeptList(String name, String yx, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page depts = new Page();
		if (name != null && !name.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_dept where name like :name and enable = :yx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim() );
			depts = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDept.class);
		}else if (name != null && !name.equals("")) {
			String sql = " select * from sm_dept where name like :name order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			depts = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDept.class);
		}else if (yx != null && !yx.equals("")) {
			String sql = " select * from sm_dept where enable = :yx order by id  ";
			paramMap.put("yx", yx.trim() );
			depts = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDept.class);
		}else {
			String sql = "select * from sm_dept order by id";
			depts = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmDept.class);
		}
		return depts;

	}

	/**
	 * @方法名称: addDept
	 * @功能描述:添加科室信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:47:15
	 * @param dept
	 * @see com.znyy.sm.dao.DeptDao#addDept(com.znyy.bean.SmDept)
	 */

	@Override
	public void addDept(SmDept dept) {

		this.getHibernateTemplate().save(dept);

	}

	
	 /** 
	 * @方法名称: getDeptByName
	 * @功能描述:ajax验证科室名称
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:55:13
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.DeptDao#getDeptByName(java.lang.String)
	 */
	 
	@Override
	public List<SmDept> getDeptByName(String name) {

		String hql = " from SmDept where name = ? ";

		List<SmDept> list = this.getHibernateTemplate().find(hql, name);
		return list;

	}

	
	 /** 
	 * @方法名称: getDeptById
	 * @功能描述:科室修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:00:01
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.DeptDao#getDeptById(java.lang.Integer)
	 */
	 
	@Override
	public SmDept getDeptById(Integer id) {
		String hql = "from SmDept where id=?";
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmDept) list.get(0);
		} else {
			return null;
		}
	}

	
	 /** 
	 * @方法名称: modDeptList
	 * @功能描述:科室修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:07:14
	 * @param sdt
	 * @see com.znyy.sm.dao.DeptDao#modDeptList(com.znyy.bean.SmDept)
	 */
	 
	@Override
	public void modDeptList(SmDept sdt) {
		
		this.getHibernateTemplate().merge(sdt);
	}

	@Override
	public List<XtUnit> getDepts(String hospitalId) {
		String hql=" from XtUnit where flag=0 and type='0' and ywflag='1' and hospitalId = ?";
		return this.getHibernateTemplate().find(hql,Long.parseLong(hospitalId));
	}

}
