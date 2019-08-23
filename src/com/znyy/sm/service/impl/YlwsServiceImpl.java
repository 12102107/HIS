package com.znyy.sm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.common.util.Page;
import com.znyy.bean.Accede;
import com.znyy.bean.SmAnaesPlanDocument;
import com.znyy.bean.SmAnaesWatch;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;
import com.znyy.bean.SmWritstate;
import com.znyy.sm.dao.WritstateDao;
import com.znyy.sm.dao.YlwsDao;
import com.znyy.sm.service.YlwsService;

public class YlwsServiceImpl implements YlwsService{

	private YlwsDao ylwsDao;
	
	public YlwsDao getYlwsDao() {
		return ylwsDao;
	}

	public void setYlwsDao(YlwsDao ylwsDao) {
		this.ylwsDao = ylwsDao;
	}

	public Page getYlwsList(int parmpage, Integer pageSize,String hospitalId) {
		
		return ylwsDao.getYlwsList(parmpage, pageSize, hospitalId);
	}

	private WritstateDao writstateDao;
	
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

	/** 
	 * @方法名称: getMztysList
	 * @功能描述:医疗文书跳转到麻醉同意书
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:35:37
	 * @param ylwsid
	 * @return
	 * @see com.znyy.sm.service.YlwsService#getMztysList(java.lang.String)
	 */
	 
	@Override
	public List<SmRegOpt> getMztysList(String ylwsid) {
		
		return ylwsDao.getYlwsList(ylwsid);
	}

	
	 /** 
	 * @方法名称: getMztysById
	 * @功能描述:根据医疗文书id查询麻醉同意书
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:32:33
	 * @param ylwsid
	 * @return
	 * @see com.znyy.sm.service.YlwsService#getMztysById(java.lang.String)
	 */
	 
	@Override
	public Accede getMztysById(String ylwsid) {
		
		Accede mztys =  ylwsDao.getMztysById(ylwsid);
		return mztys;
		
	}

	
	 /** 
	 * @方法名称: modMztysList
	 * @功能描述:同意书修改
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:35:00
	 * @param mztys
	 * @see com.znyy.sm.service.YlwsService#modMztysList(com.znyy.bean.Accede)
	 */
	 
	@Override
	public void modMztysList(Accede mztys) {
		
	      ylwsDao.modMztysList(mztys);
		
	}

	
	 /** 
	 * @方法名称: addMztys
	 * @功能描述:同意书添加
	 * @作者:付士山
	 * @创建时间:2016-2-25 上午9:15:56
	 * @param tys
	 * @see com.znyy.sm.service.YlwsService#addMztys(com.znyy.bean.Accede)
	 */
	 
	@Override
	public void addMztys(Accede tys) {
		
		 ylwsDao.addMztys(tys);
		
	}

	@Override
	public List<Map<String, Object>> getMzPrint(String ylwsid) {
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		result = ylwsDao.getMzPrint(ylwsid);
		return result;
		
	}

	
	 /** 
	 * @方法名称: getMzjhById
	 * @功能描述:根据医疗文书id查询麻醉计划
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午10:17:09
	 * @param ylwsid
	 * @return
	 * @see com.znyy.sm.service.YlwsService#getMzjhById(java.lang.String)
	 */
	 
	@Override
	public SmAnaesPlanDocument getMzjhById(String ylwsid) {
		
		SmAnaesPlanDocument mzjhs =  ylwsDao.getMzjhById(ylwsid);
		return mzjhs;
		
	}

	
	 /** 
	 * @方法名称: modMzjhList
	 * @功能描述:麻醉计划修改
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午11:04:53
	 * @param mzjhs
	 * @see com.znyy.sm.service.YlwsService#modMzjhList(com.znyy.bean.SmAnaesPlanDocument)
	 */
	 
	@Override
	public void modMzjhList(SmAnaesPlanDocument mzjhs) {
		
		ylwsDao.modMzjhList(mzjhs);
		
	}

	
	 /** 
	 * @方法名称: addMzjh
	 * @功能描述:麻醉计划添加
	 * @作者:付士山
	 * @创建时间:2016-3-8 上午11:06:40
	 * @param mzjh
	 * @see com.znyy.sm.service.YlwsService#addMzjh(com.znyy.bean.SmAnaesPlanDocument)
	 */
	 
	@Override
	public void addMzjh(SmAnaesPlanDocument mzjh) {
		
		 ylwsDao.addMzjh(mzjh);
		
	}

