package com.znyy.sm.service;
import java.util.List;
import com.common.util.Page;
import com.znyy.bean.SmMedicalTakeWay;

public interface MedicalTakeWayService {

	
	 /**
	 * @方法名称: getWayList
	 * @功能描述: 获取给药途径信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:22:28
	 * @param name
	 * @param cx 
	 * @param fl 
	 * @param way 
	 * @param code 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getWayList(String cname, String code, String way, String fl, String cx, int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: getWayById
	 * @功能描述: 给药途径修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:39:02
	 * @param id
	 * @return SmMedicalTakeWay   
	 */
	 
	SmMedicalTakeWay getWayById(String id);

	
	 /**
	 * @方法名称: modWayList
	 * @功能描述: 给药途径修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:39:07
	 * @param way void   
	 */
	 
	void modWayList(SmMedicalTakeWay way);


	
	 /**
	 * @方法名称: getWayByCode
	 * @功能描述: 
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午2:16:07
	 * @param code
	 * @return List<SmMedicalTakeWay>   
	 */
	 
	List<SmMedicalTakeWay> getWayByCode(String code);


	
	 /**
	 * @方法名称: getWayByName
	 * @功能描述: 
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午2:16:05
	 * @param name
	 * @return List<SmMedicalTakeWay>   
	 */
	 
	List<SmMedicalTakeWay> getWayByName(String name);


	
	 /**
	 * @方法名称: addWay
	 * @功能描述: 添加给药途径信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午4:29:26
	 * @param mtw void   
	 */
	 
	void addWay(SmMedicalTakeWay mtw);

}