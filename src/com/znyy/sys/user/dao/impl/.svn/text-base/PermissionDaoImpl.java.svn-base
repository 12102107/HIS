package com.znyy.sys.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.XtPermission;
import com.znyy.sys.user.dao.PermissionDao;

 /** 
 * @类名称: PermissionDaoImpl
 * @类描述:权限表Dao实现类
 * @作者:慕金剑
 * @创建时间:2015-12-7 下午2:39:58
 */
 
@SuppressWarnings("unchecked")
public class PermissionDaoImpl extends GenericDaoImpl<XtPermission, Integer>  implements PermissionDao{

	@Override
	public List<String> getBtnCode(Integer userid,
			String functionid,String sysid) {
		StringBuffer sql=new StringBuffer();
		Map<String, Object> params=new HashMap<String, Object>();
		sql.append("SELECT BTN.CODE ");
		sql.append("  FROM XT_FUN_BUTTON BTN ");
		sql.append(" WHERE BTN.FLAG = :FLAG ");
		sql.append("   AND BTN.ID IN ");
		sql.append("      (SELECT DISTINCT T.BTNID ");
		sql.append("         FROM XT_PERMISSION T ");
		sql.append("        WHERE T.FUNCTIONID = :FUNCTIONID ");
		sql.append("          AND T.ID IN ");
		sql.append("              ( SELECT RP.PERID ");
		sql.append("                 FROM XT_ROLE_PER RP ");
		sql.append("               WHERE RP.ROLEID IN (SELECT ROLEID ");
		sql.append("                                    FROM XT_USER_ROLE ");
		sql.append("                                   LEFT JOIN XT_ROLE R ");
		sql.append("                                    ON R.ID = ROLEID ");
		sql.append("                                 WHERE USERID = :USERID ");
		sql.append("                                   AND R.FLAG =:FLAG  ");
		sql.append("                                   AND R.SYSTEMID =:SYSID )) ");
		sql.append("      AND T.FLAG =:FLAG ) ");
		params.put("FLAG", "0");
		params.put("FUNCTIONID",functionid);
		params.put("USERID",userid);
		params.put("SYSID",sysid);
		return this.setQueryParametersOfSQL(sql.toString(), params).list();
	}
	@Override
	public List<String> getAllBtnCode(String funid) {
		StringBuffer sql=new StringBuffer();
		Map<String, Object> params=new HashMap<String, Object>();
		sql.append("SELECT BTN.CODE ");
		sql.append("  FROM XT_FUN_BUTTON BTN ");
		sql.append("  LEFT JOIN XT_PERMISSION T ");
		sql.append("    ON T.BTNID = BTN.ID ");
		sql.append(" WHERE BTN.FLAG =:FLAG ");
		sql.append("   AND T.FUNCTIONID =:FUNID ");
		sql.append("   AND T.FLAG =:FLAG ");
		params.put("FLAG", "0");
		params.put("FUNID", funid);
		return setQueryParametersOfSQL(sql.toString(), params).list();
	}
}
