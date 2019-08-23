package com.znyy.sm.service.impl;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmDept;
import com.znyy.bean.XtUnit;
import com.znyy.sm.dao.DeptDao;
import com.znyy.sm.service.DeptService;

public class DeptServiceImpl implements DeptService {

	private DeptDao deptDao;

	public DeptDao getDeptDao() {
	
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
	
		this.deptDao = deptDao;
	}

	
	 /** 
	 * @方法名称: getDeptList
	 * @功能描述:获取科室信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午9:44:15
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.DeptService#getDeptList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getDeptList(String name,  String yx,int parmpage, Integer pageSize) {
		return deptDao.getDeptList(name,yx,parmpage,pageSize);
		
	}

	
	 /** 
	 * @方法名称: addDept
	 * @功能描述:添加科室信息
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:46:04
	 * @param dept
	 * @see com.znyy.sm.service.DeptService#addDept(com.znyy.bean.SmDept)
	 */
	 
	@Override
	public void addDept(SmDept dept) {
		
		deptDao.addDept(dept);
		
	}

	
	 /** 
	 * @方法名称: getDeptByName
	 * @功能描述:ajax验证科室名称
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:51:49
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.DeptService#getDeptByName(java.lang.String)
	 */
	 
	@Override
	public List<SmDept> getDeptByName(String name) {
		
		return deptDao.getDeptByName(name);
		
	}

	
	 /** 
	 * @方法名称: getDeptById
	 * @功能描述:科室修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午10:58:43
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.DeptService#getDeptById(java.lang.Integer)
	 */
	 
	@Override
	public SmDept getDeptById(Integer id) {
		SmDept dt=deptDao.getDeptById(id);
		return dt;
	}

	
	 /** 
	 * @方法名称: modDeptList
	 * @功能描述:科室修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-6 上午11:06:07
	 * @param sdt
	 * @see com.znyy.sm.service.DeptService#modDeptList(com.znyy.bean.SmDept)
	 */
	 
	@Override
	public void modDeptList(SmDept sdt) {
		
		deptDao.modDeptList(sdt);
	}

	@Override
	public List<XtUnit> getDepts(String hospitalId) {
		return deptDao.getDepts(hospitalId);
	}
	
}
