package com.znyy.sm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmDrugOrGoods;
import com.znyy.sm.dao.DrugOrGoodsDao;
@SuppressWarnings("unchecked")
public class DrugOrGoodsDaoImpl extends GenericDaoImpl<SmDrugOrGoods, String> implements
DrugOrGoodsDao {

	
	 /** 
	 * @方法名称: getDrugList
	 * @功能描述:获取药品物品信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:35:51
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.DrugOrGoodsDao#getDrugList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getDrugList(String name, String lx, String yx, String code, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page its = new Page();
		if (name != null && !name.equals("")&&lx != null && !lx.equals("")&&code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where name like :name and  type like :lx " +
					" and code like :code and  enable = :yx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("lx", "%" + lx.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (name != null && !name.equals("")&&lx != null && !lx.equals("")&&code != null && !code.equals("") ) {
			String sql = " select * from SM_DRUG_OR_GOODS where name like :name and  type like :lx " +
					" and code like :code order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("lx", "%" + lx.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where name like :name " +
					" and code like :code and  enable = :yx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (name != null && !name.equals("")&&lx != null && !lx.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where name like :name and  type like :lx " +
					" and  enable = :yx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("lx", "%" + lx.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (lx != null && !lx.equals("")&&code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where type like :lx " +
					" and code like :code and  enable = :yx order by code  ";
			paramMap.put("lx", "%" + lx.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (name != null && !name.equals("")&&lx != null && !lx.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where name like :name and  type like :lx " +
					"  order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("lx", "%" + lx.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where name like :name " +
					" and code like :code order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (name != null && !name.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where name like :name and  enable = :yx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (lx != null && !lx.equals("")&&code != null && !code.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where type like :lx " +
					" and code like :code order by code  ";
			paramMap.put("lx", "%" + lx.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (lx != null && !lx.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where type like :lx " +
					"  and  enable = :yx order by code  ";
			paramMap.put("lx", "%" + lx.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where code like :code and  enable = :yx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (name != null && !name.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where name like :name order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (lx != null && !lx.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where type like :lx order by code  ";
			paramMap.put("lx", "%" + lx.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (code != null && !code.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where code like :code order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		}else if (yx != null && !yx.equals("")) {
			String sql = " select * from SM_DRUG_OR_GOODS where enable = :yx order by code  ";
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmDrugOrGoods.class);
		} else {
			String sql = "select * from SM_DRUG_OR_GOODS where 1=1 order by code";
			its = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmDrugOrGoods.class);
		}
		return its;
	}

	
	 /** 
	 * @方法名称: getDrugById
	 * @功能描述:药品物品修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:51:48
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.DrugOrGoodsDao#getDrugById(java.lang.Integer)
	 */
	 
	@Override
	public SmDrugOrGoods getDrugById(Integer id) {
		

		String hql = "from SmDrugOrGoods where id=?";
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmDrugOrGoods) list.get(0);
		} else {
			return null;
		}
	}

	
	 /** 
	 * @方法名称: modDrugList
	 * @功能描述:药品物品修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:52:13
	 * @param dg
	 * @see com.znyy.sm.dao.DrugOrGoodsDao#modDrugList(com.znyy.bean.SmDrugOrGoods)
	 */
	 
	@Override
	public void modDrugList(SmDrugOrGoods dg) {
		
		this.getHibernateTemplate().merge(dg);
	}


	
	 /** 
	 * @方法名称: addDrug
	 * @功能描述:添加药品物品信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:03:49
	 * @param sdg
	 * @see com.znyy.sm.dao.DrugOrGoodsDao#addDrug(com.znyy.bean.SmDrugOrGoods)
	 */
	 
	@Override
	public void addDrug(SmDrugOrGoods sdg) {
		this.getHibernateTemplate().save(sdg);
	}


	
	 /** 
	 * @方法名称: getDrugByName
	 * @功能描述:ajax验证药品物品名称
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:12:44
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.DrugOrGoodsDao#getDrugByName(java.lang.String)
	 */
	 
	@Override
	public List<SmDrugOrGoods> getDrugByName(String name) {

		String hql = " from SmDrugOrGoods where name = ? ";

		List<SmDrugOrGoods> list = this.getHibernateTemplate().find(hql, name);
		return list;
	}


	
	 /** 
	 * @方法名称: getDrugByCode
	 * @功能描述:ajax验证药品物品代码
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:12:49
	 * @param parseInt
	 * @return
	 * @see com.znyy.sm.dao.DrugOrGoodsDao#getDrugByCode(int)
	 */
	 
	@Override
	public List<SmDrugOrGoods> getDrugByCode(int parseInt) {

		String hql = " from SmDrugOrGoods where code = ? ";

		List<SmDrugOrGoods> list = this.getHibernateTemplate().find(hql, parseInt);
		return list;
	}

}