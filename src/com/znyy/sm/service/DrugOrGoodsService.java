package com.znyy.sm.service;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmDrugOrGoods;

public interface DrugOrGoodsService {

	
	 /**
	 * @方法名称: getDrugList
	 * @功能描述: 获取药品物品信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:36:42
	 * @param name
	 * @param yx 
	 * @param lx 
	 * @param dj 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getDrugList(String name,  String lx, String yx, String code,int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: getDrugById
	 * @功能描述: 药品物品修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:53:27
	 * @param id
	 * @return SmDrugOrGoods   
	 */
	 
	SmDrugOrGoods getDrugById(Integer id);

	
	 /**
	 * @方法名称: modDrugList
	 * @功能描述: 药品物品修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:53:33
	 * @param dg void   
	 */
	 
	void modDrugList(SmDrugOrGoods dg);


	
	 /**
	 * @方法名称: addDrug
	 * @功能描述: 添加药品物品信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:02:46
	 * @param sdg void   
	 */
	 
	void addDrug(SmDrugOrGoods sdg);


	
	 /**
	 * @方法名称: getDrugByName
	 * @功能描述: ajax验证药品物品名称
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:08:51
	 * @param name
	 * @return List<SmDrugOrGoods>   
	 */
	 
	List<SmDrugOrGoods> getDrugByName(String name);


	
	 /**
	 * @方法名称: getDrugByCode
	 * @功能描述: ajax验证药品物品代码
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:08:49
	 * @param parseInt
	 * @return List<SmDrugOrGoods>   
	 */
	 
	List<SmDrugOrGoods> getDrugByCode(int parseInt);

	

}