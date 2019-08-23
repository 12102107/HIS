/**
 * 
 */
package com.common.util;

import java.security.MessageDigest;

/**
 * <p>Title: MD5 </p>
 * <p>Description: MD5加密</p>
 * <p>Company: 光网科技</p> 
 * @author 白东旭
 * @date 2015-9-9,下午2:23:08
 */
public class MD5 {
	
	/**
	 * 
	 * @Description: 将需要加密的字符串转成32位16进制字符串
	 * @param @param inStr
	 * @param @return   
	 * @return String  
	 * @author 白东旭
	 * @date 2015-9-9,下午2:24:14
	 *
	 */
	public static String convert(String inStr){
		MessageDigest md5 = null;
		try{
			md5 = MessageDigest.getInstance("MD5");
		}catch (Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++){
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
}
