package com.znyy.sm.service.impl;
import java.util.List;
import com.common.util.Page;
import com.znyy.bean.SmMedicalTakeWay;
import com.znyy.sm.dao.MedicalTakeWayDao;
import com.znyy.sm.service.MedicalTakeWayService;

public class MedicalTakeWayServiceImpl implements MedicalTakeWayService {

	private MedicalTakeWayDao medicalTakeWayDao;

	public MedicalTakeWayDao getMedicalTakeWayDao() {
	
		return medicalTakeWayDao;
	}

	public void setMedicalTakeWayDao(MedicalTakeWayDao medicalTakeWayDao) {
	
		this.medicalTakeWayDao = medicalTakeWayDao;
	}

	
	 /** 
	 * @方法名称: getWayList
	 * @功能描述:获取给药途径信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:22:37
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.MedicalTakeWayService#getWayList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getWayList(String cname, String code, String way, String fl, String cx, int parmpage, Integer pageSize) {
		
		return medicalTakeWayDao.getWayList(cname,code,way,fl,cx,parmpage,pageSize);
		
	}

	
	 /** 
	 * @方法名称: getWayById
	 * @功能描述:给药途径修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:40:11
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.MedicalTakeWayService#getWayById(java.lang.String)
	 */
	 
	@Override
	public SmMedicalTakeWay getWayById(String id) {
		
		SmMedicalTakeWay mtw=medicalTakeWayDao.getWayById(id);
		return mtw;
		
	}

	
	 /** 
	 * @方法名称: modWayList
	 * @功能描述:给药途径修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午1:40:44
	 * @param way
	 * @see com.znyy.sm.service.MedicalTakeWayService#modWayList(com.znyy.bean.SmMedicalTakeWay)
	 */
	 
	@Override
	public void modWayList(SmMedicalTakeWay way) {
		
		medicalTakeWayDao.modWayList(way);
		
	}

	
	 /** 
	 * @方法名称: getWayByCode
	 * @功能描述:
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午2:17:57
	 * @param code
	 * @return
	 * @see com.znyy.sm.service.MedicalTakeWayService#getWayByCode(java.lang.String)
	 */
	 
	@Override
	public List<SmMedicalTakeWay> getWayByCode(String code) {
		
	
		return medicalTakeWayDao.getWayByCode(code);
		
	}

	
	 /** 
	 * @方法名称: getWayByName
	 * @功能描述:
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午2:18:01
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.MedicalTakeWayService#getWayByName(java.lang.String)
	 */
	 
	@Override
	public List<SmMedicalTakeWay> getWayByName(String name) {

		return medicalTakeWayDao.getWayByName(name);
		
	}

	
	 /** 
	 * @方法名称: addWay
	 * @功能描述:添加给药途径信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 下午4:30:01
	 * @param mtw
	 * @see com.znyy.sm.service.MedicalTakeWayService#addWay(com.znyy.bean.SmMedicalTakeWay)
	 */
	 
	@Override
	public void addWay(SmMedicalTakeWay mtw) {
		
		medicalTakeWayDao.addWay(mtw);
		
	}

	
}
