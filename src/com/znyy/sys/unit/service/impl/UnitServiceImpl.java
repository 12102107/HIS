package com.znyy.sys.unit.service.impl;

import java.util.List;
import java.util.Map;

import com.znyy.sys.unit.dao.UnitDao;
import com.znyy.sys.unit.service.UnitService;

public class UnitServiceImpl implements UnitService{
	
	private UnitDao unitDao;

	@Override
	public List<Map<String, Object>> getMoreUnitSel(Integer userid,
			String hospitalcode, String moreunitflag) {
		return unitDao.getMoreUnitSel(userid, hospitalcode, moreunitflag);
		
	}

	public UnitDao getUnitDao() {
	
		return unitDao;
	}

	public void setUnitDao(UnitDao unitDao) {
	
		this.unitDao = unitDao;
	}

}
