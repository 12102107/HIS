package com.common.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.e;

import org.apache.commons.collections.map.ListOrderedMap;
import org.hibernate.Criteria;
import org.hibernate.Query;

import com.common.util.Page;


/**
 * <b> GenericDAO 类使用注释</b>
 * <p>
 * GenericDAO 使用例子 :
 * <ul>
 * <li>exemple ： TODO</li>
 * <li>exemple ： TODO</li>
 * <li>exemple ： TODO</li>
 * </ul>
 * </p>
 * 
 * @version 0.0.0.1
 * 
 */
@SuppressWarnings("unchecked")
public interface GenericDAO<T, PK extends Serializable> {

	/**
	 * Generic method used to get all objects of a particular type. This is the
	 * same as lookup up all rows in a table.
	 * 
	 * @return List of populated objects
	 */
	List<T> getAll();

	/**
	 * 
	 * getAll方法
	 * 
	 * <p>
	 * getAll方法描述
	 * </p>
	 * 
	 * @param orderBy
	 * @param isAsc
	 * @return
	 * @since 0.0.0.0
	 */
	List<T> getAll(String orderBy, boolean isAsc);

	/**
	 * Generic method to get an object based on class and identifier. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to get
	 * @return a populated object
	 * @see org.springframework.orm.ObjectRetrievalFailureException
	 */
	T get(PK id);

	/**
	 * Checks for existence of an object of type T using the id arg.
	 * 
	 * @param id
	 *            the id of the entity
	 * @return - true if it exists, false if it doesn't
	 */
	boolean exists(PK id);

	/**
	 * Generic method to save an object - handles both update and insert.
	 * 
	 * @param object
	 *            the object to save
	 * @return the persisted object
	 */
	T save(T object);

	/**
	 * Generic method to delete an object based on class and id
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to remove
	 */
	void remove(PK id);

	/**
	 * 
	 * remove方法
	 * 
	 * <p>
	 * remove方法描述
	 * </p>
	 * 
	 * @param object
	 * @since 0.0.0.0
	 */
	void remove(T object);

	/**
	 * 
	 * findByHQLWithPage方法
	 * 
	 * <p>
	 * findByHQLWithPage方法描述
	 * </p>
	 * 
	 * @param hql
	 * @param args
	 *            条件参数，key=参数名，Value=数的值
	 * @param pageNo
	 *            如果为-1，从头开始
	 * @param pageSize
	 *            如果为-1，从开始处到结束
	 * @return
	 * @since 0.0.0.0
	 */
	Page findByHQLWithPage(String hql, Map<String, Object> args, int pageNo,
			int pageSize);

	/**
	 * 
	 * findByHQLWithPage方法
	 * 
	 * <p>
	 * findByHQLWithPage方法描述
	 * </p>
	 * 
	 * @param criteria
	 * @param pageNo
	 *            如果为-1，从头开始
	 * @param pageSize
	 *            如果为-1，从开始处到结束
	 * @return
	 * @since 0.0.0.0
	 */
	Page findByHQLWithPage(Criteria criteria, int pageNo, int pageSize);

	/**
	 * 
	 * countByHql方法
	 * 
	 * <p>
	 * countByHql方法描述
	 * </p>
	 * 
	 * @param hql
	 * @param parameterMap
	 * @return
	 * @since 0.0.0.0
	 */
	int countByHql(final String hql, final Map<String, Object> parameterMap);
	/**
	 * 以SQL方式查询
	 * @param hql
	 * @param parameterMap
	 * @return
	 */
	int countByHqlOfSQL(final String hql, final Map<String, Object> parameterMap);

	/**
	 * 
	 * setQueryParameters方法
	 * 
	 * <p>
	 * setQueryParameters方法描述
	 * </p>
	 * 
	 * @param hql
	 * @param parameterMap
	 * @return
	 * @since 0.0.0.0
	 */
	Query setQueryParameters(String hql, Map<String, Object> parameterMap);
	/**
	 * 
	 * setQueryParametersOfSQL方法
	 * 
	 * <p>
	 * sql查询
	 * </p>
	 * 
	 * @param hql
	 * @param parameterMap
	 * @return
	 * @since 0.0.0.0
	 */
	Query setQueryParametersOfSQL(String queryString, Map<String, Object> parameterMap);
	
	 /**
	 * @方法名称: setQueryParametersOfSQL
	 * @功能描述: 原生SQL查询
	 * @作者:慕金剑
	 * @创建时间:2015-12-7 下午5:46:39
	 * @param queryString sql语句
	 * @param parameterMap 参数
	 * @param t  返回类型
	 * @return Query   
	 */
	 
	Query setQueryParametersOfSQL(String queryString, Map<String, Object> parameterMap,Class<T> t);
	/**
	 * 
	 * flush方法
	 * 
	 * <p>
	 * 提交session中对象
	 * </p>
	 * 
	 * @since 0.0.0.0
	 */
	public void flush();

	/**
	 * 
	 * clear方法
	 * 
	 * <p>
	 * 清空session
	 * </p>
	 * 
	 * @since 0.0.0.0
	 */
	public void clear();

	
	/**
	 * 
	 * @方法名称: findBySql
	 * @功能描述:执行原生sql查询
	 * @作者:刘强
	 * @创建时间:2015-12-30 下午3:24:31
	 * @param sql
	 * @param parameterMap
	 * @return
	 * @see com.common.dao.GenericDAO#findBySql(java.lang.String, java.util.Map)
	 */
	public List findBySql(final String sql,Map<String, Object> parameterMap);
	
	
	/**
	 * 
	 * @方法名称: findByHql
	 * @功能描述: 执行sql语句返回list集合
	 * @作者:魏兆鹏
	 * @创建时间:2015-12-23 下午2:16:39
	 * @param hql
	 * @param ob
	 * @return Page
	 */
	public Page findByHql(String hql,Object[]ob);

}
