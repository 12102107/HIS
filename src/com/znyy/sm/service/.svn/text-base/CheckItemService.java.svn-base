package com.znyy.sm.service;
import java.util.List;
import com.common.util.Page;
import com.znyy.bean.SmCheckItem;
public interface CheckItemService {

	
	 /**
	 * @方法名称: getCheckList
	 * @功能描述: 
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:14:22
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
	 * @方法名称: getCheckById
	 * @功能描述: 检验项目修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:40:38
	 * @param id
	 * @return SmCheckItem   
	 */
	 
	SmCheckItem getCheckById(String id);


	
	 /**
	 * @方法名称: modCheckList
	 * @功能描述: 检验项目修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:40:58
	 * @param ci void   
	 */
	 
	void modCheckList(SmCheckItem ci);


	
	 /**
	 * @方法名称: getCheckByName
	 * @功能描述: ajax验证检验项目名称
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午4:56:08
	 * @param name
	 * @return List<SmCheckItem>   
	 */
	 
	List<SmCheckItem> getCheckByName(String name);


	
	 /**
	 * @方法名称: getCheckByCode
	 * @功能描述: ajax验证检验项目代码 
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午4:55:58
	 * @param code
	 * @return List<SmCheckItem>   
	 */
	 
	List<SmCheckItem> getCheckByCode(String code);


	
	 /**
	 * @方法名称: addCheck
	 * @功能描述: 添加检验项目信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午5:15:03
	 * @param sci void   
	 */
	 
	void addCheck(SmCheckItem sci);

}
