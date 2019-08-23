package com.znyy.sm.dao.impl;

import java.util.List;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmMedicine;
import com.znyy.bean.ZyOperationApply;
import com.znyy.sm.dao.HisDao;


@SuppressWarnings("unchecked")
public class HisDaoImpl extends GenericDaoImpl<SmMedicine, String> implements
HisDao{

	@Override
	public List<ZyOperationApply> getOperationApply() {
		String hql = " from ZyOperationApply where state='0'";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public ZyOperationApply getHisById(long id) {
		
		String hql = "from ZyOperationApply where id=?";
		List list = this.getHibernateTemplate().find(hql, id);
		if (!list.isEmpty()) {
			return (ZyOperationApply) list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void modHisList(ZyOperationApply hiss) {
		
		this.getHibernateTemplate().merge(hiss);
		
	}


}
