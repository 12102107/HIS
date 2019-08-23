/**  
 * @Title: OptNurseDaoImpl.java 
 * @Package com.znyy.sm.dao.impl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-3-7 上午11:25:07 
 */ 
package com.znyy.sm.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmNurseAnaes;
import com.znyy.bean.SmOptNurse;
import com.znyy.bean.SmWritTemplate;
import com.znyy.sm.dao.OptNurseDao;

/** 
 * @ClassName: OptNurseDaoImpl 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-3-7 上午11:25:07 
 */
public class OptNurseDaoImpl extends GenericDaoImpl<SmOptNurse, String> implements
		OptNurseDao {

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.OptNurseDao#getSopVague(java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getSopVague(String word) {
		String sql = "select t.name from SM_OPERATION_PEOPLE t where (t.name like :name or t.pinyin like :pinyin) and t.role='手术医师'";
		Map m = new HashMap();
		m.put("name", "%"+word.trim()+"%");
		m.put("pinyin", "%"+word.trim().toLowerCase()+"%");
		List l = this.findBySql(sql, m);
		List<Map<String, String>> r = new ArrayList<Map<String, String>>();
		for(Object obj:l) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("name", obj.toString());
			r.add(map);
		}
		return r;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.OptNurseDao#saveOptNurse(com.znyy.bean.SmOptNurse)
	 */
	@Override
	public void saveOptNurse(SmOptNurse nurse) {
		this.save(nurse);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.OptNurseDao#getOptNurseBySroId(java.lang.String)
	 */
	@Override
	public SmOptNurse getOptNurseBySroId(String ylwsid) {
		List<SmOptNurse> l = this.getHibernateTemplate().find("from SmOptNurse where operationId=?",ylwsid);
		if(l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.OptNurseDao#getSmNurseAnaesBySroid(java.lang.String)
	 */
	@Override
	public List<SmNurseAnaes> getSmNurseAnaesBySroid(String ylwsid) {
		SmOptNurse nurse = this.getOptNurseBySroId(ylwsid);
		if(nurse==null) {
			return null;
		} else {
			return this.getHibernateTemplate().find("from SmNurseAnaes where optNurseId=? order by time",nurse.getId());
		}
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.OptNurseDao#saveSmNurseAnaes(com.znyy.bean.SmNurseAnaes)
	 */
	@Override
	public void saveSmNurseAnaes(SmNurseAnaes a) {
		this.getHibernateTemplate().saveOrUpdate(a);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.OptNurseDao#getOptNursePrint(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getOptNursePrint(String ylwsid) {
		
		StringBuffer sql = new StringBuffer("select "); 
		
		sql.append("t.name t,t.age,t.sex,t.dept,r.name r,t.type,n.assay_jerque,n.wound_sort,");
		sql.append("n.insurgery_time,n.start_time,n.end_time,n.outroom_time,");
		sql.append("t.diagnosis_name,n.latter_diag,t.designed_opt_name,n.real_oper,");
		sql.append("n.anaes_mode,n.operator,n.assistor,n.coach,n.anaesthetist,n.instrnurse,n.circunurse,");
		sql.append("n.oper_body_pos,n.before_skin,n.before_sore,n.after_skin,n.after_sore,n.burn,n.remark,");
		sql.append("n.disinfect_mark,n.stopbleedingvalue,n.stopbleeding_begintime,n.stopbleeding_endtime,n.safetybelt,");
		sql.append("n.implant,n.oper_after_goto,n.shadow,n.count,n.casehistory,n.valuables ");

		sql.append("from Sm_Opt_Nurse n left join Sm_Reg_Opt t on t.id = n.operation_id left join sm_operroom r on r.id=t.room "); 

		sql.append("where t.id =:sroid");
		Map m = new HashMap();
		m.put("sroid", ylwsid);
		
		List l = this.findBySql(sql.toString(), m);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (Object obj:l) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", objToStr(o[0]));
			map.put("age", o[1].toString()+"岁");
			if(objToStr(o[2]).equals("0")) {
				map.put("sex", "男");
			}
			if(objToStr(o[2]).equals("1")) {
				map.put("sex", "女");
			}
			map.put("dept",objToStr( o[3]));
			map.put("room",objToStr( o[4]));
			if(objToStr(o[5]).equals("0")) {
				map.put("type", "急诊手术");
			}
			if(objToStr(o[5]).equals("1")) {
				map.put("type", "择期手术");
			}
			map.put("assayJerque", objToStr(o[6]));
			map.put("woundSort", objToStr(o[7]));

			if(o[8]!=null) {
				map.put("insurgeryTime", o[8]);
			} else {
				map.put("insurgeryTime", "");
			}
			if(o[9]!=null) {
				map.put("startTime", o[9]);
			} else {
				map.put("startTime", "");
			}
			if(o[10]!=null) {
				map.put("endTime", o[10]);
			} else {
				map.put("endTime", "");
			}
			if(o[11]!=null) {
				map.put("outroomTime", o[11]);
			} else {
				map.put("outroomTime", "");
			}
			
			map.put("diagnosisName", objToStr(o[12]));
			map.put("latterDiag", objToStr(o[13]));
			map.put("designedOptName", objToStr(o[14]));
			map.put("realOper", objToStr(o[15]));
			
			map.put("anaesMode",objToStr( o[16]));
			
			map.put("operator",objToStr( o[17]));
			map.put("assistor",objToStr( o[18]));
			map.put("coach",objToStr( o[19]));
			map.put("anaesthetist", objToStr(o[20]));
			map.put("instrnurse", objToStr(o[21]));
			map.put("circunurse",objToStr( o[22]));
			
			map.put("operBodyPos", objToStr(o[23]));
			map.put("beforeSkin", objToStr(o[24]));
			map.put("beforeSore",objToStr( o[25]));
			map.put("afterSkin",objToStr( o[26]));
			map.put("afterSore", objToStr(o[27]));
			map.put("burn", objToStr(o[28]));
			map.put("remark",objToStr( o[29]));

			map.put("disinfectMark",objToStr( o[30]));
			map.put("stopbleedingvalue", objToStr(o[31]));
			map.put("stopbleedingBegintime",objToStr( o[32]));
			map.put("stopbleedingEndtime", objToStr(o[33]));
			map.put("safetybelt", objToStr(o[34]));
			
			map.put("implant",objToStr( o[35]));

			map.put("operAfterGoto",objToStr( o[36]));
			map.put("shadow", objToStr(o[37]));
			map.put("count",objToStr( o[38]));

			map.put("casehistory",objToStr( o[39]));
			map.put("valuables", objToStr(o[40]));

			DateFormat f = new SimpleDateFormat("yyyy年MM月dd日");
			
			map.put("printdate", f.format(new Date()));
			
			result.add(map);
		}
		return result;
	}

	private static String objToStr(Object obj) {
		if(obj != null && !"null".equals(obj))
			return obj.toString();
		return "";
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.OptNurseDao#saveSmWritTemplate(com.znyy.bean.SmWritTemplate)
	 */
	@Override
	public void saveSmWritTemplate(SmWritTemplate wt) {
		this.getHibernateTemplate().save(wt);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.OptNurseDao#getSmWritTemplatePersonal(java.lang.String)
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePersonal(String userid) {
		return this.getHibernateTemplate().find("from SmWritTemplate where wirtType='02' and type='1' and userid=? and enable='0'",userid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.OptNurseDao#getSmWritTemplatePublic()
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePublic() {
		return this.getHibernateTemplate().find("from SmWritTemplate where wirtType='02' and type='0' and enable='0'");
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.OptNurseDao#delTemplate(java.lang.String)
	 */
	@Override
	public void delTemplate(String templateId) {
		SmWritTemplate s = this.getHibernateTemplate().get(SmWritTemplate.class, templateId);
		s.setEnable("1");
		this.getHibernateTemplate().save(s);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.OptNurseDao#getTemplateVal(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getTemplateVal(String templateId) {
		
		StringBuffer sql = new StringBuffer("select "); 
		
		sql.append("n.assay_jerque,n.wound_sort,");
		sql.append("n.insurgery_time,n.start_time,n.end_time,n.outroom_time,");
		sql.append("n.latter_diag,n.real_oper,");
		sql.append("n.anaes_mode,n.operator,n.assistor,n.coach,n.anaesthetist,n.instrnurse,n.circunurse,");
		sql.append("n.oper_body_pos,n.before_skin,n.before_sore,n.after_skin,n.after_sore,n.burn,n.remark,");
		sql.append("n.disinfect_mark,n.stopbleedingvalue,n.stopbleeding_begintime,n.stopbleeding_endtime,n.safetybelt,");
		sql.append("n.implant,n.oper_after_goto,n.shadow,n.count,n.casehistory,n.valuables,n.id ");

		sql.append("from Sm_Opt_Nurse n left join SM_WRIT_TEMPLATE w on n.id = w.wirt_id "); 

		sql.append("where w.id =:id");
		Map m = new HashMap();
		m.put("id", templateId);
		
		List l = this.findBySql(sql.toString(), m);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		
		String nurseid = "";
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for (Object obj:l) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			
			map.put("assayJerque", objToStr(o[0]));
			map.put("woundSort", objToStr(o[1]));
			
			if(o[2]!=null) {
				map.put("insurgeryTime", f.format(o[2]));
			} else {
				map.put("insurgeryTime", "");
			}
			if(o[3]!=null) {
				map.put("startTime", f.format(o[3]));
			} else {
				map.put("startTime", "");
			}
			if(o[4]!=null) {
				map.put("endTime", f.format(o[4]));
			} else {
				map.put("endTime", "");
			}
			if(o[5]!=null) {
				map.put("outroomTime", f.format(o[5]));
			} else {
				map.put("outroomTime", "");
			}
			
			
			map.put("latterDiag", objToStr(o[6]));
		
			map.put("realOper", objToStr(o[7]));
			
			map.put("anaesMode",objToStr( o[8]));
			
			map.put("operator",objToStr( o[9]));
			map.put("assistor",objToStr( o[10]));
			map.put("coach",objToStr( o[11]));
			map.put("anaesthetist", objToStr(o[12]));
			map.put("instrnurse", objToStr(o[13]));
			map.put("circunurse",objToStr( o[14]));
			
			map.put("operBodyPos", objToStr(o[15]));
			map.put("beforeSkin", objToStr(o[16]));
			map.put("beforeSore",objToStr( o[17]));
			map.put("afterSkin",objToStr( o[18]));
			map.put("afterSore", objToStr(o[19]));
			map.put("burn", objToStr(o[20]));
			map.put("remark",objToStr( o[21]));

			map.put("disinfectMark",objToStr( o[22]));
			map.put("stopbleedingvalue", objToStr(o[23]));
			map.put("stopbleedingBegintime",objToStr( o[24]));
			map.put("stopbleedingEndtime", objToStr(o[25]));
			map.put("safetybelt", objToStr(o[26]));
			
			map.put("implant",objToStr( o[27]));

			map.put("operAfterGoto",objToStr( o[28]));
			map.put("shadow", objToStr(o[29]));
			map.put("count",objToStr( o[30]));

			map.put("casehistory",objToStr( o[31]));
			map.put("valuables", objToStr(o[32]));
			
			nurseid = o[33].toString();
			
			result.add(map);
		}
		
		List<SmNurseAnaes> na = this.getHibernateTemplate().find("from SmNurseAnaes where optNurseId = ?  order by type,time",nurseid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		for(int i=0;i<na.size();i++) {
			map.put("anaes"+i+"DIASTOLIC_PRESSURE", objToStr(na.get(i).getDiastolicPressure()));
			map.put("anaes"+i+"SYSTOLIC_PRESSURE", objToStr(na.get(i).getSystolicPressure()));
			map.put("anaes"+i+"R", objToStr(na.get(i).getR()));
			map.put("anaes"+i+"P", objToStr(na.get(i).getP()));
			map.put("anaes"+i+"SPO2", objToStr(na.get(i).getSpo2()));
			if(na.get(i).getTime()!=null) {
				map.put("anaes"+i+"TIME", f.format(na.get(i).getTime()));
			} else {
				map.put("anaes"+i+"TIME", "");
			}
		}
		
		result.add(map);
		
		return result;
	}

}
