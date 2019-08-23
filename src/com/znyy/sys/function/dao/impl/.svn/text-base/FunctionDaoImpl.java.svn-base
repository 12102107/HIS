package com.znyy.sys.function.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.XtFunction;
import com.znyy.sys.function.dao.FunctionDao;

@SuppressWarnings("unchecked")
public class FunctionDaoImpl extends GenericDaoImpl<XtFunction, Integer>
		implements FunctionDao {

	/**
	 * @方法名称: getAllFunctions
	 * @功能描述:获取用户不同系统下的所有模块
	 * @作者:慕金剑
	 * @创建时间:2015-12-7 下午2:51:54
	 * @param sysid
	 * @return
	 * @see com.znyy.sys.dao.FunctionDao#getAllFunctions(java.lang.Integer,
	 *      java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getAllFunctions(String sysid) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT T.ID, ");
		sql.append("   T.NAME, ");
		sql.append("   T.PID, ");
		sql.append("   T.URL, ");
		sql.append("   T.FUN_LEVEL, ");
		sql.append("   (select count(XF.ID) ");
		sql.append("      from XT_FUNCTION XF ");
		sql.append("    WHERE XF.PID = T.ID ");
		sql.append("       AND XF.FLAG =:FLAG ");
		sql.append("       AND XF.SYSTEMID =:SYSID ");
		sql.append("       AND XF.FUN_LEVEL =:FUNLEVEL ) AS menu3 ");
		sql.append("FROM XT_FUNCTION T ");
		sql.append("WHERE T.FLAG =:FLAG ");
		sql.append(" AND T.SYSTEMID =:SYSID ");
		sql.append(" AND T.FUN_LEVEL <> :FUNLEVEL ");
		sql.append("ORDER BY T.FUN_LEVEL DESC, T.SORT ASC, T.ID ASC ");
		params.put("SYSID", sysid);
		params.put("FLAG", "0");
		params.put("FUNLEVEL", "3");
		Query query = this.setQueryParametersOfSQL(sql.toString(), params);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	/**
	 * @方法名称: getXtFunctions
	 * @功能描述:获取用户权限下的菜单id
	 * @作者:慕金剑
	 * @创建时间:2015-12-7 下午2:34:06
	 * @param sysid
	 *            系统id
	 * @param userid
	 *            用户编号
	 * @return
	 * @see com.znyy.sys.dao.FunctionDao#getXtFunctions(java.lang.Integer,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public List<String> getXtFunctions(String sysid, Integer userid) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		// 根据角色下权限汇总正常权限并得到模块id
		sql.append("SELECT DISTINCT TO_CHAR(T.FUNCTIONID) ");
		sql.append("  FROM XT_PERMISSION T ");
		sql.append(" WHERE T.ID IN (SELECT RP.PERID ");
		sql.append("     FROM XT_ROLE_PER RP ");
		sql.append("   WHERE RP.ROLEID IN (SELECT UR.ROLEID ");
		sql.append("                    FROM XT_USER_ROLE UR ");
		sql.append("                      LEFT JOIN XT_ROLE R ");
		sql.append("                              ON R.ID = UR.ROLEID ");
		sql.append("                            WHERE UR.USERID = :USERID ");
		sql.append("                              AND R.FLAG = :FLAG ");
		sql.append("                              AND R.SYSTEMID=:SYSTEMID ");
		sql.append("           )) ");
		sql.append("  AND T.FLAG = :FLAG ");
		params.put("USERID", userid);
		params.put("FLAG", "0");
		params.put("SYSTEMID", sysid);
		Query query = this.setQueryParametersOfSQL(sql.toString(), params);
		return query.list();
	}

	@Override
	public List findFunctionThree(Integer functionid) {

		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer();
		hql.append(" From XtFunction where pid = ? order by id");
		return this.getHibernateTemplate().find(hql.toString(), functionid);

	}
	
	/**
	 * @方法名称: getOracleSQLIn
	 * @功能描述: sql in方法 当参数过长 重新拼接
	 * @作者:杨云博
	 * @创建时间:2015-12-30 上午8:49:10
	 * @param ids
	 * @param count
	 * @param field
	 * @param params
	 * @param key
	 * @return String
	 */

	private String getOracleSQLIn(List<?> ids, int count, String field,
			Map<String, Object> params, String key) {
		count = Math.min(count, 1000);
		int len = ids.size();
		int size = len % count;
		if (size == 0) {
			size = len / count;
		} else {
			size = (len / count) + 1;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(" ( ");
		for (int i = 0; i < size; i++) {
			int fromIndex = i * count;
			int toIndex = Math.min(fromIndex + count, len);
			List<?> productId = ids.subList(fromIndex, toIndex);
			if (i != 0) {
				builder.append(" OR ");
			}
			builder.append(field).append(" IN (:").append(key + i).append(")");
			params.put(key + i, productId);
		}
		builder.append(" ) ");
		return builder.toString();
	}

	@Override
	public List<XtFunction> getThreeFunctions(Integer functionid, String sysid,List<String> rightFunids) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> params = new HashMap<String, Object>();
		hql.append("FROM XtFunction T ");
		hql.append("WHERE T.flag = :flag ");
		hql.append(" AND T.systemid = :sysid ");
		hql.append(" AND T.pid = :pid ");
		if (null != rightFunids && rightFunids.size() > 0) {
			List<Integer> intList=new ArrayList<Integer>();
			for(int i=0,j=rightFunids.size();i<j;i++){
				intList.add(Integer.parseInt(rightFunids.get(i)));   
			   }  
			hql.append(" AND ");
			hql.append(this.getOracleSQLIn(intList, 990, "T.id", params,"funid"));
		}
		params.put("flag", "0");
		params.put("pid", functionid);
		params.put("sysid", sysid);
		hql.append("  ORDER BY T.sort ASC, T.id ASC ");
		Query query = this.setQueryParameters(hql.toString(), params);
		return query.list();
	}

}