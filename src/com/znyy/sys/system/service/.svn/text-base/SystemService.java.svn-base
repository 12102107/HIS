
package com.znyy.sys.system.service;

import java.util.List;
import java.util.Map;

import com.znyy.bean.XtSystem;

 /** 
 * @类名称: SystemService
 * @类描述:系统表service
 * @作者:慕金剑
 * @创建时间:2016-3-21 下午5:37:31
 */
 
public interface SystemService {
	
	 /**
	 * @方法名称: getSysById
	 * @功能描述: 根据id获取系统信息
	 * @作者:杨云博
	 * @创建时间:2016-3-22 上午9:29:43
	 * @param id
	 * @return XtSystem   
	 */
	 
	public XtSystem getSysById(String id);

	/**
	 * @方法名称: selectSystemList
	 * @功能描述: 根据医院code查询所有启用系统
	 * @作者:杨云博
	 * @创建时间:2016-4-5 上午10:33:04
	 * @param hoscode
	 * @return List<Map<String,Object>>   
	 */
	 
	public List<Map<String, Object>> selectSystemList(String hoscode);
	
	
	 /**
	 * @方法名称: selectSystemList
	 * @功能描述: 根据医院code和用户查询所有启用系统
	 * @作者:杨云博
	 * @创建时间:2016-4-12 下午4:37:56
	 * @param hoscode
	 * @param uid
	 * @return List<Map<String,Object>>   
	 */
	 
	public List<Map<String, Object>> selectSystemList(String hoscode,String uid);
}

