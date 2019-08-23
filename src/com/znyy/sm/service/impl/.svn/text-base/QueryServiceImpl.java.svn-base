/**  
 * @Title: QueryServiceImpl.java 
 * @Package com.znyy.sm.service.impl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-19 上午9:19:16 
 */ 
package com.znyy.sm.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.znyy.bean.SmDiagnosedef;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.SmOperdef;
import com.znyy.bean.SmOperroom;
import com.znyy.bean.SmRegOpt;
import com.znyy.bean.SysCvFyzflb;
import com.znyy.bean.SysDiseaseArea;
import com.znyy.bean.SysIcdCode;
import com.znyy.bean.XtUnit;
import com.znyy.sm.dao.DeptDao;
import com.znyy.sm.dao.DiagnosedefDao;
import com.znyy.sm.dao.QueryDao;
import com.znyy.sm.dao.RegOptDao;
import com.znyy.sm.service.QueryService;

/** 
 * @ClassName: QueryServiceImpl 
 * @Description: 手术查询接口实现类 
 * @author 白东旭
 * @date 2016-2-19 上午9:19:16 
 */
public class QueryServiceImpl implements QueryService {

	private DeptDao deptDao;

	public DeptDao getDeptDao() {
	
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
	
		this.deptDao = deptDao;
	}
	
	private DiagnosedefDao diagnosedefDao;
	
	/**
	 * @return the diagnosedefDao
	 */
	public DiagnosedefDao getDiagnosedefDao() {
		return diagnosedefDao;
	}

	/**
	 * @param diagnosedefDao the diagnosedefDao to set
	 */
	public void setDiagnosedefDao(DiagnosedefDao diagnosedefDao) {
		this.diagnosedefDao = diagnosedefDao;
	}


	private RegOptDao regOptDao;

	public RegOptDao getRegOptDao() {
	
		return regOptDao;
	}

	public void setRegOptDao(RegOptDao regOptDao) {
	
		this.regOptDao = regOptDao;
	}

	
	private QueryDao queryDao;

	/**
	 * @return the queryDao
	 */
	public QueryDao getQueryDao() {
		return queryDao;
	}

