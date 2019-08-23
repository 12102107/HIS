
package com.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;


public class DateUtil {
	
    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_PATTERN = "yyyy-MM-dd";
    
    public static final String MONTH_PATTERN = "yyyy-MM";
	
	public static String getDate2FormatString(Date date,String format){
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	
    /**
     * 
     * @方法名称: doConvertToString
     * @功能描述: 日期格式转换
     * @作者:陈先微
     * @创建时间:2015-11-10 下午4:16:58
     * @param value
     * @return String
     */
   public static String doConvertToString(Object value) {
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_PATTERN);
       String result = null;
       if (value instanceof Date) {
               result = simpleDateFormat.format(value);
       }
       return result;
   }
   
    /**
     * @方法名称: toString
     * @功能描述: 将日期转化为相应的字符串类型
     * @格式为：yyyy/MM/dd HH:mm:ss或yyyy-MM-dd HH:mm:ss
     * @作者:温冲
     * @创建时间:2016-1-20 下午7:25:42
     * @param p_date
     * @param p_format
     * @return String
     */
	public static String toString(Date p_date, String p_format) {
		DateFormat df = new SimpleDateFormat(p_format);
		return df.format(p_date);
	}
	
	/**
	 * @方法名称: parse
	 * @功能描述: 返回对应日期的毫秒数
	 * @作者:温冲
	 * @创建时间:2016-1-20 下午8:25:27
	 * @param str
	 * @param mode
	 * @return long
	 */
	public static long parse(String str,String mode) {  
		Date date=null;
		SimpleDateFormat formatter = new SimpleDateFormat(mode);		
		try {
			 date=formatter.parse(str);    
		} catch (Exception e) {					
			e.printStackTrace();
		}
	   return date.getTime();
	}

	/**
	 * @方法名称: addMinutes
	 * @功能描述: 在指定日期上添加分钟
	 * @作者:温冲
	 * @创建时间:2016-1-22 上午10:43:52
	 * @param p_date
	 * @param p_amount
	 * @return Date
	 */
    public static Date addMinutes(Date p_date, int p_amount) {
        return add(p_date, Calendar.MINUTE, p_amount);
    }
    /**
	 * <p>在指定日期上添加月</p>
	 * @param p_date  Date 日期对象
	 * @param p_amount int 月数
	 * @return Date 日期对象
	 */
	 public static Date addMonths(Date p_date, int p_amount) {
		 return add(p_date, Calendar.MONTH, p_amount);
	 }
	 
	 /**<p>在指定日期上添加周</p>
	  * @param p_date Date 日期对象
	  * @param p_amount int 周数
	  * @return Date 日期对象
	  */
	 public static Date addWeeks(Date p_date, int p_amount) {
        return add(p_date, Calendar.WEEK_OF_YEAR, p_amount);
     }
	 
	/**<p>在指定日期上添加天</p>
	 * @param p_date date 日期对象
	 * @param p_amount int 天数
	 * @return Date 日期对象
	 */
    public static Date addDays(Date p_date, int p_amount) {
        return add(p_date, Calendar.DAY_OF_MONTH, p_amount);
    }
    
	/**<p>在指定日期上添加小时</p>
	 * @param p_date Date 日期对象
	 * @param p_amount int 小时数
	 * @return Date 日期对象
	 */
    public static Date addHours(Date p_date, int p_amount) {
        return add(p_date, Calendar.HOUR_OF_DAY, p_amount);
    }
  
    /**<p>在指定日期上添加秒</p>
     * @param p_date Date 日期对象
     * @param p_amount int 秒数
     * @return Date 日期对象
     */
    public static Date addSeconds(Date p_date, int p_amount) {
        return add(p_date, Calendar.SECOND, p_amount);
    }
    
    /**<p>在指定日期上添加域的数量</p>
     * @param p_date Date 日期对象
     * @param p_calendarField int calendar域
     * @param p_amount int 总数
     * @return Date 日期对象
     */
    private static Date add(Date p_date, int p_calendarField, int p_amount) {
        if (p_date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(p_date);
        c.add(p_calendarField, p_amount);
        return c.getTime();
    }
    
    /**
     * @方法名称: toDate
     * @功能描述: 字符串类型的日期转换为指定格式的日期对象
     * @格式为:yyyy/MM/dd HH:mm:ss或yyyy-MM-dd HH:mm:ss
     * @作者:温冲
     * @创建时间:2016-1-22 上午10:54:58
     * @param p_value
     * @param p_format
     * @return Date
     */
	public static Date toDate(String p_value, String p_format) {
		Date _rtndate = null;
		try {
			SimpleDateFormat _sdf = new SimpleDateFormat(p_format);
			_rtndate = _sdf.parse(p_value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return _rtndate;
	}
    
    

}

