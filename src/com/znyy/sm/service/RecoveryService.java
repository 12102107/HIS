/**
 * 
 */
package com.znyy.sm.service;
import java.util.List;
import java.util.Map;

import com.znyy.bean.SmRecoveryData;
import com.znyy.bean.SmRecoveryFromMachine;
import com.znyy.bean.SmRecoveryroomRecord;
import com.znyy.bean.SmRegOpt;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author 白东旭
 * @date 2016-5-4
 */
public interface RecoveryService {

	/**
	 * @Description: 根据医疗文书id获取手术信息
	 * @param @param ylwsid
	 * @param @return   
	 * @return SmRegOpt  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-5-6
	 */
	SmRegOpt getSmRegOptByYlwsid(String ylwsid);

	/**
	 * @Description: 保存记录单
	 * @param @param record
	 * @param @param username   
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-5-6
	 */
	void saveRecord(SmRecoveryroomRecord record, String username);

	/**
	 * @Description: 根据医疗文书id获取记录单
	 * @param @param ylwsid
	 * @param @return   
	 * @return SmRecoveryroomRecord  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-5-6
	 */
	SmRecoveryroomRecord getRecordByYlwsid(String ylwsid);

	/**
	 * @Description: 生成虚拟体征信息
	 * @param @param record
	 * @param @param username   
	 * @return void  
	 * @throws 
	 * @author 崔连瑞
	 * @date 2016-5-6
	 */
	void addVitalSignsData(SmRecoveryFromMachine recovery);
	

	/**
	 * @Description: 生成虚拟体征信息
	 * @param @param record
	 * @param @param username   
	 * @return void  
	 * @throws 
	 * @author 崔连瑞
	 * @date 2016-5-6
	 */
	public Map<String, Object> getCollectDateByRoomAndTime(String roomCode);
	
	/**
	 * @Description: 创建恢复室记录单
	 * @param @param record
	 * @param @param username   
	 * @return void  
	 * @throws 
	 * @author 崔连瑞
	 * @date 2016-5-6
	 */
	void createRecoveryRecord(SmRecoveryroomRecord record);
	
	/**
	 * @Description: 修改恢复室记录单
	 * @param @param record    
	 * @return void  
	 * @throws 
	 * @author 崔连瑞
	 * @date 2016-5-6
	 */
	void updateRecoveryRecord(SmRecoveryroomRecord record);
	
	/**
	 * @方法名称: addRecoveryData
	 * @功能描述: 保存采集的体征信息
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return void
	 */
	void addRecoveryData(SmRecoveryData srdata);
	/**
	 * @方法名称: loadSmRecoveryData
	 * @功能描述: 加载体征信息
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> loadSmRecoveryData(String operationId);
	/**
	 * @方法名称: loadRecoveryPrintData
	 * @功能描述: 加载打印数据
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>>  loadRecoveryPrintData(String operationId);

	
	
	
	
}
