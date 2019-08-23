package com.znyy.sm.service.impl;

import java.util.List;

import com.common.dao.GenericDaoImpl;
import com.znyy.bean.SmMedicine;

import com.znyy.bean.ZyOperationApply;
import com.znyy.sm.dao.HisDao;
import com.znyy.sm.service.HisService;

public class HisServiceImpl extends GenericDaoImpl<SmMedicine, String> implements HisService {
private HisDao hisDao;

public HisDao getHisDao() {
	return hisDao;
}

public void setHisDao(HisDao hisDao) {
	this.hisDao = hisDao;
}

@Override
public List<ZyOperationApply> getZyOperationApply() {
	
	return hisDao.getOperationApply();
}

@Override
public ZyOperationApply getHisById(long id) {
	
	return hisDao.getHisById(id);
	
}

@Override
public void modHisList(ZyOperationApply hiss) {
	
	hisDao.modHisList(hiss);
}
































}
