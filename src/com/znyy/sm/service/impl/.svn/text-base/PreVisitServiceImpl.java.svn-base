/**  
 * @Title: PreVisitServiceImpl.java 
 * @Package com.znyy.sm.service.impl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-29 下午1:29:10 
 */ 
package com.znyy.sm.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmPreTestData;
import com.znyy.bean.SmPreVisit;
import com.znyy.bean.SmPreVisitMedicalHistory;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;
import com.znyy.bean.SmWritstate;
import com.znyy.sm.dao.PreVisitDao;
import com.znyy.sm.dao.QueryDao;
import com.znyy.sm.dao.WritstateDao;
import com.znyy.sm.service.PreVisitService;

/** 
 * @ClassName: PreVisitServiceImpl 
 * @Description:  术前访视Service实现 
 * @author 白东旭
 * @date 2016-2-29 下午1:29:10 
 */
public class PreVisitServiceImpl implements PreVisitService {

	private PreVisitDao preVisitDao;

	/**
	 * @return the preVisitDao
	 */
	public PreVisitDao getPreVisitDao() {
		return preVisitDao;
	}

	/**
	 * @param preVisitDao the preVisitDao to set
	 */
	public void setPreVisitDao(PreVisitDao preVisitDao) {
		this.preVisitDao = preVisitDao;
	}
	
	private QueryDao queryDao;

	/**
	 * @return the queryDao
	 */
	public QueryDao getQueryDao() {
		return queryDao;
	}

	/**
	 * @param queryDao the queryDao to set
	 */
	public void setQueryDao(QueryDao queryDao) {
		this.queryDao = queryDao;
	}

