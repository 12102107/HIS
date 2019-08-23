package com.znyy.sm.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.XtUnit;
import com.znyy.sm.dao.TongJiDao;

@SuppressWarnings("unchecked")
public class TongJiDaoImpl extends GenericDaoImpl<SmRegOpt, String> implements
		TongJiDao {

	/**
	 * @方法名称: getMzlsList
	 * @功能描述:获取麻醉例数统计数据
	 * @作者:付士山
	 * @创建时间:2016-3-14 上午10:55:19
	 * @return
	 * @see com.znyy.sm.dao.TongJiDao#getMzlsList()
	 */

	@Override
	public List getMzlsList(String yishi, String dateFrom, String dateTo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List list = new ArrayList();
		if (yishi != null && !yishi.equals("") && dateFrom != null
				&& !dateFrom.equals("") && dateTo != null && !dateTo.equals("")) {
			String sql = " select sum(case when DESIGNED_ANAES_METHOD_NAME like '%+%' then 1 else 0 end) fu,"
					+ "  sum(case when DESIGNED_ANAES_METHOD_NAME  not like '%+%' and DESIGNED_ANAES_METHOD_NAME not like '全麻' then 1 else 0 end) jb, "
					+ " sum(case when DESIGNED_ANAES_METHOD_NAME like '全麻' then 1 else 0 end) quan,TO_CHAR(operdate, 'YYYY-MM')"
					+ " from SM_REG_OPT where operator_name like :yishi and operdate >= TO_Date('"
					+ dateFrom
					+ "', 'YYYY/MM/dd') and operdate <= TO_Date('"
					+ dateTo
					+ "', 'YYYY/MM/dd')"
					+ " group by  TO_CHAR(operdate, 'YYYY-MM') ";
			paramMap.put("yishi", "%" + yishi.trim() + "%");
			list = this.findBySql(sql, paramMap);
		} else if (dateFrom != null && !dateFrom.equals("") && dateTo != null
				&& !dateTo.equals("")) {
			String sql = " select sum(case when DESIGNED_ANAES_METHOD_NAME like '%+%' then 1 else 0 end) fu,"
					+ "  sum(case when DESIGNED_ANAES_METHOD_NAME  not like '%+%' and DESIGNED_ANAES_METHOD_NAME not like '全麻' then 1 else 0 end) jb, "
					+ " sum(case when DESIGNED_ANAES_METHOD_NAME like '全麻' then 1 else 0 end) quan,TO_CHAR(operdate, 'YYYY-MM')"
					+ " from SM_REG_OPT where operdate >= TO_Date('"
					+ dateFrom
					+ "', 'YYYY/MM/dd') and operdate <= TO_Date('"
					+ dateTo
					+ "', 'YYYY/MM/dd')"
					+ " group by  TO_CHAR(operdate, 'YYYY-MM') ";
			list = this.findBySql(sql, new HashMap());
		} else if (dateFrom != null && !dateFrom.equals("")) {
			String sql = " select sum(case when DESIGNED_ANAES_METHOD_NAME like '%+%' then 1 else 0 end) fu,"
					+ "  sum(case when DESIGNED_ANAES_METHOD_NAME  not like '%+%' and DESIGNED_ANAES_METHOD_NAME not like '全麻' then 1 else 0 end) jb, "
					+ " sum(case when DESIGNED_ANAES_METHOD_NAME like '全麻' then 1 else 0 end) quan,TO_CHAR(operdate, 'YYYY-MM')"
					+ " from SM_REG_OPT where TO_CHAR(operdate, 'YYYY-MM') like '%"
					+ dateFrom.substring(0, 7)
					+ "%'  group by  TO_CHAR(operdate, 'YYYY-MM') ";

			list = this.findBySql(sql, new HashMap());
		} else if (yishi != null && !yishi.equals("")) {
			String sql = " select sum(case when DESIGNED_ANAES_METHOD_NAME like '%+%' then 1 else 0 end) fu,"
					+ "  sum(case when DESIGNED_ANAES_METHOD_NAME  not like '%+%' and DESIGNED_ANAES_METHOD_NAME not like '全麻' then 1 else 0 end) jb, "
					+ " sum(case when DESIGNED_ANAES_METHOD_NAME like '全麻' then 1 else 0 end) quan,TO_CHAR(operdate, 'YYYY-MM')"
					+ " from SM_REG_OPT where operator_name like :yishi group by  TO_CHAR(operdate, 'YYYY-MM')";
			paramMap.put("yishi", "%" + yishi.trim() + "%");
			list = this.findBySql(sql, paramMap);
		}

		else {
			String sql = " select sum(case when DESIGNED_ANAES_METHOD_NAME like '%+%' then 1 else 0 end) fu,"
					+ "  sum(case when DESIGNED_ANAES_METHOD_NAME  not like '%+%' and DESIGNED_ANAES_METHOD_NAME not like '全麻' then 1 else 0 end) jb, "
					+ " sum(case when DESIGNED_ANAES_METHOD_NAME like '全麻' then 1 else 0 end) quan,TO_CHAR(operdate, 'YYYY-MM')"
					+ " from SM_REG_OPT group by  TO_CHAR(operdate, 'YYYY-MM') ";
			list = this.findBySql(sql, new HashMap());
		}
		return list;

	}

	@Override
	public List getMzlsListAll(String yishi, String dateFrom, String dateTo) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		List list = new ArrayList();
		if (yishi != null && !yishi.equals("") && dateFrom != null
				&& !dateFrom.equals("") && dateTo != null && !dateTo.equals("")) {
			String sql = " select sum(case when DESIGNED_ANAES_METHOD_NAME like '%+%' then 1 else 0 end) fu,"
					+ "  sum(case when DESIGNED_ANAES_METHOD_NAME  not like '%+%' and DESIGNED_ANAES_METHOD_NAME not like '全麻' then 1 else 0 end) jb, "
					+ " sum(case when DESIGNED_ANAES_METHOD_NAME like '全麻' then 1 else 0 end) quan "
					+ " from SM_REG_OPT where operator_name like :yishi and operdate >= TO_Date('"
					+ dateFrom
					+ "', 'YYYY/MM/dd') and operdate <= TO_Date('"
					+ dateTo + "', 'YYYY/MM/dd')";
			paramMap.put("yishi", "%" + yishi.trim() + "%");
			list = this.findBySql(sql, paramMap);
		} else if (dateFrom != null && !dateFrom.equals("") && dateTo != null
				&& !dateTo.equals("")) {
			String sql = " select sum(case when DESIGNED_ANAES_METHOD_NAME like '%+%' then 1 else 0 end) fu,"
					+ "  sum(case when DESIGNED_ANAES_METHOD_NAME  not like '%+%' and DESIGNED_ANAES_METHOD_NAME not like '全麻' then 1 else 0 end) jb, "
					+ " sum(case when DESIGNED_ANAES_METHOD_NAME like '全麻' then 1 else 0 end) quan "
					+ " from SM_REG_OPT where operdate >= TO_Date('"
					+ dateFrom
					+ "', 'YYYY/MM/dd') and operdate <= TO_Date('"
					+ dateTo
					+ "', 'YYYY/MM/dd')";
			list = this.findBySql(sql, new HashMap());
		} else if (dateFrom != null && !dateFrom.equals("")) {
			String sql = " select sum(case when DESIGNED_ANAES_METHOD_NAME like '%+%' then 1 else 0 end) fu,"
					+ "  sum(case when DESIGNED_ANAES_METHOD_NAME  not like '%+%' and DESIGNED_ANAES_METHOD_NAME not like '全麻' then 1 else 0 end) jb, "
					+ " sum(case when DESIGNED_ANAES_METHOD_NAME like '全麻' then 1 else 0 end) quan "
					+ " from SM_REG_OPT where TO_CHAR(operdate, 'YYYY-MM') like '%"
					+ dateFrom.substring(0, 7) + "%'";

			list = this.findBySql(sql, new HashMap());
		} else if (yishi != null && !yishi.equals("")) {
			String sql = " select sum(case when DESIGNED_ANAES_METHOD_NAME like '%+%' then 1 else 0 end) fu,"
					+ "  sum(case when DESIGNED_ANAES_METHOD_NAME  not like '%+%' and DESIGNED_ANAES_METHOD_NAME not like '全麻' then 1 else 0 end) jb, "
					+ " sum(case when DESIGNED_ANAES_METHOD_NAME like '全麻' then 1 else 0 end) quan "
					+ " from SM_REG_OPT where operator_name like :yishi";
			paramMap.put("yishi", "%" + yishi.trim() + "%");
			list = this.findBySql(sql, paramMap);
		}

		else {
			String sql = " select sum(case when DESIGNED_ANAES_METHOD_NAME like '%+%' then 1 else 0 end) fu,"
					+ "  sum(case when DESIGNED_ANAES_METHOD_NAME  not like '%+%' and DESIGNED_ANAES_METHOD_NAME not like '全麻' then 1 else 0 end) jb, "
					+ " sum(case when DESIGNED_ANAES_METHOD_NAME like '全麻' then 1 else 0 end) quan from SM_REG_OPT";
			list = this.findBySql(sql, new HashMap());
		}
		return list;

	}

	/**
	 * @author 白东旭
	 */
	public List<XtUnit> getSmDept() {
		String hql=" from XtUnit where flag=0 and type='0' and ywflag='1'";
		return this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * @author 白东旭
	 */
	public List<SmOperationPeople> getAnesthetist() {
		String hql = "from SmOperationPeople where role='手术麻醉医师' or role='巡台麻醉医师' or role='灌注医师'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * @author 白东旭
	 */
	public List<SmOperationPeople> getNurse() {
		String hql = "from SmOperationPeople where role='巡回护士' or role='器械护士'";
		return this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * @author 白东旭
	 * @throws ParseException 
	 */
	public List getAsaList(String asaDateFrom,String asaDateTo, String asake, String asayi, String asahu, String xuanze) throws ParseException {

		
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date start = f.parse(asaDateFrom);
		Date end = f.parse(asaDateTo);
		
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		
		StringBuffer sql = new StringBuffer("select count(t.id) from  sm_reg_opt s left join SM_PRE_VISIT t on t.operation_id=s.id where s.operdate >= :start and s.operdate <= :end");
		
		if("1".equals(xuanze)) {
			
			if(asake!=null&&!"".equals(asake)&&!"x".equals(asake)) {
				
				Map<String,String> m = new HashMap<String,String>();
				m.put("name", asake);
				
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("dept", asake);
				
				map.put("start", start);
				map.put("end", end);
				
				sql.append(" and s.dept = :dept");
				
				String str1 = sql.toString() + " and t.asa='1级'";
				String str2 = sql.toString() + " and t.asa='2级'";
				String str3 = sql.toString() + " and t.asa='3级'";
				String str4 = sql.toString() + " and t.asa='4级'";
				String str5 = sql.toString() + " and t.asa='5级'";
				String str6 = sql.toString() + " and t.asa='6级'";
				
				m.put("level1", this.findBySql(str1, map).get(0).toString());
				m.put("level2", this.findBySql(str2, map).get(0).toString());
				m.put("level3", this.findBySql(str3, map).get(0).toString());
				m.put("level4", this.findBySql(str4, map).get(0).toString());
				m.put("level5", this.findBySql(str5, map).get(0).toString());
				m.put("level6", this.findBySql(str6, map).get(0).toString());
				
				result.add(m);
				
			} else {
				
				List<XtUnit> list = this.getSmDept();
				
				sql.append(" and s.dept = :dept");
				
				for(XtUnit dept: list) {

					Map<String,String> m = new HashMap<String,String>();
					m.put("name", dept.getName());
					
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("dept",  dept.getName());
					
					map.put("start", start);
					map.put("end", end);
					
					String str1 = sql.toString() + " and t.asa='1级'";
					String str2 = sql.toString() + " and t.asa='2级'";
					String str3 = sql.toString() + " and t.asa='3级'";
					String str4 = sql.toString() + " and t.asa='4级'";
					String str5 = sql.toString() + " and t.asa='5级'";
					String str6 = sql.toString() + " and t.asa='6级'";
					
					m.put("level1", this.findBySql(str1, map).get(0).toString());
					m.put("level2", this.findBySql(str2, map).get(0).toString());
					m.put("level3", this.findBySql(str3, map).get(0).toString());
					m.put("level4", this.findBySql(str4, map).get(0).toString());
					m.put("level5", this.findBySql(str5, map).get(0).toString());
					m.put("level6", this.findBySql(str6, map).get(0).toString());
					
					result.add(m);
				}
			}
			
		} else if("2".equals(xuanze)) {
			
			if(asayi!=null&&!"".equals(asayi)&&!"x".equals(asayi)) {
				
				Map<String,String> m = new HashMap<String,String>();
				m.put("name", asayi);
				
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("sop", asayi);

				map.put("start", start);
				map.put("end", end);
				
				sql.append(" and (s.ANESTHETIST = :sop or s.ANAES_ASSISTANT = :sop or s.CIRCUANESTHETIST = :sop)");
				
				String str1 = sql.toString() + " and t.asa='1级'";
				String str2 = sql.toString() + " and t.asa='2级'";
				String str3 = sql.toString() + " and t.asa='3级'";
				String str4 = sql.toString() + " and t.asa='4级'";
				String str5 = sql.toString() + " and t.asa='5级'";
				String str6 = sql.toString() + " and t.asa='6级'";
				
				m.put("level1", this.findBySql(str1, map).get(0).toString());
				m.put("level2", this.findBySql(str2, map).get(0).toString());
				m.put("level3", this.findBySql(str3, map).get(0).toString());
				m.put("level4", this.findBySql(str4, map).get(0).toString());
				m.put("level5", this.findBySql(str5, map).get(0).toString());
				m.put("level6", this.findBySql(str6, map).get(0).toString());
				
				result.add(m);
				
			} else {
				
				List<SmOperationPeople> list = this.getAnesthetist();
				
				sql.append(" and (s.ANESTHETIST = :sop or s.ANAES_ASSISTANT = :sop or s.CIRCUANESTHETIST = :sop)");
				
				for(SmOperationPeople sop: list) {
					
					Map<String,String> m = new HashMap<String,String>();
					m.put("name", sop.getName());
					
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("sop", sop.getName());

					map.put("start", start);
					map.put("end", end);
					
					sql.append(" and (s.ANESTHETIST = :sop or s.ANAES_ASSISTANT = :sop or s.CIRCUANESTHETIST = :sop)");
					
					String str1 = sql.toString() + " and t.asa='1级'";
					String str2 = sql.toString() + " and t.asa='2级'";
					String str3 = sql.toString() + " and t.asa='3级'";
					String str4 = sql.toString() + " and t.asa='4级'";
					String str5 = sql.toString() + " and t.asa='5级'";
					String str6 = sql.toString() + " and t.asa='6级'";
					
					m.put("level1", this.findBySql(str1, map).get(0).toString());
					m.put("level2", this.findBySql(str2, map).get(0).toString());
					m.put("level3", this.findBySql(str3, map).get(0).toString());
					m.put("level4", this.findBySql(str4, map).get(0).toString());
					m.put("level5", this.findBySql(str5, map).get(0).toString());
					m.put("level6", this.findBySql(str6, map).get(0).toString());
					
					result.add(m);
				}
			}
		} else if("3".equals(xuanze)) {
			if(asahu!=null&&!"".equals(asahu)&&!"x".equals(asahu)) {
				
				Map<String,String> m = new HashMap<String,String>();
				m.put("name", asahu);
				
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("nurse", asahu);
				
				sql.append(" and (s.INSTRNURSE1 = :nurse or s.INSTRNURSE2 = :nurse or s.CIRCUNURSE1 = :nurse or s.CIRCUNURSE2 = :nurse)");
				
				map.put("start", start);
				map.put("end", end);
				
				String str1 = sql.toString() + " and t.asa='1级'";
				String str2 = sql.toString() + " and t.asa='2级'";
				String str3 = sql.toString() + " and t.asa='3级'";
				String str4 = sql.toString() + " and t.asa='4级'";
				String str5 = sql.toString() + " and t.asa='5级'";
				String str6 = sql.toString() + " and t.asa='6级'";
				
				m.put("level1", this.findBySql(str1, map).get(0).toString());
				m.put("level2", this.findBySql(str2, map).get(0).toString());
				m.put("level3", this.findBySql(str3, map).get(0).toString());
				m.put("level4", this.findBySql(str4, map).get(0).toString());
				m.put("level5", this.findBySql(str5, map).get(0).toString());
				m.put("level6", this.findBySql(str6, map).get(0).toString());
				
				result.add(m);
				
			} else {
				
				List<SmOperationPeople> list = this.getNurse();
				
				sql.append(" and (s.INSTRNURSE1 = :nurse or s.INSTRNURSE2 = :nurse or s.CIRCUNURSE1 = :nurse or s.CIRCUNURSE2 = :nurse)");
				
				for(SmOperationPeople sop: list) {
					
					Map<String,String> m = new HashMap<String,String>();
					m.put("name", sop.getName());
					
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("nurse", sop.getName());

					map.put("start", start);
					map.put("end", end);
					
					String str1 = sql.toString() + " and t.asa='1级'";
					String str2 = sql.toString() + " and t.asa='2级'";
					String str3 = sql.toString() + " and t.asa='3级'";
					String str4 = sql.toString() + " and t.asa='4级'";
					String str5 = sql.toString() + " and t.asa='5级'";
					String str6 = sql.toString() + " and t.asa='6级'";
					
					m.put("level1", this.findBySql(str1, map).get(0).toString());
					m.put("level2", this.findBySql(str2, map).get(0).toString());
					m.put("level3", this.findBySql(str3, map).get(0).toString());
					m.put("level4", this.findBySql(str4, map).get(0).toString());
					m.put("level5", this.findBySql(str5, map).get(0).toString());
					m.put("level6", this.findBySql(str6, map).get(0).toString());
					
					result.add(m);
				}
			}
		} else {
			return null;
		}
		return result;
	}

	
	 /** 
	 * @方法名称: getSqshList
	 * @功能描述:获取术前术后诊断统计数据
	 * @作者:付士山
	 * @创建时间:2016-3-22 下午2:42:40
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 * @see com.znyy.sm.dao.TongJiDao#getSqshList(java.lang.String, java.lang.String)
	 */
	 
	@Override
	public List getSqshList(String dateFrom, String dateTo,String xuanze) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List list = new ArrayList();
		if("1".equals(xuanze)){
			String sql = "select t.name,t.age,t.sex,t.region,t.preengagementnumber,t.bed, " +
					"t.diagnosis_name, n.latter_diag  from  SM_OPT_NURSE  N " +
					"LEFT JOIN SM_REG_OPT t  ON t.id=n.operation_id where t.operdate >= TO_Date('"
					+ dateFrom+ "', 'YYYY/MM/dd') and t.operdate <= TO_Date('"+ dateTo + "', 'YYYY/MM/dd') and  t.diagnosis_name!=n.latter_diag";
			list = this.findBySql(sql, new HashMap());}
		else if (dateFrom!=null&&!dateFrom.equals("")&&dateTo!=null&&!dateTo.equals("")) {
			String sql = "select t.name,t.age,t.sex,t.region,t.preengagementnumber,t.bed, " +
					"t.diagnosis_name, n.latter_diag  from  SM_OPT_NURSE  N " +
					"LEFT JOIN SM_REG_OPT t  ON t.id=n.operation_id where t.operdate >= TO_Date('"
					+ dateFrom+ "', 'YYYY/MM/dd') and t.operdate <= TO_Date('"+ dateTo + "', 'YYYY/MM/dd')";
			list = this.findBySql(sql, new HashMap());
		}else if (dateFrom!=null&&!dateFrom.equals("")) {
			String sql = "select t.name,t.age,t.sex,t.region,t.preengagementnumber,t.bed, " +
					"t.diagnosis_name, n.latter_diag  from  SM_OPT_NURSE  N " +
					"LEFT JOIN SM_REG_OPT t  ON t.id=n.operation_id where TO_CHAR(t.operdate, 'YYYY-MM') like '%"
					+ dateFrom.substring(0, 7) + "%'";
			list = this.findBySql(sql, new HashMap());
		} else {
			String sql = "select t.name,t.age,t.sex,t.region,t.preengagementnumber,t.bed, " +
					"t.diagnosis_name, n.latter_diag  from  SM_OPT_NURSE  N " +
					"LEFT JOIN SM_REG_OPT t  ON t.id=n.operation_id ";
			list = this.findBySql(sql, new HashMap());
		}
			
		return list;
		
	}

}