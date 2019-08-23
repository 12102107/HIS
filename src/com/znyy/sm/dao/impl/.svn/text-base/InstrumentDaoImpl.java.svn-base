/**  
 * @Title: InstrumentDaoImpl.java
 * @Package com.znyy.sm.dao.impl
 * @Description: TODO
 * @author 白东旭
 * @date 2016年8月2日
 */
package com.znyy.sm.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.dao.GenericDaoImpl;
import com.common.util.Page;
import com.znyy.bean.SmInstrument;
import com.znyy.bean.SmInstrumentCheck;
import com.znyy.bean.SmInstrumentPackage;
import com.znyy.bean.SmInstrumentPackageItem;
import com.znyy.sm.dao.InstrumentDao;

/**
 * ClassName: InstrumentDaoImpl 
 * @Description: TODO
 * @author 白东旭
 * @date 2016年8月2日
 */
public class InstrumentDaoImpl extends GenericDaoImpl<SmInstrument, String> implements
		InstrumentDao {

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getInstrumentList(java.lang.String, java.lang.String, int, java.lang.Integer)
	 */
	@Override
	public Page getInstrumentList(String name, String common, int parmpage,
			Integer pageSize) {
		String hql = "from SmInstrument where enable='0' ";
		Map<String,Object> m = new HashMap<String,Object>();
		if(name!=null&&!name.trim().equals("")) {
			hql += "and name like :name ";
			m.put("name", "%"+name.trim()+"%");
		}
		if(common!=null&&!common.equals("")) {
			hql += "and common = :common ";
			m.put("common", common);
		}
		return this.findByHQLWithPage(hql, m, parmpage, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#saveInstrument(com.znyy.bean.SmInstrument)
	 */
	@Override
	public void saveInstrument(SmInstrument i) {
		this.save(i);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getInstrumentById(java.lang.String)
	 */
	@Override
	public SmInstrument getInstrumentById(String id) {
		return this.get(id);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#delInstrument(com.znyy.bean.SmInstrument)
	 */
	@Override
	public void delInstrument(SmInstrument i) {
		this.getHibernateTemplate().delete(i);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getInstrumentPackageList(java.lang.String, java.lang.String, int, java.lang.Integer)
	 */
	@Override
	public Page getInstrumentPackageList(String name, String common,
			int parmpage, Integer pageSize) {
		String hql = "from SmInstrumentPackage where enable='0' ";
		Map<String,Object> m = new HashMap<String,Object>();
		if(name!=null&&!name.trim().equals("")) {
			hql += "and name like :name ";
			m.put("name", "%"+name.trim()+"%");
		}
		if(common!=null&&!common.equals("")) {
			hql += "and common = :common ";
			m.put("common", common);
		}
		return this.findByHQLWithPage(hql, m, parmpage, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getInstrumentList()
	 */
	@Override
	public List<SmInstrument> getInstrumentList() {
		String hql = "from SmInstrument where enable='0' ";
		return this.getHibernateTemplate().find(hql);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#saveInstrumentPackage(com.znyy.bean.SmInstrumentPackage)
	 */
	@Override
	public void saveInstrumentPackage(SmInstrumentPackage p) {
		this.getHibernateTemplate().save(p);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#saveInstrumentPackageItem(com.znyy.bean.SmInstrumentPackageItem)
	 */
	@Override
	public void saveInstrumentPackageItem(SmInstrumentPackageItem item) {
		this.getHibernateTemplate().save(item);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getInstrumentPackageById(java.lang.String)
	 */
	@Override
	public SmInstrumentPackage getInstrumentPackageById(String id) {
		return this.getHibernateTemplate().get(SmInstrumentPackage.class, id);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getPackageItemList(java.lang.String)
	 */
	@Override
	public List<SmInstrumentPackageItem> getPackageItemList(String id) {
		String hql = " from SmInstrumentPackageItem where packageId.id=? and enable='0'";
		return this.getHibernateTemplate().find(hql,id);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#delPackageItem(com.znyy.bean.SmInstrumentPackageItem)
	 */
	@Override
	public void delPackageItem(SmInstrumentPackageItem item) {
		this.getHibernateTemplate().delete(item);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getInstrumentPackage()
	 */
	@Override
	public List<Map<String, Object>> getInstrumentPackage() {
		String sql = "select id,name from Sm_Instrument_Package where enable='0'";
		List list = this.findBySql(sql, new HashMap<String,Object>());
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for(Object obj:list) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", o[0]);
			map.put("name", o[1]);
			result.add(map);
		} 
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#saveInstrumentCheck(com.znyy.bean.SmInstrumentCheck)
	 */
	@Override
	public void saveInstrumentCheck(SmInstrumentCheck check) {
		this.getHibernateTemplate().save(check);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getInstrumentCheckList(java.lang.String)
	 */
	@Override
	public List<SmInstrumentCheck> getInstrumentCheckList(String id) {
		return this.getHibernateTemplate().find("from SmInstrumentCheck where operationId.id=?",id);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#delInstrumentCheck(com.znyy.bean.SmInstrumentCheck)
	 */
	@Override
	public void delInstrumentCheck(SmInstrumentCheck check) {
		this.getHibernateTemplate().delete(check);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getInstrumentCheckPackage(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getInstrumentCheckPackage(String id) {
		String sql = "select p.id,c.operation_before,p.name from SM_INSTRUMENT_CHECK c left join SM_INSTRUMENT_PACKAGE p on c.INSTRUMENT_ID=p.id where c.type='1' and c.OPERATION_ID=:id";
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("id", id);
		List list = this.findBySql(sql, m);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for(Object obj:list) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", o[0]);
			map.put("num", o[1]);
			map.put("name", o[2]);
			result.add(map);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getInstrumentCheckInstrument(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getInstrumentCheckInstrument(String id) {
		String sql = "select i.id,c.operation_before,i.name,i.unit,i.specifications from SM_INSTRUMENT_CHECK c left join SM_INSTRUMENT i on c.INSTRUMENT_ID=i.id where c.type='0' and c.OPERATION_ID=:id";
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("id", id);
		List list = this.findBySql(sql, m);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for(Object obj:list) {
			Object[] o = (Object[]) obj;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", o[0]);
			map.put("num", o[1]);
			map.put("name", o[2]);
			map.put("unit", o[3]);
			map.put("specifications", o[4]);
			result.add(map);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getSmInstrumentByNameSpecifications(java.lang.String, java.lang.String)
	 */
	@Override
	public SmInstrument getSmInstrumentByNameSpecifications(String name,
			String specifications) {
		String hql = "from SmInstrument where name=? and specifications=? and enable='0' ";
		List<SmInstrument> l = this.getHibernateTemplate().find(hql,new Object[]{name,specifications});
		if(l.isEmpty()) {
			return null;
		} 
		return l.get(0);
	}

	/* (non-Javadoc)
	 * @see com.znyy.sm.dao.InstrumentDao#getSmInstrumentPackageByName(java.lang.String)
	 */
	@Override
	public SmInstrumentPackage getSmInstrumentPackageByName(String name) {
		String hql = "from SmInstrumentPackage where name=? and enable='0' ";
		List<SmInstrumentPackage> l = this.getHibernateTemplate().find(hql,name);
		if(l.isEmpty()) {
			return null;
		} 
		return l.get(0);
	}

}
