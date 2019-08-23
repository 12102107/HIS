package com.znyy.sm.dao;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;

public interface OperationPeopleDao {

	
	 /**
	 * @方法名称: getSpList
	 * @功能描述: 获取手术人员信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 上午10:17:04
	 * @param code
	 * @param yx 
	 * @param lx 
	 * @param lb 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	public Page getSpList(String code, String lb, String lx, String yx, int parmpage, Integer pageSize);

	
	
	
	 /**
	 * @方法名称: getSpById
	 * @功能描述: 修改手术人员跳转
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:21:18
	 * @param id
	 * @return SmOperdef   
	 */
	 
	public SmOperationPeople getSpById(Integer id);

	/**
	 * @方法名称: modSpList
	 * @功能描述: 修改手术人员
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:58:17
	 * @param Sp void   
	 */
	 
	public void modSpList(SmOperationPeople sp);


	 /**
	 * @方法名称: addSp
	 * @功能描述: 添加手术人员信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午2:48:36
	 * @param sp void   
	 */
	 
	public void addSp(SmOperationPeople sp);

	
	 /**
	 * @方法名称: getSpByName
	 * @功能描述: ajax验证手术人员名称
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:15:28
	 * @param name
	 * @return List<SmOperationPeople>   
	 */
	 
	public List<SmOperationPeople> getSpByName(String name);

	
	 /**
	 * @方法名称: getSpByCode
	 * @功能描述: ajax验证手术人员代码
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:47:17
	 * @param code
	 * @return List<SmOperationPeople>   
	 */
	 
	public List<SmOperationPeople> getSpByCode(int code);




	public List<SmOperationPeople> getSops(String enable, String role);




	
	 /**
	 * @方法名称: getSopsByZimu
	 * @功能描述: AJAX联动查询手术人员
	 * @作者:付士山
	 * @创建时间:2016-1-18 下午3:14:31
	 * @param zimu
	 * @return List<SmOperationPeople>   
	 */
	 
	public List<SmOperationPeople> getSopsByZimu(String zimu);
	/**
	 * @方法名称: getSqzdByZimu
	 * @功能描述: AJAX联动查询术前诊断名称
	 * @作者:崔连瑞
	 * @创建时间:2016-04-28 下午3:14:31
	 * @param zimu
	 * @return List<SmOperationPeople>   
	 */
	
	public List<SmDiagnosedef> getSqzdByZimu(String zimu);
	/**
	 * @方法名称: getNsssByZimu
	 * @功能描述: AJAX联动查询拟施手术
	 * @作者:崔连瑞
	 * @创建时间:2016-04-28 下午3:14:31
	 * @param zimu
	 * @return List<SmOperdef>   
	 */
	
	public List<SmOperdef> getNsssByZimu(String zimu);




	
	 /**
	 * @方法名称: getOpList
	 * @功能描述: 查询麻醉医师列表
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:37:05
	 * @param enable
	 * @return List<SmOperationPeople>   
	 */
	 
	public List<SmOperationPeople> getOpList(String enable);




	public List<SmOperationPeople> getLxList();




	public List<SmOperationPeople> getAnesthetistersByRole(String yishiRole);




	public List<SmOperationPeople> getAnesthetistersByPy(String zimu);




	public List<SmOperationPeople> AnesthetistersByyishiName(String yishiName);




	public List<SmOperationPeople> getAnesthetistersByPy1(String zimu);




	public List<SmOperationPeople> getAnesthetistersByPy2(String zimu);



}
