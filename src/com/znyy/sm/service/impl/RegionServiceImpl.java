package com.znyy.sm.service.impl;
import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmRegion;
import com.znyy.bean.SysDiseaseArea;
import com.znyy.sm.dao.RegionDao;

import com.znyy.sm.service.RegionService;

public class RegionServiceImpl implements RegionService {

	private RegionDao regionDao;

	public RegionDao getRegionDao() {
	
		return regionDao;
	}

	public void setRegionDao(RegionDao regionDao) {
	
		this.regionDao = regionDao;
	}

	
	 /** 
	 * @方法名称: getRegionList
	 * @功能描述:获取病区信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:36:34
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.RegionService#getRegionList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getRegionList(String name,String yx, int parmpage, Integer pageSize) {
		
		return regionDao.getRegionList(name,yx,parmpage,pageSize);
		
	}

	
	 /** 
	 * @方法名称: getRegionByName
	 * @功能描述:ajax验证病区名称
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:59:07
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.RegionService#getRegionByName(java.lang.String)
	 */
	 
	@Override
	public List<SmRegion> getRegionByName(String name) {
		
		return regionDao.getRegionByName(name);
		
	}

	
	 /** 
	 * @方法名称: addRegion
	 * @功能描述:添加病区信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午12:59:23
	 * @param sr
	 * @see com.znyy.sm.service.RegionService#addRegion(com.znyy.bean.SmRegion)
	 */
	 
	@Override
	public void addRegion(SmRegion sr) {
		
		regionDao.addRegion(sr);
		
	}

	
	 /** 
	 * @方法名称: getRegionById
	 * @功能描述:病区修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午1:06:43
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.RegionService#getRegionById(java.lang.Integer)
	 */
	 
	@Override
	public SmRegion getRegionById(Integer id) {
		SmRegion srn=regionDao.getRegionById(id);
		return srn;
		
	}

	
	 /** 
	 * @方法名称: modRegionList
	 * @功能描述:病区修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-6 下午1:14:39
	 * @param srn
	 * @see com.znyy.sm.service.RegionService#modRegionList(com.znyy.bean.SmRegion)
	 */
	 
	@Override
	public void modRegionList(SmRegion srn) {
		regionDao.modRegionList(srn);
	
	}

	@Override
	public List<SysDiseaseArea> getRegions() {
	
		return regionDao.getRegions();
		
	}

	
}
