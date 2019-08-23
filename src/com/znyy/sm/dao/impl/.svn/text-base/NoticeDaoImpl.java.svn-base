package com.znyy.sm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmNotice;
import com.znyy.sm.dao.NoticeDao;

@SuppressWarnings("unchecked")
public class NoticeDaoImpl extends GenericDaoImpl<SmNotice, String> implements
		NoticeDao {
	/**
	 * @方法名称: getNocList
	 * @功能描述:获取公告信息列表
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午1:47:28
	 * @return
	 * @see com.znyy.sm.dao.NoticeDao#getNocList()
	 */
	@Override
	public Page getNocList(String name, int parmpage, Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page nocs = new Page();
		if (name != null && !name.equals("")) {
			String sql = " select * from sm_notice where 1=1 and name like :name order by id  ";
			paramMap.put("name", "%" + name.trim() + "%");
			nocs = this.findByHQLWithPageOfSQL(sql, paramMap, parmpage,
					pageSize, SmNotice.class);
		} else {
			String sql = "select * from sm_notice where 1=1 order by id";
			nocs = this.findByHQLWithPageOfSQL(sql, null, parmpage, pageSize,
					SmNotice.class);
		}
		return nocs;
	}

	/**
	 * @方法名称: getNoticeById
	 * @功能描述:公告修改跳转
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午3:05:34
	 * @param id
	 * @return
	 * @see com.znyy.sm.dao.NoticeDao#getNoticeById(java.lang.Integer)
	 */

	@Override
	public SmNotice getNoticeById(Integer id) {

		String hql = "from SmNotice where id=?";

		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (SmNotice) list.get(0);
		} else {
			return null;
		}
	}

	
	 /** 
	 * @方法名称: modNoticeList
	 * @功能描述:修改公告信息
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午3:21:10
	 * @param noti
	 * @see com.znyy.sm.dao.NoticeDao#modNoticeList(com.znyy.bean.SmNotice)
	 */
	 
	@Override
	public void modNoticeList(SmNotice noti) {
		
		this.getHibernateTemplate().merge(noti);
		
	}

	
	 /** 
	 * @方法名称: addNotice
	 * @功能描述:添加公告信息
	 * @作者:付士山
	 * @创建时间:2016-3-24 下午5:19:21
	 * @param notice
	 * @see com.znyy.sm.dao.NoticeDao#addNotice(com.znyy.bean.SmNotice)
	 */
	 
	@Override
	public void addNotice(SmNotice notice) {
		
		this.getHibernateTemplate().save(notice);
	}

	
	 /** 
	 * @方法名称: delNotice
	 * @功能描述:公告删除
	 * @作者:付士山
	 * @创建时间:2016-3-25 上午10:38:06
	 * @param id
	 * @see com.znyy.sm.dao.NoticeDao#delNotice(java.lang.Integer)
	 */
	 
	@Override
	public void delNotice(SmNotice notic) {
		
		this.getHibernateTemplate().delete(notic);
		
	}

	@Override
	public Map<String, Object> getOpterNameById(String userId) {
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		m.put("userId", userId);
		String sql=" select t.name from xt_user t where t.id=:userId ";
        List<?> l = this.findBySql(sql, m);
			result.put("UserName", l.get(0));
			
        
		return result;
	}

}