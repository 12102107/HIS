package com.znyy.sm.dao.impl;
import java.util.List;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmAnaesMethod;
import com.znyy.bean.SmMedicalStandard;
import com.znyy.sm.dao.MedicalStandardDao;
@SuppressWarnings("unchecked")
public class MedicalStandardDaoImpl extends GenericDaoImpl<SmMedicalStandard, String> implements
MedicalStandardDao {

	@Override
	public List<SmMedicalStandard> getMs() {
		String hql = " from SmMedicalStandard ";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public void addFile(SmMedicalStandard ms) {

		this.getHibernateTemplate().save(ms);
	}

	@Override
	public SmMedicalStandard queryZskSummaryById(String knowId) {
     String hql = "from SmMedicalStandard where id=? and pid != 0 and summary!=null" ;
		
		List list = this.getHibernateTemplate().find(hql, Integer.valueOf(knowId) );
		if (!list.isEmpty()) {
			return (SmMedicalStandard) list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<SmMedicalStandard> getCatalogList() {
		String hql = " from SmMedicalStandard where pid=0";
		return this.getHibernateTemplate().find(hql);
	}


	@Override
	public void zskDel(SmMedicalStandard ms) {
		this.getHibernateTemplate().delete(ms);
		
	}

	@Override
	public SmMedicalStandard queryZskById(String knowId) {
	     String hql = "from SmMedicalStandard where id=? " ;
			
			List list = this.getHibernateTemplate().find(hql, Integer.valueOf(knowId) );
			if (!list.isEmpty()) {
				return (SmMedicalStandard) list.get(0);
			} else {
				return null;
			}
	}

}