package com.znyy.sm.dao;

import java.util.List;

import com.common.util.Page;
import com.znyy.bean.SmDrugOrGoods;


public interface DrugOrGoodsDao {

	
	 /**
	 * @方法名称: getDrugList
	 * @功能描述: 获取药品物品信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:36:18
	 * @param name
	 * @param yx 
	 * @param lx 
	 * @param dj 
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	Page getDrugList(String name, String lx, String yx, String code,int parmpage, Integer pageSize);

	
	 /**
	 * @方法名称: getDrugById
	 * @功能描述: 药品物品修改跳转
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:49:37
	 * @param id
	 * @return SmDrugOrGoods   
	 */
	 
	SmDrugOrGoods getDrugById(Integer id);

	
	 /**
	 * @方法名称: modDrugList
	 * @功能描述: 药品物品修改数据
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午9:49:42
	 * @param dg void   
	 */
	 
	void modDrugList(SmDrugOrGoods dg);


	
	 /**
	 * @方法名称: addDrug
	 * @功能描述: 添加药品物品信息
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:03:37
	 * @param sdg void   
	 */
	 
	void addDrug(SmDrugOrGoods sdg);


	
	 /**
	 * @方法名称: getDrugByName
	 * @功能描述: ajax验证药品物品名称
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:11:26
	 * @param name
	 * @return List<SmDrugOrGoods>   
	 */
	 
	List<SmDrugOrGoods> getDrugByName(String name);


	
	 /**
	 * @方法名称: getDrugByCode
	 * @功能描述: ajax验证药品物品代码
	 * @作者:付士山
	 * @创建时间:2016-1-8 上午10:11:31
	 * @param parseInt
	 * @return List<SmDrugOrGoods>   
	 */
	 
	List<SmDrugOrGoods> getDrugByCode(int parseInt);

}
