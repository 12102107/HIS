package com.znyy.sm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmAnaesMethod;
import com.znyy.sm.dao.AnaesMethodDao;
@SuppressWarnings("unchecked")
public class AnaesMethodDaoImpl extends GenericDaoImpl<SmAnaesMethod, String> implements
AnaesMethodDao {

	
	 /** 
	 * @方法名称: getMzffList
	 * @功能描述:获取麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 上午10:41:05
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.AnaesMethodDao#getMzffList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getMzffList(String code,String mname, String cy, String yx, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page mzffs = new Page();
		if (code != null && !code.equals("")&&mname != null && !mname.equals("")&&cy != null && !cy.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_anaes_method where code like :code  and name like :mname and is_usually = :cy and is_valid = :yx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("mname", "%" + mname.trim() + "%");
			paramMap.put("cy",cy.trim());
			paramMap.put("yx",yx.trim());
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (code != null && !code.equals("")&&mname != null && !mname.equals("")&&cy != null && !cy.equals("")) {
			String sql = " select * from sm_anaes_method where code like :code  and name like :mname and is_usually = :cy order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("mname", "%" + mname.trim() + "%");
			paramMap.put("cy",cy.trim());
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (code != null && !code.equals("")&&cy != null && !cy.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_anaes_method where code like :code and is_usually = :cy and is_valid = :yx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("cy",cy.trim());
			paramMap.put("yx",yx.trim());
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (mname != null && !mname.equals("")&&cy != null && !cy.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_anaes_method where name like :mname and is_usually = :cy and is_valid = :yx order by code  ";
			paramMap.put("mname", "%" + mname.trim() + "%");
			paramMap.put("cy",cy.trim());
			paramMap.put("yx",yx.trim());
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (code != null && !code.equals("")&&mname != null && !mname.equals("")) {
			String sql = " select * from sm_anaes_method where code like :code  and name like :mname order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("mname", "%" + mname.trim() + "%");
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (code != null && !code.equals("")&&cy != null && !cy.equals("")) {
			String sql = " select * from sm_anaes_method where code like :code and is_usually = :cy order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("cy",cy.trim());
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_anaes_method where code like :code and is_valid = :yx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx",yx.trim());
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (mname != null && !mname.equals("")&&cy != null && !cy.equals("")) {
			String sql = " select * from sm_anaes_method where name like :mname and is_usually = :cy order by code  ";
			paramMap.put("mname", "%" + mname.trim() + "%");
			paramMap.put("cy",cy.trim());
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (mname != null && !mname.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_anaes_method where name like :mname and is_valid = :yx order by code  ";
			paramMap.put("mname", "%" + mname.trim() + "%");
			paramMap.put("yx",yx.trim());
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (cy != null && !cy.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_anaes_method where is_usually = :cy and is_valid = :yx order by code  ";
			paramMap.put("cy",cy.trim());
			paramMap.put("yx",yx.trim());
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (code != null && !code.equals("")) {
			String sql = " select * from sm_anaes_method where code like :code order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (mname != null && !mname.equals("")) {
			String sql = " select * from sm_anaes_method where name like :mname order by code  ";
			paramMap.put("mname", "%" + mname.trim() + "%");
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (cy != null && !cy.equals("")) {
			String sql = " select * from sm_anaes_method where  is_usually = :cy order by code  ";
			paramMap.put("cy",cy.trim());
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		}else if (yx != null && !yx.equals("")) {
			String sql = " select * from sm_anaes_method where is_valid = :yx order by code  ";
			paramMap.put("yx",yx.trim());
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		} else {
			String sql = "select * from sm_anaes_method order by code";
			mzffs = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmAnaesMethod.class);
		}
		return mzffs;
	}

	

	 
	
	 /** 
	 * @方法名称: getMzffById
	 * @功能描述:修改麻醉方法跳转
	 * @作者:付士山
	 * @创建时间:2015-12-31 上午11:51:48
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.AnaesMethodDao#getMzffById(java.lang.String)
	 */
	 
	@Override
	public SmAnaesMethod getMzffById(String id) {
		String hql = "from SmAnaesMethod where code=?";
		
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmAnaesMethod) list.get(0);
		} else {
			return null;
		}
	}	
	 
	
	 /** 
	 * @方法名称: modMzffList
	 * @功能描述:修改麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午1:39:03
	 * @param sam
	 * @see com.znyy.sm.dao.AnaesMethodDao#modMzffList(com.znyy.bean.SmAnaesMethod)
	 */
	 
	@Override
	public void modMzffList(SmAnaesMethod sam) {
	
		this.getHibernateTemplate().merge(sam);
		
	}
	
	 /** 
	 * @方法名称: addMzff
	 * @功能描述:添加麻醉方法信息
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午2:19:31
	 * @param sa
	 * @see com.znyy.sm.dao.AnaesMethodDao#addMzff(com.znyy.bean.SmAnaesMethod)
	 */
	 
	@Override
	public void addMzff(SmAnaesMethod sa) {
		
		this.getHibernateTemplate().save(sa);
		
	}
	
	 /** 
	 * @方法名称: getMzffByName
	 * @功能描述:ajax验证麻醉方法名称
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午3:24:25
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.AnaesMethodDao#getMzffByName(java.lang.String)
	 */
	 
	@Override
	public List<SmAnaesMethod> getMzffByName(String name) {
	String hql = " from SmAnaesMethod where name = ? ";

		List<SmAnaesMethod> list = this.getHibernateTemplate().find(hql, name);
		return list;
	}
	
	
	 /** 
	 * @方法名称: getMzffByCode
	 * @功能描述:ajax验证麻醉方法代码
	 * @作者:付士山
	 * @创建时间:2015-12-31 下午5:01:47
	 * @param code
	 * @return
	 * @see com.znyy.sm.dao.AnaesMethodDao#getMzffByCode(java.lang.String)
	 */
	 
	@Override
	public List<SmAnaesMethod> getMzffByCode(String code) {
		String hql = " from SmAnaesMethod where code = ? ";

		List<SmAnaesMethod> list = this.getHibernateTemplate().find(hql, code);
		return list;
	}





	
	 /** 
	 * @方法名称: getMzffList2
	 * @功能描述:选择麻醉方法列表
	 * @作者:付士山
	 * @创建时间:2016-1-18 下午3:15:31
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.AnaesMethodDao#getMzffList2(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getMzffList2(String name, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page mzffs = new Page();
		if (name != null && !name.equals("")) {
			String sql = " select * from sm_anaes_method where is_valid=0 and name like :name order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			mzffs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmAnaesMethod.class);
		} else {
			String sql = "select * from sm_anaes_method where is_valid=0 order by code";
			mzffs = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmAnaesMethod.class);
		}
		return mzffs;
	}





	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.AnaesMethodDao#getMzffList2(java.lang.String)
	 */
	@Override
	public List getMzffList2(String name) {
		return this.getHibernateTemplate().find("from SmAnaesMethod where isValid='0'");
	}


}