/**  
 * @Title: InstrumentDao.java
 * @Package com.znyy.sm.dao
 * @Description: TODO
 * @author 白东旭
 * @date 2016年8月2日
 */
package com.znyy.sm.dao;

import java.util.List;
import java.util.Map;

import com.common.util.Page;
import com.znyy.bean.SmInstrument;
import com.znyy.bean.SmInstrumentCheck;
import com.znyy.bean.SmInstrumentPackage;
import com.znyy.bean.SmInstrumentPackageItem;

/**
 * ClassName: InstrumentDao 
 * @Description: TODO
 * @author 白东旭
 * @date 2016年8月2日
 */
public interface InstrumentDao {

	/**
	 * @Description: 分页查询手术器械列表
	 * @param @param name
	 * @param @param common
	 * @param @param parmpage
	 * @param @param pageSize
	 * @param @return   
	 * @return Page  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	Page getInstrumentList(String name, String common, int parmpage,
			Integer pageSize);

	/**
	 * @Description: 保存手术器械
	 * @param @param i   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	void saveInstrument(SmInstrument i);

	/**
	 * @Description: 获取手术器械
	 * @param @param id
	 * @param @return   
	 * @return SmInstrument  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	SmInstrument getInstrumentById(String id);

	/**
	 * @Description: 删除手术器械
	 * @param @param i   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	void delInstrument(SmInstrument i);

	/**
	 * @Description: 获取手术包列表
	 * @param @param name
	 * @param @param common
	 * @param @param parmpage
	 * @param @param pageSize
	 * @param @return   
	 * @return Page  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月4日
	 */
	Page getInstrumentPackageList(String name, String common, int parmpage,
			Integer pageSize);

	/**
	 * @Description: 获取器械列表
	 * @param @return   
	 * @return List<SmInstrument>  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月4日
	 */
	List<SmInstrument> getInstrumentList();

	/**
	 * @Description: 保存手术包
	 * @param @param p   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月4日
	 */
	void saveInstrumentPackage(SmInstrumentPackage p);

	/**
	 * @Description: 保存手术包器械
	 * @param @param item   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月4日
	 */
	void saveInstrumentPackageItem(SmInstrumentPackageItem item);

	/**
	 * @Description: 获取手术包
	 * @param @param id
	 * @param @return   
	 * @return SmInstrumentPackage  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月5日
	 */
	SmInstrumentPackage getInstrumentPackageById(String id);

	/**
	 * @Description: 获取手术包内器械
	 * @param @param id
	 * @param @return   
	 * @return List<SmInstrumentPackageItem>  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月5日
	 */
	List<SmInstrumentPackageItem> getPackageItemList(String id);

	/**
	 * @Description: 删除手术包内器械
	 * @param @param item   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月5日
	 */
	void delPackageItem(SmInstrumentPackageItem item);

	/**
	 * @Description: 获取手术包信息
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月8日
	 */
	List<Map<String, Object>> getInstrumentPackage();

	/**
	 * @Description: 保存手术器械清单项
	 * @param @param check   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月8日
	 */
	void saveInstrumentCheck(SmInstrumentCheck check);

	/**
	 * @Description: 获取手术器械清单列表
	 * @param @param id
	 * @param @return   
	 * @return List<SmInstrumentCheck>  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月8日
	 */
	List<SmInstrumentCheck> getInstrumentCheckList(String id);

	/**
	 * @Description: 删除手术器械清单
	 * @param @param check   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月8日
	 */
	void delInstrumentCheck(SmInstrumentCheck check);

	/**
	 * @Description: 获取手术包清单
	 * @param @param id
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月8日
	 */
	List<Map<String, Object>> getInstrumentCheckPackage(String id);

	/**
	 * @Description: 获取手术器械清单 
	 * @param @param id
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月8日
	 */
	List<Map<String, Object>> getInstrumentCheckInstrument(String id);

	/**
	 * @Description: 根据名称 规格获取手术器械
	 * @param @param name
	 * @param @param specifications
	 * @param @return   
	 * @return SmInstrument  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月30日
	 */
	SmInstrument getSmInstrumentByNameSpecifications(String name,
			String specifications);

	/**
	 * @Description: 根据名称获取手术包
	 * @param @param name
	 * @param @return   
	 * @return SmInstrumentPackage  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月30日
	 */
	SmInstrumentPackage getSmInstrumentPackageByName(String name);


}
