package com.znyy.sm.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmCheckItem;
import com.znyy.sm.dao.CheckItemDao;
@SuppressWarnings("unchecked")
public class CheckItemDaoImpl extends GenericDaoImpl<SmCheckItem, String> implements
CheckItemDao {

	
	 /** 
	 * @方法名称: getCheckList
	 * @功能描述:获取检验项目信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:16:53
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.CheckItemDao#getCheckList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getCheckList(String name, String dw, String code, String yx, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page its = new Page();
		if (name != null && !name.equals("")&&dw != null && !dw.equals("")&&code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_check_item where name like :name and  unit like :dw " +
					" and code like :code and  enable = :yx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (name != null && !name.equals("")&&dw != null && !dw.equals("")&&code != null && !code.equals("") ) {
			String sql = " select * from sm_check_item where name like :name and  unit like :dw " +
					" and code like :code order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_check_item where name like :name " +
					" and code like :code and  enable = :yx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (name != null && !name.equals("")&&dw != null && !dw.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_check_item where name like :name and  unit like :dw " +
					" and  enable = :yx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (dw != null && !dw.equals("")&&code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_check_item where unit like :dw " +
					" and code like :code and  enable = :yx order by code  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (name != null && !name.equals("")&&dw != null && !dw.equals("")) {
			String sql = " select * from sm_check_item where name like :name and  unit like :dw " +
					"  order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("dw", "%" + dw.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (name != null && !name.equals("")&&code != null && !code.equals("")) {
			String sql = " select * from sm_check_item where name like :name " +
					" and code like :code order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (name != null && !name.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_check_item where name like :name and  enable = :yx order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (dw != null && !dw.equals("")&&code != null && !code.equals("")) {
			String sql = " select * from sm_check_item where unit like :dw " +
					" and code like :code order by code  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("code", "%" + code.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (dw != null && !dw.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_check_item where unit like :dw " +
					"  and  enable = :yx order by code  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (code != null && !code.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_check_item where code like :code and  enable = :yx order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (name != null && !name.equals("")) {
			String sql = " select * from sm_check_item where name like :name order by code  ";
			paramMap.put("name", "%" + name.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (dw != null && !dw.equals("")) {
			String sql = " select * from sm_check_item where unit like :dw order by code  ";
			paramMap.put("dw", "%" + dw.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (code != null && !code.equals("")) {
			String sql = " select * from sm_check_item where code like :code order by code  ";
			paramMap.put("code", "%" + code.trim() + "%");
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		}else if (yx != null && !yx.equals("")) {
			String sql = " select * from sm_check_item where enable = :yx order by code  ";
			paramMap.put("yx", yx.trim());
			its = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmCheckItem.class);
		} else {
			String sql = "select * from sm_check_item where 1=1 order by code";
			its = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmCheckItem.class);
		}
		return its;
	}

	
	 /** 
	 * @方法名称: modCheckList
	 * @功能描述:检验项目修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:43:28
	 * @param ci
	 * @see com.znyy.sm.dao.CheckItemDao#modCheckList(com.znyy.bean.SmCheckItem)
	 */
	 
	@Override
	public void modCheckList(SmCheckItem ci) {
		
		this.getHibernateTemplate().merge(ci);
		
	}

	
	 /** 
	 * @方法名称: getCheckById
	 * @功能描述:检验项目修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:43:26
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.CheckItemDao#getCheckById(java.lang.String)
	 */
	 
	@Override
	public SmCheckItem getCheckById(String id) {
	String hql = "from SmCheckItem where code=?";
		
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmCheckItem) list.get(0);
		} else {
			return null;
	}
	}


	
	 /** 
	 * @方法名称: getCheckByName
	 * @功能描述:ajax验证检验项目名称
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午4:57:51
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.CheckItemDao#getCheckByName(java.lang.String)
	 */
	 
	@Override
	public List<SmCheckItem> getCheckByName(String name) {
		String hql = " from SmCheckItem where name = ? ";

		List<SmCheckItem> list = this.getHibernateTemplate().find(hql, name);
		return list;
	}


	
	 /** 
	 * @方法名称: getCheckByCode
	 * @功能描述:ajax验证检验项目代码 
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午4:57:54
	 * @param code
	 * @return
	 * @see com.znyy.sm.dao.CheckItemDao#getCheckByCode(java.lang.String)
	 */
	 
	@Override
	public List<SmCheckItem> getCheckByCode(String code) {
		
		String hql = " from SmCheckItem where code = ? ";

		List<SmCheckItem> list = this.getHibernateTemplate().find(hql, code);
		return list;
	
	}


	
	 /** 
	 * @方法名称: addCheck
	 * @功能描述:
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午5:16:18
	 * @param sci
	 * @see com.znyy.sm.dao.CheckItemDao#addCheck(com.znyy.bean.SmCheckItem)
	 */
	 
	@Override
	public void addCheck(SmCheckItem sci) {
		
		this.getHibernateTemplate().save(sci);
		
	}
}