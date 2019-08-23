

package com.znyy.sys.system.service.impl;

import java.util.List;
import java.util.Map;

import com.znyy.bean.XtSystem;
import com.znyy.sys.system.dao.SystemDao;
import com.znyy.sys.system.service.SystemService;

 /** 
 * @类名称: HospitalServiceImpl
 * @类描述:系统表service实现类
 * @作者:慕金剑
 * @创建时间:2016-3-21 下午4:21:23
 */
 
public class SystemServiceImpl implements SystemService {
    private SystemDao systemDao;
    
    @Override
	public XtSystem getSysById(String id) {
		return systemDao.get(id);
	}

	@Override
	public List<Map<String, Object>> selectSystemList(String hoscode,String uid) {
		return systemDao.selectSystemList(hoscode,uid);
	}
	
	@Override
	public List<Map<String, Object>> selectSystemList(String hoscode) {
		return systemDao.selectSystemList(hoscode);
	}

	
	public SystemDao getSystemDao() {
	
		return systemDao;
	}

	public void setSystemDao(SystemDao systemDao) {
	
		this.systemDao = systemDao;
	}

}

