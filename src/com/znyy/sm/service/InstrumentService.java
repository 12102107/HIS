/**  
 * @Title: InstrumentService.java
 * @Package com.znyy.sm.service
 * @Description: TODO
 * @author 白东旭
 * @date 2016年8月2日
 */
package com.znyy.sm.service;

import java.util.List;
import java.util.Map;

import com.common.util.Page;
import com.znyy.bean.SmInstrument;
import com.znyy.bean.SmInstrumentPackage;
import com.znyy.bean.SmInstrumentPackageItem;
import com.znyy.bean.SmRegOpt;

/**
 * ClassName: InstrumentService 
 * @Description: TODO
 * @author 白东旭
 * @date 2016年8月2日
 */
public interface InstrumentService {

	/**
	 * @Description: 分页获取手术器械列表
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
	 * @Description: 添加手术器械
	 * @param @param i   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	void addInstrument(SmInstrument i);

	/**
	 * @Description: 根据Id获取手术器械
	 * @param @param id
	 * @param @return   
	 * @return SmInstrument  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	SmInstrument getInstrumentById(String id);

	/**
	 * @Description: 修改手术器械
	 * @param @param i   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	void modInstrument(SmInstrument i);

	/**
	 * @Description: 根据id删除手术器械
	 * @param @param id   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月2日
	 */
	void delInstrument(String id);

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
	 * @Description: 添加手术包
	 * @param @param p
	 * @param @param iid
	 * @param @param inum   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月4日
	 */
	void addInstrumentPackage(SmInstrumentPackage p, List<String> iid,
			List<String> inum);

	/**
	 * @Description: 根据手术包id获取手术包
	 * @param @param id
	 * @param @return   
	 * @return SmInstrumentPackage  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月5日
	 */
	SmInstrumentPackage getInstrumentPackageById(String id);

	/**
	 * @Description: 根据手术包id获取包内手术器械
	 * @param @param id
	 * @param @return   
	 * @return List<SmInstrumentPackageItem>  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月5日
	 */
	List<SmInstrumentPackageItem> getPackageItemList(String id);

	/**
	 * @Description: 修改手术包
	 * @param @param p
	 * @param @param iid
	 * @param @param inum   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月5日
	 */
	void modInstrumentPackage(SmInstrumentPackage p, List<String> iid,
			List<String> inum);

	/**
	 * @Description: 删除手术包
	 * @param @param id   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月5日
	 */
	void delInstrumentPackage(String id);

	/**
	 * @Description: 获取手术信息
	 * @param @param id
	 * @param @return   
	 * @return SmRegOpt  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月8日
	 */
	SmRegOpt getSmRegOpt(String id);

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
	 * @Description: 获取手术器械信息
	 * @param @param id
	 * @param @return   
	 * @return Map<String,String>  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月8日
	 */
	Map<String, String> getInstrumentInfo(String id);

	/**
	 * @Description: 保存或更改手术清单
	 * @param @param id
	 * @param @param iid
	 * @param @param itype
	 * @param @param inum   
	 * @return void  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月8日
	 */
	void saveOrUpdateInstrumentCheck(String id, List<String> iid,
			List<String> itype, List<String> inum);

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
	 * @Description: 获取打印基本信息
	 * @param @param id
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月10日
	 */
	List<Map<String, Object>> getPrintInfo(String id);

	/**
	 * @Description: 获取打印列表信息
	 * @param @param id
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月10日
	 */
	List<Map<String, Object>> getPrintList(String id);

	/**
	 * @Description: 校验手术器械
	 * @param @param name
	 * @param @param specifications
	 * @param @return   
	 * @return boolean  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月30日
	 */
	boolean getCheckNameSpecifications(String name, String specifications);

	/**
	 * @Description: 校验手术包
	 * @param @param name
	 * @param @return   
	 * @return boolean  
	 * @throws
	 * @author 白东旭
	 * @date 2016年8月30日
	 */
	boolean getCheckPackageName(String name);

}
