/**  
 * @Title: PreVisitAction.java 
 * @Package com.znyy.sm.action 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-29 下午1:26:37 
 */ 
package com.znyy.sm.action;

import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.common.action.CommAction;
import com.common.util.XmlUtil;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmPreTestData;
import com.znyy.bean.SmPreVisit;
import com.znyy.bean.SmPreVisitMedicalHistory;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;
import com.znyy.sm.service.PreVisitService;

/** 
 * @ClassName: PreVisitAction 
 * @Description: 术前访视action 
 * @author 白东旭
 * @date 2016-2-29 下午1:26:37 
 */
public class PreVisitAction extends CommAction {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;

	private PreVisitService preVisitService;

	/**
	 * @return the preVisitService
	 */
	public PreVisitService getPreVisitService() {
		return preVisitService;
	}

	/**
	 * @param preVisitService the preVisitService to set
	 */
	public void setPreVisitService(PreVisitService preVisitService) {
		this.preVisitService = preVisitService;
	}
	
	private SmPreVisit preVisit;
	
	private SmPreVisitMedicalHistory spVmh;
	
	private String ylwsid;//OPERATION_ID
	private String hid;//OPERATION_ID
	
	
	private String BP1;
	private String BP2;
	private String R;
	private String P;
	private String T;
	private String elze;
	
	private String visitDate;
	
	private String templateType; 
	private String templateName; 
	private String templateId;

	private String loadTestResult;
	
	private String operationId;
	private String hb;
	private String hct;
	private String wbc;
	private String plt;
	private String KPlus;
	private String naPlus;
	private String clReduce;
	private String glu;
	private String sgpt;
	private String bun;
	private String cr;
	private String pt;
	private String aptt;
	private String pao2;
	
	
	
	
	private String functionid;
	
