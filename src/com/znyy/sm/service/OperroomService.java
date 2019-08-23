package com.znyy.sm.service;

import java.util.List;

import com.common.util.Page;

import com.znyy.bean.SmOperroom;

public interface OperroomService {

	
	 /**
	 * @方法名称: getOrList
	 * @功能描述: 获得手术室信息列表
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午1:03:02
	 * @param name
	 * @param yx 
	 * @param lx 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getOrList(String name, String lx, String yx, int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: addOr
	 * @功能描述: 添加手术室信息
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午1:30:33
	 * @param sor void   
	 */
	 
	void addOr(SmOperroom sor);


	
	 /**
	 * @方法名称: getOrById
	 * @功能描述: 手术室修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午3:31:54
	 * @param id
	 * @return SmOperroom   
	 */
	 
	SmOperroom getOrById(Integer id);


	
	 /**
	 * @方法名称: modOrList
	 * @功能描述: 修改手术室数据
	 * @作者:付士山
	 * @创建时间:2016-1-5 上午9:15:35
	 * @param or void   
	 */
	 
	void modOrList(SmOperroom or);


	
	 /**
	 * @方法名称: getOrByName
	 * @功能描述: ajax验证手术室名称
	 * @作者:付士山
	 * @创建时间:2016-1-5 上午9:46:57
	 * @param name
	 * @return List<SmOperationPeople>   
	 */
	 
	List<SmOperroom> getOrByName(String name);

	 
	List<SmOperroom> getRoomList(String enable, String string);

}
