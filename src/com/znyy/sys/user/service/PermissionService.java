package com.znyy.sys.user.service;

import java.util.List;


 /** 
 * @类名称: PermissionService
 * @类描述:权限表service
 * @作者:慕金剑
 * @创建时间:2015-12-8 上午10:46:31
 */
 
public interface PermissionService {
	
	 /**
	 * @方法名称: getBtnCode
	 * @功能描述: 获取模块按钮code集合(userid,functionid,sysid为空时返回空list)
	 * 模块下所有有效的按钮
	 * @作者:慕金剑
	 * @创建时间:2015-12-22 下午1:45:38
	 * @param userid 用户id
	 * @param functionid 模块id
	 * @param sysid 系统id
	 * @return List<String>   
	 */
	public List<String> getBtnCode(Integer userid,String functionid,String sysid);
}
