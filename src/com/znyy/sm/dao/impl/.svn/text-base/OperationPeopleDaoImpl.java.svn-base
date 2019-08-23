package com.znyy.sm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.sm.dao.OperationPeopleDao;

@SuppressWarnings("unchecked")
public class OperationPeopleDaoImpl extends GenericDaoImpl<SmOperationPeople, String> implements
OperationPeopleDao {

	
	 /** 
	 * @方法名称: getSpList
	 * @功能描述:获取手术人员列表
	 * @作者:付士山
	 * @创建时间:2015-12-28 上午10:21:36
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.OperationPeopleDao#getSpList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getSpList(String code, String lb, String lx, String yx, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page sps = new Page();
		if (lb != null && !lb.equals("")&&code != null && !code.equals("")&&lx != null && !lx.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_operation_people where name like :lb and code like :code and role=:lx and enable = :yx order by code  ";
			paramMap.put("lb", "%" + lb.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("lx", lx.trim());
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else	if (lb != null && !lb.equals("")&&code != null && !code.equals("")&&lx != null && !lx.equals("")) {
			String sql = " select * from sm_operation_people where name like :lb and code like :code and role=:lx order by code  ";
			paramMap.put("lb", "%" + lb.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("lx", lx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else	if (lb != null && !lb.equals("")&&lx != null && !lx.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_operation_people where name like :lb and role=:lx and enable = :yx order by code  ";
			paramMap.put("lb", "%" + lb.trim() + "%");
			paramMap.put("lx", lx.trim());
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else	if (lb != null && !lb.equals("")&&code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_operation_people where name like :lb and code like :code and enable = :yx order by code  ";
			paramMap.put("lb", "%" + lb.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else	if (code != null && !code.equals("")&&lx != null && !lx.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_operation_people where code like :code and role=:lx and enable = :yx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("lx", lx.trim());
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else	if (lb != null && !lb.equals("")&&code != null && !code.equals("")) {
			String sql = " select * from sm_operation_people where name like :lb and code like :code order by code  ";
			paramMap.put("lb", "%" + lb.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else	if (lb != null && !lb.equals("")&&lx != null && !lx.equals("")) {
			String sql = " select * from sm_operation_people where name like :lb and role=:lx order by code  ";
			paramMap.put("lb", "%" + lb.trim() + "%");
			paramMap.put("lx", lx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else	if (lb != null && !lb.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_operation_people where name like :lb and enable = :yx order by code  ";
			paramMap.put("lb", "%" + lb.trim() + "%");
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else	if (code != null && !code.equals("")&&lx != null && !lx.equals("")) {
			String sql = " select * from sm_operation_people where code like :code and role=:lx and enable = :yx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("lx", lx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else	if (code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_operation_people where code like :code and enable = :yx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else	if (lx != null && !lx.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_operation_people where role=:lx and enable = :yx order by code  ";
			paramMap.put("lx", lx.trim());
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else if (lb != null && !lb.equals("")) {
			String sql = " select * from sm_operation_people where name like :lb order by code  ";
			paramMap.put("lb", "%" + lb.trim() + "%");
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		} else if (code != null && !code.equals("")) {
			String sql = " select * from sm_operation_people where code like :code order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		} else if (lx != null && !lx.equals("")) {
			String sql = " select * from sm_operation_people where role=:lx order by code  ";
			paramMap.put("lx", lx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else if (yx != null && !yx.equals("")) {
			String sql = " select * from sm_operation_people where enable = :yx order by code  ";
			paramMap.put("yx", yx.trim());
			sps = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperationPeople.class);
		}else {
			String sql = "select * from sm_operation_people where 1=1 order by code";
			sps = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmOperationPeople.class);
		}
		return sps;
	}

	
	 /** 
	 * @方法名称: getSpById
	 * @功能描述:修改手术人员跳转
	 * @作者:付士山
	 * @创建时间:2015-12-29 下午2:23:53
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.OperationPeopleDao#getSpById(java.lang.Integer)
	 */
	 
	@Override
	public SmOperationPeople getSpById(Integer id) {String hql = "from SmOperationPeople where code=?";
		
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmOperationPeople) list.get(0);
		} else {
			return null;
		}
	}



	
	 /** 
	 * @方法名称: modSpList
	 * @功能描述:修改手术人员信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:59:09
	 * @param Sp
	 * @see com.znyy.sm.dao.OperationPeopleDao#modSpList(com.znyy.bean.SmOperationPeople)
	 */
	 
	@Override
	public void modSpList(SmOperationPeople sp) {
		
		this.getHibernateTemplate().merge(sp);
		
	}
	
	 /** 
	 * @方法名称: addSp
	 * @功能描述:添加手术人员信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午2:49:27
	 * @param sp
	 * @see com.znyy.sm.dao.OperationPeopleDao#addSp(com.znyy.bean.SmOperationPeople)
	 */
	@Override
		public void addSp(SmOperationPeople sp) {
		
		this.getHibernateTemplate().save(sp);
		
	}

	
	 /** 
	 * @方法名称: getSpByName
	 * @功能描述:ajax验证手术人员名称
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:16:01
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.OperationPeopleDao#getSpByName(java.lang.String)
	 */
	 
	@Override
		public List<SmOperationPeople> getSpByName(String name) {
		

		String hql = " from SmOperationPeople where name = ? ";

		List<SmOperationPeople> list = this.getHibernateTemplate().find(hql, name);
		return list;
	}
	 /** 
	 * @方法名称: getSpByCode
	 * @功能描述:ajax验证手术人员代码
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:47:53
	 * @param code
	 * @return
	 * @see com.znyy.sm.dao.OperationPeopleDao#getSpByCode(java.lang.String)
	 */
	@Override
	public List<SmOperationPeople> getSpByCode(int code) {
		String hql = " from SmOperationPeople where code = ? ";

		List<SmOperationPeople> list = this.getHibernateTemplate().find(hql, code);
		return list;
	}


	@Override
	public List<SmOperationPeople> getSops(String enable,String role) {
		String hql=" from SmOperationPeople where enable=? and role=?";
		return this.getHibernateTemplate().find(hql,new Object[]{enable,role});
		
	}


	
	 /** 
	 * @方法名称: getSopsByZimu
	 * @功能描述:AJAX联动查询手术人员
	 * @作者:付士山
	 * @创建时间:2016-1-18 下午3:14:37
	 * @param zimu
	 * @return
	 * @see com.znyy.sm.dao.OperationPeopleDao#getSopsByZimu(java.lang.String)
	 */
	 
	@Override
	public List<SmOperationPeople> getSopsByZimu(String zimu) {
		
		String hql=" from SmOperationPeople where pinyin like ? and role='手术医师'";
		return this.getHibernateTemplate().find(hql,"%"+zimu+"%");
	}
	@Override
	public List<SmDiagnosedef> getSqzdByZimu(String zimu) {
		
		String hql=" from SmDiagnosedef where pinyin like ? and enable='0'";
		return this.getHibernateTemplate().find(hql,"%"+zimu+"%");
	}
	@Override
	public List<SmOperdef> getNsssByZimu(String zimu) {
		
		String hql=" from SmOperdef where pinyin like ? and enable='0'";
		return this.getHibernateTemplate().find(hql,"%"+zimu+"%");
	}


	
	 /** 
	 * @方法名称: getOpList
	 * @功能描述:查询麻醉医师列表
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:37:10
	 * @param enable
	 * @return
	 * @see com.znyy.sm.dao.OperationPeopleDao#getOpList(java.lang.String)
	 */
	 
	@Override
	public List<SmOperationPeople> getOpList(String enable) {
		
		
		String hql=" from SmOperationPeople where enable=? ";
		return this.getHibernateTemplate().find(hql,enable);
	}


	@Override
	public List<SmOperationPeople> getLxList() {
		
		String hql="select distinct role from SmOperationPeople";
		return this.getHibernateTemplate().find(hql);
		
	}


	@Override
	public List<SmOperationPeople> getAnesthetistersByRole(String yishiRole) {
		String hql=" from SmOperationPeople where role= ? ";
		return this.getHibernateTemplate().find(hql,yishiRole);
	}


	@Override
	public List<SmOperationPeople> getAnesthetistersByPy(String zimu) {
		String hql=" from SmOperationPeople where pinyin like ? and role in ('手术麻醉医师','巡台麻醉医师','灌注医师')";
		return this.getHibernateTemplate().find(hql,"%"+zimu+"%");
	}


	@Override
	public List<SmOperationPeople> AnesthetistersByyishiName(String yishiName) {
		String hql=" from SmOperationPeople where name=? ";
		return this.getHibernateTemplate().find(hql,yishiName);
	}


	@Override
	public List<SmOperationPeople> getAnesthetistersByPy1(String zimu) {
		String hql=" from SmOperationPeople where pinyin like ? and role in ('手术医师')";
		return this.getHibernateTemplate().find(hql,"%"+zimu+"%");
	}


	@Override
	public List<SmOperationPeople> getAnesthetistersByPy2(String zimu) {
		String hql=" from SmOperationPeople where pinyin like ? and role in ('器械护士','巡回护士')";
		return this.getHibernateTemplate().find(hql,"%"+zimu+"%");
	}


}