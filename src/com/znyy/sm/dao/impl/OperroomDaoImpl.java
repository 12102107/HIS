package com.znyy.sm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;

import com.znyy.bean.SmOperroom;
import com.znyy.sm.dao.OperroomDao;
@SuppressWarnings("unchecked")
public class OperroomDaoImpl extends GenericDaoImpl<SmOperroom, String> implements
OperroomDao {

	
	 /** 
	 * @方法名称: getOrList
	 * @功能描述:获得手术室信息列表
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午1:04:05
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.OperroomDao#getOrList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getOrList(String name, String lx, String yx, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page sors = new Page();
		if (name != null && !name.equals("")&&lx != null && !lx.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_operroom where name like :name and room_type like :lx and enable = :yx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("lx", "%" + lx.trim() + "%");
			paramMap.put("yx", yx.trim());
			sors = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperroom.class);
		}else if (name != null && !name.equals("")&&lx != null && !lx.equals("")) {
			String sql = " select * from sm_operroom where name like :name and room_type like :lx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("lx", "%" + lx.trim() + "%");
			sors = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperroom.class);
		}else  if (name != null && !name.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_operroom where name like :name and enable = :yx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			sors = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperroom.class);
		}else  if (lx != null && !lx.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_operroom where room_type like :lx and enable = :yx order by id  ";
			paramMap.put("lx", "%" + lx.trim() + "%");
			paramMap.put("yx", yx.trim());
			sors = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperroom.class);
		}else if (name != null && !name.equals("")) {
			String sql = " select * from sm_operroom where name like :name order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			sors = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperroom.class);
		}else if (lx != null && !lx.equals("")) {
			String sql = " select * from sm_operroom where room_type like :lx order by id  ";
			paramMap.put("lx", "%" + lx.trim() + "%");
			sors = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperroom.class);
		}else if (yx != null && !yx.equals("")) {
			String sql = " select * from sm_operroom where enable = :yx order by id  ";
			paramMap.put("yx", yx.trim());
			sors = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmOperroom.class);
		} else {
			String sql = "select * from sm_operroom order by id";
			sors = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmOperroom.class);
		}
		return sors;
	}

	
	 /** 
	 * @方法名称: addOr
	 * @功能描述:添加手术室信息
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午1:33:58
	 * @param sor
	 * @see com.znyy.sm.dao.OperroomDao#addOr(com.znyy.bean.SmOperroom)
	 */
	 
	@Override
	public void addOr(SmOperroom sor) {
		
		this.getHibernateTemplate().save(sor);
		
	}


	
	 /** 
	 * @方法名称: getOrById
	 * @功能描述:手术室修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午3:35:32
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.OperroomDao#getOrById(java.lang.Integer)
	 */
	 
	@Override
	public SmOperroom getOrById(Integer id) {
		String hql = "from SmOperroom where id=?";
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmOperroom) list.get(0);
		} else {
			return null;
		}
	}


	
	 /** 
	 * @方法名称: modOrList
	 * @功能描述:修改手术室数据
	 * @作者:付士山
	 * @创建时间:2016-1-5 上午9:17:53
	 * @param or
	 * @see com.znyy.sm.dao.OperroomDao#modOrList(com.znyy.bean.SmOperroom)
	 */
	 
	@Override
	public void modOrList(SmOperroom or) {
		
		this.getHibernateTemplate().merge(or);
		
	}


	
	 /** 
	 * @方法名称: getOrByName
	 * @功能描述:ajax验证手术室名称
	 * @作者:付士山
	 * @创建时间:2016-1-5 上午9:48:50
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.OperroomDao#getOrByName(java.lang.String)
	 */
	 
	@Override
	public List<SmOperroom> getOrByName(String name) {
		
		String hql = " from SmOperroom where name = ? ";

		List<SmOperroom> list = this.getHibernateTemplate().find(hql, name);
		return list;
		
	}


	@Override
	public List<SmOperroom> getRoomList(String enable,String type) {
		String hql=" from SmOperroom where enable=? and roomType=?";
		return this.getHibernateTemplate().find(hql,new Object[]{enable,type});
	}

	
}
