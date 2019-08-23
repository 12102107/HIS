

package com.znyy.sys.hospital.service.impl;

import java.util.List;
import java.util.Map;

import com.znyy.sys.hospital.dao.HospitalDao;
import com.znyy.sys.hospital.service.HospitalService;

 /** 
 * @类名称: HospitalServiceImpl
 * @类描述:系统医院表service实现类
 * @作者:慕金剑
 * @创建时间:2016-3-21 下午4:21:23
 */
 
public class HospitalServiceImpl implements HospitalService {
	private HospitalDao hospitalDao;
	
	@Override
	public List<Map<String, Object>> getHospitalAll() {
		return hospitalDao.getHospitalAll();
	}

	public HospitalDao getHospitalDao() {
	
		return hospitalDao;
	}

	public void setHospitalDao(HospitalDao hospitalDao) {
	
		this.hospitalDao = hospitalDao;
	} 
	

}

