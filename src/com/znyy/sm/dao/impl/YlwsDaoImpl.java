package com.znyy.sm.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.Accede;
import com.znyy.bean.SmAnaesPlanDocument;
import com.znyy.bean.SmAnaesWatch;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;
import com.znyy.sm.dao.YlwsDao;

/**
 * @类名称: YlwsDaoImpl
 * @类描述:
 * @作者:付士山
 * @创建时间:2016-3-8 上午10:18:40
 */

@SuppressWarnings("unchecked")
public class YlwsDaoImpl extends GenericDaoImpl<SmRegOpt, String> implements
		YlwsDao {

	public Page getYlwsList(int parmpage, Integer pageSize, String hospitalId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Page ylwss = new Page();
			String sql = "select * from sm_reg_opt where 1=1 and state='03' or state='04'  or state='05' and archstate='00' and hospital_id=:h order by operdate desc";
			Map m = new HashMap();
			m.put("h", hospitalId);
			ylwss = this.findByHQLWithPageOfSQL(sql, m, parmpage, pageSize,SmRegOpt.class);
		return ylwss;

	}

	/**
	 * @方法名称: getYlwsList
	 * @功能描述:医疗文书跳转到麻醉同意书
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:36:21
	 * @param ylwsid
	 * @return
	 * @see com.znyy.sm.dao.YlwsDao#getYlwsList(java.lang.String)
	 */

	@Override
	public List<SmRegOpt> getYlwsList(String ylwsid) {

		String hql = " from SmRegOpt where id=?";
		return this.getHibernateTemplate().find(hql, ylwsid);
	}

	/**
	 * @方法名称: getMztysById
	 * @功能描述:根据医疗文书id查询麻醉同意书
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:33:31
	 * @param ylwsid
	 * @return
	 * @see com.znyy.sm.dao.YlwsDao#getMztysById(java.lang.String)
	 */

	@Override
	public Accede getMztysById(String ylwsid) {
		String hql = "from Accede where docId=?";
		List list = this.getHibernateTemplate().find(hql, ylwsid);
		if (!list.isEmpty()) {
			return (Accede) list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * @方法名称: modMztysList
	 * @功能描述:同意书修改
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:35:12
	 * @param mztys
	 * @see com.znyy.sm.dao.YlwsDao#modMztysList(com.znyy.bean.Accede)
	 */

	@Override
	public void modMztysList(Accede mztys) {
		this.getHibernateTemplate().merge(mztys);

	}

	/**
	 * @方法名称: addMztys
	 * @功能描述:同意书添加
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午11:08:13
	 * @param tys
	 * @see com.znyy.sm.dao.YlwsDao#addMztys(com.znyy.bean.Accede)
	 */

	@Override
	public void addMztys(Accede tys) {

		this.getHibernateTemplate().save(tys);

	}

	@Override
	public List<Map<String, Object>> getMzPrint(String ylwsid) {
		String sql = "select t.name,t.sex,t.age,t.region,t.bed,t.preengagementnumber,t.designed_anaes_method_name,"
				+ "a.choose_pain,a.visit_date,a.notice,a.transfusion_merit,a.transfusion_yn,"
				+ "a.accident_concurrency,a.choose_airtube,a.other_puncture,p.name as pname "
				+ "from SM_REG_OPT t left join SM_ACCEDE a on t.id=a.doc_id "
				+ "left join SM_OPERATION_PEOPLE p on p.code=a.operation_id where t.id=:ylwsid";
		Map m = new HashMap();
		m.put("ylwsid", ylwsid);
		List l = this.findBySql(sql, m);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Object obj : l) {
			Object[] o = (Object[]) obj;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("NAME", o[0]);
			if ("0".equals(o[1])) {
				map.put("SEX", "男");
			}
			if ("1".equals(o[1])) {
				map.put("SEX", "女");
			}
			map.put("AGE", o[2]);
			map.put("REGION", o[3]);
			map.put("BED", o[4]);
			map.put("PREENGAGEMENTNUMBER", o[5]);
			map.put("DESIGNED_ANAES_METHOD_NAME", o[6]);
			map.put("CHOOSE_PAIN", o[7]);
			map.put("VISIT_DATE", o[8]);
			map.put("NOTICE", o[9]);

			if (o[10] != null) {
				map.put("TRANSFUSION_MERIT", o[10]);

			} else {
				map.put("TRANSFUSION_MERIT", "");
			}

			map.put("TRANSFUSION_YN", o[11]);

			if (o[12] != null) {

				map.put("ACCIDENT_CONCURRENCY", o[12]);
			} else {
				map.put("ACCIDENT_CONCURRENCY", "");
			}

			map.put("CHOOSE_AIRTUBE", o[13]);

			if (o[14] != null) {

				map.put("OTHER_PUNCTURE", o[14]);
			} else {
				map.put("OTHER_PUNCTURE", "");
			}
			map.put("PNAME", o[15]);
			result.add(map);
		}
		return result;
	}

	/**
	 * @方法名称: getMzjhById
	 * @功能描述:根据医疗文书id查询麻醉计划
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午10:18:42
	 * @param ylwsid
	 * @return
	 * @see com.znyy.sm.dao.YlwsDao#getMzjhById(java.lang.String)
	 */

	@Override
	public SmAnaesPlanDocument getMzjhById(String ylwsid) {

		String hql = "from SmAnaesPlanDocument where docId=?";
		List list = this.getHibernateTemplate().find(hql, ylwsid);
		if (!list.isEmpty()) {
			return (SmAnaesPlanDocument) list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * @方法名称: modMzjhList
	 * @功能描述:麻醉计划修改
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午11:05:40
	 * @param mzjhs
	 * @see com.znyy.sm.dao.YlwsDao#modMzjhList(com.znyy.bean.SmAnaesPlanDocument)
	 */

	@Override
	public void modMzjhList(SmAnaesPlanDocument mzjhs) {

		this.getHibernateTemplate().merge(mzjhs);

	}

	/**
	 * @方法名称: addMzjh
	 * @功能描述:麻醉计划添加
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午11:07:25
	 * @param mzjh
	 * @see com.znyy.sm.dao.YlwsDao#addMzjh(com.znyy.bean.SmAnaesPlanDocument)
	 */

	@Override
	public void addMzjh(SmAnaesPlanDocument mzjh) {

		this.getHibernateTemplate().save(mzjh);

	}

	@Override
	public List<Map<String, Object>> getMzPrintMzjh(String ylwsid) {
		String sql = "select t.name,t.sex,t.age,t.region,t.bed,"
				+ "t.preengagementnumber,t.diagnosis_name,t.designed_opt_name,"
				+ "a.ab_user_medicine,a.direction,a.ganaes_user_medicine,"
				+ "a.special_technology,a.inspect,a.hurt_inspect,a.liquor_cure,"
				+ "a.anaes_match,a.doctor_sopite,a.possibi_happen,a.discuss,a.aneasdoctor,"
				+ "a.visit_date,a.blood_pre_h,a.blood_pre_l,a.heart_rhythm,a.breath_fre,"
				+ "a.spo2,a.prefastingtime,a.equipment_inspection,a.conclusion,a.anaes_method,t.opt_level "
				+ "from SM_REG_OPT t left join SM_ANAES_PLAN_DOCUMENT a on t.id=a.doc_id where t.id=:ylwsid";
		Map m = new HashMap();
		m.put("ylwsid", ylwsid);
		List l = this.findBySql(sql, m);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Object obj : l) {
			Object[] o = (Object[]) obj;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("NAME", o[0]);
			if ("0".equals(o[1])) {
				map.put("SEX", "男");
			}
			if ("1".equals(o[1])) {
				map.put("SEX", "女");
			}
			map.put("AGE", o[2]);
			map.put("REGION", o[3]);
			map.put("BED", o[4]);
			map.put("PREENGAGEMENTNUMBER", o[5]);
			map.put("DIAGNOSIS_NAME", o[6]);
			map.put("DESIGNED_OPT_NAME", o[7]);
			map.put("AB_USER_MEDICINE", o[8]);
			map.put("DIRECTION", o[9]);
			map.put("GANAES_USER_MEDICINE", o[10]);
			map.put("SPECIAL_TECHNOLOGY", o[11]);
			map.put("INSPECT", o[12]);
			map.put("HURT_INSPECT", o[13]);
			map.put("LIQUOR_CURE", o[14]);
			map.put("ANAES_MATCH", o[15]);
			map.put("DOCTOR_SOPITE", o[16]);
			map.put("POSSIBI_HAPPEN", o[17]);
			map.put("DISCUSS", o[18]);
			map.put("ANEASDOCTOR", o[19]);
			map.put("VISIT_DATE", o[20]);
			map.put("BLOOD_PRE_H", o[21]);
			map.put("BLOOD_PRE_L", o[22]);
			map.put("HEART_RHYTHM", o[23]);
			map.put("BREATH_FRE", o[24]);
			map.put("SPO2", o[25]);
			map.put("PREFASTINGTIME", o[26]);
			map.put("EQUIPMENT_INSPECTION", o[27]);
			map.put("CONCLUSION", o[28]);
			map.put("ANAES_METHOD", o[29]);
			map.put("OPT_LEVEL", o[30]);
			result.add(map);
		}
		return result;
	}

	/**
	 * @方法名称: getShsfById
	 * @功能描述:根据医疗文书id查询术后随访
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:25:03
	 * @param ylwsid
	 * @return
	 * @see com.znyy.sm.dao.YlwsDao#getShsfById(java.lang.String)
	 */

	@Override
	public SmAnaesWatch getShsfById(String ylwsid) {

		String hql = "from SmAnaesWatch where docId=?";
		List list = this.getHibernateTemplate().find(hql, ylwsid);
		if (!list.isEmpty()) {
			return (SmAnaesWatch) list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * @方法名称: modShfsList
	 * @功能描述:术后随访修改
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:47:20
	 * @param shsfs
	 * @see com.znyy.sm.dao.YlwsDao#modShfsList(com.znyy.bean.SmAnaesWatch)
	 */

	@Override
	public void modShfsList(SmAnaesWatch shsfs) {

		this.getHibernateTemplate().merge(shsfs);

	}

	/**
	 * @方法名称: addShfs
	 * @功能描述:术后随访添加
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:49:31
	 * @param shsf
	 * @see com.znyy.sm.dao.YlwsDao#addShfs(com.znyy.bean.SmAnaesWatch)
	 */

	@Override
	public void addShfs(SmAnaesWatch shsf) {

		this.getHibernateTemplate().save(shsf);

	}

	@Override
	public List<Map<String, Object>> getPrintSf(String ylwsid) {

		String sql = "select t.name,t.sex,t.age,t.region,t.bed,t.preengagementnumber,t.operdate,"
				+ "t.designed_opt_name,a.blood_pressure,a.pulse,a.observetime,a.awareness_operation,a.muscular_soreness,"
				+ "a.allsick,a.allvomit,a.faucesache,a.soundhoarseness,a.observepeople,a.nerve_blocked_remark,a.nerve_blocked_observetime,"
				+ "a.lumbago,a.neuralsick,a.neuralvomit,a.leg_paresthesia,a.leg_movement,a.neural_observepeople,a.neural_remark,"
				+ "a.remark,a.analgesiaplan,a.observeaftertime,a.quietvas,a.exercisevas,a.naupathia,a.vomit,a.pruritus,a.observepeopleafter"
				+ ",a.remarkafter from SM_REG_OPT t left join SM_ANAES_WATCH a on t.id=a.doc_id where t.id=:ylwsid";

		Map m = new HashMap();
		m.put("ylwsid", ylwsid);
		List l = this.findBySql(sql, m);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Object obj : l) {
			Object[] o = (Object[]) obj;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("NAME", o[0]);
			if ("0".equals(o[1])) {
				map.put("SEX", "男");
			}
			if ("1".equals(o[1])) {
				map.put("SEX", "女");
			}
			map.put("AGE", o[2]);
			map.put("REGION", o[3]);
			map.put("BED", o[4]);
			map.put("PREENGAGEMENTNUMBER", o[5]);
			map.put("OPERDATE", o[6]);
			map.put("DESIGNED_OPT_NAME", o[7]);
			map.put("BLOOD_PRESSURE", o[8]);
			map.put("PULSE", o[9]);

			if (o[10] != null) {

				map.put("OBSERVETIME", o[10]);
			} else {
				map.put("OBSERVETIME", "");
			}
			map.put("AWARENESS_OPERATION", o[11]);
			map.put("MUSCULAR_SORENESS", o[12]);
			map.put("ALLSICK", o[13]);
			map.put("ALLVOMIT", o[14]);
			map.put("FAUCESACHE", o[15]);
			map.put("SOUNDHOARSENESS", o[16]);

			if (o[17] != null) {

				map.put("OBSERVEPEOPLE", o[17]);
			} else {
				map.put("OBSERVEPEOPLE", "");
			}
			if (o[18] != null) {

				map.put("NERVE_BLOCKED_REMARK", o[18]);
			} else {
				map.put("NERVE_BLOCKED_REMARK", "");
			}
			if (o[19] != null) {

				map.put("NERVE_BLOCKED_OBSERVETIME", o[19]);
			} else {
				map.put("NERVE_BLOCKED_OBSERVETIME", "");
			}

			map.put("LUMBAGO", o[20]);
			map.put("NEURALSICK", o[21]);
			map.put("NEURALVOMIT", o[22]);
			map.put("LEG_PARESTHESIA", o[23]);
			map.put("LEG_MOVEMENT", o[24]);
			if (o[25] != null) {

				map.put("NEURAL_OBSERVEPEOPLE", o[25]);
			} else {
				map.put("NEURAL_OBSERVEPEOPLE", "");
			}
			if (o[26] != null) {

				map.put("NEURAL_REMARK", o[26]);
			} else {
				map.put("NEURAL_REMARK", "");
			}
			if (o[27] != null) {

				map.put("REMARK", o[27]);
			} else {
				map.put("REMARK", "");
			}
			map.put("ANALGESIAPLAN", o[28]);
			if (o[29] != null) {

				map.put("OBSERVEAFTERTIME", o[29]);
			} else {
				map.put("OBSERVEAFTERTIME", "");
			}
			if (o[30] != null) {

				map.put("QUIETVAS", o[30]);
			} else {
				map.put("QUIETVAS", "");
			}
			if (o[31] != null) {

				map.put("EXERCISEVAS", o[31]);
			} else {
				map.put("EXERCISEVAS", "");
			}
			map.put("NAUPATHIA", o[32]);
			map.put("VOMIT", o[33]);
			map.put("PRURITUS", o[34]);
			if (o[35] != null) {

				map.put("OBSERVEPEOPLEAFTER", o[35]);
			} else {
				map.put("OBSERVEPEOPLEAFTER", "");
			}
			if (o[36] != null) {
				map.put("REMARKAFTER", o[36]);
			} else {
				map.put("REMARKAFTER", "");
			}

			result.add(map);
		}
		return result;
	}
	
	
	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.YlwsDao#getSmRegOpt(java.lang.String)
	 */
	@Override
	public SmRegOpt getSmRegOpt(String id) {
		return this.get(id);
	}


	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.YlwsDao#saveSmRegOpt(com.znyy.bean.SmRegOpt)
	 */
	@Override
	public void saveSmRegOpt(SmRegOpt sro) {
		this.save(sro);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.YlwsDao#saveSmWritTemplate(com.znyy.bean.SmWritTemplate)
	 */
	@Override
	public void saveSmWritTemplate(SmWritTemplate wt) {
		this.getHibernateTemplate().save(wt);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.YlwsDao#getSmWritTemplatePersonal(java.lang.String)
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePersonal(String userid) {
		return this.getHibernateTemplate().find("from SmWritTemplate where wirtType='03' and type='1' and userid=? and enable='0'",userid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.YlwsDao#getSmWritTemplatePublic()
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePublic() {
		return this.getHibernateTemplate().find("from SmWritTemplate where wirtType='03' and type='0' and enable='0'");
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.YlwsDao#delTemplate(java.lang.String)
	 */
	@Override
	public void delTemplate(String templateId) {
		SmWritTemplate s = this.getHibernateTemplate().get(SmWritTemplate.class, templateId);
		s.setEnable("1");
		this.getHibernateTemplate().save(s);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.YlwsDao#getTemplateVal(java.lang.String)
	 */
	@Override
	public SmAnaesWatch getTemplateVal(String templateId) {
		SmWritTemplate s = this.getHibernateTemplate().get(SmWritTemplate.class, templateId);
		return this.getHibernateTemplate().get(SmAnaesWatch.class, Integer.parseInt(s.getWirtId()));
	}

}
