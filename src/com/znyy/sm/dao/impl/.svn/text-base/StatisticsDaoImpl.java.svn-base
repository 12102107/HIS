/**  
 * @Title: StatisticsDaoImpl.java 
 * @Package com.znyy.sm.dao.impl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-3-15 下午1:36:23 
 */ 
package com.znyy.sm.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.XtUnit;
import com.znyy.sm.dao.StatisticsDao;

/** 
 * @ClassName: StatisticsDaoImpl 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-3-15 下午1:36:23 
 */
public class StatisticsDaoImpl extends GenericDaoImpl<SmRegOpt, String> implements
		StatisticsDao {

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getSmDept()
	 */
	@Override
	public List<XtUnit> getSmDept() {
		String hql=" from XtUnit where flag=0 and type='0' and ywflag='1'";
		return this.getHibernateTemplate().find(hql);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getAnesthetist()
	 */
	@Override
	public List<SmOperationPeople> getAnesthetist() {
		String hql = "from SmOperationPeople where role='手术麻醉医师' or role='巡台麻醉医师' or role='灌注医师'";
		return this.getHibernateTemplate().find(hql);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getNurse()
	 */
	@Override
	public List<SmOperationPeople> getNurse() {
		String hql = "from SmOperationPeople where role='巡回护士' or role='器械护士'";
		return this.getHibernateTemplate().find(hql);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getLevelStatistics(java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getLevelStatistics(Date start, Date end,
			String sType, String deptname, String sopname, String nursename) {
		
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		
		StringBuffer sql = new StringBuffer("select count(t.id) from SM_REG_OPT t where t.operdate >= :start and t.operdate <= :end");
		
		if("0".equals(sType)) {
			
			if(deptname!=null&&!"".equals(deptname)&&!"x".equals(deptname)) {
				
				Map<String,String> m = new HashMap<String,String>();
				m.put("name", deptname);
				
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("dept", deptname);
				
				map.put("start", start);
				map.put("end", end);
				
				sql.append(" and t.dept = :dept");
				
				String str1 = sql.toString() + " and t.opt_level = '1'";
				String str2 = sql.toString() + " and t.opt_level = '2'";
				String str3 = sql.toString() + " and t.opt_level = '3'";
				String str4 = sql.toString() + " and t.opt_level = '4'";
				
				m.put("level1", this.findBySql(str1, map).get(0).toString());
				m.put("level2", this.findBySql(str2, map).get(0).toString());
				m.put("level3", this.findBySql(str3, map).get(0).toString());
				m.put("level4", this.findBySql(str4, map).get(0).toString());
				
				result.add(m);
				
			} else {
				
				List<XtUnit> list = this.getSmDept();
				
				sql.append(" and t.dept = :dept");
				
				for(XtUnit dept: list) {

					Map<String,String> m = new HashMap<String,String>();
					m.put("name", dept.getName());
					
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("dept",  dept.getName());
					
					map.put("start", start);
					map.put("end", end);
					
					String str1 = sql.toString() + " and t.opt_level = '1'";
					String str2 = sql.toString() + " and t.opt_level = '2'";
					String str3 = sql.toString() + " and t.opt_level = '3'";
					String str4 = sql.toString() + " and t.opt_level = '4'";
					
					m.put("level1", this.findBySql(str1, map).get(0).toString());
					m.put("level2", this.findBySql(str2, map).get(0).toString());
					m.put("level3", this.findBySql(str3, map).get(0).toString());
					m.put("level4", this.findBySql(str4, map).get(0).toString());
					
					result.add(m);
				}
			}
			
		} else if("1".equals(sType)) {
			
			if(sopname!=null&&!"".equals(sopname)&&!"x".equals(sopname)) {
				
				Map<String,String> m = new HashMap<String,String>();
				m.put("name", sopname);
				
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("sop", sopname);

				map.put("start", start);
				map.put("end", end);
				
				sql.append(" and (t.ANESTHETIST = :sop or t.ANAES_ASSISTANT = :sop or t.CIRCUANESTHETIST = :sop)");
				
				String str1 = sql.toString() + " and t.opt_level = '1'";
				String str2 = sql.toString() + " and t.opt_level = '2'";
				String str3 = sql.toString() + " and t.opt_level = '3'";
				String str4 = sql.toString() + " and t.opt_level = '4'";
				
				m.put("level1", this.findBySql(str1, map).get(0).toString());
				m.put("level2", this.findBySql(str2, map).get(0).toString());
				m.put("level3", this.findBySql(str3, map).get(0).toString());
				m.put("level4", this.findBySql(str4, map).get(0).toString());
				
				result.add(m);
				
			} else {
				
				List<SmOperationPeople> list = this.getAnesthetist();
				
				sql.append(" and (t.ANESTHETIST = :sop or t.ANAES_ASSISTANT = :sop or t.CIRCUANESTHETIST = :sop)");
				
				for(SmOperationPeople sop: list) {
					
					Map<String,String> m = new HashMap<String,String>();
					m.put("name", sop.getName());
					
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("sop", sop.getName());

					map.put("start", start);
					map.put("end", end);
					
					String str1 = sql.toString() + " and t.opt_level = '1'";
					String str2 = sql.toString() + " and t.opt_level = '2'";
					String str3 = sql.toString() + " and t.opt_level = '3'";
					String str4 = sql.toString() + " and t.opt_level = '4'";
					
					m.put("level1", this.findBySql(str1, map).get(0).toString());
					m.put("level2", this.findBySql(str2, map).get(0).toString());
					m.put("level3", this.findBySql(str3, map).get(0).toString());
					m.put("level4", this.findBySql(str4, map).get(0).toString());
					
					result.add(m);
				}
			}
		} else if("2".equals(sType)) {
			if(nursename!=null&&!"".equals(nursename)&&!"x".equals(nursename)) {
				
				Map<String,String> m = new HashMap<String,String>();
				m.put("name", nursename);
				
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("nurse", nursename);

				map.put("start", start);
				map.put("end", end);
				
				sql.append(" and (t.INSTRNURSE1 = :nurse or t.INSTRNURSE2 = :nurse or t.CIRCUNURSE1 = :nurse or t.CIRCUNURSE2 = :nurse)");
				
				String str1 = sql.toString() + " and t.opt_level = '1'";
				String str2 = sql.toString() + " and t.opt_level = '2'";
				String str3 = sql.toString() + " and t.opt_level = '3'";
				String str4 = sql.toString() + " and t.opt_level = '4'";
				
				m.put("level1", this.findBySql(str1, map).get(0).toString());
				m.put("level2", this.findBySql(str2, map).get(0).toString());
				m.put("level3", this.findBySql(str3, map).get(0).toString());
				m.put("level4", this.findBySql(str4, map).get(0).toString());
				
				result.add(m);
				
			} else {
				
				List<SmOperationPeople> list = this.getNurse();
				
				sql.append(" and (t.INSTRNURSE1 = :nurse or t.INSTRNURSE2 = :nurse or t.CIRCUNURSE1 = :nurse or t.CIRCUNURSE2 = :nurse)");
				
				for(SmOperationPeople sop: list) {
					
					Map<String,String> m = new HashMap<String,String>();
					m.put("name", sop.getName());
					
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("nurse", sop.getName());

					map.put("start", start);
					map.put("end", end);
					
					String str1 = sql.toString() + " and t.opt_level = '1'";
					String str2 = sql.toString() + " and t.opt_level = '2'";
					String str3 = sql.toString() + " and t.opt_level = '3'";
					String str4 = sql.toString() + " and t.opt_level = '4'";
					
					m.put("level1", this.findBySql(str1, map).get(0).toString());
					m.put("level2", this.findBySql(str2, map).get(0).toString());
					m.put("level3", this.findBySql(str3, map).get(0).toString());
					m.put("level4", this.findBySql(str4, map).get(0).toString());
					
					result.add(m);
				}
			}
		} else {
			return null;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getWorkingTime(java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getWorkingTime(Date start, Date end,
			String sType, String deptname, String sopname, String nursename) {
		
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		
		StringBuffer sqlAnaes = new StringBuffer("select nvl(sum(ROUND(TO_NUMBER(a.ANAES_END_TIME - a.ANAES_START_TIME) * 24 * 60)),'0') from SM_ANAES_RECORD a left join Sm_Reg_Opt t on t.id=a.operation_id where t.operdate >= :start and t.operdate <= :end");
		StringBuffer sqlOpt = new StringBuffer("select nvl(sum(ROUND(TO_NUMBER(a.OPT_END_TIME - a.OPT_START_TIME) * 24 * 60)),'0') from SM_ANAES_RECORD a left join Sm_Reg_Opt t on t.id=a.operation_id where t.operdate >= :start and t.operdate <= :end");
		
		if("0".equals(sType)) {
			
			sqlAnaes.append(" and t.dept = :dept");
			sqlOpt.append(" and t.dept = :dept");
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("start", start);
			map.put("end", end);
			
			if(deptname!=null&&!"".equals(deptname)&&!"x".equals(deptname)) {
				
				Map<String,String> m = new HashMap<String,String>();
				m.put("name", deptname);

				map.put("dept", deptname);
				
				m.put("anaestheticTime", this.findBySql(sqlAnaes.toString(), map).get(0).toString());
				m.put("surgeryTime", this.findBySql(sqlOpt.toString(), map).get(0).toString());
				
				result.add(m);
				
			} else {
				
				List<XtUnit> list = this.getSmDept();
				
				for(XtUnit dept: list) {

					Map<String,String> m = new HashMap<String,String>();
					m.put("name", dept.getName());
					
					map.put("dept",  dept.getName());
					
					m.put("anaestheticTime", this.findBySql(sqlAnaes.toString(), map).get(0).toString());
					m.put("surgeryTime", this.findBySql(sqlOpt.toString(), map).get(0).toString());
					
					result.add(m);
				}
			}
			
		} else if("1".equals(sType)) {
			
			sqlAnaes.append(" and (t.ANESTHETIST = :sop or t.ANAES_ASSISTANT = :sop or t.CIRCUANESTHETIST = :sop)");
			sqlOpt.append(" and (t.ANESTHETIST = :sop or t.ANAES_ASSISTANT = :sop or t.CIRCUANESTHETIST = :sop)");
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("start", start);
			map.put("end", end);
			
			if(sopname!=null&&!"".equals(sopname)&&!"x".equals(sopname)) {
				
				Map<String,String> m = new HashMap<String,String>();
				m.put("name", sopname);
				
				map.put("sop", sopname);

				m.put("anaestheticTime", this.findBySql(sqlAnaes.toString(), map).get(0).toString());
				m.put("surgeryTime", this.findBySql(sqlOpt.toString(), map).get(0).toString());
				
				result.add(m);
				
			} else {
				
				List<SmOperationPeople> list = this.getAnesthetist();
				
				for(SmOperationPeople sop: list) {
					
					Map<String,String> m = new HashMap<String,String>();
					m.put("name", sop.getName());

					map.put("sop", sop.getName());
					
					m.put("anaestheticTime", this.findBySql(sqlAnaes.toString(), map).get(0).toString());
					m.put("surgeryTime", this.findBySql(sqlOpt.toString(), map).get(0).toString());
					
					result.add(m);
				}
			}
		} else if("2".equals(sType)) {
			
			sqlAnaes.append(" and (t.INSTRNURSE1 = :nurse or t.INSTRNURSE2 = :nurse or t.CIRCUNURSE1 = :nurse or t.CIRCUNURSE2 = :nurse)");
			sqlOpt.append(" and (t.INSTRNURSE1 = :nurse or t.INSTRNURSE2 = :nurse or t.CIRCUNURSE1 = :nurse or t.CIRCUNURSE2 = :nurse)");
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("start", start);
			map.put("end", end);
			
			if(nursename!=null&&!"".equals(nursename)&&!"x".equals(nursename)) {
				
				Map<String,String> m = new HashMap<String,String>();
				m.put("name", nursename);

				map.put("nurse", nursename);
				
				m.put("anaestheticTime", this.findBySql(sqlAnaes.toString(), map).get(0).toString());
				m.put("surgeryTime", this.findBySql(sqlOpt.toString(), map).get(0).toString());
				
				result.add(m);
				
			} else {
				
				List<SmOperationPeople> list = this.getNurse();

				for(SmOperationPeople sop: list) {
					
					Map<String,String> m = new HashMap<String,String>();
					m.put("name", sop.getName());
					
					map.put("nurse", sop.getName());
					
					m.put("anaestheticTime", this.findBySql(sqlAnaes.toString(), map).get(0).toString());
					m.put("surgeryTime", this.findBySql(sqlOpt.toString(), map).get(0).toString());
					
					result.add(m);
				}
			}
		} else {
			return null;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getAnalgesiaStatistics(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Object> getAnalgesiaStatistics(Date start,
			Date end) {
		StringBuffer sql = new StringBuffer("select count(t.id) from SM_ANAES_RECORD t where t.CREATE_TIME >= :start and t.CREATE_TIME <= :end and t.ANALGESIA='01'");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		return this.findBySql(sql.toString(), map);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getCprStatistics(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Object> getCprStatistics(Date start, Date end) {
		StringBuffer sql = new StringBuffer("select count(t.id) from SM_ANAES_RECORD t where t.CREATE_TIME >= :start and t.CREATE_TIME <= :end and t.CPR='01'");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		return this.findBySql(sql.toString(), map);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getRecoveryStatistics(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Object> getRecoveryStatistics(Date start, Date end) {
		StringBuffer sql = new StringBuffer("select count(t.id) from SM_OUT_ROOM_STATUS t left join SM_REG_OPT sro on sro.id=t.operation_id where sro.operdate >= :start and sro.operdate <= :end and t.leave_to='01'");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		return this.findBySql(sql.toString(), map);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getNissStatistics(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Object> getNissStatistics(Date start, Date end) {
		StringBuffer sql = new StringBuffer("select niss,count(niss) from ");
		sql.append("(select ( ");
		sql.append("CASE WHEN ceil(to_number(s1.OPT_START_TIME-s1.OPT_END_TIME)*24)>=3 THEN 1 ELSE 0 END + ");
		sql.append("CASE WHEN s1.incision_cleanliness>='02' THEN 1 ELSE 0 END + ");
		sql.append("CASE WHEN p.asa>='2级' THEN 1 ELSE 0 END  ) as niss ");
		sql.append("from SM_ANAES_RECORD s1 ");
		sql.append("left join Sm_Reg_Opt sro on sro.id=s1.operation_id left join SM_PRE_VISIT p on p.operation_id=sro.id "); 
		sql.append("where sro.state='05' and sro.operdate >= :start and sro.operdate <= :end ) t group by niss order by niss");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		return this.findBySql(sql.toString(), map);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getMethod()
	 */
	@Override
	public List<Object> getMethod() {
		StringBuffer sql = new StringBuffer("select name from SM_ANAES_METHOD where IS_VALID='0'");
		return this.findBySql(sql.toString(), new HashMap<String,Object>());
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getMethodStatisticsDept(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Object> getMethodStatisticsDept(String start, String end,
			String method, String deptname) {
		StringBuffer sql = new StringBuffer("select count(t.type),t.type from SM_REG_OPT t where t.DESIGNED_ANAES_METHOD_NAME like :method and to_char(operdate,'yyyy-mm-dd') >= :start and to_char(operdate,'yyyy-mm-dd') <= :end and t.dept=:dept group by t.type order by t.type");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("method","%"+method+"%");
		map.put("dept", deptname);
		return this.findBySql(sql.toString(), map);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.StatisticsDao#getMethodStatisticsSop(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Object> getMethodStatisticsSop(String start, String end,
			String method, String sopname) {
		StringBuffer sql = new StringBuffer("select count(type),type from SM_REG_OPT t where DESIGNED_ANAES_METHOD_NAME like :method and to_char(operdate,'yyyy-mm-dd') >= :start and to_char(operdate,'yyyy-mm-dd') <= :end and (t.ANESTHETIST = :sop or t.ANAES_ASSISTANT = :sop or t.CIRCUANESTHETIST = :sop) group by type order by type");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("method","%"+method+"%");
		map.put("sop", sopname);
		return this.findBySql(sql.toString(), map);
	}
	
}
