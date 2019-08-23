package com.znyy.sys.system.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.XtSystem;
import com.znyy.sys.system.dao.SystemDao;

 /** 
 * @类名称: HospitalDaoImpl
 * @类描述:系统表dao实现类
 * @作者:慕金剑
 * @创建时间:2016-3-21 下午4:22:28
 */
 
public class SystemDaoImpl extends GenericDaoImpl<XtSystem, String> implements SystemDao {

	@Override
	public List<Map<String, Object>> selectSystemList(String hoscode) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT T.ID ,T.NAME,T.IMG_PATH ,T.TYPE,T.URL,T.MOREUNIT  FROM XT_SYSTEM T WHERE T.FLAG =:FLAG AND T.HOSPITAL_ID =:HOSID ORDER BY T.TYPE,T.SORT";
		params.put("HOSID", hoscode);
		params.put("FLAG", "0");
		Query query = this.setQueryParametersOfSQL(sql, params);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	@Override
	public List<Map<String, Object>> selectSystemList(String hoscode,String uid) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT T1.* FROM (SELECT T.ID ,T.NAME,T.IMG_PATH ,T.TYPE,T.URL,T.MOREUNIT  FROM XT_SYSTEM T ");
		sql.append(" LEFT JOIN XT_ROLE R ON R.SYSTEMID = T.ID");
		sql.append(" LEFT JOIN XT_USER_ROLE U ON U.ROLEID = R.ID");
		sql.append(" WHERE T.FLAG = :FLAG AND T.HOSPITAL_ID =:HOSID AND R.FLAG = :FLAG AND U.USERID = :USERID ORDER BY T.TYPE,T.SORT ) T1");
		params.put("HOSID", hoscode);
		params.put("FLAG", "0");
		params.put("USERID", uid);
		Query query = this.setQueryParametersOfSQL(sql.toString(), params);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

}

