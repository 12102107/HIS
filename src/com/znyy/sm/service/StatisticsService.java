/**  
 * @Title: StatisticsService.java 
 * @Package com.znyy.sm.service 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-3-15 下午1:34:26 
 */ 
package com.znyy.sm.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.XtUnit;

/** 
 * @ClassName: StatisticsService 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-3-15 下午1:34:26 
 */
public interface StatisticsService {

	/**
	 * @Title: getSmDept 
	 * @Description: 获取手术科室
	 * @author 白东旭
	 * @date 2016-3-15 下午2:04:11
	 * @param @return
	 * @return List<XtUnit>
	 * @throws 
	 *
	 */ 
	
	List<XtUnit> getSmDept();

	/**
	 * @Title: getAnesthetist 
	 * @Description: 获取麻醉医师
	 * @author 白东旭
	 * @date 2016-3-15 下午2:09:35
	 * @param @return
	 * @return List<SmOperationPeople>
	 * @throws 
	 *
	 */ 
	
	List<SmOperationPeople> getAnesthetist();

	/**
	 * @Title: getNurse 
	 * @Description: 获取手术护士
	 * @author 白东旭
	 * @date 2016-3-15 下午2:13:34
	 * @param @return
	 * @return List<SmOperationPeople>
	 * @throws 
	 *
	 */ 
	
	List<SmOperationPeople> getNurse();

	/**
	 * @throws ParseException 
	 * @Title: getLevelStatistics 
	 * @Description: 查询手术等级统计
	 * @author 白东旭
	 * @date 2016-3-15 下午3:24:27
	 * @param @param start
	 * @param @param end
	 * @param @param sType
	 * @param @param deptname
	 * @param @param sopname
	 * @param @param nursename
	 * @param @return
	 * @return List<Map<String,String>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, String>> getLevelStatistics(String start, String end,
			String sType, String deptname, String sopname,
			String nursename) throws ParseException;

	/**
	 * @throws ParseException 
	 * @Title: getWorkingTime 
	 * @Description: 获取工作时间
	 * @author 白东旭
	 * @date 2016-3-17 下午5:08:09
	 * @param @param start
	 * @param @param end
	 * @param @param sType
	 * @param @param deptname
	 * @param @param sopname
	 * @param @param nursename
	 * @param @return
	 * @return List<Map<String,String>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, String>> getWorkingTime(String start, String end,
			String sType, String deptname, String sopname, String nursename) throws ParseException;

	/**
	 * @Description: 镇痛治疗例数统计
	 * @param @param start
	 * @param @param end
	 * @param @return   
	 * @return List<Object> 
	 * @throws ParseException 
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-12
	 */
	List<Object> getAnalgesiaStatistics(String start, String end) throws ParseException;

	/**
	 * @Description: 心肺复苏例数统计
	 * @param @param start
	 * @param @param end
	 * @param @return   
	 * @return List<Object>  
	 * @throws ParseException 
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-12
	 */
	List<Object> getCprStatistics(String start, String end) throws ParseException;

	/**
	 * @Description: 麻醉复苏管理例数统计
	 * @param @param start
	 * @param @param end
	 * @param @return   
	 * @return List<Object>  
	 * @throws ParseException 
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-12
	 */
	List<Object> getRecoveryStatistics(String start, String end) throws ParseException;

	/**
	 * @Description: niss统计
	 * @param @param start
	 * @param @param end
	 * @param @return   
	 * @return List<Object>  
	 * @throws ParseException 
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-13
	 */
	List<Object> getNissStatistics(String start, String end) throws ParseException;

	/**
	 * @Description: 获取麻醉方法统计
	 * @param @param start
	 * @param @param end
	 * @param @param sType
	 * @param @param deptname
	 * @param @param sopname
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws ParseException 
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-15
	 */
	List<Map<String, Object>> getMethodStatistics(String start, String end,
			String sType, String deptname, String sopname) throws ParseException;


}
