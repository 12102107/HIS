package com.znyy.sm.service;

import java.util.List;
import java.util.Map;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SysCvFyzflb;

public interface RegOptService {

	
	 /**
	 * @方法名称: addSsdj
	 * @功能描述: 添加手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-18 上午9:46:52
	 * @param sro void   
	 */
	 
	void addSsdj(SmRegOpt sro);

	
	 /**
	 * @param hospitalId 
	 * @方法名称: getRoList
	 * @功能描述: 查询手术登记列表
	 * @作者:付士山
	 * @创建时间:2016-1-20 下午1:54:58
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
	 * @创建时间:2016-1-21 下午2:10:43
	 * @param id
	 * @return SmRegOpt   
	 */
	 
	SmRegOpt modSsdjListTo(String id);


	
	 /**
	 * @方法名称: modSsdjList
	 * @功能描述: 修改手术登记信息
	 * @作者:付士山
	 * @创建时间:2016-1-21 下午5:03:40
	 * @param sros void   
	 */
	 
	void modSsdjList(SmRegOpt sros);

	 
	void modSsapList1(SmRegOpt sros);


	List<SmRegOpt> getRoYuYueList();


	List<SmRegOpt> getMzysapList();


	List<SmRegOpt> getMzysList(String hospitalId);

	/**
	 * 
	 * @Title: modOSroReservation 
	 * @Description: 预约安排手术
	 * @author 白东旭
	 * @date 2016-2-17 下午1:37:24
	 * @param @param sroid 手术信息id
	 * @param @param roomid 手术室id
	 * @param @param circunurse1 第一器械护士
	 * @param @param circunurse2 第二器械护士
	 * @param @param instrnurse1 第一巡回护士
	 * @param @param instrnurse2 第二巡回护士
	 * @return void
	 * @throws 
	 *
	 */
	void modOSroReservation(String sroid, String roomid, String circunurse1,
			String circunurse2, String instrnurse1, String instrnurse2);


	/**
	 * @param hospitalId 
	 * @Title: getSroYuYueList 
	 * @Description: 获取预约信息列表
	 * @author 白东旭
	 * @date 2016-2-17 下午2:40:56
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getSroYuYueList(String hospitalId);


	/**
	 * @Title: modMzysReservation 
	 * @Description: 安排麻醉医生
	 * @author 白东旭
	 * @date 2016-2-18 上午10:12:15
	 * @param @param sroid
	 * @param @param anesthetist
	 * @param @param circuanesthetist
	 * @param @param anaesAssistant
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void modMzysReservation(String sroid, String anesthetist,
			String circuanesthetist, String anaesAssistant);


	/**
	 * @param hospitalId 
	 * @Title: getSroMzysList 
	 * @Description: 已安排麻醉医生列表
	 * @author 白东旭
	 * @date 2016-2-18 上午10:16:35
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