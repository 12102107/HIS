package com.common.util;

import java.util.Collection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonUtils {

	private JsonUtils() {
		super();
	}

	/**
	 * 将一个JAVA对象转换成JSON格式的字符串
	 * 
	 * @param target
	 *            转换的目标对象
	 * @return
	 */
	public static String toJSON(final Object target) {
		return toJSON(target, null, null);
	}

	/**
	 * 将一个JAVA对象转换成JSON格式的字符串
	 * 
	 * @param target
	 *            转换的目标对象
	 * @param datePattern
	 *            转换使用的日期格式
	 * @return
	 */
	public static String toJSON(final Object target, final String datePattern) {
		return toJSON(target, null, datePattern);
	}

	/**
	 * 将一个JAVA对象转换成JSON格式的字符串
	 * 
	 * @param target
	 *            转换的目标对象
	 * @param excludes
	 *            转换排除的属性列表
	 * @return
	 */
	public static String toJSON(final Object target, final String[] excludes) {
		return toJSON(target, excludes, null);
	}

	/**
	 * 将一个JAVA对象转换成JSON格式的字符串
	 * 
	 * @param target
	 *            转换的目标对象
	 * @param excludes
	 *            转换排除的属性列表 *
	 * @param datePattern
	 *            转换使用的日期格式
	 * @return
	 */
	public static String toJSON(final Object target, final String[] excludes,
			final String datePattern) {
		if (null == target) {
			return "null";
		}

		JsonConfig config = new JsonConfig();
		if (null != excludes && 0 != excludes.length) {// 排除指定的属性
			config.setExcludes(excludes);
		}

		if (null != datePattern && !datePattern.trim().equals("")) {
			/*
			 * 注册java.util.Date的转换器，而转换器实际上是一个实现了JsonValueProcessor接口
			 * 的匿名内部类，其中的processObjectValue方法用于将java.util.Date类型的属性转换成 JSON字符串
			 */
			config.registerJsonValueProcessor(java.util.Date.class,
					new JsonValueProcessor() {
						public Object processArrayValue(Object obj,
								JsonConfig jsonconfig) {
							return this.process(obj);
						}

						// 此方法将java.util.Date类型的属性转换成 JSON字符串
						public Object processObjectValue(String s, Object obj,
								JsonConfig jsonconfig) {
							return this.process(obj);
						}

						private String process(Object obj) {
							if (null == obj) {// 时间为null返回"";
								return "";
							}
							java.util.Date date = (java.util.Date) obj;
							java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
									datePattern.trim());
							return format.format(date);
						}
					});
		}

		String json = null;
		if (target instanceof Collection || target instanceof Object[]) {// 数组、List、Set的转换
			JSONArray jsonArray = JSONArray.fromObject(target, config);
			json = jsonArray.toString();
		} else {// Map、Bean的转换
			JSONObject jsonObject = JSONObject.fromObject(target, config);
			json = jsonObject.toString();
		}
		return json;
	}
}
