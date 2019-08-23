/**  
 * @Title: ArrangeServiceImpl.java 
 * @Package com.znyy.sm.service.impl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016-2-23 下午1:22:16 
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

import com.znyy.sm.dao.ArrangeDao;
import com.znyy.sm.service.ArrangeService;

/** 
 * @ClassName: ArrangeServiceImpl 
 * @Description: 排班管理Service实现类 
 * @author 白东旭
 * @date 2016-2-23 下午1:22:16 
 */
public class ArrangeServiceImpl implements ArrangeService {

	private ArrangeDao arrangeDao;

	/**
	 * @return the arrangeDao
	 */
	public ArrangeDao getArrangeDao() {
		return arrangeDao;
	}

	/**
	 * @param arrangeDao the arrangeDao to set
	 */
	public void setArrangeDao(ArrangeDao arrangeDao) {
		this.arrangeDao = arrangeDao;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.ArrangeService#getMyArrangeWeek()
	 */
	@Override
	public List<Map<String, Object>> getMyArrangeWeek(String userid, String dateFrom, String dateTo) throws ParseException {
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		if(dateFrom==null&&dateTo==null) {
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
			
				List<Map<String,Object>> r = arrangeDao.getMyArrangeByDay(f.parse(f.format(c.getTime())),userid);
				map.put("sro", r);
			
				result.add(map);
			}
		} else {
			DateFormat str = new SimpleDateFormat("MM月dd日 EEEE");
			DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			Date day = f.parse(dateFrom);
			int num = daysBetween(f.parse(dateFrom),f.parse(dateTo));
			for(int i=0;i<=num;i++) {
			
				Map<String,Object> map = new HashMap<String,Object>();
			
				Calendar c = Calendar.getInstance();
				c.setTime(day);
				c.add(Calendar.DATE, i);
			
				c.set(Calendar.HOUR, 0);
				c.set(Calendar.SECOND,0);
				c.set(Calendar.MINUTE,0);
			
				map.put("day", str.format(c.getTime()));
			
				List<Map<String,Object>> r = arrangeDao.getMyArrangeByDay(f.parse(f.format(c.getTime())),userid);
				map.put("sro", r);
			
				result.add(map);
			}
		}
		return result;
	}

	public static int daysBetween(Date smdate,Date bdate) throws ParseException {    
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		smdate=sdf.parse(sdf.format(smdate));  
		bdate=sdf.parse(sdf.format(bdate));  
		Calendar cal = Calendar.getInstance();    
		cal.setTime(smdate);    
		long time1 = cal.getTimeInMillis();                 
		cal.setTime(bdate);    
		long time2 = cal.getTimeInMillis();         
		long between_days=(time2-time1)/(1000*3600*24);  
		            
		return Integer.parseInt(String.valueOf(between_days));           
	} 	
		
	/* (non-Javadoc)
	 * @see com.znyy.sm.service.ArrangeService#getArrangeWeek()
	 */
	@Override
	public List<Map<String, Object>> getArrangeWeek(String dateFrom, String dateTo) throws ParseException {
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		
		if (dateFrom != null && !dateFrom.equals("")&&dateTo != null && !dateTo.equals("")) { 
			
			Map<String,Object> map = new HashMap<String,Object>();
			
			List<Map<String,Object>> r = arrangeDao.getArrangeByDay(null,dateFrom,dateTo);
			
			map.put("sro", r);
			
			result.add(map);
			
		} else {
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
				
				List<Map<String,Object>> r = arrangeDao.getArrangeByDay(f.parse(f.format(c.getTime())),dateFrom,dateTo);
				map.put("sro", r);
				
				result.add(map);
			}
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.service.ArrangeService#getArrangeWeekPrint()
	 */
	@Override
	public List<Map<String, Object>> getArrangeWeekPrint() throws ParseException {
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		
		Date day = new Date();
		DateFormat str = new SimpleDateFormat("MM月dd日 EEEE");
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<7;i++) {
			
			
			Calendar c = Calendar.getInstance();
			c.setTime(day);
			c.add(Calendar.DATE, i);
			
			c.set(Calendar.HOUR, 0);
			c.set(Calendar.SECOND,0);
			c.set(Calendar.MINUTE,0);
			
			List<Map<String,Object>> r = arrangeDao.getArrangeByDayPrint(f.parse(f.format(c.getTime())));
			
			result.addAll(r);
		}
	
		return result;
	} 
	
}
