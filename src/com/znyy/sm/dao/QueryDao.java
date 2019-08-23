/**  
 * @Title: QueryDao.java 
 * @Package com.znyy.sm.dao 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-19 上午9:20:07 
 */ 
package com.znyy.sm.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SysDiseaseArea;

/** 
 * @ClassName: QueryDao 
 * @Description: 手术查询Dao接口 
 * @author 白东旭
 * @date 2016-2-19 上午9:20:07 
 */
public interface QueryDao {

	/**
	 * @param hospitalId 
	 * @Title: getSroByDay 
	 * @Description: 获取某一天手术信息
	 * @author 白东旭
	 * @date 2016-2-19 上午10:11:58
	 * @param @param time
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getSroByDay(Date time, String hospitalId);

	/**
	 * @Title: getSmRegOptById 
	 * @Description: 根据id获取手术信息
	 * @author 白东旭
	 * @date 2016-2-19 下午1:53:54
	 * @param @param sroid
	 * @param @return
	 * @return SmRegOpt
	 * @throws 
	 *
	 */ 
	
	SmRegOpt getSmRegOptById(String sroid);

	/**
	 * @Title: saveSmRegOpt 
	 * @Description: 保存或更新手术信息
	 * @author 白东旭
	 * @date 2016-2-19 下午1:56:01
	 * @param @param sro
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void saveSmRegOpt(SmRegOpt sro);

	/**
	 * @Title: getSmDiagnosedefList 
	 * @Description: 获取诊断列表
	 * @author 白东旭
	 * @date 2016-2-19 下午3:55:05
	 * @param @return
	 * @return List<SmDiagnosedef>
	 * @throws 
	 *
	 */ 
	
	List<SmDiagnosedef> getSmDiagnosedefList();

	/**
	 * @Title: getSmOperdefList 
	 * @Description: 获取手术名称列表
	 * @author 白东旭
	 * @date 2016-2-19 下午5:42:57
	 * @param @return
	 * @return List<SmOperdef>
	 * @throws 
	 *
	 */ 
	
	List<SmOperdef> getSmOperdefList();

	/**
	 * @Title: getSmOperationPeopleList 
	 * @Description: 获取手术人员列表
	 * @author 白东旭
	 * @date 2016-2-19 下午5:50:59
	 * @param @param string
	 * @param @return
	 * @return List<SmOperationPeople>
	 * @throws 
	 *
	 */ 
	
	List<SmOperationPeople> getSmOperationPeopleList(String string);

	/**
	 * @Title: getSmOperroomList 
	 * @Description: 获取手术室列表
	 * @author 白东旭
	 * @date 2016-2-22 上午11:14:35
	 * @param @return
	 * @return List<SmOperroom>
	 * @throws 
	 *
	 */ 
	
	List<SmOperroom> getSmOperroomList();

	/**
	 * @Title: getSmRegionList 
	 * @Description: 获取病区列表
	 * @author 白东旭
	 * @date 2016-2-22 下午2:08:48
	 * @param @return
	 * @return List<SysDiseaseArea>
	 * @throws 
	 *
	 */ 
	
	List<SysDiseaseArea> getSmRegionList();

	/**
	 * @Title: getSmRoomById 
	 * @Description: 获取手术室
	 * @author 白东旭
	 * @date 2016-3-8 上午9:20:24
	 * @param @param SmOperroom
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */ 
	
	SmOperroom getSmRoomById(String room);

	/**
	 * @param hospitalId 
	 * @Title: getOutsideScreen 
	 * @Description: 获取手术室外大屏幕
	 * @author 白东旭
	 * @date 2016-3-21 下午2:34:25
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getOutsideScreen(String hospitalId);

	/**
	 * @throws ParseException 
	 * @Title: getInsideScreen 
	 * @Description: 获取手术室内大屏幕
	 * @author 白东旭
	 * @date 2016-3-22 上午11:02:31
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getInsideScreen(String hospitalId) throws ParseException;

	/**
	 * @param mz 
	 * @param ss 
	 * @param zd 
	 * @param maxage 
	 * @param minage 
	 * @param sex 
	 * @param dateTo 
	 * @param dateFrom 
	 * @Description: 科研查询
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws ParseException 
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-27
	 */
	List<Map<String, Object>> getScientificQuery(String dateFrom, String dateTo, String sex, String minage, String maxage, String zd, String ss, String mz) throws ParseException;

}
