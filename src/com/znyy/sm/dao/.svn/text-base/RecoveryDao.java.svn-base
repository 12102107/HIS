/**
 * 
 */
package com.znyy.sm.dao;

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
public interface RecoveryDao {

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
	 * @Description: 保存恢复室记录单
	 * @param @param record   
	 * @return void  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-5-6
	 */
	void saveRecord(SmRecoveryroomRecord record);
	
	/**
	 * @Description: 更新恢复室记录单
	 * @param @param record   
	 * @return void  
	 * @throws 
	 * @author 崔连瑞
	 * @date 2016-5-18
	 */
	void updateRecord(SmRecoveryroomRecord record);

	/**
	 * @Description: 根据医疗文书id获取恢复室记录单
	 * @param @param ylwsid
	 * @param @return   
	 * @return SmRecoveryroomRecord  
	 * @throws 
	 * @author 白东旭
	 * @date 2016-5-6
	 */
	SmRecoveryroomRecord getRecordByYlwsid(String ylwsid);

	
	/**
	 * @Description: 保存虚拟体征信息
	 * @param @param record   
	 * @return void  
	 * @throws 
	 * @author 崔连瑞
	 * @date 2016-5-6
	 */
	public void saveVitalSignsData(SmRecoveryFromMachine recovery);
	
	/**
	 * @Description: 获取体征信息
	 * @param @param record   
	 * @return void  
	 * @throws 
	 * @author 崔连瑞
	 * @date 2016-5-6
	 */
	public Map<String, Object> getCollectDatesByRoomAndTime(String roomCode);
	
	/**
	 * @方法名称: addRecoveryDatas
	 * @功能描述: 保存采集的体征信息
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return void
	 */
	public void addRecoveryDatas(SmRecoveryData srdata);
	/**
	 * @方法名称: loadRecoveryData
	 * @功能描述: 加载体征信息
	 * @作者:崔连瑞
	 * @创建时间:2016-5-17 上午10:53:32
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> loadRecoveryData(String operationId);
	
    /**
     * @方法名称: loadRecoveryPrintDataByOptId
     * @功能描述: 获取打印数据
     * @作者:崔连瑞
     * @创建时间:2016-4-20 上午9:21:21
     * @param operationId
     * @return  List<Map<String, Object>>
     */
    public  List<Map<String, Object>> loadRecoveryPrintDataByOptId(String operationId) ;
    

}
