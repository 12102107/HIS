/**  
 * @Title: PreVisitService.java 
 * @Package com.znyy.sm.service 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-29 下午1:28:49 
 */ 
package com.znyy.sm.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmPreTestData;
import com.znyy.bean.SmPreVisit;
import com.znyy.bean.SmPreVisitMedicalHistory;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;

/** 
 * @ClassName: PreVisitService 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-2-29 下午1:28:49 
 */
public interface PreVisitService {

	/**
	 * @Title: getSmRegOptById 
	 * @Description: 获取手术信息
	 * @author 白东旭
	 * @date 2016-3-2 上午9:26:57
	 * @param @param ylwsid
	 * @param @return
	 * @return SmRegOpt
	 * @throws 
	 *
	 */ 
	
	SmRegOpt getSmRegOptById(String ylwsid);

	/**
	 * @param userid 
	 * @Title: getMzysByUserid 
	 * @Description: 获取当前登陆麻醉医师
	 * @author 白东旭
	 * @date 2016-3-2 上午9:37:17
	 * @param @return
	 * @return SmOperationPeople
	 * @throws 
	 *
	 */ 
	
	SmOperationPeople getMzysByUserid(String userid);

	/**
	 * @param visitDate 
	 * @Title: savePreVisit 
	 * @Description: TODO
	 * @author 白东旭
	 * @date 2016-3-2 上午10:40:48
	 * @param @param preVisit
	 * @param @param spVmh
	 * @param @param bP1 血压
	 * @param @param bP2 血压
	 * @param @param r 心率
	 * @param @param p 呼吸
	 * @param @param t 体温
	 * @param @param elze
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void savePreVisit(SmPreVisit preVisit, SmPreVisitMedicalHistory spVmh,
			String bP1, String bP2, String r, String p, String t, String elze, String visitDate);

	/**
	 * @Title: getPreVisitByYlwsd 
	 * @Description: 获取术前访视信息
	 * @author 白东旭
	 * @date 2016-3-2 上午11:26:47
	 * @param @param ylwsid
	 * @param @return
	 * @return SmPreVisit
	 * @throws 
	 *
	 */ 
	
	SmPreVisit getPreVisitByYlwsd(String ylwsid);

	/**
	 * @Title: getSpVmhByYlwsd 
	 * @Description: 获取术前访视病史信息
	 * @author 白东旭
	 * @date 2016-3-2 上午11:27:05
	 * @param @param ylwsid
	 * @param @return
	 * @return SmPreVisitMedicalHistory
	 * @throws 
	 *
	 */ 
	
	SmPreVisitMedicalHistory getSpVmhByYlwsd(String ylwsid);

	/**
	 * @Title: getSpacialMonitoring 
	 * @Description: 获取血压等信息
	 * @author 白东旭
	 * @date 2016-3-2 下午1:07:15
	 * @param @param preVisit
	 * @param @return
	 * @return Map<String,String>
	 * @throws 
	 *
	 */ 
	
	Map<String, String> getSpacialMonitoring(SmPreVisit preVisit);

	/**
	 * @throws ParseException 
	 * @param visitDate 
	 * @Title: commitPreVisit 
	 * @Description: 提交术前访视
	 * @author 白东旭
	 * @date 2016-3-2 下午3:11:23
	 * @param @param preVisit
	 * @param @param spVmh
	 * @param @param bP1
	 * @param @param bP2
	 * @param @param r
	 * @param @param p
	 * @param @param t
	 * @param @param elze
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void commitPreVisit(SmPreVisit preVisit, SmPreVisitMedicalHistory spVmh,
			String bP1, String bP2, String r, String p, String t, String elze, String visitDate) throws ParseException;

	/**
	 * @param ylwsid 
	 * @Title: getPreVisitPrint 
	 * @Description: 获取打印数据
	 * @author 白东旭
	 * @date 2016-3-3 下午4:41:50
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, Object>> getPreVisitPrint(String ylwsid);

	/**
	 * @param userid 
	 * @Title: savePreVisitTemplate 
	 * @Description: 保存模板
	 * @author 白东旭
	 * @date 2016-3-31 上午10:24:56
	 * @param @param preVisit
	 * @param @param spVmh
	 * @param @param bP1
	 * @param @param bP2
	 * @param @param r
	 * @param @param p
	 * @param @param t
	 * @param @param elze
	 * @param @param visitDate
	 * @param @param templateType
	 * @param @param templateName
	 * @return void
	 * @throws 
	 *
	 */ 
	
	void savePreVisitTemplate(SmPreVisit preVisit,
			SmPreVisitMedicalHistory spVmh, String bP1, String bP2, String r,
			String p, String t, String elze, String visitDate,
			String templateType, String templateName, String userid);

	/**
	 * @Title: getSmWritTemplatePersonal 
	 * @Description: 获取个人模板
	 * @author 白东旭
	 * @date 2016-3-31 下午2:21:04
	 * @param @param userid
	 * @param @return
	 * @return List<SmWritTemplate>
	 * @throws 
	 *
	 */ 
	
	List<SmWritTemplate> getSmWritTemplatePersonal(String userid);

	/**
	 * @Title: getSmWritTemplatePublic 
	 * @Description: 获取公共模板
	 * @author 白东旭
	 * @date 2016-3-31 下午2:21:15
	 * @param @return
	 * @return List<SmWritTemplate>
	 * @throws 
	 *
	 */ 
	
	List<SmWritTemplate> getSmWritTemplatePublic();

	/**
	 * @Title: getTemplateVal 
	 * @Description: 获取模板内容
	 * @author 白东旭
	 * @date 2016-4-1 上午10:09:41
	 * @param @param templateId
	 * @param @return
	 * @return List<Map<String,String>>
	 * @throws 
	 *
	 */ 
	
	List<Map<String, String>> getTemplateVal(String templateId);

	/**
	 * @Title: delTemplate 
	 * @Description: 删除模板
	 * @author 白东旭
	 * @date 2016-4-1 下午3:41:05
	 * @param @param templateId
	 * @return void
	 * @throws   
	 *
	 */ 
	
	void delTemplate(String templateId);

	/**
	 * @Title: loadTestResult 
	 * @Description: 加载检验检查事件
	 * @author 崔连瑞
	 * @date 2016-5-26 下午3:41:05
	 * @param  String ylwsid
	 * @return Map<String , Object>
	 * @throws   
	 *
	 */ 
    Map<String , Object> loadTestResult(String hid);
    
    /**
     * @Title: getTestEventByOperationId 
     * @Description: 获取检验检查事件
     * @author 崔连瑞
     * @date 2016-5-26 下午3:41:05
     * @param  String operationId
     * @return SmPreTestData
     *
     */ 
    SmPreTestData getTestEventByOperationId(String operationId);
    
    /**
     * @Title: addTest 
     * @Description: 更新检验检查事件
     * @author 崔连瑞
     * @date 2016-5-26 下午3:41:05
     * @param  SmPreTestData  
     * @return void
     *
     */ 
    void addTest(SmPreTestData sprd);
    
    /**
     * @Title: updateTest 
     * @Description: 添加检验检查事件
     * @author 崔连瑞
     * @date 2016-5-26 下午3:41:05
     * @param  SmPreTestData
     * @return void
     *
     */ 
    void updateTest(SmPreTestData sprd);
}
