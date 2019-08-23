package com.znyy.sys.function.service;

import java.util.List;
import java.util.Map;

import com.znyy.bean.XtFunction;

public interface FunctionService {


	/**
	 * @方法名称: selectMenu
	 * @功能描述:根据用户和系统查询有权限的菜单
	 * @作者:慕金剑
	 * @创建时间:2015-12-7 下午6:42:26
	 * @param sysid
	 * @param userid
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String, Object>> selectMenu(String sysid, Integer userid);

	/**
	 * 查找三级菜单
	 * 
	 * @方法名称: findFunctionThree
	 * @功能描述:
	 * @作者:王滨
	 * @创建时间:2016-3-15 下午7:25:09
	 * @param functionid
	 * @return List
	 */
	public List findFunctionThree(Integer functionid);

	/**
	 * 
	 * @方法名称: findFuctionById
	 * @功能描述: 根据id查找对象
	 * @作者:王滨
	 * @创建时间:2016-3-16 下午2:14:41
	 * @param fid
	 * @return XtFunction
	 */
	public XtFunction findFuctionById(Integer fid);
	
	 /**
	 * @方法名称: getThreeFunctions
	 * @功能描述: 查询有权限的三级菜单
	 * @作者:慕金剑
	 * @创建时间:2016-3-30 上午11:42:05
	 * @param functionid 二级菜单id
	 * @param sysid 系统id
	 * @param userid 人员id
	 * @return List<XtFunction>   
	 */
	 
	public List<XtFunction> getThreeFunctions(Integer functionid,String sysid,Integer userid);
}
