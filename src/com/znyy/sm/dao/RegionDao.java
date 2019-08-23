package com.znyy.sm.dao;
import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmRegion;
import com.znyy.bean.SysDiseaseArea;

public interface RegionDao {

	
	 /**
	 * @方法名称: getRegionList
	 * @功能描述: 获取病区信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:36:46
	 * @param name
	 * @param yx 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getRegionList(String name, String yx, int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: getRegionByName
	 * @功能描述: ajax验证病区名称
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:59:47
	 * @param name
	 * @return List<SmRegion>   
	 */
	 
	List<SmRegion> getRegionByName(String name);


	
	 /**
	 * @方法名称: addRegion
	 * @功能描述: 添加病区信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午1:00:00
	 * @param sr void   
	 */
	 
	void addRegion(SmRegion sr);


	
	 /**
	 * @方法名称: getRegionById
	 * @功能描述: 病区修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午1:07:57
	 * @param id
	 * @return SmRegion   
	 */
	 
	SmRegion getRegionById(Integer id);


	
	 /**
	 * @方法名称: modRegionList
	 * @功能描述: 病区修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午1:15:08
	 * @param srn void   
	 */
	 
	void modRegionList(SmRegion srn);


	List<SysDiseaseArea> getRegions();

	
}