	@Override
	public List<Map<String, Object>> getMzPrintMzjh(String ylwsid) {
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		result = ylwsDao.getMzPrintMzjh(ylwsid);
		return result;
	}

	
	 /** 
	 * @方法名称: getShsfById
	 * @功能描述:根据医疗文书id查询术后随访
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:23:55
	 * @param ylwsid
	 * @return
	 * @see com.znyy.sm.service.YlwsService#getShsfById(java.lang.String)
	 */
	 
	@Override
	public SmAnaesWatch getShsfById(String ylwsid) {
		
		SmAnaesWatch shsfs =  ylwsDao.getShsfById(ylwsid);
		return shsfs;
	}
	
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.YlwsService#modArchived(java.lang.String)
	 */
	@Override
	public void modArchived(String id) {
		SmRegOpt sro = ylwsDao.getSmRegOpt(id);
		sro.setArchstate("01");
		ylwsDao.saveSmRegOpt(sro);
	}
	
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.YlwsService#getSmWirtstateVal(java.lang.String)
	 */
	@Override
	public String getSmWirtstateVal(String id) {
		String r = "";
		SmWritstate s = writstateDao.getSmWritstateBySroId(id);
		if(s==null) {
			return "1";
		} else {
			int i = 0;
			
			if(!"02".equals(s.getPrevisit())) {
				r += " 术前访视";
				i++;
			}
			
			if(!"02".equals(s.getConsent())) {
				r += " 同意书";
				i++;
			}
			
			if(!"02".equals(s.getRecord())) {
				r += " 麻醉记录";
				i++;
			}

			if(!"02".equals(s.getSummary())) {
				r += " 麻醉总结";
				i++;
			}
			
			if(!"02".equals(s.getFollow())) {
				r += " 术后随访";
				i++;
			}
			
			if(!"02".equals(s.getNurse())) {
				r += " 手术护理";
				i++;
			}			
			
			if(i==0) {
				return "0";
			} else {
				r += " 未完成，请完成后归档！";
				return r;
			}
		}
	}

	
	 /** 
	 * @方法名称: modShfsList
	 * @功能描述:术后随访修改
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:46:36
	 * @param shsfs
	 * @see com.znyy.sm.service.YlwsService#modShfsList(com.znyy.bean.SmAnaesWatch)
	 */
	 
	@Override
	public void modShfsList(SmAnaesWatch shsfs) {
		
		ylwsDao.modShfsList(shsfs);
		
	}

	
	 /** 
	 * @方法名称: addShfs
	 * @功能描述:术后随访修改
	 * @作者:付士山
	 * @创建时间:2016-3-10 上午10:48:44
	 * @param shsf
	 * @see com.znyy.sm.service.YlwsService#addShfs(com.znyy.bean.SmAnaesWatch)
	 */
	 
	@Override
	public void addShfs(SmAnaesWatch shsf) {
		
		 ylwsDao.addShfs(shsf);
		
	}

	@Override
	public List<Map<String, Object>> getPrintSf(String ylwsid) {
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		result = ylwsDao.getPrintSf(ylwsid);
		return result;
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.YlwsService#saveShsfTemplate(com.znyy.bean.SmAnaesWatch, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void saveShsfTemplate(SmAnaesWatch shsf, String templateType,
			String templateName, String userid) {
		shsf.setId(null);
		shsf.setDocId(null);
		ylwsDao.addShfs(shsf);
		
		
		SmWritTemplate wt = new SmWritTemplate();
		wt.setName(templateName);
		wt.setType(templateType);
		wt.setWirtId(shsf.getId().toString());
		wt.setWirtType("03");
		wt.setEnable("0");
		if(templateType.equals("1")) {
			wt.setUserid(userid);
		}
		ylwsDao.saveSmWritTemplate(wt);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.YlwsService#getSmWritTemplatePersonal(java.lang.String)
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePersonal(String userid) {
		return ylwsDao.getSmWritTemplatePersonal(userid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.YlwsService#getSmWritTemplatePublic()
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePublic() {
		return ylwsDao.getSmWritTemplatePublic();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.YlwsService#delTemplate(java.lang.String)
	 */
	@Override
	public void delTemplate(String templateId) {
		ylwsDao.delTemplate(templateId);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.YlwsService#getTemplateVal(java.lang.String)
	 */
	@Override
	public SmAnaesWatch getTemplateVal(String templateId) {
		return ylwsDao.getTemplateVal(templateId);
	}


	
}
