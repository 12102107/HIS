
package com.common.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.chainsaw.Main;

/**
 * @类名称: SerialNumberGenerater
 * @类描述:生成流水单号公共类
 * 0115121500001 前两位是模块代号4-8位是年月日，后五位是顺序编号
 * 
 * @作者:刘强
 * @创建时间:2015-12-13 上午10:34:56
 */
public class SerialNumberGenerater {
	private static final String SERIAL_NUMBER = "XXXX"; // 流水号格式
    private static SerialNumberGenerater primaryGenerater = null;
    
    
	
    public SerialNumberGenerater() {
		
	}

	/**
     * 取得PrimaryGenerater的单例实现
     * 
     * @return
     */
    public static SerialNumberGenerater getInstance() {
        if (primaryGenerater == null) {
            synchronized (SerialNumberGenerater.class) {
                if (primaryGenerater == null) {
                    primaryGenerater = new SerialNumberGenerater();
                }
            }
        }
        return primaryGenerater;
    }
    
    /**
     * 生成下一个编号
     * moduleName:功能编码（01:收银员日结,02:挂号员日结,03:医嘱收费,04:挂号收费,05急诊挂号收费）
     * sno:上一位单据号
     */
    public synchronized String generaterNextNumber(String moduleName,String sno) {
        String id = null;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        if (sno == null) {
            id =moduleName+formatter.format(date) + "00001";
        } else {
            int count = SERIAL_NUMBER.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append("0");
            }
            DecimalFormat df = new DecimalFormat("00000");
            id = moduleName+formatter.format(date)
                    + df.format(1 + Integer.parseInt(sno.substring(8, 13)));
        }
        return id;
    }
    
    public static void main(String[] args) {
    	SerialNumberGenerater s = new SerialNumberGenerater();
    	System.out.println(s.generaterNextNumber("01",null));//首次调用
    	System.out.println(s.generaterNextNumber("01","0115121500001"));//多次调用
	}
     
}

