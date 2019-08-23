/**  
 * @Title: ArrangeDaoImpl.java 
 * @Package com.znyy.sm.dao.impl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-23 下午1:24:32 
 */ 
package com.znyy.sm.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.dao.ArrangeDao;

/** 
 * @ClassName: ArrangeDaoImpl 
 * @Description: 排班管理dao实现类 
 * @author 白东旭
 * @date 2016-2-23 下午1:24:32 
 */
public class ArrangeDaoImpl extends GenericDaoImpl<SmRegOpt, String> implements ArrangeDao {

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.ArrangeDao#getMyArrangeByDay(java.util.Date, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getMyArrangeByDay(Date parse, String userid) {
		
		String name = this.getNameByUserid(userid);
		
		String sql = "select t.id,t.name s,t.sex,t.age,t.age_mon,t.region,t.bed,t.diagnosis_name,t.designed_opt_name,t.designed_anaes_method_name,t.operator_name,t.state,t.type,t.hid," +
				" t.INSTRNURSE1,t.INSTRNURSE2,t.CIRCUNURSE1,t.CIRCUNURSE2,t.ANAES_ASSISTANT,t.ANESTHETIST,t.CIRCUANESTHETIST, " +
				" room.name r,t.starttime"+
				" from SM_REG_OPT t left join SM_OPERROOM room on room.id=t.room where t.operdate = :time and (t.INSTRNURSE1=:name or t.INSTRNURSE2=:name or t.CIRCUNURSE1=:name or t.CIRCUNURSE2=:name or t.ANAES_ASSISTANT=:name or t.CIRCUANESTHETIST=:name or t.ANESTHETIST=:name or t.operator_id like :userid) order by t.id";
		Map m = new HashMap();
		m.put("time", parse);
		m.put("userid", "%"+userid+"%");
		m.put("name", name);
		List l = this.findBySql(sql, m);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (Object obj:l) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", o[0]);
			map.put("name", o[1]);
			map.put("sex", o[2]);
			if(o[3]!=null&&!o[3].equals("")) {
				if(o[4]!=null&&!o[4].equals("")) {
					map.put("age", o[3].toString()+"岁 "+o[4].toString()+"月");
				} else {
					map.put("age", o[3].toString()+"岁 ");
				}
			} else {
				map.put("age", "");
			}
			map.put("region", o[5]);
			map.put("bed", o[6]);
			map.put("diagnosisName", o[7]);
			map.put("designedOptName", o[8]);
			map.put("designedAnaesMethodName", o[9]);
			map.put("operatorName", o[10]);
			map.put("state", o[11]);
			map.put("type", o[12]);
			map.put("hid", o[13]);
			
			map.put("instrnurse1", o[14]);
			map.put("instrnurse2", o[15]);
			map.put("circunurse1", o[16]);
			map.put("circunurse2", o[17]);
			map.put("anaesAssistant", o[18]);
			map.put("anesthetist", o[19]);
			map.put("circuanesthetist", o[20]);
			
			if(name.equals(o[14])) {
				map.put("role", "第一巡回护士");
			}
			if(o[15]!=null&&name.equals(o[15])) {
				map.put("role", "第二巡回护士");
			}
			if(name.equals(o[16])) {
				map.put("role", "第一器械护士");
			}
			if(name.equals(o[17])) {
				map.put("role", "第二器械护士");
			}
			if(name.equals(o[18])) {
				map.put("role", "灌注医师");
			}
			if(name.equals(o[19])) {
				map.put("role", "手术麻醉医师");
			}
			if(name.equals(o[20])) {
				map.put("role", "巡台麻醉医师");
			}
			String[] opname = o[10].toString().split(", ");
			for(String s:opname) {
				if(s.equals(name)) {
					map.put("role", "手术医师");
				}
			}
			
			map.put("room", o[21]);
			map.put("starttime", o[22]);
			
