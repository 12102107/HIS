/**  
 * @Title: PreVisitDaoImpl.java 
 * @Package com.znyy.sm.dao.impl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-29 下午1:30:52 
 */ 
package com.znyy.sm.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmPreTestData;
import com.znyy.bean.SmPreVisit;
import com.znyy.bean.SmPreVisitMedicalHistory;
import com.znyy.bean.SmWritTemplate;
import com.znyy.sm.dao.PreVisitDao;

/** 
 * @ClassName: PreVisitDaoImpl 
 * @Description: 术前访视Dao 
 * @author 白东旭
 * @date 2016-2-29 下午1:30:52 
 */
public class PreVisitDaoImpl extends GenericDaoImpl<SmPreVisit, Long> implements
		PreVisitDao {

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.PreVisitDao#getMzysByUserid(java.lang.String)
	 */
	@Override
	public SmOperationPeople getMzysByUserid(String userid) {
		return (SmOperationPeople) this.getHibernateTemplate().find("from SmOperationPeople where code=? and role='手术麻醉医师'",Integer.parseInt(userid)).get(0);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.PreVisitDao#saveSpVmh(com.znyy.bean.SmPreVisitMedicalHistory)
	 */
	@Override
	public void saveSpVmh(SmPreVisitMedicalHistory spVmh) {
		this.getHibernateTemplate().saveOrUpdate(spVmh);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.PreVisitDao#savePreVisit(com.znyy.bean.SmPreVisit)
	 */
	@Override
	public void savePreVisit(SmPreVisit preVisit) {
		this.save(preVisit);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.PreVisitDao#getPreVisitByYlwsd(java.lang.String)
	 */
	@Override
	public SmPreVisit getPreVisitByYlwsd(String ylwsid) {
		List<SmPreVisit> l = this.getHibernateTemplate().find("from SmPreVisit where operationId=?",ylwsid);
		if(l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.PreVisitDao#getSpVmhByYlwsd(java.lang.String)
	 */
	@Override
	public SmPreVisitMedicalHistory getSpVmhByYlwsd(String ylwsid) {
		List<SmPreVisitMedicalHistory> l =  this.getHibernateTemplate().find("from SmPreVisitMedicalHistory where operationId=?",ylwsid);
		if(l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.PreVisitDao#getPreVisitPrint(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getPreVisitPrint(String ylwsid) {
		
		StringBuffer sql = new StringBuffer("select "); 
		
		sql.append("t.name,t.age,t.bed,t.hid,t.sex,t.diagnosis_name,t.designed_opt_name,v.height,v.weight,v.complaint,v.spacial_monitoring,v.spacial_monitoring_other,");
		sql.append("m.heartbool,m.heartbool_detail,m.heartbool_other,");
		sql.append("m.lungbreath,m.lungbreath_detail,m.lungbreath_other,");
		sql.append("m.urologyprocreate,m.urologyprocreate_detail,m.urologyprocreate_other,");
		sql.append("m.digest,m.digest_detail,m.digest_other,");
		sql.append("m.nevemuscle,m.nevemuscle_detail,m.nevemuscle_other,");
		sql.append("m.boold,m.boold_detail,m.boold_other,");
		sql.append("m.incretion,m.incretion_detail,m.digest_other,");
		sql.append("m.spirit,m.spirit_detail,m.spirit_other,");
		sql.append("m.obstetrical,m.obstetrical_detail,m.obstetrical_other,");
		sql.append("m.smokecase,m.smokecase_detail,m.smokecase_other,");
		sql.append("m.allergic,m.allergic_detail,m.allergic_other,");
		sql.append("m.hereditycase,m.hereditycase_detail,m.hereditycase_other,");
		sql.append("m.specialmedica,m.specialmedica_detail,m.specialmedica_other,");
		sql.append("m.main_case,m.main_case_detail,m.main_case_other,");
		sql.append("v.asa,v.full_stomach,");
		sql.append("v.aneasdoctor,v.finish_time,v.DISPOSAL  ");

		sql.append("from SM_REG_OPT t left join SM_PRE_VISIT v on t.id=v.operation_id left join Sm_Pre_Visit_Medical_History m on t.id=m.operation_id "); 

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
			map.put("bed", objToStr(o[2]));
			map.put("hid", objToStr(o[3]));
			map.put("sex", objToStr(o[4]));
			map.put("diagnosisName",objToStr( o[5]));
			map.put("designedOptName",objToStr( o[6]));
			map.put("height", objToStr(o[7]));
			map.put("weight", objToStr(o[8]));
			map.put("complaint", objToStr(o[9]));
			
			map.put("spacialMonitoring",objToStr(o[10]));
			
			String[] s = objToStr(o[10]).split("-");
			if(s.length==5) {
				map.put("BP1", s[0]);
				map.put("BP2", s[1]);
				map.put("R", s[2]);
				map.put("P", s[3]);
				map.put("T", s[4]);
			}
			if(s.length==4) {
				map.put("BP1", s[0]);
				map.put("BP2", s[1]);
				map.put("R", s[2]);
				map.put("P", s[3]);
			}
			if(s.length==3) {
				map.put("BP1", s[0]);
				map.put("BP2", s[1]);
				map.put("R", s[2]);
			}
			if(s.length==2) {
				map.put("BP1", s[0]);
				map.put("BP2", s[1]);
			}
			if(s.length==1) {
				map.put("BP1", s[0]);
			}

			map.put("elze", objToStr(o[11]));
			
			map.put("heartbool", objToStr(o[12]));
			map.put("heartboolDetail", objToStr(o[13]));
			map.put("heartboolOther", objToStr(o[14]));
			
			map.put("lungbreath", objToStr(o[15]));
			map.put("lungbreathDetail",objToStr( o[16]));
			map.put("lungbreathOther",objToStr( o[17]));
			
			map.put("urologyprocreate",objToStr( o[18]));
			map.put("urologyprocreateDetail",objToStr( o[19]));
			map.put("urologyprocreateOther", objToStr(o[20]));
			
			map.put("digest", objToStr(o[21]));
			map.put("digestDetail",objToStr( o[22]));
			map.put("digestOther", objToStr(o[23]));
			
			map.put("nevemuscle", objToStr(o[24]));
			map.put("nevemuscleDetail",objToStr( o[25]));
			map.put("nevemuscleOther",objToStr( o[26]));

			map.put("boold", objToStr(o[27]));
			map.put("booldDetail", objToStr(o[28]));
			map.put("booldOther",objToStr( o[29]));

			map.put("incretion",objToStr( o[30]));
			map.put("incretionDetail", objToStr(o[31]));
			map.put("incretionOther",objToStr( o[32]));

			map.put("spirit", objToStr(o[33]));
			map.put("spiritDetail", objToStr(o[34]));
			map.put("spiritOther",objToStr( o[35]));

			map.put("obstetrical",objToStr( o[36]));
			map.put("obstetricalDetail", objToStr(o[37]));
			map.put("obstetricalOther",objToStr( o[38]));

			map.put("smokecase",objToStr( o[39]));
			map.put("smokecaseDetail", objToStr(o[40]));
			map.put("smokecaseOther", objToStr(o[41]));
			
			map.put("allergic", objToStr(o[42]));
			map.put("allergicDetail", objToStr(o[43]));
			map.put("allergicOther",objToStr( o[44]));
			
			map.put("hereditycase",objToStr( o[45]));
			map.put("hereditycaseDetail",objToStr( o[46]));
			map.put("hereditycaseOther",objToStr( o[47]));
			
			map.put("specialmedica",objToStr( o[48]));
			map.put("specialmedicaDetail", objToStr(o[49]));
			map.put("specialmedicaOther", objToStr(o[50]));

			map.put("mainCase", objToStr(o[51]));
			map.put("mainCaseDetail", objToStr(o[52]));
			map.put("mainCaseOther",objToStr( o[53]));
			
			map.put("ASA", objToStr(o[54]));
			map.put("fullStomach", objToStr(o[55]));
			map.put("aneasdoctor", objToStr(o[56]));
			
			if(o[57]!=null) {
				map.put("visitDate", o[57]);
			} else {
				map.put("visitDate", "");
			}
			
			map.put("disposal", objToStr(o[58]));
			
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
	 * @see com.znyy.sm.dao.PreVisitDao#saveSmWritTemplate(com.znyy.bean.SmWritTemplate)
	 */
	@Override
	public void saveSmWritTemplate(SmWritTemplate wt) {
		this.getHibernateTemplate().save(wt);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.PreVisitDao#getSmWritTemplatePersonal(java.lang.String)
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePersonal(String userid) {
		return this.getHibernateTemplate().find("from SmWritTemplate where wirtType='01' and type='1' and userid=? and enable='0'",userid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.PreVisitDao#getSmWritTemplatePublic()
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePublic() {
		return this.getHibernateTemplate().find("from SmWritTemplate where wirtType='01' and type='0' and enable='0'");
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.PreVisitDao#getTemplateVal(java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getTemplateVal(String templateId) {
		
		Map m1 = new HashMap();
		m1.put("id", templateId);
		String pid = (String) this.findBySql("select wirt_id from SM_WRIT_TEMPLATE where id=:id", m1).get(0);
		
		StringBuffer sql = new StringBuffer("select "); 
		
		sql.append("v.height,v.weight,v.complaint,v.spacial_monitoring,v.spacial_monitoring_other,");
		sql.append("m.heartbool,m.heartbool_detail,m.heartbool_other,");
		sql.append("m.lungbreath,m.lungbreath_detail,m.lungbreath_other,");
		sql.append("m.urologyprocreate,m.urologyprocreate_detail,m.urologyprocreate_other,");
		sql.append("m.digest,m.digest_detail,m.digest_other,");
		sql.append("m.nevemuscle,m.nevemuscle_detail,m.nevemuscle_other,");
		sql.append("m.boold,m.boold_detail,m.boold_other,");
		sql.append("m.incretion,m.incretion_detail,m.digest_other,");
		sql.append("m.spirit,m.spirit_detail,m.spirit_other,");
		sql.append("m.obstetrical,m.obstetrical_detail,m.obstetrical_other,");
		sql.append("m.smokecase,m.smokecase_detail,m.smokecase_other,");
		sql.append("m.allergic,m.allergic_detail,m.allergic_other,");
		sql.append("m.hereditycase,m.hereditycase_detail,m.hereditycase_other,");
		sql.append("m.specialmedica,m.specialmedica_detail,m.specialmedica_other,");
		sql.append("m.main_case,m.main_case_detail,m.main_case_other,");
		sql.append("v.asa,v.full_stomach,v.DISPOSAL ");

		sql.append("from SM_PRE_VISIT v left join Sm_Pre_Visit_Medical_History m on v.id=m.doc_id "); 

		sql.append("where v.id =:pid");
		Map m = new HashMap();
		m.put("pid", pid);
		
		List l = this.findBySql(sql.toString(), m);
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		for (Object obj:l) {
			
			Object[] o = (Object[]) obj;
			Map<String,String> map = new HashMap<String,String>();

			map.put("height", objToStr(o[0]));
			map.put("weight", objToStr(o[1]));
			map.put("complaint", objToStr(o[2]));
			
			map.put("spacialMonitoring",objToStr(o[3]));
			
			String[] s = objToStr(o[3]).split("-");
			if(s.length==5) {
				map.put("BP1", s[0]);
				map.put("BP2", s[1]);
				map.put("R", s[2]);
				map.put("P", s[3]);
				map.put("T", s[4]);
			}
			if(s.length==4) {
				map.put("BP1", s[0]);
				map.put("BP2", s[1]);
				map.put("R", s[2]);
				map.put("P", s[3]);
			}
			if(s.length==3) {
				map.put("BP1", s[0]);
				map.put("BP2", s[1]);
				map.put("R", s[2]);
			}
			if(s.length==2) {
				map.put("BP1", s[0]);
				map.put("BP2", s[1]);
			}
			if(s.length==1) {
				map.put("BP1", s[0]);
			}

			map.put("elze", objToStr(o[4]));
			
			map.put("heartbool", objToStr(o[5]));
			map.put("heartboolDetail", objToStr(o[6]));
			map.put("heartboolOther", objToStr(o[7]));
			
			map.put("lungbreath", objToStr(o[8]));
			map.put("lungbreathDetail",objToStr( o[9]));
			map.put("lungbreathOther",objToStr( o[10]));
			
			map.put("urologyprocreate",objToStr( o[11]));
			map.put("urologyprocreateDetail",objToStr( o[12]));
			map.put("urologyprocreateOther", objToStr(o[13]));
			
			map.put("digest", objToStr(o[14]));
			map.put("digestDetail",objToStr( o[15]));
			map.put("digestOther", objToStr(o[16]));
			
			map.put("nevemuscle", objToStr(o[17]));
			map.put("nevemuscleDetail",objToStr( o[18]));
			map.put("nevemuscleOther",objToStr( o[19]));

			map.put("boold", objToStr(o[20]));
			map.put("booldDetail", objToStr(o[21]));
			map.put("booldOther",objToStr( o[22]));

			map.put("incretion",objToStr( o[23]));
			map.put("incretionDetail", objToStr(o[24]));
			map.put("incretionOther",objToStr( o[25]));

			map.put("spirit", objToStr(o[26]));
			map.put("spiritDetail", objToStr(o[27]));
			map.put("spiritOther",objToStr( o[28]));

			map.put("obstetrical",objToStr( o[29]));
			map.put("obstetricalDetail", objToStr(o[30]));
			map.put("obstetricalOther",objToStr( o[31]));

			map.put("smokecase",objToStr( o[32]));
			map.put("smokecaseDetail", objToStr(o[33]));
			map.put("smokecaseOther", objToStr(o[34]));
			
			map.put("allergic", objToStr(o[35]));
			map.put("allergicDetail", objToStr(o[36]));
			map.put("allergicOther",objToStr( o[37]));
			
			map.put("hereditycase",objToStr( o[38]));
			map.put("hereditycaseDetail",objToStr( o[39]));
			map.put("hereditycaseOther",objToStr( o[40]));
			
			map.put("specialmedica",objToStr( o[41]));
			map.put("specialmedicaDetail", objToStr(o[42]));
			map.put("specialmedicaOther", objToStr(o[43]));

			map.put("mainCase", objToStr(o[44]));
			map.put("mainCaseDetail", objToStr(o[45]));
			map.put("mainCaseOther",objToStr( o[46]));
			
			map.put("ASA", objToStr(o[47]));
			map.put("fullStomach", objToStr(o[48]));
			map.put("disposal", objToStr(o[49]));
			result.add(map);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.PreVisitDao#delTemplate(java.lang.String)
	 */
	@Override
	public void delTemplate(String templateId) {
		SmWritTemplate s = this.getHibernateTemplate().get(SmWritTemplate.class, templateId);
		s.setEnable("1");
		this.getHibernateTemplate().save(s);
	}

	@Override
	public Map<String, Object> loadTest(String hid) {
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		m.put("hid", hid);
		String sql=" select t.test_code,t.test_name,t.test_value  from sm_test_data t  where t.operation_id=:hid ";
        List<?> l = this.findBySql(sql, m);
		for (Object obj : l) {
			Object[] o = (Object[]) obj;
			if(o[0].equals("Hb")){
				result.put("Hb", o[2]!=null?o[2]:"");
			}
			if(o[0].equals("HCT")){
				result.put("HCT", o[2]!=null?o[2]:"");
			}
			if(o[0].equals("WBC")){
				result.put("WBC", o[2]!=null?o[2]:"");
			}
			if(o[0].equals("PLT")){
				result.put("PLT", o[2]!=null?o[2]:"");
			}
			if(o[0].equals("K+")){
				result.put("K", o[2]!=null?o[2]:"");
			}
			if(o[0].equals("Na+")){
				result.put("Na", o[2]!=null?o[2]:"");
			}
			if(o[0].equals("Cl-")){
				result.put("Cl", o[2]!=null?o[2]:"");
			}
			if(o[0].equals("GLU")){
				result.put("GLU", o[2]!=null?o[2]:"");
			}
			if(o[0].equals("SGPT")){
				result.put("SGPT",o[2]!=null?o[2]:"");
			}
			if(o[0].equals("BUN")){
				result.put("BUN", o[2]!=null?o[2]:"");
			}
			if(o[0].equals("Cr")){
				result.put("Cr", o[2]!=null?o[2]:"");
			}
			if(o[0].equals("PT")){
				result.put("PT", o[2]!=null?o[2]:"");
			}
			if(o[0].equals("APTT")){
				result.put("APTT", o[2]!=null?o[2]:"");
			}
		    if(o[0].equals("PaO2")){
				result.put("PaO2", o[2]!=null?o[2]:"");
			}
		}
		return result;
	}
/*	@Override
	public Map<String, Object> loadTest(String hid) {
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		m.put("hid", hid);
		String sql=" select " +
				" t.mrn,t.test_code,t.test_name,t.test_result,t.test_result_flag,t.lab_device_test_id,t.dt_validate  " +
				" from v_lab_report_pm t where t.mrn=:hid ";
		List<?> l = this.findBySql(sql, m);
		List Hb_HCT =new ArrayList();
		for (Object obj : l) {
			Object[] o = (Object[]) obj;
			if(o[1].equals("Hb")){
				Hb_HCT.add(o[3]);
			}
			if(o[1].equals("HCT")){
				Hb_HCT.add(o[3]);
			}
			if(o[1].equals("WBC")){
				result.put("WBC", o[3]!=null?o[3]:"");
			}
			if(o[1].equals("PLT")){
				result.put("PLT", o[3]!=null?o[3]:"");
			}
			if(o[1].equals("K+")){
				result.put("K", o[3]!=null?o[3]:"");
			}
			if(o[1].equals("Na+")){
				result.put("Na", o[3]!=null?o[3]:"");
			}
			if(o[1].equals("Cl-")){
				result.put("Cl", o[3]!=null?o[3]:"");
			}
			if(o[1].equals("GLU")){
				result.put("GLU", o[3]!=null?o[3]:"");
			}
			if(o[1].equals("SGPT")){
				result.put("SGPT",o[3]!=null?o[3]:"");
			}
			if(o[1].equals("BUN")){
				result.put("BUN", o[3]!=null?o[3]:"");
			}
			if(o[1].equals("Cr")){
				result.put("Cr", o[3]!=null?o[3]:"");
			}
			if(o[1].equals("PT")){
				result.put("PT", o[3]!=null?o[3]:"");
			}
			if(o[1].equals("APTT")){
				result.put("APTT", o[3]!=null?o[3]:"");
			}
			if(o[1].equals("CK")){
				//if(o[1].equals("PaO2")){
				result.put("PaO2", o[3]!=null?o[3]:"");
			}
			
		}
		if(Hb_HCT.size()==2){
			result.put("Hb_HCT", StringUtils.join(Hb_HCT, "/"));
		}else{
			result.put("Hb_HCT", "");
		}
		return result;
	}
*/

	@Override
	public SmPreTestData getTestEventByOptId(String operationId) {
		
		List<SmPreTestData> l = this.getHibernateTemplate().find("from SmPreTestData where operationId=?",operationId);
		if(l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}

	@Override
	public void addTestData(SmPreTestData sprd) {
		this.getHibernateTemplate().save(sprd);
	}

	@Override
	public void updateTestData(SmPreTestData sprd) {
		this.getHibernateTemplate().merge(sprd);
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}