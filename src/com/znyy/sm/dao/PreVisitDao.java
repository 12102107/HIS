/**  
 * @Title: PreVisitDao.java 
 * @Package com.znyy.sm.dao 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-29 下午1:30:19 
 */ 
package com.znyy.sm.dao;

import java.util.List;
import java.util.Map;

import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmPreTestData;
import com.znyy.bean.SmPreVisit;
import com.znyy.bean.SmPreVisitMedicalHistory;
import com.znyy.bean.SmWritTemplate;

/** 
 * @ClassName: PreVisitDao 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-2-29 下午1:30:19 
 */
public interface PreVisitDao {

	/**
	 * @Title: getMzysByUserid 
	 * @Description: 获取当前登陆麻醉医师
	 * @author 白东旭
	 * @date 2016-3-2 上午9:38:49
	 * @param @param userid
	 * @param @return
	 * @return SmOperationPeople
	 * @throws 
	 *
	 */ 
	
	SmOperationPeople getMzysByUserid(String userid);

	/**
	 * @Title: saveSpVmh 
	 * @Description: 保存术前访视病史信息
	 * @author 白东旭
	 * @date 2016-3-2 上午10:45:13
	 * @param @param spVmh
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void saveSpVmh(SmPreVisitMedicalHistory spVmh);

	/**
	 * @Title: savePreVisit 
	 * @Description: 保存术前访视信息
	 * @author 白东旭
	 * @date 2016-3-2 上午10:58:34
	 * @param @param preVisit
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void savePreVisit(SmPreVisit preVisit);

	/**
	 * @Title: getPreVisitByYlwsd 
	 * @Description: 获取术前访视单信息
	 * @author 白东旭
	 * @date 2016-3-2 上午11:28:31
	 * @param @param ylwsid
	 * @param @return
	 * @return SmPreVisit
	 * @throws 
	 *
	 */ 
	
	SmPreVisit getPreVisitByYlwsd(String ylwsid);

	/**
	 * @Title: getSpVmhByYlwsd 
	 * @Description: TODO
	 * @author 白东旭
	 * @date 2016-3-2 上午11:32:04
	 * @param @param ylwsid
	 * @param @return
	 * @return SmPreVisitMedicalHistory
	 * @throws 
	 *
	 */ 
	
	SmPreVisitMedicalHistory getSpVmhByYlwsd(String ylwsid);

	/**
	 * @Title: getPreVisitPrint 
	 * @Description: 获取打印数据
	 * @author 白东旭
	 * @date 2016-3-3 下午4:44:30
	 * @param @param ylwsid
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getPreVisitPrint(String ylwsid);

	/**
	 * @Title: saveSmWritTemplate 
	 * @Description: 保存模板
	 * @author 白东旭
	 * @date 2016-3-31 上午11:04:42
	 * @param @param wt
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void saveSmWritTemplate(SmWritTemplate wt);

	/**
	 * @Title: getSmWritTemplatePersonal 
	 * @Description: TODO
	 * @author 白东旭
	 * @date 2016-3-31 下午2:22:04
	 * @param @param userid
	 * @param @return
	 * @return List<SmWritTemplate>
	 * @throws 
	 *
	 */ 
	
	List<SmWritTemplate> getSmWritTemplatePersonal(String userid);

	/**
	 * @Title: getSmWritTemplatePublic 
	 * @Description: TODO
	 * @author 白东旭
	 * @date 2016-3-31 下午2:22:08
	 * @param @return
	 * @return List<SmWritTemplate>
	 * @throws 
	 *
	 */ 
	
	List<SmWritTemplate> getSmWritTemplatePublic();

	/**
	 * @Title: getTemplateVal 
	 * @Description: TODO
	 * @author 白东旭
	 * @date 2016-4-1 上午10:10:57
	 * @param @param templateId
	 * @param @return
	 * @return List<Map<String,String>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, String>> getTemplateVal(String templateId);

	/**
	 * @Title: delTemplate 
	 * @Description: TODO
	 * @author 白东旭
	 * @date 2016-4-1 下午3:41:27
	 * @param @param templateId
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void delTemplate(String templateId);
	
	/**
	 * @Title: loadTest 
	 * @author 崔连瑞
	 * @date 2016-5-26 下午3:41:27
	 * @return Map<String , Object>
	 * @throws 
	 *
	 */
	Map<String , Object> loadTest(String hid);
	
	/**
	 * @Title: getTestEventByOptId 
	 * @author 崔连瑞
	 * @date 2016-5-26 下午3:41:27
	 * @return SmPreTestData
	 * @param operationId
	 * @throws 
	 *
	 */
	SmPreTestData getTestEventByOptId(String operationId);
	
	/**
	 * @Title: addTestData 
	 * @author 崔连瑞
	 * @date 2016-5-26 下午3:41:27
	 * @return void
	 * @param SmPreTestData
	 * @throws 
	 *
	 */
	void addTestData(SmPreTestData sprd);
	
	/**
	 * @Title: updateTestData 
	 * @author 崔连瑞
	 * @date 2016-5-26 下午3:41:27
	 * @return void
	 * @param SmPreTestData
	 * @throws 
	 *
	 */
	void updateTestData(SmPreTestData sprd);

}
