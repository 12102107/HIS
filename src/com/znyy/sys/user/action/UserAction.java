package com.znyy.sys.user.action;
import java.util.List;
import java.util.Map;

import com.common.action.CommAction;
import com.common.redis.IRedisUtil;
import com.common.redis.RedisKeys;
import com.common.util.Util;
import com.znyy.bean.XtFunction;
import com.znyy.bean.XtSystem;
import com.znyy.sys.function.service.FunctionService;
import com.znyy.sys.system.service.SystemService;

/**
 * @类名称: UserAction
 * @类描述:用户action
 * @作者:慕金剑
 * @创建时间:2015-12-7 下午12:51:35
 */

public class UserAction extends CommAction {
	private FunctionService functionService;
	private SystemService systemService;
	private String info;
	private String sysid;
	private IRedisUtil redisUtil;
	private Integer functionid;

	
	
	 /**
	 * @方法名称: index
	 * @功能描述: 会话超时或退出登录时调用
	 * @作者:慕金剑
	 * @创建时间:2016-4-15 下午4:05:19
	 * @return
	 */
	 
	public String index() {
		request.setAttribute("info", info);
		session.clear();
		String loginUserId=request.getParameter("loginUserId");
		//存在登录人id时说明是退出系统清除redissession
		if(!Util.isBlank(loginUserId)){
			redisUtil.delete(RedisKeys.SYSOA, RedisKeys.SESSIONPrefix+loginUserId);
		}
		return SUCCESS;
	}

	/**
	 * @方法名称: login
	 * @功能描述: 用户登录系统时调用
	 * @作者:慕金剑
	 * @创建时间:2015-12-11 上午9:10:46
	 * @return String
	 */
	public String login() {
		// 系统id
		String sysid=request.getParameter("systemid");
		//登录人id
		String loginUserId=request.getParameter("loginUserId");
	    session.put("sysid", sysid);
	    redisUtil.hset(RedisKeys.SYSOA,RedisKeys.SESSIONPrefix+loginUserId,"sysid",sysid);
	    //选择多科室中一个之后
	    String selUnitid=request.getParameter("selUnitid");
	    if(!Util.isBlank(selUnitid)){
	    	//session中存入选择的科室id
			session.put("unitid", selUnitid);
			redisUtil.hset(RedisKeys.SYSOA, RedisKeys.SESSIONPrefix+loginUserId,"unitid",selUnitid);
	    }else{
	    	redisUtil.hdel(RedisKeys.SYSOA, RedisKeys.SESSIONPrefix+loginUserId,"unitid");
	    }
	    //获取redis中存储的session,登录平台时已经放入该redis，必须存在
	  	Map<String,String> redisSession=redisUtil.hgetAll(RedisKeys.SYSOA,RedisKeys.SESSIONPrefix+loginUserId);
	    if(null==redisSession||redisSession.isEmpty()){
			return "login";
	    }else{
	    	session.putAll(redisSession);
	    }
		return SUCCESS;
	}
	
	 /**
	 * @方法名称: findTopTo
	 * @功能描述: 跳转到top页面
	 * @作者:慕金剑
	 * @创建时间:2016-4-11 上午10:18:37
	 * @return String   
	 */
	 
	public String findTopTo(){
		request.setAttribute("loginUserId",Util.null2String(session.get("userid")));
		request.setAttribute("loginUserName",session.get("sessionusername"));
		return SUCCESS;
	}
	/**
	 * @方法名称: findMenu
	 * @功能描述: 根据当前登录人，当前系统id获取该用户的菜单
	 * @作者:慕金剑
	 * @创建时间:2015-12-11 上午9:19:56
	 * @return String
	 * @throws Exception
	 */
	public String findMenu() {
		try {
			sysid = (String) this.session.get("sysid");
			Integer userid =Util.getIntegerValue(this.session.get("userid"));
			//session中不存在信息时跳转到登录页
			if(Util.isBlank(sysid)||Util.isBlank(userid)){
				return "login";
			}
			// 根据登录用户获取用户具体哪些模块的权限
			 List<Map<String, Object>> functions = functionService.selectMenu(sysid, userid);
			 request.setAttribute("menus", functions);
			 XtSystem m = systemService.getSysById(sysid);
			 request.setAttribute("sysname", m.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	
	
	/**
	 * 
	 * @方法名称: menuframe
	 * @功能描述: 菜单跳转页面初始默认第一页
	 * @作者:王滨
	 * @创建时间:2016-3-16 下午1:53:54
	 * @return String
	 */
	public String menuframe() {
//		List<XtFunction> list = functionService.findFunctionThree(functionid);
		List<XtFunction> list = functionService.getThreeFunctions(functionid,
				(String) this.session.get("sysid"),
				Util.getIntegerValue(this.session.get("userid")));
		if (!list.isEmpty()) {
			XtFunction xtFunction = list.get(0);
			request.setAttribute("xtFunction", xtFunction);
		}
		request.setAttribute("pid", functionid);
		request.setAttribute("flag", "0");// 判断首选位置
		request.setAttribute("functionList", list);
		return SUCCESS;

	}

	/**
	 * 
	 * @方法名称: menuframe
	 * @功能描述: 点击三级菜单跳转页面
	 * @作者:王滨
	 * @创建时间:2016-3-16 下午1:53:54
	 * @return String
	 */
	public String menuframeToByfunction() {
		Integer fid = Integer.parseInt(request.getParameter("fid"));
//		List<XtFunction> list = functionService.findFunctionThree(functionid);
		List<XtFunction> list = functionService.getThreeFunctions(functionid,
				(String) this.session.get("sysid"),
				Util.getIntegerValue(this.session.get("userid")));
		XtFunction xtFunction = functionService.findFuctionById(fid);
		request.setAttribute("xtFunction", xtFunction);
		request.setAttribute("fid", fid);
		request.setAttribute("flag", "1");
		request.setAttribute("functionList", list);
		return SUCCESS;

	}


	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getSysid() {
		return sysid;
	}

	public void setSysid(String sysid) {
		this.sysid = sysid;
	}
	public FunctionService getFunctionService() {

		return functionService;
	}

	public void setFunctionService(FunctionService functionService) {

		this.functionService = functionService;
	}


	public IRedisUtil getRedisUtil() {

		return redisUtil;
	}

	public void setRedisUtil(IRedisUtil redisUtil) {

		this.redisUtil = redisUtil;
	}

	public Integer getFunctionid() {

		return functionid;
	}

	public void setFunctionid(Integer functionid) {

		this.functionid = functionid;
	}

	public SystemService getSystemService() {
	
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
	
		this.systemService = systemService;
	}
}
