package com.znyy.sm.service;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmDept;
import com.znyy.bean.XtUnit;

public interface DeptService {

	
	 /**
	 * @方法名称: getDeptList
	 * @功能描述: 获取科室信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午9:43:56
	 * @param name
	 * @param yx 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getDeptList(String name, String yx, int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: addDept
	 * @功能描述: 添加科室信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:45:07
	 * @param dept void   
	 */
	 
	void addDept(SmDept dept);


	
	 /**
	 * @方法名称: getDeptByName
	 * @功能描述: ajax验证科室名称
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:51:25
	 * @param name
	 * @return List<SmOperroom>   
	 */
	 
	List<SmDept> getDeptByName(String name);


	
	 /**
	 * @方法名称: getDeptById
	 * @功能描述: 科室修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:58:18
	 * @param id
	 * @return SmDept   
	 */
	 
	SmDept getDeptById(Integer id);


	
	 /**
	 * @方法名称: modDeptList
	 * @功能描述: 科室修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:05:44
	 * @param sdt void   
	 */
	 
	void modDeptList(SmDept sdt);


	List<XtUnit> getDepts(String hospitalId);

	
}
