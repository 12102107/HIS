package com.znyy.sm.service.impl;

import java.util.List;
import com.common.util.Page;
import com.znyy.bean.SmCheckItem;
import com.znyy.sm.dao.CheckItemDao;
import com.znyy.sm.service.CheckItemService;

public class CheckItemServiceImpl implements CheckItemService {

	/**
	 * 
	 */
	private CheckItemDao checkItemDao;

	public CheckItemDao getCheckItemDao() {
	
		return checkItemDao;
	}

	public void setCheckItemDao(CheckItemDao checkItemDao) {
	
		this.checkItemDao = checkItemDao;
	}

	
	 /** 
	 * @方法名称: getCheckList
	 * @功能描述:获取检验项目信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:14:45
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.CheckItemService#getCheckList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getCheckList(String name, String dw, String code, String yx, int parmpage, Integer pageSize) {
		
		return checkItemDao.getCheckList(name,dw,code,yx,parmpage,pageSize);
		
	}

	
	 /** 
	 * @方法名称: getCheckById
	 * @功能描述:检验项目修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:41:12
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.CheckItemService#getCheckById(java.lang.String)
	 */
	 
	@Override
	public SmCheckItem getCheckById(String id) {
		
		return checkItemDao.getCheckById(id);
		
	}

	
	 /** 
	 * @方法名称: modCheckList
	 * @功能描述:检验项目修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午2:41:17
	 * @param ci
	 * @see com.znyy.sm.service.CheckItemService#modCheckList(com.znyy.bean.SmCheckItem)
	 */
	 
	@Override
	public void modCheckList(SmCheckItem ci) {
		
		checkItemDao.modCheckList(ci);
		
	}

	
	 /** 
	 * @方法名称: getCheckByName
	 * @功能描述:ajax验证检验项目名称
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午4:56:24
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.CheckItemService#getCheckByName(java.lang.String)
	 */
	 
	@Override
	public List<SmCheckItem> getCheckByName(String name) {
		

		return checkItemDao.getCheckByName(name);
		
	}

	
	 /** 
	 * @方法名称: getCheckByCode
	 * @功能描述:ajax验证检验项目代码 
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午4:56:27
	 * @param code
	 * @return
	 * @see com.znyy.sm.service.CheckItemService#getCheckByCode(java.lang.String)
	 */
	 
	@Override
	public List<SmCheckItem> getCheckByCode(String code) {
		return checkItemDao.getCheckByCode(code);
		
	}

	
	 /** 
	 * @方法名称: addCheck
	 * @功能描述:添加检验项目信息
	 * @作者:付士山
	 * @创建时间:2016-1-7 下午5:15:31
	 * @param sci
	 * @see com.znyy.sm.service.CheckItemService#addCheck(com.znyy.bean.SmCheckItem)
	 */
	 
	@Override
	public void addCheck(SmCheckItem sci) {
		checkItemDao.addCheck(sci);
	
	}


}
