package com.znyy.sm.service;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SysIcdCode;

public interface DiagnosedefService {

	
	/**
	 * 
	 * @方法名称: getZdList
	 * @功能描述: 获取诊断信息列表
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:17:06
	 * @param name
	 * @param pinyin 
	 * @param yx 
	 * @param parmpage
	 * @param pageSize
	 * @return Page
	 */
	public Page getZdList(String name,String yx, String pinyin, int parmpage, Integer pageSize);
	
	
	/**
	 * 
	 * @方法名称: getZdById
	 * @功能描述: 根据id获取一条诊断信息
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:17:56
	 * @param id
	 * @return SmDiagnosedef
	 */
	public SmDiagnosedef getZdById(Integer id);

	
	/**
	 * 
	 * @方法名称: modZdList
	 * @功能描述: 修改诊断列表信息
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:18:48
	 * @param sm void
	 */
	public void modZdList(SmDiagnosedef sm);

	/**
	 * 
	 * @方法名称: addZd
	 * @功能描述: 添加诊断列表信息
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:18:54
	 * @param zd void
	 */
	public void addZd(SmDiagnosedef zd);


	
	 /**
	 * @方法名称: getZdByName
	 * @功能描述: ajax验证诊断名称
	 * @作者:付士山
	 * @创建时间:2015-12-25 上午10:34:29
	 * @param name
	 * @return List<SmDiagnosedef>   
	 */
	 
	public List<SmDiagnosedef> getZdByName(String name);


	public List<SmDiagnosedef> getZds(String enable);


	/**
	 * @Description: 获取系统诊断icd列表
	 * @param @return   
	 * @return List<SysIcdCode>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-16
	 */
	public List<SysIcdCode> getSysIcdCodeList();


	/**
	 * @Description: 模糊查询诊断
	 * @param @param zimu
	 * @param @return   
	 * @return List<SysIcdCode>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-16
	 */
	public List<SysIcdCode> querySqzdName(String zimu);
	

}
