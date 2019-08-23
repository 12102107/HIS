package com.znyy.sm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmRegion;
import com.znyy.bean.SysDiseaseArea;
import com.znyy.sm.dao.RegionDao;

@SuppressWarnings("unchecked")
public class RegionDaoImpl extends GenericDaoImpl<SmRegion, String> implements
		RegionDao {

	/**
	 * @方法名称: getRegionList
	 * @功能描述:获取病区信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:36:40
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.dao.RegionDao#getRegionList(java.lang.String, int,
	 *      java.lang.Integer)
	 */

	@Override
	public Page getRegionList(String name,String yx, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page srs = new Page();
		if (name != null && !name.equals("")&&yx != null && !yx.equals("")) {
			String sql = " select * from sm_region where name like :name and enable = :yx order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			paramMap.put("yx", yx.trim());
			srs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmRegion.class);
		}else if (name != null && !name.equals("")) {
			String sql = " select * from sm_region where name like :name order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			srs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmRegion.class);
		}else if (yx != null && !yx.equals("")) {
			String sql = " select * from sm_region where enable = :yx order by id  ";
			paramMap.put("yx", yx.trim());
			srs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmRegion.class);
		} else {
			String sql = "select * from sm_region where 1=1 order by id";
			srs = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmRegion.class);
		}
		return srs;
	}

	/**
	 * @方法名称: getRegionByName
	 * @功能描述:ajax验证病区名称
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午12:00:03
	 * @param name
	 * @return
	 * @see com.znyy.sm.dao.RegionDao#getRegionByName(java.lang.String)
	 */

	@Override
	public List<SmRegion> getRegionByName(String name) {

		String hql = " from SmRegion where name = ? ";

		List<SmRegion> list = this.getHibernateTemplate().find(hql, name);
		return list;
	}

	/**
	 * @方法名称: addRegion
	 * @功能描述:添加病区信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午1:00:14
	 * @param sr
	 * @see com.znyy.sm.dao.RegionDao#addRegion(com.znyy.bean.SmRegion)
	 */

	@Override
	public void addRegion(SmRegion sr) {

		this.getHibernateTemplate().save(sr);

	}

	/**
	 * @方法名称: getRegionById
	 * @功能描述:病区修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午1:08:23
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.RegionDao#getRegionById(java.lang.Integer)
	 */

	@Override
	public SmRegion getRegionById(Integer id) {
		String hql = "from SmRegion where id=?";
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmRegion) list.get(0);
		} else {
			return null;
		}
	}

	
	 /** 
	 * @方法名称: modRegionList
	 * @功能描述:病区修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午1:15:53
	 * @param srn
	 * @see com.znyy.sm.dao.RegionDao#modRegionList(com.znyy.bean.SmRegion)
	 */
	 
	@Override
	public void modRegionList(SmRegion srn) {
		this.getHibernateTemplate().merge(srn);
		
	}

	@Override
	public List<SysDiseaseArea> getRegions() {
		String hql=" from SysDiseaseArea where flag='1'";
		return this.getHibernateTemplate().find(hql);
	}

}
