package com.znyy.sys.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.XtUser;
import com.znyy.sys.user.dao.UserDao;




@SuppressWarnings("unchecked")
public class UserDaoImpl extends GenericDaoImpl<XtUser, Integer> implements UserDao {

	/**
	 * @方法名称: getUser
	 * @功能描述:根据登录名和密码判断用户登录是否正确
	 * @作者:慕金剑
	 * @创建时间:2015-12-11 上午9:35:39
	 * @param userid
	 * @param pwd
	 * @return
	 * @see com.znyy.sys.dao.UserDao#getUser(java.lang.String, java.lang.String)
	 */
	public List<Map<String, Object>> getUser(String userid, String pwd) {
		String sql = "SELECT L.HOSPITAL_ID,L.USERID,X.NAME,X.ID FROM XT_USER X LEFT JOIN XT_USER_LOGIN L ON L.USERID = X.ID WHERE (X.STATUS = '0' OR X.STATUS = '1') AND X.FLAG = '0' AND L.FLAG = '0' AND L.NAME = :USERID AND L.PWD = :PWD ";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("USERID", userid);
		params.put("PWD", pwd);
		Query query=this.setQueryParametersOfSQL(sql, params);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

}
