/**  
 * @Title: ArrangeDao.java 
 * @Package com.znyy.sm.dao 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-23 下午1:23:40 
 */ 
package com.znyy.sm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/** 
 * @ClassName: ArrangeDao 
 * @Description: 排班管理Dao 
 * @author 白东旭
 * @date 2016-2-23 下午1:23:40 
 */
public interface ArrangeDao {

	/**
	 * @param userid 
	 * @Title: getMyArrangeByDay 
	 * @Description: 获取某天内我的排班
	 * @author 白东旭
	 * @date 2016-2-23 下午2:42:06
	 * @param @param parse
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getMyArrangeByDay(Date parse, String userid);

	/**
	 * @param riqi 
	 * @param dateTo 
	 * @param dateFrom 
	 * @Title: getArrangeByDay 
	 * @Description: 获取某一天的排班
	 * @author 白东旭
	 * @date 2016-2-24 上午9:19:45
	 * @param @param parse
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getArrangeByDay(Date parse, String dateFrom, String dateTo );

	/**
	 * @Title: getArrangeByDayPrint 
	 * @Description: 获取某一天排版打印信息
	 * @author 白东旭
	 * @date 2016-2-25 上午10:56:27
	 * @param @param parse
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getArrangeByDayPrint(Date parse);



}
