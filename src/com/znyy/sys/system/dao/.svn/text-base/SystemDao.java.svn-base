

package com.znyy.sys.system.dao;

import java.util.List;
import java.util.Map;

import com.common.dao.GenericDAO;
import com.znyy.bean.XtSystem;

 /** 
 * @类名称: HospitalDao
 * @类描述:系统表dao
 * @作者:慕金剑
 * @创建时间:2016-3-21 下午4:21:54
 */
 
public interface SystemDao extends GenericDAO<XtSystem,String>{
	
	 /**
	 * @方法名称: selectSystemList
	 * @功能描述: 根据医院code查询所有启用系统
	 * @作者:杨云博
	 * @创建时间:2016-4-5 上午10:31:27
	 * @param hoscode
	 * @return List<Map<String,Object>>   
	 */
	 
	public List<Map<String, Object>> selectSystemList(String hoscode);
	
	 /**
	 * @方法名称: selectSystemList
	 * @功能描述: 根据医院code和用户查询所有启用系统
	 * @作者:杨云博
	 * @创建时间:2016-4-12 下午4:37:23
	 * @param hoscode
	 * @param uid
	 * @return List<Map<String,Object>>   
	 */
	 
	public List<Map<String, Object>> selectSystemList(String hoscode,String uid);
}

