package com.znyy.sys.user.dao;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDAO;
import com.znyy.bean.XtUser;

public interface UserDao extends GenericDAO<XtUser, Integer> {

	/**
	 * 创建人:赵羽中 日期:2015-04-13 描述:根据登录名和密码判断用户登录是否正确
	 */
	List<Map<String, Object>> getUser(String userid, String pwd);

}
