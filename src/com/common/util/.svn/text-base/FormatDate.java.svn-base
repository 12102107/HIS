package com.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatDate {
	//获得当月第一天
    public static String getFirstDay(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
    	 Calendar c = Calendar.getInstance();   
         c.add(Calendar.MONTH, 0);
         c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
         return format.format(c.getTime());
    }
    //获得当月最后一天
    public static String getLastDay(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
    	Calendar ca = Calendar.getInstance();   
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH)); 
        return format.format(ca.getTime());
    }
}
