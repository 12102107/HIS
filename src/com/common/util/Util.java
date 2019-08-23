package com.common.util;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang.RandomStringUtils;

public class Util {
	
	/**  
	    * 获取汉字串拼音首字母，英文字符不变  
	    *  
	    * @param chinese 汉字串  
	    * @return 汉语拼音首字母  
	    */   
	   public static String cn2FirstSpell(String chinese) {   
	       StringBuffer pybf = new StringBuffer();   
	       char[] arr = chinese.toCharArray();   
	       HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();   
	       defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);   
	       defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   
	       for (int i = 0; i < arr.length; i++) {   
	               if (arr[i] > 128) {   
	                       try {   
	                               String[] _t = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);   
	                               if (_t != null) {   
	                                       pybf.append(_t[0].charAt(0));   
	                               }   
	                       } catch (BadHanyuPinyinOutputFormatCombination e) {   
	                               e.printStackTrace();   
	                       }   
	               } else {   
	                       pybf.append(arr[i]);   
	               }   
	       }   
	       return pybf.toString().replaceAll("\\W", "").trim().toUpperCase();   
	   }   
	   /**  
	    * 获取汉字串拼音，英文字符不变  
	    *  
	    * @param chinese 汉字串  
	    * @return 汉语拼音  
	    */  
	   public static String cn2Spell(String chinese) {   
	           StringBuffer pybf = new StringBuffer();   
	           char[] arr = chinese.toCharArray();   
	           HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();   
	           defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);   
	           defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   
	           for (int i = 0; i < arr.length; i++) {   
	                   if (arr[i] > 128) {   
	                           try {   
	                                   pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0]);   
	                           } catch (BadHanyuPinyinOutputFormatCombination e) {   
	                                   e.printStackTrace();   
	                           }   
	                   } else {   
	                           pybf.append(arr[i]);   
	                   }   
	           }   
	           return pybf.toString();   
	   }   	

	/**
	 * 获取档期日期时间
	 * 
	 * @param formatDate
	 *            日期时间格式
	 */
	public static String simpleDateFormat(String formatDate) {
		if ("".equals(formatDate)) {
			formatDate = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat format = new SimpleDateFormat(formatDate);// 设置日期格式
		String date = format.format(new Date());
		return date;
	}
	
	/**
	 * 转换日期时间格式
	 * 
	 * @param formatDate
	 *            要转换成的日期时间格式
	 * @param date
	 *            要转换的日期时间
	 * @return
	 */
	public static String conversionSimpleDateFormat(String formatDate, String date) {
		SimpleDateFormat format = new SimpleDateFormat(formatDate);// 设置日期格式
		String newDate = "";
		try {
			newDate = format.format(format.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDate;
	}

	public static boolean equalsDate(String dateString) {
		try {
			long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(dateString);//
			long diff = (new Date()).getTime() - date.getTime();
			long day = diff / nd;// 计算差多少天
			Long equalsDay = Long.valueOf("1");
			if (day < equalsDay) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	/**
	 * 日期时间格式转换
	 * @param formatDate
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date simpleDateFormatForDate(String formatDate, String date) throws Exception{
		if ("".equals(formatDate)) {
			formatDate = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat format = new SimpleDateFormat(formatDate);// 设置日期格式
		Date newdate = format.parse(date);
		return newdate;
	}
	
	
	/**
	 * @param String null
	 * @param String
	 * @return
	 * @throws Exception
	 */
	public static boolean isNotBlank(String str) throws Exception{
		if(str !=null && str !=""){
			 return true;
		}
		return false;
	}
	
	
	/**
	 * String转为float
	 * 
	 * @param str
	 * @param _default
	 * @return
	 */
	public static Float str2Float(String str, Float _default) {
		try {
			if (str != null) {
				return Float.parseFloat(str);
			}
			return _default;
		} catch (NumberFormatException e) {
			return _default;
		}
	}

	/**
	 * String转为integer 请使用getIntegerValue方法
	 * 
	 * @param str
	 * @param _default
	 * @return
	 */
	@Deprecated
	public static Integer str2Integer(String str, Integer _default) {
		try {
			if (str != null) {
				return Integer.parseInt(str);
			}
			return _default;
		} catch (NumberFormatException e) {
			return _default;
		}
	}

	/**
	 * string转为decimal
	 * 
	 * @param str
	 * @param _default
	 * @return
	 */
	public static BigDecimal str2BigDecimal(String str, BigDecimal _default) {
		try {
			if (str != null) {
				return new BigDecimal(str);
			}
			return _default;
		} catch (NumberFormatException e) {
			return _default;
		}
	}

	/**
	 * string转换为int,请使用getIntValue方法
	 * 
	 * @param str
	 * @param _default
	 * @return
	 */
	@Deprecated
	public static int str2Int(String str, int _default) {
		try {
			if (str != null) {
				return Integer.parseInt(str.trim());
			}
			return _default;
		} catch (Exception _ex) {
			return _default;
		}
	}

	/**
	 * 字符串判空
	 * 
	 * @param s
	 * @return
	 */
	public static String null2String(String s) {
		if (!isBlank(s)) {
			return s;
		} else {
			return "";
		}
	}

	/**
	 * 对象判空后返回字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String null2String(Object o) {
		return null2String(o, "");
	}

	/**
	 * 对象判空后返回字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String null2String(Object o, String defVal) {
		if (!isBlank(o)) {
			return o.toString();
		} else {
			return defVal;
		}

	}

	/**
	 * 字符串非空判断（"",null,"null"）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (null == str || str.trim().length() == 0
				|| "null".equalsIgnoreCase(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 字符串非空判断（"",null,"null"）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(Object o) {
		if (null == o || o.toString().trim().length() == 0
				|| "null".equalsIgnoreCase(o.toString())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 删除危险字符，以防止注入漏洞 例如：String gopage =
	 * Util.removeDangerousCharacter(request.getParameter("gopage"));
	 * 描述：getParameter方法获取的是前端（浏览器）传递的参数， 直接使用存在漏洞风险（sql注入、script注入等）。
	 * 
	 * @param s
	 * @return
	 */
	public static String removeDangerousCharacter(String s) {

		if (s != null) {
			s = s.replaceAll("<", "＜");
			s = s.replaceAll(">", "＞");
			s = s.replaceAll("\\(", "（");
			s = s.replaceAll("\\)", "）");
			s = s.replaceAll("'", "＇");
			// s = s.replaceAll("%", "％");
			s = s.replaceAll(";", "；");
			s = s.replaceAll("\\\\", "＼");
			s = s.replaceAll("\\+", "＋");
			// s = s.replaceAll("&", "＆");
		} else {
			s = "";
		}

		return s;
	}

	/**
	 * 替换危险字符，以防止链接注入漏洞 例如： javaScript中：var test = '<%=Util.jsString(test)%>';
	 * 描述：test值是getParameter方法获取的是前端（浏览器）传递的参数， 直接使用存在漏洞风险（链接注入、script注入等）。
	 * 
	 * @param s
	 * @return
	 */
	public static String jsString(String s) {
		if (s != null) {
			s = s.replaceAll("\"", "\\\"");
			s = s.replaceAll("'", "\\'");
			s = s.replaceAll(">", "\\>");
			// s = s.replaceAll("<","&lt;");
			// s = s.replaceAll(">","&gt;");
			// s = s.replaceAll("&","&amp;");
			// s = s.replaceAll("\"","&quot;");
		}
		return s;
	}

	/**
	 * 防止HTTP 响应分割
	 * 
	 * @param s
	 * @return
	 */
	public static String preventHttpResponseSplit(String s) {
		if (s != null) {
			s = s.replaceAll("\r", "");
			s = s.replaceAll("\n", "");
			s = s.replaceAll("%0d", "");
			s = s.replaceAll("%0D", "");
			s = s.replaceAll("%0a", "");
			s = s.replaceAll("%0A", "");
			s = s.replaceAll("%0d%0a", "");
			s = s.replaceAll("%0D%0A", "");
		}
		return s;
	}

	/**
	 * 返回服务器IP
	 * 
	 * @return
	 */
	public static String getServerIP() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		String sIP = "";
		InetAddress ip = null;
		try { // 如果是Windows操作系统
			if (isWindowsOS) {
				ip = InetAddress.getLocalHost();
			} else {// 如果是Linux操作系统
				boolean bFindIP = false;
				Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
						.getNetworkInterfaces();
				while (netInterfaces.hasMoreElements()) {
					if (bFindIP) {
						break;
					}
					NetworkInterface ni = (NetworkInterface) netInterfaces
							.nextElement();
					// ----------特定情况，可以考虑用ni.getName判断
					// 遍历所有ip
					Enumeration<InetAddress> ips = ni.getInetAddresses();
					while (ips.hasMoreElements()) {
						ip = (InetAddress) ips.nextElement();
						if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
						// 127.开头的都是lookback地址
								&& ip.getHostAddress().indexOf(":") == -1) {
							bFindIP = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != ip) {
			sIP = ip.getHostAddress();
		}
		return sIP;
	}

	/**
	 * 字符串转整数，出错返回-1
	 * 
	 * @param paramString
	 * @return
	 */
	public static int getIntValue(String paramString) {
		return getIntValue(paramString, -1);
	}

	/**
	 * Integer转int，null返回0
	 * 
	 * @param paramInteger
	 * @return
	 */
	public static int getIntValue(Integer paramInteger) {
		if (null == paramInteger) {
			return 0;
		} else {
			return paramInteger.intValue();
		}
	}

	/**
	 * 字符串转换为double类型
	 * 
	 * @param paramString
	 * @return
	 */
	public static Double getDoubleValue(String paramString) {
		Double b = 0.0;
		if (null == paramString || paramString.trim().length() < 1) {
			return b;
		}
		try {
			b = Double.parseDouble(paramString);
		} catch (Exception e) {
		}
		return b;
	}

	/**
	 * 字符串转换为double类型
	 * 
	 * @param value
	 *            被转换字符串
	 * @param defaultValue
	 *            出错时的缺省值
	 * @return
	 */
	public static Double getDoubleValue(String value, Double defaultValue) {
		Double d = defaultValue;
		if (isBlank(value)) {
			return d;
		}
		try {
			d = Double.parseDouble(value);
		} catch (Exception e) {
		}
		return d;
	}

	/**
	 * 字符串转整数，指定出错返回值
	 * 
	 * @param paramString
	 * @param paramInt
	 * @return
	 */
	public static int getIntValue(String paramString, int paramInt) {
		try {
			return Integer.parseInt(paramString);
		} catch (Exception localException) {
		}
		return paramInt;
	}

	/**
	 * object转为integer
	 * 
	 * @param obj
	 * @return
	 */
	public static Integer getIntegerValue(Object obj) {
		if (Util.isBlank(obj)) {
			return null;
		} else {
			try {
				return new Integer(obj.toString());
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * object转为integer 如果异常返回第二个参数值
	 * 
	 * @param obj
	 * @return
	 */
	public static Integer getIntegerValue(Object obj, int paramInt) {
		if (null == obj) {
			return paramInt;
		} else {
			try {
				return new Integer(obj.toString());
			} catch (Exception e) {
				return paramInt;
			}
		}
	}

	/**
	 * object转为Boolean类型
	 * 
	 * @param obj
	 * @return
	 */
	public static Boolean getBooleanValue(Object obj) {
		if (null == obj) {
			return null;
		} else {
			try {
				return new Boolean(obj.toString());
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * object转为long
	 * 
	 * @param obj
	 * @return
	 */
	public static Long getLongValue(Object obj) {
		if (null == obj) {
			return null;
		} else {
			try {
				return new Long(obj.toString());
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 取客户端IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getClientIP(HttpServletRequest request) {
		String IP = getClientIPAll(request);
		if (IP != null && !"".equals(IP)) {
			String[] ipArray = IP.split(",");
			IP = ipArray[ipArray.length - 1];
		}
		return IP;
	}

	/**
	 * 取客户端全IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getClientIPAll(HttpServletRequest request) {
		String IP = request.getHeader("x-forwarded-for");
		if ((IP == null) || (IP.length() == 0)
				|| ("unknown".equalsIgnoreCase(IP))) {
			IP = request.getHeader("Proxy-Client-IP");
		}
		if ((IP == null) || (IP.length() == 0)
				|| ("unknown".equalsIgnoreCase(IP))) {
			IP = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((IP == null) || (IP.length() == 0)
				|| ("unknown".equalsIgnoreCase(IP))) {
			IP = request.getRemoteAddr();
		}
		if (IP != null && IP.length() > 30) {
			IP = IP.substring(IP.length() - 30, IP.length());
		}
		return IP;
	}



	/**
	 * 原生成附件末级目录名称
	 * 
	 * @param paramInt
	 * @return
	 */
	public static String getCharString(int paramInt) {
		String str = "";
		int i = getchars(paramInt, 26, 0);

		for (int j = i; j > 0; j--) {
			int k;
			if (j > 1) {
				k = new BigDecimal(Math.pow(26.0D, j - 1)).intValue();
				int m = paramInt - k;
				int n = m % k;
				int i1 = m / k;
				paramInt -= k;
				if (n != 0)
					i1++;
				if (i1 > 26) {
					i1 %= 26;
					if (i1 == 0)
						i1 = 26;
				}
				str = str + (char) (i1 + 64);
			} else {
				k = paramInt;
				if (paramInt > 26)
					k = paramInt % 26;
				if (k == 0)
					k = 26;
				str = str + (char) (k + 64);
			}
		}
		return str;
	}

	public static int getchars(int paramInt1, int paramInt2, int paramInt3) {
		int i = 1;
		int j = paramInt1 / paramInt2;
		int k = paramInt1 % paramInt2;
		if (j > 0) {
			if (j > paramInt2) {
				if (k == 0)
					i += getchars(j, paramInt2, j / paramInt2);
				else {
					i += getchars(j, paramInt2, 0);
				}
			} else if ((j > 1) || (k > paramInt3))
				i++;
		}

		return i;
	}

	/**
	 * 随机生成9位密码
	 * 
	 * @return
	 */
	public static String RandomPwd() {
		String num = "";
		String[] str = { "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a",
				"s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v",
				"b", "n", "m" };
		for (int i = 0; i < 3; i++) {
			int it1 = (int) (Math.random() * 25);
			int it2 = (int) (Math.random() * 25);
			int it3 = new Random().nextInt(10);
			num += str[it1] + str[it2].toUpperCase() + it3;
		}
		return num;
	}


	/**
	 * 首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstChar2Upper(String str) {
		if (null != str && str.length() > 0) {
			StringBuilder sb = new StringBuilder(str);
			sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
			str = sb.toString();
		}
		return str;
	}

	/**
	 * 判断字符串是否是int类型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(Object str) {
		if (null == str || str.toString().trim().length() == 0) {
			return true;
		}
		boolean result = false;
		Pattern pattern = Pattern.compile("-?[0-9]*");
		result = pattern.matcher(str.toString()).matches();
		return result;
	}

	/**
	 * 判断字符串是否是int类型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		if (null == str || str.toString().trim().length() == 0) {
			return true;
		}
		boolean result = false;
		Pattern pattern = Pattern.compile("-?[0-9]*");
		result = pattern.matcher(str.toString()).matches();
		return result;
	}

	/**
	 * 判断字符串是否是float类型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isFloat(String str) {
		if (null == str || str.trim().length() == 0) {
			return true;
		}
		boolean result = false;
		Pattern pattern = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
		result = pattern.matcher(str).matches();
		return result;
	}

	public static String toDouble(Object obj) {
		String de = null2String(obj);
		if (Util.isFloat(de)) {
			if (de != "") {
				DecimalFormat dfDecimalFormat = new DecimalFormat("#.00");
				return dfDecimalFormat.format(new Double(de));
			} else {
				return "";
			}
		}
		return "";
	}

	/**
	 * 金额转换为中文
	 * 
	 * @param obj
	 * @return
	 */
	private static String[] digit = { "", "拾", "佰", "仟", "万", "拾万", "佰万", "仟万",
			"亿", "拾亿", "佰亿", "仟亿", "万亿" };
	private static String[] bb = { "分", "角" };
	private static final String YUAN = "元";
	private static final String ZHENG = "整";

	public static String numberToChinese(Object obj) {
		String objs = null2String(obj);
		if (!isBlank(objs) && isFloat(objs)) {
			return getMoneyCDesc(new Double(objs));
		} else {
			return "";
		}
	}

	/**
	 * 取得数字对应的中文
	 * 
	 * @param money
	 * @return
	 */
	public static String getMoneyCDesc(double money) {
		BigDecimal b = new BigDecimal(String.valueOf(money));

		String strMoney = "" + b.setScale(2, BigDecimal.ROUND_UNNECESSARY);
		// System.out.println(strMoney);
		String[] amt = strMoney.split("\\.");
		strMoney = getYuan(amt[0]) + YUAN + getJiaoFen(amt[1]);
		return strMoney;
	}

	/**
	 * 得到分角部分
	 * 
	 * @param s
	 * @return
	 */
	public static String getJiaoFen(String s) {
		char[] c = s.toCharArray();
		int len = c.length;
		String ch = "";
		String d = "";
		for (int i = 0; i < c.length; i++) {
			if (i > 0 && c[i] == '0' && c[i] == c[i - 1]) {
				--len;
				continue;
			}
			// 得到数字对应的中文
			ch += (getChinese(c[i]));
			// 非零时, 显示是几百, 还是几千

			if (!getChinese(c[i]).equals("零")) {
				if (c.length == 2) {
					d = bb[--len];
				} else {
					d = bb[len];
				}
				ch += d;
			} else {
				--len; // 如果是0则不取位数
			}
		}
		// 如果最后一位是 0, 则去掉
		if ((ch.charAt(ch.length() - 1)) == '零') {
			ch = ch.substring(0, ch.length() - 1);
		}

		if (ch.indexOf("角") == -1 && ch.indexOf("分") == -1) {
			ch += ZHENG;
		}
		return ch;
	}

	/**
	 * 得到元的部分
	 * 
	 * @param s
	 * @return
	 */
	public static String getYuan(String s) {
		char[] c = s.toCharArray();
		StringBuffer chSb = new StringBuffer();
		int len = c.length;
		List<String> list = new ArrayList<String>();
		String d = "";
		for (int i = 0; i < c.length; i++) {
			// 如果有几个0挨在一起时, 只显示一个零即可
			if (i > 0 && c[i] == '0' && c[i] == c[i - 1]) {
				--len;
				continue;
			}
			// 得到数字对应的中文
			chSb.append(getChinese(c[i]));

			// 非零时, 显示是几百, 还是几千
			if (!getChinese(c[i]).equals("零")) {
				d = digit[--len];
				list.add(d);// 当数字中有万和十万时, 要去掉十万
				chSb.append(d);
			} else {
				--len; // 如果是0则不取位数
			}
		}
		String chStr = chSb.toString();
		// 如果同时包含有万和十万, 则将十万中的万去掉
		if (list.contains("万") && list.contains("拾万")) {
			chStr = chStr.replaceAll("拾万", "拾");
		}
		if (list.contains("万") && list.contains("佰万")) {
			chStr = chStr.replaceAll("佰万", "佰");
		}
		if (list.contains("万") && list.contains("仟万")) {
			chStr = chStr.replaceAll("仟万", "仟");
		}
		// 如果同时包含亿和十亿, 则将十亿中的亿字去掉
		if (list.contains("亿") && list.contains("拾亿")) {
			chStr = chStr.replaceAll("拾亿", "拾");
		}
		if (list.contains("亿") && list.contains("佰亿")) {
			chStr = chStr.replaceAll("佰亿", "佰");
		}
		if (list.contains("亿") && list.contains("仟亿")) {
			chStr = chStr.replaceAll("仟亿", "仟");
		}
		if (list.contains("亿") && list.contains("万亿")) {
			chStr = chStr.replaceAll("万亿", "万");
		}
		// 如果最后一位是 0, 则去掉
		if ((chSb.charAt(chSb.length() - 1)) == '零') {
			chStr = chStr.substring(0, chStr.length() - 1);
		}
		return chStr;
	}

	/**
	 * 取得数字对应的中文
	 * 
	 * @param i
	 * @return
	 */
	public static String getChinese(char i) {
		String ch = "";
		switch (i) {
		case '0':
			ch = "零";
			break;
		case '1':
			ch = "壹";
			break;
		case '2':
			ch = "贰";
			break;
		case '3':
			ch = "叁";
			break;
		case '4':
			ch = "肆";
			break;
		case '5':
			ch = "伍";
			break;
		case '6':
			ch = "陆";
			break;
		case '7':
			ch = "柒";
			break;
		case '8':
			ch = "捌";
			break;
		case '9':
			ch = "玖";
			break;
		}
		return ch;
	}

	/**
	 * 判断字符串是否未超出长度
	 * 
	 * @param str
	 * @param length
	 * @return 没超出：true,超出：false
	 */
	public static boolean isNoOverlength(String str, Integer length) {
		if (null == str || null == length) {
			return true;
		}
		if (getStrlength(str) > length) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 判断字符串是否是英文或者数字
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isLetter(char c) {
		int k = 0x80;
		return c / k == 0 ? true : false;
	}

	/**
	 * 获取字符串长度，一个中文算两个长度
	 * 
	 * @param s
	 * @return
	 */
	public static int getStrlength(String s) {
		if (s == null)
			return 0;
		char[] c = s.toCharArray();
		int len = 0;
		for (int i = 0; i < c.length; i++) {
			len++;
			if (!isLetter(c[i])) {
				len++;
			}
		}
		return len;
	}

	/**
	 * 千分位
	 * 
	 * @param text
	 *            值
	 * @param type
	 *            类型 1：浮点型，2：整型
	 * @return
	 */
	public static String fmtMicrometer(String text, int type) {
		if (text == null || text.trim().length() == 0)
			return "";
		DecimalFormat df = null;
		if (type == 2) {
			df = new DecimalFormat("###,##0");
		} else {
			df = new DecimalFormat("###,##0.00");
		}
		double number = 0.0;
		try {
			number = Double.parseDouble(text);
		} catch (Exception e) {
			number = 0.0;
		}
		return df.format(number);
	}
	
	/**根据格式转换数字
	 * @param text 值
	 * @param format 格式如：###,##0、###,##0.00
	 * @return
	 */
	public static String fmtMicrometer(String text,String format){
		if (text == null || text.trim().length() == 0||null==format||format.trim().length()==0)
			return "";
		 DecimalFormat	df = new DecimalFormat(format);
		BigDecimal number = BigDecimal.ZERO;
		try {
			number = new BigDecimal(text);
		} catch (Exception e) {
			number = BigDecimal.ZERO;
		}
		return df.format(number);
	}

	/**
	 * 根据key取值
	 * 
	 * @param key
	 * @param map
	 * @return
	 */
	public static String getKeyValue(String key, Map<String, Object> map) {
		try {
			String value = String.valueOf(map.get(key));
			if (isBlank(value)) {
				return "";
			}
			return value.trim();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 删除script标签和link标签
	 * 
	 * @param html
	 * @return
	 */
	public static String removeScriptAndLink(String html) {
		String new_html = html; // 含html标签的字符串
		Pattern p_script, p_link;
		Matcher m_script, m_link;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?(\\/>|>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>)";
			String regEx_link = "<[\\s]*?link[^>]*?(\\/>|>[\\s\\S]*?<[\\s]*?\\/[\\s]*?link[\\s]*?>)";
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(new_html);
			new_html = m_script.replaceAll(""); // 过滤script标签

			p_link = Pattern.compile(regEx_link, Pattern.CASE_INSENSITIVE);
			m_link = p_link.matcher(new_html);
			new_html = m_link.replaceAll(""); // 过滤link标签

		} catch (Exception e) {
			System.err.println("removeScriptAndLink: " + e.getMessage());
		}
		return new_html.replaceAll("<p>&nbsp;</p>", "");// 返回文本字符串

	}

	/**
	 * 获取指定位数的字符串，不足左侧补充字符
	 * 
	 * @param str
	 * @param size
	 * @param padChar
	 * @return
	 */
	public static String leftPad(String str, int size, char padChar) {
		return org.apache.commons.lang.StringUtils.leftPad(str, size, padChar);
	}

	/**
	 * 获取torder
	 * 
	 * @param SelShoworder
	 * @param parentTorder
	 * @param split
	 * @return
	 */
	public static String getTorder(Integer SelShoworder, String parentTorder,
			String split) {
		if (null == SelShoworder) {
			return "";
		}
		String selfTorder = leftPad(SelShoworder.toString(), 4, '0');
		if (null != parentTorder && parentTorder.length() > 0) {
			selfTorder = parentTorder + split + selfTorder;
		}
		return selfTorder;
	}

	/**
	 * 获取顶级域名
	 * 
	 * @param request
	 * @return
	 */
	public static String getTopLevelDomain(HttpServletRequest request) {
		String serverName = request.getServerName();
		String topLevelDomain = serverName.replaceAll(".*\\.(\\w+\\.\\w+)$",
				"$1");// 顶级域名
		return topLevelDomain;
	}

	/**
	 * 返回指定长度的日期域
	 * 
	 * @param 日期域
	 *            ，例如年、月、日
	 * @param 长度
	 * @return
	 */
	public static String add0(int paramInt1, int paramInt2) {
		// double l = Math.pow(10.0D, paramInt2);
		long l = (long) Math.pow(10D, paramInt2);
		return String.valueOf(l + paramInt1).substring(1);
	}

	/**
	 * 字符串转换为date类型,默认"yyyy-MM-dd"
	 * 
	 * @param paramString
	 * @return
	 */
	public static Date getDateValue(String paramString) {
		return Util.getDateValue(paramString, "yyyy-MM-dd");
	}

	/**
	 * 字符串转换为指定格式的date类型
	 * 
	 * @param dateString
	 * @param format
	 * @return
	 */
	public static Date getDateValue(String dateString, String format) {
		if (null == dateString || dateString.trim().length() < 1) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date newDate = null;
		try {
			newDate = dateFormat.parse(dateString);
		} catch (ParseException pe) {
			newDate = null;
		}
		return newDate;
	}

	/**
	 * 替换sql like所用参数
	 * 
	 * @param paramStr
	 * @return
	 */
	public static String transformLikeParam(String paramStr) {
		if (paramStr == null || paramStr.trim().equals("")) {
			return "";
		}
		String escapeChar = "\\";
		paramStr = Util.transformLikeSql(paramStr, "\\", escapeChar,
				paramStr.indexOf("\\"));
		paramStr = Util.transformLikeSql(paramStr, "%", escapeChar,
				paramStr.indexOf("%"));
		paramStr = Util.transformLikeSql(paramStr, "_", escapeChar,
				paramStr.indexOf("_"));
		paramStr = Util.transformLikeSql(paramStr, "'", escapeChar,
				paramStr.indexOf("'"));

		return paramStr;
	}

	/**
	 * sql字符替换
	 * 
	 * @param likeSql
	 * @param transChar
	 * @param escapeChar
	 * @param beginindex
	 * @return
	 */
	public static String transformLikeSql(String likeSql, String transChar,
			String escapeChar, int beginindex) {
		if (beginindex > -1) {
			likeSql = likeSql.substring(0, beginindex) + escapeChar
					+ likeSql.substring(beginindex, likeSql.length());
			String tempString = likeSql.substring(beginindex + 2,
					likeSql.length());
			int tempindex = tempString.indexOf(transChar);
			if (tempindex == -1) {
				tempindex = 0;
			}
			if (tempString.equals("")) {
				return likeSql;
			}
			likeSql = transformLikeSql(likeSql, transChar, escapeChar,
					tempindex + beginindex + 2);
		}
		return likeSql;
	}

	/**
	 * 取网站一级域名
	 * 
	 * @param requestURI
	 * @return
	 */
	public static String getDomain(String requestURI) {
		return requestURI.replaceAll(".*\\.(\\w+\\.\\w+)$", "$1");
	}

	/**
	 * 取网站二级域名
	 * 
	 * @param requestURI
	 * @return
	 */
	public static String getSecondDomain(String requestURI) {
		return requestURI.replaceAll(".*\\.(\\w+\\.\\w+\\.\\w+)$", "$1");
	}

	/**
	 * 取网站一级域名
	 * 
	 * @param request
	 * @return
	 */
	public static String getDomain(HttpServletRequest request) {
		String serverName = request.getServerName();
		if (isBlank(serverName)) {
			return "";
		}
		return getDomain(serverName);
	}

	/**
	 * 取网站二级域名
	 * 
	 * @param request
	 * @return
	 */
	public static String getSecondDomain(HttpServletRequest request) {
		String serverName = request.getServerName();
		if (isBlank(serverName)) {
			return "";
		}
		return getSecondDomain(serverName);
	}

	/**
	 * 取number位随即密码
	 * 
	 * @param number
	 * @return
	 */
	public static String getRandomPassWord(int number) {
		return RandomStringUtils.randomAlphanumeric(number).toLowerCase();
	}

	/**
	 * 替换掉不需要的 页面传来的\r\n
	 * 
	 * @decription
	 * @author shangwenyu
	 * @time 2014-11-7 下午4:17:57
	 * @param string
	 * @return
	 */
	public static String replaceRN(String string) {
		if (!Util.isBlank(string)) {
			string = string.replace("\r", "").replace("\n", "");
		}
		return string;
	}



	/**
	 * 剔除字符串中的全角半角空格
	 * 
	 * @param str
	 * @return
	 */
	public static String strTrim(String str) {
	    if(null!=str && !"".equals(str)){  
	    	str = str.replaceAll("^[	*|　*| *| *|\\s*]*", "").replaceAll("[	*|　*| *| *|\\s*]*$", "");  
	    }  
	    return str;  
	}

	/**
	 * 截取带中文的字符串
	 * 
	 * @param str
	 * @param num
	 * @return
	 */
	public static String subStrByChinese(String str, int num) throws Exception {
		if (Util.isBlank(str)) {
			return "";
		}
		int sum = 0;
		int length = str.getBytes("GBK").length;

		if (length > num) {
			StringBuilder sb = new StringBuilder(num);
			for (int i = 0; i < str.length(); i++) {
				int c = str.charAt(i);
				if ((c & 0xff00) != 0)
					sum += 2;
				else
					sum += 1;
				if (sum <= num)
					sb.append((char) c);
				else
					break;
			}
			return sb.toString();
		}
		return str;
	}

	public static boolean equals(Object obj1, Object obj2) {
		if (obj1 == obj2)
			return true;
		try {
			if (obj1 == null) {
				obj1 = "";
			}
			if (obj2 == null) {
				obj2 = "";
			}
			return obj1.equals(obj2);
		} catch (Exception e) {
			return false;
		}
	}
	/**验证手机号是否正确
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles){  
		  
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  
		  
		Matcher m = p.matcher(mobiles);  
		  
		return m.matches();  
		  
   }  
	/**
	 * @方法名称: pd
	 * @功能描述: 去空
	 * @作者:田伟勋
	 * @创建时间:2016-1-20 下午8:06:44
	 * @param content
	 * @return String   
	 */
	 
	public static String pd(Object content){
		if(content==null){
			return "";
		}else{
			return content.toString();
		}
	}
	public static String changeIdToBarcode(Long id,Integer count){
		int c=count-id.toString().length();
	    String s="";
		for(int i=0; i<c;i++){
			s+="0";
		}
		return s+id.toString();
	}
	
	
	public static String getFourNo(int i){
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(4);
        //设置最小整数位数    
        nf.setMinimumIntegerDigits(4);
        //输出测试语句
        return nf.format(i);
	}
	 /**
	 * 系统返回平台，会话超时跳转那个服务器
	 */
	 
	public static String loginUrl="/OA/";

}
