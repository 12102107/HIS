/**  
 * @Title: ArrangeService.java 
 * @Package com.znyy.sm.service 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-23 下午1:21:49 
 */ 
package com.znyy.sm.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/** 
 * @ClassName: ArrangeService 
 * @Description: 排班管理Service 
 * @author 白东旭
 * @date 2016-2-23 下午1:21:49 
 */
public interface ArrangeService {

	/**
	 * @param dateTo 
	 * @param dateFrom 
	 * @throws ParseException 
	 * @param userid 
	 * @Title: getMyArrangeWeek 
	 * @Description: 获取近一周内我的排班
	 * @author 白东旭
	 * @date 2016-2-23 下午2:39:34
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getMyArrangeWeek(String userid, String dateFrom, String dateTo) throws ParseException;

	/**
	 * @param riqi 
	 * @param dateTo 
	 * @param dateFrom 
	 * @throws ParseException 
	 * @Title: getArrangeWeek 
	 * @Description: 获取一周内全部排班
	 * @author 白东旭
	 * @date 2016-2-24 上午9:18:31
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getArrangeWeek(String dateFrom, String dateTo) throws ParseException;

	/**
	 * @throws ParseException 
	 * @Title: getArrangeWeekPrint 
	 * @Description: 获取打印数据
	 * @author 白东旭
	 * @date 2016-2-24 下午5:59:54
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getArrangeWeekPrint() throws ParseException;

}
