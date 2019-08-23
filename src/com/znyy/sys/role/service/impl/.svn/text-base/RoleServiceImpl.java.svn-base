package com.znyy.sys.role.service.impl;

import com.znyy.sys.role.dao.RoleDao;
import com.znyy.sys.role.service.RoleService;

public class RoleServiceImpl implements RoleService{
	private RoleDao roleDao;

	 /** 
	 * @方法名称: selectIsAdminRole
	 * @功能描述:根据用户编号判读是否为管理员角色
	 * @作者:慕金剑
	 * @创建时间:2015-12-7 下午1:31:11
	 * @param userid
	 * @return
	 * @see com.znyy.sys.service.RoleService#selectIsAdminRole(java.lang.String)
	 */
	@Override
	public boolean selectIsAdminRole(Integer userid) {
		return roleDao.selectIsAdminRole(userid);
	}

	public RoleDao getRoleDao() {
	
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
	
		this.roleDao = roleDao;
	}
}
