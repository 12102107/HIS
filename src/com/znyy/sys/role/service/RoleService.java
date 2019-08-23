package com.znyy.sys.role.service;

public interface RoleService {
	
	 /**
	 * @方法名称: selectIsAdminRole
	 * @功能描述: 根据用户编号判读是否为管理员角色
	 * @作者:慕金剑
	 * @创建时间:2015-12-7 下午1:30:34
	 * @param userid
	 * @return boolean   
	 */
	public boolean selectIsAdminRole(Integer userid);
	
}
