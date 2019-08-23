package com.znyy.sm.service.impl;
import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.sm.dao.OperationPeopleDao;
import com.znyy.sm.service.OperationPeopleService;

public class OperationPeopleServiceImpl implements OperationPeopleService {

	private OperationPeopleDao operationPeopleDao;


	
	 public OperationPeopleDao getSpDao() {
	
		return operationPeopleDao;
	}



	public void setSpDao(OperationPeopleDao operationPeopleDao) {
	
		this.operationPeopleDao = operationPeopleDao;
	}



	/** 
	 * @方法名称: getSpList
	 * @功能描述:获取手术人员列表信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 上午10:22:33
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.OperationPeopleService#getSpList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getSpList(String code,String lb, String lx, String yx,int parmpage, Integer pageSize) {
		
		return operationPeopleDao.getSpList(code,lb,lx,yx, parmpage, pageSize);
		
	}
	 /** 
	 * @方法名称: getSpById
	 * @功能描述:修改手术人员跳转
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:20:48
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.OperationPeopleService#getSpById(java.lang.String)
	 */

	@Override
	public SmOperationPeople getSpById(Integer id) {
		SmOperationPeople sp=operationPeopleDao.getSpById(id);
		return sp;
		
	}
	 /** 
	 * @方法名称: modSpList
	 * @功能描述:修改手术人员
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午1:57:34
	 * @param sp
	 * @see com.znyy.sm.service.OperationPeopleService#modSpList(com.znyy.bean.SmOperationPeople)
	 */

	@Override
	public void modSpList(SmOperationPeople sp) {
		
		operationPeopleDao.modSpList(sp);
		
	}



	

	 /** 
	 * @方法名称: addSp
	 * @功能描述:添加手术人员信息
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:07:26
	 * @param sp
	 * @see com.znyy.sm.service.OperationPeopleService#addSp(com.znyy.bean.SmOperationPeople)
	 */
		@Override
		public void addSp(SmOperationPeople sp) {
			
			operationPeopleDao.addSp(sp);
			
		}
	 /** 
	 * @方法名称: getSpByName
	 * @功能描述:ajax验证手术人员
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:15:05
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.OperationPeopleService#getSpByName(java.lang.String)
	 */



		@Override
		public List<SmOperationPeople> getSpByName(String name) {
			
			return operationPeopleDao.getSpByName(name);
			
		}

	 /** 
	 * @方法名称: getSpByCode
	 * @功能描述:ajax验证手术代码
	 * @作者:付士山
	 * @创建时间:2015-12-28 下午3:45:46
	 * @param code
	 * @return
	 * @see com.znyy.sm.service.OperationPeopleService#getSpByCode(java.lang.String)
	 */
		@Override
		public List<SmOperationPeople> getSpByCode(int code) {
			
			return operationPeopleDao.getSpByCode(code);
			
		}



	public OperationPeopleDao getOperationPeopleDao() {
	
		return operationPeopleDao;
	}



	public void setOperationPeopleDao(OperationPeopleDao operationPeopleDao) {
	
		this.operationPeopleDao = operationPeopleDao;
	}



	@Override
	public List<SmOperationPeople> getSops(String enable,String role) {
		 
		return operationPeopleDao.getSops(enable,role);
		
	}



	
	 /** 
	 * @方法名称: getSopsByZimu
	 * @功能描述:AJAX联动查询手术人员
	 * @作者:付士山
	 * @创建时间:2016-1-18 下午3:14:23
	 * @param zimu
	 * @return
	 * @see com.znyy.sm.service.OperationPeopleService#getSopsByZimu(java.lang.String)
	 */
	 
	@Override
	public List<SmOperationPeople> getSopsByZimu(String zimu) {
		
		return operationPeopleDao.getSopsByZimu(zimu);
		
	}
	@Override
	public List<SmDiagnosedef> getSqzdNameByZimu(String zimu) {
		
		return operationPeopleDao.getSqzdByZimu(zimu);
		
	}
	@Override
	public List<SmOperdef> getNsssNameByZimu(String zimu) {
		
		return operationPeopleDao.getNsssByZimu(zimu);
		
	}



	
	 /** 
	 * @方法名称: getOpList
	 * @功能描述:查询麻醉医师列表
	 * @作者:付士山
	 * @创建时间:2016-2-24 上午11:36:58
	 * @param enable
	 * @return
	 * @see com.znyy.sm.service.OperationPeopleService#getOpList(java.lang.String)
	 */
	 
	@Override
	public List<SmOperationPeople> getOpList(String enable) {
		
		List<SmOperationPeople> sop= operationPeopleDao.getOpList(enable);
		return sop;
		
	}



	/* (non-Javadoc)
	 * @see com.znyy.sm.service.OperationPeopleService#getOperatorNameById(java.lang.String)
	 */
	@Override
	public String getOperatorNameById(String operatorId) {
		SmOperationPeople p = operationPeopleDao.getSpById(Integer.valueOf(operatorId));
		return p.getName();
	}



	@Override
	public List<SmOperationPeople> getLxList() {
		
		return operationPeopleDao.getLxList();
		
	}



	@Override
	public List<SmOperationPeople> getAnesthetistersByRole(String yishiRole) {
		
		return operationPeopleDao.getAnesthetistersByRole(yishiRole);
	}



	@Override
	public List<SmOperationPeople> getAnesthetistersByPy(String zimu) {
		return operationPeopleDao.getAnesthetistersByPy(zimu);
	}



	@Override
	public List<SmOperationPeople> AnesthetistersByyishiName(String yishiName) {
		return operationPeopleDao.AnesthetistersByyishiName(yishiName);
	}



	@Override
	public List<SmOperationPeople> getAnesthetistersByPy1(String zimu) {
		return operationPeopleDao.getAnesthetistersByPy1(zimu);
	}



	@Override
	public List<SmOperationPeople> getAnesthetistersByPy2(String zimu) {
		return operationPeopleDao.getAnesthetistersByPy2(zimu);
	}

}
