/**
 * 
 */
package com.znyy.sm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.znyy.bean.SmAnaesSummary;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SmWritTemplate;
import com.znyy.sm.dao.AnesthesiaSummaryDao;
import com.znyy.sm.service.AnesthesiaSummaryService;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author 白东旭
 * @date 2016-4-28
 */
public class AnesthesiaSummaryServiceImpl implements AnesthesiaSummaryService {

	private AnesthesiaSummaryDao anesthesiaSummaryDao;

	/**
	 * @return the anesthesiaSummaryDao
	 */
	public AnesthesiaSummaryDao getAnesthesiaSummaryDao() {
		return anesthesiaSummaryDao;
	}

	/**
	 * @param anesthesiaSummaryDao the anesthesiaSummaryDao to set
	 */
	public void setAnesthesiaSummaryDao(AnesthesiaSummaryDao anesthesiaSummaryDao) {
		this.anesthesiaSummaryDao = anesthesiaSummaryDao;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaSummaryService#getSummaryByYlwsid(java.lang.String)
	 */
	@Override
	public SmAnaesSummary getSummaryByYlwsid(String ylwsid) {
		return anesthesiaSummaryDao.getSummaryByYlwsid(ylwsid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaSummaryService#saveSummary(com.znyy.bean.SmAnaesSummary)
	 */
	@Override
	public void saveSummary(SmAnaesSummary summary, String username) {
		
		if(summary.getId()!=null&&summary.getId().equals("")) {
			summary.setId(null);
		}
		summary.setCreatOperation(username);
		summary.setCreatTime(new Date());
		anesthesiaSummaryDao.saveSummary(summary);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaSummaryService#saveSummaryTemplate(com.znyy.bean.SmAnaesSummary, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void saveSummaryTemplate(SmAnaesSummary summary,
			String templateType, String templateName, String userid) {
		summary.setId(null);
		summary.setOperationId(null);
		summary.setCreatOperation(null);
		summary.setCreatTime(null);
		anesthesiaSummaryDao.saveSummary(summary);
		
		SmWritTemplate wt = new SmWritTemplate();
		wt.setName(templateName);
		wt.setType(templateType);
		wt.setWirtId(summary.getId());
		wt.setWirtType("04");
		wt.setEnable("0");
		if(templateType.equals("1")) {
			wt.setUserid(userid);
		}
		anesthesiaSummaryDao.saveSmWritTemplate(wt);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaSummaryService#getSmWritTemplatePersonal(java.lang.String)
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePersonal(String userid) {
		return anesthesiaSummaryDao.getSmWritTemplatePersonal(userid);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaSummaryService#getSmWritTemplatePublic()
	 */
	@Override
	public List<SmWritTemplate> getSmWritTemplatePublic() {
		return anesthesiaSummaryDao.getSmWritTemplatePublic();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaSummaryService#getTemplateVal(java.lang.String)
	 */
	@Override
	public SmAnaesSummary getTemplateVal(String templateId) {
		return anesthesiaSummaryDao.getTemplateVal(templateId);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaSummaryService#delTemplate(java.lang.String)
	 */
	@Override
	public void delTemplate(String templateId) {
		anesthesiaSummaryDao.delTemplate(templateId);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.AnesthesiaSummaryService#getSummaryPrint(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getSummaryPrint(String ylwsid) {
		
		SmAnaesSummary summary = anesthesiaSummaryDao.getSummaryByYlwsid(ylwsid);
		
		SmRegOpt sro = anesthesiaSummaryDao.getSmRegOpt(ylwsid);
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("name", sro.getName());
		if(sro.getSex().equals("0")) {
			map.put("sex", "男");
		} 
		if(sro.getSex().equals("1")) {
			map.put("sex", "女");
		}
		map.put("region", sro.getRegion());
		map.put("bed", sro.getBed());
		map.put("hid", sro.getHid());
		
		map.put("position", ObjToStr(summary.getPosition()));
		map.put("injectionResistance", ObjToStr(summary.getInjectionResistance()));
		map.put("backflow", ObjToStr(summary.getBackflow()));
		map.put("puncturePoint1Location", ObjToStr(summary.getPuncturePoint1Location()));
		map.put("puncturePoint1Result", ObjToStr(summary.getPuncturePoint1Result()));
		map.put("puncturePoint2Location", ObjToStr(summary.getPuncturePoint2Location()));
		map.put("puncturePoint2Result", ObjToStr(summary.getPuncturePoint2Result()));
		map.put("blood", ObjToStr(summary.getBlood()));
		map.put("skinDepth", ObjToStr(summary.getSkinDepth()));
		map.put("catheterDepth", ObjToStr(summary.getCatheterDepth()));
		map.put("punctureMethod", ObjToStr(summary.getPunctureMethod()));
		map.put("catheterizationSituation", ObjToStr(summary.getCatheterizationSituation()));
		map.put("reason", ObjToStr(summary.getReason()));
		map.put("ligamentaFlavaFeeli", ObjToStr(summary.getLigamentaFlavaFeeli()));
		map.put("anesthesiaLevelStartUp", ObjToStr(summary.getAnesthesiaLevelStartUp()));
		map.put("anesthesiaLevelStartDown", ObjToStr(summary.getAnesthesiaLevelStartDown()));
		map.put("vacuum", ObjToStr(summary.getVacuum()));
		map.put("pulsate", ObjToStr(summary.getPulsate()));
		map.put("anesthesiaLevelEndUp", ObjToStr(summary.getAnesthesiaLevelEndUp()));
		map.put("anesthesiaLevelEndDown", ObjToStr(summary.getAnesthesiaLevelEndDown()));
		
		map.put("orotracheal", ObjToStr(summary.getOrotracheal()));
		map.put("nasalIntubation", ObjToStr(summary.getNasalIntubation()));
		map.put("nasalIntubationLr", ObjToStr(summary.getNasalIntubationLr()));
		map.put("catheterId", ObjToStr(summary.getCatheterId()));
		map.put("anesthesiaInducementPeriod", ObjToStr(summary.getAnesthesiaInducementPeriod()));
		map.put("fiberscope", ObjToStr(summary.getFiberscope()));
		map.put("doubleLumen", ObjToStr(summary.getDoubleLumen()));
		map.put("doubleLumenLr", ObjToStr(summary.getDoubleLumenLr()));
		map.put("doubleLumenSituation", ObjToStr(summary.getDoubleLumenSituation()));
		map.put("inducingMethod", ObjToStr(summary.getInducingMethod()));
		map.put("laryngealMaskAirway", ObjToStr(summary.getLaryngealMaskAirway()));
		map.put("laryngealMaskAirwayType", ObjToStr(summary.getLaryngealMaskAirwayType()));
		map.put("auxiliary", ObjToStr(summary.getAuxiliary()));
		map.put("generalAnesthesiaOther", ObjToStr(summary.getGeneralAnesthesia()));
		
		map.put("cervicalPlexusBlock", ObjToStr(summary.getCervicalPlexusBlock()));
		map.put("cervicalPlexusBlockLr", ObjToStr(summary.getCervicalPlexusBlockLr()));
		map.put("cervicalPlexus", ObjToStr(summary.getCervicalPlexus()));
		map.put("brachialPlexusBlock", ObjToStr(summary.getBrachialPlexusBlock()));
		map.put("brachialPlexusBlockLr", ObjToStr(summary.getBrachialPlexusBlockLr()));
		map.put("brachialPlexusBlockMethod", ObjToStr(summary.getBrachialPlexusBlockMethod()));
		map.put("lumbarPlexusBlock", ObjToStr(summary.getLumbarPlexusBlock()));
		map.put("lumbarPlexusBlockLr", ObjToStr(summary.getLumbarPlexusBlockLr()));
		map.put("sciaticNerveBlock", ObjToStr(summary.getSciaticNerveBlock()));
		map.put("sciaticNerveBlockLr", ObjToStr(summary.getSciaticNerveBlockLr()));
		map.put("femoralNerveBlock", ObjToStr(summary.getFemoralNerveBlock()));
		map.put("femoralNerveBlockLr", ObjToStr(summary.getFemoralNerveBlockLr()));
		map.put("continuousFemoral", ObjToStr(summary.getContinuousFemoral()));
		map.put("continuousFemoralLr", ObjToStr(summary.getContinuousFemoralLr()));
		
		map.put("invasiveName", ObjToStr(summary.getInvasiveName()));
		map.put("invasiveNameElse", ObjToStr(summary.getInvasiveNameElse()));
		
		map.put("complicationName", ObjToStr(summary.getComplicationName()));
		map.put("complicationNameElse", ObjToStr(summary.getComplicationNameElse()));

		String adverseEvents="";
		
		if("1".equals(summary.getLaryngospasm())) {
			adverseEvents += "喉痉挛：" + ObjToStr(summary.getLaryngospasmContent()) + " ";
		}
		
		if("1".equals(summary.getOxygen())) {
			adverseEvents += "氧合不当：" + ObjToStr(summary.getOxygenContent()) + " " + ObjToStr(summary.getOxygenElse()) + " ";
		}
		
		if("1".equals(summary.getAnesMachineCircuit())) {
			adverseEvents += "麻醉机回路故障：" + ObjToStr(summary.getAnesMachineCircuitContent()) + " " + ObjToStr(summary.getAnesMachineCircuitElse()) + " ";
		}
		
		if("1".equals(summary.getMedications())) {
			adverseEvents += "用药：" + ObjToStr(summary.getMedicationsContent()) + " " + ObjToStr(summary.getMedicationsElse()) + " ";
		}
		
		if("1".equals(summary.getVentilationInvalid())) {
			adverseEvents += "通气无效：" + ObjToStr(summary.getVentilationInvalidContent()) + " " + ObjToStr(summary.getVentilationInvalidElse()) + " ";
		}
		
		if("1".equals(summary.getCirculationAnomaly())) {
			adverseEvents += "循环异常：" + ObjToStr(summary.getCirculationAnomalyContent()) + " " + ObjToStr(summary.getCirculationAnomalyElse()) + " ";
		}
		
		if("1".equals(summary.getAnesMachine())) {
			adverseEvents += "麻醉机：" + ObjToStr(summary.getAnesMachineContent()) + " " + ObjToStr(summary.getAnesMachineElse()) + " ";
		}
		
		if("1".equals(summary.getLocalAnesthesia())) {
			adverseEvents += "局麻技术：" + ObjToStr(summary.getLocalAnesthesiaContent()) + " " + ObjToStr(summary.getLocalAnesthesiaElse()) + " ";
		}
		
		if("1".equals(summary.getImproperVentilation())) {
			adverseEvents += "不当通气：" + ObjToStr(summary.getImproperVentilationContent()) + " ";
		}
		
		if("1".equals(summary.getVenousChannel())) {
			adverseEvents += "静脉通路：" + ObjToStr(summary.getVenousChannelContent()) + " " + ObjToStr(summary.getVenousChannelElse()) + " ";
		}
		
		if("1".equals(summary.getOtherMachine())) {
			adverseEvents += "其他设备：" + ObjToStr(summary.getOtherMachineContent()) + " ";
		}
		
		if("1".equals(summary.getOther())) {
			adverseEvents += ObjToStr(summary.getOtherContent()) + " ";
		}
		map.put("adverseEvents", adverseEvents);

		map.put("summary", ObjToStr(summary.getSummary()));
		
		map.put("anesthetist", ObjToStr(sro.getAnesthetist()));
		
		result.add(map);
		
		return result;
	}
	
	public String ObjToStr(Object obj) {
		if(obj==null) {
			return "";
		} else {
			return obj.toString();
		}
	}

	
}
