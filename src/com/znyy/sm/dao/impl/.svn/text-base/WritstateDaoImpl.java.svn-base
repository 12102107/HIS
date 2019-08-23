/**  
 * @Title: WritstateDaoImpl.java 
 * @Package com.znyy.sm.dao.impl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-3-14 上午10:02:44 
 */ 
package com.znyy.sm.dao.impl;

import java.util.List;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmWritstate;
import com.znyy.sm.dao.WritstateDao;

/** 
 * @ClassName: WritstateDaoImpl 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-3-14 上午10:02:44 
 */
public class WritstateDaoImpl extends GenericDaoImpl<SmWritstate, String> implements
		WritstateDao {

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.WritstateDao#getSmWritstateBySroId(java.lang.String)
	 */
	@Override
	public SmWritstate getSmWritstateBySroId(String operationId) {
		String hql = "from SmWritstate where operationId=?";
		List<SmWritstate> r = this.getHibernateTemplate().find(hql,operationId);
		if(!r.isEmpty()) {
			return r.get(0);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.WritstateDao#saveSmWritstate(com.znyy.bean.SmWritstate)
	 */
	@Override
	public void saveSmWritstate(SmWritstate s) {
		this.save(s);
	}

}