	private WritstateDao writstateDao;
	
	
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#getSmRegOptById(java.lang.String)
	 */
	@Override
	public SmRegOpt getSmRegOptById(String ylwsid) {
		return queryDao.getSmRegOptById(ylwsid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#getMzysByUserid(java.lang.String)
	 */
	@Override
	public SmOperationPeople getMzysByUserid(String userid) {
		return preVisitDao.getMzysByUserid(userid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#savePreVisit(com.znyy.bean.SmPreVisit, com.znyy.bean.SmPreVisitMedicalHistory, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void savePreVisit(SmPreVisit preVisit,
			SmPreVisitMedicalHistory spVmh, String bP1, String bP2, String r,
			String p, String t, String elze,String visitDate) {
		
		spVmh.setOperationId(preVisit.getOperationId());
		preVisitDao.saveSpVmh(spVmh);
		
		preVisit.setVisitdate(visitDate.substring(0,10));
		preVisit.setVisittime(visitDate.substring(11,16));
		
		String spacialMonitoring = bP1+"-"+bP2+"-"+r+"-"+p+"-"+t;
		preVisit.setSpacialMonitoring(spacialMonitoring);
		preVisit.setSpacialMonitoringOther(elze);
		
		preVisitDao.savePreVisit(preVisit);
		
		SmWritstate s = writstateDao.getSmWritstateBySroId(preVisit.getOperationId());
		if(s==null) {
			s = new SmWritstate();
			s.setOperationId(preVisit.getOperationId());
		}
		s.setNurse("01");
		writstateDao.saveSmWritstate(s);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#getPreVisitByYlwsd(java.lang.String)
	 */
	@Override
	public SmPreVisit getPreVisitByYlwsd(String ylwsid) {
		return preVisitDao.getPreVisitByYlwsd(ylwsid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#getSpVmhByYlwsd(java.lang.String)
	 */
	@Override
	public SmPreVisitMedicalHistory getSpVmhByYlwsd(String ylwsid) {
		return preVisitDao.getSpVmhByYlwsd(ylwsid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#getSpacialMonitoring(com.znyy.bean.SmPreVisit)
	 */
	@Override
	public Map<String, String> getSpacialMonitoring(SmPreVisit preVisit) {
		if(preVisit.getSpacialMonitoring()==null) {
			return null;
		}
		String[] s = preVisit.getSpacialMonitoring().split("-");
		if(s.length>0) {
			Map<String, String> m = new HashMap<String,String>();
			if(s.length==5) {
				m.put("BP1", s[0]);
				m.put("BP2", s[1]);
				m.put("R", s[2]);
				m.put("P", s[3]);
				m.put("T", s[4]);
			}
			if(s.length==4) {
				m.put("BP1", s[0]);
				m.put("BP2", s[1]);
				m.put("R", s[2]);
				m.put("P", s[3]);
			}
			if(s.length==3) {
				m.put("BP1", s[0]);
				m.put("BP2", s[1]);
				m.put("R", s[2]);
			}
			if(s.length==2) {
				m.put("BP1", s[0]);
				m.put("BP2", s[1]);
			}
			if(s.length==1) {
				m.put("BP1", s[0]);
			}
			return m;
		} else {
			return null;
		}

	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#commitPreVisit(com.znyy.bean.SmPreVisit, com.znyy.bean.SmPreVisitMedicalHistory, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void commitPreVisit(SmPreVisit preVisit,
			SmPreVisitMedicalHistory spVmh, String bP1, String bP2, String r,
			String p, String t, String elze,String visitDate) throws ParseException {
		
		preVisit.setState("1");
		
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		preVisit.setFinishTime(f.parse(visitDate));
		
		this.savePreVisit(preVisit, spVmh, bP1, bP2, r, p, t, elze,visitDate);
		
		SmWritstate s = writstateDao.getSmWritstateBySroId(preVisit.getOperationId());
		if(s==null) {
			s = new SmWritstate();
			s.setOperationId(preVisit.getOperationId());
		}
		s.setNurse("02");
		writstateDao.saveSmWritstate(s);
	
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#getPreVisitPrint(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getPreVisitPrint(String ylwsid) {
		return preVisitDao.getPreVisitPrint(ylwsid);
	}

	/**
	 * @return the writstateDao
	 */
	public WritstateDao getWritstateDao() {
		return writstateDao;
	}

	/**
	 * @param writstateDao the writstateDao to set
	 */
	public void setWritstateDao(WritstateDao writstateDao) {
		this.writstateDao = writstateDao;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#savePreVisitTemplate(com.znyy.bean.SmPreVisit, com.znyy.bean.SmPreVisitMedicalHistory, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void savePreVisitTemplate(SmPreVisit preVisit,
			SmPreVisitMedicalHistory spVmh, String bP1, String bP2, String r,
			String p, String t, String elze, String visitDate,
			String templateType, String templateName, String userid) {
		
		if(visitDate!=null&&!visitDate.equals("")) {
			preVisit.setVisitdate(visitDate.substring(0,10));
			preVisit.setVisittime(visitDate.substring(11,16));
		}
		
		String spacialMonitoring = bP1+"-"+bP2+"-"+r+"-"+p+"-"+t;
		preVisit.setSpacialMonitoring(spacialMonitoring);
		preVisit.setSpacialMonitoringOther(elze);
		preVisit.setOperationId("");
		preVisit.setId(null);
		
		preVisitDao.savePreVisit(preVisit);
		
		spVmh.setDocId(preVisit.getId().toString());
		preVisitDao.saveSpVmh(spVmh);
		
		SmWritTemplate wt = new SmWritTemplate();
		wt.setName(templateName);
		wt.setType(templateType);
		wt.setWirtId(preVisit.getId().toString());
		wt.setWirtType("01");
		wt.setEnable("0");
		if(templateType.equals("1")) {
			wt.setUserid(userid);
		}
		preVisitDao.saveSmWritTemplate(wt);

	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#getSmWritTemplatePersonal(java.lang.String)
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePersonal(String userid) {
		return preVisitDao.getSmWritTemplatePersonal(userid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#getSmWritTemplatePublic()
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePublic() {
		return preVisitDao.getSmWritTemplatePublic();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#getTemplateVal(java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getTemplateVal(String templateId) {
		return preVisitDao.getTemplateVal(templateId);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.PreVisitService#delTemplate(java.lang.String)
	 */
	@Override
	public void delTemplate(String templateId) {
		preVisitDao.delTemplate(templateId);
	}

	@Override
	public Map<String, Object> loadTestResult(String hid) {
		return preVisitDao.loadTest(hid);
	}

	@Override
	public SmPreTestData getTestEventByOperationId(String operationId) {
		return preVisitDao.getTestEventByOptId(operationId);
	}

	@Override
	public void addTest(SmPreTestData sprd) {
		preVisitDao.addTestData(sprd);
	}

	@Override
	public void updateTest(SmPreTestData sprd) {
		preVisitDao.updateTestData(sprd);
	}


	
	
	
}
