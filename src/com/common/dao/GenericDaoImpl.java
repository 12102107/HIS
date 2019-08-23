package com.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import com.common.util.Page;

/**
 * <b> GenericDaoHibernate 类使用注释:CRUD实现基类，在applicationContext.xml中定义名为：
 * sessionFactoryProject的SessionFactory 实例，采用annotation自动注入机制。</b>
 * <p>
 * GenericDaoHibernate 使用例子 :
 * <ul>
 * <li>exemple ： TODO</li>
 * <li>exemple ： TODO</li>
 * <li>exemple ： TODO</li>
 * </ul>
 * </p>
 * 
 * @version 1.0.0.0
 * 
 */
@SuppressWarnings("unchecked")
public class GenericDaoImpl<T, PK extends Serializable> extends
		HibernateDaoSupport implements GenericDAO<T, PK> {
	public final Log log = LogFactory.getLog(getClass());

	private SessionFactory sessionFactoryProject;

	private Class<T> persistentClass;

	/**
	 * 构造方法 GenericDaoHibernate
	 * 
	 * <p>
	 * 取得T对象类型
	 * </p>
	 * 
	 */
	public GenericDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Overriding methods exists
	 * 
	 * @see com.wonders.wxyz.base.dao.GenericDAO#exists(java.io.Serializable)
	 */
	public boolean exists(PK id) {
		Assert.notNull(id);
		return false;
	}

	/**
	 * Overriding methods get
	 * 
	 * @see com.wonders.wxyz.base.dao.GenericDAO#get(java.io.Serializable)
	 */
	public T get(PK id) {
		return (T) this.getHibernateTemplate().get(persistentClass, id);
	}

	/**
	 * Overriding methods getAll
	 * 
	 * @see com.wonders.wxyz.base.dao.GenericDAO#getAll()
	 */
	public List getAll() {
		return this.getHibernateTemplate().find(
				"from " + persistentClass.getSimpleName() + " ");
	}

	/**
	 * Overriding methods getAll
	 * 
	 * @see com.wonders.wxyz.base.dao.GenericDAO#getAll(java.lang.String,
	 *      boolean)
	 */
	public List<T> getAll(String orderBy, boolean isAsc) {
		Assert.hasText(orderBy);
		if (isAsc)
			return getHibernateTemplate().findByCriteria(
					DetachedCriteria.forClass(persistentClass).addOrder(
							Order.asc(orderBy)));
		else
			return getHibernateTemplate().findByCriteria(
					DetachedCriteria.forClass(persistentClass).addOrder(
							Order.desc(orderBy)));
	}

	/**
	 * Overriding methods remove
	 * 
	 * @see com.wonders.wxyz.base.dao.GenericDAO#remove(java.io.Serializable)
	 */
	public void remove(PK id) {
		T object = get(id);
		this.getHibernateTemplate().delete(object);
	}

	/**
	 * Overriding methods remove
	 * 
	 * @see com.wonders.wxyz.base.dao.GenericDAO#remove(java.lang.Object)
	 */
	public void remove(T object) {
		this.getHibernateTemplate().delete(object);
	}

	/**
	 * Overriding methods save
	 * 
	 * @see com.wonders.wxyz.base.dao.GenericDAO#save(java.lang.Object)
	 */
	public T save(T object) {
		this.getHibernateTemplate().saveOrUpdate(object);
		return (T) object;
	}

	/**
	 * Getter 方法 persistentClass
	 * 
	 * @return the persistentClass
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * Setter 方法 persistentClass
	 * 
	 * @param persistentClass
	 *            the persistentClass to set
	 */
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * Overriding methods findByHQLWithPage
	 * 
	 * @see com.wonders.wxyz.base.dao.GenericDAO#findByHQLWithPage(org.hibernate.Criteria,
	 *      int[])
	 */
	public Page findByHQLWithPage(Criteria criteria, int pageNo, int pageSize) {
		Assert.notNull(criteria);
		Assert.isTrue(pageNo >= 1, "pageNo should start from 1");
		if (pageNo < 1)
			pageNo = 1;
		int startIndex = Page.getStartOfAnyPage(pageNo, pageSize);
		int totalCount = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		List list = criteria.setFirstResult(startIndex - 1)
				.setMaxResults(pageSize).list();
		int avaCount = list != null ? list.size() : 0;
		return new Page(startIndex, avaCount, totalCount, pageSize, list);
	}

	/**
	 * 
	 * Overriding methods findByHQLWithPage
	 * 
	 * @see com.wonders.wxyz.base.dao.GenericDAO#findByHQLWithPage(java.lang.String,
	 *      java.util.Map, int, int)
	 */
	public Page findByHQLWithPage(String hql, Map<String, Object> args,
			int pageNo, int pageSize) {
		Page page = new Page();
			Assert.notNull(hql);
			String countHql = " select count (*) "
					+ removeSelect(removeOrders(hql));
			int totalCount = countByHql(countHql, args);
			if (totalCount < 1)
				return new Page();
			Query query = setQueryParameters(hql, args);
			if (pageNo < 1)
				pageNo = 1;
			int startIndex = Page.getStartOfAnyPage(pageNo, pageSize);
			List list = query.setFirstResult(startIndex - 1)
					.setMaxResults(pageSize).list();
			page.setData(list);
			page.setPageSize(pageSize);
			page.setTotalCount(totalCount);
			page.setStart(startIndex);
		return page;
	}

	public Page findByHQLWithPage2(String hql, Map<String, Object> args,
			int pageNo, int pageSize) {
		Assert.notNull(hql);
		Page page = new Page();
		// String countHql = " select count (*) " +
		// removeSelect(removeOrders(hql));
		// int totalCount = countByHql(countHql, args);
		// if (totalCount < 1)
		// return new Page();
		Query query = setQueryParameters(hql, args);
		if (pageNo < 1)
			pageNo = 1;
		int startIndex = Page.getStartOfAnyPage(pageNo, pageSize);

		List list = query.setFirstResult(startIndex - 1)
				.setMaxResults(pageSize).list();
		page.setData(list);
		page.setPageSize(pageSize);
		// page.setTotalCount(totalCount);
		page.setStart(startIndex);
		return page;
	}

	/**
	 * 
	 * countByHql方法
	 * 
	 * <p>
	 * 返回对应的记录数
	 * </p>
	 * 
	 * @param hql
	 * @param parameterMap
	 * @return
	 * @since 0.0.0.0
	 */
	public int countByHql(final String hql,
			final Map<String, Object> parameterMap) {
		return ((Long) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					{
				Query query = setQueryParameters(hql, parameterMap);
				return query.uniqueResult();
				// return Integer.parseInt(query.list().get(0).toString());
			}
		})).intValue();
	}

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
	public Query setQueryParameters(String hql, Map<String, Object> parameterMap) {
		Query query = getSession().createQuery(hql);
		if (null != parameterMap && parameterMap.size() > 0) {
			Iterator iter = parameterMap.keySet().iterator();
			while (iter.hasNext()) {
				String key = (String) iter.next();
				Object value = parameterMap.get(key);
				if (value == null) {
					throw new RuntimeException("HQL binding parameter:" + key
							+ ", its value is null!! Value CAN'T be null");
				}
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}
		return query;

	}

	
	
	/**
	 * 
	 * setSQLQueryParameters方法
	 * 
	 * <p>
	 * setSQLQueryParameters方法描述
	 * </p>
	 * 
	 * @param sql
	 * @param parameterMap
	 * @return
	 * @since 0.0.0.0
	 */
	public Query setSQLQueryParameters(String sql, Map<String, Object> parameterMap) {
		Query query = getSession().createSQLQuery(sql);
		if (null != parameterMap && parameterMap.size() > 0) {
			Iterator iter = parameterMap.keySet().iterator();
			while (iter.hasNext()) {
				String key = (String) iter.next();
				Object value = parameterMap.get(key);
				if (value == null) {
					throw new RuntimeException("HQL binding parameter:" + key
							+ ", its value is null!! Value CAN'T be null");
				}
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}
		return query;

	}
	public Query setSQLQueryParameters(String sql, Object[] value){
		Query query = getSession().createSQLQuery(sql);
		if (value != null) {
			for (int i = 0; i < value.length; i++) {
				query.setParameter(i, value[i]);
			}
		}
		return query;

	}

	/**
	 * 以SQL方式查询
	 * 
	 * @param hql
	 * @param args
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page findByHQLWithPageOfSQL(String queryString,
			Map<String, Object> args, int pageNo, int pageSize) {
		Assert.notNull(queryString);
		Page page = new Page();
		String countHql = " select count(*) "
				+ removeSelect(removeOrders(queryString));
		int totalCount = countByHqlOfSQL(countHql, args);
		if (totalCount < 1)
			return new Page();
		Query query = setQueryParametersOfSQL(queryString, args);
		if (pageNo < 1)
			pageNo = 1;
		int startIndex = Page.getStartOfAnyPage(pageNo, pageSize);

		List list = query.setFirstResult(startIndex - 1)
				.setMaxResults(pageSize).list();
		page.setData(list);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setStart(startIndex);
		return page;
	}

	/**
	 * 以SQL方式查询
	 * 
	 * @param hql
	 * @param parameterMap
	 * @return
	 */
	public int countByHqlOfSQL(final String hql,
			final Map<String, Object> parameterMap) {
		return ((BigDecimal) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = setQueryParametersOfSQL(hql, parameterMap);
						return query.uniqueResult();
					}
				})).intValue();
	}

	/**
	 * 
	 * setQueryParametersOfSQL方法
	 * 
	 * <p>
	 * setQueryParametersOfSQL方法描述
	 * </p>
	 * 
	 * @param hql
	 * @param parameterMap
	 * @return
	 * @since 0.0.0.0
	 */
	public Query setQueryParametersOfSQL(String queryString,
			Map<String, Object> parameterMap) {
		Query query = getSession().createSQLQuery(queryString);
		if (null != parameterMap && parameterMap.size() > 0) {
			Iterator iter = parameterMap.keySet().iterator();
			while (iter.hasNext()) {
				String key = (String) iter.next();
				Object value = parameterMap.get(key);
				if (value == null) {
					throw new RuntimeException("SQL binding parameter:" + key
							+ ", its value is null!! Value CAN'T be null");
				}
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}
		return query;
	}

	/**
	 * 
	 * flush方法
	 * 
	 * <p>
	 * flush方法描述
	 * </p>
	 * 
	 * @since 0.0.0.0
	 */
	public void flush() {
		getHibernateTemplate().flush();
	}

	/**
	 * 
	 * clear方法
	 * 
	 * <p>
	 * clear方法描述
	 * </p>
	 * 
	 * @since 0.0.0.0
	 */
	public void clear() {
		getHibernateTemplate().clear();
	}

	/**
	 * 去除hql的select 子句，未考虑union的情况,用于pagedQuery.
	 * 
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql
				+ " must has a keyword 'from'");
		return hql.substring(beginPos);
	}

	/**
	 * 去除hql的orderby 子句，用于pagedQuery.
	 * 
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	
	/**
	 * 
	 * Overriding methods findByHQLWithPageOnFecth
	 * 
	 * @see com.wonders.wxyz.base.dao.GenericDAO#findByHQLWithPage(java.lang.String,
	 *      java.util.Map, int, int)
	 */
	public Page findByHQLWithPageOnFecth(String hql, Map<String, Object> args, int pageNo, int pageSize) {
		Assert.notNull(hql);
		Page page = new Page();
		String countHql =  removeSelect(removeOrders(hql));
		Query countQuery = setQueryParameters(countHql, args);
		int totalCount = countQuery.list().size();
		if (totalCount < 1)
			return new Page();
		Query query = setQueryParameters(hql, args);
		if (pageNo < 1)
			pageNo = 1;
		int startIndex = Page.getStartOfAnyPage(pageNo, pageSize);

		List list = query.setFirstResult(startIndex - 1).setMaxResults(pageSize).list();
		page.setData(list);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setStart(startIndex);
		return page;
	}

	/**
	 * Getter 方法 sessionFactoryProject
	 * 
	 * @return the sessionFactoryProject
	 */
	public SessionFactory getSessionFactoryProject() {
		return sessionFactoryProject;
	}

	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}


	/**
	 * 
	 * @方法名称: findBySql
	 * @功能描述:执行sql查询
	 * @作者:刘强
	 * @创建时间:2015-12-30 下午3:24:31
	 * @param sql
	 * @param parameterMap
	 * @return
	 * @see com.common.dao.GenericDAO#findBySql(java.lang.String, java.util.Map)
	 */
	@Override
	public List findBySql(String sql,Map<String, Object> parameterMap) {
		Assert.hasText(sql);
		Query q = setSQLQueryParameters(sql,parameterMap);
		return q.list();
	}
	public List findBySql(String sql,Object[] value) {
		Assert.hasText(sql);
		Query q = setSQLQueryParameters(sql,value);
		return q.list();
	}



	@Override
	public Query setQueryParametersOfSQL(String queryString,
			Map<String, Object> parameterMap, Class<T> t) {
		Query query = getSession().createSQLQuery(queryString).addEntity(t);
		if (null != parameterMap && parameterMap.size() > 0) {
			Iterator iter = parameterMap.keySet().iterator();
			while (iter.hasNext()) {
				String key = (String) iter.next();
				Object value = parameterMap.get(key);
				if (value == null) {
					throw new RuntimeException("SQL binding parameter:" + key
							+ ", its value is null!! Value CAN'T be null");
				}
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}
		return query;
	}
	
	/**
	 * 以SQL方式查询
	 * 
	 * @param hql
	 * @param args
	 * @param pageNo
	 * @param pageSize
	 * @param classname
	 * @return
	 */
	public Page findByHQLWithPageOfSQL(String queryString,
			Map<String, Object> args, int pageNo, int pageSize,Class<T> t) {
		Assert.notNull(queryString);
		Page page = new Page();
		String countHql = " select count(*) "
				+ removeSelect(removeOrders(queryString));
		int totalCount = countByHqlOfSQL(countHql, args);
		if (totalCount < 1)
			return new Page();
		Query query = setQueryParametersOfSQL(queryString, args , t);
		if (pageNo < 1)
			pageNo = 1;
		int startIndex = Page.getStartOfAnyPage(pageNo, pageSize);

		List list = query.setFirstResult(startIndex - 1)
				.setMaxResults(pageSize).list();
		page.setData(list);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setStart(startIndex);
		return page;
	}
	
	/**
	 * 
	 * @方法名称: findByHql
	 * @功能描述: hql分页
	 * @作者:魏兆鹏
	 * @创建时间:2015-12-23 下午2:17:11
	 * @param hql
	 * @param ob
	 * @return
	 * @see com.common.dao.GenericDAO#findByHql(java.lang.String, java.lang.Object[])
	 */
	public Page findByHql(String hql, Object[]ob) {
		// TODO Auto-generated method stub
		Assert.notNull(hql);
		Page page = new Page();
		List list  =  this.getHibernateTemplate().find(hql, ob);
		page.setData(list);
		return page;
	}
	
	

}
