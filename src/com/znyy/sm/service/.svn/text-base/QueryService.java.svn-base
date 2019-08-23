/**  
 * @Title: QueryService.java 
 * @Package com.znyy.sm.service 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-19 上午9:18:32 
 */ 
package com.znyy.sm.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SysCvFyzflb;
import com.znyy.bean.SysDiseaseArea;
import com.znyy.bean.SysIcdCode;
import com.znyy.bean.XtUnit;

/** 
 * @ClassName: QueryService 
 * @Description: 手术查询Service接口 
 * @author 白东旭
 * @date 2016-2-19 上午9:18:32 
 */
public interface QueryService {

	/**
	 * @param hospitalId 
	 * @throws ParseException 
	 * @Title: getSroListWeek 
	 * @Description: 获取一周内手术信息
	 * @author 白东旭
	 * @date 2016-2-19 上午9:39:08
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getSroListWeek(String hospitalId) throws ParseException;

	/**
	 * @Title: modCancelSro 
	 * @Description: 取消手术信息
	 * @author 白东旭
	 * @date 2016-2-19 下午1:52:13
	 * @param @param sroid
	 * @param @param reason
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void modCancelSro(String sroid, String reason);

	/**
	 * @Title: activateSro 
	 * @Description: 激活手术信息
	 * @author 白东旭
	 * @date 2016-2-19 下午2:14:57
	 * @param @param sroid
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void activateSro(String sroid);

	/**
	 * @throws ParseException 
	 * @Title: getSmRegOptById 
	 * @Description: 根据id获取手术信息
	 * @author 白东旭
	 * @date 2016-2-19 下午3:38:30
	 * @param @param sroid
	 * @param @return
	 * @return SmRegOpt
	 * @throws 
	 *
	 */ 
	
	SmRegOpt getSmRegOptById(String sroid) throws ParseException;

	/**
	 * @Title: getSmDiagnosedefList 
	 * @Description: 获取诊断列表
	 * @author 白东旭
	 * @date 2016-2-19 下午3:54:14
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
	 * @date 2016-2-19 下午5:42:24
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
	 * @date 2016-2-19 下午5:50:27
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
	 * @date 2016-2-22 上午11:13:05
	 * @param @return
	 * @return List<SmOperroom>
	 * @throws 
	 *
	 */ 
	
	List<SmOperroom> getSmOperroomList();

	/**
	 * @param operdate 
	 * @Title: modChangeSro 
	 * @Description: 修改手术信息
	 * @author 白东旭
	 * @date 2016-2-22 下午1:17:45
	 * @param @param sro
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void modChangeSro(SmRegOpt sro, Date operdate);

	/**
	 * @Title: getSmRegionList 
	 * @Description: 获取病区列表
	 * @author 白东旭
	 * @date 2016-2-22 下午2:07:33
	 * @param @return
	 * @return List<SysDiseaseArea>
	 * @throws 
	 *
	 */ 
	
	List<SysDiseaseArea> getSmRegionList();

	/**
	 * @param hospitalId 
	 * @param operdate 
	 * @Title: addEmergencySro 
	 * @Description: 保存紧急手术信息
	 * @author 白东旭
	 * @date 2016-2-23 上午9:22:54
	 * @param @param sro
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void addEmergencySro(SmRegOpt sro, Date operdate, String hospitalId);

	/**
	 * @param hospitalId 
	 * @Title: getOutsideScreen 
	 * @Description: 获取手术室外大屏幕显示信息
	 * @author 白东旭
	 * @date 2016-3-21 下午1:14:50
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getOutsideScreen(String hospitalId);

	/**
	 * @param hospitalId 
	 * @throws ParseException 
	 * @Title: getInsideScreen 
	 * @Description: 获取手术室内大屏幕显示信息
	 * @author 白东旭
	 * @date 2016-3-22 上午11:01:40
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getInsideScreen(String hospitalId) throws ParseException;

	/**
	 * @Description: 获取缴费类别
	 * @param @return   
	 * @return List<SysCvFyzflb>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-17
	 */
	List<SysCvFyzflb> getSysCvFyzflbList();

	/**
	 * @Description: 获取诊断代码表
	 * @param @return   
	 * @return List<SysIcdCode>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-17
	 */
	List<SysIcdCode> getSysIcdCodeList();

	/**
	 * @param mz 
	 * @param ss 
	 * @param zd 
	 * @param age 
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
	List<Map<String, Object>> getScientificQuery(String dateFrom, String dateTo, String sex, String age, String zd, String ss, String mz) throws ParseException;

	/**
	 * @Description: 获取科室
	 * @param @param hospitalId
	 * @param @return   
	 * @return List<XtUnit>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-7-7
	 */
	List<XtUnit> getDepts(String hospitalId);

}
