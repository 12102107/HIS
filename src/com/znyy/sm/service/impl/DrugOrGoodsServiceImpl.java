package com.znyy.sm.service.impl;
import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmDrugOrGoods;
import com.znyy.sm.dao.DrugOrGoodsDao;
import com.znyy.sm.service.DrugOrGoodsService;

public class DrugOrGoodsServiceImpl implements DrugOrGoodsService {

	private DrugOrGoodsDao drugOrGoodsDao;

	public DrugOrGoodsDao getDrugOrGoodsDao() {
	
		return drugOrGoodsDao;
	}

	public void setDrugOrGoodsDao(DrugOrGoodsDao drugOrGoodsDao) {
	
		this.drugOrGoodsDao = drugOrGoodsDao;
	}

	
	 /** 
	 * @方法名称: getDrugList
	 * @功能描述:获取药品物品信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:36:11
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return
	 * @see com.znyy.sm.service.DrugOrGoodsService#getDrugList(java.lang.String, int, java.lang.Integer)
	 */
	 
	@Override
	public Page getDrugList(String name
			, String lx, String yx, String code, int parmpage, Integer pageSize) {
		
		return drugOrGoodsDao.getDrugList(name,lx,yx,code, parmpage, pageSize);
		
	}

	
	 /** 
	 * @方法名称: getDrugById
	 * @功能描述:药品物品修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:47:47
	 * @param id
	 * @return
	 * @see com.znyy.sm.service.DrugOrGoodsService#getDrugById(java.lang.Integer)
	 */
	 
	@Override
	public SmDrugOrGoods getDrugById(Integer id) {
		
		SmDrugOrGoods sdg=drugOrGoodsDao.getDrugById(id);
		return sdg;
		
	}

	
	 /** 
	 * @方法名称: modDrugList
	 * @功能描述:药品物品修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:47:40
	 * @param dg
	 * @see com.znyy.sm.service.DrugOrGoodsService#modDrugList(com.znyy.bean.SmDrugOrGoods)
	 */
	 
	@Override
	public void modDrugList(SmDrugOrGoods dg) {
		
		drugOrGoodsDao.modDrugList(dg);
		
	}

	
	 /** 
	 * @方法名称: addDrug
	 * @功能描述:添加药品物品信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:03:04
	 * @param sdg
	 * @see com.znyy.sm.service.DrugOrGoodsService#addDrug(com.znyy.bean.SmDrugOrGoods)
	 */
	 
	@Override
	public void addDrug(SmDrugOrGoods sdg) {
		
		drugOrGoodsDao.addDrug(sdg);
		
	}

	
	 /** 
	 * @方法名称: getDrugByName
	 * @功能描述:ajax验证药品物品名称
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:14:09
	 * @param name
	 * @return
	 * @see com.znyy.sm.service.DrugOrGoodsService#getDrugByName(java.lang.String)
	 */
	 
	@Override
	public List<SmDrugOrGoods> getDrugByName(String name) {
		
		return drugOrGoodsDao.getDrugByName(name);
		
	}

	
	 /** 
	 * @方法名称: getDrugByCode
	 * @功能描述:ajax验证药品物品代码
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:14:15
	 * @param parseInt
	 * @return
	 * @see com.znyy.sm.service.DrugOrGoodsService#getDrugByCode(int)
	 */
	 
	@Override
	public List<SmDrugOrGoods> getDrugByCode(int parseInt) {
		
		return drugOrGoodsDao.getDrugByCode(parseInt);
		
	}

}
