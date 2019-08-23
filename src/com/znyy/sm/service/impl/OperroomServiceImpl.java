package com.znyy.sm.service.impl;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmOperroom;
import com.znyy.sm.dao.OperroomDao;
import com.znyy.sm.service.OperroomService;

public class OperroomServiceImpl implements OperroomService {

	private OperroomDao operroomDao;

	public OperroomDao getOperroomDao() {
	
		return operroomDao;
	}

	public void setOperroomDao(OperroomDao operroomDao) {
	
		this.operroomDao = operroomDao;
	}

	
	 /** 
	 * @方法名称: getOrList
	 * @功能描述:获得手术室信息列表
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午1:03:50
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.OperroomService#getOrList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getOrList(String name, String lx, String yx,int parmpage, Integer pageSize) {
		return operroomDao.getOrList(name,lx,yx, parmpage, pageSize);
		
	}

	
	 /** 
	 * @方法名称: addOr
	 * @功能描述:添加手术室信息
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午1:31:12
	 * @param sor
	 * @see com.znyy.sm.service.OperroomService#addOr(com.znyy.bean.SmOperroom)
	 */
	 
	@Override
	public void addOr(SmOperroom sor) {
		operroomDao.addOr(sor);
	}

	
	 /** 
	 * @方法名称: getOrById
	 * @功能描述:手术室修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-4 下午3:32:30
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.OperroomService#getOrById(java.lang.Integer)
	 */
	 
	@Override
	public SmOperroom getOrById(Integer id) {
		SmOperroom sor=operroomDao.getOrById(id);
		return sor;
		
	}

	
	 /** 
	 * @方法名称: modOrList
	 * @功能描述:修改手术室数据
	 * @作者:付士山
	 * @创建时间:2016-1-5 上午9:16:43
	 * @param or
	 * @see com.znyy.sm.service.OperroomService#modOrList(com.znyy.bean.SmOperroom)
	 */
	 
	@Override
	public void modOrList(SmOperroom or) {
		
		operroomDao.modOrList(or);
		
	}

	
	 /** 
	 * @方法名称: getOrByName
	 * @功能描述:ajax验证手术室名称
	 * @作者:付士山
	 * @创建时间:2016-1-5 上午9:47:41
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.OperroomService#getOrByName(java.lang.String)
	 */
	 
	@Override
	public List<SmOperroom> getOrByName(String name) {
		
		
		return operroomDao.getOrByName(name);
		
	}

	@Override
	public List<SmOperroom> getRoomList(String enable,String type) {
		return operroomDao.getRoomList(enable,type);
	}
	
}
