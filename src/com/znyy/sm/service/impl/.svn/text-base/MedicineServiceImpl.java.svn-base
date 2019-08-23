package com.znyy.sm.service.impl;
import java.util.List;
import com.common.util.Page;
import com.znyy.bean.SmMedicine;
import com.znyy.sm.dao.MedicineDao;
import com.znyy.sm.service.MedicineService;


public class MedicineServiceImpl implements MedicineService {

	private MedicineDao medicineDao;

	public MedicineDao getMedicineDao() {
	
		return medicineDao;
	}

	public void setMedicineDao(MedicineDao medicineDao) {
	
		this.medicineDao = medicineDao;
	}

	
	 /** 
	 * @方法名称: getMedList
	 * @功能描述:获取药品库信息
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午9:43:04
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.MedicineService#getMedList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getMedList(String name, String code, String fl, String dw,
			String pinyin, String yx, int parmpage, Integer pageSize) {
		
		return medicineDao.getMedList(name,code,fl,dw,pinyin,yx,parmpage,pageSize);
		
	}

	
	 /** 
	 * @方法名称: getMedById
	 * @功能描述:药品库修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午10:44:00
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.MedicineService#getMedById(java.lang.Integer)
	 */
	 
	@Override
	public SmMedicine getMedById(Integer id) {
		
		SmMedicine med=medicineDao.getMedById(id);
		return med;
		
	}

	
	 /** 
	 * @方法名称: modMedList
	 * @功能描述:药品库修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午10:51:59
	 * @param smed
	 * @see com.znyy.sm.service.MedicineService#modMedList(com.znyy.bean.SmMedicine)
	 */
	 
	@Override
	public void modMedList(SmMedicine smed) {
		
		medicineDao.modMedList(smed);
		
	}

	
	 /** 
	 * @方法名称: getMedByName
	 * @功能描述:ajax验证药品库名称
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午11:12:28
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.MedicineService#getMedByName(java.lang.String)
	 */
	 
	@Override
	public List<SmMedicine> getMedByName(String name) {
		
	
		return medicineDao.getMedByName(name);
		
	}

	
	 /** 
	 * @方法名称: addMed
	 * @功能描述:添加药品库信息
	 * @作者:付士山
	 * @创建时间:2016-1-11 上午11:27:41
	 * @param med
	 * @see com.znyy.sm.service.MedicineService#addMed(com.znyy.bean.SmMedicine)
	 */
	 
	@Override
	public void addMed(SmMedicine med) {
		
		medicineDao.addMed(med);
		
	}

	@Override
	public List<SmMedicine> getDwList() {
		
		return medicineDao.getDwList();
		
	}

	@Override
	public List<SmMedicine> getFlList() {
		
		return medicineDao.getFlList();
		
	}
	

}
