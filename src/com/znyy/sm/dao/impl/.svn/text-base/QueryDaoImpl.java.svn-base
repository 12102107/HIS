/**  
 * @Title: QueryDaoImpl.java 
 * @Package com.znyy.sm.dao.impl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-19 上午9:21:24 
 */ 
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
import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SysDiseaseArea;
import com.znyy.sm.dao.QueryDao;

/** 
 * @ClassName: QueryDaoImpl 
 * @Description: 手术查询Dao接口实现类 
 * @author 白东旭
 * @date 2016-2-19 上午9:21:24 
 */
public class QueryDaoImpl extends GenericDaoImpl<SmRegOpt, String> implements QueryDao {

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#getSroByDay(java.util.Date)
	 */
	@Override
	public List<Map<String, Object>> getSroByDay(Date time,String hospitalId) {
		String sql = "select t.id,t.name,t.sex,t.age,t.age_mon,t.region,t.bed,t.diagnosis_name,t.designed_opt_name,t.designed_anaes_method_name,t.operator_name,t.preengagementnumber,t.state,t.type,t.hid" +
				" from SM_REG_OPT t where t.operdate = :time and t.hospital_id=:h order by t.id";
		Map m = new HashMap();
		m.put("time", time);
		m.put("h", hospitalId);
		List l = this.findBySql(sql, m);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (Object obj:l) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", o[0]);
			map.put("name", o[1]);
			map.put("sex", o[2]);
			String age = "";
			if(o[3]!=null) {
				age += o[3].toString()+"岁 ";
				if(o[4]!=null) {
					age += o[4].toString()+"月";
				}
			}
			map.put("age", age);
			map.put("region", o[5]);
			map.put("bed", o[6]);
			map.put("diagnosisName", o[7]);
			map.put("designedOptName", o[8]);
			map.put("designedAnaesMethodName", o[9]);
			map.put("operatorName", o[10]);
			map.put("preengagementnumber", o[11]);
			map.put("state", o[12]);
			map.put("type", o[13]);
			map.put("hid", o[14]);
			result.add(map);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#getSmRegOptById(java.lang.String)
	 */
	@Override
	public SmRegOpt getSmRegOptById(String sroid) {
		return this.get(sroid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#saveSmRegOpt(com.znyy.bean.SmRegOpt)
	 */
	@Override
	public void saveSmRegOpt(SmRegOpt sro) {
		this.save(sro);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#getSmDiagnosedefList()
	 */
	@Override
	public List<SmDiagnosedef> getSmDiagnosedefList() {
		return this.getHibernateTemplate().find("from SmDiagnosedef where enable = '0'");
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#getSmOperdefList()
	 */
	@Override
	public List<SmOperdef> getSmOperdefList() {
		return this.getHibernateTemplate().find("from SmOperdef where enable = '0'");
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#getSmOperationPeopleList(java.lang.String)
	 */
	@Override
	public List<SmOperationPeople> getSmOperationPeopleList(String string) {
		return this.getHibernateTemplate().find("from SmOperationPeople where enable = '0' and role = ?",string);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#getSmOperroomList()
	 */
	@Override
	public List<SmOperroom> getSmOperroomList() {
		return this.getHibernateTemplate().find("from SmOperroom where enable = '0' and roomType='0'");
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#getSmRegionList()
	 */
	@Override
	public List<SysDiseaseArea> getSmRegionList() {
		return this.getHibernateTemplate().find("from SysDiseaseArea where flag = '1'");
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#getSmRoomById(java.lang.String)
	 */
	@Override
	public SmOperroom getSmRoomById(String room) {
		return this.getHibernateTemplate().get(SmOperroom.class, Integer.parseInt(room));
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#getOutsideScreen()
	 */
	@Override
	public List<Map<String, Object>> getOutsideScreen(String hospitalId) {
		String sql = "select t.dept,t.bed,t.hid,t.name,t.sex,t.state,n.oper_after_goto" +
				" from SM_REG_OPT t left join SM_OPT_NURSE n on t.id=n.operation_id where ((t.state='04' ) or ((t.state='03' or t.state='05') and t.operdate = :operdate))and t.hospital_id = :h order by t.room";
		//03 代表 手术未开始； 04代表手术进行中； 05代表 手术结束
		
		Map m = new HashMap();
		Date now = new Date();
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			m.put("operdate", f.parse(f.format(now)));
		} catch (ParseException e) {
			m.put("operdate","");
		}
		m.put("h", hospitalId);
		List l = this.findBySql(sql, m);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (Object obj:l) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("dept", o[0]);
			map.put("bed", o[1]);
			map.put("hid", o[2]);
			map.put("name", this.nameChange(o[3]));
			map.put("sex", o[4]);
			map.put("state", o[5]);
			map.put("oper_after_goto", o[6]);
			result.add(map);
		}
		return result;
	}
	
	private String nameChange(Object o) {
		String s = o.toString();
		if(s.length()==2) {
			return s.charAt(0)+" ＊ "+s.charAt(1);
		} else {
			return s.charAt(0)+" ＊ "+s.charAt(s.length()-1);
		}
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#getInsideScreen()
	 */
	@Override
	public List<Map<String, Object>> getInsideScreen(String hospitalId) throws ParseException {
		String sql = "select r.name s,t.dept,t.name r,t.designed_opt_name,t.designed_anaes_method_name,t.anesthetist,t.circuanesthetist,t.anaes_assistant,t.operator_name," +
				" t.instrnurse1,t.instrnurse2,t.circunurse1,t.circunurse2"+
				" from SM_REG_OPT t  left join SM_OPERROOM r on r.id=t.room where t.operdate = :operdate and t.state!='00' and t.hospital_id =:h";

		Date now = new Date();
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Map m = new HashMap();
		m.put("h", hospitalId);
		m.put("operdate", f.parse(f.format(now)));
		
		List l = this.findBySql(sql, m);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (Object obj:l) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("room", o[0]);
			map.put("dept", o[1]);
			map.put("name", o[2]);
			map.put("optname", o[3]);
			map.put("anaes", o[4]);
			map.put("anesthetist", o[5]);
			map.put("circuanesthetist", o[6]);
			map.put("anaes_assistant", o[7]);
			map.put("operator_name", o[8]);
			map.put("instrnurse1", o[9]);
			map.put("instrnurse2", o[10]);
			map.put("circunurse1", o[11]);
			map.put("circunurse2", o[12]);
			result.add(map);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.QueryDao#getScientificQuery()
	 */
	@Override
	public List<Map<String, Object>> getScientificQuery(String dateFrom, String dateTo, String sex, 
			String minage, String maxage, String zd, String ss, String mz) throws ParseException {
		StringBuffer sql = new StringBuffer("select t.name r,t.sex,t.age,r.name s,t.hid,t.region,t.bed,t.operdate," +
				" t.diagnosis_name,t.designed_opt_name,t.designed_anaes_method_name,"+
				" t.anesthetist,t.circuanesthetist,t.anaes_assistant," +
				" t.instrnurse1,t.instrnurse2,t.circunurse1,t.circunurse2,"+
				" t.operator_name"+
				" from SM_REG_OPT t left join SM_OPERROOM r on r.id=t.room where 1=1");
		
		Map m = new HashMap();

		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		if(dateFrom!=null&&!"".equals(dateFrom)) {
			sql.append(" and t.operdate>= :dateFrom");
			m.put("dateFrom", f.parse(dateFrom));
		}
		
		if(dateTo!=null&&!"".equals(dateTo)) {
			sql.append(" and t.operdate<= :dateFrom");
			m.put("dateTo", f.parse(dateTo));
		}

		if(sex!=null&&!"".equals(sex)) {
			sql.append(" and t.sex =:sex");
			m.put("sex", sex);
		}
		
		if(minage!=null&&!"".equals(minage)) {
			sql.append(" and t.age>= :minage");
			m.put("minage", minage);
		}
		
		if(maxage!=null&&!"".equals(maxage)) {
			sql.append(" and t.age< :maxage");
			m.put("maxage", maxage);
		}

		if(zd!=null&&!"".equals(zd.trim())) {
			sql.append(" and t.diagnosis_name like :zd");
			m.put("zd", "%"+zd.trim()+"%");
		}
		
		if(ss!=null&&!"".equals(ss.trim())) {
			sql.append(" and t.designed_opt_name like :ss");
			m.put("ss", "%"+ss.trim()+"%");
		}
		
		if(mz!=null&&!"".equals(mz.trim())) {
			sql.append(" and t.designed_anaes_method_name like :mz");
			m.put("mz", "%"+mz.trim()+"%");
		}
		
		List l = this.findBySql(sql.toString(), m);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (Object obj:l) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", o[0]);
			map.put("sex", o[1]);
			map.put("age", o[2]);
			map.put("room", o[3]);
			map.put("hid", o[4]);
			map.put("region", o[5]);
			map.put("bed", o[6]);
			map.put("operdate", o[7]);
			map.put("diagnosis_name", o[8]);
			map.put("designed_opt_name", o[9]);
			map.put("designed_anaes_method_name", o[10]);
			map.put("anesthetist", o[11]);
			map.put("circuanesthetist", o[12]);
			map.put("anaes_assistant", o[13]);
			map.put("instrnurse1", o[14]);
			map.put("instrnurse2", o[15]);
			map.put("circunurse1", o[16]);
			map.put("circunurse2", o[17]);
			map.put("operator_name", o[18]);
			result.add(map);
		}
		return result;
	}
}