	/**
	 * 
	 * @Title: preVisitList 
	 * @Description: 查看术前访视单
	 * @author 白东旭
	 * @date 2016-3-1 上午9:20:55
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String preVisitList() {
		
		preVisit = preVisitService.getPreVisitByYlwsd(ylwsid);
		spVmh = preVisitService.getSpVmhByYlwsd(ylwsid);
		if(preVisit!=null) {
			Map<String,String> spacialMonitoring = preVisitService.getSpacialMonitoring(preVisit);
			if(spacialMonitoring!=null) {
				BP1 = spacialMonitoring.get("BP1");
				BP2 = spacialMonitoring.get("BP2");
				R = spacialMonitoring.get("R");
				P = spacialMonitoring.get("P");
				T = spacialMonitoring.get("T");
			}
		}
		
		SmRegOpt sro = preVisitService.getSmRegOptById(ylwsid);
		request.setAttribute("sro", sro);
		
		String userid = (String) session.get("userid");
		SmOperationPeople op = preVisitService.getMzysByUserid(userid);
		request.setAttribute("op", op);
		
		SmPreTestData sprd =preVisitService.getTestEventByOperationId(ylwsid);
		request.setAttribute("sprd", sprd);
		
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: savePreVisit 
	 * @Description: 保存术前访视信息
	 * @author 白东旭
	 * @date 2016-3-2 上午10:31:03
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void savePreVisit() {
		preVisitService.savePreVisit(preVisit,spVmh,BP1,BP2,R,P,T,elze,visitDate); 
	}
	
	/**
	 * 
	 * @Title: commitPreVisit 
	 * @Description: 提交术前访视
	 * @author 白东旭
	 * @date 2016-3-2 下午4:10:49
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void commitPreVisit() {
		try {
			preVisitService.commitPreVisit(preVisit,spVmh,BP1,BP2,R,P,T,elze,visitDate);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 
	 * @Title: chooseAsaTo 
	 * @Description: 选择asa页面跳转
	 * @author 白东旭
	 * @date 2016-3-2 下午4:11:11
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String chooseAsaTo() {
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: loadPrint 
	 * @Description: 获取打印数据
	 * @author 白东旭
	 * @date 2016-3-3 下午4:39:56
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void loadPrint() {
		try {
			
			List<Map<String, Object>> result = preVisitService.getPreVisitPrint(ylwsid);
		
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			PrintWriter out = response.getWriter();
			out.print(XmlUtil.xmlAssemble(null,result));
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title: templateTo 
	 * @Description: 模板信息跳转
	 * @author 白东旭
	 * @date 2016-3-31 上午10:22:05
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String templateTo() {
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: savePreVisitTemplate 
	 * @Description: 保存模板
	 * @author 白东旭
	 * @date 2016-3-31 上午10:24:12
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void savePreVisitTemplate() {
		String userid = (String) session.get("userid");
		preVisitService.savePreVisitTemplate(preVisit,spVmh,BP1,BP2,R,P,T,elze,visitDate,templateType,templateName,userid); 
	}
	
	/**
	 * 
	 * @Title: choseTemplateTo 
	 * @Description: 选择模板页跳转
	 * @author 白东旭
	 * @date 2016-3-31 下午2:04:16
	 * @param @return
	 * @return String
	 * @throws 
	 *
	 */
	public String choseTemplateTo() {
		
		String userid = (String) session.get("userid"); 
		
		List<SmWritTemplate> personalTemplate = preVisitService.getSmWritTemplatePersonal(userid);
		request.setAttribute("personal", personalTemplate);
		
		List<SmWritTemplate> publicTemplate = preVisitService.getSmWritTemplatePublic();
		request.setAttribute("publicT", publicTemplate);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: getTemplateVal 
	 * @Description: 获取模板内容
	 * @author 白东旭
	 * @date 2016-4-1 上午10:06:18
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void getTemplateVal() {
		
		List<Map<String,String>> template = preVisitService.getTemplateVal(templateId);
		try {
	
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");	

			String json = JSONArray.fromObject(template).toString();
			
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @Title: delTemplate 
	 * @Description: 删除模板
	 * @author 白东旭
	 * @date 2016-4-1 下午3:40:42
	 * @param 
	 * @return void
	 * @throws 
	 *
	 */
	public void delTemplate() {
		preVisitService.delTemplate(templateId);
	}
	
	
	
	/**
	 * @方法名称: loadAnesthesiaRecord
	 * @功能描述: 医疗文书跳转到麻醉记录
	 * @作者:崔连瑞
	 * @创建时间:2016-3-2 10:36:04
	 * @param ylwsid
	 * @return String
	 */
	public String loadTest(){
		Map<String,Object> map =preVisitService.loadTestResult(hid);
		JSONObject jsonObject = JSONObject.fromObject(map); 
		this.loadTestResult=jsonObject.toString();	
		return SUCCESS;
	}
	/**
	 * @方法名称: loadAnesthesiaRecord
	 * @功能描述: 医疗文书跳转到麻醉记录
	 * @作者:崔连瑞
	 * @创建时间:2016-3-2 10:36:04
	 * @param ylwsid
	 * @return String
	 */
	public String saveTest(){
		SmPreTestData sprd =preVisitService.getTestEventByOperationId(operationId);
		if(sprd!=null){
			sprd.setHb(Double.valueOf(hb).doubleValue());
			sprd.setHct(Double.valueOf(hct).doubleValue());
			sprd.setWbc(Double.valueOf(wbc).doubleValue());
			sprd.setPlt(Double.valueOf(plt).doubleValue());
			sprd.setKPlus(Double.valueOf(KPlus).doubleValue());
			sprd.setNaPlus(Double.valueOf(naPlus).doubleValue());
			sprd.setClReduce(Double.valueOf(clReduce).doubleValue());
			sprd.setGlu(Double.valueOf(glu).doubleValue());
			sprd.setSgpt(Double.valueOf(sgpt).doubleValue());
			sprd.setBun(Double.valueOf(bun).doubleValue());
			sprd.setCr(Double.valueOf(cr).doubleValue());
			sprd.setPt(Double.valueOf(pt).doubleValue());
			sprd.setAptt(Double.valueOf(aptt).doubleValue());
			sprd.setPao2(Double.valueOf(pao2).doubleValue());
			sprd.setTime(new Date());
			try {
				preVisitService.updateTest(sprd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
			SmPreTestData smprd = new SmPreTestData();
			smprd.setOperationId(operationId);
			smprd.setHb(Double.valueOf(hb).doubleValue());
			smprd.setHct(Double.valueOf(hct).doubleValue());
			smprd.setWbc(Double.valueOf(wbc).doubleValue());
			smprd.setPlt(Double.valueOf(plt).doubleValue());
			smprd.setKPlus(Double.valueOf(KPlus).doubleValue());
			smprd.setNaPlus(Double.valueOf(naPlus).doubleValue());
			smprd.setClReduce(Double.valueOf(clReduce).doubleValue());
			smprd.setGlu(Double.valueOf(glu).doubleValue());
			smprd.setSgpt(Double.valueOf(sgpt).doubleValue());
			smprd.setBun(Double.valueOf(bun).doubleValue());
			smprd.setCr(Double.valueOf(cr).doubleValue());
			smprd.setPt(Double.valueOf(pt).doubleValue());
			smprd.setAptt(Double.valueOf(aptt).doubleValue());
			smprd.setPao2(Double.valueOf(pao2).doubleValue());
			smprd.setTime(new Date());
			try {
				preVisitService.addTest(smprd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @return the preVisit
	 */
	public SmPreVisit getPreVisit() {
		return preVisit;
	}

	/**
	 * @param preVisit the preVisit to set
	 */
	public void setPreVisit(SmPreVisit preVisit) {
		this.preVisit = preVisit;
	}

	/**
	 * @return the ylwsid
	 */
	public String getYlwsid() {
		return ylwsid;
	}

	/**
	 * @param ylwsid the ylwsid to set
	 */
	public void setYlwsid(String ylwsid) {
		this.ylwsid = ylwsid;
	}

	/**
	 * @return the spVmh
	 */
	public SmPreVisitMedicalHistory getSpVmh() {
		return spVmh;
	}

	/**
	 * @param spVmh the spVmh to set
	 */
	public void setSpVmh(SmPreVisitMedicalHistory spVmh) {
		this.spVmh = spVmh;
	}
	
	/**
	 * @return the r
	 */
	public String getR() {
		return R;
	}

	/**
	 * @param r the r to set
	 */
	public void setR(String r) {
		R = r;
	}

	/**
	 * @return the p
	 */
	public String getP() {
		return P;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(String p) {
		P = p;
	}

	/**
	 * @return the t
	 */
	public String getT() {
		return T;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(String t) {
		T = t;
	}

	/**
	 * @return the elze
	 */
	public String getElze() {
		return elze;
	}

	/**
	 * @param elze the elze to set
	 */
	public void setElze(String elze) {
		this.elze = elze;
	}

	/**
	 * @return the bP1
	 */
	public String getBP1() {
		return BP1;
	}

	/**
	 * @param bP1 the bP1 to set
	 */
	public void setBP1(String bP1) {
		BP1 = bP1;
	}

	/**
	 * @return the bP2
	 */
	public String getBP2() {
		return BP2;
	}

	/**
	 * @param bP2 the bP2 to set
	 */
	public void setBP2(String bP2) {
		BP2 = bP2;
	}

	/**
	 * @return the visitDate
	 */
	public String getVisitDate() {
		return visitDate;
	}

	/**
	 * @param visitDate the visitDate to set
	 */
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	/**
	 * @return the templateType
	 */
	public String getTemplateType() {
		return templateType;
	}

	/**
	 * @param templateType the templateType to set
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	/**
	 * @return the templateName
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * @return the templateId
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the functionid
	 */
	public String getFunctionid() {
		return functionid;
	}

	/**
	 * @param functionid the functionid to set
	 */
	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getLoadTestResult() {
		return loadTestResult;
	}

	public void setLoadTestResult(String loadTestResult) {
		this.loadTestResult = loadTestResult;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getHb() {
		return hb;
	}

	public void setHb(String hb) {
		this.hb = hb;
	}

	public String getHct() {
		return hct;
	}

	public void setHct(String hct) {
		this.hct = hct;
	}

	public String getWbc() {
		return wbc;
	}

	public void setWbc(String wbc) {
		this.wbc = wbc;
	}

	public String getPlt() {
		return plt;
	}

	public void setPlt(String plt) {
		this.plt = plt;
	}

	public String getKPlus() {
		return KPlus;
	}

	public void setKPlus(String kPlus) {
		KPlus = kPlus;
	}

	public String getNaPlus() {
		return naPlus;
	}

	public void setNaPlus(String naPlus) {
		this.naPlus = naPlus;
	}

	public String getClReduce() {
		return clReduce;
	}

	public void setClReduce(String clReduce) {
		this.clReduce = clReduce;
	}

	public String getGlu() {
		return glu;
	}

	public void setGlu(String glu) {
		this.glu = glu;
	}

	public String getSgpt() {
		return sgpt;
	}

	public void setSgpt(String sgpt) {
		this.sgpt = sgpt;
	}

	public String getBun() {
		return bun;
	}

	public void setBun(String bun) {
		this.bun = bun;
	}

	public String getCr() {
		return cr;
	}

	public void setCr(String cr) {
		this.cr = cr;
	}

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getAptt() {
		return aptt;
	}

	public void setAptt(String aptt) {
		this.aptt = aptt;
	}

	public String getPao2() {
		return pao2;
	}

	public void setPao2(String pao2) {
		this.pao2 = pao2;
	}

	
	
}
