/**  
 * @Title: OptNurseServiceImpl.java 
 * @Package com.znyy.sm.service.impl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-3-7 上午11:23:48 
 */ 
package com.znyy.sm.service.impl;

import java.util.List;
import java.util.Map;

import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmNurseAnaes;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmOptNurse;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;
import com.znyy.bean.SmWritstate;
import com.znyy.sm.dao.OptNurseDao;
import com.znyy.sm.dao.QueryDao;
import com.znyy.sm.dao.WritstateDao;
import com.znyy.sm.service.OptNurseService;

/** 
 * @ClassName: OptNurseServiceImpl 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-3-7 上午11:23:48 
 */
public class OptNurseServiceImpl implements OptNurseService {

	private OptNurseDao optNurseDao;

	/**
	 * @return the optNurseDao
	 */
	public OptNurseDao getOptNurseDao() {
		return optNurseDao;
	}

	/**
	 * @param optNurseDao the optNurseDao to set
	 */
	public void setOptNurseDao(OptNurseDao optNurseDao) {
		this.optNurseDao = optNurseDao;
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
	 * @see com.znyy.sm.service.OptNurseService#getSmRegOptById(java.lang.String)
	 */
	@Override
	public SmRegOpt getSmRegOptById(String ylwsid) {
		SmRegOpt sro =  queryDao.getSmRegOptById(ylwsid);
		SmOperroom room =  queryDao.getSmRoomById(sro.getRoom());
		sro.setRoom(room.getName());
		return sro;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#getSmOperdefList()
	 */
	@Override
	public List<SmOperdef> getSmOperdefList() {
		return queryDao.getSmOperdefList();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#getSmDiagnosedefList()
	 */
	@Override
	public List<SmDiagnosedef> getSmDiagnosedefList() {
		return queryDao.getSmDiagnosedefList();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#getSopVague(java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getSopVague(String word) {
		return optNurseDao.getSopVague(word);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#getSmOperationPeopleList(java.lang.String)
	 */
	@Override
	public List<SmOperationPeople> getSmOperationPeopleList(String string) {
		return queryDao.getSmOperationPeopleList(string);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#saveOptNurse(com.znyy.bean.SmOptNurse)
	 */
	@Override
	public void saveOptNurse(SmOptNurse nurse, List<SmNurseAnaes> anaes) {
		if(nurse.getId().equals("")) {
			nurse.setId(null);
		}
		nurse.setStatus("0");
		optNurseDao.saveOptNurse(nurse);
		for(SmNurseAnaes a:anaes) {
			if(a.getId().equals("")) {
				a.setId(null);
			}	
			a.setOptNurseId(nurse.getId());
			optNurseDao.saveSmNurseAnaes(a);
		}
		SmWritstate s = writstateDao.getSmWritstateBySroId(nurse.getOperationId());
		if(s==null) {
			s = new SmWritstate();
			s.setOperationId(nurse.getOperationId());
		}
		s.setNurse("01");
		writstateDao.saveSmWritstate(s);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#getOptNurseBySroId(java.lang.String)
	 */
	@Override
	public SmOptNurse getOptNurseBySroId(String ylwsid) {
		return optNurseDao.getOptNurseBySroId(ylwsid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#getSmNurseAnaesBySroid(java.lang.String)
	 */
	@Override
	public List<SmNurseAnaes> getSmNurseAnaesBySroid(String ylwsid) {
		return optNurseDao.getSmNurseAnaesBySroid(ylwsid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#saveOptNurseCommit(com.znyy.bean.SmOptNurse, java.util.List)
	 */
	@Override
	public void saveOptNurseCommit(SmOptNurse nurse, List<SmNurseAnaes> anaes) {
		if(nurse.getId().equals("")) {
			nurse.setId(null);
		}
		nurse.setStatus("1");
		optNurseDao.saveOptNurse(nurse);
		for(SmNurseAnaes a:anaes) {
			if(a.getId().equals("")) {
				a.setId(null);
			}	
			a.setOptNurseId(nurse.getId());
			optNurseDao.saveSmNurseAnaes(a);
		}
		SmWritstate s = writstateDao.getSmWritstateBySroId(nurse.getOperationId());
		if(s==null) {
			s = new SmWritstate();
			s.setOperationId(nurse.getOperationId());
		}
		s.setNurse("02");
		writstateDao.saveSmWritstate(s);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#getOptNursePrint(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getOptNursePrint(String ylwsid) {
		return optNurseDao.getOptNursePrint(ylwsid);
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
	 * @see com.znyy.sm.service.OptNurseService#saveOptNurseTemplate(com.znyy.bean.SmOptNurse, java.util.List, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void saveOptNurseTemplate(SmOptNurse nurse,
			List<SmNurseAnaes> anaes, String templateType, String templateName,
			String userid) {
		nurse.setId(null);
		nurse.setOperationId(null);
		nurse.setStatus("0");
		optNurseDao.saveOptNurse(nurse);
		for(SmNurseAnaes a:anaes) {
			a.setId(null);
			a.setOptNurseId(nurse.getId());
			optNurseDao.saveSmNurseAnaes(a);
		}
		
		SmWritTemplate wt = new SmWritTemplate();
		wt.setName(templateName);
		wt.setType(templateType);
		wt.setWirtId(nurse.getId());
		wt.setWirtType("02");
		wt.setEnable("0");
		if(templateType.equals("1")) {
			wt.setUserid(userid);
		}
		optNurseDao.saveSmWritTemplate(wt);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#getSmWritTemplatePersonal(java.lang.String)
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePersonal(String userid) {
		return optNurseDao.getSmWritTemplatePersonal(userid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#getSmWritTemplatePublic()
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePublic() {
		return optNurseDao.getSmWritTemplatePublic();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#delTemplate(java.lang.String)
	 */
	@Override
	public void delTemplate(String templateId) {
		optNurseDao.delTemplate(templateId);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OptNurseService#getTemplateVal(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getTemplateVal(String templateId) {
		return optNurseDao.getTemplateVal(templateId);
	}

}
