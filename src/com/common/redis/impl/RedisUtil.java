package com.common.redis.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.common.redis.IRedisUtil;
import com.common.redis.RedisKeys;

/** 
 * @类名称: RedisUtil
 * @类描述: Redis库DDl操作工具类 
 * 注意: 保存到Redis库的数据一定要保持 key值唯一 否则会覆盖原有存在的key 类似Map对象的操作
 * kEY值不要太长 512K以内为限制
 * @作者:于文涛
 * @创建时间:2016-2-26 下午6:21:16
 */
public class RedisUtil implements IRedisUtil{

	/**
	 * 宕机处理(容灾处理)库,暂不提供服务
	 */
	private ShardedJedisPool shardedJedisPool;
	/**
	 * 为提高扩展性，以后会有多个redis服务，此Map中key为redis服务分别为oa,service;value为对应的redis池
	 */
	private Map<String,ShardedJedisPool> shardedJedisPoolMap;

	/**
	 * @方法名称: set
	 * @功能描述: 添加字符串数据 
	 * @作者:于文涛
	 * @创建时间:2016-2-26 下午7:57:59
	 * @param system 选择数据库标识 目前仅用RedisKeys.SYSOA
	 * @param key 唯一主键
	 * @param value 值
	 * @return String 成功返回OK 失败返回Null
	 * @see com.common.redis.IRedisUtil#set(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String set(String system,String key,String value) {
		ShardedJedis shardedJedis = getShardedJedis(system);
		String result = null;
		try {
			result = shardedJedis.set(key,value);
			return result;
		} catch (Exception e2) {
			returnBrokenResource(shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(system,shardedJedis);
		}
		return result;
	}

	/**
	 * @方法名称: delete
	 * @功能描述: 删除单个数据
	 * @作者:于文涛
	 * @创建时间:2016-1-4 下午2:01:42
	 * @param key void
	 * @throws Exception 
	 */
	public Long delete(String system,String key){
		ShardedJedis shardedJedis = getShardedJedis(system);
		long count = shardedJedis.del(key);
		returnResource(key,shardedJedis);
		return count;
	}

