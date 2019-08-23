package com.znyy.sm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmMedicalTakeWay;
import com.znyy.sm.dao.MedicalTakeWayDao;

@SuppressWarnings("unchecked")
public class MedicalTakeWayDaoImpl extends
		GenericDaoImpl<SmMedicalTakeWay, String> implements MedicalTakeWayDao {

	/**
	 * @方法名称: getWayList
	 * @功能描述:获取给药途径信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:21:51
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.MedicalTakeWayDao#getWayList(java.lang.String, int,
	 *      java.lang.Integer)
	 */

	@Override
	public Page getWayList(String name, String code, String way, String fl,
			String cx, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page ways = new Page();
		if (name != null && !name.equals("") && code != null
				&& !code.equals("") && way != null && !way.equals("")
				&& fl != null && !fl.equals("") && cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where name like :name and code like :code "
					+ "and  measure_mode like :way and category like :fl and durable = :cx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (name != null && !name.equals("") && code != null
				&& !code.equals("") && way != null && !way.equals("")
				&& fl != null && !fl.equals("")) {
			String sql = " select * from sm_medical_take_way where name like :name and code like :code "
					+ "and  measure_mode like :way and category like :fl order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (code != null && !code.equals("") && way != null
				&& !way.equals("") && fl != null && !fl.equals("")
				&& cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where code like :code "
					+ "and  measure_mode like :way and category like :fl and  durable = :cx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (name != null && !name.equals("") && way != null
				&& !way.equals("") && fl != null && !fl.equals("")
				&& cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where name like :name  "
					+ "and  measure_mode like :way and category like :fl and  durable = :cx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);

		} else if (name != null && !name.equals("") && code != null
				&& !code.equals("") && fl != null && !fl.equals("")
				&& cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where name like :name and code like :code "
					+ " and category like :fl and  durable = :cx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (name != null && !name.equals("") && code != null
				&& !code.equals("") && way != null && !way.equals("")
				&& cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where name like :name and code like :code "
					+ "and  measure_mode like :way and  durable = :cx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if (name != null && !name.equals("") && code != null
				&& !code.equals("") && way != null && !way.equals("")
				) {
			String sql = " select * from sm_medical_take_way where name like :name and code like :code "
					+ "and  measure_mode like :way order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if (name != null && !name.equals("") && code != null
				&& !code.equals("")  
				&& fl != null && !fl.equals("") ) {
			String sql = " select * from sm_medical_take_way where name like :name and code like :code "
					+ "and  category like :fl  order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if (name != null && !name.equals("")  && way != null && !way.equals("")
				&& fl != null && !fl.equals("")  ) {
			String sql = " select * from sm_medical_take_way where name like :name  "
					+ "and  measure_mode like :way and category like :fl order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if ( code != null
				&& !code.equals("") && way != null && !way.equals("")
				&& fl != null && !fl.equals("") ) {
			String sql = " select * from sm_medical_take_way where code like :code "
					+ "and  measure_mode like :way and category like :fl order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if (name != null && !name.equals("") && code != null
				&& !code.equals("")  && cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where name like :name and code like :code "
					+ " and durable = :cx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (name != null && !name.equals("") && way != null && !way.equals("")
			 && cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where name like :name  "
					+ "and  measure_mode like :way and durable = :cx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if (code != null
				&& !code.equals("") && way != null && !way.equals("")
				&& cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where code like :code "
					+ "and  measure_mode like :way and durable = :cx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (name != null && !name.equals("")
				&& fl != null && !fl.equals("") && cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where name like :name and category like :fl and durable = :cx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (code != null
				&& !code.equals("") 
				&& fl != null && !fl.equals("") && cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where code like :code "
					+ " and category like :fl and durable = :cx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if (name != null && !name.equals("") && code != null
				&& !code.equals("") && way != null && !way.equals("")
				&& fl != null && !fl.equals("") && cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where  "
					+ " measure_mode like :way and category like :fl and durable = :cx order by code  ";
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if (name != null && !name.equals("") && code != null
				&& !code.equals("") ) {
			String sql = " select * from sm_medical_take_way where name like :name and code like :code "
					+ " order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if (name != null && !name.equals("")  && way != null && !way.equals("")
				 ) {
			String sql = " select * from sm_medical_take_way where name like :name  "
					+ "and  measure_mode like :way  order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");

			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (name != null && !name.equals("") 
				&& fl != null && !fl.equals("")) {
			String sql = " select * from sm_medical_take_way where name like :name  "
					+ "and category like :fl order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if (name != null && !name.equals("") && cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where name like :name and durable = :cx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if (code != null
				&& !code.equals("") && way != null && !way.equals("")
				) {
			String sql = " select * from sm_medical_take_way where code like :code "
					+ "and  measure_mode like :way order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("way", "%" + way.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if ( code != null
				&& !code.equals("") 
				&& fl != null && !fl.equals("")) {
			String sql = " select * from sm_medical_take_way where code like :code "
					+ " and category like :fl  order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}else if (code != null
				&& !code.equals("") && cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where code like :code "
					+ " and durable = :cx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if ( way != null && !way.equals("")
				&& fl != null && !fl.equals("") ) {
			String sql = " select * from sm_medical_take_way where "
					+ " measure_mode like :way and category like :fl  order by code  ";
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("fl", "%" + fl.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}  else if ( way != null && !way.equals("")
				&& cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where  "
					+ "  measure_mode like :way and durable = :cx order by code  ";
			paramMap.put("way", "%" + way.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if ( fl != null && !fl.equals("") && cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where category like :fl and durable = :cx order by code  ";
			paramMap.put("fl", "%" + fl.trim() + "%");
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		}     else if (name != null && !name.equals("")) {
			String sql = " select * from sm_medical_take_way where name like :name order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (code != null && !code.equals("")) {
			String sql = " select * from sm_medical_take_way where code like :code order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (way != null && !way.equals("")) {
			String sql = " select * from sm_medical_take_way where measure_mode like :way order by code  ";
			paramMap.put("way", "%" + way.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (fl != null && !fl.equals("")) {
			String sql = " select * from sm_medical_take_way where category like :fl order by code  ";
			paramMap.put("fl", "%" + fl.trim() + "%");
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else if (cx != null && !cx.equals("")) {
			String sql = " select * from sm_medical_take_way where durable = :cx order by code  ";
			paramMap.put("cx", cx.trim());
			ways = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmMedicalTakeWay.class);
		} else {
			String sql = "select * from sm_medical_take_way order by code";
			ways = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmMedicalTakeWay.class);
		}
		return ways;

	}

	/**
	 * @方法名称: getWayById
	 * @功能描述:给药途径修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:45:15
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.MedicalTakeWayDao#getWayById(java.lang.String)
	 */

	@Override
	public SmMedicalTakeWay getWayById(String id) {
		String hql = "from SmMedicalTakeWay where code=?";
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmMedicalTakeWay) list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * @方法名称: modWayList
	 * @功能描述:给药途径修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:45:36
	 * @param way
	 * @see com.znyy.sm.dao.MedicalTakeWayDao#modWayList(com.znyy.bean.SmMedicalTakeWay)
	 */

	@Override
	public void modWayList(SmMedicalTakeWay way) {

		this.getHibernateTemplate().merge(way);

	}

	/**
	 * @方法名称: getWayByCode
	 * @功能描述:
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午2:19:24
	 * @param code
	 * @return
	 * @see com.znyy.sm.dao.MedicalTakeWayDao#getWayByCode(java.lang.String)
	 */

	@Override
	public List<SmMedicalTakeWay> getWayByCode(String code) {
		String hql = " from SmMedicalTakeWay where code = ? ";

		List<SmMedicalTakeWay> list = this.getHibernateTemplate().find(hql,
				code);
		return list;
	}

	/**
	 * @方法名称: getWayByName
	 * @功能描述:
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午2:19:28
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.MedicalTakeWayDao#getWayByName(java.lang.String)
	 */

	@Override
	public List<SmMedicalTakeWay> getWayByName(String name) {
		String hql = " from SmMedicalTakeWay where name = ? ";

		List<SmMedicalTakeWay> list = this.getHibernateTemplate().find(hql,
				name);
		return list;
	}

	/**
	 * @方法名称: addWay
	 * @功能描述:添加给药途径信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午4:31:03
	 * @param mtw
	 * @see com.znyy.sm.dao.MedicalTakeWayDao#addWay(com.znyy.bean.SmMedicalTakeWay)
	 */

	@Override
	public void addWay(SmMedicalTakeWay mtw) {
		this.getHibernateTemplate().save(mtw);
	}

}