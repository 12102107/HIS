/**  
 * @Title: StatisticsDao.java 
 * @Package com.znyy.sm.dao 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-3-15 下午1:35:31 
 */ 
package com.znyy.sm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.XtUnit;

/** 
 * @ClassName: StatisticsDao 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-3-15 下午1:35:31 
 */
public interface StatisticsDao {

	/**
	 * @Title: getSmDept 
	 * @Description: 获取科室列表
	 * @author 白东旭
	 * @date 2016-3-15 下午2:04:54
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
	 * @date 2016-3-15 下午2:10:08
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
	 * @date 2016-3-15 下午2:13:56
	 * @param @return
	 * @return List<SmOperationPeople>
	 * @throws 
	 *
	 */ 
	
	List<SmOperationPeople> getNurse();

	/**
	 * @Title: getLevelStatistics 
	 * @Description: 获取手术等级统计
	 * @author 白东旭
	 * @date 2016-3-15 下午3:56:18
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
	
	List<Map<String, String>> getLevelStatistics(Date start, Date end,
			String sType, String deptname, String sopname, String nursename);

	/**
	 * @Title: getWorkingTime 
	 * @Description: 获取工作时间
	 * @author 白东旭
	 * @date 2016-3-17 下午5:09:16
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
	
	List<Map<String, String>> getWorkingTime(Date start, Date end,
			String sType, String deptname, String sopname, String nursename);

	/**
	 * @Description: 镇痛治疗例数统计
	 * @param @param parse
	 * @param @param parse2
	 * @param @return   
	 * @return List<Object>
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-12
	 */
	List<Object> getAnalgesiaStatistics(Date parse, Date parse2);

	/**
	 * @Description: 心肺复苏例数统计
	 * @param @param parse
	 * @param @param parse2
	 * @param @return   
	 * @return List<Object>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-12
	 */
	List<Object> getCprStatistics(Date parse, Date parse2);

	/**
	 * @Description: 麻醉复苏管理例数统计
	 * @param @param parse
	 * @param @param parse2
	 * @param @return   
	 * @return List<Object>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-12
	 */
	List<Object> getRecoveryStatistics(Date parse, Date parse2);

	/**
	 * @Description: niss统计
	 * @param @param parse
	 * @param @param parse2
	 * @param @return   
	 * @return List<Object>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-13
	 */
	List<Object> getNissStatistics(Date parse, Date parse2);

	/**
	 * @Description: 获取麻醉方法
	 * @param @return   
	 * @return List<Object>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-15
	 */
	List<Object> getMethod();

	/**
	 * @Description: 查询 某短时间内 某科室 某个麻醉方法 统计
	 * @param @param start 开始时间
	 * @param @param end 结束时间
	 * @param @param obj 麻醉方法名
	 * @param @param deptname 科室名称
	 * @param @return   
	 * @return List<Object>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-15
	 */
	List<Object> getMethodStatisticsDept(String start, String end, String obj,
			String deptname);

	/**
	 * @Description: 查询 某短时间内 某麻醉医师 某个麻醉方法 统计
	 * @param @param start
	 * @param @param end
	 * @param @param obj
	 * @param @param sopname
	 * @param @return   
	 * @return List<Object>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-15
	 */
	List<Object> getMethodStatisticsSop(String start, String end, String obj,
			String sopname);


}
