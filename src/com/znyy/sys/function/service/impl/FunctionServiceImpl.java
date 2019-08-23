package com.znyy.sys.function.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.redis.IRedisUtil;
import com.common.redis.RedisKeys;
import com.znyy.bean.XtFunction;
import com.znyy.sys.function.dao.FunctionDao;
import com.znyy.sys.function.service.FunctionService;
import com.znyy.sys.role.service.RoleService;

public class FunctionServiceImpl implements FunctionService {
	private FunctionDao functionDao;
	private RoleService roleService;

	/**
	 * 缓存工具类
	 */
	private IRedisUtil redisUtil;


	/**
	 * @方法名称: selectmenu
	 * @功能描述: 获取用户左侧菜单
	 * @作者:慕金剑
	 * @创建时间:2015-12-7 下午6:40:13
	 * @param menus
	 * @return List<Map>
	 */
	public List<Map<String, Object>> selectMenu(String sysid, Integer userid) {
		List<Map<String, Object>> all = new ArrayList<Map<String, Object>>();

		boolean isAdmin = roleService.selectIsAdminRole(userid);
		// 该系统下所有有效的一二级菜单
		List<Map<String, Object>> allfuns = new ArrayList<Map<String, Object>>();
		// 所有有效的一二级菜单缓存前缀（+系统id）
		StringBuffer allfunskey = new StringBuffer();
		allfunskey.append(RedisKeys.ALLMENUSPrefix).append(sysid);

		allfuns = (List<Map<String, Object>>) redisUtil.getObject(
				RedisKeys.SYSOA, allfunskey.toString());
		if (null == allfuns) {
			allfuns = functionDao.getAllFunctions(sysid);
			redisUtil.setObject(RedisKeys.SYSOA, allfunskey.toString(), allfuns);
		}
		if (isAdmin) {// 管理员
			this.getLeftMenu(all, allfuns);
		} else {
			// 所有有效的，有权限的菜单id缓存（+系统id+人员id）
			StringBuffer rightfunskey = new StringBuffer();
			rightfunskey.append(RedisKeys.RIGHTFUNSPrefix).append(sysid)
					.append("_").append(userid);
			List<Map<String, Object>> funs = new ArrayList<Map<String, Object>>();
			List<String> rightFuns = new ArrayList<String>();
			rightFuns = (List<String>) redisUtil.getObject(RedisKeys.SYSOA,
					rightfunskey.toString());
			if (null == rightFuns) {
				rightFuns = functionDao.getXtFunctions(sysid, userid);
				redisUtil.setObject(RedisKeys.SYSOA, rightfunskey.toString(),
						rightFuns);
			}
			funs.addAll(allfuns);
			// 剔除没有权限的菜单
			for (Map<String, Object> fun : allfuns) {
				if (rightFuns.contains(fun.get("ID").toString())) {
					if (null != fun.get("PID")
							&& !rightFuns.contains(fun.get("PID").toString())) {
						rightFuns.add(fun.get("PID").toString());
					}
				} else {
					funs.remove(fun);
				}
			}
			this.getLeftMenu(all, funs);
		}
		return all;
	}

	/**
	 * @方法名称: getLeftMenu
	 * @功能描述: 构造左侧菜单数据结构
	 * @作者:慕金剑
	 * @创建时间:2015-12-25 下午1:59:06
	 * @param all
	 *            返回的数据
	 * @param funs
	 *            void 菜单数据
	 */
	private void getLeftMenu(List<Map<String, Object>> all,
			List<Map<String, Object>> allfuns) {
		Map<String, List<Map<String, Object>>> l2 = new HashMap<String, List<Map<String, Object>>>();
		for (Map<String, Object> fun : allfuns) {
			Map<String, Object> menu1 = new HashMap<String, Object>();
			Map<String, Object> menu2 = new HashMap<String, Object>();
			if ("1".equals(fun.get("FUN_LEVEL"))) {
				String ID1 = fun.get("ID").toString();
				menu1.put("id", fun.get("ID"));
				menu1.put("name", fun.get("NAME"));
				if (null != fun.get("URL")) {
					String url = fun.get("URL").toString();
					if (null != url && !"".equals(url) && url.indexOf("?") > 0) {
						menu1.put("url", url + "&functionid=" + ID1);
					} else {
						menu1.put("url", url + "?functionid=" + ID1);
					}
				}
				menu1.put("menu2list", l2.get(ID1));
				all.add(menu1);
			} else if ("2".equals(fun.get("FUN_LEVEL"))) {
				String ID2 = fun.get("ID").toString();
				String PID2 = fun.get("PID").toString();
				String MENU3 = fun.get("MENU3").toString();
				menu2.put("id2", fun.get("ID"));
				menu2.put("name2", fun.get("NAME"));
				if (null != fun.get("URL")) {
					String url = fun.get("URL").toString();
					if (!"".equals(url) && url.indexOf("?") > 0) {
						menu2.put("url", url + "&functionid=" + ID2);
					} else {
						menu2.put("url", url + "?functionid=" + ID2);
					}
				}
				if (null != l2.get(PID2)) {
					l2.get(PID2).add(menu2);
				} else {
					List<Map<String, Object>> ID2l = new ArrayList<Map<String, Object>>();
					ID2l.add(menu2);
					l2.put(PID2, ID2l);
				}
				if (!"0".equals(MENU3)) {
					menu2.put("menu3list", MENU3);
				}
			}
		}
	}

	


	@Override
	public List findFunctionThree(Integer functionid) {
		return functionDao.findFunctionThree(functionid);

	}

	@Override
	public XtFunction findFuctionById(Integer fid) {
		return functionDao.get(fid);

	}
	
	@Override
	public List<XtFunction> getThreeFunctions(Integer functionid,String sysid,Integer userid) {
		boolean isAdmin = roleService.selectIsAdminRole(userid);
		if (isAdmin) {// 管理员
			return functionDao.getThreeFunctions(functionid, sysid, null);
		} else {
		//有权限的菜单id
		//所有有效的，有权限的菜单id缓存（+系统id+人员id）
		StringBuffer rightfunskey = new StringBuffer();
		rightfunskey.append(RedisKeys.RIGHTFUNSPrefix).append(sysid)
				.append("_").append(userid);
		List<String> rightFuns = new ArrayList<String>();
		rightFuns = (List<String>) redisUtil.getObject(RedisKeys.SYSOA,
				rightfunskey.toString());
		if (null == rightFuns) {
			rightFuns = functionDao.getXtFunctions(sysid, userid);
			redisUtil.setObject(RedisKeys.SYSOA, rightfunskey.toString(),
					rightFuns);
		}
		return functionDao.getThreeFunctions(functionid, sysid, rightFuns);
		}
	}

	
	public FunctionDao getFunctionDao() {

		return functionDao;
	}

	public RoleService getRoleService() {

		return roleService;
	}

	public void setFunctionDao(FunctionDao functionDao) {

		this.functionDao = functionDao;
	}

	public void setRoleService(RoleService roleService) {

		this.roleService = roleService;
	}
	
	public IRedisUtil getRedisUtil() {
	
		return redisUtil;
	}

	public void setRedisUtil(IRedisUtil redisUtil) {
	
		this.redisUtil = redisUtil;
	}

}
