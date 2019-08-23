package com.common.redis;

 /** 
 * @类名称: RedisKey
 * @类描述:Redis缓存服务器key(统一管理)
 * @作者:慕金剑
 * @创建时间:2016-2-16 上午10:34:34
 */
 
public class RedisKeys {
	/**
	 * @创建人 慕金剑
	 * @创建时间 2016-04-11
	 * @系统缓存标示-RedisSession前缀+(人员id)
	 * @例如key:RedisSession_1
	 */
	public static String SESSIONPrefix="RedisSession_";
	
	/**
	 * @创建人 慕金剑
	 * @创建时间 2016-03-25
	 * @系统缓存标示-OA系统
	 */
	public static String SYSOA="oa";
	/**
	 * @创建人 慕金剑
	 * @创建时间 2016-03-25
	 * @系统缓存标示-HIS系统
	 */
	public static String SYSHIS="his";

	/**
	 * @创建人 慕金剑
	 * @创建时间 2016-03-25
	 * @系统缓存标示-所有有效的一二级菜单缓存前缀（+系统id）
	 * @例如key:allmenus_1
	 * 查询菜单时放入该缓存
	 * 模块修改的时候维护该缓存（add、del、modFun）
	 */
	public static String ALLMENUSPrefix="allmenus_";
	
	/**
	 * @创建人 慕金剑
	 * @创建时间 2016-03-25
	 * @系统缓存标示-所有有效的，有权限的菜单id缓存（+系统id+人员id）
	 * @例如key:rightfuns_1_admin
	 * 查询菜单时放入该缓存
	 * 人修改角色时、角色添加人时、角色修改权限时维护该缓存
	 */
	public static String RIGHTFUNSPrefix="rightfuns_";
	
	/**
	 * @创建人 慕金剑
	 * @创建时间 2016-03-25
	 * @系统缓存标示-角色下所有的用户缓存（+角色id）
	 * @例如key:roleuser_1
	 * 角色添加人时放入该缓存
	 * 人修改角色时、角色添加人时维护该缓存
	 */
	 
	public static String ROLEUSERPrefix="roleuser_";
	
	/**
	 * @创建人 慕金剑
	 * @创建时间 2016-03-25
	 * @系统缓存标示-角色对象缓存（+角色id）
	 * @例如key:roleu_1
	 * 新增角色时添加该缓存
	 * 修改角色、注销角色时维护该缓存
	 */
	 
	public static String ROLEPrefix="role_";
	
}

