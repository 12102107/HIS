
package com.znyy.sys.system.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.common.action.CommAction;
import com.common.redis.IRedisUtil;
import com.common.redis.RedisKeys;
import com.common.util.Util;
import com.znyy.sys.role.service.RoleService;
import com.znyy.sys.system.service.SystemService;
import com.znyy.sys.user.service.UserService;

 /** 
 * @类名称: HospitalAction
 * @类描述:系统医院表action
 * @作者:慕金剑
 * @创建时间:2016-3-21 下午4:14:55
 */
 
public class SystemAction extends CommAction{
	private SystemService systemService;
	private UserService userService;
	private RoleService roleService;
	private String userid;
	private String pwd;
	private String info;
	private List<Map<String, Object>> listmap;
	private List<Map<String, Object>> systemTypeList;
	//redis缓存工具类
	private IRedisUtil redisUtil;
	
	 /**
	 * @方法名称: login
	 * @功能描述: 登录平台页面
	 * @作者:慕金剑
	 * @创建时间:2016-4-5 下午5:11:40
	 * @return String   
	 */
	 
	public String login(){
		String results = SUCCESS;
		String hospitalid="";
		if (Util.isBlank(userid) || Util.isBlank(pwd)) {
			return "login";
		}
		listmap = userService.getUser(userid, pwd);
		if (listmap == null) {
			results = ERROR;
			info = "用户名和密码错误";
		}else {
			String loginUserId=Util.null2String(listmap.get(0).get("ID"));
			hospitalid = Util.null2String(listmap.get(0).get("HOSPITAL_ID"));
			//当前登录人id
			//session.put("loginUserId", loginUserId);
			//登录名
			session.put("userid", loginUserId);
			//姓名
			session.put("sessionusername", Util.null2String(listmap.get(0).get("NAME")));
			//医院编码
			session.put("hospitalid",hospitalid);
			if(roleService.selectIsAdminRole(Integer.parseInt(loginUserId))){
				systemTypeList = systemService.selectSystemList(hospitalid);
			}else{
				systemTypeList = systemService.selectSystemList(hospitalid,loginUserId);
			}
			List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
			List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
			List<Map<String, Object>> list3 = new ArrayList<Map<String,Object>>();
			for (int i = 0; i < systemTypeList.size(); i++) {
				if(systemTypeList.get(i).get("TYPE").equals("0")){
					list1.add(systemTypeList.get(i));
				}else if(systemTypeList.get(i).get("TYPE").equals("1")){
					list2.add(systemTypeList.get(i));
				}else if(systemTypeList.get(i).get("TYPE").equals("2")){
					list3.add(systemTypeList.get(i));
				}
			}
			request.setAttribute("list1", list1);
			request.setAttribute("list2", list2);
			request.setAttribute("list3", list3);
			
			//存入redisSession
			redisUtil.hmset(RedisKeys.SYSOA,RedisKeys.SESSIONPrefix+loginUserId, session);
			request.setAttribute("loginUserId", loginUserId);
		}
		return results;
	}
	
	 /**
	 * @方法名称: backPlatform
	 * @功能描述: 返回到平台页面
	 * @作者:慕金剑
	 * @创建时间:2016-4-7 下午1:51:42
	 * @return String   
	 */
	 
	public String backPlatform(){
		String loginUserId=request.getParameter("loginUserId");
		//获取redis中存储的session,登录平台时已经放入该redis，必须存在
		Map<String,String> redisSession=redisUtil.hgetAll(RedisKeys.SYSOA,RedisKeys.SESSIONPrefix+loginUserId);
		if(null==redisSession||redisSession.isEmpty()){
			return "login";
		}else{
			session.putAll(redisSession);
		}
		//医院编码
		String hospitalid=(String) session.get("hospitalid");
		String uid = request.getParameter("userid");
		if(roleService.selectIsAdminRole(Integer.parseInt(loginUserId))){
			systemTypeList = systemService.selectSystemList(hospitalid);
		}else{
			systemTypeList = systemService.selectSystemList(hospitalid,loginUserId);
		}
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> list3 = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < systemTypeList.size(); i++) {
			if(systemTypeList.get(i).get("TYPE").equals("0")){
				list1.add(systemTypeList.get(i));
			}else if(systemTypeList.get(i).get("TYPE").equals("1")){
				list2.add(systemTypeList.get(i));
			}else if(systemTypeList.get(i).get("TYPE").equals("2")){
				list3.add(systemTypeList.get(i));
			}
		}
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("loginUserId",Util.null2String(session.get("userid")));
		return SUCCESS;
	}

	public SystemService getSystemService() {
	
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
	
		this.systemService = systemService;
	}

	public UserService getUserService() {
	
		return userService;
	}

	public void setUserService(UserService userService) {
	
		this.userService = userService;
	}

	public RoleService getRoleService() {
	
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
	
		this.roleService = roleService;
	}

	public String getUserid() {
	
		return userid;
	}

	public void setUserid(String userid) {
	
		this.userid = userid;
	}

	public String getPwd() {
	
		return pwd;
	}

	public void setPwd(String pwd) {
	
		this.pwd = pwd;
	}

	public String getInfo() {
	
		return info;
	}

	public void setInfo(String info) {
	
		this.info = info;
	}

	public List<Map<String, Object>> getListmap() {
	
		return listmap;
	}

	public void setListmap(List<Map<String, Object>> listmap) {
	
		this.listmap = listmap;
	}

	public List<Map<String, Object>> getSystemTypeList() {
	
		return systemTypeList;
	}

	public void setSystemTypeList(List<Map<String, Object>> systemTypeList) {
	
		this.systemTypeList = systemTypeList;
	}

	public IRedisUtil getRedisUtil() {
	
		return redisUtil;
	}

	public void setRedisUtil(IRedisUtil redisUtil) {
	
		this.redisUtil = redisUtil;
	}
}

