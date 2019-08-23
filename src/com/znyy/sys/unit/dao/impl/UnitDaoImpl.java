package com.znyy.sys.unit.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.XtUnit;
import com.znyy.sys.unit.dao.UnitDao;

@SuppressWarnings("unchecked")
public class UnitDaoImpl extends GenericDaoImpl<XtUnit, Long> implements UnitDao{
	
	@Override
	public List<Map<String, Object>> getMoreUnitSel(Integer userid,
			String hospitalcode, String moreunitflag) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT T.NAME AS TNAME, T.ID AS TID ");
		sql.append(" FROM XT_UNIT T ");
		sql.append(" LEFT JOIN XT_USER_UNIT X ");
		sql.append("   ON X.UNITID = T.ID ");
		sql.append("WHERE X.USERID =:USERID ");
		sql.append(" AND T.FLAG =:FLAG ");
		sql.append(" AND T.HOSPITAL_ID =:HOSPITALID ");
		if("9".equals(moreunitflag)){
			//无
			sql.append(" AND ROWNUM = 1 ");
		}else{
			//有
			sql.append(" AND T.TYPE =:FLAG ");
			sql.append(" AND T.YWFLAG =:YWFLAG ");
		}
		//门诊
		if("0".equals(moreunitflag)){
			paramMap.put("YWFLAG", "0");
		}
		//住院
		if("1".equals(moreunitflag)){
			paramMap.put("YWFLAG", "1");
		}
		paramMap.put("FLAG", "0");
		paramMap.put("USERID", userid);
		paramMap.put("HOSPITALID", hospitalcode);
		Query query = this.setQueryParametersOfSQL(sql.toString(), paramMap);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

}
