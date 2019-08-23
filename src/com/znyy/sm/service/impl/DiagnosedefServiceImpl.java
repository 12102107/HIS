package com.znyy.sm.service.impl;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SysIcdCode;
import com.znyy.sm.dao.DiagnosedefDao;
import com.znyy.sm.service.DiagnosedefService;


public class DiagnosedefServiceImpl implements DiagnosedefService {

	private DiagnosedefDao diagnosedefDao;
	

	 /** 
	 * @方法名称: getZdList
	 * @功能描述:获取诊断信息列表
	 * @作者:付士山
	 * @创建时间:2015-12-24 下午4:03:21
	 * @param name 病人名
	 * @param parmpage  当前为第几页
	 * @param pageSize  每页显示的条数
	 * @return
	 * @see com.znyy.sm.service.DiagnosedefService#getZdList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getZdList(String name, String yx, String pinyin ,
			int parmpage, Integer pageSize) {
		return diagnosedefDao.getZdList(name,yx,pinyin,  parmpage, pageSize);
	}


	/**
	 * 
	 * @方法名称: getZdById
	 * @功能描述:根据id获取一条诊断信息
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:27:24
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.DiagnosedefService#getZdById(java.lang.Integer)
	 */
	@Override
	public SmDiagnosedef getZdById(Integer id) {
		
		SmDiagnosedef zd=diagnosedefDao.getZdById(id);
		
		return zd;
	}


	/**
	 * 
	 * @方法名称: modZdList
	 * @功能描述:修改诊断列表信息
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:27:34
	 * @param sm
	 * @see com.znyy.sm.service.DiagnosedefService#modZdList(com.znyy.bean.SmDiagnosedef)
	 */
	@Override
	public void modZdList(SmDiagnosedef sm) {
		
		diagnosedefDao.modZdList(sm);
		
	}


	/**
	 * 
	 * @方法名称: addZd
	 * @功能描述:添加诊断列表信息
	 * @作者:付士山
	 * @创建时间:2015-12-24 上午9:27:43
	 * @param zd
	 * @see com.znyy.sm.service.DiagnosedefService#addZd(com.znyy.bean.SmDiagnosedef)
	 */
	@Override
	public void addZd(SmDiagnosedef zd) {
		
		diagnosedefDao.addZd(zd);
		
	}



	
	 /** 
	 * @方法名称: getZdByName
	 * @功能描述:ajax验证诊断名称
	 * @作者:付士山
	 * @创建时间:2015-12-25 上午10:35:07
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.DiagnosedefService#getZdByName(java.lang.String)
	 */
	 
	@Override
	public List<SmDiagnosedef> getZdByName(String name) {
		return diagnosedefDao.getZdByName(name);	
	}



	public DiagnosedefDao getZdDao() {
	
		return diagnosedefDao;
	}



	public void setZdDao(DiagnosedefDao diagnosedefDao) {
	
		this.diagnosedefDao = diagnosedefDao;
	}


	public DiagnosedefDao getDiagnosedefDao() {
	
		return diagnosedefDao;
	}


	public void setDiagnosedefDao(DiagnosedefDao diagnosedefDao) {
	
		this.diagnosedefDao = diagnosedefDao;
	}


	@Override
	public List<SmDiagnosedef> getZds(String enable) {
		
		return diagnosedefDao.getZds(enable);
		
	}


	/* (non-Javadoc)
	 * @see com.znyy.sm.service.DiagnosedefService#getSysIcdCodeList()
	 */
	@Override
	public List<SysIcdCode> getSysIcdCodeList() {
		return diagnosedefDao.getSysIcdCodeList();
	}


	/* (non-Javadoc)
	 * @see com.znyy.sm.service.DiagnosedefService#querySqzdName(java.lang.String)
	 */
	@Override
	public List<SysIcdCode> querySqzdName(String zimu) {
		return diagnosedefDao.querySqzdName(zimu);
	}


}
