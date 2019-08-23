package com.znyy.sm.dao;
import java.util.List;
import com.common.util.Page;
import com.znyy.bean.SmMedicine;


public interface MedicineDao {

	
	 /**
	 * @方法名称: getMedList
	 * @功能描述: 获取药品库信息
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午9:43:42
	 * @param name
	 * @param yx 
	 * @param pinyin 
	 * @param dw 
	 * @param fl 
	 * @param code 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getMedList(String name, String code, String fl, String dw, String pinyin, String yx, int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: getMedById
	 * @功能描述: 药品库修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午10:44:59
	 * @param id
	 * @return SmMedicine   
	 */
	 
	SmMedicine getMedById(Integer id);


	
	 /**
	 * @方法名称: modMedList
	 * @功能描述: 药品库修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午10:52:28
	 * @param smed void   
	 */
	 
	void modMedList(SmMedicine smed);


	
	 /**
	 * @方法名称: getMedByName
	 * @功能描述: ajax验证药品库名称
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午11:13:35
	 * @param name
	 * @return List<SmMedicine>   
	 */
	 
	List<SmMedicine> getMedByName(String name);


	
	 /**
	 * @方法名称: addMed
	 * @功能描述: 添加药品库信息
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午11:28:01
	 * @param med void   
	 */
	 
	void addMed(SmMedicine med);


	List<SmMedicine> getDwList();


	List<SmMedicine> getFlList();

}
