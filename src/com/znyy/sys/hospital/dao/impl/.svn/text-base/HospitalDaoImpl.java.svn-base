package com.znyy.sys.hospital.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.XtHospital;
import com.znyy.sys.hospital.dao.HospitalDao;

 /** 
 * @类名称: HospitalDaoImpl
 * @类描述:系统医院表dao实现类
 * @作者:慕金剑
 * @创建时间:2016-3-21 下午4:22:28
 */
 
public class HospitalDaoImpl extends GenericDaoImpl<XtHospital, Short> implements HospitalDao {

	@Override
	public List<Map<String, Object>> getHospitalAll() {
		Map<String, Object> params=new HashMap<String, Object>();
		String sql = "SELECT ID,NAME,CODE FROM XT_HOSPITAL WHERE FLAG = '0' ";
	    Query query=this.setQueryParametersOfSQL(sql, params);
	    query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}


}

