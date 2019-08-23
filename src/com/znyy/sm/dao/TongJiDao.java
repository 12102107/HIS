package com.znyy.sm.dao;

import java.text.ParseException;
import java.util.List;

import com.znyy.bean.SmRegOpt;

public interface TongJiDao {

	
	 /**
	 * @param yishi 
	 * @param dateTo 
	 * @param dateFrom 
	 * @方法名称: getMzlsList
	 * @功能描述: 获取麻醉例数统计数据
	 * @作者:付士山
	 * @创建时间:2016-3-14 上午10:55:03
	 * @return List<SmRegOpt>   
	 */
	 
	List<SmRegOpt> getMzlsList(String yishi, String dateFrom, String dateTo);

	List<SmRegOpt> getMzlsListAll(String yishi, String dateFrom, String dateTo);

	
	 /**
	 * @param asaDateFrom 
	 * @param xuanze 
	 * @param asahu 
	 * @param asayi 
	 * @param asake 
	 * @param asaDateTo 
	 * @方法名称: getAsaList
	 * @功能描述: 获取ASA统计数据
	 * @作者:付士山
	 * @创建时间:2016-3-18 下午1:24:41
	 * @return List   
	 * @throws ParseException 
	 */
	 
	List getAsaList(String asaDateFrom, String asaDateTo, String asake, String asayi, String asahu, String xuanze) throws ParseException;

	
	 /**
	 * @方法名称: getSqshList
	 * @功能描述: 获取术前术后诊断统计数据
	 * @作者:付士山
	 * @创建时间:2016-3-22 下午2:42:04
	 * @param dateFrom
	 * @param dateTo
	 * @param xuanze 
	 * @return List   
	 */
	 
	List getSqshList(String dateFrom, String dateTo, String xuanze);


}