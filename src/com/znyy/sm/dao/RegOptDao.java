package com.znyy.sm.dao;

import java.util.List;
import java.util.Map;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SysCvFyzflb;

public interface RegOptDao {

	
	 /**
	 * @方法名称: addSsdj
	 * @功能描述: 添加手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-18 上午9:47:45
	 * @param sro void   
	 */
	 
	void addSsdj(SmRegOpt sro);

	
	 /**
	 * @param hospitalId 
	 * @方法名称: getRoList
	 * @功能描述: 查询手术登记列表
	 * @作者:付士山
	 * @创建时间:2016-1-20 下午1:57:10
	 * @param name
	 * @param parmpage
	 * @param pageSize
	 * @return Page   
	 */
	 
	List getRoList(String hospitalId);


	
	 /**
	 * @方法名称: modSsdjListTo
	 * @功能描述: 根据id查询手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-21 下午2:12:55
	 * @param id
	 * @return SmRegOpt   
	 */
	 
	SmRegOpt modSsdjListTo(String id);


	
	 /**
	 * @方法名称: modSsdjList
	 * @功能描述: 修改手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-21 下午5:05:03
	 * @param sros void   
	 */
	 
	void modSsdjList(SmRegOpt sros);


	void modSsdjList1(SmRegOpt sros);


	List<SmRegOpt> getRoYuYueList();


	List<SmRegOpt> getMzysapList();


	List<SmRegOpt> getMzysList(String hospitalId);

	/**
	 * 
	 * @Title: getSro 
	 * @Description: 获取手术信息记录
	 * @author 白东旭
	 * @date 2016-2-17 下午1:39:57
	 * @param @param sroid
	 * @return SmRegOpt
	 * @throws 
	 *
	 */
	SmRegOpt getSro(String sroid);

	/**
	 * 
	 * @Title: saveSro 
	 * @Description: 保存手术信息
	 * @author 白东旭
	 * @date 2016-2-17 下午1:47:15
	 * @param @param sro
	 * @return void
	 * @throws 
	 *
	 */
	void saveSro(SmRegOpt sro);


	/**
	 * @Title: getSmOperroomById 
	 * @Description: 获取手术室/恢复室
	 * @author 白东旭
	 * @date 2016-2-17 下午2:31:35
	 * @param @param valueOf
	 * @param @return
	 * @return SmOperroom
	 * @throws 
	 *
	 */ 
	
	SmOperroom getSmOperroomById(Integer valueOf);


	/**
	 * @param hospitalId 
	 * @Title: getSroYuYueList 
	 * @Description: 获取预约列表
	 * @author 白东旭
	 * @date 2016-2-17 下午2:43:21
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getSroYuYueList(String hospitalId);


	/**
	 * @param hospitalId 
	 * @Title: getSroMzysList 
	 * @Description: 获取已安排麻醉医生列表
	 * @author 白东旭
	 * @date 2016-2-18 上午10:17:17
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getSroMzysList(String hospitalId);


	/**
	 * @Description: 获取收费类型列表
	 * @param @return   
	 * @return List<SysCvFyzflb>  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-6-16
	 */
	List<SysCvFyzflb> getSysCvFyzflbList();



}