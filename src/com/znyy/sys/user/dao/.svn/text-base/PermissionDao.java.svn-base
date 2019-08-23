package com.znyy.sys.user.dao;

import java.util.List;

import com.common.dao.GenericDAO;
import com.znyy.bean.XtPermission;


 /** 
 * @类名称: PermissionDao
 * @类描述:权限表Dao
 * @作者:慕金剑
 * @创建时间:2015-12-7 下午2:40:29
 */
 
public interface PermissionDao extends GenericDAO<XtPermission, Integer> {
	
	 /**
	 * @方法名称: getBtnCode
	 * @功能描述: 根据模块id、用户id、系统id获取模块按钮code集合(非管理员)
	 * @作者:慕金剑
	 * @创建时间:2016-3-31 上午9:38:22
	 * @param userid用户id
	 * @param functionid模块id
	 * @param sysid系统id
	 * @return List<String>   
	 */
	 
	public List<String> getBtnCode(Integer userid,String functionid,String sysid);
	
	 /**
	 * @方法名称: getAllBtnCode
	 * @功能描述: 获取所有有效的模块按钮Code（管理员）
	 * 模块下所有有效的按钮编码
	 * @作者:慕金剑
	 * @创建时间:2016-3-31 上午9:57:07
	 * @param funid 模块id
	 * @return List<String>   
	 */
	 
	public List<String> getAllBtnCode(String funid);
	
}
