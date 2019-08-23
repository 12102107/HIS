
package com.common.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** 
 * @类名称: IRedisUtil
 * @类描述: Redis库DDl操作工具类 
 * 注意: 保存到Redis库的数据一定要保持 key值唯一 否则会覆盖原有存在的key 类似Map对象的操作
 * kEY值不要太长 512K以内为限制
 * @作者:于文涛
 * @创建时间:2016-2-26 下午6:21:16
 */
public interface IRedisUtil {
	/**
	 * @方法名称: set
	 * @功能描述: 添加字符串数据 
	 * @作者:于文涛
	 * @创建时间:2016-2-26 下午7:57:59
	 * @param system 选择数据库标识
	 * @param key 唯一主键
	 * @param value 值
	 * @return String 成功返回OK 失败返回Null
	 */
	public String set( String system, String key, String value);

	/**
	 * 
	 * @方法名称: setObject
	 * @功能描述: 添加对象
	 * @作者:于文涛
	 * @创建时间:2016-2-26 下午7:58:57
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @param value 值
	 * @return String 成功返回OK 失败返回Null
	 */
	public String setObject(String system,String key,Object value);
	/**
	 * 
	 * @方法名称: setObject
	 * @功能描述: 添加Set集合
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:21:43
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @param value 值
	 * @return String 成功返回OK 失败返回Null
	 */
	public String setObject(String system,String key, Set<? extends Serializable> value);
	/**
	 * @方法名称: setObject
	 * @功能描述: 添加map集合
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:22:09
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @param value 值
	 * @return String 成功返回OK 失败返回Null
	 */
	public String setObject(String system,String key, Map<?, ? extends Serializable> value);
	/**
	 * @方法名称: setObject
	 * @功能描述: 添加List集合
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:22:09
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @param value 值
	 * @return String 成功返回OK 失败返回Null
	 */
	public String setObject(String system,String key, List<? extends Serializable> value);
	/**
	 * @方法名称: setObject
	 * @功能描述: 添加可持久化对象
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:22:09
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @param value 值
	 * @return String 成功返回OK 失败返回Null
	 */
	public String setObject(String system,String key,Serializable value) ;
	/**
	 * @方法名称: delete
	 * @功能描述: 删除数据
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:23:17
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @return Long
	 */
	public Long delete( String system,String key);
	/**
	 * @方法名称: get
	 * @功能描述: 获取对应key的值
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:23:53
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @return String
	 */
	public String get( String system, String key);
	/**
	 * @方法名称: getObject
	 * @功能描述: 获取对应key的值(对象)
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:24:42
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @return Object
	 */
	public Object getObject(String system,String key) ;
	/**
	 * @方法名称: exists
	 * @功能描述: 查看key值是否存在
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:25:17
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @return boolean
	 */
	public boolean exists(String system,String key);
	/**
	 * @方法名称: expire
	 * @功能描述: 为对应key设置超时时间
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:25:58
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @param seconds 秒
	 * @return Long
	 */
	public Long expire(String system,String key, int seconds);
	/**
	 * @方法名称: ttl
	 * @功能描述: 获取对应key剩余超时清除时间
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:26:35
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @return Long
	 */
	public Long ttl(String system,String key);
	/**
	 * @方法名称: type
	 * @功能描述: 获取对应key在redis保存的类型 
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:27:14
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键
	 * @return String
	 * 返回值:none - key不存在
	 * 		string - 字符串
	 * 		list - 列表
	 * 		set - 集合
	 * 		zset - 有序集
	 * 		hash - 哈希表
	 */
	public String type(String system,String key);
	
	 /**
	 * @方法名称: hset
	 * @功能描述: redis直接操作map put值
	 * @作者:慕金剑
	 * @创建时间:2016-4-8 下午3:44:08
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key   唯一主键
	 * @param field map中key
	 * @param value map中value
	 * @return Long   
	 */
	 
	public Long hset(String system,String key,String field,String value);
	
	
	 /**
	 * @方法名称: hdel
	 * @功能描述: redis直接操作map remove值
	 * @作者:慕金剑
	 * @创建时间:2016-4-8 下午3:45:04
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key  唯一主键 
	 * @param field map中key
	 * @return Long   
	 */
	 
	public Long hdel(String system,String key,String field);
	
	 /**
	 * @方法名称: hgetAll
	 * @功能描述: redis 得到所有map数据
	 * @作者:慕金剑
	 * @创建时间:2016-4-8 下午3:45:55
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key  唯一主键 
	 * @return Map<String,String>   
	 */
	 
	public Map<String, String> hgetAll(String system,String key);
	
	 /**
	 * @方法名称: hget
	 * @功能描述: redis根据map中key获取值
	 * @作者:慕金剑
	 * @创建时间:2016-4-8 下午3:46:31
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key  唯一主键 
	 * @param field map中key
	 * @return String   
	 */
	 
	public String hget(String system,String key,String field);
	
	 /**
	 * @方法名称: hmset
	 * @功能描述: redis直接放入map类型数据
	 * @作者:慕金剑
	 * @创建时间:2016-4-8 下午3:47:52
	 * @param system 选择数据库标识  跟据该值选取  oa库 service(业务)库
	 * @param key 唯一主键 
	 * @param map 存储的map
	 * @return String   
	 */
	 
	public String hmset(String system,String key,Map<String, String> map);
	
}

