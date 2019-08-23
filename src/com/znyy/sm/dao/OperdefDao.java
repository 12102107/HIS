package com.znyy.sm.dao;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmOperdef;


public interface OperdefDao {

	
	 /**
	 * @方法名称: getSsList
	 * @功能描述: 获取手术名称信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 上午10:17:04
	 * @param name
	 * @param code 
	 * @param pinyin 
	 * @param yx 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	public Page getSsList(String name, String yx, String pinyin, String code, int parmpage, Integer pageSize);
	
	
	 /**
	 * @方法名称: getSsById
	 * @功能描述: 修改手术名称跳转
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:21:18
	 * @param id
	 * @return SmOperdef   
	 */
	 
	public SmOperdef getSsById(String id);


	
	 /**
	 * @方法名称: modSsList
	 * @功能描述: 修改手术名称
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:58:17
	 * @param ss void   
	 */
	 
	public void modSsList(SmOperdef ss);


	
	 /**
	 * @方法名称: addSs
	 * @功能描述: 添加手术信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午2:48:36
	 * @param so void   
	 */
	 
	public void addSs(SmOperdef so);


	
	 /**
	 * @方法名称: getSsByName
	 * @功能描述: ajax验证手术名称
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:15:28
	 * @param name
	 * @return List<SmOperdef>   
	 */
	 
	public List<SmOperdef> getSsByName(String name);


	
	 /**
	 * @方法名称: getSsByCode
	 * @功能描述: ajax验证手术代码
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:47:17
	 * @param code
	 * @return List<SmOperdef>   
	 */
	 
	public List<SmOperdef> getSsByCode(String code);


	public List<SmOperdef> getOps(String enable);
}
