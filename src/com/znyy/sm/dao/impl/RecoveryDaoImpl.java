/**
 * 
 */
package com.znyy.sm.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmRecoveryData;
import com.znyy.bean.SmRecoveryFromMachine;
import com.znyy.bean.SmRecoveryroomRecord;
import com.znyy.bean.SmRegOpt;
import com.znyy.sm.dao.RecoveryDao;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author 白东旭
 * @date 2016-5-4
 */
public class RecoveryDaoImpl extends GenericDaoImpl<SmRecoveryroomRecord, String> implements
		RecoveryDao {

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.RecoveryDao#getSmRegOptByYlwsid(java.lang.String)
	 */
	@Override
	public SmRegOpt getSmRegOptByYlwsid(String ylwsid) {
		return this.getHibernateTemplate().get(SmRegOpt.class, ylwsid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.RecoveryDao#saveRecord(com.znyy.bean.SmRecoveryroomRecord)
	 */
	@Override
	public void saveRecord(SmRecoveryroomRecord record) {
		this.save(record);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.RecoveryDao#getRecordByYlwsid(java.lang.String)
	 */
	@Override
	public SmRecoveryroomRecord getRecordByYlwsid(String ylwsid) {
		List<SmRecoveryroomRecord> list = this.getHibernateTemplate().find("from SmRecoveryroomRecord where operationId=?",ylwsid);
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public void saveVitalSignsData(SmRecoveryFromMachine recovery) {
		this.getHibernateTemplate().save(recovery);
		
	}

	@Override
	public Map<String, Object> getCollectDatesByRoomAndTime(String roomCode) {
		Map<String, Object> result = new HashMap<String, Object>();
		String hql=" from SmRecoveryFromMachine where itemCode=? and roomCode=? order by time desc";			
		String[] str = {"BP_SYS","BP_DIAS","HEARTRATE","RESPRATE","SPO2"};
		for (int i = 0; i < str.length; i++) {
			List<?> list = this.getHibernateTemplate().find(hql, str[i],roomCode);
			if (!list.isEmpty()) {
				SmRecoveryFromMachine srfm =  (SmRecoveryFromMachine) list.get(0);
				result.put(str[i], srfm.getItemValue());
			}
			
		}
		return result;
	}

	@Override
	public void updateRecord(SmRecoveryroomRecord record) {
		this.getHibernateTemplate().merge(record);
	}

	@Override
	public void addRecoveryDatas(SmRecoveryData srdata) {
		this.getHibernateTemplate().save(srdata);
	}

	@Override
	public List<Map<String, Object>> loadRecoveryData(String operationId) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		SmRecoveryroomRecord srrr = getRecordByYlwsid(operationId);
		String hql=" from SmRecoveryData where operationId=?  order by time asc";	
		List<?> list = this.getHibernateTemplate().find(hql, operationId);
		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
			Map<String, Object> map = new HashMap<String, Object>();
			SmRecoveryData smRecoveryData = (SmRecoveryData) iterator.next();
			int i = smRecoveryData.getRemarkInterval();
			long l = smRecoveryData.getTime().getTime()-srrr.getEnterTime().getTime();
			double dou= l/(i*60*1000);
			int d3 = (int) Math.floor(dou);
			map.put("BP_SYS", smRecoveryData.getBpSys());
			map.put("BP_DIAS", smRecoveryData.getBpDias());
			map.put("HEARTRATE", smRecoveryData.getHeartrate());
			map.put("RESPRATE", smRecoveryData.getResprate());
			map.put("SPO2", smRecoveryData.getSpo2());
			map.put("POINT", d3);
			result.add(map);
		}
		
		return result;
	}

	@Override
	public List<Map<String, Object>> loadRecoveryPrintDataByOptId(String operationId) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result.add(this.getRegPrintData(operationId));
		result.add(this.getRecoveryPrintData(operationId));
		System.out.println("------------------------------恢复室记录单打印----------------------------------");
		return result;
	}
	/**
	 * @方法名称: getRegOptPrintData
	 * @功能描述: 获取基本信息与恢复小结打印数据
	 * @作者:崔连瑞
	 * @创建时间:2016-3-31 上午9:36:04
	 * @param  operationId  
	 * @return Map<String,Object>
	 */
	public Map<String,Object> getRegPrintData(String operationId){
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		m.put("operationId", operationId);
		String sql=" select  " +
				   " r.id,r.name,r.sex,r.age,r.age_mon,r.weight,r.bed,r.hid,r.region, " +
				   " r.diagnosis_name,r.designed_opt_name,r.designed_anaes_method_name, " +
				   " r.anesthetist,r.instrnurse1,r.instrnurse2, rr.enter_time,rr.exit_time, " +
				   " rr.sober_score,rr.physical_activity_score,rr.breathing_score,rr.total_score, " +
				   " rr.destination  " +
				   " from sm_reg_opt r   " +
				   " left join sm_recoveryroom_record  rr on r.id=rr.operation_id  " +
				   " where r.id=:operationId   ";
        List<?> l = this.findBySql(sql, m);
		for (Object obj : l) {
			Object[] o = (Object[]) obj;
			result.put("ID", o[0]);
			result.put("NAME", o[1]);
			result.put("SEX", "0".equals(o[2])?"男":"女");
			if(o[3]!=null&&o[4]!=null){
				result.put("AGE", o[3].toString()+"岁"+o[4]+"月");
			}
			if(o[3]!=null&&o[4]==null){
				result.put("AGE", o[3].toString()+"岁");
			}
			if(o[3]==null&&o[4]!=null){
				result.put("AGE", o[4]+"月");
			}
			if(o[3]==null&&o[4]==null){
				result.put("AGE","");
			}
			result.put("WEIGHT", o[5]!=null?o[5]:"");
			result.put("BED", o[6]!=null?o[6]:"");
			result.put("HID", o[7]!=null?o[7]:"");
			result.put("REGION", o[8]!=null?o[8]:"");
			result.put("DIAGNOSIS_NAME", o[9]!=null?o[9]:"");
			result.put("DESIGNED_OPT_NAME", o[10]!=null?o[10]:"");
			result.put("DESIGNED_ANAES_METHOD_NAME", o[11]!=null?o[11]:"");
			result.put("ANESTHETIST", o[12]!=null?o[12]:"");
			if(o[13]!=null&&o[14]!=null){
				result.put("INSTRNURSE", o[13]+"、"+o[14]);
			}
			if(o[13]!=null&&o[14]==null){
				result.put("INSTRNURSE", o[13]);
			}
			if(o[13]==null&&o[14]!=null){
				result.put("INSTRNURSE", o[14]);
			}
			if(o[13]==null&&o[14]==null){
				result.put("INSTRNURSE", "");
			}
			result.put("ENTER_TIME", o[15].toString());
			result.put("EXIT_TIME", o[16].toString());
			result.put("SOBER_SCORE", o[17]!=null?o[17]:"");
			result.put("PHYSICAL_ACTIVITY_SCORE", o[18]!=null?o[18]:"");
			result.put("BREATHING_SCORE", o[19]!=null?o[19]:"");
			result.put("TOTAL_SCORE", o[20]!=null?o[20]:"");
			result.put("DESTINATION", o[21]!=null?o[21]:"");
		}
		return result;
	}
	/**
	 * @方法名称: getRecoveryPrintData
	 * @功能描述: 获取体征信息打印数据
	 * @作者:崔连瑞
	 * @创建时间:2016-3-31 上午9:36:04
	 * @param  operationId  
	 * @return Map<String,Object>
	 */
	public Map<String,Object> getRecoveryPrintData(String operationId){
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		m.put("operationId", operationId);
		String sql=" select " +
				   " t.operation_id,t.time,t.remark_interval,t.bp_sys,t.bp_dias,t.heartrate,t.resprate,t.spo2  " +
				   " from sm_recovery_data t " +
				   " where t.operation_id=:operationId  " +
				   " order by t.time asc ";
		List<?> l = this.findBySql(sql, m);
		int i=0;
			for (Object obj : l) {
				Object[] o = (Object[]) obj;
				result.put("DATA_TIME"+i, o[1].toString().substring(0, o[1].toString().length()-5));
				result.put("DATA_BP"+i, (o[3]!=null?o[3].toString():"")+"/"+(o[4]!=null?o[4].toString():""));
				result.put("DATA_HR"+i, o[5]!=null?o[5].toString():"");
				result.put("DATA_RR"+i, o[6]!=null?o[6].toString():"");
				result.put("DATA_SPO"+i, o[7]!=null?o[7].toString():"");
				i++;
			}
		return result;
	}
	
	
	

}