			result.add(map);
		}
		return result;
	}

	public String getNameByUserid(String userid) {
		String sql = "select sp.name from SM_OPERATION_PEOPLE sp left join XT_USER u on sp.code=u.id where u.id=?";
		String name = (String) this.findBySql(sql, new Object[]{userid}).get(0);
		return name;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.ArrangeDao#getArrangeByDay(java.util.Date)
	 */
	@Override
	public List<Map<String, Object>> getArrangeByDay(Date parse,String dateFrom, String dateTo) {
		String sql=null;
		Map m = new HashMap();
		if (dateFrom != null && !dateFrom.equals("")&&dateTo != null && !dateTo.equals("")) { 
			sql = "select t.operdate,room.name r,t.name s,t.sex,t.age,t.age_mon,t.hid,t.region,t.bed,t.designed_opt_name,t.designed_anaes_method_name,"+
						" t.INSTRNURSE1,t.INSTRNURSE2,t.CIRCUNURSE1,t.CIRCUNURSE2,t.ANAES_ASSISTANT,t.ANESTHETIST,t.CIRCUANESTHETIST,t.operator_name,t.type"+
						" from SM_REG_OPT t left join SM_OPERROOM room on room.id=t.room where t.operdate >= TO_Date('"
					+ dateFrom+ "', 'YYYY/MM/dd') and t.operdate <= TO_Date('"+ dateTo + "', 'YYYY/MM/dd') and t.state='03' order by t.operdate,t.starttime";}
		else {
			sql = "select t.operdate,room.name r,t.name s,t.sex,t.age,t.age_mon,t.hid,t.region,t.bed,t.designed_opt_name,t.designed_anaes_method_name,"+
					" t.INSTRNURSE1,t.INSTRNURSE2,t.CIRCUNURSE1,t.CIRCUNURSE2,t.ANAES_ASSISTANT,t.ANESTHETIST,t.CIRCUANESTHETIST,t.operator_name,t.type"+
					" from SM_REG_OPT t left join SM_OPERROOM room on room.id=t.room where t.operdate = :time and t.state='03' order by t.operdate,t.starttime";
			m.put("time", parse);
		}
		
		
		List l = this.findBySql(sql, m);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (Object obj:l) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("operdate", o[0]);
			map.put("room", o[1]);
			map.put("name", o[2]);
			map.put("sex", o[3]);
			if(o[4]!=null&&!o[4].equals("")) {
				if(o[5]!=null&&!o[5].equals("")) {
					map.put("age", o[4].toString()+"岁 "+o[5].toString()+"月");
				} else {
					map.put("age", o[4].toString()+"岁 ");
				}
			} else {
				map.put("age", "");
			}
			map.put("hid", o[6]);
			map.put("bed", o[8]);
			map.put("region", o[7]);
			map.put("designedOptName", o[9]);
			map.put("designedAnaesMethodName", o[10]);
			if(o[11]!=null&&!o[11].equals("")) {
				if(o[12]!=null&&!o[12].equals("")) {
					map.put("instrnurse", o[11].toString()+", "+o[12].toString());
				} else {
					map.put("instrnurse", o[11].toString());
				}
			} else {
				map.put("instrnurse", "");
			}
			if(o[13]!=null&&!o[13].equals("")) {
				if(o[14]!=null&&!o[14].equals("")) {
					map.put("circunurse", o[13].toString()+", "+o[14].toString());
				} else {
					map.put("circunurse", o[13].toString());
				}
			} else {
				map.put("circunurse", "");
			}
			map.put("anaesAssistant", o[15]);
			map.put("anesthetist", o[16]);
			map.put("circuanesthetist", o[17]);
			map.put("operatorName", o[18]);
			map.put("type", o[19]);
			
			result.add(map);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.ArrangeDao#getArrangeByDayPrint(java.util.Date)
	 */
	@Override
	public List<Map<String, Object>> getArrangeByDayPrint(Date parse) {
		String sql = "select t.operdate,room.name r,t.name s,NVL(t.sex,'x'),t.age,t.age_mon,NVL(t.hid,'0'),NVL(t.region,'x'),NVL(t.bed,'x'),NVL(t.designed_opt_name,'x'),NVL(t.designed_anaes_method_name,'x'),"+
				" t.INSTRNURSE1,t.INSTRNURSE2,t.CIRCUNURSE1,t.CIRCUNURSE2,NVL(t.ANAES_ASSISTANT,'x'),NVL(t.ANESTHETIST,'x'),NVL(t.CIRCUANESTHETIST,'x'),t.operator_name,t.type"+
				" from SM_REG_OPT t left join SM_OPERROOM room on room.id=t.room where t.operdate = :time order by t.operdate,t.starttime";
		Map m = new HashMap();
		m.put("time", parse);
		List l = this.findBySql(sql, m);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (Object obj:l) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("OPERDATE", o[0]);
			map.put("R", o[1]);
			map.put("S", o[2]);
			if("0".equals(o[3])) {
				map.put("SEX", "男");
			}
			if("1".equals(o[3])) {
				map.put("SEX", "女");
			}
			if(o[4]!=null&&!o[4].equals("")) {
				if(o[5]!=null&&!o[5].equals("")) {
					map.put("AGE", o[4].toString()+"岁 "+o[5].toString()+"月");
				} else {
					map.put("AGE", o[4].toString()+"岁 ");
				}
			} else {
				map.put("AGE", "");
			}
			if(!o[6].equals("0")) {
				map.put("HID", o[6]);
			}
			if(!o[8].equals("x")) {
				map.put("BED", o[8]);
			}
			if(!o[7].equals("x")) {
				map.put("REGION", o[7]);
			}
			if(!o[9].equals("x")) {
				map.put("DESIGNED_OPT_NAME", o[9]);
			}
			if(!o[10].equals("x")) {
				map.put("DESIGNED_ANAES_METHOD_NAME", o[10]);
			}
			if(o[11]!=null&&!o[11].equals("")) {
				if(o[12]!=null&&!o[12].equals("")) {
					map.put("INSTRNURSE1", o[11].toString()+", "+o[12].toString());
				} else {
					map.put("INSTRNURSE1", o[11].toString());
				}
			} else {
				map.put("INSTRNURSE1", "");
			}
			if(o[13]!=null&&!o[13].equals("")) {
				if(o[14]!=null&&!o[14].equals("")) {
					map.put("CIRCUNURSE1", o[13].toString()+", "+o[14].toString());
				} else {
					map.put("CIRCUNURSE1", o[13].toString());
				}
			} else {
				map.put("CIRCUNURSE1", "");
			}
			if(!o[15].equals("x")) {
				map.put("ANAES_ASSISTANT", o[15]);
			}
			if(!o[16].equals("x")) {
				map.put("ANESTHETIST", o[16]);
			}
			if(!o[17].equals("x")) {
				map.put("CIRCUANESTHETIST", o[17]);
			}
			if(!o[18].equals("x")) {
				map.put("OPERATOR_NAME", o[18]);
			}
	
			result.add(map);
		}
		return result;
	}
}