	/**
	 * @方法名称: get
	 * @功能描述: 获取值
	 * @作者:于文涛
	 * @创建时间:2016-1-4 下午2:04:39
	 * @param keyId
	 * @return String
	 * @throws Exception 
	 */
	public String get( String system, String key){
		ShardedJedis shardedJedis = getShardedJedis(system);
		String result = null;
		try {
			result = shardedJedis.get(key);
			return result;
		} catch (Exception e2) {
			returnBrokenResource( shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(key,shardedJedis);
		}
		return result;
	}

	/**
	 * @方法名称: setObject
	 * @功能描述:
	 * 		存一个对象
	 * 		如果key已经存在 覆盖原值
	 * 		成功返回 OK
	 * 		失败返回 null
	 * @作者:于文涛
	 * @创建时间:2016-2-26 下午7:20:14
	 * @param system
	 * @param key
	 * @param value
	 * @return
	 * @see com.common.redis.IRedisUtil#setObject(java.lang.String, java.lang.String, java.lang.Object)
	 */
	public String setObject(String system,String key, Object value) {
		return setObjectImpl(system,key, value);
	}

	/**
	 * 存一个对象
	 * 如果key已经存在 覆盖原值
	 * 成功返回 OK
	 * 失败返回 null
	 */
	public String setObject(String system,String key, Serializable value) {
		return setObjectImpl(system,key, value);
	}

	/**
	 * 存一个List 对象
	 * 如果key已经存在 覆盖原值
	 * 成功返回 OK
	 * 失败返回 null
	 */
	public String setObject(String system,String key, List<? extends Serializable> value) {
		return setObjectImpl( system,key, value);
	}

	/**
	 * 存一个Map对象
	 * 如果key已经存在 覆盖原值
	 * 成功返回 OK
	 * 失败返回 null
	 */
	public String setObject(String system,String key, Map<?, ? extends Serializable> value) {
		return setObjectImpl(system,key, value);
	}
	/**
	 * 存一个Set集合
	 * 如果key已经存在 覆盖原值
	 * 成功返回 OK
	 * 失败返回 null
	 */
	public String setObject(String system,String key, Set<? extends Serializable> value) {
		return setObjectImpl(system,key, value);
	}

	/**
	 * @方法名称: setObjectImpl
	 * @功能描述: 存储对象
	 * @作者:于文涛
	 * @创建时间:2016-2-26 下午7:24:36
	 * @param system
	 * @param key
	 * @param value
	 * @return String  成功返回OK 失败返回null
	 */
	private String setObjectImpl(String system,String key, Object value){
		ShardedJedis shardedJedis = getShardedJedis(system);
		try {
			byte[] byteArray = objectToByte(value);
			String setObjectRet = shardedJedis.set(key.getBytes(), byteArray);
			return setObjectRet;
		} catch (Exception e) {
			returnBrokenResource(shardedJedis);
			e.printStackTrace();
		}finally{
			returnResource(key,shardedJedis);
		}
		return null;
	}

	/*************取对象****************/
	/**
	 * @方法名称: getObject
	 * @功能描述: 获取对象
	 * @作者:于文涛
	 * @创建时间:2016-2-26 下午7:25:57
	 * @param system
	 * @param key
	 * @return Object 存在返回对象 异常返回null
	 */
	public Object getObject(String system,String key) {
		ShardedJedis shardedJedis = getShardedJedis(system);
		try {
			byte[] bs = shardedJedis.get(key.getBytes());
			Object obj = byteToObject(bs);
			return obj;
		} catch (Exception e2) {
			returnBrokenResource(shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(key,shardedJedis);
		}
		return null;
	}

	/**
	 * 判断key是不是已经存在
	 * @param key
	 * 存在 返回true
	 * 否则 返回false
	 */
	public boolean exists(String system,String key) {
		ShardedJedis shardedJedis = getShardedJedis(system);
		boolean result = false;
		try {
			result = shardedJedis.exists(key.getBytes());
			return result;
		} catch (Exception e2) {
			returnBrokenResource(shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(key,shardedJedis);
		}
		return result;
	}

	/**
	 * Long expire(String key,int seconds);
	 * 给指定的key设置生存时间 以秒为单位 当key过期时，会被自动删除
	 * 如果key不存在 返回0
	 * 设置成功返回1
	 * 过期时间的延迟在1秒钟之内，也就是，就算key已经过期，但它还是可能在1秒之内被访问到
	 */
	public Long expire(String system,String key, int seconds) {
		ShardedJedis shardedJedis = getShardedJedis(system);
		long result = 0;
		try {
			result = shardedJedis.expire(key.getBytes(), seconds);
			return result;
		} catch (Exception e2) {
			returnBrokenResource(shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(key,shardedJedis);
		}
		return result;
	}

	/**
	 * Long ttl(String key);
	 * 以秒为单位，返回给定 key 的剩余生存时间。
	 * 当 key 不存在或没有设置生存时间时，返回 -1 。
	 * 否则，返回 key 的剩余生存时间(以秒为单位)。
	 */
	public Long ttl(String system,String key) {
		ShardedJedis shardedJedis = getShardedJedis(system);
		long result = 0;
		try {
			result = shardedJedis.ttl(key.getBytes());
			return result;
		} catch (Exception e2) {
			returnBrokenResource( shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(key,shardedJedis);
		}
		return result;
	}

	/**
	 * TYPE
	 * public String type(String key)
	 * 描述：返回key所对应的value的类型。
	 * 返回值：none - key不存在
	 * 		string - 字符串
	 * 		list - 列表
	 * 		set - 集合
	 * 		zset - 有序集
	 * 		hash - 哈希表
	 */
	public String type(String system,String key) {
		ShardedJedis shardedJedis = getShardedJedis(system);
		String result = null;
		try {
			result = shardedJedis.type(key.getBytes());
			return result;
		} catch (Exception e2) {
			returnBrokenResource(shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(key,shardedJedis);
		}
		return result;
	}
	/**
	 * @方法名称: getShardedJedis
	 * @功能描述: 获取Jedis连接 目前仅用OA库即可,暂不考虑分库
	 * @作者:于文涛
	 * @创建时间:2016-2-26 下午8:06:20
	 * @param system
	 * @return ShardedJedis
	 */
	private  ShardedJedis  getShardedJedis(String system) {
		ShardedJedisPool pool=null;
		try{
			pool = shardedJedisPoolMap.get(RedisKeys.SYSOA);
		}catch(Exception e){
			return shardedJedisPool.getResource();    //发生异常时,由shardedJedisPool库提供
		}
		if(pool!=null){
			return pool.getResource();
		}else{
			return shardedJedisPool.getResource();   //如果某一台存放数据的redis服务宕机，有shardedJedisPool提供临时提供服务
		}
	}

	/**
	 * @方法名称: returnResource
	 * @功能描述: 释放资源
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:54:11
	 * @param system
	 * @param shardedJedis void
	 */
	private void returnResource(String system,ShardedJedis shardedJedis){
		shardedJedisPool.returnResource(shardedJedis);
	}
	/**
	 * @方法名称: returnBrokenResource
	 * @功能描述: 释放不可用的资源
	 * @作者:于文涛
	 * @创建时间:2016-2-29 上午9:54:17
	 * @param shardedJedis void
	 */
	private void returnBrokenResource(ShardedJedis shardedJedis){
		shardedJedisPool.returnBrokenResource(shardedJedis);
	}

	/**
	 * @方法名称: objectToByte
	 * @功能描述: 对象序列化
	 * @作者:于文涛
	 * @创建时间:2016-2-26 下午6:36:28
	 * @param obj
	 * @return byte[]
	 */
	protected byte[] objectToByte(Object obj) {
		byte[] bs=null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			bs =  bos.toByteArray();
			oos.close();
			bos.close();
			return bs;
		} catch (IOException e) {

			e.printStackTrace();
		}
		return bs;
	}
	/**
	 * @方法名称: byteToObject
	 * @功能描述: 对象反序列化
	 * @作者:于文涛
	 * @创建时间:2016-2-26 下午6:36:39
	 * @param bs
	 * @return Object
	 */
	protected Object byteToObject(byte[]  bs){
		Object obj = null;
		try{
			if(bs != null){
				ByteArrayInputStream bis = new ByteArrayInputStream(bs);
				ObjectInputStream inputStream = new ObjectInputStream(bis);
				obj = inputStream.readObject();
				//inputStream.close();
				//bis.close();
			}
			return obj;
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
		return obj;
	}
	
	@Override
	public Long hset(String system, String key, String field,String value) {
		ShardedJedis shardedJedis = getShardedJedis(system);
		Long result= null ;
		try {
			result = shardedJedis.hset(key, field, value);
			return result;
		} catch (Exception e2) {
			returnBrokenResource(shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(system,shardedJedis);
		}
		return result;
	}
	
	@Override
	public Long hdel(String system, String key, String field) {
		
		ShardedJedis shardedJedis = getShardedJedis(system);
		Long result= null ;
		try {
			result = shardedJedis.hdel(key, field);
			return result;
		} catch (Exception e2) {
			returnBrokenResource(shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(system,shardedJedis);
		}
		return result;
	}
	
	@Override
	public Map<String, String> hgetAll(String system, String key) {
		
		ShardedJedis shardedJedis = getShardedJedis(system);
		Map<String, String> result= null ;
		try {
			result = shardedJedis.hgetAll(key);
			return result;
		} catch (Exception e2) {
			returnBrokenResource(shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(system,shardedJedis);
		}
		return result;
	}

	@Override
	public String hget(String system, String key, String field) {
		
		ShardedJedis shardedJedis = getShardedJedis(system);
		String result= null ;
		try {
			result = shardedJedis.hget(key, field);
			return result;
		} catch (Exception e2) {
			returnBrokenResource(shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(system,shardedJedis);
		}
		return result;
	}
	
	@Override
	public String hmset(String system, String key, Map<String, String> map) {
		ShardedJedis shardedJedis = getShardedJedis(system);
		String result= null ;
		try {
			result = shardedJedis.hmset(key, map);
			return result;
		} catch (Exception e2) {
			returnBrokenResource(shardedJedis);
			e2.printStackTrace();
		}finally{
			returnResource(system,shardedJedis);
		}
		return result;
		
	}

	public void setShardedJedisPoolMap(
			Map<String, ShardedJedisPool> shardedJedisPoolMap) {
		this.shardedJedisPoolMap = shardedJedisPoolMap;
	}

	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}

}

