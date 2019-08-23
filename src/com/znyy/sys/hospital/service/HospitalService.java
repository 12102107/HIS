
package com.znyy.sys.hospital.service;

import java.util.List;
import java.util.Map;

 /** 
 * @类名称: HospitalService
 * @类描述:系统医院表service
 * @作者:慕金剑
 * @创建时间:2016-3-21 下午4:18:21
 */
 
public interface HospitalService {
	
	 /**
	 * @方法名称: getHospitalAll
	 * @功能描述: 获取所有启用医院
	 * @作者:杨云博
	 * @创建时间:2016-3-22 上午10:02:38
	 * @return List<Map<String,Object>>   
	 */
	 
	public List<Map<String, Object>> getHospitalAll();

}

