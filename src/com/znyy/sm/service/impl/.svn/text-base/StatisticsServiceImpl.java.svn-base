/**  
 * @Title: StatisticsServiceImpl.java 
 * @Package com.znyy.sm.service.impl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-3-15 下午1:34:46 
 */ 
package com.znyy.sm.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.znyy.bean.SmOperationPeople;
import com.znyy.bean.XtUnit;
import com.znyy.sm.dao.StatisticsDao;
import com.znyy.sm.service.StatisticsService;

/** 
 * @ClassName: StatisticsServiceImpl 
 * @Description: TODO 
 * @author 白东旭
 * @date 2016-3-15 下午1:34:46 
 */
public class StatisticsServiceImpl implements StatisticsService {

	private StatisticsDao statisticsDao;

	/**
	 * @return the statisticsDao
	 */
	public StatisticsDao getStatisticsDao() {
		return statisticsDao;
	}

	/**
	 * @param statisticsDao the statisticsDao to set
	 */
	public void setStatisticsDao(StatisticsDao statisticsDao) {
		this.statisticsDao = statisticsDao;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.StatisticsService#getSmDept()
	 */
	@Override
	public List<XtUnit> getSmDept() {
		return statisticsDao.getSmDept();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.StatisticsService#getAnesthetist()
	 */
	@Override
	public List<SmOperationPeople> getAnesthetist() {
		return statisticsDao.getAnesthetist();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.StatisticsService#getNurse()
	 */
	@Override
	public List<SmOperationPeople> getNurse() {
		return statisticsDao.getNurse();
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.StatisticsService#getLevelStatistics(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getLevelStatistics(String start,
			String end, String sType, String deptname,
			String sopname, String nursename) throws ParseException {
		
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar s = Calendar.getInstance();
		if(start!=null&&!"".equals(start)) {
			s.setTime(f.parse(start));
			s.set(Calendar.HOUR_OF_DAY, 0);
			s.set(Calendar.MINUTE, 0);
			s.set(Calendar.SECOND, 0);
		}
		
		Calendar e = Calendar.getInstance();
		if(end!=null&&!"".equals(end)) {
			e.setTime(f.parse(end));
			e.set(Calendar.HOUR_OF_DAY, 23);
			e.set(Calendar.MINUTE, 59);
			e.set(Calendar.SECOND, 59);
		}
		
		if(start==null&&end==null) {
			return statisticsDao.getLevelStatistics(null,null,sType,deptname,sopname,nursename);
		} else if(start!=null&&end==null) {
			return statisticsDao.getLevelStatistics(f.parse(start),null,sType,deptname,sopname,nursename);
		} else if(start==null&&end!=null) {
			return statisticsDao.getLevelStatistics(null,f.parse(end),sType,deptname,sopname,nursename);
		} else {
			return statisticsDao.getLevelStatistics(f.parse(start),f.parse(end),sType,deptname,sopname,nursename);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.StatisticsService#getWorkingTime(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getWorkingTime(String start, String end,
			String sType, String deptname, String sopname, String nursename) throws ParseException {
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar s = Calendar.getInstance();
		if(start!=null&&!"".equals(start)) {
			s.setTime(f.parse(start));
			s.set(Calendar.HOUR_OF_DAY, 0);
			s.set(Calendar.MINUTE, 0);
			s.set(Calendar.SECOND, 0);
		}
		
		Calendar e = Calendar.getInstance();
		if(end!=null&&!"".equals(end)) {
			e.setTime(f.parse(end));
			e.set(Calendar.HOUR_OF_DAY, 23);
			e.set(Calendar.MINUTE, 59);
			e.set(Calendar.SECOND, 59);
		}
		
		if(start==null&&end==null) {
			return statisticsDao.getWorkingTime(null,null,sType,deptname,sopname,nursename);
		} else if(start!=null&&end==null) {
			return statisticsDao.getWorkingTime(f.parse(start),null,sType,deptname,sopname,nursename);
		} else if(start==null&&end!=null) {
			return statisticsDao.getWorkingTime(null,f.parse(end),sType,deptname,sopname,nursename);
		} else {
			return statisticsDao.getWorkingTime(f.parse(start),f.parse(end),sType,deptname,sopname,nursename);
		}
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.StatisticsService#getAnalgesiaStatistics(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Object> getAnalgesiaStatistics(String start,
			String end) throws ParseException {

		if(start==null&&end==null) {
		
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//获取当前月第一天：
			Calendar c = Calendar.getInstance();    
			c.add(Calendar.MONTH, 0);
			c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
			String first = format.format(c.getTime());
			System.out.println("===============first:"+first);
        
			//获取当前月最后一天
			Calendar ca = Calendar.getInstance();    
			ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
			String last = format.format(ca.getTime());
			System.out.println("===============last:"+last);
        
			start = first;
			end = last;
			
		}
		
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar s = Calendar.getInstance();
		if(start!=null&&!"".equals(start)) {
			s.setTime(f.parse(start));
			s.set(Calendar.HOUR_OF_DAY, 0);
			s.set(Calendar.MINUTE, 0);
			s.set(Calendar.SECOND, 0);
		}
		
		Calendar e = Calendar.getInstance();
		if(end!=null&&!"".equals(end)) {
			e.setTime(f.parse(end));
			e.set(Calendar.HOUR_OF_DAY, 23);
			e.set(Calendar.MINUTE, 59);
			e.set(Calendar.SECOND, 59);
		}
		
		if(start==null&&end==null) {
			return statisticsDao.getAnalgesiaStatistics(null,null);
		} else if(start!=null&&end==null) {
			return statisticsDao.getAnalgesiaStatistics(f.parse(start),null);
		} else if(start==null&&end!=null) {
			return statisticsDao.getAnalgesiaStatistics(null,f.parse(end));
		} else {
			return statisticsDao.getAnalgesiaStatistics(f.parse(start),f.parse(end));
		}
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.StatisticsService#getCprStatistics(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Object> getCprStatistics(String start, String end) throws ParseException {
		if(start==null&&end==null) {
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//获取当前月第一天：
			Calendar c = Calendar.getInstance();    
			c.add(Calendar.MONTH, 0);
			c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
			String first = format.format(c.getTime());
			System.out.println("===============first:"+first);
        
			//获取当前月最后一天
			Calendar ca = Calendar.getInstance();    
			ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
			String last = format.format(ca.getTime());
			System.out.println("===============last:"+last);
        
			start = first;
			end = last;
			
		}
		
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar s = Calendar.getInstance();
		if(start!=null&&!"".equals(start)) {
			s.setTime(f.parse(start));
			s.set(Calendar.HOUR_OF_DAY, 0);
			s.set(Calendar.MINUTE, 0);
			s.set(Calendar.SECOND, 0);
		}
		
		Calendar e = Calendar.getInstance();
		if(end!=null&&!"".equals(end)) {
			e.setTime(f.parse(end));
			e.set(Calendar.HOUR_OF_DAY, 23);
			e.set(Calendar.MINUTE, 59);
			e.set(Calendar.SECOND, 59);
		}
		
		if(start==null&&end==null) {
			return statisticsDao.getCprStatistics(null,null);
		} else if(start!=null&&end==null) {
			return statisticsDao.getCprStatistics(f.parse(start),null);
		} else if(start==null&&end!=null) {
			return statisticsDao.getCprStatistics(null,f.parse(end));
		} else {
			return statisticsDao.getCprStatistics(f.parse(start),f.parse(end));
		}
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.StatisticsService#getRecoveryStatistics(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Object> getRecoveryStatistics(String start, String end) throws ParseException {
		
			if(start==null&&end==null) {
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//获取当前月第一天：
			Calendar c = Calendar.getInstance();    
			c.add(Calendar.MONTH, 0);
			c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
			String first = format.format(c.getTime());
			System.out.println("===============first:"+first);
        
			//获取当前月最后一天
			Calendar ca = Calendar.getInstance();    
			ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
			String last = format.format(ca.getTime());
			System.out.println("===============last:"+last);
        
			start = first;
			end = last;
			
		}
		
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar s = Calendar.getInstance();
		if(start!=null&&!"".equals(start)) {
			s.setTime(f.parse(start));
			s.set(Calendar.HOUR_OF_DAY, 0);
			s.set(Calendar.MINUTE, 0);
			s.set(Calendar.SECOND, 0);
		}
		
		Calendar e = Calendar.getInstance();
		if(end!=null&&!"".equals(end)) {
			e.setTime(f.parse(end));
			e.set(Calendar.HOUR_OF_DAY, 23);
			e.set(Calendar.MINUTE, 59);
			e.set(Calendar.SECOND, 59);
		}
		
		if(start==null&&end==null) {
			return statisticsDao.getRecoveryStatistics(null,null);
		} else if(start!=null&&end==null) {
			return statisticsDao.getRecoveryStatistics(f.parse(start),null);
		} else if(start==null&&end!=null) {
			return statisticsDao.getRecoveryStatistics(null,f.parse(end));
		} else {
			return statisticsDao.getRecoveryStatistics(f.parse(start),f.parse(end));
		}
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.StatisticsService#getNissStatistics(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Object> getNissStatistics(String start, String end) throws ParseException {
		
		if(start==null&&end==null) {
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//获取当前月第一天：
			Calendar c = Calendar.getInstance();    
			c.add(Calendar.MONTH, 0);
			c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
			String first = format.format(c.getTime());
        
			//获取当前月最后一天
			Calendar ca = Calendar.getInstance();    
			ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
			String last = format.format(ca.getTime());
        
			start = first;
			end = last;
			
		}
		
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar s = Calendar.getInstance();
		if(start!=null&&!"".equals(start)) {
			s.setTime(f.parse(start));
			s.set(Calendar.HOUR_OF_DAY, 0);
			s.set(Calendar.MINUTE, 0);
			s.set(Calendar.SECOND, 0);
		}
		
		Calendar e = Calendar.getInstance();
		if(end!=null&&!"".equals(end)) {
			e.setTime(f.parse(end));
			e.set(Calendar.HOUR_OF_DAY, 23);
			e.set(Calendar.MINUTE, 59);
			e.set(Calendar.SECOND, 59);
		}
		
		if(start==null&&end==null) {
			return statisticsDao.getNissStatistics(null,null);
		} else if(start!=null&&end==null) {
			return statisticsDao.getNissStatistics(f.parse(start),null);
		} else if(start==null&&end!=null) {
			return statisticsDao.getNissStatistics(null,f.parse(end));
		} else {
			return statisticsDao.getNissStatistics(f.parse(start),f.parse(end));
		}
		
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.StatisticsService#getMethodStatistics(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getMethodStatistics(String start,
			String end, String sType, String deptname, String sopname) throws ParseException {
		if(start==null&&end==null) {
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//获取当前月第一天：
			Calendar c = Calendar.getInstance();    
			c.add(Calendar.MONTH, 0);
			c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
			String first = format.format(c.getTime());
        
			//获取当前月最后一天
			Calendar ca = Calendar.getInstance();    
			ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
			String last = format.format(ca.getTime());
        
			start = first;
			end = last;
			
		}
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		
		List<Object> method = statisticsDao.getMethod();
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("method", method);
		result.add(m);
		
		if(sType.equals("0")) {
			if(deptname!=null&&!"".equals(deptname)&&!"x".equals(deptname)) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("name", deptname);
				List<Object> statistics = new ArrayList<Object>();
				for(Object obj:method) {
					List<Object> methodStatistics = statisticsDao.getMethodStatisticsDept(start,end,(String)obj,deptname);
					statistics.add(methodStatistics);
				}
				map.put("statistics", statistics);
				result.add(map);
			} else {
				List<XtUnit> smdept = statisticsDao.getSmDept();
				for(XtUnit dept:smdept) {
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("name", dept.getName());
					List<Object> statistics = new ArrayList<Object>();
					for(Object obj:method) {
						List<Object> methodStatistics = statisticsDao.getMethodStatisticsDept(start,end,(String)obj, dept.getName());
						statistics.add(methodStatistics);
					}
					map.put("statistics", statistics);
					result.add(map);
				}
			}
		}
		if(sType.equals("1")) {
			if(sopname!=null&&!"".equals(sopname)&&!"x".equals(sopname)) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("name", sopname);
				List<Object> statistics = new ArrayList<Object>();
				for(Object obj:method) {
					List<Object> methodStatistics = statisticsDao.getMethodStatisticsSop(start,end,(String)obj,sopname);
					statistics.add(methodStatistics);
				}
				map.put("statistics", statistics);
				result.add(map);
			} else {
				List<SmOperationPeople> sops = statisticsDao.getAnesthetist();
				for(SmOperationPeople sop:sops) {
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("name", sop.getName());
					List<Object> statistics = new ArrayList<Object>();
					for(Object obj:method) {
						List<Object> methodStatistics = statisticsDao.getMethodStatisticsSop(start,end,(String)obj, sop.getName());
						statistics.add(methodStatistics);
					}
					map.put("statistics", statistics);
					result.add(map);
				}
			}
		}

		return result;
	}

}
