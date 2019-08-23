package com.znyy.sm.dao;

import java.util.List;
import com.common.util.Page;
import com.znyy.bean.SmCheckItem;
public interface CheckItemDao {

	
	 /**
	 * @方法名称: getCheckList
	 * @功能描述: 获取检验项目信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:15:26
	 * @param name
	 * @param yx 
	 * @param code 
	 * @param dw 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getCheckList(String name, String dw, String code, String yx, int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: modCheckList
	 * @功能描述: 检验项目修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:42:12
	 * @param ci void   
	 */
	 
	void modCheckList(SmCheckItem ci);


	
	 /**
	 * @方法名称: getCheckById
	 * @功能描述: 检验项目修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:42:24
	 * @param id
	 * @return SmCheckItem   
	 */
	 
	SmCheckItem getCheckById(String id);


	
	 /**
	 * @方法名称: getCheckByName
	 * @功能描述: ajax验证检验项目名称
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午4:57:36
	 * @param name
	 * @return List<SmCheckItem>   
	 */
	 
	List<SmCheckItem> getCheckByName(String name);


	
	 /**
	 * @方法名称: getCheckByCode
	 * @功能描述: ajax验证检验项目代码 
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午4:57:40
	 * @param code
	 * @return List<SmCheckItem>   
	 */
	 
	List<SmCheckItem> getCheckByCode(String code);


	
	 /**
	 * @方法名称: addCheck
	 * @功能描述: 添加检验项目信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午5:15:55
	 * @param sci void   
	 */
	 
	void addCheck(SmCheckItem sci);

	
}
