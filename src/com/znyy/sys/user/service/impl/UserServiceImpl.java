package com.znyy.sys.user.service.impl;
import java.util.List;
import java.util.Map;

import com.common.util.MD5;
import com.znyy.sys.user.dao.UserDao;
import com.znyy.sys.user.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	/**
	 * @方法名称: getUser
	 * @功能描述:
	 * @作者:慕金剑
	 * @创建时间:2015-12-11 上午9:04:34
	 * @param userid
	 * @param pwd
	 * @return
	 * @see com.znyy.sys.service.UserService#getUser(java.lang.String,
	 *      java.lang.String)
	 */
	public List<Map<String, Object>> getUser(String userid, String pwd) {
		pwd = MD5.convert(pwd);
		List<Map<String, Object>> zu = userDao.getUser(userid, pwd);
		if (null != zu && !zu.isEmpty()) {
			return zu;
		}
		return null;
	}
	public UserDao getUserDao() {
	
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
	
		this.userDao = userDao;
	}
}
