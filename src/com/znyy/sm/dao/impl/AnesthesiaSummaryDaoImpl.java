/**
 * 
 */
package com.znyy.sm.dao.impl;

import java.util.List;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmAnaesSummary;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;
import com.znyy.sm.dao.AnesthesiaSummaryDao;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author 白东旭
 * @date 2016-4-28
 */
public class AnesthesiaSummaryDaoImpl extends GenericDaoImpl<SmAnaesSummary, String> implements
		AnesthesiaSummaryDao {

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.AnesthesiaSummaryDao#getSummaryByYlwsid(java.lang.String)
	 */
	@Override
	public SmAnaesSummary getSummaryByYlwsid(String ylwsid) {
		String hql = "from SmAnaesSummary where operationId=?";
		List<SmAnaesSummary> l = this.getHibernateTemplate().find(hql,ylwsid);
		if(l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.AnesthesiaSummaryDao#saveSummary(com.znyy.bean.SmAnaesSummary)
	 */
	@Override
	public void saveSummary(SmAnaesSummary summary) {
		this.save(summary);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.AnesthesiaSummaryDao#saveSmWritTemplate(com.znyy.bean.SmWritTemplate)
	 */
	@Override
	public void saveSmWritTemplate(SmWritTemplate wt) {
		this.getHibernateTemplate().save(wt);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.AnesthesiaSummaryDao#getSmWritTemplatePersonal(java.lang.String)
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePersonal(String userid) {
		return this.getHibernateTemplate().find("from SmWritTemplate where wirtType='04' and type='1' and userid=? and enable='0'",userid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.AnesthesiaSummaryDao#getSmWritTemplatePublic()
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePublic() {
		return this.getHibernateTemplate().find("from SmWritTemplate where wirtType='04' and type='0' and enable='0'");
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.AnesthesiaSummaryDao#delTemplate(java.lang.String)
	 */
	@Override
	public void delTemplate(String templateId) {
		SmWritTemplate s = this.getHibernateTemplate().get(SmWritTemplate.class, templateId);
		s.setEnable("1");
		this.getHibernateTemplate().save(s);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.AnesthesiaSummaryDao#getTemplateVal(java.lang.String)
	 */
	@Override
	public SmAnaesSummary getTemplateVal(String templateId) {
		String hql = "select s from SmAnaesSummary s,SmWritTemplate w where w.wirtId=s.id and w.id=?";
		List<SmAnaesSummary> s = this.getHibernateTemplate().find(hql,templateId);
		if(s.isEmpty()) {
			return null;
		} else {
			return s.get(0);
		}
	}
	
	private static String objToStr(Object obj) {
		if(obj != null && !"null".equals(obj))
			return obj.toString();
		return "";
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.AnesthesiaSummaryDao#getSmRegOpt(java.lang.String)
	 */
	@Override
	public SmRegOpt getSmRegOpt(String ylwsid) {
		return this.getHibernateTemplate().get(SmRegOpt.class, ylwsid);
	}
}
