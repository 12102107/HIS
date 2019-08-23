package com.znyy.sys.function.dao;

import java.util.List;
import java.util.Map;

import com.common.dao.GenericDAO;
import com.znyy.bean.XtFunction;

public interface FunctionDao extends GenericDAO<XtFunction, Integer> {

	/**
	 * @方法名称: getAllFunctions
	 * @功能描述: 获取用户不同系统下的所有模块
	 * @作者:慕金剑
	 * @创建时间:2015-12-7 下午2:47:29
	 * @param sysid
	 * @return List<Map<String, Object>>
	 */

	public List<Map<String, Object>> getAllFunctions(String sysid);

	/**
	 * @方法名称: getXtFunctions
	 * @功能描述: 获取用户权限下的菜单id
	 * @作者:慕金剑
	 * @创建时间:2015-12-7 下午2:30:10
	 * @param sysid
	 *            系统id
	 * @param userid
	 *            用户编号
	 * @return List<String>
	 */
	public List<String> getXtFunctions(String sysid, Integer userid);

	/**
	 * 
	 * @方法名称: findFunctionThree
	 * @功能描述: 查找三级菜单
	 * @作者:王滨
	 * @创建时间:2016-3-15 下午7:26:08
	 * @param functionid
	 * @return List
	 */
	public List findFunctionThree(Integer functionid);
	
	 /**
	 * @方法名称: getThreeFunctions
	 * @功能描述: 查询有权限的三级菜单
	 * @作者:慕金剑
	 * @创建时间:2016-3-30 上午11:45:27
	 * @param functionid 二级菜单id
	 * @param sysid 系统id
	 * @return List<XtFunction>   
	 */
	 
	public List<XtFunction> getThreeFunctions(Integer functionid,String sysid,List<String> rightFunids);

}
