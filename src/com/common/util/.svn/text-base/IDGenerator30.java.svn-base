
package com.common.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**   
  * 项目名称：SmHis 
 * 类名称：IDGenerator   
 * 类描述：生成ID，功能类似uuid,保证生成主键唯一，且具有一定意义   
 * 创建人：魏兆鹏
 * 创建时间：2015-11-20   
 *    
 */
public class IDGenerator30 {

	
	
	
	private static StringBuilder stringBuilder = new StringBuilder();
	
	/**

	 * ID 为30位char 分为4部分
	 * 1. 五位UserID，不足五位后面补0
	 * 2. 五位模块名称，不足五位后面补0
	 * 3. 十七位时间
	 * 4. 三位时间
	 * 方法需要同步处理，防止出现同步问题
	 * @param userID 用户ID
	 * @param moduleName 模块名称
	 * @return 字符串
	 * @throws
	 */
	public synchronized  static String generateID(String userID, String moduleName) {
		
	
	
		stringBuilder.setLength(0);
		if (userID.length() < 5) {
			stringBuilder.append(userID);
			for (int i = 0; i < 5 - userID.length(); i++) {
				stringBuilder.append('0');
			}
			
		}
		else {
			userID = userID.substring(0, 5);
			stringBuilder.append(userID);
		}
		
		if (moduleName.length() < 5) {
			stringBuilder.append(moduleName);
			for (int i = 0; i < 5 - moduleName.length(); i++) {
				stringBuilder.append('0');
			}
			
		}
		else {
			moduleName = moduleName.substring(0, 5);
			stringBuilder.append(moduleName);
		}
	
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		
		stringBuilder.append(timeStamp);
		
		
		String pattern = "000";
		DecimalFormat df = new DecimalFormat(pattern);
		Random random = new Random();
	
		stringBuilder.append(df.format(random.nextInt(9999999) %999));
		
		
		return stringBuilder.toString();
	}
	
	/*
	public static void main(String args[]) {
		System.out.println(IDGenerator30.generateID("10000", "system"));
		
	}*/
}
