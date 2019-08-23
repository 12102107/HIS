
package com.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 
 * @类名称: XmlUtil
 * @类描述:
 * @作者:吕航
 * @创建时间:2016-1-27 下午2:08:49
 */
public class XmlUtil {

	/**
	 * @方法名称: main
	 * @功能描述: 
	 * @作者:吕航
	 * @创建时间:2016-1-27 下午1:05:58
	 * @param args void   
	 */

	public static void main(String[] args) {

		// 例子
		//map中的key存储数据库表字段列名，map中的value存储数据库字段对应的数据
		//行级数据（数据库查询每一行数据拼接）
		//两行数据
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> maprow1 = new HashMap<String, String>();
		maprow1.put("CNUM", "102");
		maprow1.put("BRNAME", "白东旭");
		Map<String,String> maprow2 = new HashMap<String, String>();
		maprow2.put("CNUM", "103");
		maprow2 .put("BRNAME", "白东旭1");
		list.add(maprow1);
		list.add(maprow2);
		//普通参数，map中的key是值与打印文件中的参数名称一致，map中的value是可以是从页面活session中获取的
		List<Map<String,String>> params = new ArrayList<Map<String,String>>();
		Map<String,String> param1 = new HashMap<String, String>();
		param1.put("PARENTER", "printer1");
		params.add(param1);

	}
	
	/**
	 * 
	 * @方法名称: xmlAssemble
	 * @功能描述: 组装报表模板所需的xml
	 * @作者:吕航
	 * @创建时间:2016-1-27 下午2:20:52
	 * @param list
	 * @return String
	 */
	public static String xmlAssemble(List<Map<String,Object>> rowList, List<Map<String,Object>> params) {
		StringBuffer xml = new StringBuffer();
			xml.append("<report>\n");
		if(rowList != null) {
			xml.append("<xml>\n");
			for(Map<String, Object> map : rowList) {
				//组装报表行级内容
				xmlAssembleItem(map, xml);
			}
			xml.append("</xml>\n");
		}
			xml.append(xmlAssembleParam(params));
			xml.append("</report>");
		return xml.toString();
	}
	
	/**
	 * 
	 * @方法名称: xmlAssembleParam
	 * @功能描述: 组装报表参数内容
	 * @作者:吕航
	 * @创建时间:2016-1-27 下午3:53:31
	 * @param params
	 * @return String
	 */
	public static String xmlAssembleParam(List<Map<String,Object>> params) {
		StringBuffer param = new StringBuffer();
		if(params != null) {
			param.append("<_grparam>");
			for(Map<String, Object> map : params) {
				
				Set<String> set = map.keySet();
				String key = "";
				//组装报表参数内容
				for(Iterator<String> it = set.iterator();it.hasNext();) {
					key = it.next();
					param.append("<").append(key).append(">").append(map.get(key)).append("</").append(key).append(">");
				}
				
			}
			param.append("</_grparam>\n");
		}
		
		return param.toString();
	}
	
	/**
	 * 
	 * @方法名称: xmlAssembleItem
	 * @功能描述: 组装报表行级内容
	 * @作者:吕航
	 * @创建时间:2016-1-27 下午2:20:56
	 * @param map
	 * @param xml void
	 */
	public static void xmlAssembleItem(Map<String, Object> map, StringBuffer xml) {
		if(map != null) {
			Set<String> set = map.keySet();
			String key = "";
			xml.append("<row>");
			for(Iterator<String> it = set.iterator();it.hasNext();) {
				 key = it.next();
				 xml.append("<").append(key).append(">").append(map.get(key)).append("</").append(key).append(">");
			}
			xml.append("</row>\n");
		}
	}

	/**
	 * 
	 * @方法名称: objToStr
	 * @功能描述: 对象转字符串
	 * @作者:李连超
	 * @创建时间:2016-2-2 下午2:43:04
	 * @param obj 对象
	 * @return String 
	 */
	public static String objToStr(Object obj) {
		if(obj != null && !"null".equals(obj))
			return obj.toString();
		return "";
	}
}

