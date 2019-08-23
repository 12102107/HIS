package com.znyy.sys.role.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.XtRole;
import com.znyy.sys.role.dao.RoleDao;

@SuppressWarnings("unchecked")
public class RoleDaoImpl extends GenericDaoImpl<XtRole, Integer> implements
		RoleDao {
	/**
	 * @方法名称: selectIsAdminRole
	 * @功能描述:根据用户编号判读是否为管理员角色
	 * @作者:慕金剑
	 * @创建时间:2015-12-7 下午1:32:54
	 * @param userid
	 * @return
	 * @see com.znyy.sys.dao.RoleDao#selectIsAdminRole(java.lang.String)
	 */
	@Override
	public boolean selectIsAdminRole(Integer userid) {
		String sql = "SELECT T.ID FROM XT_ROLE T WHERE  EXISTS (SELECT T1.ROLEID FROM XT_USER_ROLE T1 WHERE T1.USERID=:USERID AND T.ID=T1.ROLEID) AND TYPE=0 ";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("USERID", userid);
		Query query = this.setQueryParametersOfSQL(sql, params);
		if (null == query.list() || query.list().size() == 0) {// 该用户不是管理员角色
			return false;
		} else {
			return true;
		}
	}

}