	/**
	 * @param queryDao the queryDao to set
	 */
	public void setQueryDao(QueryDao queryDao) {
		this.queryDao = queryDao;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getSroListWeek()
	 */
	@Override
	public List<Map<String, Object>> getSroListWeek(String hospitalId) throws ParseException {
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		
		Date day = new Date();
		DateFormat str = new SimpleDateFormat("MM月dd日 EEEE");
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<7;i++) {
			
			Map<String,Object> map = new HashMap<String,Object>();
			
			Calendar c = Calendar.getInstance();
			c.setTime(day);
			c.add(Calendar.DATE, i);
			
			c.set(Calendar.HOUR, 0);
			c.set(Calendar.SECOND,0);
			c.set(Calendar.MINUTE,0);
			
			map.put("day", str.format(c.getTime()));
			
			List<Map<String,Object>> r = queryDao.getSroByDay(f.parse(f.format(c.getTime())),hospitalId);
			map.put("sro", r);
			
			result.add(map);
			
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#modCancelSro(java.lang.String, java.lang.String)
	 */
	@Override
	public void modCancelSro(String sroid, String reason) {
		
		SmRegOpt sro = queryDao.getSmRegOptById(sroid);
		
		sro.setState("00");
		sro.setReasons(reason);
		
		queryDao.saveSmRegOpt(sro);
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#activateSro(java.lang.String)
	 */
	@Override
	public void activateSro(String sroid) {
		
		SmRegOpt sro = queryDao.getSmRegOptById(sroid);
		
		sro.setState("01");
		
		queryDao.saveSmRegOpt(sro);
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getSmRegOptById(java.lang.String)
	 */
	@Override
	public SmRegOpt getSmRegOptById(String sroid) throws ParseException {
		
		SmRegOpt sro = queryDao.getSmRegOptById(sroid);

		return sro;
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getSmDiagnosedefList()
	 */
	@Override
	public List<SmDiagnosedef> getSmDiagnosedefList() {

		return queryDao.getSmDiagnosedefList();
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getSmOperdefList()
	 */
	@Override
	public List<SmOperdef> getSmOperdefList() {

		return queryDao.getSmOperdefList();
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getSmOperationPeopleList(java.lang.String)
	 */
	@Override
	public List<SmOperationPeople> getSmOperationPeopleList(String string) {
		
		return queryDao.getSmOperationPeopleList(string);
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getSmOperroomList()
	 */
	@Override
	public List<SmOperroom> getSmOperroomList() {
		return queryDao.getSmOperroomList();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#modChangeSro(com.znyy.bean.SmRegOpt)
	 */
	@Override
	public void modChangeSro(SmRegOpt sro,Date operdate) {

		SmRegOpt opt = queryDao.getSmRegOptById(sro.getId());
		
		opt.setType(sro.getType());
		opt.setOptLevel(sro.getOptLevel());
		opt.setEndtime(sro.getEndtime());
		opt.setStarttime(sro.getStarttime());
		opt.setOperdate(operdate);
		opt.setOperatorId(sro.getOperatorId());
		opt.setOperatorName(sro.getOperatorName());
		opt.setDiagnosisName(sro.getDiagnosisName());
		opt.setDesignedOptName(sro.getDesignedOptName());
		opt.setDesignedAnaesMethodName(sro.getDesignedAnaesMethodName());
		opt.setRoom(sro.getRoom());
		opt.setCircunurse1(sro.getCircunurse1());
		opt.setCircunurse2(sro.getCircunurse2());
		opt.setInstrnurse1(sro.getInstrnurse1());
		opt.setInstrnurse2(sro.getInstrnurse2());
		opt.setAnesthetist(sro.getAnesthetist());
		opt.setCircuanesthetist(sro.getCircuanesthetist());
		opt.setAnaesAssistant(sro.getAnaesAssistant());
		opt.setState("03");
		
		queryDao.saveSmRegOpt(opt);
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getSmRegionList()
	 */
	@Override
	public List<SysDiseaseArea> getSmRegionList() {
		return queryDao.getSmRegionList();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#addEmergencySro(com.znyy.bean.SmRegOpt, java.util.Date)
	 */
	@Override
	public void addEmergencySro(SmRegOpt sro, Date operdate, String hospitalId) {
		sro.setType("0");
		sro.setState("03");
		sro.setOperdate(operdate);
		sro.setCreateTime(new Date());
		sro.setHospitalId(hospitalId);
		queryDao.saveSmRegOpt(sro);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getOutsideScreen()
	 */
	@Override
	public List<Map<String, Object>> getOutsideScreen(String hospitalId) {
		return queryDao.getOutsideScreen(hospitalId);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getInsideScreen()
	 */
	@Override
	public List<Map<String, Object>> getInsideScreen(String hospitalId) throws ParseException {
		return queryDao.getInsideScreen(hospitalId);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getSysCvFyzflbList()
	 */
	@Override
	public List<SysCvFyzflb> getSysCvFyzflbList() {
		return regOptDao.getSysCvFyzflbList();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getSysIcdCodeList()
	 */
	@Override
	public List<SysIcdCode> getSysIcdCodeList() {
		return diagnosedefDao.getSysIcdCodeList();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getScientificQuery()
	 */
	@Override
	public List<Map<String, Object>> getScientificQuery(String dateFrom, String dateTo, String sex,
			String age, String zd, String ss, String mz) throws ParseException {
		String minage = "";
		String maxage = "";
		if(age!=null&&age.equals("0")) {
			minage = "0";
			maxage = "10";
		}
		if(age!=null&&age.equals("1")) {
			minage = "11";
			maxage = "20";
		}
		if(age!=null&&age.equals("2")) {
			minage = "21";
			maxage = "30";
		}
		if(age!=null&&age.equals("3")) {
			minage = "31";
			maxage = "40";
		}
		if(age!=null&&age.equals("4")) {
			minage = "41";
			maxage = "50";
		}
		if(age!=null&&age.equals("5")) {
			minage = "51";
			maxage = "60";
		}
		if(age!=null&&age.equals("6")) {
			minage = "61";
			maxage = "70";
		}
		if(age!=null&&age.equals("7")) {
			minage = "71";
			maxage = "80";
		}
		if(age!=null&&age.equals("8")) {
			minage = "81";
			maxage = "90";
		}
		if(age!=null&&age.equals("9")) {
			minage = "91";
		}
		return queryDao.getScientificQuery(dateFrom,dateTo,sex,minage,maxage,zd,ss,mz);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.QueryService#getDepts(java.lang.String)
	 */
	@Override
	public List<XtUnit> getDepts(String hospitalId) {
		return deptDao.getDepts(hospitalId);
	}
	
}
