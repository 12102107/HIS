package com.znyy.sys.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.util.Util;
import com.znyy.sys.role.dao.RoleDao;
import com.znyy.sys.user.dao.PermissionDao;
import com.znyy.sys.user.service.PermissionService;


 /** 
 * @类名称: PermissionServiceImpl
 * @类描述:权限表service实现类
 * @作者:慕金剑
 * @创建时间:2015-12-8 上午10:46:48
 */
public class PermissionServiceImpl implements PermissionService {
	private PermissionDao permissionDao;
	private RoleDao roleDao;

	@Override
	public List<String> getBtnCode(Integer userid, String functionid,
			String sysid) {
		if (!Util.isBlank(userid) && !Util.isBlank(functionid)
				&& !Util.isBlank(sysid)) {
			if (roleDao.selectIsAdminRole(userid)) {// 是管理员拥有所有按钮
				return permissionDao.getAllBtnCode(functionid);
			} else {
				return permissionDao.getBtnCode(userid, functionid, sysid);
			}
		} else {
			return new ArrayList<String>();
		}

	}

	public PermissionDao getPermissionDao() {
	
		return permissionDao;
	}

	public void setPermissionDao(PermissionDao permissionDao) {
	
		this.permissionDao = permissionDao;
	}

	public RoleDao getRoleDao() {
	
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
	
		this.roleDao = roleDao;
	}
	
}
