package com.znyy.sm.service.impl;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmOperdef;
import com.znyy.sm.dao.OperdefDao;
import com.znyy.sm.service.OperdefService;

public class OperdefServiceImpl implements OperdefService {

	private OperdefDao operdefDao;

	public OperdefDao getSsDao() {
	
		return operdefDao;
	}


	public void setSsDao(OperdefDao operdefDao) {
	
		this.operdefDao = operdefDao;
	}


	
	 /** 
	 * @方法名称: getSsList
	 * @功能描述:获取手术名称列表信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 上午10:22:33
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.OperdefService#getSsList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getSsList(String name,String yx, String pinyin, String code, int parmpage, Integer pageSize) {
		
		return operdefDao.getSsList(name, yx,  pinyin,  code, parmpage, pageSize);
		
	}


	
	 /** 
	 * @方法名称: getSsById
	 * @功能描述:修改手术名称跳转
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:20:48
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.OperdefService#getSsById(java.lang.String)
	 */
	 
	@Override
	public SmOperdef getSsById(String id) {
		
		SmOperdef so=operdefDao.getSsById(id);
		return so;
		
	}


	
	 /** 
	 * @方法名称: modSsList
	 * @功能描述:修改手术名称
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:57:34
	 * @param ss
	 * @see com.znyy.sm.service.OperdefService#modSsList(com.znyy.bean.SmOperdef)
	 */
	 
	@Override
	public void modSsList(SmOperdef ss) {
		
		operdefDao.modSsList(ss);
		
	}


	
	 /** 
	 * @方法名称: addSs
	 * @功能描述:添加手术信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:07:26
	 * @param so
	 * @see com.znyy.sm.service.OperdefService#addSs(com.znyy.bean.SmOperdef)
	 */
	 
	@Override
	public void addSs(SmOperdef so) {
		
		operdefDao.addSs(so);
		
	}


	
	 /** 
	 * @方法名称: getSsByName
	 * @功能描述:ajax验证手术名称
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:15:05
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.OperdefService#getSsByName(java.lang.String)
	 */
	 
	@Override
	public List<SmOperdef> getSsByName(String name) {
		
		return operdefDao.getSsByName(name);	
	}


	
	 /** 
	 * @方法名称: getSsByCode
	 * @功能描述:ajax验证手术代码
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:45:46
	 * @param code
	 * @return
	 * @see com.znyy.sm.service.OperdefService#getSsByCode(java.lang.String)
	 */
	 
	@Override
	public List<SmOperdef> getSsByCode(String code) {
		
		return operdefDao.getSsByCode(code);	
	}


	public OperdefDao getOperdefDao() {
	
		return operdefDao;
	}


	public void setOperdefDao(OperdefDao operdefDao) {
	
		this.operdefDao = operdefDao;
	}


	@Override
	public List<SmOperdef> getOps(String enable) {
		
		return operdefDao.getOps(enable);
		
	}


}
